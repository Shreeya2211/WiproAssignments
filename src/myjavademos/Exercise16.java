package myjavademos;
/* 16.Write a program that prompts user for the mark (between 0-100 in int) of 3 students; computes the average (in double); and prints the result rounded to 2 decimal places. Your program needs to perform input validation. For examples,

Enter the mark (0-100) for student 1: 56
Enter the mark (0-100) for student 2: 101
Invalid input, try again...
Enter the mark (0-100) for student 2: -1
Invalid input, try again...
Enter the mark (0-100) for student 2: 99
Enter the mark (0-100) for student 3: 45
The average is: 66.67
 */
import java.util.Scanner;

public class Exercise16 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int mark;
        int total = 0;
        int count = 0;

        while (count < 3) {
            System.out.print("Enter the mark (0-100) for student " + (count + 1) + ": ");
            mark = scanner.nextInt();

            if (mark >= 0 && mark <= 100) {
                total += mark;
                count++;
            } else {
                System.out.println("Invalid input, try again...");
            }
        }

        double average = total / 3.0;
        System.out.printf("The average is: %.2f\n", average);
        
        scanner.close();
    }
}
/*
 Enter the mark (0-100) for student 1: 99
Enter the mark (0-100) for student 2: 98
Enter the mark (0-100) for student 3: 97
The average is: 98.00
*/
