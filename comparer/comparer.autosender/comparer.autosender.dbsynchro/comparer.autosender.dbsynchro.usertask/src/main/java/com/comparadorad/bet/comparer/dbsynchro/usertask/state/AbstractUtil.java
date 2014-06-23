/**
 *
 * Copyright (C) FACTORIA ETSIA S.L.
 * All Rights Reserved.
 * www.factoriaetsia.com
 *
 */
package com.comparadorad.bet.comparer.dbsynchro.usertask.state;

import java.io.IOException;
import java.util.Collection;

import javax.inject.Inject;

import org.apache.commons.httpclient.HttpException;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Component;

import com.comparadorad.bet.comparer.autosender.core.exception.ExternalAutoSenderException;
import com.comparadorad.bet.comparer.autosender.core.exception.InvalidBeanException;
import com.comparadorad.bet.comparer.autosender.core.exception.InvalidEncodingMessageGetResponseException;
import com.comparadorad.bet.comparer.autosender.core.facade.IAutosender;
import com.comparadorad.bet.comparer.autosender.core.requestbean.AddContactRequestBean;
import com.comparadorad.bet.comparer.autosender.core.requestbean.ContactCycleRequestBean;
import com.comparadorad.bet.comparer.autosender.core.requestbean.DeleteContactRequestBean;
import com.comparadorad.bet.comparer.autosender.core.requestbean.MoveContactRequestBean;
import com.comparadorad.bet.comparer.dbsynchro.usertask.context.IUserContext;
import com.comparadorad.bet.comparer.dbsynchro.usertask.exception.StateException;
import com.comparadorad.bet.comparer.model.autosender.bean.LogAction;
import com.comparadorad.bet.comparer.model.autosender.bean.LogAction.isCorrect;
import com.comparadorad.bet.comparer.model.autosender.bean.TypePayment.TypePaymentName;
import com.comparadorad.bet.comparer.model.autosender.bean.UserAction;
import com.comparadorad.bet.comparer.model.autosender.bean.UserContent;
import com.comparadorad.bet.comparer.model.autosender.bean.UserPayment;
import com.comparadorad.bet.comparer.model.autosender.bean.UserPayment.StatePayment;
import com.comparadorad.bet.comparer.model.autosender.service.IUserActionService;
import com.comparadorad.bet.comparer.payment.adapter.facade.IPaymentFacade;
import com.comparadorad.bet.comparer.payment.adapter.facade.impl.PaymentFacade;
import com.comparadorad.bet.comparer.web.rest.beans.UserInfoRequest;
import com.comparadorad.bet.comparer.web.rest.beans.enume.UserTypes;
import com.comparadorad.bet.comparer.web.restclient.core.IRestClient;
import com.comparadorad.bet.comparer.web.restclient.exception.RestClientException;

/**
 * The Class AbstractState.
 */

abstract class AbstractUtil implements IState {
	/** The Constant LOG. */
	private static final Log LOG = LogFactory.getLog(AbstractUtil.class);

	/** The autosender. */
	@Inject
	private IAutosender autosender;

	/** The rest client. */
	@Inject
	private IRestClient restClient;

	/** The user action service. */
	@Inject
	private IUserActionService userActionService;

	/** The user context. */
	private IUserContext userContext;
	
	@Inject
	private PaymentFacade paymentFacade;


	/**
	 * Adds the contact.
	 * 
	 * @param contact
	 *            the contact
	 * @throws StateException
	 *             the user state exception
	 */
	private void addContact(AddContactRequestBean contact)
			throws StateException {
		try {
			LOG.info(new StringBuffer()
					.append("Se añade el usuario a la lista: ")
					.append(contact.toString()).toString());
			autosender.addContact(contact);
		} catch (HttpException e) {
			LOG.error(e.getMessage());
			throw new StateException(e.getMessage());
		} catch (ExternalAutoSenderException e) {
			LOG.error(e.getMessage());
			throw new StateException(e.getMessage());
		} catch (IOException e) {
			LOG.error(e.getMessage());
			throw new StateException(e.getMessage());
		}
	}

