/**
 *
 * Copyright (C) FACTORIA ETSIA S.L.
 * All Rights Reserved.
 * www.factoriaetsia.com
 *
 */
package com.comparadorad.bet.comparer.synchro.reader.readerbookmaker.core.readers.bwin;

import com.comparadorad.bet.comparer.model.config.bean.CfgSport.CfgSportId;


/**
 * The Enum BetType.
 */
public enum SportsIdBwin {

	
	/** The Futbol. */
	Futbol(CfgSportId.FOOTBALL.nameId(), "1582310","1582790"),

	/** The Basketball. */
	Basketball(CfgSportId.BASKETBALL.nameId(), "1582312","1582791"),
	
	/** The Tennis. */
	Tennis(CfgSportId.TENNIS.nameId(), "1582314","1582792"),

	/** The Hockey. */
	Hockey(CfgSportId.ICE_HOCKEY.nameId(), "1582315","1582793"),

	/** The Baseball. */
	Baseball(CfgSportId.BASEBALL.nameId(), "1582317"),

	/** The American_football. */
	American_football(CfgSportId.AMERICAN_FOOTBALL.nameId(), "1582318","1582795"),
			
	/** The Cycling. */
	Cycling(CfgSportId.CYCLING.nameId()),
		
	/** The Handball. */
	Handball(CfgSportId.HANDBALL.nameId(), "1582316","1582794");


	/** The id. */
	private final String[] id;


	/**
	 * Instantiates a new sports id bwin.
	 *
	 * @param pValue the value
	 */
	SportsIdBwin(String... pValue) {
		this.id = pValue;
	}


	/**
	 * Gets the sport id.
	 *
	 * @return the sport id
	 */
	public String[] getSportId() {
		return id;
	}
	
	/**
	 * Gets the sport literal.
	 *
	 * @return the sport literal
	 */
	public String getSportLiteral() {
		return id[0];
	}


	/**
	 * Gets the sport by value.
	 *
	 * @param pValue the value
	 * @return the sport by value
	 */
	public static String getSportByValue(String pValue) {
		SportsIdBwin[] values = SportsIdBwin.values();
		for (int i = 0; i < values.length; i++) {
			String[] types = values[i].getSportId();
			for (int j = 0; j < types.length; j++) {
				if (pValue.equals(types[j])) {
					return values[i].getSportLiteral();
				}
			}
		}
		return null;
	}


}
