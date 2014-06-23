package com.comparadorad.bet.comparer.dbsynchro.usertask.config;

import static org.mockito.Mockito.mock;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.Profile;

import com.comparadorad.bet.comparer.autosender.core.config.AutosenderCoreConfig;
import com.comparadorad.bet.comparer.autosender.getresponse.config.AutosenderGetResponseConfigTest;
import com.comparadorad.bet.comparer.model.autosender.service.config.AutoSenderServiceConfigTest;
import com.comparadorad.bet.comparer.util.commons.profile.ProfileConstant;
import com.comparadorad.bet.comparer.web.restclient.core.IRestClient;

@Configuration
@Import({ AutosenderGetResponseConfigTest.class,
		AutoSenderServiceConfigTest.class, AutosenderCoreConfig.class })
@Profile(value = { ProfileConstant.TEST })
public class UserTaskConfigTest extends AbstractUserTaskConfig {
	
	@Bean
	public IRestClient getIRestClient(){
		IRestClient result = mock(IRestClient.class);
		return result;
	}

}