	/**
	 * Adds the contact.
	 * 
	 * @param list
	 *            the list
	 * @throws StateException
	 *             the user state exception
	 */
	protected void addContentList(String list) throws StateException {
		AddContactRequestBean contact;
		contact = new AddContactRequestBean();
		contact.setCampaignId(list);
		contact.setEmail(this.getUserContext().getUser().getEmail());
		contact.setName(this.getUserContext().getUser().getName());
		contact.setCycle_day(0);
		addContact(contact);
	}

	/**
	 * Delete contact.
	 * 
	 * @param list
	 *            the list
	 * @throws StateException
	 *             the user state exception
	 */
	protected void addPaymentList(String list) throws StateException {
		AddContactRequestBean contact;
		contact = new AddContactRequestBean();
		contact.setCampaignId(list);
		contact.setEmail(this.getUserContext().getUser().getEmail());
		contact.setName(this.getUserContext().getUser().getName());
		contact.setCycle_day(0);
		addContact(contact);
	}

	/**
	 * Creates the user info request.
	 * 
	 * @param liferayUserId
	 *            the liferay user id
	 * @param lista
	 *            the lista
	 * @return the user info request
	 */
	private UserInfoRequest createUserInfoRequest(String liferayUserId,
			TypePaymentName lista) {
		UserInfoRequest requestRoles = new UserInfoRequest();
		requestRoles.setLiferayUserId(this.getUserContext().getUser()
				.getLiferayUserId().toString());
		requestRoles.setDestinyGroup(getTypePaymentLiferay(lista));
		return requestRoles;
	}

	/**
	 * Delete all content list.
	 * 
	 * @throws StateException
	 *             the state exception
	 */
	private void deleteAllContentList() throws StateException {
		DeleteContactRequestBean contact;
		if (this.getUserContext().getUser().getUserContents() != null) {
			for (UserContent content : this.getUserContext().getUser()
					.getUserContents()) {
				contact = new DeleteContactRequestBean();
				contact.setCampaign(content.getExtenalSystemId());
				contact.setEmail(this.getUserContext().getUser().getEmail());
				deleteContact(contact);
			}
		}
	}

	/**
	 * Delete contact.
	 * 
	 * @param contact
	 *            the contact
	 * @throws StateException
	 *             the user state exception
	 */
	private void deleteContact(DeleteContactRequestBean contact)
			throws StateException {
		try {
			autosender.deleteContact(contact);
		} catch (HttpException e) {
			LOG.error(e.getMessage());
			throw new StateException(e.getMessage());
		} catch (InvalidBeanException e) {
			LOG.error(e.getMessage());
			throw new StateException(e.getMessage());
		} catch (InvalidEncodingMessageGetResponseException e) {
			LOG.error(e.getMessage());
			throw new StateException(e.getMessage());
		} catch (ExternalAutoSenderException e) {
			LOG.error(e.getMessage());
			throw new StateException(e.getMessage());
		} catch (IOException e) {
			LOG.error(e.getMessage());
			throw new StateException(e.getMessage());
		}
	}

	/**
	 * Delete content list.
	 * 
	 * @param list
	 *            the list
	 * @throws StateException
	 *             the state exception
	 */
	protected void deleteContentList(String list) throws StateException {
		DeleteContactRequestBean contact;
		contact = new DeleteContactRequestBean();
		contact.setCampaign(list);
		contact.setEmail(this.getUserContext().getUser().getEmail());
		deleteContact(contact);
	}

	/**
	 * Delete payment list.
	 * 
	 * @throws StateException
	 *             the state exception
	 */
	private void deletePaymentList() throws StateException {
		DeleteContactRequestBean contact;
		UserPayment payment = getActivePayment(this.getUserContext().getUser()
				.getUserPayments());
		// TODO preguntar a la api en que lista de pagos esta
		contact = new DeleteContactRequestBean();
		contact.setCampaign(payment.getExtenalSystemId());
		contact.setEmail(this.getUserContext().getUser().getEmail());

		deleteContact(contact);
	}

	/**
	 * Delete user.
	 * 
	 * @throws StateException
	 *             the state exception
	 */
	protected void deleteUser() throws StateException {
		deletePaymentList();
		deleteAllContentList();
	}

	/**
	 * Gets the active payment.
	 * 
	 * @param userPayments
	 *            the user payments
	 * @return the active payment
	 */
	private UserPayment getActivePayment(Collection<UserPayment> userPayments) {
		UserPayment result = null;
		for (UserPayment payment : userPayments) {
			if (payment.getStatePayment().name()
					.equals(StatePayment.ACTIVE.name())) {
				result = payment;
				break;
			}
		}
		return result;
	}

