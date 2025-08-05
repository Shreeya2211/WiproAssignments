package myservletdemos;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@SuppressWarnings("serial")
@WebServlet("/Dispatcher_Data")

public class Dispatcher_Data extends HttpServlet {
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");//MIME TYPE
		
		PrintWriter out= response.getWriter();
		
		String a=(String)request.getAttribute("EmployeeNumber");
		String b=(String)request.getAttribute("EmployeeName");
		String c=(String)request.getAttribute("EmployeeSalary");
		String d=(String)request.getAttribute("EmployeeDept");
		out.println("<h1>EmpDetails: "+a + " "+b + " "+c + " "+d);

		out.println("<h1>Dispatcher_Data Servlet=>Data Sharing Happens Successfully");

	}

}
