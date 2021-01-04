package ru.vienoulis.investor;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.ImportResource;

@SpringBootApplication
public class InvestorApplication {

    public static void main(String[] args) {
        SpringApplication.run(InvestorApplication.class, args);
    }

}
