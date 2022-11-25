package com.jesuspinar.pruebatabs.model;

public class Access {
    private String username;
    private String pwd;

    public Access(String username, String pwd) {
        this.username = username;
        this.pwd = pwd;
    }

    public String getUsername() {
        return username;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String newPwd) {
        pwd = newPwd;
    }
}
