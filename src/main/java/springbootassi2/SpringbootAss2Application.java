package springbootassi2;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.beans.factory.annotation.Autowired;

@SpringBootApplication
public class SpringbootAss2Application implements CommandLineRunner {

    @Autowired
    private ConfigValues configValues;

    public static void main(String[] args) {
        SpringApplication.run(SpringbootAss2Application.class, args);
    }

    @Override
    public void run(String... args) {
        configValues.display();
    }
}
