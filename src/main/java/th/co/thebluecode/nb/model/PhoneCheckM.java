package th.co.thebluecode.nb.model;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import th.co.thebluecode.nb.xstream.common.ImakeXML;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;


@XStreamAlias("PhoneCheckM")
public class PhoneCheckM  extends ImakeXML implements Serializable {
    private String phoneNumber;
    private String provider;
    private String status;
    private Date updatedTime;
    private String aisStatus;
    private String trueStatus;
    private String dtacStatus;

    private String providerChecker;
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

    public String getProviderChecker() {
        return providerChecker;
    }

    public void setProviderChecker(String providerChecker) {
        this.providerChecker = providerChecker;
    }

    public void setDtacStatus(String dtacStatus) {
        this.dtacStatus = dtacStatus;
    }
}
