package springmain;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan("springmain")
public class AppConfig1
{

    @Bean
    public DormRoom roomA()
    {
        return new DormRoom(101, "Alpha Hall");
    }

    @Bean
    public DormRoom roomB()
    {
        return new DormRoom(202, "Beta Block");
    }
}
