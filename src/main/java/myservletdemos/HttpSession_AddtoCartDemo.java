package myservletdemos;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import mysessiondemos.Product;
/*
 * HttpSession is an interface in the Servlet API used to maintain state between multiple requests 
 * from the same user (client) across multiple pages. It's a key part of session management in web applications.
 * 
 * | Method                                    | Description                            |
| ----------------------------------------- | -------------------------------------- |
| `getSession()`                            | Returns current session or creates one |
| `getAttribute(String name)`               | Retrieves an attribute from session    |
| `setAttribute(String name, Object value)` | Stores an object in the session        |
| `removeAttribute(String name)`            | Removes an attribute                   |
| `invalidate()`                            | Destroys the session                   |
| `getId()`                                 | Returns unique session ID              |
| `getCreationTime()`                       | Returns when session was created       |
| `getLastAccessedTime()`                   | Returns last access time               |
| `isNew()`                                 | Checks if the session is new           |


getSession():

If a session already exists, it returns the existing session.

If there is no session, it creates a new one.

Value	Behavior
true	Returns current session, or creates a new one if none exists
false	Returns current session, or returns null if none exists

 */
@SuppressWarnings("serial")
@WebServlet("/HttpSession_AddtoCartDemo")

public class HttpSession_AddtoCartDemo extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		        
        
	}

	@SuppressWarnings({ "unchecked" })
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");//MIME TYPE
		String name = request.getParameter("name");
        double price = Double.parseDouble(request.getParameter("price"));
        
        Product product = new Product(name, price);//Product.java
        
        HttpSession session = request.getSession();//request.getSession(true);=>both are same
        
        List<Product> cart12 = (List<Product>) session.getAttribute("mycart");

        if (cart12 == null)//for the first time
        {
            cart12 = new ArrayList<>();
            session.setAttribute("mycart", cart12);//adding the product object into session
        }

        cart12.add(product);
        
        PrintWriter out = response.getWriter();
        out.println("<h2>Product added to cart</h2>");
        out.println("<a href='HttpSession_ViewCart'>View Cart</a><br>");//servlet class url pattern
        out.println("<a href='Shopping.html'>Continue Shopping</a>");

	}

}
