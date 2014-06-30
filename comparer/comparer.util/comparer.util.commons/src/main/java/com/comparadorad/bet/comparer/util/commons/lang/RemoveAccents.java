/**
 *
 * Copyright (C) FACTORIA ETSIA S.L.
 * All Rights Reserved.
 * www.factoriaetsia.com
 *
 */
package com.comparadorad.bet.comparer.util.commons.lang;

import java.text.Normalizer;
import java.util.regex.Pattern;

/**
 * The Class RemoveAccents.
 */
public class RemoveAccents {

	/**
	 * Instantiates a new removes the accents.
	 */
	private RemoveAccents() {

	}

	/**
	 * Función que elimina acentos y caracteres especiales de una cadena de
	 * texto.
	 * 
	 * @param input
	 *            the input
	 * @return cadena de texto limpia de acentos y caracteres especiales.
	 */
	public static String normalizeString(String input) {
		// Descomposición canónica
		String normalized = Normalizer.normalize(input, Normalizer.Form.NFD);
		// Nos quedamos icamente con los caracteres ASCII
		Pattern pattern = Pattern.compile("\\P{ASCII}");
		return pattern.matcher(normalized).replaceAll("");
	}// remove2
}
