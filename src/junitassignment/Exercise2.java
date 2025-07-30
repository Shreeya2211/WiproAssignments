/* 2.Test a method that reverses a string
Include test cases for null input, empty string, and a regular string */
package junitassignment;

public class Exercise2
{

    // Method to reverse a string
    public static String reverseString(String input)
    {
        // Check for null input
        if (input == null) {
            throw new IllegalArgumentException("Input string cannot be null");
        }

        // Reverse the string using StringBuilder
        return new StringBuilder(input).reverse().toString();
    }
}

