package springmain;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MainApp3
{
    public static void main(String[] args)
    {
        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(AppConfig1.class); // changed

        Freshman student = context.getBean(Freshman.class);
        student.showInfo();

        context.close();
    }
}
