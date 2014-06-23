/**
 *
 * Copyright (C) FACTORIA ETSIA S.L.
 * All Rights Reserved.
 * www.factoriaetsia.com
 *
 */
package com.comparadorad.bet.comparer.model.autosender.config;

import java.util.Properties;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.orm.hibernate3.HibernateTransactionManager;
import org.springframework.orm.hibernate3.annotation.AnnotationSessionFactoryBean;

import com.comparadorad.bet.comparer.util.commons.profile.ProfileConstant;

/**
 * The Class AutoSenderRepositoryConfig.
 */
@Configuration
@PropertySource("classpath:/db.properties")
@Profile(value = { ProfileConstant.DEV, ProfileConstant.PREPRODUCTION,
		ProfileConstant.PRODUCTION })
public class AutoSenderBeanConfig extends AbstractAutoBeanSenderConfig {
	// Bean para importar el properties
	/**
	 * Property sources placeholder configurer.
	 *
	 * @return the property sources placeholder configurer
	 */
	@Bean
	public static PropertySourcesPlaceholderConfigurer propertySourcesPlaceholderConfigurer() {
		return new PropertySourcesPlaceholderConfigurer();
	}

	// HIBERNATE CONFIGURATION
	/** The dialect. */
	@Value("${hibernate.dialect}")
	private String dialect;
	
	/** The show sql. */
	@Value("${hibernate.show_sql}")
	private String showSql;
	
	/** The hbm2 ddl. */
	@Value("${hibernate.hbm2ddl.auto}")
	private String hbm2DDL;

	// JDBC CONFIGURATION DATASOURCE
	/** The driver class name. */
	@Value("${jdbc.driverClassName}")
	private String driverClassName;
	
	/** The url. */
	@Value("${jdbc.url}")
	private String url;
	
	/** The username. */
	@Value("${jdbc.username}")
	private String username;
	
	/** The password. */
	@Value("${jdbc.password}")
	private String password;

	// MAPPING BEANS
	/** The package beans. */
	@Value("${hibernate.mapping.packages}")
	private String packageBeans;

	/**
	 * Gets the data source.
	 *
	 * @return the data source
	 */
	@Bean
	public DataSource getDataSource() {
		DriverManagerDataSource result = new DriverManagerDataSource();
		result.setDriverClassName(driverClassName);
		result.setUrl(url);
		result.setUsername(username);
		result.setPassword(password);
		return result;
	}

	/**
	 * Transaction manager.
	 *
	 * @return the hibernate transaction manager
	 */
	@Bean
	public HibernateTransactionManager transactionManager() {
		HibernateTransactionManager transactionManager = new HibernateTransactionManager();
		transactionManager.setSessionFactory(getSessionFactory().getObject());
		return transactionManager;
	}

	/**
	 * Gets the hibernate properties.
	 *
	 * @return the hibernate properties
	 */
	@Bean
	public Properties getHibernateProperties() {
		Properties properties = new Properties();
		properties.put("hibernate.dialect", dialect);
		properties.put("hibernate.show_sql", showSql);
		properties.put("hibernate.hbm2ddl.auto", hbm2DDL);
		return properties;
	}

	/**
	 * Gets the hibernate template.
	 *
	 * @return the hibernate template
	 */
	@Bean
	public HibernateTemplate getHibernateTemplate() {
		HibernateTemplate hibernateTemplate = new HibernateTemplate(
				getSessionFactory().getObject());
		return hibernateTemplate;
	}

	/**
	 * Gets the session factory.
	 *
	 * @return the session factory
	 */
	@Bean
	public AnnotationSessionFactoryBean getSessionFactory() {
		AnnotationSessionFactoryBean factoryBean = new AnnotationSessionFactoryBean();
		factoryBean.setDataSource(getDataSource());
		factoryBean.setPackagesToScan(new String[] { packageBeans });
		factoryBean.setHibernateProperties(getHibernateProperties());
		return factoryBean;
	}
}
