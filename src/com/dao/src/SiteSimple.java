package com.dao.src;

import java.util.Date;

public class SiteSimple {

    private int id = 0;
    private String friendly_url = "";
    private String original_url = "";
    private Date created_at = null;
    private Date expire_date = null;

    public SiteSimple(int id, String friendly_url, String original_url, Date created_at, Date expire_date) {
        this.id = id;
        this.friendly_url = friendly_url;
        this.original_url = original_url;
        this.created_at = created_at;
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

    public String getOriginal_url() {
        return original_url;
    }

    public void setOriginal_url(String original_url) {
        this.original_url = original_url;
    }

    public Date getCreated_at() {
        return created_at;
    }

    public void setCreated_at(Date created_at) {
        this.created_at = created_at;
    }

    public Date getExpire_date() {
        return expire_date;
    }

    public void setExpire_date(Date expire_date) {
        this.expire_date = expire_date;
    }
}
