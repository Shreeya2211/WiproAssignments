package myjavademos;

/*6.A school has following rules for grading system:
a. Below 25 - F
b. 25 to 45 - E
c. 45 to 50 - D
d. 50 to 60 - C
e. 60 to 80 - B
f. Above 80 - A
Ask user to enter marks and print the corresponding grade.*/

import java.util.Scanner;

public class Exercise6
{
    @SuppressWarnings("resource")
	public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);

        // Input marks from the user
        System.out.print("Enter your marks (0-100): ");
        int marks = sc.nextInt();

        // Validate and determine grade
        if (marks < 0 || marks > 100)
        {
            System.out.println("Invalid marks! Please enter a value between 0 and 100.");
        } 
        else if (marks < 25)
        {
            System.out.println("Grade: F");
        } 
        else if (marks < 45)
        {
            System.out.println("Grade: E");
        } 
        else if (marks < 50)
        {
            System.out.println("Grade: D");
        } else if (marks < 60)
        {
            System.out.println("Grade: C");
        } 
        else if (marks < 80)
        {
            System.out.println("Grade: B");
        } else
        {
            System.out.println("Grade: A");
        }
    }
}

/*
Enter your marks (0-100): 99
Grade: A
*/