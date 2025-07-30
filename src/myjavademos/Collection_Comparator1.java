package myjavademos;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
/*
 * | Feature             | `Comparable`                        | `Comparator`                                         |
| ------------------- | ----------------------------------- | ---------------------------------------------------- |
| **Package**         | `java.lang`                         | `java.util`                                          |
| **Purpose**         | Defines **natural ordering**        | Defines **custom ordering**                          |
| **Method**          | `compareTo(Object o)`               | `compare(Object o1, Object o2)`                      |
| **Modifies Class?** | Yes (class must implement it)       | No (separate from class)                             |
| **Used When?**      | Default sort order (e.g., name, ID) | Multiple sort conditions (e.g., by age, then salary) |
| **Implemented By**  | The class itself                    | External class or anonymous function                 |

 */
class Item_Stuff
{
	int itemno;
	String itemname;
	int price;
	public Item_Stuff(int itemno, String itemname, int price)
	{
		super();
		this.itemno = itemno;
		this.itemname = itemname;
		this.price = price;
	}
	@Override
	public String toString()
	{
		return itemno + " "+ itemname + " "+ price;
	}
}

class WIPRONameComparator implements Comparator<Item_Stuff>
{

	//public int compare(Object arg0, Object arg1)//ORIGINAL INTERFACE METHOD
		@Override
		public int compare(Item_Stuff i1, Item_Stuff i2)
		{
			return i1.itemname.compareTo(i2.itemname);//String compareTo()=>0,>0,<0
		}	
}
class WIPROPriceComparator implements Comparator<Item_Stuff>
{
	@Override
	public int compare(Item_Stuff o1, Item_Stuff o2) 
	{
		if(o1.price==o2.price)
		{
			return 0;
		}
		else if (o1.price>o2.price)//ascending order
		{
			return 1;
		}
		else 
			return -1;
	}
}
class WIPROPriceDescendingComparator implements Comparator<Item_Stuff>
{
	@Override
	public int compare(Item_Stuff o1, Item_Stuff o2) 
	{
		if(o1.price==o2.price)
		{
			return 0;
		}
		else if (o1.price<o2.price)//descending order
		{
			return 1;
		}
		else 
			return -1;
	}
}

public class Collection_Comparator1 {

	public static void main(String[] args) {
		ArrayList<Item_Stuff> obj=new ArrayList<>();
		obj.add(new Item_Stuff(1001,"Kurtis",2000));
		obj.add(new Item_Stuff(1003,"Tops",1000));
		obj.add(new Item_Stuff(1002,"Chudis",2500));
		obj.add(new Item_Stuff(1004,"Sarees",3000));
		obj.add(new Item_Stuff(1005,"Shirts",2700));
		System.out.println("Before Sorting::");
		for(Item_Stuff t:obj)
		{
			System.out.println(t);
		}

		//Collection is a built in Interface, Collections is a built in class
		//select * from item_stuff order by itemname;
		System.out.println("Sorting(Based on Itemname's)::");
		
		//Collections.sort(objname,comparator classname)
		
		Collections.sort(obj, new WIPRONameComparator());//Implement Comparator Interface
		for(Item_Stuff t:obj)
		{
			System.out.println(t);
		}
		
		//select * from item_stuff order by price ASC;
		System.out.println("Sorting(Based on ItemPrice Ascending)::");
		Collections.sort(obj, new WIPROPriceComparator());//Implement Comparator Interface
			for(Item_Stuff t:obj)
		{
			System.out.println(t);
		}
	
			//select * from item_stuff order by price desc;
			System.out.println("Sorting(Based on ItemPrice in Descending)::");
			Collections.sort(obj, new WIPROPriceDescendingComparator());//Implement Comparator Interface
			for(Item_Stuff t:obj)
			{
				System.out.println(t);
			}

	}

}
/*
Before Sorting::
1001 Kurtis 2000
1003 Tops 1000
1002 Chudis 2500
1004 Sarees 3000
1005 Shirts 2700
Sorting(Based on Itemname's)::
1002 Chudis 2500
1001 Kurtis 2000
1004 Sarees 3000
1005 Shirts 2700
1003 Tops 1000
Sorting(Based on ItemPrice Ascending)::
1003 Tops 1000
1001 Kurtis 2000
1002 Chudis 2500
1005 Shirts 2700
1004 Sarees 3000
Sorting(Based on ItemPrice in Descending)::
1004 Sarees 3000
1005 Shirts 2700
1002 Chudis 2500
1001 Kurtis 2000
1003 Tops 1000
*/