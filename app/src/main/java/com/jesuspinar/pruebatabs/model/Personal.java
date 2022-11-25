package com.jesuspinar.pruebatabs.model;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class Personal {
    private String picture;
    private String nif;
    private String name;
    private String surname;
    private GregorianCalendar birth;
    private String birthStr;
    private String address;


    public Personal(String picture, String nif, String name, String surname, String birth, String address) {
        this.picture = picture;
        this.nif = nif;
        this.name = name;
        this.surname = surname;
        this.address = address;

        DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        Date date = null;
        try {
            date = dateFormat.parse(birth);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        GregorianCalendar birthday = new GregorianCalendar();
        assert date != null;
        birthday.setTime(date);

        this.birthStr = birth;
        this.birth = birthday;
    }

    public String getPicture() {
        return picture;
    }

    public String getNif() {
        return nif;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public String getBirth() {
        return birthStr;
    }

    public String getAddress() {
        return address;
    }

    public int getAge() {
        Calendar date = Calendar.getInstance();
        int years = date.get(Calendar.YEAR) - birth.get(Calendar.YEAR);
        int months = date.get(Calendar.MONTH) - birth.get(Calendar.MONTH);
        int days = date.get(Calendar.DAY_OF_MONTH) - birth.get(Calendar.DAY_OF_MONTH);

        if(months < 0 || (months==0 && days < 0)) {
            years--;
        }
        return years;
    }
}
