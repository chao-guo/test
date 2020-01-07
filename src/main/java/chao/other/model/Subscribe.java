package chao.other.model;

import pcitc.imp.common.ettool.baseresrep.BaseResRep;

import java.io.Serializable;

public class Subscribe extends BaseResRep implements Serializable {

	private static final long serialVersionUID = 1L;

	private Long subscribeId;

	private String subscribeCode;

	private String subscribeName;

	private String subscriberType;

	private String subscriberCode;

	private Integer durationType;

	private Long valueMode;

	private String shiftArea;

	private Long inUse;

	private Long pointerVal;

	private String items;

	public String getItems() {
		return items;
	}

	public void setItems(String items) {
		this.items = items;
	}

	public Long getSubscribeId() {
		return subscribeId;
	}

	public void setSubscribeId(Long subscribeId) {
		this.subscribeId = subscribeId;
	}

	public String getSubscribeCode() {
		return subscribeCode;
	}

	public void setSubscribeCode(String subscribeCode) {
		this.subscribeCode = subscribeCode;
	}

	public String getSubscribeName() {
		return subscribeName;
	}

	public void setSubscribeName(String subscribeName) {
		this.subscribeName = subscribeName;
	}

	public String getSubscriberType() {
		return subscriberType;
	}

	public void setSubscriberType(String subscriberType) {
		this.subscriberType = subscriberType;
	}

	public String getSubscriberCode() {
		return subscriberCode;
	}

	public void setSubscriberCode(String subscriberCode) {
		this.subscriberCode = subscriberCode;
	}

	public Integer getDurationType() {
		return durationType;
	}

	public void setDurationType(Integer durationType) {
		this.durationType = durationType;
	}

	public Long getValueMode() {
		return valueMode;
	}

	public void setValueMode(Long valueMode) {
		this.valueMode = valueMode;
	}

	public String getShiftArea() {
		return shiftArea;
	}

	public void setShiftArea(String shiftArea) {
		this.shiftArea = shiftArea;
	}

	public Long getInUse() {
		return inUse;
	}

	public void setInUse(Long inUse) {
		this.inUse = inUse;
	}

	public Long getPointerVal() {
		return pointerVal;
	}

	public void setPointerVal(Long pointerVal) {
		this.pointerVal = pointerVal;
	}

}
