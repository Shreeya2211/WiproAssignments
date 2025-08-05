package myservletdemos;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dbutilities.DBConnectionFactory_MYSQL;

//JDBC(MYSQL) + SERVLET INTEGRATION:::

//D:\apache-tomcat-10.1.17-windows-x64\apache-tomcat-10.1.17\lib=>COPY THE MYSQL CONNECTOR JAR

//RESTART AND REFRESH THE PROJECT/SERVER.

@SuppressWarnings("serial")
@WebServlet("/DisplayRecords")

public class JDBCServletDisplayRecords extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response)			throws ServletException, IOException 
	{
		response.setContentType("text/html");//MIME TYPE
		
		 	try
		{
			//LOADING DB CONNECTION FROM EXTERNAL FILE
			  //NO CLASS.FORNAME & DRIVERMANAGER CLASSES!!!!!!!!!!!!!!!!!!!!!!
			  Connection con=DBConnectionFactory_MYSQL.mydbconnect_123();
		      Statement s = con.createStatement();
		     ResultSet rs=s.executeQuery("select * from wipro_emps");
		     PrintWriter pw=response.getWriter();//to display output in browser window
		     pw.println("<table border=6 bgcolor=pink "
				  		+ "align=center bordercolor=red>"
				  		+ "<tr><th>Eno</th><th>EmpName</th>"
				  		+ "<th>Salary</th><th>Dept</th></tr>");

		     while(rs.next())
		 	    {
	pw.println("<tr>");
	pw.println("<td>"+rs.getInt(1));//first column in your mysql table
	pw.println("<td>"+rs.getString("name"));
	pw.println("<td>"+rs.getFloat("salary"));
	pw.println("<td>"+rs.getString(4)); //dept	 	 	    
	pw.println("</tr>"); 	 	
	}
	pw.println("</table>");
	rs.close();
	s.close();
	con.close(); 	 	 

			}
			  catch(Exception e)
			  {
				  e.printStackTrace();
			  }
	}

}
