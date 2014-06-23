/**
 *
 * Copyright (C) FACTORIA ETSIA S.L.
 * All Rights Reserved.
 * www.factoriaetsia.com
 *
 */
package com.comparadorad.bet.comparer.autosender.getresponse.facade;



import java.io.IOException;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.Set;

import javax.annotation.Resource;
import javax.inject.Inject;
import javax.validation.ConstraintViolation;
import javax.validation.Validator;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import org.apache.commons.httpclient.HttpException;
import org.springframework.stereotype.Component;

import com.comparadorad.bet.comparer.autosender.core.exception.ExternalAutoSenderException;
import com.comparadorad.bet.comparer.autosender.core.exception.InvalidBeanException;
import com.comparadorad.bet.comparer.autosender.core.exception.InvalidEncodingMessageGetResponseException;
import com.comparadorad.bet.comparer.autosender.core.exception.MissingContactException;
import com.comparadorad.bet.comparer.autosender.core.responsebean.CampaignListBean;
import com.comparadorad.bet.comparer.autosender.core.responsebean.GenericResponseBean;
import com.comparadorad.bet.comparer.autosender.core.responsebean.IResponseBean;
import com.comparadorad.bet.comparer.autosender.getresponse.bean.ResponseBean;
import com.comparadorad.bet.comparer.autosender.getresponse.core.IHttpPostMethod;
import com.comparadorad.bet.comparer.autosender.getresponse.enume.ContactParams;
import com.comparadorad.bet.comparer.autosender.getresponse.enume.GetResponseMethods;
import com.comparadorad.bet.comparer.autosender.getresponse.enume.MessageParams;
import com.comparadorad.bet.comparer.autosender.getresponse.exception.MissingRecipientsException;
import com.comparadorad.bet.comparer.autosender.getresponse.requestbean.AddContactRequestBeanGetResponse;
import com.comparadorad.bet.comparer.autosender.getresponse.requestbean.ContactCycleRequestBeanGetResponse;
import com.comparadorad.bet.comparer.autosender.getresponse.requestbean.DeleteContactRequestBeanGetResponse;
import com.comparadorad.bet.comparer.autosender.getresponse.requestbean.MessageResquestBeanGetResponse;
import com.comparadorad.bet.comparer.autosender.getresponse.requestbean.MoveContactRequestBeanGetResponse;
import com.comparadorad.bet.comparer.autosender.getresponse.requestbean.PaymentListResquestBeanGetResponse;


/**
 * The Class AutosenderGetResponseImpl.
 */
@Component
public class AutosenderGetResponseImpl implements IAutosenderGetResponse{

	/** The Constant RESULT. */
	private static final String RESULT = "result";

	/** The post. */
	@Inject
	private IHttpPostMethod post;

	/** The validator. */
	@Inject
	@Resource(name="ValidatorGetResponse")
	private Validator validator;

	/* (non-Javadoc)
	 * @see com.comparadorad.bet.comparer.autosender.getresponse.facade.IAutosenderGetResponse#testConnection()
	 */
	@Override
	public IResponseBean testConnection() throws HttpException, ExternalAutoSenderException, IOException, InvalidEncodingMessageGetResponseException {
		GenericResponseBean genericResponse =  new GenericResponseBean();

		post.init(GetResponseMethods.PING.getNameId());
		post.setMessageContent(null);
		ResponseBean response =  post.executeMethod();
		post.releaseConnection();

		genericResponse.setStatus(response.getStatus());
		genericResponse.setContent(response.getJsonContent().toString());

		return genericResponse;
	}



