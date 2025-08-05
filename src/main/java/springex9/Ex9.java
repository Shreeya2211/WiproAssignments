package springex9;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Ex9 {
    @SuppressWarnings("resource")
	public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("spring-config-ex9.xml");
        Purchase purchase = (Purchase) context.getBean("purchase");
        purchase.displayDetails();
    }
}
