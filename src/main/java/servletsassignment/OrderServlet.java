package servletsassignment;

import java.io.*;
import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

@SuppressWarnings({ "unused", "serial" })
@WebServlet("/OrderServlet")
public class OrderServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String name = request.getParameter("productName");
        double price = Double.parseDouble(request.getParameter("productPrice"));
        int quantity = Integer.parseInt(request.getParameter("quantity"));
        double total = price * quantity;

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        out.println("<html><body>");
        out.println("<h2>Receipt</h2>");
        out.println("Product: " + name + "<br>");
        out.println("Price: ₹" + price + "<br>");
        out.println("Quantity: " + quantity + "<br>");
        out.println("<strong>Total: ₹" + total + "</strong>");
        out.println("</body></html>");
    }
}
