package com.comparadorad.bet.comparer.synchro.reader.readerbookmaker.core.readers.intertops;

import com.comparadorad.bet.comparer.model.bet.bean.IBetEvent;
import com.comparadorad.bet.comparer.model.config.bean.CfgSport.CfgSportId;
import com.comparadorad.bet.comparer.synchro.reader.readerbookmaker.core.readers.nordicbet.SportsNordicbet;

/**
 * The Enum SportYouwinResolver.
 */
enum SportIntertopsResolver {

	/** The FOOTBALL. */
	/**
	 * Existe "US major League Soccer" con id = 2 que contemplaria la prorroga,
	 * no se incluye ya que no se han observado apuestas relacionadas
	 */
	FOOTBALL(CfgSportId.FOOTBALL.nameId(), "12"),
	/** The TENNIS. */
	TENNIS(CfgSportId.TENNIS.nameId(), "25", "26"),
	/** The BASKETBALL. */
	BASKETBALL(CfgSportId.BASKETBALL.nameId(), "5"),
	/** The BASEBALL. */
	BASEBALL(CfgSportId.BASEBALL.nameId(), "4"),
	/** The IC e_ hockey. */
	ICE_HOCKEY(CfgSportId.ICE_HOCKEY.nameId(), "16"),
	/** The HANDBALL. */
	HANDBALL(CfgSportId.HANDBALL.nameId(), "14"),
	/** The CYCLING. */
	CYCLING(CfgSportId.CYCLING.nameId(), "10"),
	/** The AMERICA n_ football. */
	AMERICAN_FOOTBALL(CfgSportId.AMERICAN_FOOTBALL.nameId(), "1");

	/** The events. */
	private final String[] events;

	/**
	 * Instantiates a new bet event bookmaker.
	 * 
	 * @param pValue
	 *            the value
	 */
	SportIntertopsResolver(String... pValue) {
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
	 * Gets the type by value.
	 * 
	 * @param pValue
	 *            the value
	 * @return the type by value
	 */
	public static String resolveSport (String idSport) {
		SportIntertopsResolver[] values = SportIntertopsResolver.values();
		for (int i = 0; i < values.length; i++) {
			String[] types = values[i].getEvents();
			for (int j = 1; j < types.length; j++) {
				if (idSport.equals(types[j])) {
					return values[i].getId();
				}
			}
		}
		return null;
	}

	/**
	 * Checks if is ice hockey.
	 * 
	 * @param sportId
	 *            the sport id
	 * @return the boolean
	 */
	public static Boolean isIceHockey(String sportId) {
		String[] events = SportIntertopsResolver.ICE_HOCKEY.getEvents();
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
		String[] events = SportIntertopsResolver.BASKETBALL.getEvents();
		for (int i = 1; i < events.length; i++) {
			if (events[i].equals(sportId)) {
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
		String[] events = SportIntertopsResolver.AMERICAN_FOOTBALL.getEvents();
		for (int i = 1; i < events.length; i++) {
			if (events[i].equals(sportId)) {
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
		String[] events = SportIntertopsResolver.BASEBALL.getEvents();
		for (int i = 1; i < events.length; i++) {
			if (events[i].equals(sportId)) {
				return true;
			}
		}
		return false;

	}

}
