/**
 *
 * Copyright (C) FACTORIA ETSIA S.L.
 * All Rights Reserved.
 * www.factoriaetsia.com
 *
 */
package com.comparadorad.bet.comparer.synchro.reader.dataapp.bookmaker.comparer.impl;

import java.io.UnsupportedEncodingException;
import java.text.Normalizer;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import uk.ac.shef.wit.simmetrics.similaritymetrics.AbstractStringMetric;

import com.comparadorad.bet.comparer.model.config.bean.CfgMaster;
import com.comparadorad.bet.comparer.model.config.bean.CfgResolverAlgorithm;
import com.comparadorad.bet.comparer.model.config.bean.ICfgSynonyms;
import com.comparadorad.bet.comparer.synchro.reader.dataapp.bookmaker.creator.bean.StrikeAMatchData;

/**
 * The Class DataComparerImpl.
 * 
 * @param <I>
 *            the generic type
 */
public class DataComparerImpl<I extends ICfgSynonyms> extends
		AbstractDataComparer {

	/** The Constant LOG. */
	private static final Log LOG = LogFactory.getLog(DataComparerImpl.class);

	/**
	 * Compare strings.
	 *
	 * @param cfgMaster the cfg master
	 * @param data the data
	 * {@inheritDoc}
	 * 
	 * Obtenemos los algoritmos configurados para el cfgMaster en cuestion y
	 * pasamos todos ellos Los resultados de cada uno de ellos los almacenamos
	 * en una lista para luego ver cual usamos o que combinacion de ellos.
	 */
	@Override
	public void compareStrings(final CfgMaster cfgMaster,
			final StrikeAMatchData<ICfgSynonyms> data) {
		Double summa = new Double(0);
		int sinonimo = 0;
		Double strike = new Double(0);
		double maximoStrike = 0.0;
		double algorithmValue;
		String wordA = converterASCII(deleteNonAsciiChars(data.getWordA()));
		String wordB = converterASCII(deleteNonAsciiChars(data.getWordB()));
		AbstractStringMetric metric;
		List<CfgResolverAlgorithm> algorithms = cfgMaster.getListaAlgoritmos();

		LOG.debug(new StringBuffer("Se usa el cfgMaster con id: ")
				.append(cfgMaster.getObjectId()));

		LOG.debug(new StringBuffer("La configuracion es: ").append(cfgMaster));

		LOG.debug(new StringBuffer().append("Comparamos '").append(wordA)
				.append("' con '").append(wordB).append("'"));

		for (CfgResolverAlgorithm cfgResolverAlgorithm : algorithms) {

			metric = cfgResolverAlgorithm.getAlgorithm();

			LOG.debug(metric);
			LOG.debug(new StringBuffer("Se va usar el algoritmo: ")
					.append(metric.getLongDescriptionString()));

			LOG.debug(new StringBuffer("El tiempo estimado es: ").append(metric
					.getSimilarityTimingEstimated(wordA, wordA)));

			algorithmValue = metric.getSimilarity(wordA, wordB);

			LOG.debug(new StringBuffer("El resultado de la comparacion es: ")
					.append(algorithmValue));

			summa = summa + algorithmValue;

			LOG.debug(new StringBuffer("La suma de las comparaciones es: ")
					.append(summa));

			data.setSumma(summa);

			if (algorithmValue >= cfgResolverAlgorithm.getLimit()) {
				// Añado a una lista los valores, dicha lista luego me servira
				// para comparar.
				sinonimo++;
				data.setSinonimo(sinonimo);
				maximoStrike = algorithmValue;
				if (strike == null || maximoStrike > strike) {
					strike = new Double(maximoStrike);
					data.setStrike(strike);

					LOG.debug(new StringBuffer("El mejor algoritmo es: ")
							.append(metric.getShortDescriptionString()));

					data.setBestAlgorithm(metric);
				}
				LOG.debug(new StringBuffer().append("La palabra ")
						.append(wordB).append(" es candidata de ser sinonimo.")
						.toString());
			}

		}
		if (sinonimo > 0) {
			strike = summa;
		}

	}

	/**
	 * Delete non ascii chars.
	 *
	 * @param cadena the cadena
	 * @return the string
	 */
	private String deleteNonAsciiChars(final String cadena) {
		String result;

		LOG.debug(new StringBuffer("Se procede a normalizar la cadena: ")
				.append(cadena));

		result = Normalizer.normalize(cadena, Normalizer.Form.NFD);
		result = result.replaceAll("\\p{InCombiningDiacriticalMarks}+", "");
		result = result.trim();

		LOG.debug(new StringBuffer("La cadena normalizada es: ").append(cadena));

		return result;
	}

	/**
	 * Converter ascii.
	 *
	 * @param inputString the input string
	 * @return the string
	 */
	private String converterASCII(String inputString) {
		byte ptext[] = inputString.getBytes();
		String result = "";
		try {
			result = new String(ptext, "ASCII");
		} catch (UnsupportedEncodingException e) {
			LOG.error(new StringBuffer("No se puede convertir la cadena: ")
					.append(inputString).append(" a ASCII")
					.append(" Se devuelve una cadena vacia"));
		}
		return result;
	}

}
