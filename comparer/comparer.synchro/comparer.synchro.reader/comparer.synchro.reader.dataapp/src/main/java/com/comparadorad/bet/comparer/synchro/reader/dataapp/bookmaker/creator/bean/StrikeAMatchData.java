/**
 *
 * Copyright (C) FACTORIA ETSIA S.L.
 * All Rights Reserved.
 * www.factoriaetsia.com
 *
 */
package com.comparadorad.bet.comparer.synchro.reader.dataapp.bookmaker.creator.bean;

import java.util.List;

import uk.ac.shef.wit.simmetrics.similaritymetrics.AbstractStringMetric;

import com.comparadorad.bet.comparer.model.config.bean.AbstractCfgSynonymWord;
import com.comparadorad.bet.comparer.model.config.bean.CfgMaster;
import com.comparadorad.bet.comparer.model.config.bean.CfgResolverAlgorithm;
import com.comparadorad.bet.comparer.model.config.bean.ICfgSynonyms;

/**
 * The Class StrikeAMatchData.
 * 
 * @param <I>
 *            the generic type
 */
public class StrikeAMatchData<I extends ICfgSynonyms> implements
		Comparable<StrikeAMatchData<I>> {

//	/** The Constant LOG. */
//	private static final LOG = LogFactory.getLog(StrikeAMatchData.class);
//	
	/** The strike. */
	private Double strike;

	/** The summa. */
	private Double summa;

	/** The sinonimo. */
	private int sinonimo;

	/**
	 * Gets the sinonimo.
	 * 
	 * @return the sinonimo
	 */
	public int getSinonimo() {
		return sinonimo;
	}

	/**
	 * Sets the sinonimo.
	 * 
	 * @param sinonimo
	 *            the sinonimo
	 */
	public void setSinonimo(int sinonimo) {
		this.sinonimo = sinonimo;
	}

	/**
	 * Gets the summa.
	 * 
	 * @return the summa
	 */
	public double getSumma() {
		return summa;
	}

	/**
	 * Sets the summa.
	 * 
	 * @param summa
	 *            the summa
	 */
	public void setSumma(double summa) {
		this.summa = summa;
	}

	/** The synonyms. */
	private I synonyms = null;

	/** The synonym word. */
	private AbstractCfgSynonymWord synonymWord;

	/** The word a. */
	private String wordA;

	/** The word b. */
	private final String wordB;

	/** The algorithm. */
	private AbstractStringMetric bestAlgorithm;

	/**
	 * Instantiates a new strike a match data.
	 * 
	 * @param pWordA
	 *            the word a
	 * @param pWordB
	 *            the word b
	 * @param pSynonyms
	 *            the synonyms
	 * @param pSynonymWord
	 *            the synonym word
	 */
	public StrikeAMatchData(String pWordA, String pWordB, I pSynonyms,
			AbstractCfgSynonymWord pSynonymWord) {
		super();
		wordA = pWordA;
		wordB = pWordB;
		synonyms = pSynonyms;
		synonymWord = pSynonymWord;
	}

	
	public StrikeAMatchData(String pWordA, String pWordB) {
		wordA = pWordA;
		wordB = pWordB;
	}
	
	/**
	 * Gets the best algorithm.
	 * 
	 * @return the best algorithm
	 */
	public AbstractStringMetric getBestAlgorithm() {
		return bestAlgorithm;
	}

	/**
	 * Sets the best algorithm.
	 * 
	 * @param bestAlgorithm
	 *            the best algorithm
	 */
	public void setBestAlgorithm(AbstractStringMetric bestAlgorithm) {
		this.bestAlgorithm = bestAlgorithm;
	}

	
	/**
	 * Compare strings.
	 * 
	 * @param cfgMaster
	 *            the cfg master
	 */
	public void compareStrings(final CfgMaster cfgMaster) {
		// Obtenemos los algoritmos configurados para el cfgMaster en cuestion y
		// pasamos todos ellos
		// Los resultados de cada uno de ellos los almacenamos en una lista para
		// luego ver cual usamos o que
		// combinacion de ellos.
		List<CfgResolverAlgorithm> algorithm = cfgMaster.getListaAlgoritmos();
		summa = new Double(0);
		sinonimo = 0;
//		LOG.debug(new StringBuffer().append("Comparamos ").append(wordA)
//				.append(" con ").append(wordB).toString());
		double maximoStrike = 0.0;
		for (int i = 0; i < algorithm.size(); i++) {
			double valorAlgoritmo = algorithm.get(i).getAlgorithm()
					.getSimilarity(wordA, wordB);
			summa = summa + valorAlgoritmo;
			if (valorAlgoritmo >= algorithm.get(i).getLimit()) {
				// Añado a una lista los valores, dicha lista luego me servira
				// para comparar.
				sinonimo++;
				maximoStrike = valorAlgoritmo;
				if (strike == null || maximoStrike > strike) {
					strike = new Double(maximoStrike);
					bestAlgorithm = algorithm.get(i).getAlgorithm();
				}
//				LOG.debug(new StringBuffer().append("La palabra ")
//						.append(wordB).append(" es candidata de ser sinonimo.")
//						.toString());
			}
		}
		if (sinonimo > 0) {
			strike = summa;
		}
	}

	
	
	/**
	 * Compare to.
	 * 
	 * @param pO
	 *            the p o
	 * @return the int {@inheritDoc}
	 */
	@Override
	public int compareTo(StrikeAMatchData<I> pO) {
		return summa.compareTo(pO.summa);
	}

	/**
	 * Gets the strike.
	 * 
	 * @return the strike
	 */
	public Double getStrike() {
		return strike;
	}

	/**
	 * Gets the synonyms.
	 * 
	 * @return the synonyms
	 */
	public I getSynonyms() {
		return synonyms;
	}

	/**
	 * Gets the synonym word.
	 * 
	 * @return the synonym word
	 */
	public AbstractCfgSynonymWord getSynonymWord() {
		return synonymWord;
	}

	/**
	 * Gets the word a.
	 * 
	 * @return the word a
	 */
	public String getWordA() {
		return wordA;
	}

	/**
	 * Gets the word a.
	 * 
	 * @return the word a
	 */
	public void setWordA(String wordA) {
		this.wordA = wordA;
	}
	
	/**
	 * Gets the word b.
	 * 
	 * @return the word b
	 */
	public String getWordB() {
		return wordB;
	}

	/**
	 * Sets the strike.
	 * 
	 * @param pStrike
	 *            the new strike
	 */
	public void setStrike(Double pStrike) {
		strike = pStrike;
	}
}
