/**
 *
 * Copyright (C) FACTORIA ETSIA S.L.
 * All Rights Reserved.
 * www.factoriaetsia.com
 *
 */
package com.comparadorad.bet.comparer.synchro.securebet.process.combination;

import java.util.ArrayList;
import java.util.List;

import com.comparadorad.bet.comparer.model.bet.bean.RtBet;


/**
 * The Class RtBetCombination.
 *
 * @param <T> the generic type
 */
public class RtBetCombination implements IRtBetCombination {
	

	/** The group. */
	private List<RtBet[]> group;

	/** The combinations. */
	private List<Object> combinations = new ArrayList<Object>();	
	

	/** The podar. */
	boolean podar = false;

	/**
	 * Instantiates a new abstract permutations.
	 * 
	 * @param group
	 *            the group
	 */
	public RtBetCombination(List<RtBet[]> group) {
		this.group = group;
		Object[][] presente = new Object[group.size()][2];
		for (int i = 0; i < group.size(); i++) {
			presente[i][0] = false;
			presente[i][1] = new boolean[group.get(i).length];
		}
		fastTree(presente, 0);
	}



	/**
	 * Fast process.
	 * 
	 * @param presente
	 *            the presente
	 */
	private void fastProcess(Object[][] presente) {
		List<boolean[]> subconjuntos = new ArrayList<boolean[]>();
		for (int i = 0; i < presente.length; i++) {
			if (Boolean.parseBoolean(presente[i][0].toString())) {
				subconjuntos.add((boolean[]) presente[i][1]);
			}
		}
		if (subconjuntos.size() > 0)
			this.lowTree(presente, subconjuntos, 0);
	}

	/**
	 * Fast tree.
	 * 
	 * @param presente
	 *            the presente
	 * @param posicionActual
	 *            the posicion actual
	 */
	private void fastTree(Object[][] presente, int posicionActual) {
		if (presente.length == posicionActual) {
			fastProcess(presente);
			// podar = true;
		} else {
			if (!podar) {
				presente[posicionActual][0] = true;
				fastTree(presente, posicionActual + 1);
				if (!podar) {
					presente[posicionActual][0] = false;
					fastTree(presente, posicionActual + 1);
				}
			}
		}
	}

	/**
	 * Low process.
	 * 
	 * @param presente
	 *            the presente
	 * @param subconjuntos
	 *            the subconjuntos
	 */
	private void lowProcess(Object[][] presente, List<boolean[]> subconjuntos) {
		List<Object> combinaciones = new ArrayList<Object>();
		for (int i = 0; i < subconjuntos.size(); i++) {
			for (int j = 0; j < subconjuntos.get(i).length; j++) {
				if (subconjuntos.get(i)[j]) {
					int k = -1;
					for (int m = 0; m < presente.length; m++) {
						if (Boolean.parseBoolean(presente[m][0].toString()))
							k++;
						if (k == i) {
							combinaciones.add(group.get(m)[j]);
							break;
						}
					}
					break;
				}
			}
		}
//		if (LOG.isDebugEnabled()) {
//			LOG.debug(combinaciones);
//		}
		this.combinations.add(combinaciones);
	}

	/**
	 * Gets the combinations.
	 * 
	 * @return the combinations
	 */
	@SuppressWarnings("unchecked")
	public List<List<RtBet>> getCombinations() {
		List<List<RtBet>> result = new ArrayList<List<RtBet>>();
		List<?> tmpCombinations = combinations;
		List<?> tmp;
		for (int i = 0; i < tmpCombinations.size(); i++) {
			tmp = (List<?>) tmpCombinations.get(i);
			result.add((List<RtBet>) tmp);
		}
		return result;
	}
	


	 /** {@inheritDoc} */ 
	@SuppressWarnings("unchecked")
	public List<List<RtBet>> getCombinations(Integer size) {
		List<List<RtBet>> result = new ArrayList<List<RtBet>>();
		List<?> tmpCombinations = combinations;
		List<?> tmp;
		for (int i = 0; i < tmpCombinations.size(); i++) {
			tmp = (List<?>) tmpCombinations.get(i);
			if (tmp.size() == size) {
				result.add((List<RtBet>) tmp);
			}
		}		
		return  result;

	}

	/**
	 * Arbol secundario.
	 * 
	 * @param presente
	 *            the presente
	 * @param subconjuntos
	 *            the subconjuntos
	 * @param posicionActual
	 *            the posicion actual
	 */
	private void lowTree(Object[][] presente, List<boolean[]> subconjuntos,
			int posicionActual) {
		if (subconjuntos.size() == posicionActual) {
			lowProcess(presente, subconjuntos);
		} else {
			for (int i = 0; i < subconjuntos.get(posicionActual).length; i++) {
				subconjuntos.set(posicionActual,
						new boolean[subconjuntos.get(posicionActual).length]);
				subconjuntos.get(posicionActual)[i] = true;
				lowTree(presente, subconjuntos, posicionActual + 1);
			}
		}
	}

}
