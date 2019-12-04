package com.ggman.photo.bean;

public class YsUser {
    private Integer wid ;
    private String name ;
    private String password;
    private String birth;
    private String phone;
    private String details;
    private Integer sign;

    public Integer getWid() {
        return wid;
    }

    public void setWid(Integer wid) {
        this.wid = wid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getBirth() {
        return birth;
    }

    public void setBirth(String birth) {
        this.birth = birth;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }

    public Integer getSign() {
        return sign;
    }

    public void setSign(Integer sign) {
        this.sign = sign;
    }

    public YsUser() {
    }

    public YsUser(Integer wid, String name, String password, String birth, String phone, String details, Integer sign) {
        this.wid = wid;
        this.name = name;
        this.password = password;
        this.birth = birth;
        this.phone = phone;
        this.details = details;
        this.sign = sign;
    }

    @Override
    public String toString() {
        return "YsUser{" +
                "wid=" + wid +
                ", name='" + name + '\'' +
                ", password='" + password + '\'' +
                ", birth='" + birth + '\'' +
                ", phone='" + phone + '\'' +
                ", details='" + details + '\'' +
                ", sign=" + sign +
                '}';
    }
}
