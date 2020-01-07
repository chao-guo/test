package chao.other.model;

import java.io.Serializable;

public class SubscribeObj implements Serializable {

	private static final long serialVersionUID = 1L;
	private String collectionName;
	private String pointerCode;
	private String unTagCode;
	private String spaceSize = "1";
	private String space = "1";
	private String nodeId;
	private String measureCode;
	private String nodeCode;

	public String getTankCode() {
		return nodeCode;
	}

	public void setTankCode(String tankCode) {
		nodeCode = tankCode;
	}

	public String getCollectionName() {
		return collectionName;
	}

	public void setCollectionName(String collectionName) {
		this.collectionName = collectionName;
	}

	public String getPointerCode() {
		return pointerCode;
	}

	public void setPointerCode(String pointerCode) {
		this.pointerCode = pointerCode;
	}

	public String getUnTagCode() {
		return unTagCode;
	}

	public void setUnTagCode(String unTagCode) {
		this.unTagCode = unTagCode;
	}

	public String getSpaceSize() {
		return spaceSize;
	}

	public void setSpaceSize(String spaceSize) {
		this.spaceSize = spaceSize;
	}

	public String getSpace() {
		return space;
	}

	public void setSpace(String space) {
		this.space = space;
	}

	public String getNodeId() {
		return nodeId;
	}

	public void setNodeId(String nodeId) {
		this.nodeId = nodeId;
	}

	public String getMeasureCode() {
		return measureCode;
	}

	public void setMeasureCode(String measureCode) {
		this.measureCode = measureCode;
	}

}
