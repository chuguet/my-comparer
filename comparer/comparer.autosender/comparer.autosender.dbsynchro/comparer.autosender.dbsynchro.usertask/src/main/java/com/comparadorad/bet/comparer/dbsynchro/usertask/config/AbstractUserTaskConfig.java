package com.comparadorad.bet.comparer.dbsynchro.usertask.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.ImportResource;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.validation.beanvalidation.LocalValidatorFactoryBean;

import com.comparadorad.bet.comparer.payment.adapter.config.PaymentAdapterSpringConfiguration;

@Configuration
@ComponentScan({ "com.comparadorad.bet.comparer.dbsynchro.usertask"})
@ImportResource("classpath*:/application-context-app.xml")
public abstract class AbstractUserTaskConfig {

	
	/**
	 * Property sources placeholder configurer.
	 * 
	 * @return the property sources placeholder configurer
	 */
	@Bean
	public static PropertySourcesPlaceholderConfigurer propertySourcesPlaceholderConfigurer() {
		return new PropertySourcesPlaceholderConfigurer();
	}
	
	@Bean(name = "ValidatorGetResponse")
	public LocalValidatorFactoryBean getLocalValidatorFactoryBeanConfig() {
		return new LocalValidatorFactoryBean();
	}
}
