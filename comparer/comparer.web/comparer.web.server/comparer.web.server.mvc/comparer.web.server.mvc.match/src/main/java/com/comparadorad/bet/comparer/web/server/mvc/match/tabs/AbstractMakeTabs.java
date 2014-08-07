/**
 *
 * Copyright (C) FACTORIA ETSIA S.L.
 * All Rights Reserved.
 * www.factoriaetsia.com
 *
 */
package com.comparadorad.bet.comparer.web.server.mvc.match.tabs;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.comparadorad.bet.comparer.model.bet.bean.RtMarket;
import com.comparadorad.bet.comparer.model.bet.bean.RtMatch;
import com.comparadorad.bet.comparer.model.config.bean.CfgBetType;
import com.comparadorad.bet.comparer.model.config.bean.CfgBetTypeEvent;
import com.comparadorad.bet.comparer.model.config.bean.CfgBetType.CfgBetTypeId;
import com.comparadorad.bet.comparer.model.core.bean.user.UserData;
import com.comparadorad.bet.comparer.web.client.gwt.common.bean.ObjectToId;
import com.comparadorad.bet.comparer.web.client.gwt.common.bean.tab.response.TabResponseDataTo;
import com.comparadorad.bet.comparer.web.client.gwt.common.bean.tab.response.TabResponseTo;
import com.comparadorad.bet.comparer.web.server.mvc.match.comparator.BetTypePriorityComparator;

/**
 * The Class AbstractMakeTabs.
 */
public abstract class AbstractMakeTabs implements IMakeTabs {

	/** The Constant LOG. */
	private static final Log LOG = LogFactory.getLog(AbstractMakeTabs.class);

	/**
	 * Make tab bet type.
	 * 
	 * @param matchs
	 *            the matchs
	 * @param userData
	 *            the user data
	 * @return the tab response to {@inheritDoc}
	 */
	@Override
	public TabResponseTo makeTabBetType(List<RtMatch> matchs, UserData userData) {
		TabResponseTo result = new TabResponseTo();
		List<CfgBetType> betTypes = getBetTypesFromMatchs(matchs);
		LOG.debug(new StringBuffer("Se recuperan ")
				.append(betTypes.size())
				.append(" bet types totales para ser filtradas segun tipo de vista"));
		List<CfgBetType> betTypesKept = getBetTypesKept(betTypes);
		LOG.debug(new StringBuffer("Se recuperan ").append(betTypesKept.size())
				.append(" bet types totales filtradas"));
		result.setTabs(getTabResponseToList(betTypesKept, userData));
		return result;
	}

	/**
	 * Make tab bet type.
	 * 
	 * @param match
	 *            the match
	 * @param userData
	 *            the user data
	 * @return the tab response to {@inheritDoc}
	 */
	@Override
	public TabResponseTo makeTabBetType(RtMatch match, UserData userData) {
		TabResponseTo result = new TabResponseTo();

		List<CfgBetType> betTypes = getBetTypesFromMatchs(match);
		LOG.debug(new StringBuffer("Se recuperan ")
				.append(betTypes.size())
				.append(" bet types totales para ser filtradas segun tipo de vista"));
		List<CfgBetType> betTypesKept = getBetTypesKept(betTypes);
		LOG.debug(new StringBuffer("Se recuperan ").append(betTypesKept.size())
				.append(" bet types totales filtradas"));

		result.setTabs(getTabResponseToList(betTypesKept, userData));
		return result;
	}

	private List<TabResponseDataTo> getTabResponseToList(
			List<CfgBetType> cfgBetTypes, UserData userData) {
		List<TabResponseDataTo> tabs = new ArrayList<TabResponseDataTo>();
		TabResponseDataTo tab;
		Collections.sort(cfgBetTypes, new BetTypePriorityComparator());
		for (CfgBetType betType : cfgBetTypes) {
			tab = new TabResponseDataTo();
			tab.setId(new ObjectToId(betType.getObjectId().toString()));
			tab.setName(betType.getName(userData.getLocale()));
			tabs.add(tab);
		}
		return tabs;
	}

	/**
	 * Gets the bet types kept.
	 * 
	 * @param betTypes
	 *            the bet types
	 * @return the bet types kept
	 */
	protected abstract List<CfgBetType> getBetTypesKept(
			List<CfgBetType> betTypes);

	/**
	 * Gets the bet types from matchs.
	 * 
	 * @param matchs
	 *            the matchs
	 * @return the bet types from matchs
	 */
	private List<CfgBetType> getBetTypesFromMatchs(List<RtMatch> matchs) {
		List<CfgBetType> result = new ArrayList<CfgBetType>();
		for (RtMatch match : matchs) {
			for (RtMarket market : match.getRtMarkets()) {
				if ( ( market.getBetTypeEvent().getBetTypeEvent().getNameId()
						.equals(CfgBetTypeEvent.CfgBetTypeEventId.PARTIDO_COMPLETO
								.nameId()) || 
					   market.getBetTypeEvent().getBetTypeEvent().getNameId()
							.equals(CfgBetTypeEvent.CfgBetTypeEventId.PARTIDO_COMPLETO_PRORROGA
									.nameId()) ||
					 (market.getBetType().getNameId().equals(CfgBetTypeId.UNO_X_DOS.nameId()))
					 )
					 &&
					 (market.getBetType().getNameId().equals(CfgBetTypeId.UNO_X_DOS.nameId()) || 
							 market.getBetType().getNameId().equals(CfgBetTypeId.GANADOR_PARTIDO.nameId()))
					 && (!result.contains(market.getBetType())) ) {
					result.add(market.getBetType());
				}
			}
		}
		return result;
	}

	/**
	 * Gets the bet types from matchs.
	 * 
	 * @param match
	 *            the match
	 * @return the bet types from matchs
	 */
	private List<CfgBetType> getBetTypesFromMatchs(RtMatch match) {
		List<CfgBetType> result = new ArrayList<CfgBetType>();
		for (RtMarket market : match.getRtMarkets()) {
			if (!result.contains(market.getBetType())) {
				result.add(market.getBetType());
			}
		}
		return result;
	}
}
