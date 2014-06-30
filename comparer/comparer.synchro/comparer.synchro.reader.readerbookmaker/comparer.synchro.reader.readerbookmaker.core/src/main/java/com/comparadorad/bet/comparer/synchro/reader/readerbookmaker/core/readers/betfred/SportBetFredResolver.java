package com.comparadorad.bet.comparer.synchro.reader.readerbookmaker.core.readers.betfred;

import com.comparadorad.bet.comparer.model.config.bean.CfgSport.CfgSportId;


enum SportBetFredResolver {

	/** The TENNIS. */
	TENNIS(CfgSportId.TENNIS.nameId(), "Tennis"),
	/** The BASKETBALL. */
	BASKETBALL(CfgSportId.BASKETBALL.nameId(), "basketball", "Basketball"),
	/** The BASEBALL. */
	BASEBALL(CfgSportId.BASEBALL.nameId(), "baseball", "Baseball"),
	/** The IC e_ hockey. */
	ICE_HOCKEY(CfgSportId.ICE_HOCKEY.nameId(), "nhl", "IceHockey", "ice"),
	/** The AMERICA n_ football. */
	AMERICAN_FOOTBALL(CfgSportId.AMERICAN_FOOTBALL.nameId(), "American");

	/** The events. */
	private final String[] events;

	/**
	 * Instantiates a new bet event bookmaker.
	 * 
	 * @param pValue
	 *            the value
	 */
	SportBetFredResolver(String... pValue) {
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
		String[] events = SportBetFredResolver.ICE_HOCKEY.getEvents();
		for (int i = 1; i < events.length; i++) {
			if (events[i].equalsIgnoreCase(sportId)) {
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
		String[] events = SportBetFredResolver.BASKETBALL.getEvents();
		for (int i = 1; i < events.length; i++) {
			if (events[i].equalsIgnoreCase(sportId)) {
				return true;
			}
		}
		return false;
	}

	/**
	 * Checks if is american football.
	 * 
	 * @param sportId
	 *            the sport id
	 * @return the boolean
	 */
	public static Boolean isAmericanFootball(String sportId) {
		String[] events = SportBetFredResolver.AMERICAN_FOOTBALL.getEvents();
		for (int i = 1; i < events.length; i++) {
			if (events[i].equalsIgnoreCase(sportId)) {
				return true;
			}
		}
		return false;
	}

	/**
	 * Checks if is baseball.
	 * 
	 * @param sportId
	 *            the sport id
	 * @return the boolean
	 */
	public static Boolean isBaseball(String sportId) {
		String[] events = SportBetFredResolver.BASEBALL.getEvents();
		for (int i = 1; i < events.length; i++) {
			if (events[i].equalsIgnoreCase(sportId)) {
				return true;
			}
		}
		return false;

	}
}