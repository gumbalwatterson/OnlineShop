package com.entity;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsChecker;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;

@Configuration
@EnableWebSecurity
public class WebSecuConfig extends WebSecurityConfigurerAdapter{
	
	@Bean
	BCryptPasswordEncoder getencoder(){
		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
		return encoder;
	}
	
	@Bean
	AuthenticationProvider  getAuthenticationProvider() {
	DaoAuthenticationProvider authenticationProvider = new DaoAuthenticationProvider();
	authenticationProvider.setPasswordEncoder(getencoder());
	authenticationProvider.setUserDetailsService(getUserDetailsService());
	//authenticationProvider.setPreAuthenticationChecks(getUserDetailsChecker());
	return authenticationProvider;
	}
	/*
	@Bean
	UserDetailsChecker getUserDetailsChecker() {
		return new MyUserDetailsChecker();
	}
	*/
	@Bean
	 UserDetailsService getUserDetailsService() {
		return new MyUserDetailsService();
	}
	
	 @Bean
	    public AuthenticationFailureHandler authenticationFailureHandler() {
	        return new CustomAuthenticationFailureHandler();
	    }
	 
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.authenticationProvider(getAuthenticationProvider());
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		
		http.csrf().disable();
		
		http.authorizeRequests()
		.antMatchers("/create" , "/users" , "/log" , "/useraccount"  ).hasAnyAuthority("ADMIN" , "USER")
		.antMatchers("/**" , "/").permitAll()
		.and()
		.formLogin().loginPage("/loginpage").permitAll().loginProcessingUrl("/perform_login").usernameParameter("name").passwordParameter("password").failureUrl("/loginpage?error=true").defaultSuccessUrl("/", true)
		.and()
		.logout()
		.and()
		.httpBasic();
		// kamila: java = $2a$10$YYm/yoDRZC9bBbaEE10gN.sc.HU0/IpuZ0SRMN1aV3C8IItaHi6C2
		// jan: java2= $2a$10$b0kV1nLvie9ojYxc.ew1XugWfxxyOx5tPOUdv/sQ2lJ8CXq5wfjjG
		// hubert java3
	}

	
	
}
