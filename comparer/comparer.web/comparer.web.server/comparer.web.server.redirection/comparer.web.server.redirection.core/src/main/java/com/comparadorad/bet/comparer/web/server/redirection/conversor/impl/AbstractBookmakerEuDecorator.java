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
 * The Class AbstractBookmakerEuDecorator.
 */
public abstract class AbstractBookmakerEuDecorator extends AbstractUrlConversor {

	 /** {@inheritDoc} */
	@Override
	public String makeUrl(String url, String idAfiliado) {
		String result = "";
		String urlFinal = new StringBuffer().append(url).append("?cmpid=")
				.append(idAfiliado).toString();
//		result = StringEscapeUtils.escapeHtml(urlFinal);
		result = encryptUrl(urlFinal);
		return result;
	}
	
}
