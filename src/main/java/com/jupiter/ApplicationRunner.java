package com.jupiter;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;

/**
 * Entry point class for starting the application
 */
@SpringBootApplication
public class ApplicationRunner {
    public static void main(String[] as) {
        SpringApplication.run(ApplicationRunner.class, as);
    }
}
