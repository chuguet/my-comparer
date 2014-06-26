/**
 *
 * Copyright (C) FACTORIA ETSIA S.L.
 * All Rights Reserved.
 * www.factoriaetsia.com
 *
 */
package com.comparadorad.bet.comparer.synchro.reader.process.xml.resolver.longTerm;

import org.springframework.stereotype.Component;

import com.comparadorad.bet.comparer.model.config.bean.LongTerm;

/**
 * The Class LongTermResolver.
 */
@Component
class LongTermResolver extends AbstractLongTermResolver {
	
	/** The long term. */
	private LongTerm longTerm;
	
	
	
	/**
	 * Instantiates a new long term resolver.
	 */
	public LongTermResolver() {
		super();
	}



	@Override
	protected LongTerm resolver(boolean pLongTerm) {
		longTerm = new LongTerm();
		longTerm.setLongTerm(Boolean.valueOf(pLongTerm));
		
		return longTerm;
	}

}
