package com.dao.implement;

import com.dao.DAO;
import com.dao.src.SiteUser;
import com.dao.src.User;

import java.sql.*;
import java.util.ArrayList;

public class UserDAO extends DAO<User> {

    public UserDAO(Connection conn){
        super(conn);
    }

    public ArrayList<SiteUser> findSitesSimpleByKey(String key, String value) { return new ArrayList<SiteUser>(); }


    public int create(User obj) {
        return 0;
    }

    public boolean delete(User obj) {
        return false;
    }

    public boolean update(User obj) {
        return false;
    }

    public User findByKey(String key, String value) {
        User user = new User();

        try {

            Statement s = this.connect.createStatement();
            PreparedStatement pst = this.connect.prepareStatement("select * from user where "+ key +" = ?");
            pst.setString(1, value);
            ResultSet rs = pst.executeQuery();

            if(rs.first())
                user = new User(
                        rs.getInt("id"),
                        rs.getString("email"),
                        rs.getString("firstname"),
                        rs.getString("lastname"),
                        rs.getString("password")
                );
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return user;
    }

}
