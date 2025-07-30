package myjavademos;
/*
 * | Feature             | **Instance Block**                                                        | **Constructor**                                       |
| ------------------- | ------------------------------------------------------------------------- | ----------------------------------------------------- |
| ✅ **What it is**    | Block of code inside a class, **outside any method**                      | A **special method** with the same name as the class  |
| ⚙️ **When it runs** | Runs **every time an object is created**, just **before the constructor** | Runs **after instance block**, when object is created |
| 🔁 **Reusability**  | Common code for **all constructors**                                      | Can have **multiple constructors** (overloading)      |
| 🧩 **Use case**     | Initialize common values or logic shared by all constructors              | Initialize object based on parameters                 |

 */
/*
 * | Feature                  | Instance Block                             | Constructor                            |
| ------------------------ | ------------------------------------------ | -------------------------------------- |
| **Purpose**              | Initialize **instance variables**          | Initialize **objects with parameters** |
| **Can take parameters?** | ❌ No                                       | ✅ Yes (constructor overloading)        |
| **Multiple allowed?**    | ✅ Yes (you can write many instance blocks) | ✅ Yes (you can overload constructors)  |
| **Order of execution**   | Runs **before the constructor**            | Runs **after instance block**          |
| **Inheritance**          | Not inherited                              | Can be called using `super()`          |

 */
/*
Initialisations blocks can be:
    * Static block
    * Instance block(non static block)
--Static Initialisation blocks run only once when the class is first loaded. 
Used to initialize only static variables.
--Instance Initialisation blocks run each time BEFORE the object of the class 
is created. Used to initalize only instance variables.
The Compiler copies instance initializer block into every constructor. 
Therefore, this can be used to share a block of code between multiple 
constructors.
--The instance initializer block comes in the order in which they appear.

 *CLASS ORDER::
 *STATIC BLOCK=>INSTANCE BLOCK=>CONSTRUCTOR=>METHOD
 *
 *this keyword cannot be used in static block in java.
 *this keyword can be used in instance block in java.
 *
 *the static blocks of the parent class are executed, followed by the static blocks of the subclass.
 *
*/

class Sites
{
	//instance block
	{
		System.out.println("Online Shopping Sites Loaded - PARENT CLASS INSTANCE BLOCK!!");
	}
	Sites()
	{
		System.out.println("ShoppersStop,Myntra,Faballey... - PARENT CLASS INSTANCE BLOCK");
	}
	static
	{
		System.out.println("Static Block Sites! - PARENT CLASS STATIC BLOCK");
	}
}
class Purchase extends Sites
{
	//2 instance block
	{
		System.out.println("Before purchase read the terms&conditions-SUB CLASS INSTANCE BLOCK");
	}
	{
		System.out.println("Timing,Charges and reporting to audit - SUB CLASS INSTANCE BLOCK");
	}
	Purchase(String pname)
	{
	System.out.println("Prod Name:: "+pname);	
	}
	static
	{
		System.out.println("Shopping App Loaded - SUB CLASS STATIC BLOCK!!!");
	}
}

public class InstanceBlockDemo {
	static int b=1000;
	InstanceBlockDemo()
	{
		System.out.println("Default Constructor Loaded!");
	}
	//instance  block(NO NAME)
	{
		System.out.println("Preloading the object-FIRST INSTANCE BLOCK!");
		System.out.println(b);//static variable
	}
	{//instance  block(NO NAME)
		System.out.println("Preloading the object again - SECOND INSTANCE BLOCK!");
	}
	static//TOP HIGHER  PRIORITY
	{
		System.out.println("Preloading the class - STATIC BLOCK!");
	}

	public static void main(String[] args) {
		@SuppressWarnings("unused")
		InstanceBlockDemo obj=new InstanceBlockDemo();//2*4=8times instance block output
		@SuppressWarnings("unused")
		InstanceBlockDemo obj1=new InstanceBlockDemo();
		@SuppressWarnings("unused")
		InstanceBlockDemo obj2=new InstanceBlockDemo();		
		@SuppressWarnings("unused")
		InstanceBlockDemo obj3=new InstanceBlockDemo();
		
		/*
		 * 1.Parent class Static block then derived class static block
		 2.Parent class instance block,sub class instance block then DERIVED CLASS  constructor
		 */
		@SuppressWarnings("unused")
		Purchase p1=new Purchase("Kurtis");
		@SuppressWarnings("unused")
		Purchase p2=new Purchase("Party wear dresses");

	}

}
/*
Preloading the class - STATIC BLOCK!
Preloading the object-FIRST INSTANCE BLOCK!
1000
Preloading the object again - SECOND INSTANCE BLOCK!
Default Constructor Loaded!
Preloading the object-FIRST INSTANCE BLOCK!
1000
Preloading the object again - SECOND INSTANCE BLOCK!
Default Constructor Loaded!
Preloading the object-FIRST INSTANCE BLOCK!
1000
Preloading the object again - SECOND INSTANCE BLOCK!
Default Constructor Loaded!
Preloading the object-FIRST INSTANCE BLOCK!
1000
Preloading the object again - SECOND INSTANCE BLOCK!
Default Constructor Loaded!
Static Block Sites! - PARENT CLASS STATIC BLOCK
Shopping App Loaded - SUB CLASS STATIC BLOCK!!!
Online Shopping Sites Loaded - PARENT CLASS INSTANCE BLOCK!!
ShoppersStop,Myntra,Faballey... - PARENT CLASS INSTANCE BLOCK
Before purchase read the terms&conditions-SUB CLASS INSTANCE BLOCK
Timing,Charges and reporting to audit - SUB CLASS INSTANCE BLOCK
Prod Name:: Kurtis
Online Shopping Sites Loaded - PARENT CLASS INSTANCE BLOCK!!
ShoppersStop,Myntra,Faballey... - PARENT CLASS INSTANCE BLOCK
Before purchase read the terms&conditions-SUB CLASS INSTANCE BLOCK
Timing,Charges and reporting to audit - SUB CLASS INSTANCE BLOCK
Prod Name:: Party wear dresses
*/