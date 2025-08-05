package myservletdemos;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import mysessiondemos.Product;
@SuppressWarnings("serial")
@WebServlet("/HttpSession_ViewCart")

public class HttpSession_ViewCart extends HttpServlet {
	@SuppressWarnings("unchecked")
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");//MIME TYPE
		
		HttpSession session = request.getSession(false);//false	Returns current session, or returns null if none exists

		PrintWriter out = response.getWriter();

        if (session == null || session.getAttribute("mycart") == null) 
        {
            out.println("<h2>No items in your cart.</h2>");
            return;
        }
        
        List<Product> cart = (List<Product>) session.getAttribute("mycart");
        out.println("<h2>Your Shopping Cart:</h2>");
        double total = 0;

        for (Product p : cart) 
        {
            out.println("Product: " + p.getName() + " | Price: ₹" + p.getPrice() + "<br>");
            total += p.getPrice();
        }
        out.println("<hr>Total: ₹" + total + "<br>");
        

out.println("<form action=HttpSession_logout method=get>");
 out.println("<input type=submit value=Logout></form>");
             
        out.println("<a href='Shopping.html'>Continue Shopping</a>");
        
		
	
	}


}
