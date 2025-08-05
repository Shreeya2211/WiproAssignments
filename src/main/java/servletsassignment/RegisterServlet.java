package servletsassignment;

import java.io.*;
import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

@SuppressWarnings("serial")
@WebServlet("/register")
public class RegisterServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        String name = request.getParameter("name");
        String email = request.getParameter("email");
        String gender = request.getParameter("gender");
        String course = request.getParameter("course");

        out.println("<html><body>");
        out.println("<h2>Student Registration Details</h2>");
        out.println("<p><strong>Name:</strong> " + name + "</p>");
        out.println("<p><strong>Email:</strong> " + email + "</p>");
        out.println("<p><strong>Gender:</strong> " + gender + "</p>");
        out.println("<p><strong>Course:</strong> " + course + "</p>");
        out.println("</body></html>");
    }
}
