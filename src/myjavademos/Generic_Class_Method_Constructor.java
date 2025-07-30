package myjavademos;


//generic class
//Built in generic characters:: T or E
//Generics is equivalent to TEMPLATES IN C++

//generic class
class Item<WIPRO>
{
	 	private WIPRO itemCode;//WIPRO is replaced by any OBJECT type!
	 	private String itemName;

	 	//Generic constructor
	    //WIPRO is replaced by ANY Object TYPE
	   	//1 constructor works for MULTIPLE OBJECT TYPE!

	 	public Item(WIPRO itemCode, String itemName)
	 	{
	        this.itemCode = itemCode;
	        this.itemName = itemName;
	    }
	 	//GENERIC METHOD WITH GENERIC RETURNTYPE
	 	 public <WIPRO1> void showItemDetails(WIPRO1 price) 
	 	 {
	         System.out.println("Item Code: " + itemCode);
	         System.out.println("Item Name: " + itemName);
	         System.out.println("Item Price: " + price);
	         System.out.println("---------------------");
	     }
	 	
	 	 //generic method
		  	//return type of the method is GENERIC
		
	 	//GENERIC METHOD WITH GENERIC RETURNTYPE
		 public WIPRO display()
	  	{
	  		return itemCode;
	  	}

	    
}
public class Generic_Class_Method_Constructor {

	public static void main(String[] args) 
	{
		Item<Integer> i1 = new Item<>(1001, "Notebook");
        i1.showItemDetails(55.75);
        System.out.println("Display(): "+i1.display());
        
        Item<String> i2 = new Item<>("X205", "Pen");
        i2.showItemDetails(20);
        System.out.println("Display(): "+i2.display());
        
        Item<Float> i3 = new Item<>(5.5f, "Eraser");
        i3.showItemDetails("Rs. 10");
        System.out.println("Display(): "+i3.display());
        
	}

}
/*
Item Code: 1001
Item Name: Notebook
Item Price: 55.75
---------------------
Display(): 1001
Item Code: X205
Item Name: Pen
Item Price: 20
---------------------
Display(): X205
Item Code: 5.5
Item Name: Eraser
Item Price: Rs. 10
---------------------
Display(): 5.5
*/