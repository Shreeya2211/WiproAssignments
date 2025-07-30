package myjavademos;

/*7.A student will not be allowed to sit in exam if his/her attendence is less than 70%.
Take following input from user
Number of classes held
Number of classes attended.
And print
percentage of class attended
Is student is allowed to sit in exam or not.*/

import java.util.Scanner;

public class Exercise7
{
 @SuppressWarnings("resource")
public static void main(String[] args)
 {
     Scanner sc = new Scanner(System.in);

     // Input: total classes held and attended
     System.out.print("Enter number of classes held: ");
     int totalClasses = sc.nextInt();

     System.out.print("Enter number of classes attended: ");
     int attendedClasses = sc.nextInt();

     // Validate input
     if (attendedClasses > totalClasses || totalClasses <= 0)
     {
         System.out.println("Invalid input. Please check the values.");
         return;
     }

     // Calculate percentage
     double attendancePercentage = ((double) attendedClasses / totalClasses) * 100;
     System.out.printf("Attendance Percentage: %.2f%%\n", attendancePercentage);

     // Check eligibility
     if (attendancePercentage >= 70) {
         System.out.println("Student is allowed to sit in the exam.");
     } else {
         System.out.println("Student is NOT allowed to sit in the exam.");
     }
 }
}
/*
Enter number of classes held: 70
Enter number of classes attended: 50
Attendance Percentage: 71.43%
Student is allowed to sit in the exam.
*/
