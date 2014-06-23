/**
 *
 * Copyright (C) FACTORIA ETSIA S.L.
 * All Rights Reserved.
 * www.factoriaetsia.com
 *
 */
package com.comparadorad.bet.comparer.autosender.getresponse.facade;

import static com.comparadorad.bet.comparer.autosender.getresponse.convert.BeanConvert.addContactConver;
import static com.comparadorad.bet.comparer.autosender.getresponse.convert.BeanConvert.deleteContactConvert;
import static com.comparadorad.bet.comparer.autosender.getresponse.convert.BeanConvert.moveContactConvert;
import static com.comparadorad.bet.comparer.autosender.getresponse.convert.BeanConvert.paymentListConvert;
import static com.comparadorad.bet.comparer.autosender.getresponse.convert.BeanConvert.sendNewsletterConvert;
import static com.comparadorad.bet.comparer.autosender.getresponse.convert.BeanConvert.setContactCycleConvert;

import java.io.IOException;

import javax.inject.Inject;

import org.apache.commons.httpclient.HttpException;
import org.springframework.stereotype.Component;

import com.comparadorad.bet.comparer.autosender.core.exception.ExternalAutoSenderException;
import com.comparadorad.bet.comparer.autosender.core.facade.IAutosender;
import com.comparadorad.bet.comparer.autosender.core.requestbean.AddContactRequestBean;
import com.comparadorad.bet.comparer.autosender.core.requestbean.ContactCycleRequestBean;
import com.comparadorad.bet.comparer.autosender.core.requestbean.DeleteContactRequestBean;
import com.comparadorad.bet.comparer.autosender.core.requestbean.MessageResquestBean;
import com.comparadorad.bet.comparer.autosender.core.requestbean.MoveContactRequestBean;
import com.comparadorad.bet.comparer.autosender.core.requestbean.PaymentListResquestBean;
import com.comparadorad.bet.comparer.autosender.core.responsebean.CampaignListBean;
import com.comparadorad.bet.comparer.autosender.core.responsebean.IResponseBean;

/**
 * The Class FacadeGetResponse.
 */
@Component
public class FacadeGetResponse implements IAutosender {

	/** The autosender. */
	@Inject
	private AutosenderGetResponseImpl autosender;


	/** {@inheritDoc} */ 
	@Override
	public IResponseBean testConnection() throws HttpException, IOException,
			ExternalAutoSenderException {
		return autosender.testConnection();
	}


	/** {@inheritDoc} */ 
	@Override
	public IResponseBean addContact(AddContactRequestBean addContactRequestBean)
			throws HttpException, IOException, ExternalAutoSenderException {
		return autosender.addContact(addContactConver(addContactRequestBean));
	}


	/** {@inheritDoc} */ 
	@Override
	public IResponseBean moveContact(
			MoveContactRequestBean moveContactRequestBean)
			throws HttpException, IOException, ExternalAutoSenderException {
		return autosender
				.moveContact(moveContactConvert(moveContactRequestBean));
	}


	/** {@inheritDoc} */ 
	@Override
	public IResponseBean deleteContact(
			DeleteContactRequestBean deleteContactRequestBean)
			throws HttpException, ExternalAutoSenderException, IOException {
		return autosender
				.deleteContact(deleteContactConvert(deleteContactRequestBean));
	}

	/** {@inheritDoc} */ 
	@Override
	public IResponseBean sendNewsletter(MessageResquestBean messageResquestBean)
			throws HttpException, ExternalAutoSenderException, IOException {
		return autosender
				.sendNewsletter(sendNewsletterConvert(messageResquestBean));
	}

	/** {@inheritDoc} */ 
	@Override
	public IResponseBean getPaymentList(
			PaymentListResquestBean paymentListRequestBean)
			throws HttpException, ExternalAutoSenderException, IOException {

		return autosender
				.getPaymentList(paymentListConvert(paymentListRequestBean));
	}

	/** {@inheritDoc} */ 
	@Override
	public CampaignListBean getCampaignList() throws HttpException,
			ExternalAutoSenderException, IOException {
		return autosender.getCampaignList();
	}


	@Override
	public IResponseBean setContactCycle(
			ContactCycleRequestBean contactCycleRequestBean)
			throws HttpException, IOException, ExternalAutoSenderException {
		return autosender.setContactCycle(setContactCycleConvert(contactCycleRequestBean));
	}

}
