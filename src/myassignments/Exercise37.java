/*
37.Write a program that creates a new file called batch mates and 
store your entire batch mates name in it and display the details.
 */
package myassignments;

import java.io.*;

public class Exercise37
{
    public static void main(String[] args)
    {
        String[] batchmates =
        	{
            "Rishika", "Shreya", "Varshini",
            "Sarah", "Shreeya", "Rishitha"
        };

        File file = new File("batchmates.txt");

        // Write batchmates to file
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(file)))
        {
            for (String name : batchmates)
            {
                writer.write(name);
                writer.newLine();
            }
            System.out.println("Batchmates names written to file successfully.");
        }
        catch (IOException e)
        {
            System.out.println("Error writing to file: " + e.getMessage());
        }

        // Read and display names from file
        System.out.println("\nBatchmates List:");
        try (BufferedReader reader = new BufferedReader(new FileReader(file)))
        {
            String name;
            while ((name = reader.readLine()) != null)
            {
                System.out.println(name);
            }
        } catch (IOException e)
        {
            System.out.println("Error reading from file: " + e.getMessage());
        }
    }
}
/*
Batchmates names written to file successfully.

Batchmates List:
Rishika
Shreya
Varshini
Sarah
Shreeya
Rishitha
*/
