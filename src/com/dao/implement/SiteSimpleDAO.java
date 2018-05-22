package com.dao.implement;

import com.dao.DAO;
import com.dao.src.SiteSimple;

import java.sql.*;
import java.util.UUID;

public class SiteSimpleDAO extends DAO<SiteSimple> {

    public SiteSimpleDAO(Connection conn){
        super(conn);
    }

    public int create(SiteSimple siteSimple) {
        try {

            Statement s = this.connect.createStatement();
            PreparedStatement pst = this.connect.prepareStatement("INSERT INTO simple_site(friendly_url, default_url, created_at, expire_date, is_secure, password) VALUES (?,?,?,?,?,?)",
                    Statement.RETURN_GENERATED_KEYS);
            pst.setString(1, getFriendlyurlFromDefault());
            pst.setString(2, siteSimple.getDefault_url());
            java.sql.Date created_at = new java.sql.Date(siteSimple.getCreated_at().getTime());
            pst.setDate(3, created_at);
            java.sql.Date expired_at = new java.sql.Date(siteSimple.getExpire_date().getTime());
            pst.setDate(4, expired_at);
            pst.setInt(5, siteSimple.getIs_secure());
            pst.setString(6, siteSimple.getPassword());
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
            PreparedStatement pst = this.connect.prepareStatement("select * from site_simple where "+ key +" = ?");
            pst.setString(1, value);
            ResultSet rs = pst.executeQuery();

            if(rs.first())
                siteSimple = new SiteSimple(
                        rs.getInt("id"),
                        rs.getString("friendly_url"),
                        rs.getString("default_url"),
                        rs.getInt("is_secure"),
                        rs.getDate("created_at"),
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
