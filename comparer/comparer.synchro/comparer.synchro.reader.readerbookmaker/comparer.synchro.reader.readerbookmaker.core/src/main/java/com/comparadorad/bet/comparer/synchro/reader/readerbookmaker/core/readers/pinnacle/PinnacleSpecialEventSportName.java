/**
 *
 * Copyright (C) FACTORIA ETSIA S.L.
 * All Rights Reserved.
 * www.factoriaetsia.com
 *
 */
package com.comparadorad.bet.comparer.synchro.reader.readerbookmaker.core.readers.pinnacle;

/**
 * The Enum Sports. Pinnacle pone muchas veces el nombre de la competicion en el
 * nodo de <sporttype> para eventos de tipo especial. El enum Sports esta
 * pensado para asociar el string del nodo <sporttype> a un deporte. Un listado
 * de competiciones y sus deportes asociados se puede encontrar en:
 * http://xml.pinnaclesports.com/leagues.asp
 */
enum PinnacleSpecialEventSportName {

	/** The AMERICA n_ fotball. */
	AMERICAN_FOTBALL("American Football", "NFL", "Football"),

	/** The AUSSI e_ rules. */
	AUSSIE_RULES("Aussie Rules"),

	/** The BASEBALL. */
	BASEBALL("Baseball", "MLB", "NCAA", "NRL"),

	/** The BASKETBALL. */
	BASKETBALL("Basketball", "NBA", "WNBA", "Adriatic", "Eurobasket",
			"EuroChampW", "Eurocup", "ACB"),

	/** The DARTS. */
	DARTS("Darts"),

	/** The HOCKEY. */
	HOCKEY("Hockey", "NHL", "AHL"),

	/** The MOTOR. */
	MOTOR("Motor", "Formula 1"),

	/** The RUGBY. */
	RUGBY("Rugby", "IRB", "Lions Tour"),

	/** The SNOOKER. */
	SNOOKER("Snoocer", "Goldfields", "Wuxi"),

	/** The SOCCER. */
	SOCCER("Soccer", "Allsvenskan", "FIFA", "UEFA"),

	/** The TENNIS. */
	TENNIS("Tennis", "ATP", "WTA", "Aegon", "Topshelf");

	/**
	 * Gets the event by value.
	 * 
	 * @param pValue
	 *            the value
	 * @return the event by value
	 */
	public static PinnacleSpecialEventSportName getSportNameByValue(
			String pValue) {
		PinnacleSpecialEventSportName[] sports = PinnacleSpecialEventSportName
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
	 * Instantiates a new sports.
	 * 
	 * @param pSportLookupNames
	 *            the sport lookup names
	 */
	PinnacleSpecialEventSportName(String... pSportLookupNames) {
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

	public static boolean isBasketball(String name) {
		if(name.equals(PinnacleSpecialEventSportName.BASKETBALL.getSportName())){
			return true;
		}
		return false;
	}
	
	public static boolean isBaseball(String name) {
		if(name.equals(PinnacleSpecialEventSportName.BASEBALL.getSportName())){
			return true;
		}
		return false;
	}
	
	public static boolean isAmericanFootbal(String name) {
		if(name.equals(PinnacleSpecialEventSportName.AMERICAN_FOTBALL.getSportName())){
			return true;
		}
		return false;
	}


}
