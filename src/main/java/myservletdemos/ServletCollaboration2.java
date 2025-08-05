package myservletdemos;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@SuppressWarnings("serial")
@WebServlet("/ServletCollaboration2")
public class ServletCollaboration2 extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");//MIME TYPE
		
		PrintWriter obj=response.getWriter();
		
		//NO SERVLETCONTEXT OBJECT
		
		RequestDispatcher rs=request.getRequestDispatcher("Login.html");//ServletRequest / is optional for url
		
		@SuppressWarnings("unused")
		RequestDispatcher rs1=request.getRequestDispatcher("/Wipro_UpdateEmployee");//valid / is not mandatory
		
		if(rs!=null)
		{
			rs.include(request, response);
		}
		obj.println("<h1><p>Current Servlet Running!");//this code will not be displayed in forward()

	}


}
