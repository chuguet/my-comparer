package com.comparadorad.bet.comparer.synchro.valuebet.app.launcher;

import org.springframework.scheduling.annotation.Scheduled;

import com.comparadorad.bet.comparer.util.batch.AbstractBatchReaderAppLauncher;

public class BatchValueBetAppLauncherTest extends AbstractBatchReaderAppLauncher {
	
	private final static String NAME = "batchValueBet";

	@Override
	protected String getJobName() {
		return NAME;
	}

	@Scheduled(fixedDelay = 1)
	@Override	
	protected void launch() {
		launchJobs();		
	}
	
	

}
