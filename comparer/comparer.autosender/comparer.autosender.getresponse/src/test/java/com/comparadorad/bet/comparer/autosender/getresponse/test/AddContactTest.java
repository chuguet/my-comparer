/**
 *
 * Copyright (C) FACTORIA ETSIA S.L.
 * All Rights Reserved.
 * www.factoriaetsia.com
 *
 */
package com.comparadorad.bet.comparer.autosender.getresponse.test;

import java.util.Hashtable;

import javax.inject.Inject;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.junit.Test;

import com.comparadorad.bet.comparer.autosender.core.enume.ContactActions;
import com.comparadorad.bet.comparer.autosender.core.facade.IAutosender;
import com.comparadorad.bet.comparer.autosender.core.requestbean.AddContactRequestBean;
import com.comparadorad.bet.comparer.autosender.core.responsebean.GenericResponseBean;

/**
 * The Class AddContactTest.
 */
public class AddContactTest extends AbstractTest{


	/** The Constant LOG. */
	public static final Log LOG = LogFactory
			.getLog(AddContactTest.class);

	/** The facade get response. */
	@Inject
	IAutosender facadeGetResponse;


	/**
	 * Adds the contact test.
	 *
	 * @throws Exception the exception
	 */
	@Test
	public void addContactTest() throws Exception{
		//lista gratuitos: pJPR
		//lista satlas: p0Ue
		AddContactRequestBean contactRequestBean = new AddContactRequestBean();
		contactRequestBean.setEmail("zgonzalez@factoriaetsia.com");
		contactRequestBean.setCampaignId("p0Ue");
		contactRequestBean.setName("LE ISAAC");
		Hashtable<String, String> customs= new Hashtable<String,String>();
		customs.put("GUSTO", "HOMOSEXUAL");
		customs.put("PROFESION", "VIVIDOR/FOLLADOR");
		contactRequestBean.setAction(ContactActions.UPDATE);
		contactRequestBean.setIp("69.69.69.69");
		contactRequestBean.setCustoms(customs);
		GenericResponseBean response = (GenericResponseBean) facadeGetResponse.addContact(contactRequestBean);


		LOG.info("STATUS: " + response.getStatus());
		LOG.info("CONTENT: " + response.getContent());

	}
}
