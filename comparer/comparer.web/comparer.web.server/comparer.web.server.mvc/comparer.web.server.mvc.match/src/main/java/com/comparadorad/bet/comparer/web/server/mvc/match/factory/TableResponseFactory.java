/**
 *
 * Copyright (C) FACTORIA ETSIA S.L.
 * All Rights Reserved.
 * www.factoriaetsia.com
 *
 */
package com.comparadorad.bet.comparer.web.server.mvc.match.factory;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.comparadorad.bet.comparer.model.config.bean.CfgBetType;
import com.comparadorad.bet.comparer.web.server.mvc.core.beans.InformationWindow;
import com.comparadorad.bet.comparer.web.server.mvc.match.enums.LevelType;
import com.comparadorad.bet.comparer.web.server.mvc.match.table.competition.tablongterm.IMakeTableCompetitionLT;
import com.comparadorad.bet.comparer.web.server.mvc.match.table.country.tablongterm.IMakeTableCountryLT;
import com.comparadorad.bet.comparer.web.server.mvc.match.table.event.tabevent.IMakeTableEvent;
import com.comparadorad.bet.comparer.web.server.mvc.match.table.shortterm.IMakeTableShortTerm;

/**
 * A factory for creating TableResponse objects.
 */
@Service
public class TableResponseFactory extends AbstractObjectResponseFactory {

	/** The make tables competition lt. */
	@Inject
	private List<IMakeTableCompetitionLT> makeTablesCompetitionLT;

	/** The make tables country lt. */
	@Inject
	private List<IMakeTableCountryLT> makeTablesCountryLT;

	/** The make tables event. */
	@Inject
	private List<IMakeTableEvent> makeTablesEvent;

	/** The make tables short term. */
	@Inject
	private List<IMakeTableShortTerm> makeTablesShortTerm;

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.comparadorad.bet.comparer.web.server.mvc.match.factory.
	 * IObjectResponseFactory
	 * #makeTableLTCompetition(com.comparadorad.bet.comparer
	 * .model.config.bean.CfgBetType,
	 * com.comparadorad.bet.comparer.web.server.mvc
	 * .core.beans.InformationWindow)
	 */
	@Override
	public IMakeTableCompetitionLT makeTableCompetitionLT(
			CfgBetType cfgBetType, InformationWindow informationWindow) {
		IMakeTableCompetitionLT table = null;
		for (IMakeTableCompetitionLT makeTable : makeTablesCompetitionLT) {
			if (makeTable.getBetTypeId().nameId()
					.equals(cfgBetType.getNameId())) {
				table = makeTable;
				break;
			}
		}
		return table;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.comparadorad.bet.comparer.web.server.mvc.match.factory.
	 * IObjectResponseFactory
	 * #makeTableCountryLongTerm(com.comparadorad.bet.comparer
	 * .model.config.bean.CfgBetType,
	 * com.comparadorad.bet.comparer.web.server.mvc
	 * .core.beans.InformationWindow)
	 */
	@Override
	public IMakeTableCountryLT makeTableCountryLT(CfgBetType cfgBetType,
			InformationWindow informationWindow) {
		IMakeTableCountryLT table = null;
		for (IMakeTableCountryLT makeTable : makeTablesCountryLT) {
			if (makeTable.getBetTypeId().nameId()
					.equals(cfgBetType.getNameId())) {
				table = makeTable;
				break;
			}
		}
		return table;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.comparadorad.bet.comparer.web.server.mvc.match.factory.
	 * IObjectResponseFactory
	 * #makeTableEvent(com.comparadorad.bet.comparer.model.
	 * config.bean.CfgBetType,
	 * com.comparadorad.bet.comparer.web.server.mvc.core.
	 * beans.InformationWindow)
	 */
	@Override
	public IMakeTableEvent makeTableEvent(CfgBetType cfgBetType,
			InformationWindow informationWindow) {
		IMakeTableEvent table = null;
		for (IMakeTableEvent makeTable : makeTablesEvent) {
			if (makeTable.getBetTypeId().nameId()
					.equals(cfgBetType.getNameId())) {
				table = makeTable;
				break;
			}
		}
		return table;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.comparadorad.bet.comparer.web.server.mvc.match.factory.
	 * IObjectResponseFactory
	 * #makeTableSport(com.comparadorad.bet.comparer.model.
	 * config.bean.CfgBetType,
	 * com.comparadorad.bet.comparer.web.server.mvc.core.
	 * beans.InformationWindow)
	 */
	@Override
	public IMakeTableShortTerm makeTableShortTerm(CfgBetType cfgBetType,
			LevelType levelType, InformationWindow informationWindow) {
		IMakeTableShortTerm table = null;
		for (IMakeTableShortTerm makeTable : makeTablesShortTerm) {
			if (makeTable.getBetTypeId().nameId()
					.equals(cfgBetType.getNameId())
					&& makeTable.getLevelType().equals(levelType)) {
				table = makeTable;
				break;
			}
		}
		return table;
	}

}
