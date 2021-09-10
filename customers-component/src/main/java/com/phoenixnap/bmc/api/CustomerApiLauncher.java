package com.phoenixnap.bmc.api;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = {"org.openapitools", "com.phoenixnap.bmc.api", "org.openapitools.configuration"})
public class CustomerApiLauncher {

    public static void main(String[] args) throws Exception {
        new SpringApplication(CustomerApiLauncher.class).run(args);
    }


}
