package com.yurets_y.mydevelopercv.entities;


import javax.persistence.*;

import java.util.Collections;
import java.util.Date;
import java.util.Map;

@Entity
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Long id;


    private String name;

    private String middleName;

    private String surname;

    private Date birthDay;

    private String city;

    private String eMail;

    private String phone;

    @ElementCollection
    private Map<String,String> moreInfo;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMiddleName() {
        return middleName;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public Date getBirthDay() {
        return birthDay;
    }

    public void setBirthDay(Date birthDay) {
        this.birthDay = birthDay;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String geteMail() {
        return eMail;
    }

    public void seteMail(String eMail) {
        this.eMail = eMail;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Map<String, String> getMoreInfo() {
        return Collections.unmodifiableMap(moreInfo);
    }

    public void setMoreInfo(Map<String, String> moreInfo) {
        this.moreInfo = moreInfo;
    }
}
