package myjavademos;

interface Process1
{
	int code=6565;//public static final int code=6565;
	void startup();
}
interface Process2
{
		void shutdown();
}
//A class cannot inherit more than one class like below!
//one interface inherits more than one interface!!!
interface Process3 extends Process1, Process2
{
	void comments();
}
public class Interface_Class1 implements Process3 
{
	@SuppressWarnings("static-access")
	public static void main(String[] args) {
		//Process3 obj55=new Process3();//Interfaces cannot be directly instantiated!
		
		Process3 obj4=new Interface_Class1();//Polymorphic Object
		obj4.startup();
		obj4.shutdown();
		obj4.comments();
		System.out.println("Interface data member:: "+code);
		System.out.println("Interface data member:: "+obj4.code);
		System.out.println("Interface data member:: "+Process3.code);//interfacename.staticdatamember
		//objectname instanceof interfacename
		if(obj4 instanceof Process1)
		{
			System.out.println("Yes!Process1");
		}
		if(obj4 instanceof Process2)
		{
			System.out.println("Yes!Process2");
		}
		if(obj4 instanceof Process3)
		{
			System.out.println("Yes!Process3");
		}				


	}
	@Override
	public void startup() {
		System.out.println("Log files are created!");		
	}
	@Override
	public void shutdown() {
		System.out.println("Log files are created!");		
	}
	@Override
	public void comments() {
		System.out.println("Server Synchronized and Tuned!");				
	}

}
/*
Log files are created!
Log files are created!
Server Synchronized and Tuned!
Interface data member:: 6565
Interface data member:: 6565
Interface data member:: 6565
Yes!Process1
Yes!Process2
Yes!Process3
*/