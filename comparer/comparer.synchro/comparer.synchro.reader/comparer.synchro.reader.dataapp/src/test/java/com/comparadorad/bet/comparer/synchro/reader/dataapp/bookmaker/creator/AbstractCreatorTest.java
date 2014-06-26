/**
 *
 * Copyright (C) FACTORIA ETSIA S.L.
 * All Rights Reserved.
 * www.factoriaetsia.com
 *
 */
package com.comparadorad.bet.comparer.synchro.reader.dataapp.bookmaker.creator;

import java.math.BigInteger;
import java.util.List;

import javax.inject.Inject;

import org.junit.Before;
import org.junit.runner.RunWith;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.comparadorad.bet.comparer.model.config.bean.CfgBookmaker;
import com.comparadorad.bet.comparer.model.config.bean.CfgMaster;
import com.comparadorad.bet.comparer.model.config.service.ICfgMasterService;
import com.comparadorad.bet.comparer.synchro.reader.dataapp.config.SynchroReaderDataAppConfig;
import com.comparadorad.bet.comparer.synchro.reader.dataapp.config.SynchroReaderDataAppTestConfig;
import com.comparadorad.bet.comparer.util.commons.profile.ProfileConstant;

/**
 * The Class AbstractCreatorTest.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = { SynchroReaderDataAppConfig.class,
		SynchroReaderDataAppTestConfig.class })
@ActiveProfiles(value = { ProfileConstant.TEST,
		ProfileConstant.TEST_NO_JOB_EXECUTION })
public abstract class AbstractCreatorTest {

	/**
	 * Gets the cfg creator.
	 * 
	 * @return the cfg creator
	 */
	protected abstract AbstractCfgCreator getCfgCreator();

	/** The master service. */
	@Inject
	private ICfgMasterService masterService;

	/**
	 * Sets the up.
	 */
	@Before
	public void setUp() {
		List<CfgMaster> masterList = (List<CfgMaster>) masterService.findAll();
		getCfgCreator().setMasterList(masterList);
	}

	/**
	 * Gets the bookmaker.
	 * 
	 * @return the bookmaker
	 */
	protected CfgBookmaker getBookmaker() {
		CfgBookmaker result = new CfgBookmaker(new BigInteger("19"));
		return result;
	}
}
