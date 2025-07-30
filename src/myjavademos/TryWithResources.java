package myjavademos;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

/*
 * Older approach to close the resources:::
 * 
This is an older approach that we used to handle file related operations.
Notice, we manually closed the resource using close() method.
 */
/*JDK 8 FEATURE::
 * a try with resources is a feature of Java which was added into Java 7. 
 * It helps to close all the resources declared within try block. 
 * It automatically closes the resources after being used. 
 * A resource can be any file or a database connection.
For example, if we are working with File handing then after opening a file, 
it requires to be closed after reading or writing data. 
In early versions of Java, we have to explicitly close the resource, 
but from Java 7, we don’t need to worry about to close the resources.
*/

/*
 * 1.Objects declared in a try with resources statement have scope within the 
 * try block, 
 * but not the catch and finally blocks.
   2.The close() method of objects declared in a try with resources 
   block is invoked regardless of whether an exception is thrown 
   during execution.
 */
/*
 * The try-with-resources statement does automatic resource management. 
 * We need not explicitly close the resources as JVM automatically closes them. 
 * This makes the code more readable and easier to write.
 */
/*
 * 1.In a try-with-resources statement, catch or finally block executes 
 * after closing of the declared resources.
 2.You can use catch and finally blocks with try-with-resources statement 
 just like an ordinary try statement.
 */
/*
 * Purpose of try-with-resources
Avoid memory leaks (resources like files, DB connections must be closed).

Cleaner code (no need for finally block to close resources).

Exception-safe: Closes resources even if an exception occurs.

*******************No need to manually close Connection, Statement, or ResultSet.
 */

public class TryWithResources {

	public static void main(String[] args) {
		System.out.println("TRY WITH RESOURCE(FILE,DATABASE)::");
		
		try(Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/wiprotraining","root","1234");  //CALLING con.close()
	            Statement stmt=con.createStatement();  //st.close()
	            ResultSet rs=stmt.executeQuery("select * from wipro_emps");  //rs.close()
	            )
	        {  
	            while(rs.next())
	            {    
	                System.out.println(rs.getInt(1)+""+rs.getString(2)+""+rs.getString(4)+ " "+rs.getFloat(3));    
	            }  
	        }  
	        catch(Exception e)
			{    
	            System.out.println(e);  
	        }
			finally
			{
				System.out.println("Done!");
			}



	}

}
/*
TRY WITH RESOURCE(FILE,DATABASE)::
1001ThananyaHR 34932.3
1002AbiTraining 39932.3
1003DeviHR 89032.3
1004SaiTesting 9000030.0
Done!
*/
/* 
 TRY WITH RESOURCE(FILE,DATABASE)::
1001AbhiHR 33456.3
1002RishiTRAINING 55456.7
1003DiviHR 44456.7
1004SaiTESTING 90456.9
Done!
*/
