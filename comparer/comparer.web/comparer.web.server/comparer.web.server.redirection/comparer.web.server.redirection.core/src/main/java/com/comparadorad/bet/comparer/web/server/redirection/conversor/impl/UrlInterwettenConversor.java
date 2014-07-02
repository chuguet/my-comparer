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
 * The Class UrlInterwettenConversor.
 */
@Component
public class UrlInterwettenConversor extends AbstractUrlConversor {

	/** {@inheritDoc} */
	@Override
	public String makeUrl(String url, String idAfiliado) {
		String result = "";
		String urlFinal = new StringBuffer().append(url).append("?pid=").append(idAfiliado).toString();

//		result = StringEscapeUtils.escapeHtml(urlFinal);
		result = encryptUrl(urlFinal);

		return result;
	}

	/** {@inheritDoc} */
	@Override
	public String getId() {
		String result = "";
		BigInteger id = CfgBookmakerId.INTERWETTEN_COM_ID.objectId();
		result = id.toString();
		return result;
	}

}