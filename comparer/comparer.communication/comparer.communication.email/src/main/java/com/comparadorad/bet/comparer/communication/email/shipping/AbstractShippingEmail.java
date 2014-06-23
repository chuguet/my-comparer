/**
 *
 * Copyright (C) FACTORIA ETSIA S.L.
 * All Rights Reserved.
 * www.factoriaetsia.com
 *
 */
package com.comparadorad.bet.comparer.communication.email.shipping;

import java.io.IOException;
import java.util.List;

import javax.inject.Inject;

import org.apache.commons.httpclient.HttpException;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.comparadorad.bet.comparer.autosender.core.enume.MessageType;
import com.comparadorad.bet.comparer.autosender.core.exception.ExternalAutoSenderException;
import com.comparadorad.bet.comparer.autosender.core.exception.MissingContactException;
import com.comparadorad.bet.comparer.autosender.core.facade.IAutosender;
import com.comparadorad.bet.comparer.autosender.core.requestbean.MessageResquestBean;
import com.comparadorad.bet.comparer.autosender.getresponse.enume.ListTypeUser;
import com.comparadorad.bet.comparer.communication.email.exception.ShippingEmailException;

/**
 * The Class AbstractShippingEmail.
 */
abstract class AbstractShippingEmail implements IShippingEmail {

	/** The auto sender. */
	@Inject
	private IAutosender autoSender;

	/** The Constant LOG. */
	private static final Log LOG = LogFactory
			.getLog(AbstractShippingEmail.class);

	/**
	 * The auto sender.
	 * 
	 * @param message
	 *            the message
	 * @throws ShippingEmailException
	 *             the shipping email exception
	 */

	/** {@inheritDoc} */
	@Override
	public void shipMail(String message) throws ShippingEmailException {

		MessageResquestBean messageResquestBean = new MessageResquestBean();

		LOG.info("Se inicia el proceso de envio de correo");

		LOG.info("El contenido del mensaje es: " + message);
		messageResquestBean.setContent(message);
		LOG.debug("El formato es: " + getMessageType().getNameId());
		messageResquestBean.setMessageType(getMessageType());
		LOG.debug("Con el contenido: " + getContent());
		messageResquestBean.setSubject(getContent());
		for (ListTypeUser campaignId : getCampaignId()) {
			LOG.info("Se envia a la siguiente campaña: " + campaignId);
			messageResquestBean.setCampaignId(campaignId.getId());
			shipMail(messageResquestBean);
		}

		LOG.info("Se finaliza el proceso de envio de correo");
	}

	/**
	 * Ship mail.
	 * 
	 * @param messageResquestBean
	 *            the message resquest bean
	 * @throws ShippingEmailException
	 *             the shipping email exception
	 */
	protected void shipMail(MessageResquestBean messageResquestBean)
			throws ShippingEmailException {
		try {
			autoSender.sendNewsletter(messageResquestBean);
		} catch (HttpException e) {
			LOG.error(e.getMessage());
			throw new ShippingEmailException(e);
		} catch (IOException e) {
			LOG.error(e.getMessage());
			throw new ShippingEmailException(e);
		} catch (ExternalAutoSenderException externalAutoSenderException) {
			if (externalAutoSenderException instanceof MissingContactException) {
				LOG.debug(new StringBuffer(" No existe usuarios en la lista: ")
						.append(messageResquestBean.getCampaignId()));
			} else {
				LOG.error(externalAutoSenderException.getMessage());
				throw new ShippingEmailException(externalAutoSenderException);
			}
		}

	}

	/**
	 * Gets the message type.
	 * 
	 * @return the message type
	 */
	protected abstract MessageType getMessageType();

	/**
	 * Gets the content.
	 * 
	 * @return the content
	 */
	protected abstract String getContent();

	/**
	 * Gets the campaign id.
	 * 
	 * @return the campaign id
	 */
	protected abstract List<ListTypeUser> getCampaignId();

}
