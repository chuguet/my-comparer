/**
 *
 * Copyright (C) FACTORIA ETSIA S.L.
 * All Rights Reserved.
 * www.factoriaetsia.com
 *
 */
package com.comparadorad.bet.comparer.model.config.repository;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import javax.inject.Inject;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.junit.Test;

import com.comparadorad.bet.comparer.model.config.bean.CfgCompetitionEvent;
import com.comparadorad.bet.comparer.model.repository.CfgCompetitionEventRepository;

/**
 * The Class CfgCompetitionEventRepositoryTest.
 */
public class CfgCompetitionEventRepositoryTest extends
		AbstractConfigRepositoryTest<CfgCompetitionEventRepository> {

	/** The Constant LOG. */
	private static final Log LOG = LogFactory
			.getLog(CfgCompetitionEventRepositoryTest.class);

	/** The Constant COMPETITION_FOUND. */
	private static final String COMPETITION_FOUND = "Competition Found: ";

	/** The competition event repository. */
	@Inject
	private CfgCompetitionEventRepository competitionEventRepository;

	/** {@inheritDoc} */
	@Override
	public CfgCompetitionEventRepository getCrudRepository() {
		return competitionEventRepository;
	}

	/** {@inheritDoc} */
	@Override
	protected Object getNewElement() {
		CfgCompetitionEvent cfgCompetitionEvent = new CfgCompetitionEvent();
		cfgCompetitionEvent.setI18n(getI18N());
		return cfgCompetitionEvent;
	}

	@Test
	public void testQuery() {
		String nameEvent = "Competicion Corto Plazo";

		LOG.debug(new StringBuffer(COMPETITION_FOUND).append(
				competitionEventRepository.customFindByname(nameEvent).get(0)
						.getObjectId()).toString());

		assertEquals(competitionEventRepository.customFindByname(nameEvent).get(0)
				.getName(new Locale("Spain")).toString(),nameEvent);
	}

	@Test
	public void testCustomFindByLongTerm() {
		
		List<CfgCompetitionEvent> result = competitionEventRepository
				.customFindByLongTerm(false);

	}
	
	@Test
	public void customFindByname() {
		LOG.debug("Se inicia el test customFindByname");
		
		List<CfgCompetitionEvent> result = competitionEventRepository
				.customFindByname("Competicion Corto Plazo");
		
		assertEquals(result.size(),1);
		assertEquals(result.get(0).getI18n().getI18nField(null).getString(), "Competicion Corto Plazo");
		
		LOG.debug("El test customFindByname ha sido ejecutado con éxito");
	}
}
