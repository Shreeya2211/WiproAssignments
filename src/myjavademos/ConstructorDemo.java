package myjavademos;
/*
Constructor::
--Used to initialize the data members and startup operations for your class!
--No return type not even void but methods may or may not return a value
--it is automatically invoked when an object is created!! but methods are
invoked explicitly
--classname+methodname is same=> constructor method
--constructor name and classname must be same
--Constructor are not inherited by subclasses!!but methods are automatically inherited by
subclasses
--There is always a default constructor(INSTANCE VARIABLE DEFAULT VALUES) provided by JVM compiler!!!
--Like methods, Constructor can be overloaded!!!
--Constructor cannot be abstract,static or final!!!!!!!!!!!!!!!!!!!!!
(Methods can be defined as abstract,static,final)
--2 types of constructor: 
	--default or no argument constructor
	--parameterized constructor
*/
/*
 * class Abc
 * {
 * void Abc()//method
 * {
 * }
 * Abc()//constructor
 * {
 * }
 * float Abc(int x)//method
 * {
 * }
 * }
 */
class Student_Details
{
	int studid;
	String studname;
	float marks;
	
	void view()
	{
		System.out.println("Student Details:: "+studid+ " "+studname + " "+marks);
	}

	Student_Details()//default constructor
	{
		System.out.println("NO Argument Constructor Loaded!");
	}
	//Constructor overloading
	//Parameterized constructor
	public Student_Details(int i,String x)
	{
		System.out.println("Para Constructor 1:::::");
		this.studid=i;//this keyword is optional here!
		studname=x;	
	}
	Student_Details(int i,String x,float y)
	{
		System.out.println("Para Constructor 2:::::");
		studid=i;
		studname=x;
		marks=y;
	}
}//Student Over!

	
class Demo
{
	//empty default constructor
	Demo() 
	{ 
	}
	public Demo(String a)
	{
		System.out.println("Demo Parameterized Constructor::  "+a);
	}
	void Demo()
	//methodname and classname can also be same!
	{
		System.out.println("Methodname and classname can also be same!");
	}
}//Demo Over
public class ConstructorDemo {
	public static void main(String[] args) {
		Student_Details d1=new Student_Details();//call default constructor
		Student_Details d2=new Student_Details(1001,"Thananya",90.0f);//int,string,float
		Student_Details d3=new Student_Details(1002,"Abi");//int,string
		d1.view();//default values will be displayed
		d2.view();
		d3.view();
	
		/*
		 * When we dont create a constructor java compiler creates a default
		 * constructor.But when we create one or more constructors, it does not
		 * create any default constructor!!!
		 * So we have to implement the default constructor in the class to
		 * avoid the compilation problem.
		 */	
	
		Demo obj3=new Demo();
		@SuppressWarnings("unused")
		Demo obj4=new Demo("Java");
		obj3.Demo();//Calling Method
	
	}

}
/*
NO Argument Constructor Loaded!
Para Constructor 2:::::
Para Constructor 1:::::
Student Details:: 0 null 0.0
Student Details:: 1001 Thananya 90.0
Student Details:: 1002 Abi 0.0
*/