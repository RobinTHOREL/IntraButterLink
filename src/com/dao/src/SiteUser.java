package com.dao.src;

import java.util.Date;

public class SiteUser {

    private int id = 0;
    private int nb_traffic = 0;
    private boolean captcha = false;
    private int max_clic = 0;
    private int id_simple_site = 0;
    private int id_user = 0;

    public SiteUser(int id, int nb_traffic, boolean captcha,  int max_clic, int id_simple_site, int id_user ) {
        this.id = id;
        this.captcha = captcha;
        this.max_clic = max_clic;
        this.nb_traffic = nb_traffic;
        this.id_simple_site = id_simple_site;
        this.id_user = id_user;
    }

    public SiteUser(){}

    public int getId() {
        return id;
    }


    public void setId(int id) {
        this.id = id;
    }

    public boolean isCaptcha() {
        return captcha;
    }

    public void setCaptcha(boolean captcha) {
        this.captcha = captcha;
    }

    public int getMax_clic() {
        return max_clic;
    }

    public void setMax_clic(int max_clic) {
        this.max_clic = max_clic;
    }

    public int getId_simple_site() {
        return id_simple_site;
    }

    public void setId_simple_site(int id_simple_site) {
        this.id_simple_site = id_simple_site;
    }

    public int getId_user() {
        return id_user;
    }

    public int getNb_traffic() {
        return nb_traffic;
    }

    public void setNb_traffic(int nb_traffic) {
        this.nb_traffic = nb_traffic;
    }

    public void setId_user(int id_user) {
        this.id_user = id_user;
    }

    public boolean isValid() {
        return this.getNb_traffic() >= this.getMax_clic();
    }
}
