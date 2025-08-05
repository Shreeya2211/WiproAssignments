package myservletdemos;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@SuppressWarnings("serial")
@WebServlet("/URLRewriting_Success")
public class URLRewriting_Success extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");//MIME TYPE
		
		PrintWriter out = response.getWriter();

        String name_1 = request.getParameter("name123");//extracting the value from the query parameter
        String roll_1 = request.getParameter("roll123");//extracting the value from the query parameter

        out.println("<html><body>");
        out.println("<h1>Welcome " + name_1 + "!</h1>");
        out.println("<p>Your Roll No: " + roll_1 + "</p>");
        out.println("</body></html>");
	}


}
