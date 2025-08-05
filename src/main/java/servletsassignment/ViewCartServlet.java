package servletsassignment;

import java.io.*;
import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

@SuppressWarnings("serial")
@WebServlet("/ViewCartServlet")
public class ViewCartServlet extends HttpServlet {
    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        Cookie[] cookies = request.getCookies();

        out.println("<h2>Your Cart Items:</h2>");
        boolean found = false;
        if (cookies != null) {
            for (Cookie c : cookies) {
                if (c.getName().startsWith("item")) {
                    out.println("<li>" + c.getValue() + "</li>");
                    found = true;
                }
            }
        }

        if (!found) {
            out.println("<p>Your cart is empty.</p>");
        }

        out.println("<br><a href='addtocart1.html'>Add More Items</a>");
    }
}
