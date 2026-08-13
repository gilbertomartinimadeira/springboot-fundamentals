package crossmade.example;

// import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
// import org.springframework.context.annotation.Primary;

@Configuration
public class ApplicationConfig {
    //@Bean("myBean")
	@Bean("bean1")
	// @Qualifier("bean1")
	public MyFirstClass myFirstBean() {
		return new MyFirstClass("First Bean");
	}

	@Bean
	// @Qualifier("bean2")
	public MyFirstClass mySecondBean() { // we can use the bean name as qualifier ( in this case the method name if we don't have one )
		return new MyFirstClass("Second Bean");
	}

	@Bean
	//@Primary
	public MyFirstClass myThirdBean() {
		return new MyFirstClass("Third Bean");
	}
}
