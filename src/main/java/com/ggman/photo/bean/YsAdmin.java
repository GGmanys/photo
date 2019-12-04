package com.ggman.photo.bean;

public class YsAdmin {
    private Integer id ;
    private String name ;
    private String password;
    private  Integer sign;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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

    public Integer getSign() {
        return sign;
    }

    public void setSign(Integer sign) {
        this.sign = sign;
    }

    public YsAdmin() {
    }

    public YsAdmin(Integer id, String name, String password, Integer sign) {
        this.id = id;
        this.name = name;
        this.password = password;
        this.sign = sign;
    }

    @Override
    public String toString() {
        return "YsAdmin{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", password='" + password + '\'' +
                ", sign=" + sign +
                '}';
    }
}
