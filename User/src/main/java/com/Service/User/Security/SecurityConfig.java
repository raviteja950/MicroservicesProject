package com.Service.User.Security;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;


@Configuration
public class SecurityConfig {

	private jwtSecurityFilter securityFilter;

	public SecurityConfig(jwtSecurityFilter Utility) {
		this.securityFilter = Utility;
	}
	
	
	@Bean
	public SecurityFilterChain filterChain(HttpSecurity http) throws Exception{
		
		http
		.csrf(csrf -> csrf.disable())
		.authorizeHttpRequests(e -> 
		e.requestMatchers("/auth/**").permitAll()
//		.requestMatchers("/getSpecificUserdetils/**").permitAll()
		.requestMatchers("/v3/api-docs/**", "/swagger-ui/**", "/swagger-ui.html").permitAll()
		.anyRequest().authenticated());
		
		http.addFilterBefore(securityFilter, UsernamePasswordAuthenticationFilter.class);
		
		return http.build();
		
		
		
	}

}
