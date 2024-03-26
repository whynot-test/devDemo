package com.example.devdemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@EnableCaching
public class DevDemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(DevDemoApplication.class, args);
    }

}
