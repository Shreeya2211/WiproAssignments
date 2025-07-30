package myjavademos;

import java.io.IOException;
//In the calling chain of method calls, Checked Exception has to be 
//HANDLED COMPULSORY with the 
//help of throws keyword/TRY-CATCH BLOCK

/*
* Throws keyword::
* --alternative of try---catch block
* --throws followed by classnames!(NO NEW KEYWORD!)
* --throws used in the METHOD SIGNATURES!NOT INSIDE THE METHOD BODY
* --contains multiple exception also
* ex: 
* public void disp() throws IOException,SQLException,ArithmeticException
* {
* }
*/
/*
 * | Feature            | `throw`                              | `throws`                                            |
| ------------------ | ------------------------------------ | --------------------------------------------------- |
| **Type**           | Statement                            | Keyword used in method declaration                  |
| **Purpose**        | Actually **throws** an exception     | **Declares** that a method might throw an exception |
| **Used in**        | Inside method body                   | In method signature                                 |
| **Followed by**    | Exception object                     | Exception class name(s)                             |
| **Number allowed** | Only **one exception** per statement | Can declare **multiple exceptions**                 |

 */

/*
 * Think of throw as "throwing the ball" (you take action), 
 * and throws as "saying I might throw the ball" (you declare the possibility).
 */
public class ExceptionPropagationDemo2 {

	void test3() throws IOException //no try catch block in test3()=>//MANUALLY PROPAGATIONG
	{
		throw new IOException();//CheckedException generated	
	}
	void test2() throws IOException,Exception//valid
	//void test2() throws IOException//MANUALLY PROPAGATIONG //no try catch block in test2()
	{
		test3();	//test2 calling test3()
	}
	
	void test1()
	{
		try
		{
			test2();//test1 calling test2()
		}
		catch(Exception e)
		{
			System.out.println("Exception handled only in test1()");
			e.printStackTrace();//test3() problem handled here!
		}	
	}
	public static void main(String[] args) {
		ExceptionPropagationDemo2 obj=new ExceptionPropagationDemo2();
		obj.test1();
		System.out.println("Program continue!");
	
	}

}
/*
Exception handled only in test1()
java.io.IOException
Program continue!
	at myjavademos.ExceptionPropagationDemo2.test3(ExceptionPropagationDemo2.java:38)
	at myjavademos.ExceptionPropagationDemo2.test2(ExceptionPropagationDemo2.java:43)
	at myjavademos.ExceptionPropagationDemo2.test1(ExceptionPropagationDemo2.java:50)
	at myjavademos.ExceptionPropagationDemo2.main(ExceptionPropagationDemo2.java:60)
*/