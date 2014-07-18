/**
 *
 * All Rights Reserved.
 * Copyright (C) FACTORIA ETSIA S.L.
 * www.factoriaetsia.com
 *
 */
package com.comparadorad.bet.comparer.web.server.mvc.match.control;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.TimeZone;

import javax.inject.Inject;

import com.comparadorad.bet.comparer.model.bet.bean.RtMarket;
import com.comparadorad.bet.comparer.model.bet.bean.RtMatch;
import com.comparadorad.bet.comparer.model.bet.service.IRtMatchService;
import com.comparadorad.bet.comparer.model.config.bean.CfgBetType;
import com.comparadorad.bet.comparer.model.config.bean.CfgBetType.CfgBetTypeId;
import com.comparadorad.bet.comparer.web.client.gwt.common.bean.ExternalLinkTo;
import com.comparadorad.bet.comparer.web.client.gwt.common.bean.LinkTo;
import com.comparadorad.bet.comparer.web.client.gwt.common.bean.ObjectToId;
import com.comparadorad.bet.comparer.web.client.gwt.common.bean.ValueTo;
import com.comparadorad.bet.comparer.web.client.gwt.common.bean.cfg.response.ResourceTo;
import com.comparadorad.bet.comparer.web.client.gwt.common.bean.table.TableResponseCellTo;
import com.comparadorad.bet.comparer.web.client.gwt.common.bean.table.TableResponseRowTo;
import com.comparadorad.bet.comparer.web.server.mvc.core.beans.DateUtilJava;
import com.comparadorad.bet.comparer.web.server.mvc.core.control.AbstractComparerController;

/**
 * The Class AbstractOdds.
 */
public abstract class AbstractOdds extends AbstractComparerController {

	/** The match service. */
	@Inject
	private IRtMatchService matchService;

	/** The priority list bet types. */
	protected List<CfgBetTypeId> priorityListBetTypes;

	/**
	 * Filter long term.
	 * 
	 * @param pMatch
	 *            the match
	 * @return the rt match
	 */
	protected RtMatch filterLongTerm(RtMatch pMatch) {
		RtMatch match = new RtMatch();

		if (pMatch.getMatchId().getCompetitionEvent() != null
				&& pMatch.getMatchId().getCompetitionEvent().getLongTerm() != null
				&& pMatch.getMatchId().getCompetitionEvent().getLongTerm()
						.getLongTerm().equals(Boolean.TRUE)) {
			match = pMatch;
		}
		return match;
	}

	/**
	 * Filter short term.
	 * 
	 * @param matchs
	 *            the matchs
	 * @return the list
	 */
	protected List<RtMatch> filterShortTerm(List<RtMatch> matchs) {
		List<RtMatch> result = new ArrayList<RtMatch>();

		for (RtMatch match : matchs) {
			if (match.getMatchId().getCompetitionEvent() != null
					&& match.getMatchId().getCompetitionEvent().getLongTerm() != null
					&& match.getMatchId().getCompetitionEvent().getLongTerm()
							.getLongTerm().equals(Boolean.FALSE)) {
				result.add(match);
			}
		}
		return result;
	}

	/**
	 * Find cfg bet type by id.
	 * 
	 * @param pId
	 *            the id
	 * @param matchs
	 *            the matchs
	 * @return the cfg bet type
	 */
	protected CfgBetType findCfgBetTypeById(String pId, List<RtMatch> matchs) {
		CfgBetType betType = null;
		for (RtMatch match : matchs) {
			for (RtMarket market : match.getRtMarkets()) {
				if (market.getBetType().getObjectId().toString().equals(pId)) {
					betType = market.getBetType();
					break;
				}
			}
		}
		return betType;
	}

	/**
	 * Find cfg bet type by id.
	 * 
	 * @param pId
	 *            the id
	 * @param match
	 *            the match
	 * @return the cfg bet type
	 */
	protected CfgBetType findCfgBetTypeById(String pId, RtMatch match) {
		CfgBetType betType = null;
		for (RtMarket market : match.getRtMarkets()) {
			if (market.getBetType().getObjectId().toString().equals(pId)) {
				betType = market.getBetType();
			}
		}
		return betType;
	}

	/**
	 * Gets the new cell.
	 * 
	 * @param id
	 *            the id
	 * @param value
	 *            the value
	 * @param location
	 *            the location
	 * @param literal
	 *            the literal
	 * @param linkTo
	 *            the link to
	 * @param date
	 *            the date
	 * @param externalLinkTo
	 *            the external link to
	 * @param timeZone
	 *            the time zone
	 * @return the new cell
	 */
	protected TableResponseCellTo getNewCell(final ObjectToId id,
			final String value, final String location, final String literal,
			final LinkTo linkTo, final Date date,
			final ExternalLinkTo externalLinkTo, final TimeZone timeZone) {
		TableResponseCellTo cell = new TableResponseCellTo();
		ValueTo valueTo = new ValueTo();
		if (id != null) {
			cell.setId(id);
		}
		if (value != null) {
			valueTo.setValueStr(value);
		}
		if (location != null) {
			cell.add(new ResourceTo(location));
		}
		if (literal != null) {
			valueTo.setLiteral(literal);
		}
		if (linkTo != null) {
			cell.setLinkTo(linkTo);
		}
		if (date != null) {
			valueTo.setDate(DateUtilJava.dateTimeToString(date));
		}
		if (externalLinkTo != null) {
			cell.setExternalLinkTo(externalLinkTo);
		}
		cell.setValueTo(valueTo);
		return cell;
	}

	/**
	 * Gets the new row.
	 * 
	 * @return the new row
	 */
	protected TableResponseRowTo getNewRow() {
		return new TableResponseRowTo();
	}

	

	/**
	 * Gets the match service.
	 *
	 * @return the match service
	 */
	protected IRtMatchService getMatchService() {
		return matchService;
	}

	/**
	 * Checks if is long term.
	 * 
	 * @param pMatch
	 *            the match
	 * @return true, if is long term
	 */
	protected boolean isLongTerm(RtMatch pMatch) {
		boolean result = false;

		if (pMatch.getMatchId().getCompetitionEvent() != null
				&& pMatch.getMatchId().getCompetitionEvent().getLongTerm() != null
				&& pMatch.getMatchId().getCompetitionEvent().getLongTerm()
						.getLongTerm().equals(Boolean.TRUE)) {
			result = true;
		}
		return result;
	}

	/**
	 * Checks if is long term bet type.
	 * 
	 * @param market
	 *            the market
	 * @return true, if is long term bet type
	 */
	protected boolean isLongTermBetType(RtMarket market) {
		return (market.getBetType().getNameId()
				.equals(CfgBetTypeId.GANADOR.nameId()) || market.getBetType()
				.getNameId().equals(CfgBetTypeId.MAXIMO_GOLEADOR.nameId()));
	}

}