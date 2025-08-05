package myservletdemos;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@SuppressWarnings("serial")
@WebServlet("/URLRewriting_1")
public class URLRewriting_1 extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");//MIME TYPE
		
		PrintWriter out = response.getWriter();

        String name = request.getParameter("name");
        String roll = request.getParameter("roll");
        
        // URL Rewriting using query string
        String rewrittenURL = "URLReWriting_Success?name123=" + name + "&roll123=" + roll;//Servlet class url pattern
        
        //http://localhost:8090/WIPROServletsDemo2025/URLReWriting_Success?name123=Devi&roll123=11100
        
        out.println("<html><body>");
        out.println("<h2>Hi " + name + "! Click below to continue:</h2>");
        out.println("<a href='" + rewrittenURL + "'>Go to Welcome Page</a>");
        out.println("</body></html>");
        
	}


}
