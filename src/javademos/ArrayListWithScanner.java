package javademos;

import java.util.ArrayList;
import java.util.Scanner;

class Student
{
	int rollno;
	String stuname;
	public Student(int rollno, String stuname) 
	{
		super();
		this.rollno = rollno;
		this.stuname = stuname;
	}
	public int getRollno() {
		return rollno;
	}
	public String getStuname() {
		return stuname;
	}
	@Override
	public String toString() 
	{
        return "Student1 Details: " + getRollno() + " " + getStuname();
	}

}
public class ArrayListWithScanner {

	@SuppressWarnings("resource")
	public static void main(String[] args) {
		int roll;
		String name1;
	   
		Scanner scan = new Scanner(System.in);
		ArrayList<Student> listobj = new ArrayList<Student>();

        while(true) 
        {   
	        System.out.println("1 - Add Student to ArrayList");
	        System.out.println("2 - Display Student from ArrayList");

	        //Read
	       	String input = scan.nextLine();
	       	if (input.equals("1")) 
	       	{
       		System.out.print("Enter Rollno: ");
   			roll = Integer.parseInt(scan.nextLine());
   			System.out.print("Enter Name: ");
   			name1 = scan.nextLine();
            listobj.add(new Student(roll, name1));//*************adding the record to arraylist object   
	       	}
	       	else if (input.equals("2")) 
	       	{
	       		for (Student s:listobj)
	       		{
	       			System.out.println(s);
	       		}
	       	return;	  //completed          
	       	}    

        }
	}

}
/*
1 - Add Student to ArrayList
2 - Display Student from ArrayList
1
Enter Rollno: 1
Enter Name: Thananya
1 - Add Student to ArrayList
2 - Display Student from ArrayList
1
Enter Rollno: 2
Enter Name: Abi
1 - Add Student to ArrayList
2 - Display Student from ArrayList
1
Enter Rollno: 3
Enter Name: Priya
1 - Add Student to ArrayList
2 - Display Student from ArrayList
2
Student Details: 1 Thananya
Student Details: 2 Abi
Student Details: 3 Priya
*/

/*
1 - Add Student to ArrayList
2 - Display Student from ArrayList
1
Enter Rollno: 1
Enter Name: shree
1 - Add Student to ArrayList
2 - Display Student from ArrayList
2
Student1 Details: 1 shree
*/