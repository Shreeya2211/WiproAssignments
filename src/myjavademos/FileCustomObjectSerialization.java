
package myjavademos;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

/*
 * Serialization in Java is the process of converting an object into a byte stream, so it can be:

✅ Saved to a file

📤 Sent over a network

🧠 Stored in memory or cache

🔁 Recreated later (deserialization)

What is Serialization?
To persist the state of an object and reconstruct it later.

| Purpose                         | Explanation                                                               |
| ------------------------------- | ------------------------------------------------------------------------- |
| 📁 **Persistence**              | Save an object’s state to a file or database                              |
| 🌐 **Communication**            | Send objects between systems via sockets (networking, RMI)                |
| ♻️ **Deep Cloning**             | Create deep copies of complex objects                                     |
| ☁️ **Caching**                  | Store objects in memory or disk and reuse later                           |
| 🔃 **Distributed applications** | Used in frameworks like **RMI, EJB, JMS, Hibernate, Spring, Kafka**, etc. |



 */
//NotSerializableException thrown if the class does not implement Serializable interface!
/*
* 1.Serializable interface does not have ANY METHODS!!!(""MARKER INTERFACE"")
	public interface Serializable
	{
	}
2.this interface NOTIFY the JVM to perform serialization!
3.*********Only objects marked SERIALIZABLE can be persisted into text file !!	
*/

@SuppressWarnings("serial")
class Book  implements Serializable//marker interface--now this class eligible for SERIALIZATION
{
	//transient modifier=>ignore the variable during serialization!!!!
		//ex:password fields(OTP)

	//String ISBN;//non transient variable
	 transient String ISBN;//cannot be serialized in text file, so null is displayed

	String bookname;
	String author;
	public Book(String iSBN, String bookname, String author) 
	{
		super();
		ISBN = iSBN;
		this.bookname = bookname;
		this.author = author;
	}
	@Override
	public String toString() 
	{
		return "Book [ISBN=" + ISBN + ", bookname=" + bookname + ", author=" + author + "]";
	}
	
}
public class FileCustomObjectSerialization {
	/*
	 *Serialization(Marshalling):: Saving or writing the OBJECT in a TEXT FILE
	 *Deserialization(Unmarshalling):: Restoring the SAME OBJECT again from the text file 
	 */
	/*
	 * ByteStream Category::::=>ObjectInputStream(ReadObject) and ObjectOutputStream(WriteObject) classes 
	 * used for SERIALIZATION!
	 */

	public static void main(String[] args)throws Exception {
		Book b1=new Book("5653-565-565","Java Complete Reference","Thananya");
		Book b2=new Book("5653-565-561","JSP Complete Reference","Abi");
		Book b3=new Book("5653-565-566","Jython Complete Reference","Surya");
		
		//.ser,.dat,.txt=>serialization file extension		

		//Write Object into text file
		FileOutputStream obj=new FileOutputStream("D:\\WIPRO\\Books.ser");//create a text file
		ObjectOutputStream b11=new ObjectOutputStream(obj);
		b11.writeObject(b1);//Serialization(saving/writing object)
		b11.writeObject(b2);//Serialization(saving object)
		b11.writeObject(b3);//Serialization(saving object)
		
		
		System.out.println("Book Data Serialized or Persisted!");		
		b11.close();
		
		//Read Object
		FileInputStream obj1=new FileInputStream("D:\\WIPRO\\Books.ser");
		ObjectInputStream b12=new ObjectInputStream(obj1);
		Book b6;
		while(obj1.available() != 0)//read more than one object
		{
			b6 = (Book) b12.readObject();//Deserialization(restoring object)
			System.out.println("Data Deserialized:: "+b6.toString());//output
		}			
		b12.close();

	}

}
/*
Book Data Serialized or Persisted!
Data Deserialized:: Book [ISBN=5653-565-565, bookname=Java Complete Reference, author=Thananya]
Data Deserialized:: Book [ISBN=5653-565-561, bookname=JSP Complete Reference, author=Abi]
Data Deserialized:: Book [ISBN=5653-565-566, bookname=Jython Complete Reference, author=Surya]
*/
/*
Book Data Serialized or Persisted!
Data Deserialized:: Book [ISBN=null, bookname=Java Complete Reference, author=Thananya]
Data Deserialized:: Book [ISBN=null, bookname=JSP Complete Reference, author=Abi]
Data Deserialized:: Book [ISBN=null, bookname=Jython Complete Reference, author=Surya]
*/