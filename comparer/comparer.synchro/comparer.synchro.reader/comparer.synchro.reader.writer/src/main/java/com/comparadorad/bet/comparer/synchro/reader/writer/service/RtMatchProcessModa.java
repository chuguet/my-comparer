/**
 *
 * Copyright (C) FACTORIA ETSIA S.L.
 * All Rights Reserved.
 * www.factoriaetsia.com
 *
 */
package com.comparadorad.bet.comparer.synchro.reader.writer.service;

import java.util.List;

import org.springframework.stereotype.Component;

import com.comparadorad.bet.comparer.model.bet.bean.RtBookmakerIdWeight;
import com.comparadorad.bet.comparer.model.bet.bean.RtMatch;
import com.comparadorad.bet.comparer.model.bet.bean.RtModa;
import com.comparadorad.bet.comparer.model.core.bean.CoreDate;

/**
 * The Class RtMatchProcessModa.
 */
@Component
public class RtMatchProcessModa {

	/**
	 * Calculate moda.
	 * 
	 * @param modas
	 *            the modas
	 * @return the core date
	 */
	public CoreDate calculateModa(
			List<RtModa> modas) {
		RtModa moda = null;
		CoreDate result = null;

		boolean primera = true;
		for (RtModa modaIt : modas) {
			if (primera) {
				moda = modaIt;
				primera = false;
			} else {
				if (calculateWeight(moda.getMatchers()) < calculateWeight(modaIt
						.getMatchers())) {
					moda = modaIt;
				}
			}
		}

		if (moda != null) {
			result = moda.getElement();
		}

		return result;
	}

	/**
	 * Calculate weight.
	 * 
	 * @param matchers
	 *            the matchers
	 * @return the integer
	 */
	private Integer calculateWeight(List<RtBookmakerIdWeight> matchers) {
		Integer weight = 0;
		for (RtBookmakerIdWeight bookmakerIdWeight : matchers) {
			weight += bookmakerIdWeight.getWeigth();
		}
		return weight;
	}

	/**
	 * Contains.
	 * 
	 * @param matchers
	 *            the matchers
	 * @param bookmakerIdModaProcess
	 *            the bookmaker id moda process
	 * @return the boolean
	 */
	private Boolean contains(List<RtBookmakerIdWeight> matchers,
			String bookmakerIdModaProcess) {
		Boolean result = Boolean.FALSE;
		for (RtBookmakerIdWeight bookmakerIdWeight : matchers) {
			if (bookmakerIdModaProcess.equals(bookmakerIdWeight
					.getBookmakerId().objectId().toString())) {
				result = Boolean.TRUE;
				break;
			}
		}
		return result;
	}

	/**
	 * Erase bookmaker id.
	 * 
	 * @param modas
	 *            the modas
	 * @param pBookmakerIdWeight
	 *            the bookmaker id weight
	 */
	private void eraseBookmakerId(
			List<RtModa> modas,
			RtBookmakerIdWeight pBookmakerIdWeight) {
		int i = 0;
		int j = 0;
		boolean encontrado = false;
		for (RtModa moda : modas) {
			for (RtBookmakerIdWeight bookmakerIdWeight : moda.getMatchers()) {
				if (bookmakerIdWeight.getBookmakerId().equals(
						pBookmakerIdWeight.getBookmakerId())) {
					encontrado = true;
					break;
				}
				j++;
			}
			if (!encontrado) {
				j = 0;
				i++;
			} else {
				break;
			}
		}
		if (encontrado) {
			modas.get(i).getMatchers().remove(j);
			if (modas.get(i).getMatchers().isEmpty()) {
				modas.remove(i);
			}
		}
	}

	/**
	 * Gets the moda process.
	 * 
	 * @param rtMatch
	 *            the rt match
	 * @return the moda process
	 */
	public RtModa getModaFromProcess(
			RtMatch rtMatch) {
		// Recupero la de posicion 0, porque hasta este punto, no se ha
		// recuperado nada de base de datos por lo tanto solo tenemos un
		// elemento RtModa en la lista con una fecha y una lista de solo un
		// bookmaker
		return rtMatch.getMatchId().getModa().get(0);
	}

	/**
	 * Process moda.
	 * 
	 * @param modasDB
	 *            the modas db
	 * @param modaProcess
	 *            the moda process
	 * @return the list
	 */
	public List<RtModa> processModa(
			List<RtModa> modasDB,
			RtModa modaProcess) {
		Boolean flag = Boolean.FALSE;
		RtBookmakerIdWeight bookmakerIdWeight = modaProcess.getMatchers()
				.get(0);

		for (RtModa modaDB : modasDB) {
			if (modaDB.getElement().equals(modaProcess.getElement())) {
				flag = Boolean.TRUE;
				if (!contains(modaDB.getMatchers(), bookmakerIdWeight
						.getBookmakerId().objectId().toString())) {
					eraseBookmakerId(modasDB, bookmakerIdWeight);
					modaDB.getMatchers().add(bookmakerIdWeight);
					break;
				}
			}
		}
		if (!flag) {
			eraseBookmakerId(modasDB, bookmakerIdWeight);
			modasDB.add(modaProcess);
		}

		return modasDB;
	}
}
