package com.comparadorad.bet.comparer.synchro.valuebet.app;

import org.junit.Test;

import com.comparadorad.bet.comparer.util.commons.profile.ProfileConstant;

public class BatchValueBetAppTest extends AbstractValueAppTest {
	
	@Test
	public final void start(){
		System.setProperty("spring.profiles.active", ProfileConstant.TEST);
		BatchValueBetApp.main(new String[] {});
	}

}
