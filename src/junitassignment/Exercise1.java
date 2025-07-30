
/*
 1.Write a test class that checks if the method returns correct factorials for valid inputs and throws IllegalArgumentException for negative numbers.

 */

package junitassignment;

public class Exercise1
{

    // Method to calculate factorial
    public static long factorial(int n)
    {
        if (n < 0) {
            throw new IllegalArgumentException("Factorial is not defined for negative numbers");
        }
        long result = 1;
        for (int i = 2; i <= n; i++)
        {
            result *= i;
        }
        return result;
    }
}
