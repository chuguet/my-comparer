/**
 *
 * Copyright (C) FACTORIA ETSIA S.L.
 * All Rights Reserved.
 * www.factoriaetsia.com
 *
 */

package com.comparadorad.bet.comparer.model.securebet.service;

import static org.junit.Assert.assertEquals;

import java.math.BigInteger;

import javax.inject.Inject;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.junit.Test;

import com.comparadorad.bet.comparer.model.core.service.IGenericCrudService;
import com.comparadorad.bet.comparer.model.securebet.bean.SecureBeanData;

/**
 * The Class SecureBetServiceTest.
 */
public class SecureBetServiceTest extends AbstractServiceTest<SecureBeanData> {

	/** The Constant LOG. */
	public static final Log LOG = LogFactory.getLog(SecureBetServiceTest.class);

	/** The secure bet service. */
	@Inject
	private ISecureBetService secureBetService;

	/**
	 * Gets the i generic service.
	 * 
	 * @return the i generic service {@inheritDoc}
	 */
	@Override
	protected IGenericCrudService<SecureBeanData> getIGenericService() {
		return secureBetService;
	}

	/**
	 * Test service.
	 */
	@Test
	public void ServiceTest() {
		assertEquals(secureBetService.findOne(new BigInteger("1")).getNameId(),
				"Real Madrid CF");
		assertEquals(secureBetService.findAll().iterator().next().getNameId(),
				"Real Madrid CF");
	}
	
	@Test
	public void findOneCustomTest(){
		secureBetService.findOneCustom("25565480255954940195315082484");
	}
}
