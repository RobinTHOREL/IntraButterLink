package com.dao.src;

import java.util.Date;

public class SiteUser {

    private int id = 0;
    private int clic_counter = 0;
    private boolean captcha = false;
    private int max_clic = 0;
    private Date created_at = null;
    private Date updated_at = null;
    private int id_simple_site = 0;
    private int id_user = 0;

    public SiteUser(int id, int clic_counter, boolean captcha,  int max_clic, Date created_at, Date updated_at, int id_simple_site, int id_user) {
        this.id = id;
        this.captcha = captcha;
        this.created_at = created_at;
        this.updated_at = updated_at;
        this.max_clic = max_clic;
        this.clic_counter = clic_counter;
        this.id_simple_site = id_simple_site;
        this.id_user = id_user;
    }

    public SiteUser(){}

    public int getId() {
        return id;
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

    public int getClic_counter() {
        return clic_counter;
    }

    public void setClic_counter(int clic_counter) {
        this.clic_counter = clic_counter;
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

    public void setId_user(int id_user) {
        this.id_user = id_user;
    }
}
