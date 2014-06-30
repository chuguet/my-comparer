/**
 *
 * Copyright (C) FACTORIA ETSIA S.L.
 * All Rights Reserved.
 * www.factoriaetsia.com
 *
 */
package com.comparadorad.bet.comparer.util.commons.lang;

/**
 * The Class TokenWordUtil.
 */
public class TokenWordUtil {

	/**
	 * Creates the tokens.
	 * 
	 * @param phrase
	 *            the phrase
	 * @return the string[]
	 */
	public static String[] createTokens(String phrase) {
		String[] tokens = phrase.split("[' '',''\\-']");
		for (int i = 0; i < tokens.length; i++) {
			tokens[i] = RemoveAccents.normalizeString(tokens[i].toLowerCase());
		}
		return tokens;
	}
}
