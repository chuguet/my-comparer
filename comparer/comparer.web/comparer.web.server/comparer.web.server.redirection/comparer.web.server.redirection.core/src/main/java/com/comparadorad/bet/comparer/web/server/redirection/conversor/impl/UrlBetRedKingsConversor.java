package com.comparadorad.bet.comparer.web.server.redirection.conversor.impl;

import java.math.BigInteger;

import org.apache.commons.lang.StringEscapeUtils;
import org.springframework.stereotype.Component;

import com.comparadorad.bet.comparer.model.config.bean.CfgBookmaker.CfgBookmakerId;

@Component
public class UrlBetRedKingsConversor extends AbstractUrlConversor {

	/** {@inheritDoc} */
	public String makeUrl(final String url, final String idAfiliado) {
		String result = "";
		// Redirigimos
		String urlFinal = new StringBuffer().append(url).append("?aname=").append(idAfiliado).append("&cg=spanish").toString();

//		result = StringEscapeUtils.escapeHtml(urlFinal);
		result = encryptUrl(urlFinal);

		return result;
	}


	@Override
	public String getId() {
		String result = "";
		BigInteger id = CfgBookmakerId.BETREDKINGS_ID.objectId();
		result = id.toString();
		return result;
	}

}
