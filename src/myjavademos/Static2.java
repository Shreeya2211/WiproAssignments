package myjavademos;



class StaticDemo
{
	static void disp_view()
	{
		System.out.println("StaticDemo:::: disp()");
	}
}//completed

//NON STATIC->OBJECT, STATIC->CLASS
public class Static2 {

	int a=100;//non static variable
	static int b=200;
	static int c=300;
	
	public void display()
	{
		System.out.println("Non static method:: ");
		//non static method access both static and non static
		System.out.println("Printing Both Static and Non-static:: "+a + " " + b + " "+ c);
		test();//valid:: non static method calls static method
	}
	static void test()
	{
		System.out.println("Static Test Method!");
	}
	static void display1()
	{
		System.out.println("Static method:: ");
		//display();//invalid... we cannot call non static methods directly in static method
		new Static2().display();
		System.out.println("Printing Both Static and Non-static:: "+new Static2().a + " " +b + " "+ c);
	}
	
	public static void main(String[] args) {
		Static2 obj=new Static2();
		obj.display();
		//display();//invalid object is mandatory
	
		test();//object is optional bcos static methods memory allocation happen by default
		Static2.test();//classname.methodname. This signature valid for only STATIC METHODS
		//obj.test();//valid but it is not required
		
		//disp_view();//invalid
				//if the static method is present in another class then
				//classname.methodname signature is compulsory

				StaticDemo.disp_view();

		
	}

}
/*
Non static method:: 
Printing Both Static and Non-static:: 100 200 300
Static Test Method!
Static Test Method!
Static Test Method!
Static Test Method!
StaticDemo:::: disp()
*/