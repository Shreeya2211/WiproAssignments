package servletsassignment;

import java.io.*;
import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

@SuppressWarnings({ "unused", "serial" })
@WebServlet("/ProductServlet")
public class ProductServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String[] data = request.getParameter("product").split(":");
        String productName = data[0];
        String productPrice = data[1];

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        out.println("<html><body>");
        out.println("<h2>Enter Quantity for: " + productName + "</h2>");
        out.println("<form action='OrderServlet' method='post'>");
        out.println("Quantity: <input type='number' name='quantity' required><br><br>");
        out.println("<input type='hidden' name='productName' value='" + productName + "'>");
        out.println("<input type='hidden' name='productPrice' value='" + productPrice + "'>");
        out.println("<input type='submit' value='Generate Receipt'>");
        out.println("</form>");
        out.println("</body></html>");
    }
}
