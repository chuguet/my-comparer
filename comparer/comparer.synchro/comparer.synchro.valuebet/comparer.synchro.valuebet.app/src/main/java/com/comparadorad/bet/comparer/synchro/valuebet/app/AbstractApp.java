package com.comparadorad.bet.comparer.synchro.valuebet.app;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.comparadorad.bet.comparer.util.commons.profile.ProfileConstant;

/**
 * The Class AbstractApp.
 */
public abstract class AbstractApp {
	
	/** The Constant LOG. */
	private static final Log LOG = LogFactory.getLog(AbstractApp.class);
	
	/**
	 * Start app.
	 */
	public void startApp() {
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
		LOG.info("Starting app with profiles:");
		for (String profile : context.getEnvironment().getActiveProfiles()) {
			LOG.info(profile);
		}
		context.refresh();
	}
	
	/**
	 * Gets the config class.
	 *
	 * @return the config class
	 */
	public abstract Class<?>[] getConfigClass();

}