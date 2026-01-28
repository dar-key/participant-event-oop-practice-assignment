import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.persistence.autoconfigure.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@ComponentScan(basePackages = { "controllers", "services", "exceptions" })
@EnableJpaRepositories(basePackages = { "repositories" })
@EntityScan(basePackages = { "models" })
public class App {
    public static void main(String[] args) {
        SpringApplication.run(App.class, args);
    }
}
