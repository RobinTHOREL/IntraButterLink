package com.dao.implement;

import com.dao.DAO;
import com.dao.src.SiteSimple;

import java.sql.*;

public class SiteSimpleDAO extends DAO<SiteSimple> {

    public SiteSimpleDAO(Connection conn){
        super(conn);
    }

    public boolean create(SiteSimple obj) {
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
                        rs.getString("original_url"),
                        rs.getDate("created_at"),
                        rs.getDate("updated_at")
                );
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return siteSimple;
    }

}
