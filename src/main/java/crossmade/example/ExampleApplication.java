package crossmade.example;

import java.util.Collections;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ExampleApplication {

	public static void main(String[] args) {
		//var context = SpringApplication.run(ExampleApplication.class, args);
		var app = new SpringApplication(ExampleApplication.class);

		app.setDefaultProperties(Collections.singletonMap("spring.profiles.active","dev"));

		var context = app.run(args);

		MyFirstService myFirstService = context.getBean(MyFirstService.class);

		System.out.println(myFirstService.tellAStory());
		System.out.println(myFirstService.getJavaVersion());
		System.out.println(myFirstService.getOsName());
		System.out.println(myFirstService.getJavaHome());
		System.out.println(myFirstService.getCustomProperty());
	}	
} // Time 2:22:00
 // 1:57:44 - Spring REST

