package com.comparadorad.bet.comparer.synchro.valuebet.app.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.comparadorad.bet.comparer.synchro.valuebet.app.launcher.BatchValueBetAppLauncherTest;
import com.comparadorad.bet.comparer.util.batch.AbstractBatchReaderAppLauncher;
import com.comparadorad.bet.comparer.util.commons.profile.ProfileConstant;

@Configuration
@Profile(value = { ProfileConstant.TEST })	
public class SynchroValueBetBatchAppConfigTest extends AbstractSynchroValueBetBatchAppConfig {

	@Bean
	@Override
	public AbstractBatchReaderAppLauncher batchReaderAppLauncher() {
		return new BatchValueBetAppLauncherTest();
	}

	@Override
	public String launchTest() {		
		return doLaunchTest();
	}
	

}
