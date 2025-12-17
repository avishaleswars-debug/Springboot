package com.code.springbootdemo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class Config {
	@Bean
public SecurityFilterChain filterchain(HttpSecurity http) throws Exception {
	http.authorizeHttpRequests(authz->
		authz.requestMatchers("/hello").authenticated()
		.requestMatchers("/hi").permitAll()
	);
	return http.build();
}
}
