package th.co.thebluecode.nb.repository;

import org.apache.log4j.Logger;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;
import th.co.thebluecode.nb.constant.ServiceConstant;
import th.co.thebluecode.nb.domain.PhoneCheck;
import th.co.thebluecode.nb.model.PhoneCheckM;
import th.co.thebluecode.nb.xstream.common.ImakeMessage;
import th.co.thebluecode.nb.xstream.common.ImakeResultMessage;

import javax.persistence.Column;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Repository("numberingRepository")
@Transactional
public class NumberingRepository {
    private static final Logger logger = Logger.getLogger(ServiceConstant.LOG_APPENDER);
    @Autowired
    @PersistenceContext(unitName = "HibernatePersistenceUnit")
    private EntityManager entityManager;
    public ImakeResultMessage listNumber(th.co.thebluecode.nb.model.PhoneCheckM phoneCheck) throws DataAccessException {
        ImakeResultMessage imakeResultMessage=new ImakeResultMessage();
        ImakeMessage imake =new ImakeMessage();
        List<PhoneCheckM> results_list = new ArrayList<PhoneCheckM>(0);
        try {
            StringBuffer sb = new StringBuffer(" select p from PhoneCheck p  where ( p.status='N' or p.status is null ) ");
            String providerChecker = phoneCheck.getProviderChecker();

            if (providerChecker != null) {
                String checker = "";
                switch (providerChecker) {
                    case "AIS":
                        checker = " ( p.aisStatus!='1' or p.aisStatus is null )";
                        break;
                    case "TRUE":
                        checker = " ( p.trueStatus!='1' or p.trueStatus is null )";
                        break;
                    case "DTAC":
                        checker = " ( p.dtacStatus!='1' or p.dtacStatus is null )";
                        break;
                    default:
                        break;
                }
                sb.append(" and " + checker);
            }
            Query query = entityManager.createQuery(sb.toString(), PhoneCheck.class);
            query.setMaxResults(3);
            List<PhoneCheck> results = query.getResultList();
             results_list = new ArrayList<PhoneCheckM>(results.size());
            for (PhoneCheck phone : results) {
                PhoneCheckM phoneCheckM = new PhoneCheckM();
                BeanUtils.copyProperties(phone, phoneCheckM);
                phoneCheckM.setPaging(null);
                results_list.add(phoneCheckM);

                sb.setLength(0);
                sb.append(" update  PhoneCheck p set p.status='P' where p.phoneNumber=:phoneNumber ");
                query = entityManager.createQuery(sb.toString());
                query.setParameter("phoneNumber", phone.getPhoneNumber());
                query.executeUpdate();
            }
            imake.setMsgCode("1");
            imake.setMsgDesc("Ok");
        }catch (Exception ex){
            imake.setMsgCode("0");
            imake.setException(ex);
            imake.setMsgDesc("Error");
        }
        imakeResultMessage.setImakeMessage(imake);
        imakeResultMessage.setResultListObj(results_list);
        return imakeResultMessage;
    }
    public ImakeMessage updateNumber(List<PhoneCheckM> phoneChecks)throws DataAccessException{
        StringBuffer sb = new StringBuffer(" ");
        ImakeMessage imake =new ImakeMessage();
        try {
            java.sql.Timestamp updatedDate = new java.sql.Timestamp(new Date().getTime());
            Query query = null;
            for(PhoneCheckM phoneCheck:phoneChecks){
                sb.setLength(0);
                String providerChecker=phoneCheck.getProviderChecker();
                String checker="";
                switch (providerChecker){
                    case "AIS":
                        checker=" p.aisStatus='1' ";
                        break;
                    case "TRUE":
                        checker=" p.trueStatus='1' ";
                        break;
                    case "DTAC":
                        checker=" p.dtacStatus='1' ";
                        break;
                    default:
                        break;
                }
                if(phoneCheck.getProvider()!=null && phoneCheck.getProvider().trim().length()>0) {
                    sb.append("update PhoneCheck p set p.provider=:provider , p.status='S' , p.updatedTime=:updatedTime ," + checker+
                            " where p.phoneNumber=:phoneNumber ");
                    query = entityManager.createQuery(sb.toString());
                    query.setParameter("provider", phoneCheck.getProvider());
                    query.setParameter("updatedTime", updatedDate);
                    query.setParameter("phoneNumber", phoneCheck.getPhoneNumber());
                    query.executeUpdate();
                }else{ // not found
                    sb.append("update PhoneCheck p set p.status='N' , p.updatedTime=:updatedTime ," + checker+
                            " where p.phoneNumber=:phoneNumber ");
                    query = entityManager.createQuery(sb.toString());
                    query.setParameter("updatedTime", updatedDate);
                    query.setParameter("phoneNumber", phoneCheck.getPhoneNumber());
                    query.executeUpdate();

                    // check Other
                    PhoneCheck phoneOther= entityManager.find(PhoneCheck.class,phoneCheck.getPhoneNumber());
                    if(phoneOther.getAisStatus()!=null && phoneOther.getAisStatus().trim().equals("1")
                                && phoneOther.getTrueStatus()!=null && phoneOther.getTrueStatus().trim().equals("1")
                                && phoneOther.getDtacStatus()!=null && phoneOther.getDtacStatus().trim().equals("1")){
                        phoneOther.setProvider("Other");
                        phoneOther.setStatus("S");
                        entityManager.merge(phoneOther);
                    }
                }



            }

            imake.setMsgCode("1");
            imake.setMsgDesc("Ok");
        }catch (Exception ex){
            imake.setMsgCode("0");
            imake.setException(ex);
            imake.setMsgDesc("Error");

        }
        return imake;
    }

}
