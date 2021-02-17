package com.entity;

import java.util.Properties;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.JpaVendorAdapter;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;

@Configuration
@EnableJpaRepositories
@EnableTransactionManagement
@PropertySource("classpath:database.properties")
public class DataConfig {

	@Autowired
	Environment env;
	@Bean
	LocalContainerEntityManagerFactoryBean entityManagerFactory() {
		
		LocalContainerEntityManagerFactoryBean entityManageFactory = new LocalContainerEntityManagerFactoryBean();
		entityManageFactory.setDataSource(dataSource());
		
		JpaVendorAdapter vendor = new HibernateJpaVendorAdapter();
		
		entityManageFactory.setJpaVendorAdapter(vendor);
		entityManageFactory.setPackagesToScan(new String[] {"com.entity"});
		entityManageFactory.setJpaProperties(hibernateProps());
		
		return entityManageFactory;
	}
	
	@Bean
	DataSource dataSource() {
		DriverManagerDataSource ds = new DriverManagerDataSource();
		 ds.setDriverClassName(env.getProperty("jdbc.driverClassName"));
		 ds.setUrl(env.getProperty("jdbc.url"));
		 ds.setUsername(env.getProperty("jdbc.user"));
		 ds.setPassword(env.getProperty("jdbc.pass"));
		return ds;
	}
	
	Properties hibernateProps() {
		final Properties hibernateProperties = new Properties();
	
		hibernateProperties.setProperty("hibernate.hbm2ddl.auto", env.getProperty("hibernate.hbm2ddl.auto"));
		hibernateProperties.setProperty("hibernate.dialect", env.getProperty("hibernate.dialect"));
		hibernateProperties.setProperty("hibernate.cache.use_second_level_cache", env.getProperty("hibernate.cache.use_second_level_cache"));
		hibernateProperties.setProperty("hibernate.cache.use_query_cache", env.getProperty("hibernate.cache.use_query_cache"));
	        
		return hibernateProperties;
		
	}

	@Bean
	JpaTransactionManager transactionManager() {
		JpaTransactionManager transactionManager = new JpaTransactionManager();
		transactionManager.setEntityManagerFactory(entityManagerFactory().getObject());
		return transactionManager;
	}
	
	@Bean(name = "multipartResolver")
	public CommonsMultipartResolver multipartResolver() {
	    CommonsMultipartResolver multipartResolver = new CommonsMultipartResolver();
	   
	    return multipartResolver;
	}
	
	 
}
