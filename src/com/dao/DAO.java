package com.dao;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.HashMap;

import com.dao.src.SiteSimple;
import com.dao.src.SiteUser;
import com.util.ConnectionConfiguration;

public abstract class DAO<T> {
    protected Connection connect = null;

    public DAO(Connection conn){
        this.connect = conn;
    }

    /**
     * Méthode de création
     * @param obj
     * @return boolean
     */
    public abstract int create(T obj);

    /**
     * Méthode pour effacer
     * @param obj
     * @return boolean
     */
    public abstract boolean delete(T obj);

    /**
     * Méthode de mise à jour
     * @param obj
     * @return boolean
     */
    public abstract boolean update(T obj);

    /**
     * Méthode de recherche des informations
     * @param key
     * @param value
     * @return T
     */
    public abstract T findByKey(String key, String value);

    /**
     * Méthode de recherche des informations
     * @param key
     * @param value
     * @return ArrayList<SiteUser>
     */
    public abstract HashMap<SiteUser,SiteSimple> findSitesSimpleByKey(String key, String value);
}

