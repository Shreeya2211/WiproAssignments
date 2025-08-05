package springmain;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MainAppX
{
    public static void main(String[] args)
    {
        ApplicationContext context = new AnnotationConfigApplicationContext(ConfigX.class);
        ItemX item = context.getBean(ItemX.class);
        item.showItemInfo();
    }
}
