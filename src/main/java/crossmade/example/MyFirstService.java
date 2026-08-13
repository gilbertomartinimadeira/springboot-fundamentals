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
    @PropertySource("classpath:application.development.properties"),
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

    @Value("${my.prop}")
    public String myPropFromDev;

    @Value("${my.custom.prop}")
    public String myPropFromCustom;

    @Autowired
    public void setEnvironment(Environment environment) {
        this.environment = environment;
    }

    public MyFirstService( @Qualifier("bean1") MyFirstClass myFirstClass ) {
        this.myFirstClass = myFirstClass;
    }

    // if I uncomment this, it will have precedence over the constructor injection
    // @Autowired
    // public void injectDependencies(@Qualifier("myThirdBean") MyFirstClass myFirstClass){
    //     this.myFirstClass = myFirstClass;
    // }

    public String tellAStory() {
        return "The service bean is saying "+ myFirstClass.sayHello() + " with myPropFromDev = "+ this.myPropFromDev + " and my.propFromCustom = " + this.myPropFromCustom;
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
        // TODO Auto-generated method stub
        return  this.environment.getProperty("my.custom.property");
    }
}
