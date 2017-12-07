package com.codekul.sonal.retrofit.domain;

/**
 * Created by sonal on 6/12/17.
 */

public class User {
    private String id;
    private String name;
    private String emailId;
    private String password;
    private String city;


    @Override
    public String toString() {
        return "User{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", emailId='" + emailId + '\'' +
                ", password='" + password + '\'' +
                ", city='" + city + '\'' +
                '}';
    }


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmailId() {
        return emailId;
    }

    public void setEmailId(String emailId) {
        this.emailId = emailId;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }





}
