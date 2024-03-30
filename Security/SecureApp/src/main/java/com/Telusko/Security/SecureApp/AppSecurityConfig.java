package com.Telusko.Security.SecureApp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.SecurityBuilder;
import org.springframework.security.config.annotation.SecurityConfigurerAdapter;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

/*
 * THIS IS CONFIGURATION CLASS FOR SPRING SECURITY
 * HERE WE ARE FETCHING THE DATA FROM THE DATABASE BY CREATING AUTHPROVIDER METHOD
 * 
 * 
 * 
 * 
 * 
 */
@Configuration
@EnableWebSecurity
public class AppSecurityConfig extends SecurityConfigurerAdapter{
	
	@Autowired
	UserDetailsService userDetailsService;
	
	@Bean
	public AuthenticationProvider authProvider()
	{
		DaoAuthenticationProvider provider =new DaoAuthenticationProvider();
		provider.setUserDetailsService(userDetailsService);//FETCHES DATA FROM DB
		provider.setPasswordEncoder(NoOpPasswordEncoder.getInstance());//new BCryptPasswordEncoder();
		return provider;
	}

//	public void configure(HttpSecurity http) throws Exception {
//		//JAVA TECHIE-IMPLEMENTING SECURITY FOR EVERY REQUEST THAT COMES
//		//DECURITY FOR ALL API'S
//		http.csrf().disable();
//		http.authorizeRequests().anyRequest().fullyAuthenticated().and().httpBasic();
//		
//		//TELUSKO CODE
////		http.csrf().disable()
////		.authorizeRequests().requestMatchers("/login").permitAll().anyRequest().authenticated()
////		.and()
////		.formLogin()
////		.loginPage("/login").permitAll()
////		.and()
////		.logout().invalidateHttpSession(true)
////		.clearAuthentication(true)
////		.logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
////		.logoutSuccessUrl("logout-success").permitAll();
//	}
//	public void configure(HttpSecurity http) throws Exception {
//		
//		//SECURITY BASED ON URL
//		http.csrf().disable();
//		http.authorizeRequests().requestMatchers("/rest/**").fullyAuthenticated()
//		.and().httpBasic();
//	}
	public void configure(HttpSecurity http) throws Exception {
		
		//SECURITY BASED ON ROLE
		http.csrf().disable();
		http.authorizeRequests().requestMatchers("/rest/**")
		.hasAnyRole("ADMIN").anyRequest().fullyAuthenticated()
		.and().httpBasic();
	}
}
