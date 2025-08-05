/* 31.Write a program to demonstrate the InputMismatchException and StringIndexOutOfBoundsException. */
package myassignments;
import java.io.*;

public class Exercise31 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        // Simulate InputMismatchException
        try {
            System.out.print("Enter a number: ");
            int num = Integer.parseInt(reader.readLine());
            System.out.println("Number is: " + num);
        } catch (NumberFormatException e) {
            System.out.println("InputMismatchException: Not a valid number.");
        }

        // Demonstrate StringIndexOutOfBoundsException
        try {
            System.out.print("Enter a word: ");
            String word = reader.readLine();

            System.out.print("Enter index: ");
            int index = Integer.parseInt(reader.readLine());

            System.out.println("Character at index " + index + ": " + word.charAt(index));
        } catch (StringIndexOutOfBoundsException e) {
            System.out.println("StringIndexOutOfBoundsException: Index is out of range.");
        } catch (NumberFormatException e) {
            System.out.println("Invalid index input.");
        }
    }
}
/* 
Enter a number: ten
InputMismatchException: Not a valid number.
Enter a word: hello
Enter index: 10
StringIndexOutOfBoundsException: Index is out of range.
*/

