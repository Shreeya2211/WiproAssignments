package myjavademos;
/*
 * Inheritance::
 *  * --Reusability of the code
 * --one class acquires the properties of another class!
 *  * --"is a relationship" ex: House  is a Building, Car is a vehicle
* class Building
 * {
 * }
 * class House extends Building
 * {
 * }
 * class Office extends Building
 * {
 * }
 *  *  --unidirectional in nature!!!!!!
*/

//Hierarchical Inheritance(parent class is inherited by multiple subclasses)
class Mobile extends Object//Object is the super classes for all classes in java

//class Mobile
{
	int iemicode=6566;
	public void operations()
	{
		System.out.println("Dial,Receive,Send Msg..");
	}
	public void show()
	{
		System.out.println("Mobile Class Show()");
	}
}
class Samsung extends Mobile
{
	int iemicode=7968;//member overriding
	public void connectivity()
	{
		System.out.println("Samsung:: WIFI+GPS!");
	}
	public void camera()
	{
		System.out.println("Samsung::ReaR fLASH LEDS,Ambient Light Sensors!");
	}
	//method overriding(run time polymorphism)
	//base class and derived class contain same method signature!!
	//super keyword=>refer immediate super class
		//this=> refers current class
	public void show()	
	{
		System.out.println("Samsung class Show()");
		super.show();//prevent method overriding!!!!!
		System.out.println("IEMI CODE:: "+ " "+iemicode + " "+ this.iemicode + " "+super.iemicode);				
	}
}
class Apple extends Mobile
{
	public void features()
	{
		System.out.println("Iphone::iMessage,Timestamps,Sleep timers,Screen timer!");
	}
}
public class InheritanceDemo1 {
	public static void main(String[] args) {
		Samsung s1=new Samsung();
		Apple a1=new Apple();
		s1.operations();//base class method but called via derived class object
		s1.camera();
		s1.connectivity();
		s1.show();//calls Mobile class show()
		a1.operations();
		a1.features();

	}

}
/*
Dial,Receive,Send Msg..
Samsung::ReaR fLASH LEDS,Ambient Light Sensors!
Samsung:: WIFI+GPS!
Samsung class Show()
Mobile Class Show()
IEMI CODE::  7968 7968 6566
Dial,Receive,Send Msg..
Iphone::iMessage,Timestamps,Sleep timers,Screen timer!
*/