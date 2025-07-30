package myjavademos;
class Parent
{
	public static void display()
	{
		System.out.println("Parent class static method!");
	}
	public void disp()
	{
		System.out.println("Parent class non-static method!");
	}
}
class Child extends Parent
{
	@Override
	public void disp()
	{
		super.disp();
		System.out.println("Child class non static method(Overridden)!");
	}
	//the same method also exists in the ParentClass  
		//it does not override, actually it is method hiding  
		//@Override//throws error.. cannot override static method!
			public static void display()
	{
		//this and super keyword(associated with object(instance variable and method))
		//cannot be used in static methods!
		System.out.println("Child class static method!");
	}
}
/*
 * Can we override a static method?
No, we cannot override static methods because method overriding is based on 
dynamic binding at runtime 
and the static methods are bonded using static binding at compile time.
 So, we cannot override static methods.

The calling of method depends upon the type of object that calls the 
static method. It means:

--If we call a static method by using the parent class object, the original 
static method will be called 
from the parent class.
--If we call a static method by using the child class object, 
the static method of the child class will be 
called.
 */

//STATIC METHODS CAN BE OVERLOADED! CANNOT BE OVERRIDDEN!
public class StaticOverriding {
	@SuppressWarnings("static-access")
	public static void main(String[] args) {
		Child c1=new Child();
		c1.display();
		Child.display();
		c1.disp();
	
		Parent pc = new Child();//Polymorphic Object
		pc.display();//Parent class bcos static
		pc.disp();//Child class bcos non static
		
	}

}
/*
Child class static method!
Child class static method!
Parent class non-static method!
Child class non static method(Overridden)!
Parent class static method!
Parent class non-static method!
Child class non static method(Overridden)!
*/