package myjavademos;
/*
 * Real-Life Analogy
Think of a remote control (parent type) that can operate TV, AC, or Fan (child types). 
You don't need a separate remote for each. 
The same remote (reference) can work with different devices (objects).


 */
class Test_3
{
	public void check1()
	{
		System.out.println("Test_3::: check1()");
	}
	public void check2()
	{
		System.out.println("Test_3::: check2()");
	}
}
class Test_4 extends Test_3
{
	//NO SUPER KEYWORD!	
	public void check1()//method overriding
	{
		System.out.println("Test_4::: check1()");
	}
	public void check2()//method overriding
	{
		System.out.println("Test_4::: check2()");
	}
	//adding new methods in derived class
	public void dummy1()
	{
		System.out.println("Test_4::dummy1()");
	}
	public void dummy2()
	{
		System.out.println("Test_4::dummy2()");
	}
}

public class PolymorphismDemo2 {

	public static void main(String[] args) {
		@SuppressWarnings("unused")
		Test_3 ob=new Test_4();//Polymorphic Object
		
		//POLYMORPHIC Array of object is possible only if the classes contain relationship!
				//A single object (obj) connects to 2 classes

		//Polymorphic array of objects
		//Test_3 obj1[]= {	new Test_3(),	new Test_4()	};

		Test_3 obj[]= 
			{
				new Test_3(),//obj[0]	
				new Test_4()//obj[1]
			};

		obj[0].check1();//parent class
		obj[0].check2();//parent class

		obj[1].check1();//derived class
		obj[1].check2();//derived class

		//obj[1].dummy1();//invalid
		((Test_4)obj[1]).dummy1();//Object casting
		((Test_4)obj[1]).dummy2();

		//getClass():: return the classname
	System.out.println("Classname::: "+obj[0].getClass() + " "+obj[1].getClass());

	}

}
/*
Test_3::: check1()
Test_3::: check2()
Test_4::: check1()
Test_4::: check2()
Test_4::dummy1()
Test_4::dummy2()
Classname::: class myjavademos.Test_3 class myjavademos.Test_4
*/