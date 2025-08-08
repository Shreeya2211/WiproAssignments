package springbootassi15;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication(scanBasePackages = "springbootassi15")
@EnableJpaRepositories(basePackages = "springbootassi15.repository")
@EntityScan(basePackages = "springbootassi15.entity")
public class Springbootassi15Application {

	public static void main(String[] args) {
		SpringApplication.run(Springbootassi15Application.class, args);
	}
}
