/**
 *
 * Copyright (C) FACTORIA ETSIA S.L.
 * All Rights Reserved.
 * www.factoriaetsia.com
 *
 */
package com.comparadorad.bet.comparer.model.config.service;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.math.BigInteger;

import javax.inject.Inject;

import org.junit.Test;

import com.comparadorad.bet.comparer.model.config.bean.CfgBookmaker;
import com.comparadorad.bet.comparer.model.core.service.IGenericCrudService;

/**
 * The Class SportTypeServiceTest.
 */

public class CfgBookmakerServiceTest extends AbstractServiceTest<CfgBookmaker> {

	/** The sport type service. */
	@Inject
	private ICfgBookmakerService cfgBookmakerService;

	/**
	 * Gets the i generic service.
	 * 
	 * @return the i generic service {@inheritDoc}
	 */
	@Override
	protected IGenericCrudService<CfgBookmaker> getIGenericService() {
		return cfgBookmakerService;
	}

	/**
	 * Gets the id afiliado.
	 * 
	 * @return the id afiliado
	 */
	@Test
	public void getIdAfiliado() {
		BigInteger bigInt = new BigInteger("19");
		CfgBookmaker bookmaker = new CfgBookmaker();

		bookmaker = cfgBookmakerService.findOne(bigInt);

		assertNotNull(bookmaker);
		assertNotNull(bookmaker.getBookmakerConfiguration().getIdAfiliado());
	}

	/**
	 * Gets the active bookmakers.
	 * 
	 * @return the active bookmakers
	 */
	@Test
	public void getActiveBookmakers() {
		Long result = cfgBookmakerService.getActiveBookmakers();

		assertNotNull(result);
		assertTrue(result > 0);

	}
}
