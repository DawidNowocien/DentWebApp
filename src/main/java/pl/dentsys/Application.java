package pl.dentsys;

import javax.annotation.PostConstruct;

import org.hsqldb.util.DatabaseManagerSwing;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@EnableJpaRepositories
@SpringBootApplication(scanBasePackages={"pl.dentsys"})
public class Application {
	
    public static void main(String[] args) {
        //SpringApplication.run(Application.class, args);
    	SpringApplicationBuilder builder = new SpringApplicationBuilder(Application.class);
    	builder.headless(false);
    	ConfigurableApplicationContext context = builder.run(args);
    }
    
    @PostConstruct
    public void startDBManager() {

    	//hsqldb
    	DatabaseManagerSwing.main(new String[] { "--url", "jdbc:hsqldb:mem:PUBLIC", "--user", "sa", "--password", "" });

    }

}
