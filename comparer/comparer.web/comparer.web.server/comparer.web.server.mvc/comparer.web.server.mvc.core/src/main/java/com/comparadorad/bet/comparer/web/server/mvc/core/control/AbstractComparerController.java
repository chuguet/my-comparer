/**
 *
 * Copyright (C) FACTORIA ETSIA S.L.
 * All Rights Reserved.
 * www.factoriaetsia.com
 *
 */
package com.comparadorad.bet.comparer.web.server.mvc.core.control;

import javax.inject.Inject;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.comparadorad.bet.comparer.util.commons.encrypt.EncryptUtil;
import com.comparadorad.bet.comparer.web.server.redirection.conversor.IUrlConversor;
import com.comparadorad.bet.comparer.web.server.redirection.factory.IUrlFactory;

/**
 * The Class AbstractController.
 */
public abstract class AbstractComparerController {

	/** The Constant LOG. */
	private static final Log LOG = LogFactory
			.getLog(AbstractComparerController.class);

	@Inject
	private IUrlFactory factoriaUrl;
	
	/** The NUMBE r_ digit s_ be t_ format. */
	protected static int NUMBER_DIGITS_BET_FORMAT = 2;

	/**
	 * Gets the user data.
	 * 
	 * @return the user data
	 */
	public void getUserData() {

	}

	/**
	 * Gets the external link to.
	 * 
	 * @param idBookmaker
	 *            the id bookmaker
	 * @param url
	 *            the url
	 * @return the external link to
	 */
	protected String getExternalLinkTo(final String idBookmaker,
			final String url, final String idAfiliado) {
		String result = "";
		// Llamamos a la factoria para recuperar el conversor y con este la
		// url a redirigir
		LOG.debug("Llamamos a la factoria para recuperar el conversor y la url definitiva");
		IUrlConversor conversor = factoriaUrl.makeUrlConversor(idBookmaker);
		result = conversor.makeUrl(url, idAfiliado);

		LOG.debug("Encriptamos la url recien creada");
		result = EncryptUtil.encryptString(result);

		return result;
	}

}
