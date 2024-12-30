package com.ccf.feige.orderfood.bean;

import java.io.Serializable;

public class UserBean implements Serializable {

    @Override
    public String toString() {
        return "UserBean{" +
                "sId='" + sId + '\'' +
                ", sPwd='" + sPwd + '\'' +
                ", sName='" + sName + '\'' +
                ", sDescribe='" + sDescribe + '\'' +
                ", sType='" + sType + '\'' +
                ", sImg='" + sImg + '\'' +
                '}';
    }

    public String getsId() {
        return sId;
    }

    public void setsId(String sId) {
        this.sId = sId;
    }

    public String getsPwd() {
        return sPwd;
    }

    public void setsPwd(String sPwd) {
        this.sPwd = sPwd;
    }

    public String getsName() {
        return sName;
    }

    public void setsName(String sName) {
        this.sName = sName;
    }

    public String getsDescribe() {
        return sDescribe;
    }

    public void setsDescribe(String sDescribe) {
        this.sDescribe = sDescribe;
    }

    public String getsType() {
        return sType;
    }

    public void setsType(String sType) {
        this.sType = sType;
    }

    public String getsImg() {
        return sImg;
    }

    public void setsImg(String sImg) {
        this.sImg = sImg;
    }

    public UserBean(String sId, String sPwd, String sName, String sDescribe, String sType, String sImg) {
        this.sId = sId;
        this.sPwd = sPwd;
        this.sName = sName;
        this.sDescribe = sDescribe;
        this.sType = sType;
        this.sImg = sImg;
    }

    public UserBean() {
    }

    private String sId;
    private String sPwd;
    private String sName;
    private String sDescribe;
    private String sType;
    private String sImg;


}
