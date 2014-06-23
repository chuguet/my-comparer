/**
 *
 * Copyright (C) FACTORIA ETSIA S.L.
 * All Rights Reserved.
 * www.factoriaetsia.com
 *
 */
package com.comparadorad.bet.comparer.communication.surebets.send;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.Date;

import javax.inject.Inject;

import org.junit.Test;

import com.comparadorad.bet.comparer.communication.surebets.AbstractCommunicationSurebets;
import com.comparadorad.bet.comparer.communication.surebets.send.ISendSureBetEmail;
import com.comparadorad.bet.comparer.model.config.bean.CfgCompetition;
import com.comparadorad.bet.comparer.model.config.bean.CfgRegion;
import com.comparadorad.bet.comparer.model.config.bean.CfgSport;
import com.comparadorad.bet.comparer.model.core.bean.I18n;
import com.comparadorad.bet.comparer.model.securebet.bean.InfoMatch;
import com.comparadorad.bet.comparer.model.securebet.bean.SecureBeanBenefit;
import com.comparadorad.bet.comparer.model.securebet.bean.SecureBeanData;

/**
 * The Class SendSureBetEmailTest.
 */
public final class SendSureBetEmailTest extends AbstractCommunicationSurebets {

	/** The bet email. */
	@Inject
	private ISendSureBetEmail betEmail;

	/**
	 * Send test.
	 */
	@Test
	public void sendTrue() {
		Boolean flag;
		SecureBeanData beanData = new SecureBeanData();
		InfoMatch infoMatch = new InfoMatch();
		CfgCompetition competition = new CfgCompetition();
		CfgSport cfgSport = new CfgSport();
		CfgRegion cfgRegion = new CfgRegion();
		I18n i18n;
		
		
		i18n = new I18n();
		i18n.addI18nField("Futbol");
		cfgSport.setI18n(i18n);
		
		i18n = new I18n();
		i18n.addI18nField("España");
		cfgRegion.setI18n(i18n);
		
		i18n = new I18n();
		i18n.addI18nField("Liga Española");
		competition.setI18n(i18n);
		
		competition.setSport(cfgSport);
		competition.setRegion(cfgRegion);
		
		infoMatch.setCompetition(competition);
		infoMatch.setNameId("Real Madrid vs Barcelona");
		infoMatch.setDate(new Date());		
		
		beanData.setBenefit(new SecureBeanBenefit(10D));
		beanData.setInfoMatch(infoMatch);
		
		flag = betEmail.send(beanData);
		assertTrue(flag);
	}
	
	/**
	 * Send false.
	 */
	@Test
	public void sendFalse() {
		Boolean flag;
		SecureBeanData beanData = new SecureBeanData();
		InfoMatch infoMatch = new InfoMatch();
		CfgCompetition competition = new CfgCompetition();
		CfgSport cfgSport = new CfgSport();
		CfgRegion cfgRegion = new CfgRegion();
		
		cfgSport.setNameId("Futbol");
		
		cfgRegion.setNameId("España");
		
		competition.setNameId("Liga Española");
		competition.setSport(cfgSport);
		competition.setRegion(cfgRegion);
		
		infoMatch.setCompetition(competition);
		infoMatch.setNameId("Real Madrid vs Barcelona");
		infoMatch.setDate(new Date());		
		
		beanData.setBenefit(new SecureBeanBenefit(0D));
		beanData.setInfoMatch(infoMatch);
		
		flag = betEmail.send(beanData);
		
		assertFalse(flag);

	}

}
