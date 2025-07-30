package myjavademos;
/*
 * In the calling chain of method calls,ONLY unchecked exception are 
 * FORWARDED/PROPAGATED by default/AUTOMATICALLY!
 *//*
 * when an exception happens, Propagation is a process in which the exception is 
 * being dropped from to the 
 * top to the bottom of the stack. If not caught once, the exception again drops 
 * down to the previous method 
 * and so on until it gets caught or until it reach the very bottom of the call 
 * stack. 
 * This is called exception propagation and this happens in case of 
 * ""Unchecked Exceptions.""""
 */
public class ExceptionPropagationDemo1 {
	void test3()//no try catch block in test3()
	{
		System.out.println(12/0);//unchecked exception--ArithmeticException
	}
	void test2()//no try catch block in test2()
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
		ExceptionPropagationDemo1 obj=new ExceptionPropagationDemo1();
		obj.test1();
		System.out.println("Program continue!");
	
	}

}
/*
Exception handled only in test1()
java.lang.ArithmeticException: / by zero
	at myjavademos.ExceptionPropagationDemo1.test3(ExceptionPropagationDemo1.java:18)
	at myjavademos.ExceptionPropagationDemo1.test2(ExceptionPropagationDemo1.java:22)
	at myjavademos.ExceptionPropagationDemo1.test1(ExceptionPropagationDemo1.java:28)
	at myjavademos.ExceptionPropagationDemo1.main(ExceptionPropagationDemo1.java:38)
Program continue!
*/