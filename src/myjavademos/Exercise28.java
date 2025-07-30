/* 28.
Write the following methods that return a lambda expression performing a specified action:

PerformOperation isOdd(): The lambda expression must return true  if a number is odd or false  if it is even.
PerformOperation isPrime(): The lambda expression must return  true if a number is prime or false  if it is composite.
PerformOperation isPalindrome(): The lambda expression must return true   if a number is a palindrome or false  if it is not.
 */
package myjavademos;

// Functional interface
interface PerformOperation
{
    boolean check(int a);
}

public class Exercise28
{

    // Lambda to check if number is odd
    public static PerformOperation isOdd()
    {
        return (int a) -> a % 2 != 0;
    }

    // Lambda to check if number is prime
    public static PerformOperation isPrime()
    {
        return (int a) ->
        {
            if (a <= 1) return false;
            for (int i = 2; i <= Math.sqrt(a); i++)
            {
                if (a % i == 0) return false;
            }
            return true;
        };
    }

    // Lambda to check if number is palindrome
    public static PerformOperation isPalindrome()
    {
        return (int a) ->
        {
            int original = a, reversed = 0;
            while (a != 0)
            {
                int digit = a % 10;
                reversed = reversed * 10 + digit;
                a /= 10;
            }
            return original == reversed;
        };
    }

    
    public static void main(String[] args)
    {
        int num1 = 5;
        int num2 = 13;
        int num3 = 121;

        System.out.println("Is " + num1 + " odd? " + isOdd().check(num1));
        System.out.println("Is " + num2 + " prime? " + isPrime().check(num2));
        System.out.println("Is " + num3 + " palindrome? " + isPalindrome().check(num3));
    }
}
/*
Is 5 odd? true
Is 13 prime? true
Is 121 palindrome? true
*/