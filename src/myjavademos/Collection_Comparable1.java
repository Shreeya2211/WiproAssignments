package myjavademos;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

//select * from emp order by salary;//asc=>default
//select * from emp order by salary asc;
//select * from emp order by salary desc;

/*
* The sort() method of the Arrays class works for primitive type while the sort() method 
* of the Collections class works for objects Collections, such as LinkedList, ArrayList, etc.
* 
*/
/*Unsorted::
* 2 devi 34000
* 1 abi  22000
* 5 daya 34230
* Sorted(based on salary)::
* 1 abi 22000
* 2 devi 34000
* 5 daya 34230
*/

/*
 * java.lang.Comparable interface:
 * --used to sort the objects
 *  * --Only one abstract method called compareTo(Object)(>0,<0,0)
 * --String and Wrapper classes(Integer,Float,Byte....) implements Comparable interface!!!!
 * --********************single column sorting either accno or name or years!

*/

class Bank_Acc implements Comparable<Bank_Acc>
{
	int accno;
	String accholdername;
	int years; 
	public Bank_Acc(int accno, String accholdername, int years) {
		super();
		this.accno = accno;
		this.accholdername = accholdername;
		this.years = years;
	}
	@Override
	public String toString()
	{
		return accno + " "+ accholdername + " "+ years;
	}
	//public int compareTo(Object arg0) //original interface method
	//sorting the records based on YEARS!
	//select * from Bank_Acc order by years asc;

	//Comparable interface affect the Original class
	//**************one field sorting allowed!		
	public int compareTo(Bank_Acc b) 
	{
		if(years==b.years)
		{
			return 0;
		}
		else if(years>b.years)//ascending
		{
			return 1;
		}
		else
		{
			return -1;
		}
	}
}
public class Collection_Comparable1 {
	public static void main(String[] args) {
		Bank_Acc b1=new Bank_Acc(11,"Devi",6);
		Bank_Acc b2=new Bank_Acc(13,"Abi",2);
		Bank_Acc b3=new Bank_Acc(8,"Daya",7);
		Bank_Acc b4=new Bank_Acc(4,"Raja",3);
		Bank_Acc b5=new Bank_Acc(12,"Lakshmi",7);
	
		ArrayList<Bank_Acc> obj=new ArrayList<Bank_Acc>();//ordered collection
		obj.add(b1);
		obj.add(b2);
		obj.add(b3);
		obj.add(b4);
		obj.add(b5);
		System.out.println("Before Sorting::");
		for(Bank_Acc t:obj)
		{
			System.out.println(t);//toString()
		}	
		//Collection is a BUILT IN interface,Collections is a BUILT IN class
		//ORDER BY KEYWORD IN SQL ====== COMPARABLE INTERFACE
		Collections.sort(obj);//sort method expect Comparable interface to be implemented

		System.out.println("After Sorting(Based on Years)::");
		for(Bank_Acc t:obj)
		{
			System.out.println(t);
		}

		int [] array = new int [] {90, 23, 5, 109, 12, 22, 67, 34};  
		Arrays.sort(array);   
		System.out.println("Elements of array sorted in ascending order: ");  
		for (int i = 0; i < array.length; i++)   
		{       
		System.out.println(array[i]);   
		}   

		Integer [] array1 = {23, -9, 78, 102, 4, 0, -1, 11, 6, 110, 205};   
		// sorts array[] in descending order   
		Arrays.sort(array1, Collections.reverseOrder());   
		System.out.println("Array elements in descending order: " +Arrays.toString(array1));   

	}

}
/*
Before Sorting::
11 Devi 6
13 Abi 2
8 Daya 7
4 Raja 3
12 Lakshmi 7
After Sorting(Based on Years)::
13 Abi 2
4 Raja 3
11 Devi 6
8 Daya 7
12 Lakshmi 7
Elements of array sorted in ascending order: 
5
12
22
23
34
67
90
109
Array elements in descending order: [205, 110, 102, 78, 23, 11, 6, 4, 0, -1, -9]
*/