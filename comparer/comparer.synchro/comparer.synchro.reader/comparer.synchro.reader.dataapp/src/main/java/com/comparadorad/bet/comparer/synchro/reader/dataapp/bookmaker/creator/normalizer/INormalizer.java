/**
 *
 * Copyright (C) FACTORIA ETSIA S.L.
 * All Rights Reserved.
 * www.factoriaetsia.com
 *
 */
package com.comparadorad.bet.comparer.synchro.reader.dataapp.bookmaker.creator.normalizer;

import java.util.List;

import com.comparadorad.bet.comparer.model.config.bean.ICfgSynonyms;

/**
 * The Interface INormalizer.
 *
 * @param <T> the generic type
 */
public interface INormalizer{
	
	/**
	 * Normalize.
	 *
	 * @param listaNormalizada the lista normalizada
	 * @return the list
	 */
	List<String> normalize (List<String> listaNormalizada);

}
