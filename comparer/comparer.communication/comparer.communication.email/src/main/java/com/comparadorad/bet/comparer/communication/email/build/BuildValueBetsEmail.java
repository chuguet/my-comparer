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

import org.springframework.stereotype.Component;

import com.comparadorad.bet.comparer.communication.email.beans.ValueBetTo;
import com.comparadorad.bet.comparer.communication.email.build.enums.TemplateEmail;
import com.comparadorad.bet.comparer.communication.email.valuebet.enums.ValueBetEmailField;

/**
 * The Class BuildValueBetsEmail.
 * 
 * @param <I>
 *            the generic type
 */
@Component
public final class BuildValueBetsEmail<I extends List<ValueBetTo>> extends
		AbstractBuildEmail<I> {

	/**
	 * Gets the template email.
	 * 
	 * @return the template email {@inheritDoc}
	 */
	@Override
	public TemplateEmail getTemplateEmail() {
		return TemplateEmail.VALUEBET;
	}

	/**
	 * Gets the parameters.
	 * 
	 * @return the parameters {@inheritDoc}
	 */
	@Override
	public Map<String, String> getParameters() {
		Map<String, String> result = new HashMap<String, String>();
		result.put(ValueBetEmailField.SUBTITLE.getNameId(), getEmailConfig()
				.getEmailSubtitle());
		result.put(ValueBetEmailField.TITLE.getNameId(), getEmailConfig()
				.getEmailTitle());
		result.put(ValueBetEmailField.CONTACT.getNameId(), getEmailConfig()
				.getEmailContact());
		return result;
	}

}
