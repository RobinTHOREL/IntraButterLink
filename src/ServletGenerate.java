import com.dao.DAO;
import com.dao.implement.SiteSimpleDAO;
import com.dao.implement.SiteUserDAO;
import com.dao.implement.UserDAO;
import com.dao.src.SiteSimple;
import com.dao.src.SiteUser;
import com.dao.src.User;
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

        //Get form data
        Boolean isLogged = Boolean.valueOf(request.getParameter("isLogged"));
        int isSecure = 0;
        int siteId = 0;
        String default_url = request.getParameter("url");
        String password = request.getParameter("password");

        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date date = new Date();
        System.out.println(dateFormat.format(date));


        boolean captchaStatus = false;

        if (password.length() > 0)
            isSecure = 1;

        //Init SiteSimple DAO
        DAO<SiteSimple> siteSimple = new SiteSimpleDAO(ConnectionConfiguration.getConnection(getServletContext().getInitParameter("db-url"), getServletContext().getInitParameter("db-user"),
                getServletContext().getInitParameter("db-password")));

        if(!isLogged) {
            //Create siteSimple object with form data
            //SiteSimple site = new SiteSimple( 0,"",default_url,isSecure ,dateFormat.format(date),new Date("15-01-1993"),password);
        } else {
            String expire_date_string = request.getParameter("expire_date");
            DateFormat format = new SimpleDateFormat("YYYY-mm-dd");
            Date expire_date = null;

            try {
                expire_date = format.parse(expire_date_string);
            } catch (ParseException e) {
                e.printStackTrace();
            }

            //Create siteSimple object with form data
            SiteSimple site = new SiteSimple( 0,"",default_url,isSecure ,expire_date,expire_date,password);
            siteId = siteSimple.create(site);

            int maxClics = Integer.parseInt(request.getParameter("max_clics"));
            String captcha = request.getParameter("captcha");
            if(captcha.equals("on")){
                captchaStatus = true;
            }


            //Récupération de la session
            HttpSession session= request.getSession(true);

            //Init DAO User
            DAO<User> user = new UserDAO(ConnectionConfiguration.getConnection(getServletContext().getInitParameter("db-url"), getServletContext().getInitParameter("db-user"),
                    getServletContext().getInitParameter("db-password")));

            //Fetch current User
            User currentUser = user.findByKey("email", (String) session.getAttribute("currentSessionUser"));

            //Init SiteUser
            DAO<SiteUser> siteUser = new SiteUserDAO(ConnectionConfiguration.getConnection(getServletContext().getInitParameter("db-url"), getServletContext().getInitParameter("db-user"),
                    getServletContext().getInitParameter("db-password")));

            //Create siteUser Object with form Data
            SiteUser siteUserToCreate = new SiteUser(0, 0, captchaStatus, maxClics, siteId, currentUser.getId());

            //Inserting the siteUser in DB
            int userId = siteUser.create(siteUserToCreate);

        }

        response.sendRedirect("/sites");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
