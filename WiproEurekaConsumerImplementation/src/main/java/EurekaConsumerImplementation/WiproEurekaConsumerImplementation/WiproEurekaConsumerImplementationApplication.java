package EurekaConsumerImplementation.WiproEurekaConsumerImplementation;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients(basePackages = "com.feignclient")
public class WiproEurekaConsumerImplementationApplication {

	public static void main(String[] args) {
		SpringApplication.run(WiproEurekaConsumerImplementationApplication.class, args);
	}

}
