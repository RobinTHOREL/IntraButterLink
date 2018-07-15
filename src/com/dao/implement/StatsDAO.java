package com.dao.implement;

import com.dao.DAO;
import com.dao.src.SiteSimple;
import com.dao.src.SiteUser;
import com.dao.src.Stats;

import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;

public class StatsDAO extends DAO<Stats> {

    public StatsDAO(Connection conn){
        super(conn);
    }

    public HashMap<SiteUser,SiteSimple> findSitesSimpleByKey(String key, String value) { return new HashMap<>(); }


    public int create(Stats obj) {
        return 0;
    }

    public boolean delete(Stats obj) {
        return false;
    }

    public boolean update(Stats obj) {
        return false;
    }

    public Stats findByKey(String key, String value) {
        Stats stats = new Stats();

        try {

            Statement s = this.connect.createStatement();
            PreparedStatement pst = this.connect.prepareStatement("select * from user where "+ key +" = ?");
            pst.setString(1, value);
            ResultSet rs = pst.executeQuery();

            if(rs.first())
                stats = new Stats(
                        rs.getInt("id"),
                        rs.getDate("date_clic"),
                        rs.getString("country"),
                        rs.getInt("site_id")
                );
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return stats;
    }

}
