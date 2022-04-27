package org.greyhawk.ejercicio;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@SuppressWarnings("checkstyle:HideUtilityClassConstructor")
@SpringBootApplication
@EnableMongoRepositories
public class EjercicioApplication {

    public static void main(final String[] args) {
        SpringApplication.run(EjercicioApplication.class, args);
    }

}
