package com.dao.implement;

import com.dao.DAO;
import com.dao.src.SiteUser;

import java.sql.*;

public class SiteUserDAO extends DAO<SiteUser> {

    public SiteUserDAO(Connection conn){
        super(conn);
    }

    public boolean create(SiteUser obj) {
        return false;
    }

    public boolean delete(SiteUser obj) {
        return false;
    }

    public boolean update(SiteUser obj) {
        return false;
    }

    public SiteUser find(int id) {
        SiteUser siteUser = new SiteUser();

        try {

            Statement s = this.connect.createStatement();
            PreparedStatement pst = this.connect.prepareStatement("select * from site_user where id=?");
            pst.setInt(1, id);
            ResultSet rs = pst.executeQuery();

            if(rs.first())
                siteUser = new SiteUser(
                        id,
                        rs.getInt("clic_counter"),
                        rs.getBoolean("captcha"),
                        rs.getInt("max_clic"),
                        rs.getDate("created_at"),
                        rs.getDate("updated_at"),
                        rs.getInt("id_simple_site"),
                        rs.getInt("id_user")
                );
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return siteUser;
    }

}
