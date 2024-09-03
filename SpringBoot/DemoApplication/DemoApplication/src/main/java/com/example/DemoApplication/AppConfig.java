package com.example.DemoApplication;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration

// Class
public class AppConfig {

    @Bean

    // Method
    public Student student() {

        return new Student(1, "Geek");
    }
}