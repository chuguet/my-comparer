package com.comparadorad.bet.comparer.synchro.reader.readerbookmaker.core.readers.interwetten;

import com.comparadorad.bet.comparer.model.config.bean.CfgSport.CfgSportId;

public class InterwettenSportUtil {
	
	enum SportInterwettenResolver {

		/** The BASKETBALL. */
		BASKETBALL(CfgSportId.BASKETBALL.nameId(), "Basketball"),
		/** The BASEBALL. */
		BASEBALL(CfgSportId.BASEBALL.nameId(), "Baseball"),
		/** The IC e_ hockey. */
		ICE_HOCKEY(CfgSportId.ICE_HOCKEY.nameId(), "Ice Hockey"),
		/** The AMERICA n_ football. */
		AMERICAN_FOOTBALL(CfgSportId.AMERICAN_FOOTBALL.nameId(), "American Football");

		/** The events. */
		private final String[] events;

		/**
		 * Instantiates a new bet event bookmaker.
		 * 
		 * @param pValue
		 *            the value
		 */
		SportInterwettenResolver(String... pValue) {
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
	}
	
	/**
	 * Checks if is ice hockey.
	 * 
	 * @param sportId
	 *            the sport id
	 * @return the boolean
	 */
	public static Boolean isIceHockey(String sportId) {
		String[] events = SportInterwettenResolver.ICE_HOCKEY.getEvents();
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
		String[] events = SportInterwettenResolver.BASKETBALL.getEvents();
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
		String[] events = SportInterwettenResolver.AMERICAN_FOOTBALL.getEvents();
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
		String[] events = SportInterwettenResolver.BASEBALL.getEvents();
		for (int i = 1; i < events.length; i++) {
			if (events[i].equals(sportId)) {
				return true;
			}
		}
		return false;

	}

}
