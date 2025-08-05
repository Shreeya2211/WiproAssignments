package com.main;
import com.bean.Product;
import com.dao.ProductDao;

import java.util.Scanner;

public class BillingPageApplication {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ProductDao dao = new ProductDao();

        try {
            System.out.print("Enter Product Code: ");
            String code = scanner.nextLine();

            Product product = dao.getProductByCode(code);

            System.out.print("Enter Quantity: ");
            int quantity = scanner.nextInt();

            double total = product.getProductPrice() * quantity;

            System.out.println("\n----- Final Bill -----");
            System.out.println("Product: " + product.getProductName());
            System.out.println("Category: " + product.getProductCategory());
            System.out.println("Unit Price: ₹" + product.getProductPrice());
            System.out.println("Quantity: " + quantity);
            System.out.println("Total: ₹" + total);
            System.out.println("----------------------");

        } catch (Exception e) {
            System.err.println("Error: " + e.getMessage());
        }

        scanner.close();
    }
}
