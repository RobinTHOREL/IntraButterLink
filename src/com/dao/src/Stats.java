package com.dao.src;

import java.util.Date;

public class Stats {

    private int id = 0;
    private Date date_clic = null;
    private String country = "";
    private int id_site = 0;

    public Stats(int id, Date date_clic, String country, int id_site) {
        this.id = id;
        this.date_clic = date_clic;
        this.country = country;
        this.id_site = id_site;
    }

    public Stats() {}

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getDate_clic() {
        return date_clic;
    }

    public void setDate_clic(Date date_clic) {
        this.date_clic = date_clic;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public int getId_site() {
        return id_site;
    }

    public void setId_site(int id_site) {
        this.id_site = id_site;
    }
}
