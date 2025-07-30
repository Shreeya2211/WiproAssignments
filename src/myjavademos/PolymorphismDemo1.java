package myjavademos;

class Emp1
{
	public void work()
	{
		System.out.println("Employee Work Process Loaded!");
	}
	public void show()
	{
		System.out.println("Employee Show() Loaded!");	
	}
}
class Manager1 extends Emp1
{
	public void work()//Overriding method
	{
	super.work();//valid
	System.out.println("Managing teams!");
	super.work();//valid
	}
	public void services()
	{
		super.work();
		System.out.println("Generating reports,Client meetings etc.,");
	}	
}
public class PolymorphismDemo1 {

	public static void main(String[] args) {
		@SuppressWarnings("unused")
		Manager1 ob=new Manager1();//ACCESS BOTH THE CLASS METHODS 

		//Polymorphic object
		Emp1 obj=new Manager1();//valid Manager  is also a employee
		
		//Manager1 obj1=new Emp1();//invalid!But ALL employee is not a manager
		
		obj.work();//derived class method
		obj.show();//base class method
		//obj.services();//invalid/*
	
		/*
		* Upcasting: Upcasting is the typecasting of a child object to a parent object. 
		 * Upcasting can be done implicitly. Upcasting gives us the flexibility to access the 
		 * parent class members 
		 * but it is not possible to access all the child class members using this feature. 
		 * Instead of all the members, we can access some specified members of the child class.
		 *  For instance, we can access the overridden methods.
		Downcasting: Similarly, downcasting means the typecasting of a parent object to a 
		child object. 
		Downcasting cannot be implicit. If it s not possible, the compiler throws a 
		ClassCastException. 
		 */
		//((Emp1)obj).services();//invalid
		((Manager1)obj).services();//Object casting mandatory::downcasting

		((Manager1)obj).show();//Object casting is optional!
		((Emp1)obj).show();//Object casting is optional!
		((Manager1)obj).work();//Object casting is optional!
		((Emp1)obj).work();//Object casting is optional!

	}

}
/*
Employee Work Process Loaded!
Managing teams!
Employee Work Process Loaded!
Employee Show() Loaded!
Employee Work Process Loaded!
Generating reports,Client meetings etc.,
Employee Show() Loaded!
Employee Show() Loaded!
Employee Work Process Loaded!
Managing teams!
Employee Work Process Loaded!
Employee Work Process Loaded!
Managing teams!
Employee Work Process Loaded!
*/