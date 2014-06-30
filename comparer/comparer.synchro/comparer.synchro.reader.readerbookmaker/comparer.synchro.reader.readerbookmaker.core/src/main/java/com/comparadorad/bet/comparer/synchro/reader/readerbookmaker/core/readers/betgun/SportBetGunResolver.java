package com.comparadorad.bet.comparer.synchro.reader.readerbookmaker.core.readers.betgun;

import com.comparadorad.bet.comparer.model.config.bean.CfgSport.CfgSportId;

public enum SportBetGunResolver {
	
	/** The FOOTBALL. */
	FOOTBALL(CfgSportId.FOOTBALL.nameId(), "SOCCER"),
	/** The BASKETBALL. */
	BASKETBALL(CfgSportId.BASKETBALL.nameId(), "BASKETBALL"),
	/** The IC e_ hockey. */
	ICE_HOCKEY(CfgSportId.ICE_HOCKEY.nameId(), "ICE HOCKEY"),
	/** The HANDBALL. */
	HANDBALL(CfgSportId.HANDBALL.nameId(), "HANDBALL");

	/** The events. */
	private final String[] events;

	/**
	 * Instantiates a new bet event bookmaker.
	 * 
	 * @param pValue
	 *            the value
	 */
	SportBetGunResolver(String... pValue) {
		this.events = pValue;
	}

	/**
	 * Gets the events.
	 * 
	 * @return the events
	 */
	public String[] getEvents() {
		return events;
	}

	/**
	 * Gets the id.
	 * 
	 * @return the id
	 */
	public String getId() {
		return events[0];
	}

	/**
	 * Checks if is ice hockey.
	 * 
	 * @param sportId
	 *            the sport id
	 * @return the boolean
	 */
	public static Boolean isIceHockey(String sportId) {
		String[] events = SportBetGunResolver.ICE_HOCKEY.getEvents();
		for (int i = 1; i < events.length; i++) {
			if (events[i].equals(sportId)) {
				return true;
			}
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
		String[] events = SportBetGunResolver.BASKETBALL.getEvents();
		for (int i = 1; i < events.length; i++) {
			if (events[i].equalsIgnoreCase(sportId)) {
				return true;
			}
		}
		return false;
	}

}