	/* (non-Javadoc)
	 * @see com.comparadorad.bet.comparer.autosender.getresponse.facade.IAutosenderGetResponse#addContact(com.comparadorad.bet.comparer.autosender.getresponse.requestbean.AddContactRequestBeanGetResponse)
	 */
	@Override
	public IResponseBean addContact(AddContactRequestBeanGetResponse contactRequestBean) throws HttpException, ExternalAutoSenderException, IOException, InvalidBeanException, InvalidEncodingMessageGetResponseException {
		GenericResponseBean genericResponse =  new GenericResponseBean();
		Hashtable<String, Object> params = new Hashtable<String, Object>();
		Set<ConstraintViolation<AddContactRequestBeanGetResponse>> constraintViolations;
		//validación del bean
		constraintViolations = validator.validate(contactRequestBean);
		if(constraintViolations.size()!=0){
			throw new InvalidBeanException();
		}
		//atributos fijos
		params.put(ContactParams.CAMPAIGN.getNameId(), contactRequestBean.getCampaign());
		params.put(ContactParams.NAME.getNameId(), contactRequestBean.getName());
		params.put(ContactParams.EMAIL.getNameId(), contactRequestBean.getEmail());
		params.put(ContactParams.CYCLE_DAY.getNameId(), contactRequestBean.getCycle_day());
		//atributos opcionales
		if(contactRequestBean.getAction()!=null){
			params.put(ContactParams.ACTION.getNameId(), contactRequestBean.getAction().getNameId());
		}

		if(contactRequestBean.getCycle_day()!=null){
			params.put(ContactParams.CYCLE_DAY.getNameId(), contactRequestBean.getCycle_day());
		}

		if(contactRequestBean.getIp()!=null){
			params.put(ContactParams.IP.getNameId(), contactRequestBean.getIp());	
		}
		if(contactRequestBean.getCustoms()!=null){
			params.put(ContactParams.CUSTOMS.getNameId(), contactRequestBean.getCustoms());	
		}
		//método
		post.init(GetResponseMethods.ADD_CONTACT.getNameId());
		//contenido
		post.setMessageContent(params);
		//ejecucion
		ResponseBean response =  post.executeMethod();
		//desconexion
		post.releaseConnection();
		//respuesta
		genericResponse.setStatus(response.getStatus());
		genericResponse.setContent(response.getJsonContent().toString());

		return genericResponse;
	}



	/* (non-Javadoc)
	 * @see com.comparadorad.bet.comparer.autosender.getresponse.facade.IAutosenderGetResponse#moveContact(com.comparadorad.bet.comparer.autosender.getresponse.requestbean.MoveContactRequestBeanGetResponse)
	 */
	@Override
	public IResponseBean moveContact(MoveContactRequestBeanGetResponse contactRequestBeanGetResponse) throws InvalidBeanException, InvalidEncodingMessageGetResponseException, HttpException, ExternalAutoSenderException, IOException, MissingContactException {
		GenericResponseBean genericResponse =  new GenericResponseBean();
		Set<ConstraintViolation<MoveContactRequestBeanGetResponse>> constraintViolations;
		Hashtable<String, Object> params = new Hashtable<String, Object>();
		//validación del bean
		constraintViolations = validator.validate(contactRequestBeanGetResponse);
		if(constraintViolations.size()!=0){
			throw new InvalidBeanException();
		}

		//atributos fijos
		String user_id = getUserId(contactRequestBeanGetResponse.getOriginCampaignId(),contactRequestBeanGetResponse.getEmail());

		//atributos fijos
		params.put(ContactParams.CONTACT.getNameId(), user_id);
		params.put(ContactParams.CAMPAIGN.getNameId(), contactRequestBeanGetResponse.getDestinyCampaignId());

		//método
		post.init(GetResponseMethods.MOVE_CONTACT.getNameId());
		//contenido
		post.setMessageContent(params);
		//ejecucion
		ResponseBean response =  post.executeMethod();
		//desconexion
		post.releaseConnection();
		//respuesta
		genericResponse.setStatus(response.getStatus());
		genericResponse.setContent(response.getJsonContent().toString());

		return genericResponse;
	}



	/* (non-Javadoc)
	 * @see com.comparadorad.bet.comparer.autosender.getresponse.facade.IAutosenderGetResponse#deleteContact(com.comparadorad.bet.comparer.autosender.getresponse.requestbean.DeleteContactRequestBeanGetResponse)
	 */
	@Override
	public IResponseBean deleteContact(
			DeleteContactRequestBeanGetResponse deleteContactRequestBeanGetResponse) throws InvalidBeanException, InvalidEncodingMessageGetResponseException, HttpException, ExternalAutoSenderException, IOException, MissingContactException {
		GenericResponseBean genericResponse =  new GenericResponseBean();
		Set<ConstraintViolation<DeleteContactRequestBeanGetResponse>> constraintViolations;
		Hashtable<String, Object> params = new Hashtable<String, Object>();
		//validación del bean
		constraintViolations = validator.validate(deleteContactRequestBeanGetResponse);
		if(constraintViolations.size()!=0){
			throw new InvalidBeanException();
		}
		//atributos fijos
		String user_id = getUserId(deleteContactRequestBeanGetResponse.getCampaign(),deleteContactRequestBeanGetResponse.getEmail());

		params.put(ContactParams.CONTACT.getNameId(), user_id);

		//método
		post.init(GetResponseMethods.DELETE_CONTACT.getNameId());
		//contenido
		post.setMessageContent(params);
		//ejecucion
		ResponseBean response =  post.executeMethod();
		//desconexion
		post.releaseConnection();
		//respuesta
		genericResponse.setStatus(response.getStatus());
		genericResponse.setContent(response.getJsonContent().toString());

		return genericResponse;
	}

