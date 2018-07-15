package com.dao.implement;

import com.dao.DAO;
import com.dao.src.Password;
import com.dao.src.SiteSimple;
import com.dao.src.SiteUser;

import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;

public class PasswordDAO extends DAO<Password> {

    public PasswordDAO(Connection conn){
        super(conn);
    }

    public HashMap<SiteUser,SiteSimple> findSitesSimpleByKey(String key, String value) { return new HashMap<>(); }

    public int create(Password obj) {
        return 0;
    }

    public boolean delete(Password obj) {
        return false;
    }

    public boolean update(Password obj) {
        return false;
    }

    public Password findByKey(String key, String value) {
        Password password = new Password();

        try {

            Statement s = this.connect.createStatement();
            PreparedStatement pst = this.connect.prepareStatement("select * from user where "+ key +" = ?");
            pst.setString(1, value);
            ResultSet rs = pst.executeQuery();

            if(rs.first())
                password = new Password(
                        rs.getInt("id"),
                        rs.getString("password"),
                        rs.getInt("id_site")
                );
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return password;
    }

}
