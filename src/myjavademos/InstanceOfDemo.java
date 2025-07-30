package myjavademos;
class A1 extends Object//optional
{
}
class B1 extends Object//Optional
{
}
class C1 extends A1
{
}
class D extends A1
{
}
public class InstanceOfDemo {
	public static void main(String[] args) {
		A1 a=new A1();
		B1 b=new B1();
		C1 c=new C1();
		D d=new D();
		/*
		instanceof keyword::Check whether an object is an instance of a specific class
		--boolean
		*/
		if (a instanceof A1)	//objectname instanceof classname
		{
		System.out.println("a is instanceof A");	
		}
		if (b instanceof B1)
		{
		System.out.println("b is instanceof B");	
		}
		if (c instanceof C1)
		{
		System.out.println("c is instanceof C");	
		}
		if (d instanceof D)
		{
		System.out.println("d is instanceof D");	
		}
		if (c instanceof A1)//C1(c) extends A1
		{
			System.out.println("c is ALSO instanceof A");	
		}
		A1 ob; //null=>REFERENCE OBJECT
		ob = d; // A reference to d 
		if(ob instanceof D) //class D extends A1
			System.out.println("ob can be cast to D"); 
			else 
			System.out.println("ob cannot be cast to D"); 

			if(a instanceof Object) 
			System.out.println("a may be cast to Object"); 
			if(b instanceof Object) 
			System.out.println("b may be cast to Object"); 
			if(c instanceof Object) 
			System.out.println("c may be cast to Object"); 
			if(d instanceof Object) 
			System.out.println("d may be cast to Object"); 

			//String name="Abi";//Valid=>REFERENCE OBJECT
			//String name=null;//unused/unreferenced object=>eligible for Garbage collection process
			String name=new String("Abi");//valid=>COMPLETE OBJECT
			if(name instanceof String)
			{
				System.out.println("Correct");
			}
			else
			{
				System.out.println("Invalid");
			}
			if(name instanceof Object)
			{
				System.out.println("Correct");
			}
			else
			{
				System.out.println("Invalid");
			}



	}

}
/*
a is instanceof A
b is instanceof B
c is instanceof C
d is instanceof D
c is ALSO instanceof A
ob can be cast to D
a may be cast to Object
b may be cast to Object
c may be cast to Object
d may be cast to Object
Correct
Correct
*/