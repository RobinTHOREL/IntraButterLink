
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.util.ConnectionConfiguration;


/**
 * Servlet implementation class Link
 */
@WebServlet("/s")
public class ServletLink extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id = request.getParameter("id");
        String default_url = "";
        String password = "";
        String friendly_url = "";
        Date expire_date = null;
        int nb_traffic = 0;
        int captcha = 0;
        int max_clic = 0;
        boolean verif_clique_is_ok = false;
        boolean verif_expiration = false;
        int idSimpleSite = 0;

        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection conn = null;
            conn = ConnectionConfiguration.getConnection(getServletContext().getInitParameter("db-url"), getServletContext().getInitParameter("db-user"),
                    getServletContext().getInitParameter("db-password"));

            String query1 = "SELECT * FROM simple_site,site_user WHERE friendly_url LIKE \"%" + id + "\" AND simple_site.id = site_user.id_simple_site";
            System.out.println(query1);
            PreparedStatement pst1 = conn.prepareStatement(query1);
            //pst1.setString(1, id);

            ResultSet rs = pst1.executeQuery();

            while (rs.next()) {
                default_url = rs.getString("default_url");
                friendly_url = rs.getString("friendly_url");
                password = rs.getString("password");
                nb_traffic = rs.getInt(9);
                expire_date = rs.getDate("expire_date");
                max_clic = rs.getInt("max_clics");
                idSimpleSite = rs.getInt(12);
            }
            rs.close();
            pst1.close();

            String query2 = "UPDATE site_user SET nb_traffic = "+(nb_traffic+1)+" WHERE id_simple_site = ?";
            System.out.println(query2);
            System.out.println(idSimpleSite);
            PreparedStatement pst2 = conn.prepareStatement(query2);
            pst2.setInt(1, idSimpleSite);

            pst2.execute();
            pst2.close();

        } catch (Exception e) {
            System.out.println("pas ok " + e);
        }
        if(max_clic == 0){
            verif_clique_is_ok = true;
        }
        if(max_clic > nb_traffic) {
            verif_clique_is_ok = true;
        }

        System.out.println("verif clic "+verif_clique_is_ok);
        System.out.println("verif expiration "+verif_expiration);
        if(verif_clique_is_ok == true) {
            System.out.println("ca passe");
            response.sendRedirect(default_url);
        } else {
            request.setAttribute("url", friendly_url);
            if(verif_clique_is_ok == false) {
                request.setAttribute("maxclique", "Désolée, cette URL n'est plus disponible");
            }


            this.getServletContext().getRequestDispatcher( "/links" ).forward( request, response );

        }

    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        /*String password_url = request.getParameter("password");
        String url_short = request.getParameter("url_short");
        String lien_full = "";
        String password = "";


        //Verif en base
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection conn = null;
            conn = ConnectionConfiguration.getConnection(getServletContext().getInitParameter("db-url"), getServletContext().getInitParameter("db-user"),
                    getServletContext().getInitParameter("db-password"));

            String query1 = "SELECT * FROM Lien WHERE url_short = ?";
            PreparedStatement pst1 = conn.prepareStatement(query1);
            pst1.setString(1, url_short);

            ResultSet rs = pst1.executeQuery();

            while (rs.next()) {
                lien_full = rs.getString("url_full");
                password = rs.getString("password_url");
            }
            rs.close();
            pst1.close();

        } catch (Exception e) {
            System.out.println("pas ok " + e);
        }


        //Si ok redirection sur url full
        //Si pas ok, redirection page saisi mot de passe
        if(password.equals(password_url)) {
            response.sendRedirect(lien_full);
        } else {
            request.setAttribute("mdpwrong", "mot de passe incorrecte");
            request.setAttribute("url", url_short);
            this.getServletContext().getRequestDispatcher( VUE ).forward( request, response );
        }*/


    }

}