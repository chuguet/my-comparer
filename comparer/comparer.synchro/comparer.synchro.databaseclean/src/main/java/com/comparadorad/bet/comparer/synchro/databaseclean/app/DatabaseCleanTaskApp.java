package com.comparadorad.bet.comparer.synchro.databaseclean.app;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.comparadorad.bet.comparer.synchro.databaseclean.config.SpringDatabaseCleanConfiguration;
import com.comparadorad.bet.comparer.util.commons.profile.ProfileConstant;

public class DatabaseCleanTaskApp {

	/** The Constant LOG. */
	private static final Log LOG = LogFactory.getLog(DatabaseCleanTaskApp.class);

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
		context.register(SpringDatabaseCleanConfiguration.class);
		LOG.info("Starting app with profiles:");
		for (String profile : context.getEnvironment().getActiveProfiles()) {
			LOG.info(profile);
		}
		LOG.info("Batch app for database clean");
		context.refresh();
		
	}
}
