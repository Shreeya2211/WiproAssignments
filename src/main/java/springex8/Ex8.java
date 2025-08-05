package springex8;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Ex8 {
    @SuppressWarnings("resource")
	public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("spring-aop-config.xml");

        ShoppingService service = (ShoppingService) context.getBean("shoppingService");

        service.addToCart("Laptop");
        service.makePayment(1499.99);
        service.placeOrder();
    }
}
