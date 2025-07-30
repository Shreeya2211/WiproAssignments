package myjavademos;

/*9.A shopkeeper sells three products whose retail prices are as follows: 
Product 1 - 22.50
              Product 2 - 44.50 
              Product 3 - 9.98
Write an application that reads a series of pairs of numbers as follows:
 a) Product number 
 b) Quantity sold

                The application should use a switch statement to determine the retail price for each product. It 
should calculate and display the total retail value of all products sold.*/


import java.util.Scanner;

public class Exercise9
{
	    public static void main(String[] args)
	    {
	        // Use try-with-resources to auto-close Scanner
	        try (Scanner sc = new Scanner(System.in))
	        {
	            double total = 0.0;  // to keep track of total amount

	            System.out.println("Welcome to the shop!");
	            System.out.println("Product Prices:");
	            System.out.println("1. Product 1 - ₹22.50");
	            System.out.println("2. Product 2 - ₹44.50");
	            System.out.println("3. Product 3 - ₹9.98");
	            System.out.println("Enter -1 to stop entering items.\n");

	            while (true) {
	                System.out.print("Enter product number (1, 2, 3 or -1 to stop): ");
	                int productNumber = sc.nextInt();

	                
	                if (productNumber == -1) {
	                    break;
	                }

	                // Check for valid product number
	                if (productNumber < 1 || productNumber > 3) {
	                    System.out.println("Invalid product number. Please enter 1, 2, or 3.");
	                    continue; 
	                }

	                System.out.print("Enter quantity sold: ");
	                int quantity = sc.nextInt();

	                double price = 0.0;

	                // Use switch to find price
	                switch (productNumber)
	                {
	                    case 1: price = 22.50; break;
	                    case 2: price = 44.50; break;
	                    case 3: price = 9.98;  break;
	                }

	                double amount = price * quantity;
	                total += amount;

	                System.out.printf("Added ₹%.2f to total.\n\n", amount);
	            }

	            
	            System.out.printf("\nTotal retail value of all products sold: ₹%.2f\n", total);
	        }
 }
 }
/*
Welcome to the shop!
Product Prices:
1. Product 1 - ₹22.50
2. Product 2 - ₹44.50
3. Product 3 - ₹9.98
Enter -1 to stop entering items.

Enter product number (1, 2, 3 or -1 to stop): 1
Enter quantity sold: 2
Added ₹45.00 to total.

Enter product number (1, 2, 3 or -1 to stop): -1

Total retail value of all products sold: ₹45.00
*/