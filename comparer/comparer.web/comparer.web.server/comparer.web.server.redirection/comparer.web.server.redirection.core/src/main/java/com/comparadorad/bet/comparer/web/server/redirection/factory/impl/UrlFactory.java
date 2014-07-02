/**
 *
 * Copyright (C) FACTORIA ETSIA S.L.
 * All Rights Reserved.
 * www.factoriaetsia.com
 *
 */
package com.comparadorad.bet.comparer.web.server.redirection.factory.impl;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Component;

import com.comparadorad.bet.comparer.web.server.redirection.conversor.IUrlConversor;

/**
 * A factory for creating Url objects.
 */
@Component
public class UrlFactory extends AbstractUrlFactory {

	/** The url conversors. */
	@Inject
	List<IUrlConversor> urlConversors;

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.comparadorad.bet.comparer.web.server.redirection.factory.IUrlFactory
	 * #makeUrlConversor(java.lang.String)
	 */
	public IUrlConversor makeUrlConversor(final String id) {
		IUrlConversor result = null;
		for (IUrlConversor conversor : urlConversors) {
			if (conversor.getId().equals(id)) {
				result = conversor;
			}
		}
		return result;
	}

}
