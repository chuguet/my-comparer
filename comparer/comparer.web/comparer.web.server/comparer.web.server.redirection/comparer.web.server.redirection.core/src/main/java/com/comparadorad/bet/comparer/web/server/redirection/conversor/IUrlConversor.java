/**
 *
 * Copyright (C) FACTORIA ETSIA S.L.
 * All Rights Reserved.
 * www.factoriaetsia.com
 *
 */
package com.comparadorad.bet.comparer.web.server.redirection.conversor;

/**
 * The Interface IUrlConversor.
 */
public interface IUrlConversor {

	/**
	 * Make url.
	 * 
	 * @param url
	 *            the url
	 * @param idAfiliado
	 *            the id afiliado
	 * @return the string
	 */
	String makeUrl(final String url, final String idAfiliado);

	/**
	 * Gets the id.
	 * 
	 * @return the id of the bookmaker
	 */
	String getId();

}
