package myjavademos;

/*1.Write a program to add 8 to the number 2345 and then divide it by 3. Now, the modulus of the quotient is taken with 5 and then multiply the resultant value by 5. Display the final result.*/

public class Exercise1
{
    public static void main(String[] args)
    {
        int number = 2345;

        number = number + 8;         // Add 8 → 2345 + 8 = 2353
        number = number / 3;         // Divide by 3 → 2353 / 3 = 784
        number = number % 5;         // Modulus with 5 → 784 % 5 = 4
        number = number * 5;         // Multiply by 5 → 4 * 5 = 20

        System.out.println("Final result: " + number); 
    }
}
/* 
Final result: 20
*/