package th.co.thebluecode.nb.constant;

import java.util.ResourceBundle;

public class ServiceConstant {
    public static final String hostReference = "http://10.2.0.76:10000/BPSService/RestletServlet/";

    public static final String LOG_APPENDER = "CHARTServicesLog";

    public static final String INTERFACE_RETURN_TYPE = "java.util.List";
    public static final String VOID_RETURN_TYPE = "void";
    public static final String FLAG_INACTIVE = "0";
    public static final String FLAG_ACTIVE = "1";
    public static final String UPDATE_TYEP_FLAG = "flag";
    public static final String TAB_ALL = "all";
    public static final String TAB_MY_DATA = "myData";
    public static final int JOURNAL_PAPERS_TYPE_JOURNAL = 1;
    public static final int JOURNAL_PAPERS_TYPE_CONFERENCE = 2;
    public static final String[] FILTERS = {"0", "1", "2", "3"};
    public static final String[] DOCTYPES = {"PUBLISH", "DRAFT"};
    public static final String ERROR_MESSAGE_KEY = "errorMessage";
    public static final String SUCCESS_MESSAGE_KEY = "successMessage";
    public static final String WARNING_MESSAGE_KEY = "warningMessage";

    public static final String ERROR_CONSTRAINT_VIOLATION_MESSAGE_CODE = "error.constraintViolation";
    //public static final String SUCCESS_MESSAGE_CODE=".constraintViolation";
    /*public static  enum FILTER{
        SUNDAY, MONDAY, TUESDAY, WEDNESDAY,
	    THURSDAY, FRIDAY, SATURDAY 
	}*/
    public static final ResourceBundle bundle;
    public static String SCHEMA = "";

    static {
        bundle = ResourceBundle.getBundle("jdbc");
        SCHEMA = bundle.getString("schema");
    }



    //CHART
    public static final String LIST_NUMBER = "listNumber";
    public static final String UPDATE_NUMBER = "updateNumber";

}
