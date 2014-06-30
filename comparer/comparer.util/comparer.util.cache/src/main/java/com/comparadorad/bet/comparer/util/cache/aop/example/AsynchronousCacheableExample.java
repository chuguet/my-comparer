/**
 *
 * Copyright (C) FACTORIA ETSIA S.L.
 * All Rights Reserved.
 * www.factoriaetsia.com
 *
 */
package com.comparadorad.bet.comparer.util.cache.aop.example;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Service;

import com.comparadorad.bet.comparer.util.cache.CacheRegion;
import com.comparadorad.bet.comparer.util.cache.aop.AsynchronousCacheable;

/**
 * The Class AsynchronousCacheableExample.
 */
@Service
public class AsynchronousCacheableExample implements
		IAsynchronousCacheableExample {
	
	/** The Constant LOG. */
	private static final Log LOG = LogFactory
			.getLog(AsynchronousCacheableExample.class);

	
	/* (non-Javadoc)
	 * @see com.comparadorad.bet.comparer.util.cache.aop.example.IAsynchronousCacheableExample#execute(java.lang.String)
	 */
	@Override
	@AsynchronousCacheable(CacheRegion.BETODDS_COMPETITIONEVENTCONTROLLER)
	public String execute(final String string) {
		LOG.info("Se inicia el metodo con un parametro");
		StringBuffer buffer = new StringBuffer("Se devuelve desde el metodo: ").append(string);
		try {
			Thread.sleep(500);
		} catch (InterruptedException e) {
			LOG.error(e.getMessage());
		}
		LOG.info("Se finaliza el metodo con un parametro");
		return buffer.toString();

	}



	/* (non-Javadoc)
	 * @see com.comparadorad.bet.comparer.util.cache.aop.example.IAsynchronousCacheableExample#executeTwo(java.lang.String, java.lang.String)
	 */
	@Override
	@AsynchronousCacheable(CacheRegion.BETODDS_COMPETITIONEVENTCONTROLLER)
	public String executeTwo(final String string1, final String string2) {
		LOG.info("Se inicia el metodo con varios parametros");
		StringBuffer buffer = new StringBuffer("Se devuelve desde el metodo: ").append(string1).append(" y ").append(string2);
		try {
			Thread.sleep(500);
		} catch (InterruptedException e) {
			LOG.error(e.getMessage());
		}
		LOG.info("Se finaliza el metodo con varios parametros");
		return buffer.toString();
	}


	

	


}
