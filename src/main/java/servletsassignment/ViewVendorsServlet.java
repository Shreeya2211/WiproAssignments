package servletsassignment;

import java.io.*;
import java.sql.*;
import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

@SuppressWarnings("serial")
@WebServlet("/ViewVendorsServlet")
public class ViewVendorsServlet extends HttpServlet 
{

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException
    {

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        // JDBC connection info
        String jdbcURL = "jdbc:mysql://localhost:3306/wiprotraining"; // replace with your DB name
        String dbUser = "root";
        String dbPass = "1234"; // replace with your password

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection conn = DriverManager.getConnection(jdbcURL, dbUser, dbPass);

            String sql = "SELECT * FROM vendors";
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);

            out.println("<h2>Vendor List</h2>");
            out.println("<table border='1'>");
            out.println("<tr><th>ID</th><th>Name</th><th>Email</th><th>City</th></tr>");

            while (rs.next()) 
            {
                out.println("<tr>");
                out.println("<td>" + rs.getInt("id") + "</td>");
                out.println("<td>" + rs.getString("name") + "</td>");
                out.println("<td>" + rs.getString("email") + "</td>");
                out.println("<td>" + rs.getString("city") + "</td>");
                out.println("</tr>");
            }

            out.println("</table>");

            conn.close();
        } catch (Exception e)
        {
            out.println("<p>Error: " + e.getMessage() + "</p>");
            e.printStackTrace(out);
        }
    }
}
