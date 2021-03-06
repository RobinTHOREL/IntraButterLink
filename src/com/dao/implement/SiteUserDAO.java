package com.dao.implement;

import com.dao.DAO;
import com.dao.src.SiteSimple;
import com.dao.src.SiteUser;
import com.dao.src.User;

import java.sql.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

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

    public HashMap<SiteUser, SiteSimple> findSitesSimpleByKey(String key, String value) {
        SiteUser siteUser = new SiteUser();
        SiteSimple siteSimple;
        HashMap<SiteUser,SiteSimple> sitesUser = new HashMap<>();

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
            String test ="select * from site_user,site_simple where id_simple_site in " + sqlInString +"and simple_site.id IN "+sqlInString;
            System.out.println(test);

                try {

                    Statement statement = this.connect.createStatement();
                    PreparedStatement prst = this.connect.prepareStatement("select * from site_user,simple_site where id_simple_site in " + sqlInString +"and simple_site.id IN "+sqlInString);
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
                    siteSimple = new SiteSimple(
                            rsF.getInt(7),
                            rsF.getString(8),
                            rsF.getString(9),
                            rsF.getInt(12),
                            rsF.getDate(11),
                            rsF.getString(13)
                );
                    sitesUser.put(siteUser,siteSimple);

                }

                    System.out.println("SiteUserDAo - site user :" + Arrays.toString(sitesUser.keySet().toArray()));
                    System.out.println("SiteUserDAo - site simple :" + Arrays.toString(sitesUser.values().toArray()));

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
