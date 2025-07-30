package myjavademos;

import java.util.Scanner;

public class Inputs {

	public static void main(String[] args) {

		//Read the input 
		@SuppressWarnings("resource")
		Scanner s1=new Scanner(System.in);//in is a reserved object of InputStream(java.io)

		System.out.println("Enter ENO:: ");
		int eno1=s1.nextInt();
		/*
		 * The nextLine() method is capable of reading input till the end of the line. 
		 * So, it stops reading input from the user when the user presses the enter key
		 * 
		 * The escaping sequence of next() is space.Next() uses to read a single word and when it
		 *  gets a white space,it stops reading and the cursor back to its original position.
		 *  
		 *  | Method       | Reads          | Stops at  | Handles spaces? | Common Use            |
| ------------ | -------------- | --------- | --------------- | --------------------- |
| `next()`     | One word/token | Space/tab | ❌ No            | Reading one word      |
| `nextLine()` | Entire line    | Enter key | ✅ Yes           | Reading full sentence |

		 */
		s1.nextLine();//IMPORTANT
		
		System.out.println("Enter Employeename:: ");
		//String name=s1.next();//considered the spaces (only first value considered)!
				String name=s1.nextLine();


		System.out.println("Enter Salary: ");
		float salary=s1.nextFloat();

		System.out.println("Emp::: " +eno1+ " "+name+ " "+salary);

		System.out.printf("%d %s %f", eno1,name,salary);//similar to native c language

		System.out.printf("%n %b",(13>45));//%n=>new line,%b=>boolean

	}

}
/*
Enter ENO:: 
1
Enter Employeename:: 
Sarah
Enter Salary: 
80000
Emp::: 1 Sarah 80000.0
1 Sarah 80000.000000
 false
*/