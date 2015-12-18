package th.co.thebluecode.nb.xstream.common;

import com.google.gson.annotations.SerializedName;
import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamImplicit;
import th.co.thebluecode.nb.model.PhoneCheckM;

import java.io.Serializable;
import java.util.List;

/**
 * @author Chatchai Pimtun 
 *
 */
@XStreamAlias("ImakeResultMessage")
public class ImakeResultMessage implements Serializable {

	private static final long serialVersionUID = 1L;
	private String serviceName;
	@XStreamAlias("imakeMessage")
	private ImakeMessage imakeMessage;

	@XStreamAlias("phoneCheck")
	private PhoneCheckM phoneCheck;

	@SuppressWarnings("rawtypes")
	@XStreamImplicit(itemFieldName="phones")
	@SerializedName("phones")
	private List resultListObj;
	
	@XStreamAlias("maxRow")
	private String maxRow;
	
	@XStreamAlias("lastpage")
	private String lastpage;
	
	@XStreamAlias("returnId")
	private String returnId;
	
	public String getReturnId() {
		return returnId;
	}
	public void setReturnId(String returnId) {
		this.returnId = returnId;
	}

	public ImakeMessage getImakeMessage() {
		return imakeMessage;
	}

	public void setImakeMessage(ImakeMessage imakeMessage) {
		this.imakeMessage = imakeMessage;
	}

	@SuppressWarnings("rawtypes")
	public List getResultListObj() {
		return resultListObj;
	}
	@SuppressWarnings("rawtypes")
	public void setResultListObj(List  resultListObj) {
		this.resultListObj = resultListObj;
	}
	public String getMaxRow() {
		return maxRow;
	}
	public void setMaxRow(String maxRow) {
		this.maxRow = maxRow;
	}
	public String getLastpage() {
		return lastpage;
	}
	public void setLastpage(String lastpage) {
		this.lastpage = lastpage;
	}

	public PhoneCheckM getPhoneCheck() {
		return phoneCheck;
	}

	public String getServiceName() {
		return serviceName;
	}

	public void setServiceName(String serviceName) {
		this.serviceName = serviceName;
	}

	public void setPhoneCheck(PhoneCheckM phoneCheck) {
		this.phoneCheck = phoneCheck;
	}
}