	/* (non-Javadoc)
	 * @see com.comparadorad.bet.comparer.autosender.getresponse.facade.IAutosenderGetResponse#sendNewsletter(com.comparadorad.bet.comparer.autosender.getresponse.requestbean.MessageResquestBeanGetResponse)
	 */
	public IResponseBean sendNewsletter(MessageResquestBeanGetResponse messageResquestBeanGetResponse) throws HttpException, ExternalAutoSenderException, IOException{
		GenericResponseBean genericResponse =  new GenericResponseBean();
		Set<ConstraintViolation<MessageResquestBeanGetResponse>> constraintViolations;
		Hashtable<String, Object> params = new Hashtable<String, Object>();
		ResponseBean response = null;
		//validación del bean
		constraintViolations = validator.validate(messageResquestBeanGetResponse);
		if(constraintViolations.size()!=0){
			throw new InvalidBeanException("El bean esta mal generado");
		}
		//atributos fijos
		params.put(MessageParams.CAMPAIGN.getNameId(), messageResquestBeanGetResponse.getCampaignId());
		params.put(MessageParams.SUBJECT.getNameId(), messageResquestBeanGetResponse.getSubject());
		Hashtable<String, String> aux = new Hashtable<String, String>(); 
		aux.put(messageResquestBeanGetResponse.getMessageType().getNameId(), messageResquestBeanGetResponse.getContent());
		params.put(MessageParams.CONTENTS.getNameId(), aux);
		JSONArray users_id = getCampaignUsers(messageResquestBeanGetResponse.getCampaignId());
		params.put(MessageParams.CONTACTS.getNameId(), users_id);
		//método
		post.init(GetResponseMethods.SEND_NEWSLETTER.getNameId());
		//contenido
		post.setMessageContent(params);
		//ejecucion
		response =  post.executeMethod();		
		//desconexion
		post.releaseConnection();
		//respuesta
		genericResponse.setStatus(response.getStatus());
		genericResponse.setContent(response.getJsonContent().toString());

		return genericResponse;
	}

	/**
	 * Gets the campaign users.
	 *
	 * @param campaignId the campaign id
	 * @return the campaign users
	 * @throws InvalidEncodingMessageGetResponseException the invalid encoding message get response exception
	 * @throws HttpException the http exception
	 * @throws ExternalAutoSenderException the external auto sender exception
	 * @throws IOException Signals that an I/O exception has occurred.
	 */
	private JSONArray getCampaignUsers(String campaignId) throws InvalidEncodingMessageGetResponseException, HttpException, ExternalAutoSenderException, IOException {
		JSONArray result = null;
		Hashtable<String, Object> params = new Hashtable<String, Object>();
		Object[] camp = {campaignId};
		params.put(ContactParams.CAMPAIGNS.getNameId(), camp);

		//método
		post.init(GetResponseMethods.GET_CONTACTS.getNameId());
		//contenido
		post.setMessageContent(params);
		//ejecucion
		ResponseBean response =  post.executeMethod();

		result = JSONObject.fromObject(response.getJsonContent().get(RESULT)).names();
		//desconexion
		post.releaseConnection();
		//respuesta
		return result;
	}



