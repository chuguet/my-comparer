/**
 *
 * Copyright (C) FACTORIA ETSIA S.L.
 * All Rights Reserved.
 * www.factoriaetsia.com
 *
 */
package com.comparadorad.bet.comparer.web.server.redirection.conversor.impl;

import org.apache.commons.lang.StringEscapeUtils;

/**
 * The Class AbstractBetonlineDecorator.
 */
public abstract class AbstractBetonlineDecorator extends AbstractUrlConversor {

	/**
	 * Make url.
	 * 
	 * @param url
	 *            the url
	 * @param idAfiliado
	 *            the id afiliado
	 * @return the string {@inheritDoc}
	 */
	@Override
	public String makeUrl(String url, String idAfiliado) {
		String result = "";
		// Redirigimos
		String urlFinal = new StringBuffer().append(url).append("?btag=")
				.append(idAfiliado).toString();
//		result = StringEscapeUtils.escapeHtml(urlFinal);
		result = encryptUrl(urlFinal);
		return result;
	}

}
