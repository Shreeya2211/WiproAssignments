package servletsassignment;

import java.io.*;
import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

@SuppressWarnings("serial")
@WebServlet("/BalanceServlet")
public class BalanceServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        HttpSession session = request.getSession(false);

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        if (session != null && session.getAttribute("name") != null) {
            String name = (String) session.getAttribute("name");
            double balance = (double) session.getAttribute("balance");

            out.println("<h2>Welcome, " + name + "</h2>");
            out.println("<p>Your Account Balance: ₹" + balance + "</p>");
            out.println("<a href='LogoutServlet'>Logout</a>");
        } else {
            out.println("<h3>Session expired or not logged in.</h3>");
            out.println("<a href='login1.html'>Login Again</a>");
        }
    }
}
