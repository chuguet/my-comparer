/**
 *
 * Copyright (C) FACTORIA ETSIA S.L.
 * All Rights Reserved.
 * www.factoriaetsia.com
 *
 */
package com.comparadorad.bet.comparer.synchro.reader.readerbookmaker.core.readers.unibet;


/**
 * The Enum BetType.
 */
public enum BetsInvalidUniBet {

	
	otro(),
	
	ganador_partido("First Team to Score", "First Goal", "Last Goal", "First to 10 Points", "First to 20 Points", "First to 50 points", "First Point", "Last Point", "First Run", "Last Run", "Team to go through", "To break Serve first"),
	
	mas_menos("Total Goals by Home Team", "Total Goals by Away Team", "Total Points by Home Team", "Total Points by Away Team", "Total Runs by Home Team", "Total Runs by Away Team", "Total Corners by Home Team", "Total Corners by Away Team", "Corners", "Points scored by the player", "Goals scored by the player", "Total Games", "Total games", "Total Numbers of Tiebreaks", "Total Aces", "total Aces"),
	
	handicap_asiatico("Fastest serve", "To hit most Aces", "Game Handicap");


	private final String[] id;


	BetsInvalidUniBet(String... pValue) {
		this.id = pValue;
	}


	public String[] getSportId() {
		return id;
	}


	public static BetsInvalidUniBet getMarketByValue(String pValue) {
		BetsInvalidUniBet[] values = BetsInvalidUniBet.values();
		for (int i = 0; i < values.length; i++) {
			String[] types = values[i].getSportId();
			for (int j = 0; j < types.length; j++) {
				if (pValue.contains(types[j])) {
					return values[i];
				}
			}
		}
		return values[0];
	}


}
