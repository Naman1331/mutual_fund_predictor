package com.example.investments.mutual_fund_calculator;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**")  // Allow all endpoints
                .allowedOrigins("http://localhost:4200")  // Allow the Angular frontend to make requests
                .allowedMethods("GET", "POST", "PUT", "DELETE")  // Allow necessary HTTP methods
                .allowedHeaders("*");  // Allow all headers
    }
}
