package com.dao.implement;

import com.dao.DAO;
import com.dao.src.Password;

import java.sql.*;

public class PasswordDAO extends DAO<Password> {

    public PasswordDAO(Connection conn){
        super(conn);
    }

    public boolean create(Password obj) {
        return false;
    }

    public boolean delete(Password obj) {
        return false;
    }

    public boolean update(Password obj) {
        return false;
    }

    public Password find(int id) {
        Password password = new Password();

        try {

            Statement s = this.connect.createStatement();
            PreparedStatement pst = this.connect.prepareStatement("select * from passwords where id=?");
            pst.setInt(1, id);
            ResultSet rs = pst.executeQuery();

            if(rs.first())
                password = new Password(
                        id,
                        rs.getString("password"),
                        rs.getInt("id_site")
                );
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return password;
    }

}
