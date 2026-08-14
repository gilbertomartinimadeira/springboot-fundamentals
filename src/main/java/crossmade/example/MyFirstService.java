package crossmade.example;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.PropertySources;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;

@Service
@PropertySources({
    @PropertySource("classpath:application-dev.properties"),
    @PropertySource("classpath:custom.properties")
})

public class MyFirstService {

    // @Autowired // field injection - not really recommended
    // @Qualifier("bean1") // Bean name being used as qualifier
    private final MyFirstClass myFirstClass;

    private Environment environment;

    public Environment getEnvironment() {
        return environment;
    }

    @Value("${my.custom.property}")
    public String myStringPropFromCustom;

    @Value("${my.custom.property.int}")
    public Integer myIntPropFromCustom;

    @Autowired
    public void setEnvironment(Environment environment) {
        this.environment = environment;
    }

    public MyFirstService( @Qualifier("mySecondBean") MyFirstClass myFirstClass ) {
        this.myFirstClass = myFirstClass;
    }

    // if I uncomment this, it will have precedence over the constructor injection
    // @Autowired
    // public void injectDependencies(@Qualifier("myThirdBean") MyFirstClass myFirstClass){
    //     this.myFirstClass = myFirstClass;
    // }

    public String tellAStory() {
        return "The service bean is saying "+ myFirstClass.sayHello() + " with myStringProp = "+ this.myStringPropFromCustom + " and myIntpropFromCustom = " + this.myIntPropFromCustom;
    }

    public String getJavaVersion() {
        return this.environment.getProperty("java.version");
    }

    public String getOsName() {
        return this.environment.getProperty("os.name");
    }

    public String getJavaHome(){
        return this.environment.getProperty("JAVA_HOME");
    }

    public String getCustomProperty() {
        return  this.environment.getProperty("my.custom.property");
    }
}
