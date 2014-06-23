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

import com.comparadorad.bet.comparer.autosender.core.enume.MessageType;
import com.comparadorad.bet.comparer.autosender.core.exception.MissingContactException;
import com.comparadorad.bet.comparer.autosender.core.facade.IAutosender;
import com.comparadorad.bet.comparer.autosender.core.requestbean.MessageResquestBean;
import com.comparadorad.bet.comparer.autosender.core.responsebean.GenericResponseBean;

/**
 * The Class SendNewsletterTest.
 */
public class SendNewsletterTest extends AbstractTest {

	/** The Constant LOG. */
	public static final Log LOG = LogFactory.getLog(SendNewsletterTest.class);

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
	public void sendNewsletterTest() throws Exception {
		// lista gratuitos: pJPR
		// lista satlas: p0Ue
		// USER : rZbwB
		MessageResquestBean messageResquestBean = new MessageResquestBean();
		GenericResponseBean response = null;
		messageResquestBean.setCampaignId("TaY2");
		messageResquestBean.setSubject("Funciona la API??");
		messageResquestBean.setMessageType(MessageType.HTML);
		messageResquestBean
				.setContent("<h1>Hola {{CONTACT \"subscriber_name\"}}, "
						+ "tu email es {{CONTACT \"subscriber_email\"}} "
						+ " Esto es un test("
						+ this.getClass()
						+ ")"
						+ "para probar el envío de newsletters.    "
						+ "{{LINK \"social_linkedin\"}}{{LINK \"social_facebook\"}}</h1>");
		try {
			response = (GenericResponseBean) facadeGetResponse
					.sendNewsletter(messageResquestBean);
		} catch (MissingContactException missingContactException) {
			LOG.error(missingContactException);
		}

		if (response != null) {

			LOG.info("STATUS: " + response.getStatus());
			LOG.info("CONTENT: " + response.getContent());
		}

	}

}
