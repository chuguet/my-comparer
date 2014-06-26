/**
 *
 * Copyright (C) FACTORIA ETSIA S.L.
 * All Rights Reserved.
 * www.factoriaetsia.com
 *
 */
package com.comparadorad.bet.comparer.synchro.reader.dataapp.bookmaker.creator.algorithm;

import org.springframework.stereotype.Component;

import com.comparadorad.bet.comparer.model.config.bean.CfgResolverAlgorithm;

@Component
public interface IAlgorithmResolver {
	
	/**
	 * Gets the diferences.
	 *
	 * @param wordA the word a
	 * @param wordB the word b
	 * @return the diferences
	 */
	Double getDiferences(String wordA, String wordB,
			CfgResolverAlgorithm cfgResolverAlgorithm);

}
