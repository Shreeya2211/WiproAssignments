package myjavademos;

/*10. Consider user has N eggs. Then display the no of eggs in gross (144 eggs make one gross) and 
no of eggs in dozen (12 eggs make one dozen) and the no of eggs that is left out remaining. 
The total no of eggs can be got as input through command line. The program should display
how many gross, how many dozen, and how many left over eggs the user has.

Solution Guidance (if applicable): For example, if the input is 1342 eggs, then the program should respond with 
        Your number of eggs is 9 gross, 3 dozen, and 10*/


public class Exercise10
{
 public static void main(String[] args)
 {
     // Check if user has passed an argument
     if (args.length == 0) {
         System.out.println("Please provide the number of eggs as a command line argument.");
         return;
     }

     // Parse the input
     int totalEggs = Integer.parseInt(args[0]);

     // Constants
     int gross = 144;
     int dozen = 12;

     // Calculations
     int grossCount = totalEggs / gross;
     int remainingAfterGross = totalEggs % gross;

     int dozenCount = remainingAfterGross / dozen;
     int leftoverEggs = remainingAfterGross % dozen;

     
     System.out.println("Your number of eggs is: " + grossCount + " gross, " + dozenCount + " dozen, and " + leftoverEggs + " egg(s).");
 }
}
/*
Your number of eggs is: 9 gross, 3 dozen, and 10 egg(s).*/
