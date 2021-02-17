package com.entity;

import java.util.Locale;

import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.i18n.LocaleChangeInterceptor;
import org.springframework.web.servlet.i18n.SessionLocaleResolver;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

@Configuration
@EnableWebMvc
@ComponentScan(basePackages= {"com.entity"})
public class WebConfig implements WebMvcConfigurer {
	

	@Bean
	public ViewResolver internalResourceViewResolver() {
	    InternalResourceViewResolver bean = new InternalResourceViewResolver();
	    bean.setPrefix("/WEB-INF/views/");
	    bean.setSuffix(".jsp");
	    return bean;
	}
	
	@Override
	 public void addResourceHandlers(ResourceHandlerRegistry registry) {
	       // registry.addResourceHandler("/static/**").addResourceLocations("/static/");
	        registry.addResourceHandler("/img/**").addResourceLocations("/WEB-INF/img/");

	 }
	
	@Override
	public void addInterceptors(InterceptorRegistry registry) {
	   
	    registry.addInterceptor(localeInterceptor());
	}
	
	 @Bean
	 public LocaleResolver localeResolver() {
	     SessionLocaleResolver slr = new SessionLocaleResolver();
	     slr.setDefaultLocale(Locale.US);
	     return slr;
	 }
	 
	 @Bean
	 public LocaleChangeInterceptor localeInterceptor() {
	     LocaleChangeInterceptor localeInterceptor = new LocaleChangeInterceptor();
	     localeInterceptor.setParamName("lang");
	     return localeInterceptor;
	    }
	 
	 @Bean
	 public MessageSource messageSource() {
	     ResourceBundleMessageSource messageSource = new ResourceBundleMessageSource();
	     messageSource.setBasenames("mymessages", "messages");
	     messageSource.setDefaultEncoding("UTF-8");
	     return messageSource;
	 }
	
	/*
	 @Override
	  public void addViewControllers(ViewControllerRegistry registry) {
	    registry.addViewController("/login").setViewName("home");
	  }
	*/
}
