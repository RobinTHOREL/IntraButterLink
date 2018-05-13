package com.dao.src;

import java.util.Date;

public class Stats {

    private int id = 0;
    private Date date_clic = null;
    private String country = "";
    private int site_id = 0;

    public Stats(int id, Date date_clic, String country, int site_id) {
        this.id = id;
        this.date_clic = date_clic;
        this.country = country;
        this.site_id = site_id;
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

    public int getSite_id() {
        return site_id;
    }

    public void setSite_id(int id_site) {
        this.site_id = id_site;
    }
}
