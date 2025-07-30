package myjavademos;

/*8.Modify the above question to allow student to sit if he/she has medical cause. Ask user if he/she has medical cause or not ( 'Y' or 'N' ) and print accordingly.*/


import java.util.Scanner;

public class Exercise8 {
 @SuppressWarnings("resource")
public static void main(String[] args) {
     Scanner sc = new Scanner(System.in);

     // Input: total classes held and attended
     System.out.print("Enter number of classes held: ");
     int totalClasses = sc.nextInt();

     System.out.print("Enter number of classes attended: ");
     int attendedClasses = sc.nextInt();

     // Validate input
     if (attendedClasses > totalClasses || totalClasses <= 0) {
         System.out.println("Invalid input. Please check the values.");
         return;
     }

     // Calculate attendance percentage
     double attendancePercentage = ((double) attendedClasses / totalClasses) * 100;
     System.out.printf("Attendance Percentage: %.2f%%\n", attendancePercentage);

     // Attendance rule check
     if (attendancePercentage >= 70)
     {
         System.out.println("Student is allowed to sit in the exam.");
     } else
     {
         
         System.out.print("Do you have a medical cause? (Y/N): ");
         char medicalCause = sc.next().charAt(0);

         if (medicalCause == 'Y' || medicalCause == 'y')
         {
             System.out.println("Student is allowed to sit in the exam due to medical cause.");
         } else
         {
             System.out.println("Student is NOT allowed to sit in the exam.");
         }
     }
 }
}
/*
 Enter number of classes held: 50
Enter number of classes attended: 25
Attendance Percentage: 50.00%
Do you have a medical cause? (Y/N): y
Student is allowed to sit in the exam due to medical cause.
*/
