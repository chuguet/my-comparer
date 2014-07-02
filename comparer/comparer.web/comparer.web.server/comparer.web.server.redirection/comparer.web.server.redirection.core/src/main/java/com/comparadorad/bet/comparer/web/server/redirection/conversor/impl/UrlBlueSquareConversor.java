package com.comparadorad.bet.comparer.web.server.redirection.conversor.impl;

import java.math.BigInteger;

import org.apache.commons.lang.StringEscapeUtils;
import org.springframework.stereotype.Component;

import com.comparadorad.bet.comparer.model.config.bean.CfgBookmaker.CfgBookmakerId;

@Component
public class UrlBlueSquareConversor extends AbstractUrlConversor {

	@Override
	public String makeUrl(String url, String idAfiliado) {
		String result = "";
		// Redirigimos
		String urlFinal = new StringBuffer().append(url).append("?idAfiliado=")
				.append(idAfiliado).toString();
//		result = StringEscapeUtils.escapeHtml(urlFinal);
		result = encryptUrl(urlFinal);
		return result;
	}

	@Override
	public String getId() {
		String result = "";
		BigInteger id = CfgBookmakerId.BLUESQUARE_COM_ID.objectId();
		result = id.toString();
		return result;
	}

}
