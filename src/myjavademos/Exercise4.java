package myjavademos;

import java.util.Scanner;

/*4.Take name, roll number and field of interest from user and print in the format below :
Hey, my name is xyz and my roll number is xyz. My field of interest are xyz.*/

public class Exercise4
{
	@SuppressWarnings("resource")
	public static void main(String[] args)
	{
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter your name: ");
        String name = sc.nextLine();

        System.out.print("Enter your roll number: ");
        String rollNo = sc.nextLine();

        System.out.print("Enter your field of interest: ");
        String interest = sc.nextLine();

        System.out.println("Hey, my name is " + name + " and my roll number is " + rollNo + ". My field of interest is " + interest + ".");

      }
}
/*
Enter your name: shreeya
Enter your roll number: 21
Enter your field of interest: cyberscurity
Hey, my name is shreeya and my roll number is 21. My field of interest is cyberscurity.
*/