package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
//import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;


@SpringBootApplication(scanBasePackages = "com.example.demo")
public class F1newsApplication {

	public static void main(String[] args) {
		SpringApplication.run(F1newsApplication.class, args);
	}

	

}
