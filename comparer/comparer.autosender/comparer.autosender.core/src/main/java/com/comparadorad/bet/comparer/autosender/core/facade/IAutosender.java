/**
 *
 * Copyright (C) FACTORIA ETSIA S.L.
 * All Rights Reserved.
 * www.factoriaetsia.com
 *
 */
package com.comparadorad.bet.comparer.autosender.core.facade;


import java.io.IOException;

import org.apache.commons.httpclient.HttpException;

import com.comparadorad.bet.comparer.autosender.core.exception.ExternalAutoSenderException;
import com.comparadorad.bet.comparer.autosender.core.requestbean.AddContactRequestBean;
import com.comparadorad.bet.comparer.autosender.core.requestbean.ContactCycleRequestBean;
import com.comparadorad.bet.comparer.autosender.core.requestbean.DeleteContactRequestBean;
import com.comparadorad.bet.comparer.autosender.core.requestbean.MessageResquestBean;
import com.comparadorad.bet.comparer.autosender.core.requestbean.MoveContactRequestBean;
import com.comparadorad.bet.comparer.autosender.core.requestbean.PaymentListResquestBean;
import com.comparadorad.bet.comparer.autosender.core.responsebean.CampaignListBean;
import com.comparadorad.bet.comparer.autosender.core.responsebean.IResponseBean;

/**
 * The Interface IAutosender.
 */
public interface IAutosender {

	
	/**
	 * Test connection.
	 *
	 * @return the i response bean
	 * @throws HttpException the http exception
	 * @throws IOException Signals that an I/O exception has occurred.
	 * @throws ExternalAutoSenderException the external auto sender exception
	 */
	IResponseBean testConnection() throws HttpException, IOException, ExternalAutoSenderException;
	

	/**
	 * Adds the contact.
	 *
	 * @param addContactRequestBean the add contact request bean
	 * @return the i response bean
	 * @throws HttpException the http exception
	 * @throws IOException Signals that an I/O exception has occurred.
	 * @throws ExternalAutoSenderException the external auto sender exception
	 */
	IResponseBean addContact(AddContactRequestBean addContactRequestBean) throws HttpException, IOException, ExternalAutoSenderException;
	
	/**
	 * Move contact.
	 *
	 * @param moveContactRequestBean the move contact request bean
	 * @return the i response bean
	 * @throws HttpException the http exception
	 * @throws IOException Signals that an I/O exception has occurred.
	 * @throws ExternalAutoSenderException the external auto sender exception
	 */
	IResponseBean moveContact(MoveContactRequestBean moveContactRequestBean) throws HttpException, IOException, ExternalAutoSenderException;
	
	/**
	 * Delete contact.
	 *
	 * @param deleteContactRequestBean the delete contact request bean
	 * @return the i response bean
	 * @throws HttpException the http exception
	 * @throws IOException Signals that an I/O exception has occurred.
	 * @throws ExternalAutoSenderException the external auto sender exception
	 */
	IResponseBean deleteContact(DeleteContactRequestBean deleteContactRequestBean) throws HttpException, IOException, ExternalAutoSenderException;
	
	/**
	 * Send newsletter.
	 *
	 * @param messageResquestBean the message resquest bean
	 * @return the i response bean
	 * @throws HttpException the http exception
	 * @throws IOException Signals that an I/O exception has occurred.
	 * @throws ExternalAutoSenderException the external auto sender exception
	 */
	IResponseBean sendNewsletter(MessageResquestBean messageResquestBean) throws HttpException, IOException, ExternalAutoSenderException;
	
	/**
	 * Gets the payment list.
	 *
	 * @param paymentListRequestBean the payment list request bean
	 * @return the payment list
	 * @throws HttpException the http exception
	 * @throws IOException Signals that an I/O exception has occurred.
	 * @throws ExternalAutoSenderException the external auto sender exception
	 */
	IResponseBean getPaymentList(PaymentListResquestBean paymentListRequestBean) throws HttpException, IOException, ExternalAutoSenderException;
	
	/**
	 * Gets the campaign list.
	 *
	 * @return the campaign list
	 * @throws HttpException the http exception
	 * @throws IOException Signals that an I/O exception has occurred.
	 * @throws ExternalAutoSenderException the external auto sender exception
	 */
	CampaignListBean getCampaignList()  throws HttpException, IOException, ExternalAutoSenderException;
	
	
	
	IResponseBean setContactCycle(ContactCycleRequestBean contactCycleRequestBean) throws HttpException, IOException, ExternalAutoSenderException;
	
}
