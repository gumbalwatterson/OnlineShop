package com.entity;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.DefaultRedirectStrategy;
import org.springframework.security.web.RedirectStrategy;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;

public class CustomAuthenticationFailureHandler implements AuthenticationFailureHandler{
	private RedirectStrategy redirectStrategy = new DefaultRedirectStrategy();
	
	@Override
	public void onAuthenticationFailure(HttpServletRequest request, HttpServletResponse response,
			AuthenticationException exception) throws IOException, ServletException {
	
		System.out.println(exception.getClass().getName());
	
	if(exception instanceof DisabledException ) {  
		System.out.println("hello");
		response.sendRedirect("loginpage");
	}
	else if(exception instanceof BadCredentialsException) {
		System.out.println("hello2");
		response.sendRedirect("loginpage");
		
	}
	
	
		//redirectStrategy.sendRedirect(request , response ,"/registration"); 

	}

}
