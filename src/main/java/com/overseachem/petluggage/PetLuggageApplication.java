package com.overseachem.petluggage;

import com.overseachem.petluggage.utils.Command;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class PetLuggageApplication {

    public static void main(String[] args) {

        SpringApplication.run(PetLuggageApplication.class, args);
    }
}
