/**
 *
 * Copyright (C) FACTORIA ETSIA S.L.
 * All Rights Reserved.
 * www.factoriaetsia.com
 *
 */
package com.comparadorad.bet.comparer.web.server.redirection.factory;

import com.comparadorad.bet.comparer.web.server.redirection.conversor.IUrlConversor;

public interface IUrlFactory {

	/**
	 * Make url conversor.
	 * 
	 * @param id
	 *            the id
	 * @return the i url conversor
	 */
	IUrlConversor makeUrlConversor(final String id);
}
