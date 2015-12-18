package th.co.thebluecode.nb.rest.resource;

import com.google.gson.Gson;
import com.thoughtworks.xstream.XStream;
import org.restlet.ext.json.JsonRepresentation;
import org.restlet.representation.Representation;
import org.restlet.representation.Variant;
import org.restlet.resource.ResourceException;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import th.co.thebluecode.nb.constant.ServiceConstant;
import th.co.thebluecode.nb.domain.PhoneCheck;
import th.co.thebluecode.nb.model.PhoneCheckM;
import th.co.thebluecode.nb.xstream.common.ImakeResultMessage;
import th.co.thebluecode.nb.xstream.common.Paging;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by imake on 18/12/2015.
 */
public class NumberingResource extends BaseResource {
    // private static final Logger logger = Logger.getLogger(ServiceConstant.LOG_APPENDER);
    @Autowired
    @Qualifier("numberingServiceJpaImpl")
    private th.co.thebluecode.nb.service.NumberingService numberingService;

    @Autowired
    private com.thoughtworks.xstream.XStream xstream;
    @Autowired
    private com.thoughtworks.xstream.XStream jsonXstream;

    public NumberingResource() {
        super();
        logger.debug("into constructor TitleResource");
        // TODO Auto-generated constructor stub
    }

    @Override
    protected void doInit() throws ResourceException {
        // TODO Auto-generated method stub
        super.doInit();
        logger.debug("into doInit");
    }

    @Override
    protected Representation post(Representation entity, Variant variant)
            throws ResourceException {
        // TODO Auto-generated method stub
        logger.debug("into Post ConsultantReportResource 2");
        InputStream in = null;
        try {
            in = entity.getStream();
            Class[] classTypes = new Class[]{th.co.thebluecode.nb.xstream.common.ImakeResultMessage.class};
            jsonXstream.processAnnotations(classTypes);// or xstream.autodetectAnnotations(true); (Auto-detect  Annotations)
            th.co.thebluecode.nb.xstream.common.ImakeResultMessage imake =
                    new th.co.thebluecode.nb.xstream.common.ImakeResultMessage();
            th.co.thebluecode.nb.model.PhoneCheckM xsource = new th.co.thebluecode.nb.model.PhoneCheckM();
            Object xtarget = jsonXstream.fromXML(in);
            if (xtarget != null) {
                imake = (th.co.thebluecode.nb.xstream.common.ImakeResultMessage) xtarget;
                if (imake != null) {
                    BeanUtils.copyProperties(imake.getPhoneCheck(), xsource);
                    if (xsource.getServiceName() != null
                            && xsource.getServiceName().length() != 0) {
                        String serviceName = xsource.getServiceName();
                        if (serviceName.equals(ServiceConstant.LIST_NUMBER)) {

                            imake=numberingService.listNumber(xsource);

                            JsonRepresentation representation_aoe = null;
                            jsonXstream
                                    .processAnnotations(th.co.thebluecode.nb.xstream.common.ImakeResultMessage.class);// or
                            jsonXstream.autodetectAnnotations(true);
                            jsonXstream.setMode(XStream.NO_REFERENCES);
                            Gson gson = new Gson();
                            String jsonStr = gson.toJson(imake);
                            representation_aoe = new JsonRepresentation(jsonStr);
                            return representation_aoe;
                        }

                    } else {
                    }
                }

            }

        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } finally {
            logger.debug(" into Finally Call");
            try {
                if (in != null)
                    in.close();

            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return null;

    }
    @Override
    protected Representation get(Variant variant) throws ResourceException {
        // TODO Auto-generated method stub
        th.co.thebluecode.nb.xstream.common.ImakeResultMessage imake = new th.co.thebluecode.nb.xstream.common.ImakeResultMessage();
        th.co.thebluecode.nb.model.PhoneCheckM xsource = new th.co.thebluecode.nb.model.PhoneCheckM();
        xsource.setServiceName("xxx");
        List models = (List) numberingService.listNumber(xsource);
        imake.setResultListObj(models);
        imake.setPhoneCheck(xsource);
        JsonRepresentation representation_aoe = null;
        jsonXstream
                .processAnnotations(th.co.thebluecode.nb.xstream.common.ImakeResultMessage.class);// or
        jsonXstream.autodetectAnnotations(true);
        jsonXstream.setMode(XStream.NO_REFERENCES);
        Gson gson = new Gson();
        String jsonStr = gson.toJson(imake);
        System.out.println("json->" + jsonStr);
        //  String json = jsonXstream.toXML(imake);
        //System.out.println("json->"+json);

        representation_aoe = new JsonRepresentation(jsonStr);

        return representation_aoe;
       /*
        th.co.thebluecode.nb.xstream.common.ImakeResultMessage imake =new th.co.thebluecode.nb.xstream.common.ImakeResultMessage();
        imake.setServiceName("test");
        PhoneCheckM phoneCheck=new PhoneCheckM();
        phoneCheck.setProvider("ais");
        imake.setPhoneCheck(phoneCheck);
        JsonRepresentation representation_aoe = null;
        jsonXstream
                .processAnnotations(th.co.thebluecode.nb.xstream.common.ImakeResultMessage.class);// or
        jsonXstream.autodetectAnnotations(true);
        jsonXstream.setMode(XStream.NO_REFERENCES);

        Gson gson = new Gson();

        String jsonStr= gson.toJson(imake);
        System.out.println("json->" + jsonStr);
        representation_aoe = new JsonRepresentation(jsonStr);
        return representation_aoe;
         */
    }
}
