/**
 *
 * Copyright (C) FACTORIA ETSIA S.L.
 * All Rights Reserved.
 * www.factoriaetsia.com
 *
 */
package com.comparadorad.bet.comparer.model.config.bean;

import com.comparadorad.bet.comparer.model.core.bean.IDocumentField;

/**
 * The Interface ICfgSynonymWord.
 */
public interface ICfgSynonymWord extends IDocumentField {

	/**
	 * Gets the word.
	 * 
	 * @return the word
	 */
	String getWord();

	/**
	 * Sets the word.
	 * 
	 * @param pWord
	 *            the new word
	 */
	void setWord(final String pWord);
}