	/**
	 * Gets the log.
	 * 
	 * @return the log
	 */
	protected abstract Log getLog();

	/**
	 * Gets the type payment liferay.
	 * 
	 * @param typePaymentName
	 *            the type payment name
	 * @return the type payment liferay
	 */
	private UserTypes getTypePaymentLiferay(TypePaymentName typePaymentName) {
		UserTypes userType = null;
		if (typePaymentName == null) {
			userType = UserTypes.GRATUITO;
		} else if (typePaymentName.equals(TypePaymentName.NIVEL_1)) {
			userType = UserTypes.NIVEL_1;
		} else if (typePaymentName.equals(TypePaymentName.NIVEL_2)) {
			userType = UserTypes.NIVEL_2;
		} else if (typePaymentName.equals(TypePaymentName.NIVEL_3)) {
			userType = UserTypes.NIVEL_3;
		}
		return userType;
	}

	/**
	 * Gets the type payment name by name id.
	 * 
	 * @param userPayments
	 *            the list
	 * @return the type payment name by name id
	 */
	private TypePaymentName getTypePaymentNameByUserPayment(
			Collection<UserPayment> userPayments) {
		TypePaymentName result = null;
		UserPayment activePayment = getActivePayment(userPayments);
		if (activePayment.getTypePayment().getTypePaymentName()
				.equals(TypePaymentName.NIVEL_1)) {
			result = TypePaymentName.NIVEL_1;
		} else if (activePayment.getTypePayment().getTypePaymentName()
				.equals(TypePaymentName.NIVEL_2)) {
			result = TypePaymentName.NIVEL_2;
		} else if (activePayment.getTypePayment().getTypePaymentName()
				.equals(TypePaymentName.NIVEL_3)) {
			result = TypePaymentName.NIVEL_3;
		}
		return result;
	}

	/**
	 * Gets the user action.
	 * 
	 * @return the user action
	 */
	protected IUserActionService getUserAction() {
		return userActionService;
	}

	/**
	 * Gets the user context.
	 * 
	 * @return the user context {@inheritDoc}
	 */
	public IUserContext getUserContext() {
		return userContext;
	}

	/**
	 * Modify contact.
	 * 
	 * @param contact
	 *            the contact
	 * @throws StateException
	 *             the state exception
	 */
	private void modifyContact(MoveContactRequestBean contact)
			throws StateException {
		try {
			this.autosender.moveContact(contact);
			
			ContactCycleRequestBean cycleRequestBean = new ContactCycleRequestBean();
			cycleRequestBean.setEmail(contact.getEmail());
			cycleRequestBean.setOriginCampaignId(contact.getDestinyCampaignId());
			cycleRequestBean.setCycle_day(0);
			
			this.autosender.setContactCycle(cycleRequestBean);
		} catch (HttpException e) {
			LOG.error(e.getMessage());
			throw new StateException(e.getMessage());
		} catch (InvalidBeanException e) {
			LOG.error(e.getMessage());
			throw new StateException(e.getMessage());
		} catch (InvalidEncodingMessageGetResponseException e) {
			LOG.error(e.getMessage());
			throw new StateException(e.getMessage());
		} catch (ExternalAutoSenderException e) {
			LOG.error(e.getMessage());
			throw new StateException(e.getMessage());
		} catch (IOException e) {
			LOG.error(e.getMessage());
			throw new StateException(e.getMessage());
		}
	}

	/**
	 * Modify contact payment.
	 *
	 * @param destinyList the destiny list
	 * @throws StateException the state exception
	 */
	protected void modifyPaymentList(String destinyList) throws StateException {
		MoveContactRequestBean contact;
		// String originList = this.autosender.getPaymentListActive(this
		// .getUserContext().getUser().getEmail()); TODO
		String originList = "Tab2";//genial..........
		LOG.debug(new StringBuffer().append("Se modifica la lista de pago a: ")
				.append(destinyList).toString());
		contact = new MoveContactRequestBean();
		contact.setOriginCampaignId(originList);
		contact.setDestinyCampaignId(destinyList);
		contact.setEmail(this.getUserContext().getUser().getEmail());

		modifyContact(contact);
	}

