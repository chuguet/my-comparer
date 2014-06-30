/**
 *
 * Copyright (C) FACTORIA ETSIA S.L.
 * All Rights Reserved.
 * www.factoriaetsia.com
 *
 */
package com.comparadorad.bet.comparer.synchro.reader.readerbookmaker.core.util;

import java.text.Normalizer;

import org.apache.commons.lang.StringEscapeUtils;

/**
 * The Class StringFormatterUtil.
 */
public class StringFormatterUtil {

	/** The Constant arrayModifiers. */
	private final static String[] arrayModifiers = { "<span>", "</span>",
			"<BR/>", "<BR>", "\"" };

	/**
	 * Normalize reader string.
	 * 
	 * @param notNormalizedString
	 *            the not normalized string
	 * @return the string
	 */
	public static String normalizeReaderString(final String notNormalizedString) {
		String result = "";

		if (notNormalizedString != null) {
			result = deleteTabs(notNormalizedString);
			result = deleteHtmlWords(result);
			result = deleteHtmlSpecialChars(result);
			result = deleteNonAsciiChars(result);
		}

		return result;
	}

	/**
	 * Delete tabs.
	 * 
	 * @param cadena
	 *            the cadena
	 * @return the string
	 */
	private static String deleteTabs(final String cadena) {
		String result = cadena;

		result = result.replaceAll("\\t", " ");
		result = result.replaceAll("\\n", " ");
		return result;

	}

	/**
	 * Delete html words.
	 * 
	 * @param cadena
	 *            the cadena
	 * @return the string
	 */
	private static String deleteHtmlWords(final String cadena) {
		String result = cadena;

		if (result.contains("<BR/>")) {
			int posicion = result.indexOf("<");
			result = result.substring(0, posicion);
		}

		for (String modificador : arrayModifiers) {
			result = result.replaceAll(modificador, " ");
		}

		return result;
	}

	/**
	 * Delete html special chars.
	 * 
	 * @param cadena
	 *            the cadena
	 * @return the string
	 */
	private static String deleteHtmlSpecialChars(final String cadena) {
		String result = cadena;

		result = StringEscapeUtils.unescapeHtml(result);

		return result;
	}

	/**
	 * Delete non ascii chars.
	 * 
	 * @param cadena
	 *            the cadena
	 * @return the string
	 */
	private static String deleteNonAsciiChars(final String cadena) {
		String result;
		result = Normalizer.normalize(cadena, Normalizer.Form.NFD);
		result = result.replaceAll("\\p{InCombiningDiacriticalMarks}+", "");
		result = result.trim();
		return result;
	}

}
