package springbootassi1;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SuppressWarnings("unused")
@SpringBootApplication
public class SpringBootAssi1Application implements CommandLineRunner {

    private final ClassKLM klm;

    public SpringBootAssi1Application(ClassKLM klm) {
        this.klm = klm;
    }

    public static void main(String[] args) {
        SpringApplication.run(SpringBootAssi1Application.class, args);
    }

    @Override
    public void run(String... args) {
        klm.show();
    }
}
