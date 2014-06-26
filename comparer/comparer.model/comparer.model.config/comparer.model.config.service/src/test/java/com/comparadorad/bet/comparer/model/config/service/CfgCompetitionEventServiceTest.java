/**
 *
 * Copyright (C) FACTORIA ETSIA S.L.
 * All Rights Reserved.
 * www.factoriaetsia.com
 *
 */
package com.comparadorad.bet.comparer.model.config.service;

import static org.junit.Assert.assertEquals;

import java.util.Locale;

import javax.inject.Inject;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.junit.Test;

import com.comparadorad.bet.comparer.model.config.bean.CfgCompetitionEvent;
import com.comparadorad.bet.comparer.model.core.service.IGenericCrudService;

/**
 * The Class CfgCompetitionEventServiceTest.
 */
public class CfgCompetitionEventServiceTest extends AbstractServiceTest<CfgCompetitionEvent>{
	
	/** The Constant LOG. */
	public static final Log LOG = LogFactory.getLog(CfgCompetitionEventServiceTest.class);

	/** The sport type service. */
	@Inject
	private ICfgCompetitionEventService competitionEventService;

	/** {@inheritDoc} */ 
	@Override
	protected IGenericCrudService<CfgCompetitionEvent> getIGenericService() {
		return competitionEventService;
	}
	
	/**
	 * Test service.
	 */
	@Test
	public void testService() {
		String nameEvent1 = "Competicion Corto Plazo";

		LOG.info("CfgCompetitionEvent found: " + competitionEventService.customFindByname(nameEvent1).get(0).getObjectId());

		assertEquals(competitionEventService.customFindByname(nameEvent1).get(0).getName(new Locale("Spain")), nameEvent1);

	}
}
