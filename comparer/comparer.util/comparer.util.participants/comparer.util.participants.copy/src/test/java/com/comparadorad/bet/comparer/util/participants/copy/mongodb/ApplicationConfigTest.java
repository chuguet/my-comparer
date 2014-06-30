package com.comparadorad.bet.comparer.util.participants.copy.mongodb;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.junit.Assert.assertThat;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.comparadorad.bet.comparer.util.commons.profile.ProfileConstant;
import com.comparadorad.bet.comparer.util.participants.copy.mongodb.CopyParticipantsConfig;

/**
 * Integration test bootstrapping an {@link ApplicationContext} from both XML and JavaConfig to assure the general setup
 * is working.
 * 
 * @author Oliver Gierke
 */
public class ApplicationConfigTest {
	/** The Constant LOG. */
	public static final Log LOG = LogFactory
			.getLog(ApplicationConfigTest.class);

	@Test
	public void bootstrapAppFromJavaConfig() {
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
		context.getEnvironment().setActiveProfiles(ProfileConstant.TEST);
		context.register(CopyParticipantsConfig.class);
		context.refresh();
		assertThat(context, is(notNullValue()));
	}
}
