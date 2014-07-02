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
import org.springframework.stereotype.Component;

import com.comparadorad.bet.comparer.model.config.bean.CfgBookmaker.CfgBookmakerId;

/**
 * The Class UrlBetClickConversor.
 */
@Component
public class UrlBwinConversor extends AbstractUrlConversor {

	/** {@inheritDoc} */
	public String makeUrl(final String url, final String idAfiliado) {
		String result = "";

		String urlFinal = new StringBuffer().append(url).append("?wm=").toString();

//		result = StringEscapeUtils.escapeHtml(urlFinal);
		result = encryptUrl(urlFinal);

		return result;
	}

	/** {@inheritDoc} */
	public String getId() {
		String result = "";
		BigInteger id = CfgBookmakerId.BWIN_COM_ID.objectId();
		result = id.toString();
		return result;
	}

}
