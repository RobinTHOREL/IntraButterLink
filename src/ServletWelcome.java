import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.Connection;
import java.sql.Statement;

@WebServlet(name = "ServletWelcome", urlPatterns = "/welcome")
public class ServletWelcome extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        HttpSession session = request.getSession(true);
        String currentSession = (String) session.getAttribute( "currentSessionUser" );

        if ( currentSession == null )
            currentSession = "";

        String message = "Bienvenu sur butterlink " + currentSession;
        request.setAttribute( "test", message );

        this.getServletContext().getRequestDispatcher( "/WEB-INF/views/welcome.jsp" ).forward( request, response );
    }
}
