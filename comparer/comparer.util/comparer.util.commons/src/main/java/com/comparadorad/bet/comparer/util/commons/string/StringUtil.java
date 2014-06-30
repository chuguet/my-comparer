/**
 *
 * Copyright (C) FACTORIA ETSIA S.L.
 * All Rights Reserved.
 * www.factoriaetsia.com
 *
 */
package com.comparadorad.bet.comparer.util.commons.string;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.springframework.stereotype.Service;

/**
 * The Class StringUtil.
 */
@Service
public class StringUtil {

	/**
	 * Delete parenthesis.
	 * 
	 * @param cadena
	 *            the cadena
	 * @return the string
	 */
	public String deleteParenthesis(final String cadena) {
		String resultado = cadena;

		String patronBusqueda = "[\\(\\)]";

		Pattern patron = Pattern.compile(patronBusqueda);
		Matcher matcher = patron.matcher(resultado);

		resultado = matcher.replaceAll("");

		return resultado;
	}

	/**
	 * Delete numbers.
	 * 
	 * @param cadena
	 *            the cadena
	 * @return the string
	 */
	public String deleteNumbers(final String cadena) {
		String result = cadena;

		// Marco el patron a buscar, todos los numeros
		final String patronABuscar = "[0-9]+";// Un numero o mas

		Pattern patron = Pattern.compile(patronABuscar);
		Matcher matcher = patron.matcher(result);

		// Elimino los numeros.
		result = matcher.replaceAll("");
		// Elimino espacios en blanco al final innecesarios.
		result = result.trim();

		return result;
	}

	/**
	 * Delete negatives.
	 * 
	 * @param cadena
	 *            the cadena
	 * @return the string
	 */
	public String deleteNegatives(final String cadena) {
		String result = cadena;
		// Marco el patron a buscar, todos los numeros
		final String patronABuscar = "-";// Un numero o mas
		Pattern patron = Pattern.compile(patronABuscar);
		Matcher matcher = patron.matcher(result);
		// Elimino los numeros.
		result = matcher.replaceAll("");
		// Elimino espacios en blanco al final innecesarios.
		result = result.trim();

		return result;
	}

	/**
	 * Delete character.
	 * 
	 * @param cadena
	 *            the cadena
	 * @param character
	 *            the character
	 * @return the string
	 */
	public String deleteCharacter(final String cadena, final String character) {
		String result = cadena;

		final String patronABuscar = new StringBuffer().append("[")
				.append(character).append("]").toString();
		Pattern patron = Pattern.compile(patronABuscar);
		Matcher matcher = patron.matcher(result);

		result = matcher.replaceAll("");

		return result;
	}

	/**
	 * Replace character.
	 * 
	 * @param cadena
	 *            the cadena
	 * @param character
	 *            the character
	 * @param replacementCharacter
	 *            the replacement character
	 * @return the string
	 */
	public String replaceCharacter(final String cadena, final String character,
			final String replacementCharacter) {
		String result = cadena;

		final String patronABuscar = new StringBuffer().append("[")
				.append(character).append("]").toString();
		Pattern patron = Pattern.compile(patronABuscar);
		Matcher matcher = patron.matcher(result);

		result = matcher.replaceAll(replacementCharacter);

		return result;
	}
	
	/**
	 * FunciÛn que elimina acentos y caracteres especiales de
	 * una cadena de texto.
	 * @param cadena
	 * @return cadena de texto limpia de acentos y caracteres especiales.
	 */
	public String removeSpecialCharacters(final String cadena) {
	    // Cadena de caracteres original a sustituir.
	    String original = "·‡‰ÈËÎÌÏÔÛÚˆ˙˘¸Ò¡¿ƒ…»ÀÕÃœ”“÷⁄Ÿ‹—Á«";
	    // Cadena de caracteres ASCII que reemplazar·n los originales.
	    String ascii = "aaaeeeiiiooouuunAAAEEEIIIOOOUUUNcC";
	    String output = cadena;
	    for (int i=0; i<original.length(); i++) {
	        // Reemplazamos los caracteres especiales.
	        output = output.replace(original.charAt(i), ascii.charAt(i));
	    }
	    return output;
	}
	
	/**
	 * FunciÛn que toma como entrada un string y le suma o le resta un valor
	 * @param cadena
	 * @param valor a sumar o restar
	 * @param suma, boleano para saber si lo sumamos o restamos
	 * @return cadena de texto sumada o restada.
	 */
	public String modifyStringValue(final String cadena, final Double valor, final Boolean suma) {

		// Cadena de caracteres original pasada a double para poder operar
	    Double cadenaModificada = Double.parseDouble(cadena);
	    
	    // Comprobamos el boolean para saber si tenemos que sumar o restar el valor
	    if (suma) {	    	
	    	cadenaModificada = cadenaModificada + valor;
	    } else {
	    	cadenaModificada = cadenaModificada - valor;
	    }
	    
	    // Devolvemos el resultado como una cadena
	    String output = new Double(cadenaModificada).toString();
	    
	    return output;
	}
	


}
