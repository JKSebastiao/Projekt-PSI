package pl.edu.pwr.psi_project;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import pl.edu.pwr.psi_project.initDB.DBInit;

@SpringBootApplication
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @Bean
    public CommandLineRunner demo (final DBInit dbInit){
        return (args) ->{
            dbInit.addPracowniki();
            dbInit.addStudent();
        };
    }
}
