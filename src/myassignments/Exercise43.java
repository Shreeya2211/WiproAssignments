/*
 * 43.Write a Java program to read the contents of a text file using BufferedReader and try-with-resources. 
 * The program should handle exceptions gracefully using proper exception handling techniques.
 */
package myassignments;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Exercise43
{
    public static void main(String[] args)
    {
        String filePath = "src/myassignments/sample.txt";

        // Try-with-resources ensures BufferedReader is closed automatically
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            System.out.println("Contents of the file:");
            while ((line = br.readLine()) != null) {
                System.out.println(line);
            }
        } catch (IOException e) {
            System.out.println("An error occurred while reading the file:");
            e.printStackTrace(); // For debugging, shows the cause
        }
    }
}
/*
Contents of the file:
Contents of the file:
Hello, this is line 1.
This is line 2.
End of file.
*/