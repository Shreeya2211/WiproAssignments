package myjavademos;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;

/*
 * 
1.DDL(Data Definition Language)
Create table,alter table,drop table,truncate table,rename table

2.DML(Data Manipulation Language)
insert,update,delete

3.DCL(Data Control Language)
grant , revoke

4.TCL(Transaction Control Language)
commit(save),rollback(undo),savepoint(bookmark)

5.DQL(Data Query Language)
select command
 */
/*
1.The PreparedStatement interface is a subinterface of Statement. It is used to execute parameterized query

2.PreparedStatement is a Java object, which represents a precompiled SQL statement

3.PreparedStatement is usually used for SQL statements that take parameters, although it can also 
execute SQL statements that have no parameters

4.A PreparedStatement is useful when an SQL statement has to be executed multiple times

5.A PreparedStatement is precompiled, hence it is immediately executed by the DBMS, unlike 
Statement, which has to be compiled first
 */
//CRUD OPERATION(CREATE(INSERT),READ(SELECT),UPDATE,DELETE)

public class JDBC_MYSQL_INSERTDemo {
	// SQLException is a checked exception!
	public static void main(String[] args) throws Exception 
{
		//loading the mysql driver
		//drivername is case sensitive
		

		/*
		 * Since JDBC 4.0, explicitly registering the driver is optional. 
		 * We just need to put vender's Jar in the classpath, 
		 * and then JDBC driver manager can detect and load the driver automatically.
		 */

		//classname.methodname=>static method
		//Class.forName("com.mysql.jdbc.Driver");  //type 4 mysql driver

		//3306-DEFAULT mysql port number
		//wipro2025:: mysql database name
		//username:root
		//my password is empty
		Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/wiprotraining","root","1234");
		/*
		 * mysql> select * from wipro_emps;
+------+----------+---------+----------+
| eno  | name     | salary  | dept     |
+------+----------+---------+----------+
| 1001 | Thananya | 34932.3 | HR       |
| 1002 | Abi      | 39932.3 | Training |
| 1003 | Devi     | 89032.3 | HR       |
| 1004 | Sai      | 9000030 | Testing  |
+------+----------+---------+----------+
4 rows in set (0.02 sec)
		 */

		@SuppressWarnings("resource")
		Scanner s1 = new Scanner(System.in);
		System.out.println("Eno:: ");
		int a = s1.nextInt();
		s1.nextLine();
		System.out.println("Name:: ");
		String b = s1.nextLine();
		System.out.println("Salary:: ");
		float c = s1.nextFloat();
		System.out.println("Dept:: ");
		String d = s1.next();

		// RUNTIME INPUT

				// DML,DQL(SELECT)=>PreparedStatement Interface
				/*
				 * A PreparedStatement is a pre-compiled SQL statement ******************The
				 * PreparedStatement interface is a subinterface of Statement. It is used to
				 * execute RUNTIME parameterized query.
				 */
		
		String query1 = "insert into wipro_emps values(?,?,?,?)";// ? is a runtime placeholder for runtime sql values
		PreparedStatement ps1 = con.prepareStatement(query1);// SQL 1
		ps1.setInt(1, a);// 1 refers first question mark
		ps1.setString(2,b);
		ps1.setFloat(3, c);
		ps1.setString(4, d);
		/*
		 * After a Statement has been executed, it returns different kinds of data
		 * depending on the type of execute used
		 * 
		 * 1.execute() returns a boolean value and is used to execute SQL statements
		 * written as a String object
		 * 
		 * 2.executeUpdate() returns an int value pertaining to the number of rows
		 * affected and is used to execute DDL SQL statements EXECUTEUPDATE METHOD
		 * MAINLY FOR DML(INSERT,UPDATE,DELETE) COMMANDS=>Int
		 * 
		 * 3.executeQuery() returns a ResultSet object and is used to execute SELECT SQL
		 * statement
		 */

		int rows = ps1.executeUpdate();
		System.out.println(rows + " Record inserted!");

		PreparedStatement ps11=con.prepareStatement("select * from wipro_emps");//SQL 2
		ResultSet rs=ps11.executeQuery();
		while(rs.next())
		{
			int a1=rs.getInt("eno");
			String b1=rs.getString(2);//2nd column=>name
			float c1=rs.getFloat("salary");
			String d1=rs.getString(4);//dept
			System.out.println(a1+ " "+b1 + " "+c1+ " "+d1);

		}
		rs.close();
		con.close();//release DB connection


		
		
		
		

	}

}
/*
Eno:: 
1005
Name:: 
Vaish
Salary:: 
80000
Dept:: 
Influencing
1 Record inserted!
1001 Abhi 33456.3 HR
1002 Rishi 55456.7 TRAINING
1003 Divi 44456.7 HR
1004 Sai 90456.9 TESTING
1005 Vaish 80000.0 Influencing
*/