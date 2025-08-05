package springmain;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MainApp2 {
    public static void main(String[] args) {
        ApplicationContext context =
                new ClassPathXmlApplicationContext("spring-config.xml");

        Account acc = (Account) context.getBean("account");
        acc.showAccountInfo();

        ((ClassPathXmlApplicationContext) context).close();
    }
}
