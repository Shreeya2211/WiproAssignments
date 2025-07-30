package myjavademos;
/*
 * final keyword::
 * --final variable cannot be modified later!
 * --One time initialization(improves the jvm performance)
 *  *  *  * * --final classes cannot be inherited!
 *  * --final method cannot be overridden in derived class

*/

//Object class is the super classes for all the classes in java!
final class AdministratorLogin extends Object //final class can inherit other classes!
{
	void settings()
	{
		System.out.println("Administrator Login Settings!!!");
	}
}
/* class StaffLogin extends AdministratorLogin//sub classes cannot inherit final base classes!
{
	
}*/
class X
{
	void disp(int i)//non final method
	{
		
	}
	//final method
	final void disp()//this method cannot be overridden in derived class
	{
		System.out.println("X class :: disp()");
	}
}
class Y extends X
{	/*
	 *this method signature not allowed in derived class bcos it is declared as final in base class!
	 * void disp()
	 * {
	 * }
	 */
	void disp2343()//non final method
	{
		System.out.println("Y class :: disp()");
	}

}
public class Inheritance_Final {

	public static void main(String[] args) {
		//NO CONST KEYWORD IN JAVA
		final char grade='A';
		final int hoursformat=24;

		//hoursformat++;//INVALID
		System.out.println("Final data members:: "+grade+ " "+hoursformat);
	
		AdministratorLogin obj=new AdministratorLogin();
		obj.settings();
		
		Y y1 =new Y();
		y1.disp();
		y1.disp2343();



	}

}
/*
Final data members:: A 24
Administrator Login Settings!!!
X class :: disp()
Y class :: disp()
*/
