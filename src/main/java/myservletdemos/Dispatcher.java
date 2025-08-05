package myservletdemos;
/*
 * In Java Servlets, setAttribute and getAttribute are used to share data (objects) between 
 * different components of a web application like Servlets, JSPs, and Filters.

These methods are available in:
1.HttpServletRequest Interface
2.HttpSession Interface
3.ServletContext Interface

Each one has a different scope.

1. Request Scope – request.setAttribute()
Lifespan: Only valid for that single request.

Used for: Passing data from one servlet to another via forward or to a JSP.

2.Session Scope – session.setAttribute()
Lifespan: Until session times out or is invalidated.

Used for: Tracking user-specific data across multiple requests.

3.Application Scope – context.setAttribute()
Lifespan: As long as the server is running.

Used for: Sharing global data among all users and all components.
 */
import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@SuppressWarnings("serial")
@WebServlet("/Dispatcher")
public class Dispatcher extends HttpServlet {
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");//MIME TYPE
		
		String eno1= request.getParameter("e1");
		String name1= request.getParameter("n1");
		String salary1= request.getParameter("s1");
		String dept1= request.getParameter("d1");
	
		//SHARING THE DATA FROM ONE SERVLET TO ANOTHER SERVLET!
		//SETTING ALL FORM VALUES TO ANOTHER SERVLET BY USING SETATTRIBUTE()
	
		request.setAttribute("EmployeeNumber", eno1);//attributename,attributevalue
		request.setAttribute("EmployeeName", name1);
		request.setAttribute("EmployeeSalary", salary1);
		request.setAttribute("EmployeeDept", dept1);
		
		//collaborating to another servlet
		ServletContext context= getServletContext();
		RequestDispatcher rd= context.getRequestDispatcher("/Dispatcher_Data");//servlet url pattern=>DOPOST METHOD
		rd.forward(request, response);

	}

}