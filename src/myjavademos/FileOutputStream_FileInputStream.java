package myjavademos;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;

//BYTE STREAM PROGRAM

public class FileOutputStream_FileInputStream {

	public static void main(String[] args)throws Exception {
		//1.Fileoutputstream will create a runtime text file
		//2.Write operation
		//Byte Stream

		FileOutputStream obj=new FileOutputStream("D:\\WIPRO\\wipro.txt");//Unhandled exception type FileNotFoundException
		String str="Good Day!";
		obj.write(str.getBytes());//convert String to bytes
		System.out.println("File Created and Data Written into file!");
		obj.close();//closing the write mode!

		//Read Operation
		File f1=new File("D:\\WIPRO\\Wipro.txt");//valid
		if(!f1.exists() || f1.length()<0)
		{
			System.out.println("File Not Exists! File Empty!");
		}
		else
		{
			FileInputStream f4=new FileInputStream(f1);//Object of File Class
			int i;//bcos it is a ByteStream
			while((i=f4.read())!=-1)//UNTIL IT REACHES END OF FILE(EOF)
			{
				System.out.print((char)i);
			}
			f4.close();//closing the read stream!!!!!!!!!!!!!!!!!!
			
		}

	}

}
/*
 * File Created and Data Written into file!
One learns from books and example only that certain things can be done. Actual learning requires that you do those things.
Recipes tell you nothing. Learning techniques is the key
*/
