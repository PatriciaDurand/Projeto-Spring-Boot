package formulario;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * Created by patriciadurand on 22/04/16.
 */

@Configuration
@EnableAutoConfiguration
@ComponentScan
//ou usar @SpringApplication

public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}
