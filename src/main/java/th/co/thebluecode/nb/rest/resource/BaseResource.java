package th.co.thebluecode.nb.rest.resource;

import org.apache.log4j.Logger;
import org.restlet.data.MediaType;
import org.restlet.ext.xml.DomRepresentation;
import org.restlet.representation.Representation;
import org.restlet.representation.Variant;
import org.restlet.resource.ResourceException;
import org.restlet.resource.ServerResource;
import org.w3c.dom.Document;
import org.xml.sax.SAXException;
import th.co.thebluecode.nb.constant.ServiceConstant;
import th.co.thebluecode.nb.xstream.common.ImakeResultMessage;

import javax.xml.parsers.ParserConfigurationException;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;


/**
 * @author Chatchai Pimtun
 */
public abstract class BaseResource extends ServerResource {
    protected static final Logger logger = Logger.getLogger(ServiceConstant.LOG_APPENDER);
    protected static final String DATE_FORMAT = "yyyy-MM-dd";
    protected String HOST = "";
    protected String PATH_REF = "";

    @Override
    protected void doInit() throws ResourceException {
        // TODO Auto-generated method stub
        super.doInit();
        // get host
        HOST = getRequest().getProtocol().toString().toLowerCase() + "://"
                + getRequest().getResourceRef().getHostDomain() + ":"
                + getRequest().getResourceRef().getHostPort();
        // get ResourceRef
        PATH_REF = getRequest().getResourceRef().getPath();
    }

    public BaseResource() {
        super();
        logger.debug("into constructor BaseResource");
        getVariants().add(new Variant(MediaType.TEXT_XML));
        getVariants().add(new Variant(MediaType.APPLICATION_ATOM));
        getVariants().add(new Variant(MediaType.APPLICATION_ALL_XML));
        // TODO Auto-generated constructor stub
    }

    public void export(Representation entity, ImakeResultMessage vresultMessage,
                       com.thoughtworks.xstream.XStream xstream) {

        // TODO Auto-generated method stub
        logger.debug("into Post FAQs");
        DomRepresentation representation_aoe = null;

        javax.xml.parsers.DocumentBuilderFactory dbf = javax.xml.parsers.DocumentBuilderFactory
                .newInstance();
        dbf.setNamespaceAware(true);
        javax.xml.parsers.DocumentBuilder db = null;
        try {
            db = dbf.newDocumentBuilder();
        } catch (ParserConfigurationException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        xstream
                .processAnnotations(ImakeResultMessage.class);// or
        xstream.autodetectAnnotations(true);
        String xml = xstream.toXML(vresultMessage);
        Document document = null;
        InputStream in = null;
        try {
            in = new ByteArrayInputStream(xml.getBytes("UTF-8"));
            document = db.parse(in);
        } catch (UnsupportedEncodingException e2) {
            // TODO Auto-generated catch block
            logger.error("error UnsupportedEncodingException xml=" + xml);
            e2.printStackTrace();
        } catch (SAXException e) {
            // TODO Auto-generated catch block
            logger.error("error SAXException xml=" + xml);
            e.printStackTrace();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            logger.error("error IOException xml=" + xml);
            e.printStackTrace();
        } finally {
            if (in != null)
                try {
                    in.close();
                } catch (IOException e) {
                    // TODO Auto-generated catch block
                    logger.error("xml=" + xml);
                    e.printStackTrace();
                }
        }

        document.normalizeDocument();
        try {
            representation_aoe = new DomRepresentation(
                    MediaType.TEXT_XML);
            //	MediaType.APPLICATION_ATOM_XML);
        } catch (IOException e) {
            // TODO Auto-generated catch block
            logger.error("xml=" + xml);
            e.printStackTrace();

        }

        representation_aoe.setDocument(document);
        getResponse().setEntity(representation_aoe);
    }

    public Representation getRepresentation(Representation entity, ImakeResultMessage vresultMessage,
                                            com.thoughtworks.xstream.XStream xstream) {

        // TODO Auto-generated method stub
        logger.debug("into Post FAQs");
        DomRepresentation representation_aoe = null;

        javax.xml.parsers.DocumentBuilderFactory dbf = javax.xml.parsers.DocumentBuilderFactory
                .newInstance();
        dbf.setNamespaceAware(true);
        javax.xml.parsers.DocumentBuilder db = null;
        try {
            db = dbf.newDocumentBuilder();
        } catch (ParserConfigurationException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        xstream
                .processAnnotations(ImakeResultMessage.class);// or
        xstream.autodetectAnnotations(true);
        String xml = xstream.toXML(vresultMessage);
        Document document = null;
        InputStream in = null;
        try {
            in = new ByteArrayInputStream(xml.getBytes("UTF-8"));
            document = db.parse(in);
        } catch (UnsupportedEncodingException e2) {
            // TODO Auto-generated catch block
            logger.error("error UnsupportedEncodingException xml=" + xml);
            e2.printStackTrace();
        } catch (SAXException e) {
            // TODO Auto-generated catch block
            logger.error("error SAXException xml=" + xml);
            e.printStackTrace();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            logger.error("error IOException xml=" + xml);
            e.printStackTrace();
        } finally {
            if (in != null)
                try {
                    in.close();
                } catch (IOException e) {
                    // TODO Auto-generated catch block
                    logger.error("xml=" + xml);
                    e.printStackTrace();
                }
        }
        document.normalizeDocument();
        try {
            representation_aoe = new DomRepresentation(
                    MediaType.TEXT_XML);
        } catch (IOException e) {
            // TODO Auto-generated catch block
            logger.error("xml=" + xml);
            e.printStackTrace();

        }
        representation_aoe.setDocument(document);
        return representation_aoe;
    }
}
