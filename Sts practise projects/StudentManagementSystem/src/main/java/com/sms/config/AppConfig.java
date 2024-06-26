package com.sms.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

//@Configuration
//public class AppConfig {
//	@Bean
//	public SecurityFilterChain springSecurityConfiguration(HttpSecurity http) throws Exception{
//		
//		http.authorizeHttpRequests(auth ->{
//			auth.requestMatchers(HttpMethod.POST, "/Student").permitAll()
//			.requestMatchers(HttpMethod.GET, "/Student/id").hasRole("USER")
//			.requestMatchers(HttpMethod.GET,"/Student").hasRole("ADMIN")
//			.anyRequest().authenticated();
//		})
//		.csrf(csrf -> csrf.disable())
//		.formLogin(Customizer.withDefaults())
//		.httpBasic(Customizer.withDefaults());
//		
//		return http.build();
//		
//		}
//	
//	@Bean
//	public PasswordEncoder getPasswordEncoder() {
//		return new BCryptPasswordEncoder();
//	}
//}

@Configuration
public class AppConfig {
	@Bean
	public SecurityFilterChain springSecurityConfiguration(HttpSecurity http) throws Exception {
		http.authorizeHttpRequests(auth ->{
			auth.requestMatchers(HttpMethod.POST, "/Student").permitAll()
			.anyRequest().authenticated();
		})
		.csrf(csrf -> csrf.disable())
		.formLogin(Customizer.withDefaults())
		.httpBasic(Customizer.withDefaults());
		return http.build();
		}
	
	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
}
