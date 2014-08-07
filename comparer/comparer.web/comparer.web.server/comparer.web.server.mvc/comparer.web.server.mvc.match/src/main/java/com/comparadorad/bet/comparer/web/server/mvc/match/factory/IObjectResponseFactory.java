/**
 *
 * Copyright (C) FACTORIA ETSIA S.L.
 * All Rights Reserved.
 * www.factoriaetsia.com
 *
 */
package com.comparadorad.bet.comparer.web.server.mvc.match.factory;

import com.comparadorad.bet.comparer.model.config.bean.CfgBetType;
import com.comparadorad.bet.comparer.web.server.mvc.core.beans.InformationWindow;
import com.comparadorad.bet.comparer.web.server.mvc.match.enums.LevelType;
import com.comparadorad.bet.comparer.web.server.mvc.match.table.competition.tablongterm.IMakeTableCompetitionLT;
import com.comparadorad.bet.comparer.web.server.mvc.match.table.country.tablongterm.IMakeTableCountryLT;
import com.comparadorad.bet.comparer.web.server.mvc.match.table.event.tabevent.IMakeTableEvent;
import com.comparadorad.bet.comparer.web.server.mvc.match.table.shortterm.IMakeTableShortTerm;

/**
 * A factory for creating IObjectResponse objects.
 */
public interface IObjectResponseFactory {

	/**
	 * Make table competition.
	 * 
	 * @param cfgBetType
	 *            the cfg bet type
	 * @param informationWindow
	 *            the information window
	 * @return the i make table competition
	 */
	IMakeTableShortTerm makeTableShortTerm(CfgBetType cfgBetType,
			LevelType levelType, InformationWindow informationWindow);

	/**
	 * Make table competition lt.
	 * 
	 * @param cfgBetType
	 *            the cfg bet type
	 * @param informationWindow
	 *            the information window
	 * @return the i make table competition lt
	 */
	IMakeTableCompetitionLT makeTableCompetitionLT(CfgBetType cfgBetType,
			InformationWindow informationWindow);

	/**
	 * Make table country long term.
	 * 
	 * @param cfgBetType
	 *            the cfg bet type
	 * @param informationWindow
	 *            the information window
	 * @return the i make table country long term
	 */
	IMakeTableCountryLT makeTableCountryLT(CfgBetType cfgBetType,
			InformationWindow informationWindow);

	/**
	 * Make table event.
	 * 
	 * @param cfgBetType
	 *            the cfg bet type
	 * @param informationWindow
	 *            the information window
	 * @return the i make table event
	 */
	IMakeTableEvent makeTableEvent(CfgBetType cfgBetType,
			InformationWindow informationWindow);

}
