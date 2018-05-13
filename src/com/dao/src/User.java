package com.dao.src;

import java.util.Date;

public class User {

    private int id = 0;
    private String mail = "";
    private String firstname = "";
    private String lastname = "";
    private String password = "";

    public User(int id, String mail, String firstname, String lastname, String password) {
        this.id = id;
        this.mail = mail;
        this.firstname = firstname;
        this.lastname = lastname;
        this.password = password;
    }

    public User(){};

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
