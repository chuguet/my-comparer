/**
 *
 * Copyright (C) FACTORIA ETSIA S.L.
 * All Rights Reserved.
 * www.factoriaetsia.com
 *
 */
package com.comparadorad.bet.comparer.synchro.reader.readerbookmaker.core.readers.betclick;

import com.comparadorad.bet.comparer.model.bet.bean.IBetEvent;
import com.comparadorad.bet.comparer.model.config.bean.CfgSport.CfgSportId;

/**
 * The Enum SportBetclickResolver.
 */
class SportBetclickResolver {

	enum SportsBetclick implements IBetEvent {

		/** The FOOTBALL. */
		FOOTBALL(CfgSportId.FOOTBALL.nameId(), "1"),
		/** The TENNIS. */
		TENNIS(CfgSportId.TENNIS.nameId(), "2"),
		/** The BASKETBALL. */
		BASKETBALL(CfgSportId.BASKETBALL.nameId(), "4"),
		/** The BASEBALL. */
		BASEBALL(CfgSportId.BASEBALL.nameId()),
		/** The IC e_ hockey. */
		ICE_HOCKEY(CfgSportId.ICE_HOCKEY.nameId(), "13"),
		/** The HANDBALL. */
		HANDBALL(CfgSportId.HANDBALL.nameId(), "9"),
		/** The MOTOR. */
		MOTOR(CfgSportId.MOTOR.nameId()),
		/** The CYCLING. */
		CYCLING(CfgSportId.CYCLING.nameId(), "6"),
		/** The AMERICA n_ football. */
		AMERICAN_FOOTBALL(CfgSportId.AMERICAN_FOOTBALL.nameId(), "14"),
		/** The RUGB y_ league. */
		RUGBY_LEAGUE(CfgSportId.RUGBY_LEAGUE.nameId(), "52");

		/** The events. */
		private final String[] events;

		/**
		 * Instantiates a new bet event bookmaker.
		 * 
		 * @param pValue
		 *            the value
		 */
		SportsBetclick(String... pValue) {
			this.events = pValue;
		}

		/** {@inheritDoc} */
		@Override
		public String[] getEvents() {
			return events;
		}

		/** {@inheritDoc} */
		@Override
		public String getId() {
			return events[0];
		}
	}

	/**
	 * Checks if is tennis.
	 * 
	 * @param sportId
	 *            the sport id
	 * @return the boolean
	 */
	public static Boolean isTennis(String sportId) {
		String[] events = SportsBetclick.TENNIS.getEvents();
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
		String[] events = SportsBetclick.BASKETBALL.getEvents();
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
		String[] events = SportsBetclick.AMERICAN_FOOTBALL.getEvents();
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
		String[] events = SportsBetclick.BASEBALL.getEvents();
		for (int i = 1; i < events.length; i++) {
			if (events[i].equals(sportId)) {
				return true;
			}
		}
		return false;
	}

}
