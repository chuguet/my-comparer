/**
 *
 * Copyright (C) FACTORIA ETSIA S.L.
 * All Rights Reserved.
 * www.factoriaetsia.com
 *
 */
package com.comparadorad.bet.comparer.communication.email.build;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Component;

import com.comparadorad.bet.comparer.communication.email.beans.SureBetTo;
import com.comparadorad.bet.comparer.communication.email.build.enums.TemplateEmail;
import com.comparadorad.bet.comparer.communication.email.exception.BuildEmailException;
import com.comparadorad.bet.comparer.communication.email.valuebet.enums.SureBetEmailField;

/**
 * The Class BuildSureBetsEmail.
 * 
 * @param <I>
 *            the generic type
 */
@Component
public final class BuildSureBetsEmail<I extends List<SureBetTo>> extends
		AbstractBuildEmail<I> {

	/** The Constant LOG. */
	private static final Log LOG = LogFactory.getLog(BuildSureBetsEmail.class);

	/** The parameters. */
	private Map<String, String> parameters;

	{
		parameters = new HashMap<String, String>();
	}

	/** {@inheritDoc} */
	public String makeMail(final I i) throws BuildEmailException {
		String benefit = String.valueOf(i.get(0).getBenefit());

		parameters.put(SureBetEmailField.BENEFIT.getNameId(),
				String.valueOf(i.get(0).getBenefit()));

		LOG.info(new StringBuffer("Se añade como paremtro el beneficio: ")
				.append(benefit));
		
		parameters.put(SureBetEmailField.SUBTITLE.getNameId(), getEmailConfig()
				.getEmailSubtitle());
		
		LOG.info(new StringBuffer(
				"Se añade como paremtro el subtitulo del email: ")
				.append(getEmailConfig().getEmailSubtitle()));
		
		parameters.put(SureBetEmailField.TITLE.getNameId(), getEmailConfig()
				.getEmailTitle());
		
		LOG.info(new StringBuffer(
				"Se añade como paremtro el titulo del email: ")
				.append(getEmailConfig().getEmailTitle()));
		
		parameters.put(SureBetEmailField.CONTACT.getNameId(), getEmailConfig()
				.getEmailContact());
		
		LOG.info(new StringBuffer(
				"Se añade como paremtro el contacto: ")
				.append(getEmailConfig().getEmailContact()));
		
		parameters.put(SureBetEmailField.BASEURL.getNameId(), getEmailConfig()
				.getSurebetLandingPage());
		
		LOG.info(new StringBuffer(
				"Se añade como parametro el landing page: ")
				.append(getEmailConfig().getSurebetLandingPage()));

		return super.makeMail(i);
	}

	/** {@inheritDoc} */
	@Override
	protected TemplateEmail getTemplateEmail() {
		return TemplateEmail.SUREBET;
	}

	/** {@inheritDoc} */
	@Override
	protected Map<String, String> getParameters() {
		return parameters;
	}

}
