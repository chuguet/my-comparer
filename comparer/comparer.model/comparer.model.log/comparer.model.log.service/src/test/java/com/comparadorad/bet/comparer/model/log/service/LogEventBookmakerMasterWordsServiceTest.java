/**
 *
 * Copyright (C) FACTORIA ETSIA S.L.
 * All Rights Reserved.
 * www.factoriaetsia.com
 *
 */
package com.comparadorad.bet.comparer.model.log.service;

import static org.junit.Assert.assertNotNull;

import java.util.Date;

import javax.inject.Inject;

import org.junit.Test;

import com.comparadorad.bet.comparer.model.config.bean.CfgBookmaker;
import com.comparadorad.bet.comparer.model.config.bean.CfgBookmaker.CfgBookmakerId;
import com.comparadorad.bet.comparer.model.core.service.IGenericCrudService;
import com.comparadorad.bet.comparer.model.log.bean.LogEvent.LogState;
import com.comparadorad.bet.comparer.model.log.bean.LogEventBookmakerMasterWords;

/**
 * The Class LogXmlEventServiceTest.
 */
public class LogEventBookmakerMasterWordsServiceTest extends
		AbstractLogServiceTest<LogEventBookmakerMasterWords> {

	/** The service. */
	@Inject
	private ILogEventBookmakerMasterWordsService service;

	/**
	 * Gets the i generic service.
	 * 
	 * @return the i generic service {@inheritDoc}
	 */
	@Override
	protected IGenericCrudService<LogEventBookmakerMasterWords> getIGenericService() {
		return service;
	}

	/**
	 * Test error.
	 */
	@Test
	public void testError() {
		service.error("TMP", "a message", null, new CfgBookmaker(
				CfgBookmakerId.BET_AT_HOME_COM_ID), new Date());
	}

	/**
	 * Testcustom find by sta.
	 */
	@Test
	public void testcustomFindBySta() {
		assertNotNull(service.customFindBySta(LogState.NEW));
	}
}
