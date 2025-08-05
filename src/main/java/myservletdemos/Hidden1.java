package myservletdemos;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/*
 * Session Management is the process of maintaining state (user data) across multiple requests 
 * from the same user (browser) in a stateless protocol like HTTP.

Why Session Management?

HTTP is stateless: Each request is independent.

Web applications often need to remember users across requests (e.g., login, shopping cart).


| Method                    | Description                                                    |
| ------------------------- | -------------------------------------------------------------- |
| 1. **Cookies**            | Stores small key-value data on the client (browser).           |
| 2. **URL Rewriting**      | Appends session ID to URL when cookies are disabled.           |
| 3. **Hidden Form Fields** | Stores data in hidden HTML fields submitted in forms.          |
| 4. **HttpSession API**    | Built-in Servlet API to handle server-side session management. |

 */
@SuppressWarnings("serial")
@WebServlet("/Hidden1")
public class Hidden1 extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");//MIME TYPE
		
		PrintWriter out=response.getWriter();
		out.println("<h1>First Hidden: "+request.getParameter("com_name"));
		out.println("Second Hidden: "+request.getParameter("location"));
	
	
		   out.println("<form method=post action=Hidden1>");//doPost()
		   out.println("<input type=hidden name=training value=Java>");
		   out.println("<input type=hidden name=Qualification value=B.E>");
		   out.println("<input type=submit value=View>");

	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out=response.getWriter();
		
	    out.println("<h1>Third Hidden: "+request.getParameter("training"));
out.println("Fourth Hidden: "+request.getParameter("Qualification"));


	}



}
