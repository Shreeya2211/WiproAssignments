package myjavademos;
/* 24.Five Bikers Compete in a race such that they drive at a constant speed which may or may
not be the same as the other. To qualify the race, the speed of a racer must be more than the
average speed of all 5 racers. Take as input the speed of each racer and print back the speed
of qualifying racers. 
 */
//Exercise24.java
import java.util.Scanner;

public class Exercise24
{
 public static void main(String[] args)
 {
     Scanner scanner = new Scanner(System.in);
     double[] speeds = new double[5];
     double total = 0;

     // Input speeds of 5 racers
     for (int i = 0; i < 5; i++)
     {
         System.out.print("Enter speed of racer " + (i + 1) + ": ");
         speeds[i] = scanner.nextDouble();
         total += speeds[i];
     }

     double averageSpeed = total / 5;
     System.out.println("Average speed: " + averageSpeed);

     System.out.println("Qualifying racers (speed > average):");
     boolean found = false;
     for (double speed : speeds)
     {
         if (speed > averageSpeed)
         {
             System.out.println(speed);
             found = true;
         }
     }

     if (!found) {
         System.out.println("No racers qualified.");
     }

     scanner.close();
 }
}
/* 
Enter speed of racer 1: 45
Enter speed of racer 2: 50
Enter speed of racer 3: 55
Enter speed of racer 4: 60
Enter speed of racer 5: 65
Average speed: 55.0
Qualifying racers (speed > average):
60.0
65.0
*/
