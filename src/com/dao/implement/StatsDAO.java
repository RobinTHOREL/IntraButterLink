package com.dao.implement;

import com.dao.DAO;
import com.dao.src.Stats;

import java.sql.*;

public class StatsDAO extends DAO<Stats> {

    public StatsDAO(Connection conn){
        super(conn);
    }

    public boolean create(Stats obj) {
        return false;
    }

    public boolean delete(Stats obj) {
        return false;
    }

    public boolean update(Stats obj) {
        return false;
    }

    public Stats find(int id) {
        Stats stats = new Stats();

        try {

            Statement s = this.connect.createStatement();
            PreparedStatement pst = this.connect.prepareStatement("select * from stats where id=?");
            pst.setInt(1, id);
            ResultSet rs = pst.executeQuery();

            if(rs.first())
                stats = new Stats(
                        id,
                        rs.getDate("date_clic"),
                        rs.getString("country"),
                        rs.getInt("id_site")
                );
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return stats;
    }

}
