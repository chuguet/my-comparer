package com.comparadorad.bet.comparer.web.server.redirection;

import org.junit.runner.RunWith;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.AnnotationConfigContextLoader;

import com.comparadorad.bet.comparer.util.commons.encrypt.EncryptUtil;
import com.comparadorad.bet.comparer.util.commons.profile.ProfileConstant;
import com.comparadorad.bet.comparer.web.server.redirection.config.WebServerRedirectionCoreConfig;


/**
 * The Class AbstractTest.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = WebServerRedirectionCoreConfig.class, loader = AnnotationConfigContextLoader.class)
@ActiveProfiles(ProfileConstant.TEST)
public abstract class AbstractTest {
	
	
	protected String encryptUrl(final String url) {
		String result = "";
		result = EncryptUtil.encryptString(url);

		return result;
	}

}
