package springmain;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@ComponentScan("springmain")
@PropertySource("classpath:datafile.properties")
public class AppConfig {
}
