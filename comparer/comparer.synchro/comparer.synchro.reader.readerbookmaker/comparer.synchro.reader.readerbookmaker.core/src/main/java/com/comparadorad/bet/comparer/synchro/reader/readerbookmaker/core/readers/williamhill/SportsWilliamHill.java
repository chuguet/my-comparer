/**
 *
 * Copyright (C) FACTORIA ETSIA S.L.
 * All Rights Reserved.
 * www.factoriaetsia.com
 *
 */
package com.comparadorad.bet.comparer.synchro.reader.readerbookmaker.core.readers.williamhill;


/**
 * The Enum BetType.
 */
public enum SportsWilliamHill {

	
	Futbol("46","36","274","275","1"),

	
	Basketball("273","336"),

	
	Tennis("45","424","43","308"),

	
	Hockey("283","401","32"),

	
	Baseball("15"),

	
	American_football("19"),
	
			
	Cycling("301"),
	
			
	Handball("303");


	private final String[] id;


	SportsWilliamHill(String... pValue) {
		this.id = pValue;
	}


	public String[] getSportId() {
		return id;
	}


	public static SportsWilliamHill getSportByValue(String pValue) {
		SportsWilliamHill[] values = SportsWilliamHill.values();
		for (int i = 0; i < values.length; i++) {
			String[] types = values[i].getSportId();
			for (int j = 0; j < types.length; j++) {
				if (pValue.equals(types[j])) {
					return values[i];
				}
			}
		}
		return null;
	}


}
