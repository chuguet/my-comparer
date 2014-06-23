package com.comparadorad.bet.comparer.communication.app;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.comparadorad.bet.comparer.communication.config.CommunicationValueBetsConfig;
import com.comparadorad.bet.comparer.util.commons.profile.ProfileConstant;


public class BatchCommunicationValueBetsApp {
	
	private static final Log LOG = LogFactory.getLog(BatchCommunicationValueBetsApp.class);

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		LOG.info("Batch app for communication of valuebets");
		AnnotationConfigApplicationContext context;
		context = new AnnotationConfigApplicationContext();
		((ConfigurableApplicationContext) context).getEnvironment()
				.setActiveProfiles(ProfileConstant.PRODUCTION);
		context.register(CommunicationValueBetsConfig.class);
		context.refresh();
	}

}
