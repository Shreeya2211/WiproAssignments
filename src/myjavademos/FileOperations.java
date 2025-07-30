package myjavademos;

import java.io.File;

/*
 * character streams:::
 * 
--Read and write 16-bit Unicode characters
--Reader and Writer
--Should be used for reading/writing text information

byte streams :::

--Read and write 8-bit (= 1 byte) characters
--InputStream and OutputStream
--Should be used for reading/writing images or sound files
--**********************Used for Object serialization
 */
/*
 * Character Stream:: Reader and Writer(Abstract classes)
 * Byte Stream:: OutputStream and InputStream(Abstract classes)
 */

public class FileOperations {

	public static void main(String[] args) throws Exception
	{
		// TODO Auto-generated method stub
		
		//to access the existing  text file=> File class!
		
		//d:\=>invalid java =>\n\t

		File obj1=new File("D:\\WIPRO\\WIPRO.TXT");
		@SuppressWarnings("unused")
		File obj3=new File("D:/WIPRO/WIPRO.TXT");
		

		//file properties
		System.out.println("Filename:: "+obj1.getName());
		System.out.println("Path:: "+obj1.getAbsolutePath());
		System.out.println("Exists? :: "+obj1.exists());
		System.out.println("Hidden file??????????????? "+obj1.isHidden());
		System.out.println("Directory::: "+obj1.isDirectory());//is this a folder?
		System.out.println("File::: "+obj1.isFile());
		System.out.println("File Size::: "+obj1.length());//size in terms of bytes
		System.out.println("Write Permission??? ::: "+obj1.canWrite());

		//create a text file from Java
		File f2=new File("D:\\WIPRO\\today12344.txt");//valid
		f2.createNewFile();//IOException-checked exception

		File f3=new File("D:\\WIPRO\\todayupdate44.txt");//valid
		if(f2.exists())//today12344.TXT
		{
			f2.renameTo(f3);//RENAMING A FILE
			System.out.println("File Renamed Successfully");
		}

		File f4=new File("D:\\wipro\\Lab_222222\\Lab_333333");//valid
		if(f4.mkdirs())//folders::make directories
		{
			System.out.println("Directory Created Successfully!");
		}
		else//if directory already exists
		{
			System.out.println("Directory Not Created!");
		}
		
		//user.dir:: it is one of the built in property key=>produce current path 
		System.out.println("Path::: "+System.getProperty("user.dir"));//Path of the Current Eclipse Project

		//Creating text file in eclipse project
		File  s1=new File(System.getProperty("user.dir")+ "\\src\\" +"EmployeeData.txt");
		s1.createNewFile();
		System.out.println("Eclipse Text File Exists? :: "+s1.exists());

		
	}

}
/*
Filename:: WI_THURSDAY.TXT
Path:: D:\WIPRO2025\WI_THURSDAY.TXT
Exists? :: true
Hidden file??????????????? false
Directory::: false
File::: true
File Size::: 180
Write Permission??? ::: true
File Renamed Successfully
Directory Not Created!
Path::: C:\Users\Administrator\eclipse-workspace\JavaWiproDemos2025
Eclipse Text File Exists? :: true
*/