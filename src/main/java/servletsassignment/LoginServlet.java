package servletsassignment;


import java.io.*;
import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

@SuppressWarnings("serial")
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String accNo = request.getParameter("accNo");
        String password = request.getParameter("password");

        // Mock account details
        if (accNo.equals("123456") && password.equals("pass123")) {
            HttpSession session = request.getSession();
            session.setAttribute("name", "Shreeya Chirra");
            session.setAttribute("balance", 50000.0);
            response.sendRedirect("BalanceServlet");
        } else {
            response.setContentType("text/html");
            PrintWriter out = response.getWriter();
            out.println("<h3>Invalid credentials. Please try again.</h3>");
            out.println("<a href='login1.html'>Go back</a>");
        }
    }
}
