/**
 *
 * Copyright (C) FACTORIA ETSIA S.L.
 * All Rights Reserved.
 * www.factoriaetsia.com
 *
 */
package com.comparadorad.bet.comparer.communication.email.app;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.comparadorad.bet.comparer.communication.email.config.EmailConfig;
import com.comparadorad.bet.comparer.util.commons.profile.ProfileConstant;

/**
 * The Class BatchCommunicationEmailApp.
 */
public class BatchCommunicationEmailApp {

	/** The Constant LOG. */
	private static final Log LOG = LogFactory
			.getLog(BatchCommunicationEmailApp.class);

	/**
	 * The main method.
	 * 
	 * @param args
	 *            the arguments
	 */
	public static void main(String[] args) {

		AnnotationConfigApplicationContext context;

		context = new AnnotationConfigApplicationContext();
		if (((ConfigurableApplicationContext) context).getEnvironment()
				.getActiveProfiles() == null
				|| ((ConfigurableApplicationContext) context).getEnvironment()
						.getActiveProfiles().length == 0) {
			((ConfigurableApplicationContext) context).getEnvironment()
					.setActiveProfiles(ProfileConstant.DEV);
		}
		context.register(EmailConfig.class);
		LOG.info("Starting app with profiles:");
		for (String profile : context.getEnvironment().getActiveProfiles()) {
			LOG.info(profile);
		}
		LOG.info("Batch app for send email");
		context.refresh();

	}

}
