package com.dao.src;

public class Password {

    private int id = 0;
    private String password = "";
    private int idSite = 0;

    public Password(int id, String password, int idSite) {
        this.id = id;
        this.password = password;
        this.idSite = idSite;
    }

    public Password() {}

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getIdSite() {
        return idSite;
    }

    public void setIdSite(int idSite) {
        this.idSite = idSite;
    }
}
