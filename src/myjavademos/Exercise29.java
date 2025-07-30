/* 29.Read the Register Number and Mobile Number of a student. If the Register Number does not contain exactly 9 characters or if the Mobile Number does not contain exactly 10 characters, throw an IllegalArgumentException. If the Mobile Number contains any character other than a digit, raise a NumberFormatException. If the Register Number contains any character other than digits and alphabets, throw a NoSuchElementException. If they are valid, print the message ‘valid’ else ‘invalid’ */

package myjavademos;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class Exercise29
{

    public static void main(String[] args) throws NumberFormatException
    {
        Scanner scanner = new Scanner(System.in);

        try
        {
            // Read Register Number
            System.out.print("Enter Register Number: ");
            String regNo = scanner.nextLine();

            // Read Mobile Number
            System.out.print("Enter Mobile Number: ");
            String mobileNo = scanner.nextLine();

            // Validate Register Number length
            if (regNo.length() != 9)
            {
                throw new IllegalArgumentException("Register Number must be exactly 9 characters");
            }

            // Validate Mobile Number length
            if (mobileNo.length() != 10)
            {
                throw new IllegalArgumentException("Mobile Number must be exactly 10 digits");
            }

            // Check if Register Number contains only alphabets and digits
            if (!regNo.matches("[a-zA-Z0-9]+"))
            {
                throw new NoSuchElementException("Register Number contains invalid characters");
            }

            // Check if Mobile Number contains only digits
            if (!mobileNo.matches("\\d+"))
            {
                throw new NumberFormatException("Mobile Number must contain only digits");
            }

            // If all validations passed
            System.out.println("valid");

        } catch (IllegalArgumentException | NoSuchElementException e)
        {
            System.out.println("invalid");
            // Optionally print error message: System.out.println(e.getMessage());
        } finally
        {
            scanner.close();
        }
    }
}
/* Enter Register Number: TS03FB094
Enter Mobile Number: 9876543210
valid
*/