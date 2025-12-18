package com.code.springbootdemo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class Config {
	@Bean
public SecurityFilterChain filterchain(HttpSecurity http) throws Exception {
	http.authorizeHttpRequests(authz->
		authz.requestMatchers("/hello/**").authenticated()
		.requestMatchers("/hi").permitAll()
		.anyRequest().permitAll()
	)
	.formLogin(form-> form.permitAll().defaultSuccessUrl("/demo",true));
	
	return http.build();
	}
	@Bean
	public UserDetailsService userDetailsService(PasswordEncoder passwordEncoder) {
		UserDetails user=User.withUsername("ajay")
				.password(passwordEncoder.encode("ajay123"))
				.roles("USER")
				.build();
		UserDetails admin=User.withUsername("vishal")
				.password(passwordEncoder.encode("vishal123"))
				.roles("ADMIN")
				.build();
		return new InMemoryUserDetailsManager(user,admin);
				}
	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
}

