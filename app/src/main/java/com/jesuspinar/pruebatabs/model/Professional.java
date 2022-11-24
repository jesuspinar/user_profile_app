package com.jesuspinar.pruebatabs.model;

public class Professional {
    private String legalForm;
    private String cif;
    private String address;
    private String webSite;
    private String email;

    public Professional(String legalForm, String cif, String address, String webSite, String email) {
        this.legalForm = legalForm;
        this.cif = cif;
        this.address = address;
        this.webSite = webSite;
        this.email = email;
    }

    public String getLegalForm() {
        return legalForm;
    }

    public String getCif() {
        return cif;
    }

    public String getAddress() {
        return address;
    }

    public String getWebSite() {
        return webSite;
    }

    public String getEmail() {
        return email;
    }
}
