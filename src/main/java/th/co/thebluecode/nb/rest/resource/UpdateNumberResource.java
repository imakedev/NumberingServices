package th.co.thebluecode.nb.rest.resource;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.thoughtworks.xstream.XStream;
import org.restlet.ext.json.JsonRepresentation;
import org.restlet.representation.Representation;
import org.restlet.representation.Variant;
import org.restlet.resource.ResourceException;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import th.co.thebluecode.nb.constant.ServiceConstant;
import th.co.thebluecode.nb.model.PhoneCheckM;
import th.co.thebluecode.nb.xstream.common.ImakeMessage;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by imake on 18/12/2015.
 */
public class UpdateNumberResource extends BaseResource {
    // private static final Logger logger = Logger.getLogger(ServiceConstant.LOG_APPENDER);
    @Autowired
    @Qualifier("numberingServiceJpaImpl")
    private th.co.thebluecode.nb.service.NumberingService numberingService;

    @Autowired
    private com.thoughtworks.xstream.XStream xstream;
    @Autowired
    private com.thoughtworks.xstream.XStream jsonXstream;

    public UpdateNumberResource() {
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
          //  jsonXstream.processAnnotations((new ArrayList<th.co.thebluecode.nb.model.PhoneCheckM>).class);// or xstream.autodetectAnnotations(true); (Auto-detect  Annotations)
            List<th.co.thebluecode.nb.model.PhoneCheckM> xsources =
                    new ArrayList<th.co.thebluecode.nb.model.PhoneCheckM>();
            Gson gson =new Gson();
             BufferedReader reader = new BufferedReader(new InputStreamReader(in));
            xsources=  gson.fromJson(reader,new TypeToken<List<PhoneCheckM>>(){}.getType());
          //  Object xtarget = jsonXstream.fromXML(in);

                if (xsources != null) {
                    th.co.thebluecode.nb.xstream.common.ImakeResultMessage imake=
                            new th.co.thebluecode.nb.xstream.common.ImakeResultMessage();
                    System.out.println(xsources);
                    ImakeMessage message = numberingService.updateNumber(xsources);
                    JsonRepresentation representation_aoe = null;
                    jsonXstream
                            .processAnnotations(th.co.thebluecode.nb.xstream.common.ImakeResultMessage.class);// or
                    jsonXstream.autodetectAnnotations(true);
                    jsonXstream.setMode(XStream.NO_REFERENCES);
                     gson = new Gson();
                    imake.setImakeMessage(message);
                    String jsonStr = gson.toJson(imake);
                    System.out.println("json->" + jsonStr);
                    representation_aoe = new JsonRepresentation(jsonStr);
                    return representation_aoe;

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
}
