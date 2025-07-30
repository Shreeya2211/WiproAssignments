package myjavademos;
/* 25.Create a class named MyTriangle that contains two static methods
a) public static double area(double a, double b, double c)
b) public static double perimeter(double a, double b, double c)
to compute area and perimeter of a triangle respectively given three valid
sides a, b and c.
And add a static method
/** Return true if the sum of any two sides is greater than the third side.
c) public static boolean isValid(double a, double b, double c)
In the main method of MyTriangle, test the three methods you write.
1) Get a, b and c from the Console
2) If a is -1, exit your program and print  Bye~ 
3) If a is not -1, use isValid to check the input
4) If the input is valid, compute the area and perimeter and print them
5) If the input is not valid, return false and print  The input is invalid. 
6) Go to 1)
*/


import java.util.Scanner;

public class Exercise25 {

    // Method to check if the triangle is valid
    public static boolean isValid(double a, double b, double c)
    {
        return (a + b > c) && (a + c > b) && (b + c > a);
    }

    // Method to calculate perimeter
    public static double perimeter(double a, double b, double c)
    {
        return a + b + c;
    }

    // Method to calculate area using Heron's formula
    public static double area(double a, double b, double c)
    {
        double s = perimeter(a, b, c) / 2;
        return Math.sqrt(s * (s - a) * (s - b) * (s - c));
    }

  
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.print("\nEnter side a (or -1 to exit): ");
            double a = sc.nextDouble();
            if (a == -1)
            {
                System.out.println("Bye~");
                break;
            }

            System.out.print("Enter side b: ");
            double b = sc.nextDouble();

            System.out.print("Enter side c: ");
            double c = sc.nextDouble();

            if (isValid(a, b, c)) {
                double peri = perimeter(a, b, c);
                double ar = area(a, b, c);
                System.out.printf("Perimeter = %.2f\n", peri);
                System.out.printf("Area = %.2f\n", ar);
            } else {
                System.out.println("The input is invalid.");
            }
        }

        sc.close();
    }
}
/*

Enter side a (or -1 to exit): 5
Enter side b: 5
Enter side c: 5
Perimeter = 15.00
Area = 10.83

Enter side a (or -1 to exit): -1
Bye~
*/