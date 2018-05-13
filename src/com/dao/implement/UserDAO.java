package com.dao.implement;

import com.dao.DAO;
import com.dao.src.User;

import java.sql.*;

public class UserDAO extends DAO<User> {

    public UserDAO(Connection conn){
        super(conn);
    }

    public boolean create(User obj) {
        return false;
    }

    public boolean delete(User obj) {
        return false;
    }

    public boolean update(User obj) {
        return false;
    }

    public User find(int id) {
        User user = new User();

        try {

            Statement s = this.connect.createStatement();
            PreparedStatement pst = this.connect.prepareStatement("select * from user where id=?");
            pst.setInt(1, id);
            ResultSet rs = pst.executeQuery();

            if(rs.first())
                user = new User(
                        id,
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
