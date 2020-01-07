package chao.other.model;

import pcitc.imp.common.ettool.Annotaion.ResourceMember;
import pcitc.imp.common.ettool.baseresrep.BaseResRep;

import java.io.Serializable;
import java.util.Date;

public class AgentDefine extends BaseResRep implements Serializable {

    private static final long serialVersionUID = 1L;
    private long agentletId;// id
    private String agentletCode;// Agent编码
    private String agentletName;// Agent名称
    private String typeCode;
    private String crtUser;// 创建人
    private Date createTime;// 创建时间
    private String mntUser;// 修改人
    private Date maintainTime;// 维护时间
    private Integer inUse;// 启用标识
    private String descs;// 说明
    @ResourceMember(InTemplate = false)
    private Integer sortNum;// 排序
    private String treeCode;// 工厂模型Code
    private String treeType;// 工厂模型类型
    @ResourceMember(InTemplate = false)
    private String valParam;// val参数--暂时没用
    private String arithmeticFormula;// 算法公式
    private Integer frequency;// 频率--主表
    private Long offset; // 偏移量--从表
    private String assemble;// Json数组
    @ResourceMember(InTemplate = false)
    private String dbNetOfOil;// --暂时没用
    @ResourceMember(InTemplate = false)
    private String dtDate;// --暂时没用
    private String obj;// 是否正常--暂时没用
    private String weight;
    private String levelOne;
    private String levelTwo;
    private String levelThree;
    private String orgCode;
    private Integer plantId;
    private String dicCode;


    public Integer getPlantId() {
        return plantId;
    }

    public void setPlantId(Integer plantId) {
        this.plantId = plantId;
    }

    public String getOrgCode() {
        return orgCode;
    }

    public void setOrgCode(String orgCode) {
        this.orgCode = orgCode;
    }

    public String getLevelOne() {
        return levelOne;
    }

    public void setLevelOne(String levelOne) {
        this.levelOne = levelOne;
    }

    public String getLevelTwo() {
        return levelTwo;
    }

    public void setLevelTwo(String levelTwo) {
        this.levelTwo = levelTwo;
    }

    public String getLevelThree() {
        return levelThree;
    }

    public void setLevelThree(String levelThree) {
        this.levelThree = levelThree;
    }

    private String workUrl;
    private String foreUrl;

    public String getWeight() {
        return weight;
    }

    public void setWeight(String weight) {
        this.weight = weight;
    }

    public Long getAgentletId() {
        return agentletId;
    }

    public void setAgentletId(long agentletId) {
        this.agentletId = agentletId;
    }

    public String getAgentletCode() {
        return agentletCode;
    }

    public void setAgentletCode(String agentletCode) {
        this.agentletCode = agentletCode;
    }

    public String getAgentletName() {
        return agentletName;
    }

    public void setAgentletName(String agentletName) {
        this.agentletName = agentletName;
    }

    public String getTypeCode() {
        return typeCode;
    }

    public void setTypeCode(String typeCode) {
        this.typeCode = typeCode;
    }

    public String getCrtUser() {
        return crtUser;
    }

    public void setCrtUser(String crtUser) {
        this.crtUser = crtUser;
    }

    public String getMntUser() {
        return mntUser;
    }

    public void setMntUser(String mntUser) {
        this.mntUser = mntUser;
    }

    public Integer getInUse() {
        return inUse;
    }

    public void setInUse(Integer inUse) {
        this.inUse = inUse;
    }

    public String getDescs() {
        return descs;
    }

    public void setDescs(String descs) {
        this.descs = descs;
    }

    public Integer getSortNum() {
        return sortNum;
    }

    public void setSortNum(Integer sortNum) {
        this.sortNum = sortNum;
    }

    public String getTreeCode() {
        return treeCode;
    }

    public void setTreeCode(String treeCode) {
        this.treeCode = treeCode;
    }

    public String getTreeType() {
        return treeType;
    }

    public void setTreeType(String treeType) {
        this.treeType = treeType;
    }

    public String getValParam() {
        return valParam;
    }

    public void setValParam(String valParam) {
        this.valParam = valParam;
    }

    public String getArithmeticFormula() {
        return arithmeticFormula;
    }

    public void setArithmeticFormula(String arithmeticFormula) {
        this.arithmeticFormula = arithmeticFormula;
    }

    public Integer getFrequency() {
        return frequency;
    }

    public void setFrequency(Integer frequency) {
        this.frequency = frequency;
    }

    public String getAssemble() {
        return assemble;
    }

    public void setAssemble(String assemble) {
        this.assemble = assemble;
    }

    public Long getOffset() {
        return offset;
    }

    public void setOffset(Long offset) {
        this.offset = offset;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getMaintainTime() {
        return maintainTime;
    }

    public void setMaintainTime(Date maintainTime) {
        this.maintainTime = maintainTime;
    }

    public String getDbNetOfOil() {
        return dbNetOfOil;
    }

    public void setDbNetOfOil(String dbNetOfOil) {
        this.dbNetOfOil = dbNetOfOil;
    }

    public String getDtDate() {
        return dtDate;
    }

    public void setDtDate(String dtDate) {
        this.dtDate = dtDate;
    }

    public String getObj() {
        return obj;
    }

    public void setObj(String obj) {
        this.obj = obj;
    }

    public String getDicCode() {
        return dicCode;
    }

    public void setDicCode(String dicCode) {
        this.dicCode = dicCode;
    }

    public String getWorkUrl() {
        return workUrl;
    }

    public void setWorkUrl(String workUrl) {
        this.workUrl = workUrl;
    }

    public String getForeUrl() {
        return foreUrl;
    }

    public void setForeUrl(String foreUrl) {
        this.foreUrl = foreUrl;
    }

}