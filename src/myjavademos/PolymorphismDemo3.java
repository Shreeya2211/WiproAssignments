package myjavademos;

/*
 * In the inheritance, the constructors never get inherited to any child class.

In java, the default constructor of a parent class called automatically by the constructor of its child class. 

 * if the parent class contains both default and parameterized constructor, 
 * then only the default constructor called automatically by the child class constructor.
 *
 * The parameterized constructor of parent class must be called explicitly using the super keyword.
 */

/*@Override:
 * 
 * | Feature                 | Benefit                         |
| ----------------------- | ------------------------------- |
| ✅ Compile-time checking | Prevents override mistakes      |
| ✅ Documentation aid     | Makes code easier to understand |
| ✅ Refactoring safety    | Avoids silent override failures |

 */
//Hierarchical inheritance
class Emps
{
	int eno;
	String name;
	//**************************Rightclick->Source->Generate Constructor using fields!

	public Emps(int eno, String name) {
		super();
		this.eno = eno;
		this.name = name;
	}
	//no business logic
	public int calcpay()
	{
		return 0;
	}
	public void comments()
	{
		System.out.println("Feedback noted!");
	}
}
class SalariedEmployees extends Emps
{
	int net_sal;
	/*
	 * If there is any base class para constructor , we have to compulsory create a 
	 * derived class constructor
	 * then we have to refer base class para constructor with the help of super keyword!
	 */
	SalariedEmployees(int eno,String name,int net_sal)
	{
		//call to super constructor must be first line!
		super(eno,name);//Emps(eno,name)
		this.net_sal=net_sal;
	}
	/*
	 @Override Annotation:: inform to the compiler or JVM:
	 --built-in annotations in java such as @Override, @Deprecated, @SuppresssWarnings, @Target, @Retention etc.
	 --Force the programmer to use same method 
	 signature given in the parent class
	 --Annotation always starts with @ symbol!
	 */
	//Method level annotation
	@Override//will comes only in derived classes!
	public int calcpay()
	{
		return net_sal*31;
	}
	//Method level annotation
	@Override//will comes only in derived classes!
	public void comments()
	{
		System.out.println("Good!");
	}

}
class ContractEmployees extends Emps
{
	int wagesperday;

	ContractEmployees(int eno,String name,int wagesperday)
	{
		super(eno,name);//calls base class para constructor ex: Emps(int eno,String name)
		this.wagesperday=wagesperday;	
	}
	//Method level annotation
	@Override//will comes only in derived classes!

	public int calcpay()
	{
		return wagesperday*7;//weekly calculation
	}
	//Method level annotation
	@Override//will comes only in derived classes!

	public void comments()
	{
		System.out.println("Excellent!");
	}
	
}
public class PolymorphismDemo3 {

	public static void main(String[] args) {
		//Polymorphic array of objects

		Emps obj[]= {
				new SalariedEmployees(1001,"Thananya",50000),//obj[0],
				new ContractEmployees(1002,"Abi",6000)//obj[1]
					};
		
		for(int i=0;i<obj.length;i++)
		{
			System.out.println(obj[i].getClass()+ " "+obj[i].eno + " "+obj[i].name + " "+obj[i].calcpay());
			obj[i].comments();
		}

	}
	}

/*
 * class myjavademos.SalariedEmployees 1001 Thananya 0
Good!
class myjavademos.ContractEmployees 1002 Abi 42000
Excellent!
*/
