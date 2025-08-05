package springmain;

import com.bean.Product;
import com.service.BillingException;
import com.service.ProductService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Scanner;

public class MainApp5 {
    @SuppressWarnings("resource")
	public static void main(String[] args) {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("spring-jdbc-config.xml");
        ProductService service = ctx.getBean("productService", ProductService.class);

        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.println("1. Generate Bill by entering code and quantity");
            System.out.println("2. Exit");
            int choice = sc.nextInt();

            if (choice == 2) break;
            if (choice != 1) {
                System.out.println("Enter option 1 or 2 only\n");
                continue;
            }

            try {
                System.out.print("Enter product_code: ");
                int code = sc.nextInt();
                if (!service.validateProductCode(code)) {
                    throw new BillingException("Invalid product_code, it should be >0 and 4 digit +ve number");
                }

                System.out.print("Enter quantity: ");
                int qty = sc.nextInt();
                if (!service.validateQuantity(qty)) {
                    throw new BillingException("Invalid quantity, it should be >0");
                }

                Product p = service.getProductDetails(code);
                double total = service.calculatePrice(qty, p.getProduct_price());

                System.out.println("Product Name: " + p.getProduct_name());
                System.out.println("Product Category: " + p.getProduct_category());
                System.out.println("Product Description: " + p.getProduct_description());
                System.out.println("Product Price(Rs): " + p.getProduct_price());
                System.out.println("Quantity: " + qty);
                System.out.println("→ Total Bill Amount: Rs." + total + "\n");

            } catch (BillingException e) {
                System.out.println(e.getMessage());
            } catch (Exception e) {
                System.out.println("Product not found or error: " + e.getMessage());
            }
        }
        sc.close();
    }
}
