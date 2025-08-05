package myservletdemos;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
/*
 * HTTP Status Code
The Server issues an HTTP Status Code in response to a request of the client 
made to the server. Status code is a 3-digit integer. 

1	1xx: Informational Response
	It is used to show that the request was received, and the process is continuing.
2	2xx: Successful
	It is used to show that the request was successfully received, understood, and accepted.
3	3xx: Redirection
	It is used to show that further action needs to be taken to complete the request.
4	4xx: Client Error
	It is used to show that the request contains bad syntax or cannot be fulfilled.
5	5xx: Server Error
	It is used to show that the server is failed to fulfill an apparently valid request.
 */
@SuppressWarnings("serial")
@WebServlet("/Redirect_Page")
public class Redirect_Page extends HttpServlet {
	
	@SuppressWarnings("static-access")
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");//MIME TYPE
		
		String d=request.getParameter("mail");//name of the radio button
		//SC stands for Status code!!
		if(d.equals("unknown"))
		{
			//response.sendError(404,"Link not available.. Please contact Network administrator!");
			response.sendError(response.SC_NOT_FOUND,"Link not available.. Please contact Network administrator!");
		}
		else
		{
		response.sendRedirect(d);//success-200 status code!
		response.setStatus(response.SC_OK);//optional
		}
		

	}


}
