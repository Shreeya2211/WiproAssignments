
/* 30.Write a interface method minimum3 that returns the smallest of three floating-point numbers. Use the Math.min method
to implement minimum3. Incorporate the method into an application that reads three values from the user, determines the smallest value and displays the result. Use method references syntax.
 */

package myjavademos;

import java.util.Scanner;
import java.util.function.BinaryOperator;

interface MinFunction {
    float minimum3(float a, float b, float c);
}

public class Exercise30 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Read three floating-point numbers from user
        System.out.print("Enter first number: ");
        float num1 = scanner.nextFloat();

        System.out.print("Enter second number: ");
        float num2 = scanner.nextFloat();

        System.out.print("Enter third number: ");
        float num3 = scanner.nextFloat();

        // BinaryOperator<Float> to find minimum of two values using method reference
        BinaryOperator<Float> minOperator = Math::min;

        // Implementing the minimum3 method using method reference logic
        MinFunction minFunction = (a, b, c) -> minOperator.apply(minOperator.apply(a, b), c);

        // Find the smallest value among the three
        float minValue = minFunction.minimum3(num1, num2, num3);

        
        System.out.printf("The smallest value is: %.2f\n", minValue);

        scanner.close();
    }
}

/* 
 * Enter first number: 5.6
Enter second number: 2.5
Enter third number: 9.8
The smallest value is: 2.50 */
