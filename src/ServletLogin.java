import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "ServletLogin", urlPatterns = "/login")
public class ServletLogin extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        HttpSession s = request.getSession();

        out.println("" +
                "<!DOCTYPE html>\n" +
                "<html lang=\"en\">\n" +
                "\n" +
                "<head>\n" +
                "  <meta charset=\"UTF-8\">\n" +
                "  <title>Login</title>\n" +
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
                "  <div class=\"container\">\n" +
                "    <div class=\"jumbotron\" style=\"margin-top: 75px;\">\n" +
                "      <h1 class=\"display-4 text-center\">Login</h1>\n" +
                "      <form class=\"col-md-8 offset-md-2\" action=\"/auth\" method=\"post\">\n" +
                "        <div class=\"form-group\">\n" +
                "          <label for=\"name\">Login</label>\n" +
                "          <input type=\"text\" name=\"login\" class=\"form-control\" id=\"login\" placeholder=\"Login\">\n" +
                "        </div>\n" +
                "          <div class=\"form-group\">\n" +
                "            <label for=\"password\">Mot de passe</label>\n" +
                "            <input type=\"password\" name=\"password\" class=\"form-control\">\n" +
                "          </div>\n" +
                "        <button type=\"submit\" class=\"btn btn-primary\">Valider</button>\n" +
                "      </form>\n" +
                "    </div>\n" +
                "  </div>\n" +
                "</body>\n" +
                "<script src=\"https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js\" integrity=\"sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q\" crossorigin=\"anonymous\"></script>\n" +
                "<!--  Boostratp/js\n" +
                "<script src=\"https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js\" integrity=\"sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl\" crossorigin=\"anonymous\"></script>\n" +
                "-->\n" +
                "<script src=\"boosted/dist/js/boosted.js\"></script>\n" +
                "<script src=\"https://code.jquery.com/jquery-1.12.4.js\"></script>\n" +
                "<script src=\"https://code.jquery.com/ui/1.12.1/jquery-ui.js\"></script>\n" +
                "<script>\n" +
                "    $( function() {\n" +
                "        $( \"#datepicker\" ).datepicker();\n" +
                "    } );\n" +
                "\n" +
                "    $(document).ready(function(){\n" +
                "        $('#datepicker').attr(\"placeholder\", Date('Y:m:d'));\n" +
                "    });\n" +
                "\n" +
                "</script>\n" +
                "</html>");
    }
}
