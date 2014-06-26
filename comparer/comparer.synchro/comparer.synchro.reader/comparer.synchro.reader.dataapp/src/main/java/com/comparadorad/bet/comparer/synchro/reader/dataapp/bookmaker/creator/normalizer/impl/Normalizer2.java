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

import javax.inject.Inject;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Component;

import com.comparadorad.bet.comparer.util.commons.string.StringUtil;

@Component(value = "Normalizer2")
public class Normalizer2 extends AbstractNormalizerImpl {

	/** The Constant LOG. */
	private static final Log LOG = LogFactory.getLog(Normalizer2.class);

	@Inject
	private StringUtil stringUtil;

	@Override
	protected List<String> normalizar(List<String> listaANormalizar) {
		List<String> result = new ArrayList<String>(listaANormalizar);

		LOG.debug("Inicio normalizacion caracteres especiales");
		result = normalizacionCaracteresEspeciales(result);
		LOG.debug("Fin normalizacion caracteres especiales");

		LOG.debug("Inicio normalizacion palabras dobles");
		result = normalizacionPalabrasDobles(result);
		LOG.debug("Fin normalizacion palabras dobles");

		// LOG.debug("Inicio normalizacion mayusculas");
		// result = normalizacionMayusculasMinusculas(result);
		// LOG.debug("Fin normalizacion mayusculas");

		return result;
	}

	/**
	 * Elimina acentos y eñes.
	 * 
	 * @param lista
	 *            de palabras a normalizar
	 * @return lista de palabras normalizadas
	 */
	private List<String> normalizacionCaracteresEspeciales(final List<String> lista) {
		List<String> listaPalabrasEspeciales = new ArrayList<String>(lista);
		for (String palabra : lista) {
			// Sustituimos la ñ por una n
			// String sinEnie = stringUtil.replaceCharacter(palabra, "ñ", "n");
			// if (!palabra.equals(sinEnie)) {
			// listaPalabrasEspeciales.add(sinEnie);
			// }
			// Eliminamos Caracteres Especiales
			String sinAcentos = stringUtil.removeSpecialCharacters(palabra);
			if (!palabra.equals(sinAcentos)) {
				listaPalabrasEspeciales.add(sinAcentos);
			}
		}
		return listaPalabrasEspeciales;
	}

	/**
	 * En palabras de dos letras las da la vuelta para poder tener por ejemplo
	 * Rafa Nadal y Nadal Rafa.
	 * 
	 * @param lista
	 *            de palabras a normalizar
	 * @return lista de palabras normalizadas
	 */
	private List<String> normalizacionPalabrasDobles(final List<String> lista) {
		List<String> listaPalabrasDobles = new ArrayList<String>(lista);

		for (String palabra : lista) {
			if (LOG.isDebugEnabled()) {
				LOG.debug("Dividimos la palabra " + palabra + " en dos mitades para ver si podemos darlas la vuelta");
			}
			String[] dividida = palabra.split(" ");
			if (dividida.length == 2) {
				String palabraGirada = new StringBuffer().append(dividida[1]).append(" ").append(dividida[0]).toString();
				listaPalabrasDobles.add(palabraGirada);
			}
		}

		return listaPalabrasDobles;
	}

	// private List<String> normalizacionMayusculasMinusculas(
	// final List<String> lista) {
	// List<String> listaMayusculas = new ArrayList<String>(lista);
	//
	// for (String palabra : lista) {
	// listaMayusculas.add(palabra.toUpperCase());
	// listaMayusculas.add(palabra.toLowerCase());
	// }
	//
	// return listaMayusculas;
	// }

}
