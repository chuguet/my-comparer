package com.comparadorad.bet.comparer.web.server.redirection.conversor.impl;

import org.apache.commons.lang.StringEscapeUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public abstract class AbstractSportingBetCentreBetMiapuestaDecorator extends
		AbstractUrlConversor {
	
	/** The Constant LOG. */
	private static final Log LOG = LogFactory
			.getLog(AbstractSportingBetCentreBetMiapuestaDecorator.class);

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.comparadorad.bet.comparer.web.server.redirection.conversor.IUrlConversor
	 * #makeUrl(java.lang.String, java.lang.String)
	 */
	public String makeUrl(final String url, final String idAfiliado) {
		String result = "";
		// Redirigimos
		String urlFinal = new StringBuffer().append(url).append("?idAfiliado=")
				.append(idAfiliado).toString();

//		result = StringEscapeUtils.escapeHtml(urlFinal);
		result = encryptUrl(urlFinal);

		return result;
	}

}
