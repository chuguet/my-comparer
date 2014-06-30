/**
 *
 * Copyright (C) FACTORIA ETSIA S.L.
 * All Rights Reserved.
 * www.factoriaetsia.com
 *
 */
package com.comparadorad.bet.comparer.synchro.reader.readerbookmaker.core.readers.pinnacle;

/**
 * The Enum PinnacleNormalEventSportName. Este enum esta pensado para cambiar el
 * nombre de deportes. Por ejemplo llega fútbol americano como:
 * <sporttype>Football</sporttype> y aquí se puede hacer un lookup con el nombre
 * Football para sacar el nombre American Football.
 */
enum PinnacleNormalEventSportName {

	/** The AMERICA n_ fotball. */
	AMERICAN_FOTBALL("American Football", "Football");

	/**
	 * Gets the sport name by value.
	 * 
	 * @param pValue
	 *            the value
	 * @return the sport name by value
	 */
	public static PinnacleNormalEventSportName getSportNameByValue(String pValue) {
		PinnacleNormalEventSportName[] sports = PinnacleNormalEventSportName
				.values();
		for (int sportIndex = 0; sportIndex < sports.length; sportIndex++) {
			String[] sportLookups = sports[sportIndex].getSportLookupNames();
			for (int lookupIndex = 0; lookupIndex < sportLookups.length; lookupIndex++) {
				if (pValue.toLowerCase().contains(
						sportLookups[lookupIndex].toLowerCase())) {
					return sports[sportIndex];
				}
			}
		}
		return null;
	}

	/** The sport lookup names. */
	private final String[] sportLookupNames;

	/**
	 * Instantiates a new pinnacle normal event sport name.
	 * 
	 * @param pSportLookupNames
	 *            the sport lookup names
	 */
	PinnacleNormalEventSportName(String... pSportLookupNames) {
		this.sportLookupNames = pSportLookupNames;
	}

	/**
	 * Gets the sport lookup names.
	 * 
	 * @return the sport lookup names
	 */
	public String[] getSportLookupNames() {
		return sportLookupNames;
	}

	/**
	 * Gets the sport name.
	 * 
	 * @return the sport name
	 */
	public String getSportName() {
		return sportLookupNames[0];
	}

}
