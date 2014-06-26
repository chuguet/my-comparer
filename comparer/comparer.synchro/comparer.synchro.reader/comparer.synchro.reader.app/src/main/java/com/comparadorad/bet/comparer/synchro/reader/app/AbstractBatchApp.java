/**
 *
 * Copyright (C) FACTORIA ETSIA S.L.
 * All Rights Reserved.
 * www.factoriaetsia.com
 *
 */
package com.comparadorad.bet.comparer.synchro.reader.app;

import org.eclipse.jetty.util.log.Log;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.comparadorad.bet.comparer.util.commons.profile.ProfileConstant;

/**
 * The Class AbstractBatchApp.
 */
public abstract class AbstractBatchApp {

	/**
	 * Instantiates a new abstract batch app.
	 */
	public AbstractBatchApp() {
		super();
	}

	/**
	 * Start app.
	 */
	public ApplicationContext startApp() {
		AnnotationConfigApplicationContext context;

		context = new AnnotationConfigApplicationContext();
		if (((ConfigurableApplicationContext) context).getEnvironment()
				.getActiveProfiles() == null
				|| ((ConfigurableApplicationContext) context).getEnvironment()
						.getActiveProfiles().length == 0) {
			((ConfigurableApplicationContext) context).getEnvironment()
					.setActiveProfiles(ProfileConstant.DEV);
		}
		for (Class<?> class1 : getConfigClass()) {
			context.register(class1);
		}
		Log.info("Starting app with profiles:");
		for (String profile : context.getEnvironment().getActiveProfiles()) {
			Log.info(profile);
		}
		context.refresh();
		
		return context;
	}

	/**
	 * Gets the config class.
	 * 
	 * @return the config class
	 */
	public abstract Class<?>[] getConfigClass();
}