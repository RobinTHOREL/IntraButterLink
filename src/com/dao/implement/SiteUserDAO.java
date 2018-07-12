package com.dao.implement;

import com.dao.DAO;
import com.dao.src.SiteUser;
import com.dao.src.User;

import java.sql.*;
import java.util.ArrayList;
import java.util.Arrays;

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

    public SiteUser findByKey(String key, String value) { return new SiteUser(); }

    public ArrayList<SiteUser> findSitesSimpleByKey(String key, String value) {
        SiteUser siteUser = new SiteUser();
        ArrayList<SiteUser> sitesUser = new ArrayList<SiteUser>();

        try {

            Statement s = this.connect.createStatement();
            PreparedStatement pst = this.connect.prepareStatement("select id_simple_site from site_user where "+ key +" = ?");
            pst.setString(1, value);
            ResultSet rs = pst.executeQuery();

            ArrayList<Integer> ids_simple_site = new ArrayList<>();

            while (rs.next()) {
                int id = rs.getInt("id_simple_site");

                if(id != 0)
                    ids_simple_site.add(id);
            }

            //rs.close();

            System.out.println(Arrays.toString(ids_simple_site.toArray()));

            String sqlInString = "(";

            for ( int c = 0 ; c < ids_simple_site.size() ; c++ ){
                sqlInString += ids_simple_site.get(c);

                if ( c != ids_simple_site.size()-1 )
                    sqlInString += ", ";
            }

            sqlInString += ")";

            System.out.println(">> " + sqlInString);
            String test ="select * from site_user where id_simple_site in " + sqlInString;
            System.out.println(test);

                try {

                    Statement statement = this.connect.createStatement();
                    PreparedStatement prst = this.connect.prepareStatement("select * from site_user where id_simple_site in " + sqlInString);
                    //prst.setString(1, sqlInString);
                    ResultSet rsF = prst.executeQuery();

                    while(rsF.next()) {
                    siteUser = new SiteUser(
                            rsF.getInt(1),
                            rsF.getInt(2),
                            rsF.getBoolean(3),
                            rsF.getInt(4),
                            rsF.getInt(5),
                            rsF.getInt(6)
                    );

                    sitesUser.add(siteUser);

                }

                    System.out.println("SiteUserDAo" + Arrays.toString(sitesUser.toArray()));


                    rsF.close();


                } catch (SQLException e) {
                    e.printStackTrace();
                }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return sitesUser;
    }

}
