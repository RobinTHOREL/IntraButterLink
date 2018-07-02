import com.util.ConnectionConfiguration;

import javax.servlet.RequestDispatcher;
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

@WebServlet(name = "ServletAuth", urlPatterns = "/auth")
public class ServletAuth extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String login = request.getParameter("login");
        String password = request.getParameter("password");

        Connection connection = null;

        try {
            connection = ConnectionConfiguration.getConnection(getServletContext().getInitParameter("db-url"), getServletContext().getInitParameter("db-user"),
                    getServletContext().getInitParameter("db-password"));

            if (connection != null) {
                System.out.println("Connexion OP");
                Statement s = connection.createStatement();
                PreparedStatement pst = connection.prepareStatement("select * from user where password = ? and email = ?");
                pst.setString(1, password);
                pst.setString(2, login);
                ResultSet rs = pst.executeQuery();
                if (rs.next()) {
                    HttpSession session = request.getSession(true);
                    session.setAttribute("currentSessionUser", login);
                    session.setAttribute("currentSessionId", rs.getString("id"));
                    response.sendRedirect("/welcome");
                }
                else {
                    System.out.println("can't login");
                    response.sendRedirect("/login");
                }
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
