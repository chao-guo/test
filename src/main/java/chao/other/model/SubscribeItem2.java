package chao.other.model;

import java.io.Serializable;


public class SubscribeItem2 extends BaseModel implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Long subscribeItemId;
	
	private String subscribeCode;
	
	private Integer durationType;
	
	private Integer valueMode;
	
	private Integer offSet;
	
	private String dataSourceCode;
	
	private String subscribeObj;

	public Long getSubscribeItemId() {
		return subscribeItemId;
	}

	public void setSubscribeItemId(Long subscribeItemId) {
		this.subscribeItemId = subscribeItemId;
	}

	public String getSubscribeCode() {
		return subscribeCode;
	}

	public void setSubscribeCode(String subscribeCode) {
		this.subscribeCode = subscribeCode;
	}

	public Integer getDurationType() {
		return durationType;
	}

	public void setDurationType(Integer durationType) {
		this.durationType = durationType;
	}

	public Integer getValueMode() {
		return valueMode;
	}

	public void setValueMode(Integer valueMode) {
		this.valueMode = valueMode;
	}

	public Integer getOffSet() {
		return offSet;
	}

	public void setOffSet(Integer offSet) {
		this.offSet = offSet;
	}

	public String getDataSourceCode() {
		return dataSourceCode;
	}

	public void setDataSourceCode(String dataSourceCode) {
		this.dataSourceCode = dataSourceCode;
	}

	public String getSubscribeObj() {
		return subscribeObj;
	}

	public void setSubscribeObj(String subscribeObj) {
		this.subscribeObj = subscribeObj;
	}
	
	
}
