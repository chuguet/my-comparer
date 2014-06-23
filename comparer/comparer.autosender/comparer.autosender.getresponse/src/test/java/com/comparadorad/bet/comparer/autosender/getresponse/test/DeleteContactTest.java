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

/**
 * The Class DeleteContactTest.
 */
public class DeleteContactTest extends AbstractTest {

	/** The Constant LOG. */
	public static final Log LOG = LogFactory.getLog(DeleteContactTest.class);

	/** The facade get response. */
	@Inject
	IAutosender facadeGetResponse;

	/**
	 * Test connection test.
	 * 
	 * @throws Exception
	 *             the exception
	 */
	@Test
	public void deleteContactTest() throws Exception {
		// lista gratuitos: pJPR
		// lista satlas: p0Ue
		// USER : rZbwB
		/*
		 * SE COMENTA ESTE TEST PORQUE NO SE PUEDE BORRAR A UN USUARIO TO-DO EL
		 * RATO
		 */
		// DeleteContactRequestBean deleteContactRequestBean = new
		// DeleteContactRequestBean();
		// deleteContactRequestBean.setCampaign("p0Ue");
		// deleteContactRequestBean.setEmail("zgonzalez@factoriaetsia.com");
		// GenericResponseBean response = (GenericResponseBean)
		// facadeGetResponse.deleteContact(deleteContactRequestBean);
		//
		// LOG.info("STATUS: " + response.getStatus());
		// LOG.info("CONTENT: " + response.getContent());

	}

}
