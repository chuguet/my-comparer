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
 * The Class AbstractNordicTrioDecorator.
 */
public abstract class AbstractNordicTrioDecorator extends AbstractUrlConversor {

	 /** {@inheritDoc} */
	public String makeUrl(final String url, final String idAfiliado) {
		String result = "";
		String urlFinal = new StringBuffer().append(url).append(idAfiliado).toString();

//		result = StringEscapeUtils.escapeHtml(urlFinal);
		result = encryptUrl(urlFinal);

		return result;
	}

}
