package myjavademos;

//creating interface in the same class
//public interface brands//throws error bcos already class is public! one public allowed in a single java file
interface brands
{
	void dispbrands();
	void dummy();
}

class Measurements
{
	//void disp();//method cannot be declared in a class
		void calcsize()
		{
			System.out.println("Measurementchart:: S,M,L,XL");
		}
}

//class compulsory override all interface methods!
//class can inherit only ONE class at a time!
//Class can implement 'n' NUMBER  OF INTERFACES!!!
//first extends,second implements!

public class Interface_ClassDemo  extends Measurements implements Shopping,brands
{
	public void delivery()//belong to class!
	{
		System.out.println("Home delivery available");
	}

	public static void main(String[] args) 
	{
		//Interface cannot be instantiated bcos no implementation(abstract)
				//Shopping s1=new Shopping();
				//brands b1=new brands();

		Interface_ClassDemo obj=new Interface_ClassDemo();
		obj.discounts();
		obj.creditpoints();
		obj.paymentgateway();
		obj.delivery();//class Interface_ClassDemo method	
		obj.dispbrands();//brands Interface method
		obj.calcsize();//Measurements class method

		Shopping obj2=new Interface_ClassDemo();//Polymorphic Object
		obj2.discounts();
		obj2.creditpoints();
		obj2.paymentgateway();
		//obj2.delivery();//invalid
		//this method not exist in Shopping interface so object casting is required!
		((Interface_ClassDemo)obj2).delivery();
		((Interface_ClassDemo)obj2).calcsize();// class Measurements

		brands b45=new Interface_ClassDemo();
		b45.dispbrands();
		//this method not exist in brands interface so object casting is required!
		((Interface_ClassDemo)b45).delivery();

	}

	@Override
	public void discounts() {
		System.out.println("20%-30% discount!");		
	}

	@Override
	public void creditpoints() {
		System.out.println("1000 creditpoints added!");			
	}

	@Override
	public void paymentgateway()
	//private void paymentgateway()////Cannot reduce the visibility of the inherited method from Shopping
	{
		System.out.println("Paytm,Paypal,Razorpay Supported!");		
	}
	@Override
	public void dispbrands() {
		System.out.println("Biba,Fabindia,Libas,Aurelia brands available!");			
	}
	@Override
	public void dummy() {
		//empty implementation	
	}

}
/*
20%-30% discount!
1000 creditpoints added!
Paytm,Paypal,Razorpay Supported!
Home delivery available
Biba,Fabindia,Libas,Aurelia brands available!
Measurementchart:: S,M,L,XL
20%-30% discount!
1000 creditpoints added!
Paytm,Paypal,Razorpay Supported!
Home delivery available
Measurementchart:: S,M,L,XL
Biba,Fabindia,Libas,Aurelia brands available!
Home delivery available
*/