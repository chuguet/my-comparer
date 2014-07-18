package com.comparadorad.bet.comparer.web.server.mvc.payment.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;

import com.comparadorad.bet.comparer.web.server.mvc.core.config.WebServerMvcCoreConfig;


@Configuration
@PropertySource(value = { "classpath:/paypal.properties"})
@Import(value = { WebServerMvcCoreConfig.class })
public abstract class AbstractPaymentConfig {

	@Value("${paypal.api.version}")
	private  String version;

	@Value("${paypal.api.url}")
	private  String redirectURL;

	@Value("${paypal.api.mode}")
	private  String mode;

	@Value("${paypal.api.username}")
	private  String username;

	@Value("${paypal.api.password}")
	private  String password;

	@Value("${paypal.api.signature}")
	private  String signature;

	@Value("${paypal.api.returnurl}")
	private  String returnURL;

	@Value("${paypal.api.cancelurl}")
	private  String cancelURL;

	@Value("${portal.url.success}")
	private String urlSuccess;
	
	public String getUrlSuccess() {
		return urlSuccess;
	}

	public void setUrlSuccess(String urlSuccess) {
		this.urlSuccess = urlSuccess;
	}

	public  String getVersion() {
		return version;
	}

	public void setVersion(String version) {
		this.version = version;
	}

	public  String getRedirectURL() {
		return redirectURL;
	}

	public void setRedirectURL(String redirectURL) {
		this.redirectURL = redirectURL;
	}

	public  String getMode() {
		return mode;
	}

	public void setMode(String mode) {
		this.mode = mode;
	}

	public  String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public  String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public  String getSignature() {
		return signature;
	}

	public void setSignature(String signature) {
		this.signature = signature;
	}

	public  String getReturnURL() {
		return returnURL;
	}

	public void setReturnURL(String returnURL) {
		this.returnURL = returnURL;
	}

	public  String getCancelURL() {
		return cancelURL;
	}

	public void setCancelURL(String cancelURL) {
		this.cancelURL = cancelURL;
	}

	@Bean
	public static PropertySourcesPlaceholderConfigurer propertySourcesPlaceholderConfigurer() {
		return new PropertySourcesPlaceholderConfigurer();
	}
	
}
