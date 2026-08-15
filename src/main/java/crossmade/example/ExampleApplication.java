package crossmade.example;

import java.util.Collections;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ExampleApplication {

	public static void main(String[] args) {
		var app = new SpringApplication(ExampleApplication.class);

		app.setDefaultProperties(Collections.singletonMap("spring.profiles.active","dev"));

		app.run(args);
	}
} // Time 4:47:
 // 1:57:44 - Spring REST

