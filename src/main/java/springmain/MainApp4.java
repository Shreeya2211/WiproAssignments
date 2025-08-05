package springmain;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MainApp4
{
    public static void main(String[] args)
    {
        ApplicationContext context = new ClassPathXmlApplicationContext("account-config.xml");
        Account1 acc = (Account1) context.getBean("acc");
        acc.displayDetails();
        ((ClassPathXmlApplicationContext) context).close();
    }
}
