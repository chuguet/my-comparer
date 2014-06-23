/**
 *
 * Copyright (C) FACTORIA ETSIA S.L.
 * All Rights Reserved.
 * www.factoriaetsia.com
 *
 */
package com.comparadorad.bet.comparer.autosender.getresponse.convert;

import java.util.Hashtable;
import java.util.Iterator;
import java.util.Map.Entry;

import com.comparadorad.bet.comparer.autosender.core.requestbean.AddContactRequestBean;
import com.comparadorad.bet.comparer.autosender.core.requestbean.ContactCycleRequestBean;
import com.comparadorad.bet.comparer.autosender.core.requestbean.DeleteContactRequestBean;
import com.comparadorad.bet.comparer.autosender.core.requestbean.MessageResquestBean;
import com.comparadorad.bet.comparer.autosender.core.requestbean.MoveContactRequestBean;
import com.comparadorad.bet.comparer.autosender.core.requestbean.PaymentListResquestBean;
import com.comparadorad.bet.comparer.autosender.getresponse.enume.AddContactAction;
import com.comparadorad.bet.comparer.autosender.getresponse.enume.ContactParams;
import com.comparadorad.bet.comparer.autosender.getresponse.requestbean.AddContactRequestBeanGetResponse;
import com.comparadorad.bet.comparer.autosender.getresponse.requestbean.ContactCycleRequestBeanGetResponse;
import com.comparadorad.bet.comparer.autosender.getresponse.requestbean.DeleteContactRequestBeanGetResponse;
import com.comparadorad.bet.comparer.autosender.getresponse.requestbean.MessageResquestBeanGetResponse;
import com.comparadorad.bet.comparer.autosender.getresponse.requestbean.MoveContactRequestBeanGetResponse;
import com.comparadorad.bet.comparer.autosender.getresponse.requestbean.PaymentListResquestBeanGetResponse;

/**
 * The Class BeanConver.
 */
public class BeanConvert {

	/**
	 * Contact conver.
	 * 
	 * @param contactRequestBean
	 *            the contact request bean
	 * @return the contact request bean get response
	 */
	public static AddContactRequestBeanGetResponse addContactConver(
			AddContactRequestBean contactRequestBean) {
		AddContactRequestBeanGetResponse result = new AddContactRequestBeanGetResponse();

		result.setCampaign(contactRequestBean.getCampaignId());
		result.setEmail(contactRequestBean.getEmail());
		result.setIp(contactRequestBean.getIp());
		result.setName(contactRequestBean.getName());
		result.setCycle_day(contactRequestBean.getCycle_day());
		if (contactRequestBean.getCustoms() != null) {

			Object[] customs = new Object[contactRequestBean.getCustoms()
					.size()];

			int j = 0;
			Iterator<Entry<String, String>> it = contactRequestBean
					.getCustoms().entrySet().iterator();
			Entry<String, String> value;
			Hashtable<String, String> param = new Hashtable<String, String>();
			;
			while (it.hasNext()) {
				value = it.next();
				param.put(ContactParams.CUSTOM_NAME.getNameId(), value.getKey());
				param.put(ContactParams.CUSTOM_CONTENT.getNameId(),
						value.getValue());
				customs[j] = param.clone();
				param.clear();
				j++;
			}
			result.setCustoms(customs);
		}

		AddContactAction[] actions = AddContactAction.values();
		if (contactRequestBean.getAction() != null) {
			for (int i = 0; i < actions.length; i++) {
				if (contactRequestBean.getAction().getNameId()
						.equals(actions[i].getAction().getNameId())) {
					result.setAction(actions[i]);
				}
			}
		}
		return result;
	}

	/**
	 * Move contact convert.
	 * 
	 * @param moveContactRequestBean
	 *            the move contact request bean
	 * @return the move contact request bean get response
	 */
	public static MoveContactRequestBeanGetResponse moveContactConvert(
			MoveContactRequestBean moveContactRequestBean) {
		MoveContactRequestBeanGetResponse result = new MoveContactRequestBeanGetResponse();
		result.setOriginCampaignId(moveContactRequestBean.getOriginCampaignId());
		result.setDestinyCampaignId(moveContactRequestBean.getDestinyCampaignId());
		result.setEmail(moveContactRequestBean.getEmail());
		
		return result;
	}

	/**
	 * Delete contact convert.
	 * 
	 * @param deleteContactRequestBean
	 *            the delete contact request bean
	 * @return the delete contact request bean get response
	 */
	public static DeleteContactRequestBeanGetResponse deleteContactConvert(
			DeleteContactRequestBean deleteContactRequestBean) {
		DeleteContactRequestBeanGetResponse deleteContactRequestBeanGetResponse = new DeleteContactRequestBeanGetResponse();
		deleteContactRequestBeanGetResponse
				.setCampaign(deleteContactRequestBean.getCampaign());
		deleteContactRequestBeanGetResponse.setEmail(deleteContactRequestBean
				.getEmail());
		return deleteContactRequestBeanGetResponse;
	}

	/**
	 * Send newsletter convert.
	 * 
	 * @param messageResquestBean
	 *            the message resquest bean
	 * @return the message resquest bean get response
	 */
	public static MessageResquestBeanGetResponse sendNewsletterConvert(
			MessageResquestBean messageResquestBean) {
		MessageResquestBeanGetResponse messageResquestBeanGetResponse = new MessageResquestBeanGetResponse();
		messageResquestBeanGetResponse.setCampaignId(messageResquestBean
				.getCampaignId());
		messageResquestBeanGetResponse.setSubject(messageResquestBean
				.getSubject());
		messageResquestBeanGetResponse.setMessageType(messageResquestBean
				.getMessageType());
		messageResquestBeanGetResponse.setContent(messageResquestBean
				.getContent());

		return messageResquestBeanGetResponse;

	}
	
	/**
	 * Payment list convert.
	 *
	 * @param paymentListResquestBean the payment list resquest bean
	 * @return the payment list resquest bean get response
	 */
	public static PaymentListResquestBeanGetResponse paymentListConvert(PaymentListResquestBean paymentListResquestBean){
		PaymentListResquestBeanGetResponse resquestBeanGetResponse = new PaymentListResquestBeanGetResponse();
		
		resquestBeanGetResponse.setEmail(paymentListResquestBean.getEmail());
		resquestBeanGetResponse.setPaymentList(paymentListResquestBean.getPaymentList());
		
		return resquestBeanGetResponse;
	}
	
	public static ContactCycleRequestBeanGetResponse  setContactCycleConvert(ContactCycleRequestBean contactCycleRequestBean){
		ContactCycleRequestBeanGetResponse result = new ContactCycleRequestBeanGetResponse();
		
		result.setEmail(contactCycleRequestBean.getEmail());
		result.setOriginCampaignId(contactCycleRequestBean.getOriginCampaignId());
		result.setCycle_day(contactCycleRequestBean.getCycle_day());
		
		return result;
	}
	
	
}
