import com.util.ConnectionConfiguration;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

@WebServlet(name = "ServletAuthenticate", urlPatterns ="/authenticated" )
public class ServletAuthenticate extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        HttpSession session = request.getSession(true);
        Connection conn = null;
        Statement stmt = null;

        String currentSession = (String) session.getAttribute( "currentSessionUser" );

        if ( currentSession == null )
            response.sendRedirect("/login");

        System.out.println(" Session : " + currentSession);

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        out.println("<!DOCTYPE html>\n" +
                "<html lang=\"en\">\n" +
                "\n" +
                "<head>\n" +
                "  <meta charset=\"UTF-8\">\n" +
                "  <title>Authenticated</title>\n" +
                "  <link rel=\"stylesheet\" href=\"https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css\" integrity=\"sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm\" crossorigin=\"anonymous\">\n" +
                "  <!-- Copyright © 2014 Monotype Imaging Inc. All rights reserved -->\n" +
                "  <link rel=\"stylesheet\" href=\"boosted/dist/css/orangeHelvetica.css\">\n" +
                "  <!-- Copyright © 2016 Orange SA. All rights reserved -->\n" +
                "  <link rel=\"stylesheet\" href=\"boosted/dist/css/orangeIcons.css\">\n" +
                "  <link rel=\"stylesheet\" href=\"boosted/dist/css/boosted.css\">\n" +
                "  <link rel=\"stylesheet\" href=\"//code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css\">\n" +
                "</head>\n" +
                "\n" +
                "<body>\n" +
                "<div class=\"skiplinks\" >\n" +
                "  <div class=\"skiplinks-section sr-only\">\n" +
                "    <ul>\n" +
                "      <li id=\"cdu-skiplink\">\n" +
                "      </li>\n" +
                "      <li>\n" +
                "        <a href=\"#content\" class=\"skiplinks-trigger\">content</a>\n" +
                "      </li>\n" +
                "    </ul>\n" +
                "  </div>\n" +
                "</div>\n" +
                "<header role=\"banner\">\n" +
                "  <nav class=\"navbar navbar-dark bg-dark navbar-expand-md\">\n" +
                "    <div class=\"container\">\n" +
                "      <a class=\"navbar-brand\" href=\"#\">\n" +
                "        <img src=\"boosted/img/orange_logo.svg\" alt=\"Back to homepage\" title=\"Back to homepage\"/></a>\n" +
                "      <button class=\"navbar-toggler\" type=\"button\" data-toggle=\"collapse\" data-target=\"#orange-navbar-collapse\" aria-controls=\"orange-navbar-collapse\" aria-expanded=\"false\" aria-label=\"Toggle navigation\">\n" +
                "        <span class=\"navbar-toggler-icon\"></span>\n" +
                "      </button>\n" +
                "      <div class=\"navbar-collapse justify-content-between collapse\" id=\"orange-navbar-collapse\">\n" +
                "        <ul class=\"navbar-nav\">\n" +
                "          <li role=\"presentation\" class=\"nav-item dropdown\">\n" +
                "            <a href=\"/logout\" class=\"nav-link active\" role=\"button\">\n" +
                "                  Deconnexion\n" +
                "            </a>\n" +
                "          </li>\n" +
                "        </ul>\n" +
                "      </div>\n" +
                "      <!-- /.navbar-collapse -->\n" +
                "    </div>\n" +
                "    <!-- /.container -->\n" +
                "  </nav>\n" +
                "</header>\n" +
                "<main id=\"content\" class=\"container\">\n" +
                "  <div id=\"header\" class=\"container\">\n" +
                "    <div class=\"row\">\n" +
                "      <div class=\"col-sm-6\">\n" +
                "        <h1>Authenticated area " + currentSession + " </h1>\n" +
                "      </div>\n" +
                "    </div>\n" +
                "  </div>\n" +
                "\n" +
                "  <table id=\"news-table\" class=\"table tablesorter\">\n" +
                "    <thead>\n" +
                "    <tr>\n" +
                "      <th scope=\"col\" class=\"header\">ID\n" +
                "      </th>\n" +
                "      <th scope=\"col\" class=\"header\">Login\n" +
                "      </th>\n" +
                "      <th scope=\"col\" class=\"header\">actions\n" +
                "      </th>\n" +
                "    </tr>\n" +
                "    </thead>\n" +
                "    <tbody>\n");

        try{
            conn = ConnectionConfiguration.getConnection( getServletContext().getInitParameter("db-url"), getServletContext().getInitParameter("db-user"),
                    getServletContext().getInitParameter("db-password"));
            stmt = conn.createStatement();
            String sql = "SELECT id, login FROM user";
            ResultSet rs = stmt.executeQuery(sql);

            while(rs.next()){
                int id  = rs.getInt("id");
                String login = rs.getString("login");


                out.println( " <tr>\n" +
                        "      <td> " + id + " </td>\n" +
                        "      <td> " + login + "</td>\n" +
                        "      <td>\n" +
                        "      <a href=\"/delete?id=" + id + "\" class=\"btn btn-danger\">Delete</a>\n" +
                        "      </td>\n" +
                        "    </tr>\n" );
            }
            rs.close();
        }catch(SQLException se){
            //Handle errors for JDBC
            se.printStackTrace();
        }catch(Exception e){
            //Handle errors for Class.forName
            e.printStackTrace();
        }finally{
            //finally block used to close resources
            try{
                if(stmt!=null)
                    conn.close();
            }catch(SQLException se){
            }// do nothing
            try{
                if(conn!=null)
                    conn.close();
            }catch(SQLException se){
                se.printStackTrace();
            }//end finally try
        }//end try

                out.println("</tbody>\n" +
                "  </table>\n" +
                "  <hr>\n" +
                "</main>\n" +
                "</body>\n" +
                "<script src=\"https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js\" integrity=\"sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q\" crossorigin=\"anonymous\"></script>\n" +
                "<!--  Boostratp/js\n" +
                "<script src=\"https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js\" integrity=\"sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl\" crossorigin=\"anonymous\"></script>\n" +
                "-->\n" +
                "<script src=\"boosted/dist/js/boosted.js\"></script>\n" +
                "<script src=\"https://code.jquery.com/jquery-1.12.4.js\"></script>\n" +
                "<script src=\"https://code.jquery.com/ui/1.12.1/jquery-ui.js\"></script>\n" +
                "</html>");

    }
}
