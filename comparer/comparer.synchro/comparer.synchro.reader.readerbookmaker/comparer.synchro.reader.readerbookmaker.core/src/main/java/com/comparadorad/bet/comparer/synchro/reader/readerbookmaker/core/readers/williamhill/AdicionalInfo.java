/**
 *
 * Copyright (C) FACTORIA ETSIA S.L.
 * All Rights Reserved.
 * www.factoriaetsia.com
 *
 */
package com.comparadorad.bet.comparer.synchro.reader.readerbookmaker.core.readers.williamhill;

/**
 * The Class AdicionalInfo.
 */
public class AdicionalInfo {

	/** The competition. */
	private String competition;

	/**
	 * Instantiates a new adicional info.
	 *
	 * @param pCompetition the competition
	 */
	public AdicionalInfo(String pCompetition) {
		super();
		competition = pCompetition;
	}

	/**
	 * Gets the competition.
	 *
	 * @return the competition
	 */
	public String getCompetition() {
		return competition;
	}

	/**
	 * Sets the competition.
	 *
	 * @param pCompetition the new competition
	 */
	public void setCompetition(String pCompetition) {
		competition = pCompetition;
	}
	
}
