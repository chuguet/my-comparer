/**
 *
 * Copyright (C) FACTORIA ETSIA S.L.
 * All Rights Reserved.
 * www.factoriaetsia.com
 *
 */
package com.comparadorad.bet.comparer.synchro.reader.dataapp.bookmaker.creator.normalizer.impl;

import java.util.ArrayList;
import java.util.List;

import com.comparadorad.bet.comparer.synchro.reader.dataapp.bookmaker.creator.normalizer.INormalizer;

/**
 * The Class AbstractNormalizerImpl.
 * 
 * @param <T>
 *            the generic type
 */
public abstract class AbstractNormalizerImpl implements INormalizer {

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.comparadorad.bet.comparer.synchro.reader.dataapp.bookmaker.creator
	 * .normalizer.INormalizer#normalize(java.util.List)
	 */
	public List<String> normalize(List<String> listaANormalizar) {
		List<String> result = new ArrayList<String>();

		result = normalizar(listaANormalizar);

		return result;
	}

	/**
	 * Normalizar.
	 * 
	 * @param listaANormalizar
	 *            the lista a normalizar
	 * @return the list
	 */
	protected abstract List<String> normalizar(List<String> listaANormalizar);

}
