/**
 *
 * Copyright (C) FACTORIA ETSIA S.L.
 * All Rights Reserved.
 * www.factoriaetsia.com
 *
 */
package com.comparadorad.bet.comparer.web.server.redirection.conversor.impl;

import java.math.BigInteger;

import org.apache.commons.lang.StringEscapeUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Component;

import com.comparadorad.bet.comparer.model.config.bean.CfgBookmaker.CfgBookmakerId;

/**
 * The Class UrlBetAtHometConversor.
 */
@Component
public class UrlBetAtHometConversor extends AbstractUrlConversor {

	/** The Constant LOG. */
	private static final Log LOG = LogFactory.getLog(UrlBetClickConversor.class);

	/** {@inheritDoc} */
	public String makeUrl(final String url, final String idAfiliado) {
		String result = "";
		// Redirigimos
		String urlFinal = new StringBuffer().append(url).append("?btag=").append(idAfiliado).toString();

//		result = StringEscapeUtils.escapeHtml(urlFinal);
		result = encryptUrl(urlFinal);

		return result;
	}

	/** {@inheritDoc} */
	public String getId() {
		String result = "";
		BigInteger id = CfgBookmakerId.BET_AT_HOME_COM_ID.objectId();
		result = id.toString();
		return result;
	}

}
