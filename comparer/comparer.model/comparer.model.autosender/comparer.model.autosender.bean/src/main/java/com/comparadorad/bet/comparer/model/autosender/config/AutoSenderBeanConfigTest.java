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

@Configuration
@PropertySource("classpath:/dbtest.properties")
@Profile(value = { ProfileConstant.TEST })
public class AutoSenderBeanConfigTest {
	// Bean para importar el properties
	@Bean
	public static PropertySourcesPlaceholderConfigurer propertySourcesPlaceholderConfigurer() {
		return new PropertySourcesPlaceholderConfigurer();
	}

	// HIBERNATE CONFIGURATION
	@Value("${hibernate.dialect}")
	private String dialect;
	@Value("${hibernate.show_sql}")
	private String showSql;
	@Value("${hibernate.hbm2ddl.auto}")
	private String hbm2DDL;

	// JDBC CONFIGURATION DATASOURCE
	@Value("${jdbc.driverClassName}")
	private String driverClassName;
	@Value("${jdbc.url}")
	private String url;
	@Value("${jdbc.username}")
	private String username;
	@Value("${jdbc.password}")
	private String password;

	// MAPPING BEANS
	@Value("${hibernate.mapping.packages}")
	private String packageBeans;

	@Bean
	public DataSource getDataSource() {
		DriverManagerDataSource result = new DriverManagerDataSource();
		result.setDriverClassName(driverClassName);
		result.setUrl(url);
		result.setUsername(username);
		result.setPassword(password);
		return result;
	}

	@Bean
	public HibernateTransactionManager transactionManager() {
		HibernateTransactionManager transactionManager = new HibernateTransactionManager();
		transactionManager.setSessionFactory(getSessionFactory().getObject());
		return transactionManager;
	}

	@Bean
	public Properties getHibernateProperties() {
		Properties properties = new Properties();
		properties.put("hibernate.dialect", dialect);
		properties.put("hibernate.show_sql", showSql);
		properties.put("hibernate.hbm2ddl.auto", hbm2DDL);
		return properties;
	}

	@Bean
	public HibernateTemplate getHibernateTemplate() {
		HibernateTemplate hibernateTemplate = new HibernateTemplate(
				getSessionFactory().getObject());
		return hibernateTemplate;
	}

	@Bean
	public AnnotationSessionFactoryBean getSessionFactory() {
		AnnotationSessionFactoryBean factoryBean = new AnnotationSessionFactoryBean();
		factoryBean.setDataSource(getDataSource());
		factoryBean.setPackagesToScan(new String[] { packageBeans });
		factoryBean.setHibernateProperties(getHibernateProperties());
		return factoryBean;
	}
}
