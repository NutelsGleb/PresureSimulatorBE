package nutels.presuresimulator.be;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories(basePackages = {"nutels.presuresimulator.be"})
//@ComponentScan(basePackages = {"nutels.presuresimulator.be.rest", "nutels.presuresimulator.be.service"})
public class PresureSimulatorApplication {

    public static void main(String[] args) {
        SpringApplication.run(PresureSimulatorApplication.class, args);
    }

}
