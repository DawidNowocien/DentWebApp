package pl.dentsys;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

//@Import(JpaConfiguration.class)
@SpringBootApplication(scanBasePackages={"pl.dentsys"})
public class Application {
	
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

}
