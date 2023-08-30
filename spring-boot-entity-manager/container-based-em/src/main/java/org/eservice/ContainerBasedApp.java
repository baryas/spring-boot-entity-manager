package org.eservice;

import org.eservice.config.JpaConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;

@SpringBootApplication
@Import(JpaConfig.class)
public class ContainerBasedApp {
    public static void main(String[] args) {
        SpringApplication.run(ContainerBasedApp.class);
    }
}