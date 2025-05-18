package dev.avee.bettersecurity.application;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = "dev.avee")
public class BettersecurityApplication {

    public static void main(String[] args) {
        SpringApplication.run(BettersecurityApplication.class, args);
    }

}
