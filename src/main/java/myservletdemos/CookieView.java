package myservletdemos;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@SuppressWarnings("serial")
@WebServlet("/CookieView")

public class CookieView extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		  response.setContentType("text/html");
	        PrintWriter out = response.getWriter();

	        Cookie[] cookies = request.getCookies();


	        if (cookies != null) 
	        {
	            out.println("<h2>Student Details from Cookies:</h2>");
	            for (Cookie c : cookies) 
	            {
	                out.println("<p>" + c.getName() + ": " + c.getValue() + "</p>");
	            }
	        } 
	        else 
	        {
	            out.println("<h2>No cookies found!</h2>");
	        }

	}

}
