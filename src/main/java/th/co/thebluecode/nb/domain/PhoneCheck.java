package th.co.thebluecode.nb.domain;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Collection;
import java.util.Date;

/**
 */
@Entity
@Table(name = "PHONE_CHECK", schema = "", catalog = "PHONE_DB")
public class PhoneCheck implements Serializable {
    @Id
    @Column(name = "PHONE_NUMBER")
    private String phoneNumber;

    @Basic
    @Column(name = "PROVIDER")
    private String provider;

    @Basic
    @Column(name = "STATUS")
    private String status;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "UPDATED_TIME")
    private Date updatedTime;

    @Basic
    @Column(name = "AIS_STATUS")
    private String aisStatus;

    @Basic
    @Column(name = "TRUE_STATUS")
    private String trueStatus;

    @Basic
    @Column(name = "DTAC_STATUS")
    private String dtacStatus;

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getProvider() {
        return provider;
    }

    public void setProvider(String provider) {
        this.provider = provider;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Date getUpdatedTime() {
        return updatedTime;
    }

    public void setUpdatedTime(Date updatedTime) {
        this.updatedTime = updatedTime;
    }

    public String getAisStatus() {
        return aisStatus;
    }

    public void setAisStatus(String aisStatus) {
        this.aisStatus = aisStatus;
    }

    public String getTrueStatus() {
        return trueStatus;
    }

    public void setTrueStatus(String trueStatus) {
        this.trueStatus = trueStatus;
    }

    public String getDtacStatus() {
        return dtacStatus;
    }

    public void setDtacStatus(String dtacStatus) {
        this.dtacStatus = dtacStatus;
    }
}