	/**
	 * Gets the user id.
	 *
	 * @param campaign the campaign
	 * @param email the email
	 * @return the user id
	 * @throws InvalidEncodingMessageGetResponseException the invalid encoding message get response exception
	 * @throws HttpException the http exception
	 * @throws ExternalAutoSenderException the get response exception
	 * @throws IOException Signals that an I/O exception has occurred.
	 * @throws MissingContactException the missing contact exception
	 */
	private String getUserId(String campaign, String email) throws InvalidEncodingMessageGetResponseException, HttpException, ExternalAutoSenderException, IOException, MissingContactException {
		String result = null;

		Hashtable<String, Object> params = new Hashtable<String, Object>();
		Hashtable<String, String> aux = new Hashtable<String, String>();

		Object[] camp = {campaign};
		params.put(ContactParams.CAMPAIGNS.getNameId(), camp);
		aux.put(ContactParams.OPERATOR_EQUALS.getNameId(), email);
		params.put(ContactParams.EMAIL.getNameId(), aux);
		//método
		post.init(GetResponseMethods.GET_CONTACTS.getNameId());
		//contenido
		post.setMessageContent(params);
		//ejecucion
		ResponseBean response =  post.executeMethod();
		//desconexion
		post.releaseConnection();
		if(!JSONObject.fromObject(response.getJsonContent().get(RESULT)).isEmpty()){
			result = JSONObject.fromObject(response.getJsonContent().get(RESULT)).names().getString(0);
		}else{
			throw new MissingContactException();
		}


		//respuesta

		return result;
	}



	/* (non-Javadoc)
	 * @see com.comparadorad.bet.comparer.autosender.getresponse.facade.IAutosenderGetResponse#getPaymentList(com.comparadorad.bet.comparer.autosender.getresponse.requestbean.PaymentListResquestBeanGetResponse)
	 */
	@Override
	public IResponseBean getPaymentList(PaymentListResquestBeanGetResponse paymentListRequestBean) throws HttpException, InvalidEncodingMessageGetResponseException, ExternalAutoSenderException, IOException {
		GenericResponseBean genericResponseBean = new GenericResponseBean();

		for (String list : paymentListRequestBean.getPaymentList()) {
			try {
				getUserId(list, paymentListRequestBean.getEmail());
				genericResponseBean.setContent(list);
				break;

			} catch (MissingContactException e) {

			}

		}

		return genericResponseBean;
	}

	public CampaignListBean getCampaignList() throws HttpException,
	InvalidEncodingMessageGetResponseException,
	ExternalAutoSenderException, IOException{
		CampaignListBean result = new CampaignListBean();
		ResponseBean response;

		Hashtable<String, Object> params = new Hashtable<String, Object>();
		Hashtable<String, String> aux = new Hashtable<String, String>();

		aux.put(ContactParams.CONTAINS.getNameId(), ContactParams.ALL.getNameId());
		params.put(ContactParams.NAME.getNameId(), aux);


		post.init(GetResponseMethods.GET_CAMPAIGNS.getNameId());
		post.setMessageContent(params);
		response = post.executeMethod();
		post.releaseConnection();


		if(!JSONObject.fromObject(response.getJsonContent().get(RESULT)).isEmpty()){
			String key;
			String value;
			JSONObject jsonObject;
			for (@SuppressWarnings("unchecked")
			Iterator<String> iterator = JSONObject.fromObject(response.getJsonContent().get(RESULT)).keys(); iterator
					.hasNext();) {
				value = iterator.next();
				jsonObject = (JSONObject) JSONObject.fromObject(response.getJsonContent().get(RESULT)).get(value);
				key = jsonObject.getString("name");
				result.getCampaignNameAndcampaignId().put(key, value);
			}

		}

		return result;
	}



	@Override
	public IResponseBean setContactCycle(
			ContactCycleRequestBeanGetResponse contactCycleRequestBean)
					throws HttpException, InvalidEncodingMessageGetResponseException,
					ExternalAutoSenderException, IOException {

		GenericResponseBean genericResponse =  new GenericResponseBean();
		Set<ConstraintViolation<ContactCycleRequestBeanGetResponse>> constraintViolations;
		Hashtable<String, Object> params = new Hashtable<String, Object>();
		//validación del bean
		constraintViolations = validator.validate(contactCycleRequestBean);
		if(constraintViolations.size()!=0){
			throw new InvalidBeanException();
		}

		//atributos fijos
		String user_id = getUserId(contactCycleRequestBean.getOriginCampaignId(),contactCycleRequestBean.getEmail());

		//atributos fijos
		params.put(ContactParams.CONTACT.getNameId(), user_id);
		params.put(ContactParams.CYCLE_DAY.getNameId(), contactCycleRequestBean.getCycle_day());

		//método
		post.init(GetResponseMethods.SET_CONTACT_CYCLE.getNameId());
		//contenido
		post.setMessageContent(params);
		//ejecucion
		ResponseBean response =  post.executeMethod();
		//desconexion
		post.releaseConnection();
		//respuesta
		genericResponse.setStatus(response.getStatus());
		genericResponse.setContent(response.getJsonContent().toString());

		return genericResponse;

	}










}
