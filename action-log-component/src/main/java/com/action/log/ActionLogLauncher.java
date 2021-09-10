package com.action.log;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@SpringBootApplication
@ComponentScan(basePackages = {"org.openapitools", "com.action.log.api.generated", "org.openapitools.configuration", "com.action.log"})
@EnableMongoRepositories(basePackages = "com.action.log.repositories")
public class ActionLogLauncher {
    public static void main(String[] args) throws Exception {
        new SpringApplication(ActionLogLauncher.class).run(args);
    }
}
