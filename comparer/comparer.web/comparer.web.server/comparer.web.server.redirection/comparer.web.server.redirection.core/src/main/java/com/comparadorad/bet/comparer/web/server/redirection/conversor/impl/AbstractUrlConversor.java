/**
 *
 * Copyright (C) FACTORIA ETSIA S.L.
 * All Rights Reserved.
 * www.factoriaetsia.com
 *
 */
package com.comparadorad.bet.comparer.web.server.redirection.conversor.impl;

import com.comparadorad.bet.comparer.util.commons.encrypt.EncryptUtil;
import com.comparadorad.bet.comparer.web.server.redirection.conversor.IUrlConversor;

/**
 * The Class AbstractUrlConversor.
 */
public abstract class AbstractUrlConversor implements IUrlConversor {

	/**
	 * Encripta la url para que no sea legible.
	 * 
	 * @param url
	 *            the url
	 * @return the string
	 */
	protected String encryptUrl(final String url) {
		String result = "";
		result = EncryptUtil.encryptString(url);

		return result;
	}
}
