package servletsassignment;

import java.io.*;
import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

@SuppressWarnings("serial")
@WebServlet("/AddToCartServlet1")
public class AddToCartServlet1 extends HttpServlet {
    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        String item = request.getParameter("item");
        if (item != null && !item.isEmpty()) {
            Cookie cookie = new Cookie("item" + System.currentTimeMillis(), item);
            cookie.setMaxAge(60 * 60); // 1 hour
            response.addCookie(cookie);
        }

        out.println("<h3>" + item + " added to cart!</h3>");
        out.println("<a href='addtocart1.html'>Add More</a><br>");
        out.println("<a href='ViewCartServlet'>View Cart</a>");
    }
}
