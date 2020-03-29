package rmi.demo.springtestdbunitdemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;

@SpringBootApplication(exclude = { SecurityAutoConfiguration.class })
public class SpringTestDbunitDemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringTestDbunitDemoApplication.class, args);
	}

}
