/**
 *
 * Copyright (C) FACTORIA ETSIA S.L.
 * All Rights Reserved.
 * www.factoriaetsia.com
 *
 */
package com.comparadorad.bet.comparer.autosender.getresponse.test;

import javax.inject.Inject;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.junit.Test;

import com.comparadorad.bet.comparer.autosender.core.facade.IAutosender;
import com.comparadorad.bet.comparer.autosender.core.responsebean.GenericResponseBean;

/**
 * The Class TestConnectionTest.
 */
public class TestConnectionTest extends AbstractTest{

	/** The Constant LOG. */
	public static final Log LOG = LogFactory
			.getLog(TestConnectionTest.class);

	/** The facade get response. */
	@Inject
	IAutosender facadeGetResponse;

	/**
	 * Test connection test.
	 *
	 * @throws Exception the exception
	 */
	@Test
	public void testConnectionTest() throws Exception{

		GenericResponseBean response = (GenericResponseBean) facadeGetResponse.testConnection();

		LOG.info("STATUS: " + response.getStatus());
		LOG.info("CONTENT: " + response.getContent());

	}

}
