/**
 *
 * Copyright (C) FACTORIA ETSIA S.L.
 * All Rights Reserved.
 * www.factoriaetsia.com
 *
 */
package com.comparadorad.bet.comparer.communication.email.config;

import java.util.ArrayList;
import java.util.List;

import org.dozer.DozerBeanMapper;
import org.dozer.Mapper;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.validation.beanvalidation.LocalValidatorFactoryBean;

/**
 * The Class AbstractEmailConfig.
 */
@Configuration
@ComponentScan({ "com.comparadorad.bet.comparer.communication.email" })
@PropertySource({ "classpath:/report/email/valuebet/valuebetEmail.properties" })
public abstract class AbstractEmailConfig {

	/** The Constant FILE_CONFIGURATION_DOZER. */
	private final static String FILE_CONFIGURATION_DOZER = "configuration-bean-mapping.xml";

	/**
	 * Property sources placeholder configurer.
	 * 
	 * @return the property sources placeholder configurer
	 */
	@Bean
	public static PropertySourcesPlaceholderConfigurer propertySourcesPlaceholderConfigurer() {
		return new PropertySourcesPlaceholderConfigurer();
	}

	/** The email contact. */
	@Value("${configuration.email.contact}")
	private String emailContact;

	/** The email subtitle. */
	@Value("${configuration.email.subtitle}")
	private String emailSubtitle;
	
	/** The email title. */
	@Value("${configuration.email.title}")
	private String emailTitle;	

	/** The surebet landing page. */
	@Value("${configuration.email.surebet.landingpage}")
	private String surebetLandingPage;

	/** The Uri imagen. */
	@Value("${configuration.email.uri}")
	private String UriImagen;
	
	/** The email contact final. */
	@Value("${configuration.email.contact.final}")
	private String emailContactFinal;

	
	
	/**
	 * Gets the email contact final.
	 *
	 * @return the email contact final
	 */
	public String getEmailContactFinal() {
		return emailContactFinal;
	}

	/**
	 * Gets the email contact.
	 * 
	 * @return the email contact
	 */
	public String getEmailContact() {
		return emailContact;
	}

	/**
	 * Gets the email subtitle.
	 * 
	 * @return the email subtitle
	 */
	public String getEmailSubtitle() {
		return emailSubtitle;
	}

	/**
	 * Gets the email title.
	 * 
	 * @return the email title
	 */
	public String getEmailTitle() {
		return emailTitle;
	}

	/**
	 * Gets the local validator factory bean config.
	 *
	 * @return the local validator factory bean config
	 */
	@Bean(name = "ValidatorGetResponse")
	public LocalValidatorFactoryBean getLocalValidatorFactoryBeanConfig() {
		return new LocalValidatorFactoryBean();
	}

	/**
	 * Gets the mapper config.
	 *
	 * @return the mapper config
	 */
	@Bean
	public Mapper getMapperConfig() {
		List<String> mappingFileUrls = new ArrayList<String>();
		DozerBeanMapper mapper = new DozerBeanMapper();
		
		mappingFileUrls.add(FILE_CONFIGURATION_DOZER);
		
		mapper.setMappingFiles(mappingFileUrls);
		
		return mapper;		
	}

	/**
	 * Gets the surebet landing page.
	 *
	 * @return the surebet landing page
	 */
	public String getSurebetLandingPage() {
		return surebetLandingPage;
	}

	/**
	 * Gets the uri imagen.
	 *
	 * @return the uri imagen
	 */
	public String getUriImagen() {
		return UriImagen;
	}

	/**
	 * Sets the email contact.
	 * 
	 * @param emailContact
	 *            the new email contact
	 */
	public void setEmailContact(String emailContact) {
		this.emailContact = emailContact;
	}
	
	/**
	 * Sets the email subtitle.
	 * 
	 * @param emailSubtitle
	 *            the new email subtitle
	 */
	public void setEmailSubtitle(String emailSubtitle) {
		this.emailSubtitle = emailSubtitle;
	}

	/**
	 * Sets the email title.
	 * 
	 * @param emailTitle
	 *            the new email title
	 */
	public void setEmailTitle(String emailTitle) {
		this.emailTitle = emailTitle;
	}

	/**
	 * Sets the uri imagen.
	 *
	 * @param uriImagen the new uri imagen
	 */
	public void setUriImagen(String uriImagen) {
		UriImagen = uriImagen;
	}

}
