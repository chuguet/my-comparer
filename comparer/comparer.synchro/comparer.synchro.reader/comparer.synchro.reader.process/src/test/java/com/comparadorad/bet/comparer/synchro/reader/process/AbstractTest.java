/**
 *
 * Copyright (C) FACTORIA ETSIA S.L.
 * All Rights Reserved.
 * www.factoriaetsia.com
 *
 */
package com.comparadorad.bet.comparer.synchro.reader.process;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.AnnotationConfigContextLoader;

import com.comparadorad.bet.comparer.model.config.bean.CfgBookmaker;
import com.comparadorad.bet.comparer.model.config.bean.CfgBookmaker.CfgBookmakerId;
import com.comparadorad.bet.comparer.model.config.bean.bmconf.CfgBookmakerBetTypeStrategies;
import com.comparadorad.bet.comparer.model.config.bean.bmconf.CfgBookmakerBetTypeStrategyGeneral;
import com.comparadorad.bet.comparer.model.config.bean.bmconf.CfgBookmakerConfiguration;
import com.comparadorad.bet.comparer.model.config.bean.bmconf.CfgBookmakerXmlReader;
import com.comparadorad.bet.comparer.synchro.reader.process.config.SynchroReaderProcessConfig;
import com.comparadorad.bet.comparer.util.commons.profile.ProfileConstant;

/**
 * The Class AbstractTest.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = SynchroReaderProcessConfig.class, loader = AnnotationConfigContextLoader.class)
@ActiveProfiles(ProfileConstant.TEST)
public abstract class AbstractTest {

	/**
	 * Test.
	 */
	@Test
	public abstract void test();
	
	protected CfgBookmaker setBookmaker() {
		CfgBookmaker cfgBookmaker = new CfgBookmaker();
		cfgBookmaker.setObjectId(CfgBookmakerId.BETCLIC_COM_ID.objectId());
		CfgBookmakerConfiguration cfgBookmakerConfiguration = new CfgBookmakerConfiguration();
		CfgBookmakerBetTypeStrategies cfgBookmakerBetTypeStrategies = new CfgBookmakerBetTypeStrategies();
		CfgBookmakerBetTypeStrategyGeneral cfgBookmakerBetTypeStrategyGeneral = new CfgBookmakerBetTypeStrategyGeneral();
		cfgBookmakerBetTypeStrategyGeneral.setDeleteNegativeNumbers(false);
		cfgBookmakerBetTypeStrategies.addBetTypeStrategy(cfgBookmakerBetTypeStrategyGeneral);
		cfgBookmakerConfiguration.setBookmakerBetTypeStrategies(cfgBookmakerBetTypeStrategies);
		cfgBookmaker.setBookmakerConfiguration(cfgBookmakerConfiguration);
		CfgBookmakerXmlReader bookmakerXmlReader = new CfgBookmakerXmlReader();
		bookmakerXmlReader.setXmlMarketBetEnabled(false);
		cfgBookmaker.setBookmakerXmlReader(bookmakerXmlReader);
		return cfgBookmaker;
	}
}
