package com.dao.src;

import java.util.Date;

public class User {

    private int id = 0;
    private String mail = "";
    private String firstname = "";
    private String lastname = "";
    private Date created_at = null;
    private Date updated_at = null;

    public User(int id, String mail, String firstname, String lastname, Date created_at, Date updated_at) {
        this.id = id;
        this.mail = mail;
        this.firstname = firstname;
        this.lastname = lastname;
        this.created_at = created_at;
        this.updated_at = updated_at;
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

    public Date getCreated_at() {
        return created_at;
    }

    public void setCreated_at(Date created_at) {
        this.created_at = created_at;
    }

    public Date getUpdated_at() {
        return updated_at;
    }

    public void setUpdated_at(Date updated_at) {
        this.updated_at = updated_at;
    }
}
