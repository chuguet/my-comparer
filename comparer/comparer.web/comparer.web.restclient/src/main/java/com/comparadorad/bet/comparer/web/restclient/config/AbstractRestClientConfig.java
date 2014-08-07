/**
 *
 * Copyright (C) FACTORIA ETSIA S.L.
 * All Rights Reserved.
 * www.factoriaetsia.com
 *
 */
package com.comparadorad.bet.comparer.web.restclient.config;

import java.util.ArrayList;
import java.util.List;

import org.apache.http.auth.AuthScope;
import org.apache.http.auth.UsernamePasswordCredentials;
import org.apache.http.impl.client.BasicCredentialsProvider;
import org.apache.http.impl.client.DefaultHttpClient;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.Scope;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.http.MediaType;
import org.springframework.http.client.ClientHttpRequestFactory;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.MappingJacksonHttpMessageConverter;
import org.springframework.web.client.RestTemplate;

/**
 * The Class AbstractAutosenderGetResponseConfig.
 */
@Configuration
@PropertySource(value = { "classpath:/datasource.properties" })
@ComponentScan("com.comparadorad.bet.comparer.web.restclient")
public abstract class AbstractRestClientConfig {

	/**
	 * Property sources placeholder configurer.
	 * 
	 * @return the property sources placeholder configurer
	 */
	@Bean
	public static PropertySourcesPlaceholderConfigurer propertySourcesPlaceholderConfigurer() {
		return new PropertySourcesPlaceholderConfigurer();
	}
	
	/**
	 * Rest template.
	 *
	 * @return the rest template
	 */
	@Bean
	@Scope("prototype")
	public RestTemplate restTemplate() {
/*Before		
		DefaultHttpClient httpClient = new DefaultHttpClient();
		BasicCredentialsProvider credentialsProvider =  new BasicCredentialsProvider();
		credentialsProvider.setCredentials(AuthScope.ANY, new UsernamePasswordCredentials("farce", "fernando"));
		httpClient.setCredentialsProvider(credentialsProvider);		
		ClientHttpRequestFactory rf = new HttpComponentsClientHttpRequestFactory(httpClient);
		RestTemplate restTemplate = new RestTemplate(rf);
*/
/*		
		List<HttpMessageConverter<?>> list = new ArrayList<HttpMessageConverter<?>>();
		list.add(new MappingJacksonHttpMessageConverter());				
		restTemplate.setMessageConverters(list);
*/		
		
		// Setup the RestTemplate configuration.
		DefaultHttpClient httpClient = new DefaultHttpClient();
		BasicCredentialsProvider credentialsProvider =  new BasicCredentialsProvider();
		credentialsProvider.setCredentials(AuthScope.ANY, new UsernamePasswordCredentials(credentialsUser, credentialsPassword));
		httpClient.setCredentialsProvider(credentialsProvider);		
		ClientHttpRequestFactory rf = new HttpComponentsClientHttpRequestFactory(httpClient);
		RestTemplate restTemplate = new RestTemplate(rf);		
		List<HttpMessageConverter<?>> messageConverterList = restTemplate.getMessageConverters();		  
		// Set HTTP Message converter using a JSON implementation.
		MappingJacksonHttpMessageConverter jsonMessageConverter = new MappingJacksonHttpMessageConverter();
		
		
		   
		// Add supported media type returned by BI API.
		List<MediaType> supportedMediaTypes = new ArrayList<MediaType>();
		supportedMediaTypes.add(new MediaType("text", "plain"));
		supportedMediaTypes.add(new MediaType("application", "json"));
		jsonMessageConverter.setSupportedMediaTypes(supportedMediaTypes);
		messageConverterList.add(jsonMessageConverter);
		restTemplate.setMessageConverters(messageConverterList);		
		
		return restTemplate;
	}
	

	/**
	 * Gets the url.
	 *
	 * @return the url
	 */
	public String getUrl() {
		return url;
	}


	public String getRestFileLog() {
		return restFileLog;
	}
	
	public String getRestFileLogURLs() {
		return restFileLogURLs;
	}
	
	public String getLogResponseSize() {
		return restLogResponseSize;
	}
	
	public String getThreadsNumber() {
		return numberThreads;
	}
	
	public Integer getRequestRetries() {
		return retries;
	}
	
	public Integer getRequestLevel() {
		return requestLevel;
	}
	
	
	/**
	 * Sets the url.
	 *
	 * @param url the new url
	 */
	public void setUrl(String url) {
		this.url = url;
	}


	/** The URL. */
	@Value("${service.url}")
	private String url;

	@Value("${file.log}")
	private String restFileLog;
	
	@Value("${file.log.urls}")
	private String restFileLogURLs;
	
	@Value("${file.log.responseSize}")
	private String restLogResponseSize;
	
	@Value("${credentials.user}")
	private String credentialsUser;
	
	@Value("${credentials.password}")
	private String credentialsPassword;
	
	@Value("${request.concurrency.number}")
	private String numberThreads;
	
	@Value("${request.retries}")
	private Integer retries;
	
	@Value("${request.level}")
	private Integer requestLevel;
	
}
