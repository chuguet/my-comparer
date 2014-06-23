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
 * The Class MoveContactTest.
 */
public class MoveContactTest extends AbstractTest {

	/** The Constant LOG. */
	public static final Log LOG = LogFactory.getLog(MoveContactTest.class);

	/** The facade get response. */
	@Inject
	IAutosender facadeGetResponse;

	/**
	 * Adds the contact test.
	 * 
	 * @throws Exception
	 *             the exception
	 */
	@Test
	public void moveContactTest() throws Exception {
		// lista gratuitos: pJPR
		// lista satlas: p0Ue
		// USER : rZbwB
		// MoveContactRequestBean contactRequestBean = new
		// MoveContactRequestBean();
		// contactRequestBean.setCampaignId("pJPR");
		// contactRequestBean.setContactId("rZbwB");
		// GenericResponseBean response = (GenericResponseBean)
		// facadeGetResponse.moveContact(contactRequestBean);
		//
		//
		// LOG.info("STATUS: " + response.getStatus());
		// LOG.info("CONTENT: " + response.getContent());

	}
}
