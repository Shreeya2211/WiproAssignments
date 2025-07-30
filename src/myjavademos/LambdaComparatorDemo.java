package myjavademos;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
class VendorData
{
	int vendorid;
	String vendorname;
	public VendorData(int vendorid, String vendorname) {
		super();
		this.vendorid = vendorid;
		this.vendorname = vendorname;
	}
}
public class LambdaComparatorDemo {
	public static void main(String[] args) {
		  List<VendorData> listobj=new ArrayList<VendorData>();
		  listobj.add(new VendorData(1,"DELL"));
		  listobj.add(new VendorData(6,"HP"));
		  listobj.add(new VendorData(3,"Lenovo"));
		  listobj.add(new VendorData(10,"SONY"));
		  listobj.add(new VendorData(8,"APPLE"));
		  System.out.println("Before Sorting::: ");
		  for(VendorData p:listobj)
	        {  
	            System.out.println(p.vendorid+" "+p.vendorname);  //NO toString() method
	        }
		  System.out.println("Sorting on the basis of VendorName...");
			// implementing lambda expression  
			//no implements Comparator , no @override but we r implementing interface method called "public int compare(Object,Object)"

		  Collections.sort(listobj,(VendorData p1,VendorData p2)->
	        {  
	        	 return p1.vendorname.compareTo(p2.vendorname);  
	  	       
	        });

		  /*		//Anonymous syntax
		  Collections.sort(list, new Comparator<VendorData>() 
		  {
		        @Override
		        public int compare(VendorData h1, VendorData h2) 
		        {
		            return h1.vendorname.compareTo(h2.vendorname);
		        }
		    });
		  */

		  System.out.println("After Sorting::: ");
  for(VendorData p:listobj)
    {  
        System.out.println(p.vendorid+" "+p.vendorname);  
    }  
	}

}
/*
Before Sorting::: 
1 DELL
6 HP
3 Lenovo
10 SONY
8 APPLE
Sorting on the basis of VendorName...
After Sorting::: 
8 APPLE
1 DELL
6 HP
3 Lenovo
10 SONY
*/