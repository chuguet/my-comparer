package com.comparadorad.bet.comparer.web.server.redirection.conversor.impl;

import org.apache.commons.lang.StringEscapeUtils;

public abstract class AbstractYouWinUWinDecoratorConversor extends
		AbstractUrlConversor {

	public String makeUrl(final String url, final String idAfiliado) {
		String result = "";
		String urlFinal = new StringBuffer().append(url).append("?pid=")
				.append(idAfiliado).toString();

//		result = StringEscapeUtils.escapeHtml(urlFinal);
		result = encryptUrl(urlFinal);

		return result;
	}

}
