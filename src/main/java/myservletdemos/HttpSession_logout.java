package myservletdemos;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
@SuppressWarnings("serial")
@WebServlet("/HttpSession_logout")
public class HttpSession_logout extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession(false);
        if (session != null) 
        {
            session.invalidate();//expire/destroy the session
        }

        response.setContentType("text/html");
        response.getWriter().println("<h3>You have been logged out successfully.</h3>");
        response.getWriter().println("<a href='Shopping.html'>Login Again</a>");
	}

	
}
