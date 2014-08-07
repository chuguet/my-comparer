package com.comparadorad.bet.comparer.web.restclient.exception;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.comparadorad.bet.comparer.util.commons.profile.ProfileConstant;
import com.comparadorad.bet.comparer.web.restclient.config.RestClientConfig;
import com.comparadorad.bet.comparer.web.restclient.util.RestTemplateUtil;

public class RestClientException extends Exception{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	public void printStackTrace() {
		super.printStackTrace();
		
		AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext();
		ctx.getEnvironment().setActiveProfiles(ProfileConstant.TEST);
		ctx.register(RestClientConfig.class);
		ctx.refresh();
		RestClientConfig clientConfig = ctx.getBean(RestClientConfig.class);
		RestTemplateUtil.writeToFile(clientConfig.getRestFileLog(), this.getMessage());
	}

}
