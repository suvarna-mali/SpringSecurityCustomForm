package com.defaultsecurity.SecurityConfig;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;

import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;




@Configuration
@EnableWebSecurity
public class SpringSecurityConfig {
	
	
	
	@Autowired
	private UserDetailsService userDetailsService;
	
	@Bean
	AuthenticationProvider authenticationProvider()
	{
		DaoAuthenticationProvider provider=new DaoAuthenticationProvider();
		
		provider.setUserDetailsService(userDetailsService);
		provider.setPasswordEncoder(new BCryptPasswordEncoder());
		return provider;
	}
	
	
	
	@Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
      // configure HTTP security...     
		http
		.authorizeRequests()
		.requestMatchers("/").permitAll()
		.requestMatchers("/home").hasRole("NORMAL")
		.requestMatchers("/admin").hasRole("ADMIN")
		.anyRequest()
		.authenticated()
		.and()
		.httpBasic();
		
		return http.build();
		
    }

}
