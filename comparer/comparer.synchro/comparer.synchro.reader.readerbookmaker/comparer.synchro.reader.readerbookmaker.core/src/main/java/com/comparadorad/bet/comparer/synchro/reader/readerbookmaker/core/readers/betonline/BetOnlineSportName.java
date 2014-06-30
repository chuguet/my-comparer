/**
 *
 * Copyright (C) FACTORIA ETSIA S.L.
 * All Rights Reserved.
 * www.factoriaetsia.com
 *
 */
package com.comparadorad.bet.comparer.synchro.reader.readerbookmaker.core.readers.betonline;

import com.comparadorad.bet.comparer.model.config.bean.CfgSport.CfgSportId;

/**
 * The Enum BetOnlineSportName.
 */
enum BetOnlineSportName {

	/** The AMERICA n_ football. */
	AMERICAN_FOOTBALL(CfgSportId.AMERICAN_FOOTBALL.nameId(), "Football"),
	/** The FOOTBALL. */
	FOOTBALL(CfgSportId.FOOTBALL.nameId(), "Soccer"),
	/** The TENNIS. */
	TENNIS(CfgSportId.TENNIS.nameId(), "Tennis"),
	/** The BASKETBALL. */
	BASKETBALL(CfgSportId.BASKETBALL.nameId(), "Basketball"),
	/** The BASEBALL. */
	BASEBALL(CfgSportId.BASEBALL.nameId(), "Baseball"),
	/** The IC e_ hockey. */
	ICE_HOCKEY(CfgSportId.ICE_HOCKEY.nameId(), "Hockey"),
	/** The RUGBY_LEAGUE n_ rugby. */
	RUGBY_LEAGUE(CfgSportId.RUGBY_LEAGUE.nameId(), "Rugby");

	/**
	 * Gets the sport name by value.
	 * 
	 * @param pValue
	 *            the value
	 * @return the sport name by value
	 */
	public static BetOnlineSportName getSportNameByValue(String pValue) {
		BetOnlineSportName[] sports = BetOnlineSportName.values();
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
	 * Instantiates a new bet online sport name.
	 * 
	 * @param pSportLookupNames
	 *            the sport lookup names
	 */
	BetOnlineSportName(String... pSportLookupNames) {
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
	
	/**
	 * Checks if is ice hockey.
	 * 
	 * @param sportId
	 *            the sport id
	 * @return the boolean
	 */
	public static Boolean isIceHockey(String sportId) {
		if (sportId.equalsIgnoreCase(BetOnlineSportName.ICE_HOCKEY.getSportName())){
			return true;
		}
		return false;
	}

	/**
	 * Checks if is basketball.
	 * 
	 * @param sportId
	 *            the sport id
	 * @return the boolean
	 */
	public static Boolean isBasketball(String sportId) {
		if (sportId.equalsIgnoreCase(BetOnlineSportName.BASKETBALL.getSportName())){
			return true;
		}
		return false;
	}
	
	/**
	 * Checks if is ice American Football.
	 * 
	 * @param sportId
	 *            the sport id
	 * @return the boolean
	 */
	public static Boolean isAmericanFootball(String sportId) {
		if (sportId.equalsIgnoreCase(BetOnlineSportName.AMERICAN_FOOTBALL.getSportName())){
			return true;
		}
		return false;
	}

	/**
	 * Checks if is Baseball.
	 * 
	 * @param sportId
	 *            the sport id
	 * @return the boolean
	 */
	public static Boolean isBaseball(String sportId) {
		if (sportId.equalsIgnoreCase(BetOnlineSportName.BASEBALL.getSportName())){
			return true;
		}
		return false;
	}

}
