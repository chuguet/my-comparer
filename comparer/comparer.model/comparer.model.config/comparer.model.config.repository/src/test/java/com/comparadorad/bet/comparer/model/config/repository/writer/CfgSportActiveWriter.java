/**
 *
 * Copyright (C) FACTORIA ETSIA S.L.
 * All Rights Reserved.
 * www.factoriaetsia.com
 *
 */
package com.comparadorad.bet.comparer.model.config.repository.writer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;

import com.comparadorad.bet.comparer.model.config.bean.CfgSportActive;
import com.comparadorad.bet.comparer.model.core.repository.AbstractWriterXML;

/**
 * The Class CfgCompetitionWriter.
 */
public class CfgSportActiveWriter extends AbstractWriterXML<List<CfgSportActive>> {

	/**
	 * Checks if is extended.
	 * 
	 * @return true, if is extended {@inheritDoc}
	 */
	@Override
	protected boolean isExtended() {
		return false;
	}

	/**
	 * Make object.
	 * 
	 * @return the list {@inheritDoc}
	 */
	@Override
	protected List<CfgSportActive> makeObject() {

		List<CfgSportActive> result = new ArrayList<CfgSportActive>();
		Collection<String> bet = new HashSet<String>(Arrays.asList("1X2", "Ganador_Partido", "Ganador", "Handicap_Asiatico",
				"1X2_Handicap", "Mas_Menos", "Maximo_Goleador"));
		addSport("Football", result, bet);

		bet = new HashSet<String>(Arrays.asList("Ganador_Partido", "Ganador", "Handicap_Asiatico", "1X2_Handicap", "Mas_Menos"));
		addSport("Tennis", result, bet);

		bet = new HashSet<String>(Arrays.asList("1X2", "Ganador_Partido", "Ganador", "Handicap_Asiatico", "1X2_Handicap", "Mas_Menos"));
		addSport("Basketball", result, bet);

		bet = new HashSet<String>(Arrays.asList("1X2", "Ganador_Partido", "Ganador", "Handicap_Asiatico", "Mas_Menos", "Maximo_Goleador"));
		addSport("Baseball", result, bet);

		bet = new HashSet<String>(Arrays.asList("1X2", "Ganador_Partido", "Ganador", "Handicap_Asiatico", "1X2_Handicap", "Mas_Menos",
				"Maximo_Goleador"));
		addSport("Ice hockey", result, bet);

		bet = new HashSet<String>(Arrays.asList("1X2", "Ganador_Partido", "Ganador", "Handicap_Asiatico", "1X2_Handicap", "Mas_Menos",
				"Maximo_Goleador"));
		addSport("Handball", result, bet);

		bet = new HashSet<String>(Arrays.asList("Ganador"));
		addSport("Motor", result, bet);

		bet = new HashSet<String>(Arrays.asList("Ganador"));
		addSport("Cycling", result, bet);

		bet = new HashSet<String>(Arrays.asList("1X2", "Ganador_Partido", "Ganador", "Handicap_Asiatico", "1X2_Handicap", "Mas_Menos",
				"Maximo_Goleador"));
		addSport("American football", result, bet);

		bet = new HashSet<String>(Arrays.asList("1X2", "Ganador_Partido", "Ganador", "Handicap_Asiatico", "1X2_Handicap", "Mas_Menos"));
		addSport("Rugby LEAGUE", result, bet);

		return result;
	}

	/**
	 * Adds the competition.
	 * 
	 * @param sportName
	 *            the sport name
	 * @param result
	 *            the result
	 * @param betsAllowed
	 *            the bets allowed
	 * @return the cfg sport active
	 */
	public CfgSportActive addSport(String sportName, List<CfgSportActive> result, Collection<String> betsAllowed) {
		// Sport New
		CfgSportActive cfgSportActive = new CfgSportActive();
		cfgSportActive.setSportName(sportName);
		cfgSportActive.setBetsBySportAllowed(betsAllowed);
		result.add(cfgSportActive);
		return cfgSportActive;
	}
}
