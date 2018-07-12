package com.dao.implement;

import com.dao.DAO;
import com.dao.src.SiteSimple;
import com.dao.src.SiteUser;

import java.sql.*;
import java.util.ArrayList;
import java.util.UUID;

public class SiteSimpleDAO extends DAO<SiteSimple> {

    public SiteSimpleDAO(Connection conn){
        super(conn);
    }

    public ArrayList<SiteUser> findSitesSimpleByKey(String key, String value) { return new ArrayList<SiteUser>(); }

    public int create(SiteSimple siteSimple) {
        try {

            Statement s = this.connect.createStatement();
            PreparedStatement pst = this.connect.prepareStatement("INSERT INTO simple_site(friendly_url, default_url, expire_date, is_secure, password) VALUES (?,?,?,?,?)",
                    Statement.RETURN_GENERATED_KEYS);
            pst.setString(1, getFriendlyurlFromDefault());
            pst.setString(2, siteSimple.getDefault_url());
            java.sql.Date expired_at = new java.sql.Date(siteSimple.getExpire_date().getTime());
            pst.setDate(3, expired_at);
            pst.setInt(4, siteSimple.getIs_secure());
            pst.setString(5, siteSimple.getPassword());
            int affectedRows = pst.executeUpdate();

            if (affectedRows == 0) {
                throw new SQLException("Creating siteSimple failed, no rows affected.");
            }
            try (ResultSet generatedKeys = pst.getGeneratedKeys()) {
                if (generatedKeys.next()) {
                    return (int) generatedKeys.getLong(1);
                }
                else {
                    throw new SQLException("Creating siteSimple failed, no ID obtained.");
                }
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }

    public boolean delete(SiteSimple obj) {
        return false;
    }

    public boolean update(SiteSimple obj) {
        return false;
    }

    public SiteSimple findByKey(String key, String value) {
        SiteSimple siteSimple = new SiteSimple();

        try {

            Statement s = this.connect.createStatement();
            PreparedStatement pst = this.connect.prepareStatement("select * from simple_site where "+ key +" = ?");
            pst.setString(1, value);
            ResultSet rs = pst.executeQuery();

            if(rs.first())
                siteSimple = new SiteSimple(
                        rs.getInt("id"),
                        rs.getString("friendly_url"),
                        rs.getString("default_url"),
                        rs.getInt("is_secure"),
                        rs.getDate("expire_date"),
                        rs.getString("password")
                );
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return siteSimple;
    }

    static String getFriendlyurlFromDefault() {

        String uniqueID = UUID.randomUUID().toString();

        return "http://localhost:3000/s/" + uniqueID;
    }

}
