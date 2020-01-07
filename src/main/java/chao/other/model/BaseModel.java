package chao.other.model;

import pcitc.imp.common.ettool.baseresrep.BaseResRep;

import java.io.Serializable;
import java.util.Date;

/**
 * BaseModel
 *
 * @author sleep
 */
public abstract class BaseModel extends BaseResRep implements Serializable {
    private static final long serialVersionUID = 1L;

    /**
     * 创建人Id
     */
    private String crtUserId;
    /**
     * 创建人Name
     */
    private String crtUserName;
    /**
     * 创建时间
     */
    private Date crtDate;
    /**
     * 修改人Id
     */
    private String mntUserId;
    /**
     * 修改人Name
     */
    private String mntUserName;
    /**
     * 修改时间
     */
    private Date mntDate;

    /**
     * 是否启用
     */
    private Long inUse;

    /**
     * 备注
     */
    private String des;

    public String getCrtUserId() {
        return crtUserId;
    }

    public void setCrtUserId(String crtUserId) {
        this.crtUserId = crtUserId;
    }

    public String getCrtUserName() {
        return crtUserName;
    }

    public void setCrtUserName(String crtUserName) {
        this.crtUserName = crtUserName;
    }

    public Date getCrtDate() {
        return crtDate;
    }

    public void setCrtDate(Date crtDate) {
        this.crtDate = crtDate;
    }

    public String getMntUserId() {
        return mntUserId;
    }

    public void setMntUserId(String mntUserId) {
        this.mntUserId = mntUserId;
    }

    public String getMntUserName() {
        return mntUserName;
    }

    public void setMntUserName(String mntUserName) {
        this.mntUserName = mntUserName;
    }

    public Date getMntDate() {
        return mntDate;
    }

    public void setMntDate(Date mntDate) {
        this.mntDate = mntDate;
    }

    public Long getInUse() {
        return inUse;
    }

    public void setInUse(Long inUse) {
        this.inUse = inUse;
    }

    public String getDes() {
        return des;
    }

    public void setDes(String des) {
        this.des = des;
    }
}
