package com.dao.src;

import java.util.Date;

public class SiteSimple {

    private int id = 0;
    private String friendly_url = "";
    private String default_url = "";
    private int is_secure = 0;
    private String password = "";
    private Date expire_date = null;

    public SiteSimple(int id, String friendly_url, String default_url, int is_secure, Date expire_date, String password) {
        this.id = id;
        this.friendly_url = friendly_url;
        this.default_url = default_url;
        this.is_secure = is_secure;
        this.password = password;
        this.expire_date = expire_date;
    }

    public SiteSimple() {}

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFriendly_url() {
        return friendly_url;
    }

    public void setFriendly_url(String friendly_url) {
        this.friendly_url = friendly_url;
    }

    public String getDefault_url() {
        return default_url;
    }

    public void setDefault_url(String default_url) {
        this.default_url = default_url;
    }

    public int getIs_secure() {
        return is_secure;
    }

    public void setIs_secure(int is_secure) {
        this.is_secure = is_secure;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Date getExpire_date() {
        return expire_date;
    }

    public void setExpire_date(Date expire_date) {
        this.expire_date = expire_date;
    }
}
