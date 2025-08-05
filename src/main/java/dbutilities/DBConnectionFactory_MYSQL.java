package dbutilities;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnectionFactory_MYSQL 
{

	public static Connection mydbconnect_123()
	{
	Connection con=null;
	try
	{
		//Class.forName("com.mysql.cj.jdbc.Driver");  //type 4 mysql driver
		//3306-mysql port number
		//wipro2025 database name
		con=DriverManager.getConnection("jdbc:mysql://localhost:3306/wiprotraining","root","1234");
	}
	catch(Exception e)
	{
	System.out.println("Connection Failed! Check console!"+e);	
	}
	if(con!=null)
	{
		System.out.println("DB Connection success!");
	}
	else
	{
		System.out.println("DB Connection Failed!");
	}
	return con;//return database connection

}
}