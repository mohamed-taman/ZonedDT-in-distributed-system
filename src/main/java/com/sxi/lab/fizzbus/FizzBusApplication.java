package com.sxi.lab.fizzbus;

import lombok.extern.log4j.Log4j2;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Component;

@SpringBootApplication
public class FizzBusApplication {

    public static void main(String[] args) {
        SpringApplication.run(FizzBusApplication.class, args);
    }

    @Component
    @Log4j2
    public static class AppStartupRunner implements ApplicationRunner {

        @Override
        public void run(ApplicationArguments args) {
            log.info("Your application started with option names : {}", args.getOptionNames());
        }
    }

}
