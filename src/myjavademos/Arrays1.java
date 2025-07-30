package myjavademos;

import java.util.Scanner;

/*
 * Arrays::
 * --Derived data type or non primitive data types(Objects)
 * --Collection of similar type of values
 * --Accessing element using index(STARTS FROM 0 TO N-1)
 * --Stored in a contiguous memory location
 * --Arrays are treated as Objects(new)!!
 */
//int a[10];=> c,c++ syntax

public class Arrays1 {
	public int[] disp()//Method returns Integer Array!
	{
		@SuppressWarnings("unused")
		int a[]= {100,200,300};
		//return a;//valid

		return new int[] {12,45,576};//valid
		//return 100;//invalid
	}
	@SuppressWarnings("resource")
	public static void main(String[] args) 
	{
		@SuppressWarnings("unused")
		int salary[] = new int[10];// salary[0]-salary[9]=>0 to n-1

		int[] salary1 = new int[10];// valid=>FIXED SIZE ARRAY
		salary1[0] = 60500;
		salary1[1] = 84500;
		salary1[2] = 15500;
		salary1[3] = 56500;
		salary1[4] = 68500;

		// LENGTH STARTS FROM 1
		System.out.println("Salary:: " + salary1[3] + " " + salary1[7] + " Length:: " + salary1.length);
		

		// salary1[44]=3434;//java.lang.ArrayIndexOutOfBoundsException:

		for (int i = 0; i < salary1.length; i++)// calculate the array size
		{
			System.out.print(" " + salary1[i]);
		}
		
		// Dynamic array
		System.out.println("\nEnter The Array Size:: ");
		Scanner s1 = new Scanner(System.in);//TAKING INPUTS BY KEYBOARD
		int arraysize = s1.nextInt();
		System.out.println("Enter the " + arraysize + " values::");
		int a[] = new int[arraysize];
		System.out.println("Array Size:: " + a.length);

		for (int i = 0; i < a.length; i++) 
		{
			a[i] = s1.nextInt();// a[0],a[1],a[2].....................
		}
		for (int i = 0; i < a.length; i++) {
			System.out.print(a[i] + " ");
		}

		// ArrayInitialization
		System.out.println("\nArray Initialization:: ");
		
		String dept[] = { "IT", "HR", "Operations", "Accounting", "Pitstop" };// new keyword is missing.. it is optional
		@SuppressWarnings("unused")
		String dept1[] = new String[] { "IT", "HR", "Operations", "Accounting", "Pitstop" };
		

		//String dept1[] = new String[11] { "IT", "HR", "Operations", "Accounting", "Pitstop" };////Cannot define
		// dimension expressions when an array initializer is provided
		
		for(int i=0;i<dept.length;i++)//TRADITIONAL FOR LOOP
		{
			System.out.print(dept[i]+ " ");
		}
		
		//special loop called "FOR EACH LOOP"
				//Read only purpose
				for(String s:dept)//NO INITIALIZATION,NO CONDITION,NO ITERTATION(NO INCREMENT)
				{
		        	System.out.print(s+ " ");
		      	}

				System.out.println("\nFor Each Loop(Method):::");
				Arrays1 obj=new Arrays1();

				int s[]=obj.disp();
				for(int i:s)
				{
					System.out.print(i + " ");
				}

	
	}

}
