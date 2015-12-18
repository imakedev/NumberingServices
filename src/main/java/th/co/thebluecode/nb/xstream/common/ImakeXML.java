package th.co.thebluecode.nb.xstream.common;

import com.thoughtworks.xstream.annotations.XStreamAlias;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

/**
 * @author Chatchai Pimtun (Admin)
 *
 */
@XStreamAlias("ImakeXML")
public class ImakeXML implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@XStreamAlias("servicename")
	private String serviceName;
	private String updateType;	
	private String[] ids;
	private String tab;
	private String filter;
	private HashMap<String, String> docAssignMapping;
	private Boolean isdocAssign;
	public String getUpdateType() {
		return updateType;
	}
	public void setUpdateType(String updateType) {
		this.updateType = updateType;
	}
	private String userid;

	public String getUserid() {
		return userid;
	}
	public void setUserid(String userid) {
		this.userid = userid;
	}
	private String keySearch;
	public String getKeySearch() {
		return keySearch;
	}
	public void setKeySearch(String keySearch) {
		this.keySearch = keySearch;
	}

	@XStreamAlias("fieldId")
	private String fieldId;

	private Integer updateRecord;

	public String getFieldId() {
		return fieldId;
	}
	public void setFieldId(String fieldId) {
		this.fieldId = fieldId;
	}
	@SuppressWarnings("rawtypes")
	@XStreamAlias("likeExpression")
	private Map likeExpression;

	@SuppressWarnings("rawtypes")
	@XStreamAlias("likeFirstExpression")
	private Map likeFirstExpression;

	@SuppressWarnings("rawtypes")
	@XStreamAlias("likeEndExpression")
	private Map likeEndExpression;

	@SuppressWarnings("rawtypes")
	@XStreamAlias("leExpression")
	private Map leExpression;

	@SuppressWarnings("rawtypes")
	@XStreamAlias("geExpression")
	private Map geExpression;
	@SuppressWarnings("rawtypes")
	@XStreamAlias("neExpression")
	private Map neExpression;

	@XStreamAlias("paging")
	private Paging paging;


	public ImakeXML() {
		paging = new Paging();
		//vcriteria = new VCriteria();

	}

	public Paging getPaging() {
		return paging;
	}
	public void setPaging(Paging paging) {
		this.paging = paging;
	}
	public String getServiceName() {
		return serviceName;
	}
	public void setServiceName(String serviceName) {
		this.serviceName = serviceName;
	}
	@SuppressWarnings("rawtypes")
	public Map getLikeExpression() {
		return likeExpression;
	}
	@SuppressWarnings("rawtypes")
	public void setLikeExpression(Map likeExpression) {
		this.likeExpression = likeExpression;
	}
	@SuppressWarnings("rawtypes")
	public Map getLeExpression() {
		return leExpression;
	}
	@SuppressWarnings("rawtypes")
	public void setLeExpression(Map leExpression) {
		this.leExpression = leExpression;
	}
	@SuppressWarnings("rawtypes")
	public Map getGeExpression() {
		return geExpression;
	}
	@SuppressWarnings("rawtypes")
	public void setGeExpression(Map geExpression) {
		this.geExpression = geExpression;
	}
	@SuppressWarnings("rawtypes")
	public Map getLikeFirstExpression() {
		return likeFirstExpression;
	}
	@SuppressWarnings("rawtypes")
	public void setLikeFirstExpression(Map likeFirstExpression) {
		this.likeFirstExpression = likeFirstExpression;
	}
	@SuppressWarnings("rawtypes")
	public Map getLikeEndExpression() {
		return likeEndExpression;
	}
	@SuppressWarnings("rawtypes")
	public void setLikeEndExpression(Map likeEndExpression) {
		this.likeEndExpression = likeEndExpression;
	}
	@SuppressWarnings("rawtypes")
	public Map getNeExpression() {
		return neExpression;
	}
	@SuppressWarnings("rawtypes")
	public void setNeExpression(Map neExpression) {
		this.neExpression = neExpression;
	}
	public Integer getUpdateRecord() {
		return updateRecord;
	}

	public String[] getIds() {
		return ids;
	}

	public void setIds(String[] ids) {
		this.ids = ids;
	}

	public String getTab() {
		return tab;
	}

	public void setTab(String tab) {
		this.tab = tab;
	}

	public String getFilter() {
		return filter;
	}

	public void setFilter(String filter) {
		this.filter = filter;
	}

	public HashMap<String, String> getDocAssignMapping() {
		return docAssignMapping;
	}

	public void setDocAssignMapping(HashMap<String, String> docAssignMapping) {
		this.docAssignMapping = docAssignMapping;
	}

	public Boolean getIsdocAssign() {
		return isdocAssign;
	}

	public void setIsdocAssign(Boolean isdocAssign) {
		this.isdocAssign = isdocAssign;
	}

	public void setUpdateRecord(Integer updateRecord) {
		this.updateRecord = updateRecord;
	}
}
