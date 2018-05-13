package com.dao.implement;

import com.dao.DAO;
import com.dao.src.SiteSimple;

import java.sql.*;

public class SiteSimpleDAO extends DAO<SiteSimple> {

    public SiteSimpleDAO(Connection conn){
        super(conn);
    }

    public boolean create(SiteSimple siteSimple) {
        try {

            Statement s = this.connect.createStatement();
            PreparedStatement pst = this.connect.prepareStatement("INSERT INTO site_simple(friendly_url, default_url, created_at, expire_date, is_secure, password) VALUES (?,?,?,?,?,?)");
            pst.setString(1, siteSimple.getFriendly_url());
            pst.setString(2, siteSimple.getDefault_url());
            pst.setDate(3, (Date) siteSimple.getCreated_at());
            pst.setDate(4, (Date) siteSimple.getExpire_date());
            pst.setInt(5, siteSimple.getIs_secure());
            pst.setString(6, siteSimple.getPassword());
            return pst.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public boolean delete(SiteSimple obj) {
        return false;
    }

    public boolean update(SiteSimple obj) {
        return false;
    }

    public SiteSimple find(int id) {
        SiteSimple siteSimple = new SiteSimple();

        try {

            Statement s = this.connect.createStatement();
            PreparedStatement pst = this.connect.prepareStatement("select * from site_simple where id=?");
            pst.setInt(1, id);
            ResultSet rs = pst.executeQuery();

            if(rs.first())
                siteSimple = new SiteSimple(
                        id,
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

}
