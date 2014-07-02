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
 * The Class UrlBetOnlineConversor.
 */
@Component
public class UrlBetOnlineConversor extends AbstractBetonlineDecorator {

	/** {@inheritDoc} */
	@Override
	public String makeUrl(String url, String idAfiliado) {
		String result = "";
		// Redirigimos
		String urlFinal = new StringBuffer().append(url).append("?btag=").append(idAfiliado).toString();
//		result = StringEscapeUtils.escapeHtml(urlFinal);
		result = encryptUrl(urlFinal);
		return result;
	}

	/**
	 * Gets the id.
	 * 
	 * @return the id {@inheritDoc}
	 */
	@Override
	public String getId() {
		String result = "";
		BigInteger id = CfgBookmakerId.BETONLINE_COM_ID.objectId();
		result = id.toString();
		return result;
	}

}