	/**
	 * Modify list liferay.
	 *
	 * @param userPayments the user payments
	 * @throws StateException the state exception
	 */
	protected void changeRoles(Collection<UserPayment> userPayments)
			throws StateException {
		LOG.debug(new StringBuffer()
				.append("Inicio de cambiar roles a un usuario de liferay con los payments ")
				.append(userPayments.toString()).toString());
		try {
			UserInfoRequest requestRoles = createUserInfoRequest(this
					.getUserContext().getUser().getLiferayUserId().toString(),
					getTypePaymentNameByUserPayment(userPayments));
			LOG.info(new StringBuffer()
					.append("Cambiamos los roles al usuario a los siguientes roles: ")
					.append(requestRoles.toString()).toString());
			restClient.changeRoles(requestRoles);
		} catch (RestClientException e) {
			LOG.error(e.getMessage());
			throw new StateException(e.getMessage());
		}
		LOG.debug("Fin de cambiar roles a un usuario de liferay.");
	}

	/**
	 * Change roles level one.
	 *
	 * @throws StateException the state exception
	 */
	protected void changeRolesLevelOne() throws StateException{
		UserInfoRequest requestRoles;
		try{
			getLog().info( new StringBuffer("Se procede a cambiar de estado a: ").append(this
					.getUserContext().getUser().getLiferayUserId()).append(" En liferay al ").append(TypePaymentName.NIVEL_1) );
			requestRoles = createUserInfoRequest(this
					.getUserContext().getUser().getLiferayUserId().toString(),
					TypePaymentName.NIVEL_1);
			restClient.changeRoles(requestRoles);	
		}catch (Exception e) {
			LOG.error(e.getMessage());
			throw new StateException(e.getMessage());
		}
	}
	
	/**
	 * Change roles level two.
	 *
	 * @throws StateException the state exception
	 */
	protected void changeRolesLevelTwo() throws StateException{
		UserInfoRequest requestRoles;
		try{
			requestRoles = createUserInfoRequest(this
					.getUserContext().getUser().getLiferayUserId().toString(),
					TypePaymentName.NIVEL_2);
			restClient.changeRoles(requestRoles);	
		}catch (Exception e) {
			LOG.error(e.getMessage());
			throw new StateException(e.getMessage());
		}
	}
	
	/**
	 * Change roles level three.
	 *
	 * @throws StateException the state exception
	 */
	protected void changeRolesLevelThree() throws StateException{
		UserInfoRequest requestRoles;
		try{
			getLog().info( new StringBuffer("Se procede a cambiar de estado a: ").append(this
					.getUserContext().getUser().getLiferayUserId()).append(" En liferay al ").append("grupo: GRATIS") );
			requestRoles = createUserInfoRequest(this
					.getUserContext().getUser().getLiferayUserId().toString(),
					TypePaymentName.NIVEL_3);
			restClient.changeRoles(requestRoles);	
		}catch (Exception e) {
			getLog().info( new StringBuffer("Error cambiando roles" ).toString());
			LOG.error(e.getMessage());
			throw new StateException(e.getMessage());
		}
	}
	
	protected void changeRolesToFree() throws StateException{
		UserInfoRequest requestRoles;
		try{
			requestRoles = createUserInfoRequest(this
					.getUserContext().getUser().getLiferayUserId().toString(),
					null);
			restClient.changeRoles(requestRoles);	
		}catch (Exception e) {
			LOG.error(e.getMessage());
			throw new StateException(e.getMessage());
		}
	}
	
	/**
	 * Sets the user context.
	 * 
	 * @param userContext
	 *            the new user context {@inheritDoc}
	 */
	public void setUserContext(IUserContext userContext) {
		this.userContext = userContext;
	}

	/**
	 * Succes action.
	 * 
	 * @param pUserAction
	 *            the user action
	 */
	protected void succesAction(UserAction pUserAction) {
		if (pUserAction.getLogAction() == null) {
			pUserAction.setLogAction(new LogAction());
		}
		pUserAction.getLogAction().setCorrect(isCorrect.SUCCESS);
		userActionService.update(pUserAction);
	}
	

	public IPaymentFacade getPaymentFacade() {
		return paymentFacade;
	}
}
