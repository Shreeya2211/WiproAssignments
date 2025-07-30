package myjavademos;

public class Vendor {
	//4 access specifier:: public,private,protected(inheritance), default or package(invisible)


		/*instance(object)(variable which is declared inside the class) 
		 always have DEFAULT VALUES
		*/
		/*
		 * int=0,float=0.0,boolean=false,String=null
		 */
	private int vendorid;
	public String vendorname;
	String place;//default or package access specifier
	int a,b;//default or package access specifier

	//All These methods are called as 4=>"NON STATIC METHODS"

	public void display()
	{
		System.out.println("My Java First Method Loaded!");
	}
	public void showrecord()
	{
		System.out.println("Vendor:: "+vendorid+ " "+vendorname+ " "+place);
	}
	private float multiply(float x)
	{
		return x*x;
	}
	void add(int x,int y)//default access specifier, x and y are local variables
	{
		a=x;
		b=y;
		System.out.println("Add:: "+(a+b));
	}

	//main is a static method
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Vendor v1=new Vendor();
		v1.display();
		v1.showrecord();//objectname.methodname
		v1.vendorid=1001;
		v1.vendorname="Dell";
		v1.place="Chennai";
		v1.showrecord();//objectname.methodname
		
		float result=v1.multiply(1.1F);
		System.out.println("Mul:: "+result);
		System.out.println("Mul:: "+v1.multiply(1.2f));
		
		System.out.println("Mul:: "+new Vendor().multiply(1.2f));//Dynamic memory
		new Vendor().display();	
		
		System.out.println("Before ADD():: "+v1.a + " "+v1.b);//default values
		v1.add(12, 10);//x,y
		System.out.println("After ADD():: "+v1.a + " "+v1.b);
		
		//default values ONLY for instance variable
		//local variable require explicit initialization
	
		int c=1000;
		System.out.println("Main Method(Local Variable)::: "+c);
		
	}

}
