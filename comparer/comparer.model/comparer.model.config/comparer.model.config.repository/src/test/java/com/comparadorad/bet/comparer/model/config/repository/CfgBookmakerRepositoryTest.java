/**
 *
 * Copyright (C) FACTORIA ETSIA S.L.
 * All Rights Reserved.
 * www.factoriaetsia.com
 *
 */
package com.comparadorad.bet.comparer.model.config.repository;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.math.BigInteger;
import java.util.Map;

import javax.inject.Inject;

import org.junit.Test;

import com.comparadorad.bet.comparer.model.config.bean.CfgBookmaker;
import com.comparadorad.bet.comparer.model.config.bean.bmconf.CfgBookmakerConfiguration;
import com.comparadorad.bet.comparer.model.config.bean.bmconf.CfgBookmakerXmlReader;
import com.comparadorad.bet.comparer.model.config.bean.bmconf.CfgBookmakerXmlReaderDateFormat;
import com.comparadorad.bet.comparer.model.repository.CfgBookmakerRepository;

/**
 * The Class CfgBookmakerRepositoryTest.
 */
public class CfgBookmakerRepositoryTest extends
		AbstractConfigRepositoryTest<CfgBookmakerRepository> {

	/** The bookmaker configuration repository. */
	@Inject
	private transient CfgBookmakerRepository cfgBookmakerRepository;

	/**
	 * Gets the crud repository.
	 * 
	 * @return the crud repository {@inheritDoc}
	 */
	@Override
	public CfgBookmakerRepository getCrudRepository() {
		return cfgBookmakerRepository;
	}

	/**
	 * Gets the new element.
	 * 
	 * @return the new element {@inheritDoc}
	 */
	@Override
	protected Object getNewElement() {
		CfgBookmaker bookmaker = new CfgBookmaker();

		CfgBookmakerXmlReader cfgBookmakerXmlReader = new CfgBookmakerXmlReader();

		bookmaker.setObjectId(new BigInteger("123"));
		CfgBookmakerXmlReaderDateFormat cfgBookmakerXmlReaderDateFormat = new CfgBookmakerXmlReaderDateFormat();
		cfgBookmakerXmlReaderDateFormat.setFormat("");
		cfgBookmakerXmlReader
				.setXmlReaderConfigDateFormat(cfgBookmakerXmlReaderDateFormat);

		bookmaker.setBookmakerXmlReader(cfgBookmakerXmlReader);
		bookmaker.setI18n(getI18N());
		CfgBookmakerConfiguration bookmakerConfiguration = new CfgBookmakerConfiguration();
		bookmaker.setBookmakerConfiguration(bookmakerConfiguration);
		return bookmaker;
	}

	/**
	 * Gets the active bookmakers test.
	 * 
	 * @return the active bookmakers test
	 */
	@Test
	public void getActiveBookmakersTest() {
		Long result = cfgBookmakerRepository.getActiveBookmakers();

		assertNotNull(result);
		assertTrue(result > 0);

	}

	@Test
	public void findAllTimesForDeleteBetsTest() {
		Map<BigInteger, Long> result = cfgBookmakerRepository
				.findAllTimesForDeleteBets();
		Long numBookmakers = cfgBookmakerRepository.getActiveBookmakers();
		assertTrue(Integer.valueOf(String.valueOf(numBookmakers)).equals(
				result.size()));
		for (BigInteger idBookmaker : result.keySet()) {
			assertTrue(result.get(idBookmaker).equals(1800000l));
		}

	}

}
