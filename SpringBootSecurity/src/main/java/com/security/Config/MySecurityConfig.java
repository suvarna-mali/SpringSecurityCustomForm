package com.security.Config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.security.SecurityProperties.User;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.*;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.csrf.CookieCsrfTokenRepository;

import com.security.model.CustomUserDetail;

@Configuration
@EnableWebSecurity
public class MySecurityConfig   {

	@Autowired
	private UserDetailsService userdetail;
	
	
	protected void configure(AuthenticationManagerBuilder auth)throws Exception
	{
		auth.userDetailsService(userdetail).passwordEncoder(passwordencoder());
	}
	
	@Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
      // configure HTTP security...     
		http
		.csrf().csrfTokenRepository(CookieCsrfTokenRepository.withHttpOnlyFalse())
		.and()
		.authorizeRequests()
		.requestMatchers("/signin").permitAll()
		.requestMatchers("/home", "/login","/register").hasRole("NORMAL")
		.requestMatchers("/users/**").hasRole("ADMIN")
		.anyRequest()
		.authenticated()
		.and()
		.formLogin()
		.loginPage("/signin") 
		.loginProcessingUrl("/dologin")
		.defaultSuccessUrl("/users/getuser");
		
		return http.build();
		
    }
	
	
	
	/*
	 * @Bean public UserDetailsService userDetailsService(){ UserDetails
	 * abc=org.springframework.security.core.userdetails.User.builder().
	 * username("abc") .password(this.passwordencoder().encode("password")) .roles()
	 * .build();
	 * 
	 * UserDetails pqr=org.springframework.security.core.userdetails.User.builder().
	 * username("pqr") .password(this.passwordencoder().encode("password")) .roles()
	 * .build();
	 * 
	 * 
	 * return new InMemoryUserDetailsManager(abc, pqr); }
	 */
	
	
	
	@Bean
	public BCryptPasswordEncoder passwordencoder()
	{
		return new BCryptPasswordEncoder(10);
	}
	
}
