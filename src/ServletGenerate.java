import com.dao.DAO;
import com.dao.implement.SiteSimpleDAO;
import com.dao.src.SiteSimple;
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
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

@WebServlet(name = "ServletGenerate", urlPatterns = "/generate")
public class ServletGenerate extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String isLogged = request.getParameter("isLogged");
        String default_url = request.getParameter("url");

        String expire_date_string = request.getParameter("expire_date");
        DateFormat format = new SimpleDateFormat("YYYY-mm-dd");
        Date expire_date = null;
        try {
            expire_date = format.parse(expire_date_string);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        int isSecure = 0;
        String password = request.getParameter("password");

        if (password.length() > 0)
            isSecure = 1;

        String max_clics = request.getParameter("max_clics");
        String captcha = request.getParameter("captcha");
        // System.out.println("captcha : " + captcha + "/ url : " + url + "/expire_date : " + expire_date + " /max clics :" + max_clics + " /password : " + password);
        DAO<SiteSimple> siteSimple = new SiteSimpleDAO(ConnectionConfiguration.getConnection(getServletContext().getInitParameter("db-url"), getServletContext().getInitParameter("db-user"),
                getServletContext().getInitParameter("db-password")));
        SiteSimple site = new SiteSimple( 0,"",default_url,isSecure ,expire_date,expire_date,password);
        if(siteSimple.create(site)){
            System.out.println("Success");
        }
        else {
            System.out.println("Failure");
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
