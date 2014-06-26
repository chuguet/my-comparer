/**
 *
 * Copyright (C) FACTORIA ETSIA S.L.
 * All Rights Reserved.
 * www.factoriaetsia.com
 *
 */
package com.comparadorad.bet.comparer.model.log.repository;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.List;

import javax.inject.Inject;

import org.junit.Test;

import com.comparadorad.bet.comparer.log.repository.LogEventBookmakerMasterWordsRepository;
import com.comparadorad.bet.comparer.model.log.bean.LogEvent.LogState;
import com.comparadorad.bet.comparer.model.log.bean.LogEventBookmakerMasterWords;

/**
 * The Class LogEventBookmakerRepositoryTest.
 */
public class LogEventBookmakerMasterWordsRepositoryTest extends
		AbstractLogRepositoryTest<LogEventBookmakerMasterWordsRepository> {

	/** The repository. */
	@Inject
	private LogEventBookmakerMasterWordsRepository repository;
	
	private String[] logState = {"NEW"};

	/**
	 * Gets the crud repository.
	 * 
	 * @return the crud repository {@inheritDoc}
	 */
	@Override
	public LogEventBookmakerMasterWordsRepository getCrudRepository() {
		return repository;
	}

	/**
	 * Test custom find by bookmaker and state.
	 */
	@Test
	public void testCustomFindByBookmakerAndState() {
		List<LogEventBookmakerMasterWords> logEventBookmakers = getCrudRepository()
				.customFindByState(LogState.NEW);
		assertNotNull(logEventBookmakers);
		assertFalse(logEventBookmakers.isEmpty());
	}

	/**
	 * Test custom find by bookmaker and state.
	 */
	@Test
	public void testExistsPreviousError() {
		
		boolean logEventBookmakers = getCrudRepository().existsPreviousError(
				"Message...", logState);
		assertNotNull(logEventBookmakers);
		assertTrue(logEventBookmakers);
	}

	/**
	 * Test Custom find by state.
	 */
	@Test
	public void customFindByStateTest() {
		assertNotNull(getCrudRepository().customFindByState(LogState.NEW));
	}
	

}
