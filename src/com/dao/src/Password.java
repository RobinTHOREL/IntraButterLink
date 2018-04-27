package com.dao.src;

public class Password {

    private int id = 0;
    private String password = "";
    private int idUser = 0;

    public Password(int id, String password, int idUser) {
        this.id = id;
        this.password = password;
        this.idUser = idUser;
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

    public int getIdUser() {
        return idUser;
    }

    public void setIdUser(int idUser) {
        this.idUser = idUser;
    }
}
