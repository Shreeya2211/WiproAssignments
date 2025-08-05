/*
 * 51.Create a Java program to connect to a MySQL database and retrieve all student records from a Student table using JDBC. 
 * Display each student's ID, name, age, course, and marks.

 */
package myassignments;
import java.sql.*;

public class Exercise51
{

    public static void main(String[] args)
    {
        String url = "jdbc:mysql://localhost:3306/wiprotraining";
        String user = "root"; 
        String password = "1234"; 

        String query = "SELECT id, name, age, course, marks FROM Student";

        try
        (
            Connection conn = DriverManager.getConnection(url, user, password);
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(query);
        ) 
        {
            System.out.println("ID\tName\tAge\tCourse\tMarks");

            while (rs.next()) 
            {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                int age = rs.getInt("age");
                String course = rs.getString("course");
                float marks = rs.getFloat("marks");

                System.out.printf("%d\t%s\t%d\t%s\t%.2f%n", id, name, age, course, marks);
            }

        }
        catch (SQLException e) 
        {
            System.err.println("Database error: " + e.getMessage());
        }
    }
}
/*
ID	Name	Age	Course	Marks
1	Alice	20	Computer Science	88.50
2	Bob	21	Mathematics	76.00
3	Charlie	22	Physics	91.20
4	David	23	IT	84.30
5	Eva	20	Electronics	79.40
*/
