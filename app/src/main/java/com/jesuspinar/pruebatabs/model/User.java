package com.jesuspinar.pruebatabs.model;

import java.util.GregorianCalendar;

public class User {


    /// Defining profiles
    private Personal personal;
    private Professional professional;
    private Access access;

    public User(String picture, String nif, String name, String surname, String birth, String address,
                String legalForm, String cif, String webSite, String email)
    {
        personal = new Personal(picture, nif, name, surname, birth, address);
        professional = new Professional(legalForm, cif, address, webSite, email);
        access = new Access(personal.getName()+personal.getSurname(), "12345");
    }

    // Personal data
    public String getNif(){
        return personal.getNif();
    }
    public String getName() {
        return personal.getName();
    }
    public String getSurname(){
        return personal.getSurname();
    }
    public String getAddress(){
        return personal.getAddress();
    }
    public String getBirth(){
        return personal.getBirth();
    }
    public String getAge(){
        return " ("+personal.getAge()+" aged) ";
    }

    // Professional data
    public String getCif(){
        return professional.getCif();
    }
    public String getLegalForm(){
        return professional.getLegalForm();
    }
    public String getWebsite(){
        return professional.getWebSite();
    }
    public String getEmail(){
        return professional.getEmail();
    }

    // Access data
    public String getUsername(){
        return access.getUsername();
    }
    public String getPassword(){
        return access.getPwd();
    }

    public void setPwd(String newPwd) {
        access.setPwd(newPwd);
    }
}
