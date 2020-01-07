package chao.other.model;

import pcitc.imp.common.ettool.baseresrep.BaseResRep;

import java.io.Serializable;

public class Measurement extends BaseResRep implements Serializable {

    private static final long serialVersionUID = 1L;

    private Long idxId;

    private String idxCode;

    private String idxName;

    private String idxAlias;

    private String idxTypeCode;

    private String idxTypeName;

    private String nodeCode;

    private String nodeName;

    private String nodeAlias;

    private String nodeTypeCode;

    private String areaCode;

    private String areaName;

    private String areaAlias;

    private String exchangeRate;

    private String dimensionCode;

    private String dimensionName;

    private String dimensionAlias;

    private String idxFormula;

    private String sourceDataType;

    private Integer inUse;

    private Integer sortNum;

    private String des;

    public Long getIdxId() {
        return idxId;
    }

    public void setIdxId(Long idxId) {
        this.idxId = idxId;
    }

    public String getIdxCode() {
        return idxCode;
    }

    public void setIdxCode(String idxCode) {
        this.idxCode = idxCode;
    }

    public String getIdxName() {
        return idxName;
    }

    public void setIdxName(String idxName) {
        this.idxName = idxName;
    }

    public String getIdxAlias() {
        return idxAlias;
    }

    public void setIdxAlias(String idxAlias) {
        this.idxAlias = idxAlias;
    }

    public String getIdxTypeCode() {
        return idxTypeCode;
    }

    public void setIdxTypeCode(String idxTypeCode) {
        this.idxTypeCode = idxTypeCode;
    }

    public String getIdxTypeName() {
        return idxTypeName;
    }

    public void setIdxTypeName(String idxTypeName) {
        this.idxTypeName = idxTypeName;
    }

    public String getNodeCode() {
        return nodeCode;
    }

    public void setNodeCode(String nodeCode) {
        this.nodeCode = nodeCode;
    }

    public String getNodeName() {
        return nodeName;
    }

    public void setNodeName(String nodeName) {
        this.nodeName = nodeName;
    }

    public String getNodeAlias() {
        return nodeAlias;
    }

    public void setNodeAlias(String nodeAlias) {
        this.nodeAlias = nodeAlias;
    }

    public String getNodeTypeCode() {
        return nodeTypeCode;
    }

    public void setNodeTypeCode(String nodeTypeCode) {
        this.nodeTypeCode = nodeTypeCode;
    }

    public String getAreaCode() {
        return areaCode;
    }

    public void setAreaCode(String areaCode) {
        this.areaCode = areaCode;
    }

    public String getAreaName() {
        return areaName;
    }

    public void setAreaName(String areaName) {
        this.areaName = areaName;
    }

    public String getAreaAlias() {
        return areaAlias;
    }

    public void setAreaAlias(String areaAlias) {
        this.areaAlias = areaAlias;
    }

    public String getExchangeRate() {
        return exchangeRate;
    }

    public void setExchangeRate(String exchangeRate) {
        this.exchangeRate = exchangeRate;
    }

    public String getDimensionCode() {
        return dimensionCode;
    }

    public void setDimensionCode(String dimensionCode) {
        this.dimensionCode = dimensionCode;
    }

    public String getDimensionName() {
        return dimensionName;
    }

    public void setDimensionName(String dimensionName) {
        this.dimensionName = dimensionName;
    }

    public String getDimensionAlias() {
        return dimensionAlias;
    }

    public void setDimensionAlias(String dimensionAlias) {
        this.dimensionAlias = dimensionAlias;
    }

    public String getIdxFormula() {
        return idxFormula;
    }

    public void setIdxFormula(String idxFormula) {
        this.idxFormula = idxFormula;
    }

    public String getSourceDataType() {
        return sourceDataType;
    }

    public void setSourceDataType(String sourceDataType) {
        this.sourceDataType = sourceDataType;
    }

    public Integer getInUse() {
        return inUse;
    }

    public void setInUse(Integer inUse) {
        this.inUse = inUse;
    }

    public Integer getSortNum() {
        return sortNum;
    }

    public void setSortNum(Integer sortNum) {
        this.sortNum = sortNum;
    }

    public String getDes() {
        return des;
    }

    public void setDes(String des) {
        this.des = des;
    }

}