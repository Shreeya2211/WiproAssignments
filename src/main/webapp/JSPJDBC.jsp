<%@page import="java.sql.*,dbutilities.DBConnectionFactory_MYSQL" %>

<%
		  try
		  {
	 	     
			 //LOADING DB CONNECTION FROM EXTERNAL FILE
			  //NO CLASS.FORNAME & DRIVERMANAGER CLASSES!!!!!!!!!!!!!!!!!!!!!!
			  Connection con=DBConnectionFactory_MYSQL.mydbconnect_123();
		      Statement s = con.createStatement();
	 	     ResultSet rs=s.executeQuery("select * from wipro_emps");
		  	 		  out.println("<table border=6 bgcolor=pink "
	 			  		+ "align=center bordercolor=red>"
	 			  		+ "<tr><th>Eno</th><th>EmpName</th>"
	 			  		+ "<th>Salary</th><th>Dept</th></tr>");
  
	 	     while(rs.next())
	 	 	    	 	    {
	 	 	 	    out.println("<tr>");
	 	 	 	    out.println("<td>"+rs.getInt(1));
	 	 	 	    out.println("<td>"+rs.getString(2));
	 	 	 	    out.println("<td>"+rs.getFloat(3));
	 	 	 	    out.println("<td>"+rs.getString(4)); 	 	 	    
	 	 	 	    out.println("</tr>"); 	 	
	 	 	 	    }
	 	 		  out.println("</table>");
	 	 	 	    rs.close();
	 	 	 	    s.close();
	 	 	 	    con.close(); 	 	 

	 	 	    
	 	  }
		  catch(Exception e)
		  {
			  e.printStackTrace();
		  }
		  
%>                
		  