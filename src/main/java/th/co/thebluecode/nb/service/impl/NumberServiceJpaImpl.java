package th.co.thebluecode.nb.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;
import th.co.thebluecode.nb.model.PhoneCheckM;
import th.co.thebluecode.nb.service.NumberingService;
import th.co.thebluecode.nb.xstream.common.ImakeMessage;
import th.co.thebluecode.nb.xstream.common.ImakeResultMessage;

import java.util.List;

@Service("numberingServiceJpaImpl")
public class NumberServiceJpaImpl implements NumberingService {


    @Autowired
    @Qualifier("numberingRepository")
    private th.co.thebluecode.nb.repository.NumberingRepository numberingRepository;

    public ImakeMessage updateNumber(List<PhoneCheckM> phoneChecks)throws DataAccessException{
       return numberingRepository.updateNumber(phoneChecks);
    }
    public ImakeResultMessage listNumber(PhoneCheckM phoneCheck) throws DataAccessException {
        return numberingRepository.listNumber(phoneCheck);
    }
}
