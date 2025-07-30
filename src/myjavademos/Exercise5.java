package myjavademos;

/*5.A company decided to give bonus of 10% to employee if his/her year of service is more than 6 years.
Ask user for their salary and year of service and print the net bonus amount.*/

import java.util.Scanner;

public class Exercise5
{
 @SuppressWarnings("resource")
public static void main(String[] args)
 {
     Scanner sc = new Scanner(System.in);

     // Input salary and years of service
     System.out.print("Enter your current salary: ");
     double salary = sc.nextDouble();

     System.out.print("Enter your years of service: ");
     int years = sc.nextInt();

     // Check eligibility and calculate bonus and net amount
     if (years > 6) {
         double bonus = 0.10 * salary;
         double netAmount = salary + bonus;

         System.out.println("You are eligible for a bonus of: ₹" + bonus);
         System.out.println("Your net amount after adding bonus is: ₹" + netAmount);
     } else {
         System.out.println("You are not eligible for a bonus.");
         System.out.println("Your net amount remains: ₹" + salary);
     }
 }
}
/*
Enter your current salary: 55000
Enter your years of service: 6
You are not eligible for a bonus.
Your net amount remains: ₹55000.0
*/
