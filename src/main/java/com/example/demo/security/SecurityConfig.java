package com.example.demo.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
public class SecurityConfig {

	@Autowired
	JwtFilter jwtFilter;

	@Bean
	public AuthenticationManager authManager(HttpSecurity http, UserDetailsService us) throws Exception {

		return http.getSharedObject(AuthenticationManagerBuilder.class).userDetailsService(us).and().build();
	}

	@Bean
	public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {

		http.csrf().disable().sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);

		http.authorizeHttpRequests().requestMatchers("/noticias/todas").permitAll();
		http.authorizeHttpRequests().requestMatchers("/user/*").permitAll();

		http.authorizeHttpRequests().requestMatchers("/noticias/insertar").authenticated()
				.requestMatchers("/noticias/misnoticias").authenticated().anyRequest().permitAll();

						http
				.addFilterBefore(jwtFilter, UsernamePasswordAuthenticationFilter.class);

		return http.build();

	}

}
