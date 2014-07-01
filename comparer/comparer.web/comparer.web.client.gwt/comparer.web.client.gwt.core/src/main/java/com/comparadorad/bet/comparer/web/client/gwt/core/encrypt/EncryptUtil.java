/**
 *
 * Copyright (C) FACTORIA ETSIA S.L.
 * All Rights Reserved.
 * www.factoriaetsia.com
 *
 */
package com.comparadorad.bet.comparer.web.client.gwt.core.encrypt;

/**
 * The Class EncryptUtilTest.
 */
public class EncryptUtil {

	/** The patron busqueda. */
	private static String searchPattern = "9f0AwB7J8CpDud5E6FQGlxnHMbcI3K4LeUNzO1ms2PtRvSVkWXqirTYaghZjoy";

	/** The patron encripta. */
	private static String encryptPattern = "wxBU7nIGj9Flm8f0AH1bcK3hdi4WJ5ZLCpDeMvTQuVkXqraYE6gosyNzOP2RSt";

	/**
	 * Encriptar cadena.
	 * 
	 * @param cadena
	 *            the cadena
	 * @return the string
	 */
	public static String encryptString(final String cadena) {
		String resultado = "";
		for (int pos = 0; pos < cadena.length(); pos++) {
			if (pos == 0) {
				resultado = encryptChar(cadena.substring(pos, pos + 1),
						cadena.length(), pos);
			} else {
				resultado += encryptChar(cadena.substring(pos, pos + 1),
						cadena.length(), pos);
			}
		}
		return resultado;
	}

	/**
	 * Desencripta cadena.
	 * 
	 * @param cadena
	 *            the cadena
	 * @return the string
	 */
	public static String desencryptString(final String cadena) {
		String original = "";
		for (int pos = 0; pos < cadena.length(); pos++) {
			if (pos == 0) {
				original = desencryptChar(cadena.substring(pos, pos + 1),
						cadena.length(), pos);
			} else {
				original += desencryptChar(cadena.substring(pos, pos + 1),
						cadena.length(), pos);
			}
		}
		return original;
	}

	/**
	 * Encriptar caracter.
	 * 
	 * @param caracter
	 *            the caracter
	 * @param variable
	 *            the variable
	 * @param indice
	 *            the indice
	 * @return the string
	 */
	private static String encryptChar(String caracter, int variable, int indice) {
		int ind;
		if (searchPattern.indexOf(caracter) != -1) {
			ind = (searchPattern.indexOf(caracter) + variable + indice)
					% searchPattern.length();
			return encryptPattern.substring(ind, ind + 1);
		}
		return caracter;
	}

	/**
	 * Desencripta caracter.
	 * 
	 * @param caracter
	 *            the caracter
	 * @param variable
	 *            the variable
	 * @param indice
	 *            the indice
	 * @return the string
	 */
	private static String desencryptChar(String caracter, int variable, int indice) {
		int ind = 0;
		if (encryptPattern.indexOf(caracter) != -1) {
			if ((encryptPattern.indexOf(caracter) - variable - indice) > 0) {
				ind = (encryptPattern.indexOf(caracter) - variable - indice)
						% encryptPattern.length();
			} else {
				ind = (searchPattern.length())
						+ ((encryptPattern.indexOf(caracter) - variable - indice) % encryptPattern
								.length());
			}
			ind = ind % encryptPattern.length();
			return searchPattern.substring(ind, ind + 1);
		} else {
			return caracter;
		}
	}

}
