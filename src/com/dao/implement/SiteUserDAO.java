package com.dao.implement;

import com.dao.DAO;
import com.dao.src.SiteUser;
import com.dao.src.User;

import java.sql.*;

public class SiteUserDAO extends DAO<SiteUser> {

    public SiteUserDAO(Connection conn){
        super(conn);
    }

    public int create(SiteUser siteUser) {
        try {

            Statement s = this.connect.createStatement();
            PreparedStatement pst = this.connect.prepareStatement("INSERT INTO site_user(nb_traffic, captcha, max_clics, id_simple_site, user_id) VALUES (?,?,?,?,?)",
                    Statement.RETURN_GENERATED_KEYS);
            pst.setInt(1, siteUser.getNb_traffic());
            pst.setBoolean(2, siteUser.isCaptcha());
            pst.setInt(3, siteUser.getMax_clic());
            pst.setInt(4, siteUser.getId_simple_site());
            pst.setInt(5, siteUser.getId_user());
            int affectedRows = pst.executeUpdate();

            if (affectedRows == 0) {
                throw new SQLException("Creating siteUser failed, no rows affected.");
            }
            try (ResultSet generatedKeys = pst.getGeneratedKeys()) {
                if (generatedKeys.next()) {
                    return (int) generatedKeys.getLong(1);
                }
                else {
                    throw new SQLException("Creating siteUser failed, no ID obtained.");
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }

    public boolean delete(SiteUser obj) {
        return false;
    }

    public boolean update(SiteUser obj) {
        return false;
    }

    public SiteUser findByKey(String key, String value) {
        SiteUser siteUser = new SiteUser();
        try {

            Statement s = this.connect.createStatement();
            PreparedStatement pst = this.connect.prepareStatement("select * from simple_site where "+ key +" = ?");
            pst.setString(1, value);
            ResultSet rs = pst.executeQuery();

            if(rs.first())
                siteUser = new SiteUser(
                        rs.getInt("id"),
                        rs.getInt("nb_traffic"),
                        rs.getBoolean("captcha"),
                        rs.getInt("max_clic"),
                        rs.getInt("id_simple_site"),
                        rs.getInt("id_user")
                );
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return siteUser;
    }

}
