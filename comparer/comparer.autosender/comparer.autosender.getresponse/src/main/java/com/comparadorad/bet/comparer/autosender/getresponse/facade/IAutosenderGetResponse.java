/**
 *
 * Copyright (C) FACTORIA ETSIA S.L.
 * All Rights Reserved.
 * www.factoriaetsia.com
 *
 */
package com.comparadorad.bet.comparer.autosender.getresponse.facade;


import java.io.IOException;

import org.apache.commons.httpclient.HttpException;

import com.comparadorad.bet.comparer.autosender.core.exception.ExternalAutoSenderException;
import com.comparadorad.bet.comparer.autosender.core.exception.InvalidBeanException;
import com.comparadorad.bet.comparer.autosender.core.exception.InvalidEncodingMessageGetResponseException;
import com.comparadorad.bet.comparer.autosender.core.exception.MissingContactException;
import com.comparadorad.bet.comparer.autosender.core.responsebean.IResponseBean;
import com.comparadorad.bet.comparer.autosender.getresponse.requestbean.AddContactRequestBeanGetResponse;
import com.comparadorad.bet.comparer.autosender.getresponse.requestbean.ContactCycleRequestBeanGetResponse;
import com.comparadorad.bet.comparer.autosender.getresponse.requestbean.DeleteContactRequestBeanGetResponse;
import com.comparadorad.bet.comparer.autosender.getresponse.requestbean.MessageResquestBeanGetResponse;
import com.comparadorad.bet.comparer.autosender.getresponse.requestbean.MoveContactRequestBeanGetResponse;
import com.comparadorad.bet.comparer.autosender.getresponse.requestbean.PaymentListResquestBeanGetResponse;

/**
 * The Interface IAutosenderGetResponse.
 */
public interface IAutosenderGetResponse {


	/**
	 * Test connection.
	 *
	 * @return the i response bean
	 * @throws HttpException the http exception
	 * @throws ExternalAutoSenderException the get response exception
	 * @throws IOException Signals that an I/O exception has occurred.
	 * @throws InvalidEncodingMessageGetResponseException the invalid encoding message get response exception
	 */
	IResponseBean testConnection() throws HttpException, ExternalAutoSenderException, IOException, InvalidEncodingMessageGetResponseException;


	/**
	 * Adds the contact.
	 *
	 * @param requestBeanGetResponse the request bean get response
	 * @return the i response bean
	 * @throws HttpException the http exception
	 * @throws ExternalAutoSenderException the get response exception
	 * @throws IOException Signals that an I/O exception has occurred.
	 * @throws InvalidBeanException the invalid bean exception
	 * @throws InvalidEncodingMessageGetResponseException the invalid encoding message get response exception
	 */
	IResponseBean addContact(AddContactRequestBeanGetResponse requestBeanGetResponse) throws HttpException, ExternalAutoSenderException, IOException, InvalidBeanException, InvalidEncodingMessageGetResponseException;


	/**
	 * Move contact.
	 *
	 * @param contactRequestBeanGetResponse the contact request bean get response
	 * @return the i response bean
	 * @throws InvalidBeanException the invalid bean exception
	 * @throws InvalidEncodingMessageGetResponseException the invalid encoding message get response exception
	 * @throws HttpException the http exception
	 * @throws ExternalAutoSenderException the get response exception
	 * @throws IOException Signals that an I/O exception has occurred.
	 * @throws MissingContactException the missing contact exception
	 */
	IResponseBean moveContact(MoveContactRequestBeanGetResponse contactRequestBeanGetResponse) throws InvalidBeanException, InvalidEncodingMessageGetResponseException, HttpException, ExternalAutoSenderException, IOException, MissingContactException;


	/**
	 * Delete contact.
	 *
	 * @param deleteContactRequestBeanGetResponse the delete contact request bean get response
	 * @return the i response bean
	 * @throws InvalidBeanException the invalid bean exception
	 * @throws InvalidEncodingMessageGetResponseException the invalid encoding message get response exception
	 * @throws HttpException the http exception
	 * @throws ExternalAutoSenderException the get response exception
	 * @throws IOException Signals that an I/O exception has occurred.
	 * @throws MissingContactException the missing contact exception
	 */
	IResponseBean deleteContact(DeleteContactRequestBeanGetResponse deleteContactRequestBeanGetResponse)  throws InvalidBeanException, InvalidEncodingMessageGetResponseException, HttpException, ExternalAutoSenderException, IOException, MissingContactException;

	
	/**
	 * Send newsletter.
	 *
	 * @param messageResquestBeanGetResponse the message resquest bean get response
	 * @return the i response bean
	 * @throws InvalidBeanException the invalid bean exception
	 * @throws InvalidEncodingMessageGetResponseException the invalid encoding message get response exception
	 * @throws HttpException the http exception
	 * @throws ExternalAutoSenderException the get response exception
	 * @throws IOException Signals that an I/O exception has occurred.
	 */
	IResponseBean sendNewsletter(MessageResquestBeanGetResponse messageResquestBeanGetResponse) throws InvalidBeanException, InvalidEncodingMessageGetResponseException, HttpException, ExternalAutoSenderException, IOException;
	
	/**
	 * Gets the payment list.
	 *
	 * @param paymentListRequestBean the payment list request bean
	 * @return the payment list
	 */
	IResponseBean getPaymentList(PaymentListResquestBeanGetResponse paymentListRequestBean) throws HttpException, InvalidEncodingMessageGetResponseException, ExternalAutoSenderException, IOException;
	
	
	
	IResponseBean setContactCycle(ContactCycleRequestBeanGetResponse contactCycleRequestBean) throws HttpException, InvalidEncodingMessageGetResponseException, ExternalAutoSenderException, IOException;
}
