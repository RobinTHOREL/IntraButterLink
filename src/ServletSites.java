import com.dao.DAO;
import com.dao.implement.SiteSimpleDAO;
import com.dao.implement.SiteUserDAO;
import com.dao.src.SiteSimple;
import com.dao.src.SiteUser;
import com.util.ConnectionConfiguration;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

@WebServlet(name = "ServletSites", urlPatterns = "/sites")
public class ServletSites extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession(true);
        String currentSession = (String) session.getAttribute( "currentSessionUser" );
        String currentId = (String) session.getAttribute("currentSessionId");

        if ( currentSession == null )
            currentSession = "";

        System.out.println("session : " + currentSession + "  id : " + currentId);

        DAO<SiteUser> sitesUser = new SiteUserDAO(ConnectionConfiguration.getConnection(getServletContext().getInitParameter("db-url"), getServletContext().getInitParameter("db-user"),
                getServletContext().getInitParameter("db-password")));

        sitesUser.findByKey("user_id", currentId);

        System.out.println(sitesUser.toString());

        this.getServletContext().getRequestDispatcher( "/WEB-INF/views/sites.jsp" ).forward( request, response );
    }
}
