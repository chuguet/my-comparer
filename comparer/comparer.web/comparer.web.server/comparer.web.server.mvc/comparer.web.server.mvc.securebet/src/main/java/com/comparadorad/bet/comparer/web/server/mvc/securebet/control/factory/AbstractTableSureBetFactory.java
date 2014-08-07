/**
 *
 * Copyright (C) FACTORIA ETSIA S.L.
 * All Rights Reserved.
 * www.factoriaetsia.com
 *
 */
package com.comparadorad.bet.comparer.web.server.mvc.securebet.control.factory;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Set;

import com.comparadorad.bet.comparer.model.bet.bean.RtBet;
import com.comparadorad.bet.comparer.model.config.bean.CfgBetType;
import com.comparadorad.bet.comparer.model.config.bean.CfgBetTypeEvent;
import com.comparadorad.bet.comparer.model.core.bean.user.UserData;
import com.comparadorad.bet.comparer.model.securebet.bean.InfoMatch;
import com.comparadorad.bet.comparer.util.commons.betOdds.FormatterUtil;
import com.comparadorad.bet.comparer.web.client.gwt.common.bean.ExternalLinkTo;
import com.comparadorad.bet.comparer.web.client.gwt.common.bean.LinkTo;
import com.comparadorad.bet.comparer.web.client.gwt.common.bean.ObjectToId;
import com.comparadorad.bet.comparer.web.client.gwt.common.bean.ValueTo;
import com.comparadorad.bet.comparer.web.client.gwt.common.bean.table.TableResponseCellTo;
import com.comparadorad.bet.comparer.web.server.mvc.core.beans.DateUtilJava;
import com.comparadorad.bet.comparer.web.server.redirection.conversor.IUrlConversor;
import com.comparadorad.bet.comparer.web.server.redirection.factory.IUrlFactory;

/**
 * A factory for creating AbstractTableValuebet objects.
 */
public abstract class AbstractTableSureBetFactory implements IValueFactory {

	protected static int NUMBER_DIGITS_BET_FORMAT = 2;

	public TableResponseCellTo makeEventCell(String betTypeEventId,
			final InfoMatch match, final UserData userData) {
		TableResponseCellTo result = new TableResponseCellTo();
		ValueTo valueTo = new ValueTo();
		LinkTo linkTo = new LinkTo();

		Date auxDate = DateUtilJava
				.convertSistemDependentDateToDesiredTimeZone(match.getDate(),
						userData.getTimeZone());
		valueTo.setDate(DateUtilJava.dateTimeToString(auxDate));
		result.setValueTo(valueTo);

		linkTo.setObjectToId(new ObjectToId(match.getObjectId().toString()));
		linkTo.setObjectToIdAux(new ObjectToId(getBetType().id()));
		linkTo.setObjectToIdAux2(new ObjectToId(betTypeEventId));
		linkTo.setName(new StringBuffer()
				.append(match.getName().getI18nField(userData.getLocale())
						.getString())
				.append("|")
				.append(match.getCompetition().getSport()
						.getName(userData.getLocale()))
				.append("|")
				.append(match.getCompetition().getRegion()
						.getName(userData.getLocale())).append("|")
				.append(match.getCompetition().getName(userData.getLocale()))
				.toString());
		result.setLinkTo(linkTo);

		return result;
	}

	public TableResponseCellTo getBetTypeCell(final CfgBetType betType,
			final CfgBetTypeEvent betTypeEvent, final RtBet bet,
			final UserData userData) {
		TableResponseCellTo result = new TableResponseCellTo();
		ValueTo valueTo = new ValueTo();
		StringBuffer buff;
		
		buff = new StringBuffer(betType.getName(userData.getLocale()));
		if (bet.getAttribute().getFinalValue() != null) {
			buff.append("|").append(
					FormatterUtil.formatBetHandicap(bet.getAttribute()
							.getFinalValue()));
		}
		buff.append("|").append(betTypeEvent.getName(userData.getLocale()));
		valueTo.setValueStr(buff.toString());
		result.setValueTo(valueTo);

		return result;
	}

	/**
	 * Make object id.
	 * 
	 * @param match
	 *            the match
	 * @param bet
	 *            the bet
	 * @return the object to id
	 */
	public abstract ObjectToId makeObjectId(final InfoMatch match,
			final Date date, int index);

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.comparadorad.bet.comparer.web.server.mvc.valuebet.control.factory
	 * .IValueFactory#getBetType()
	 */
	public abstract CfgBetType.CfgBetTypeId getBetType();

	public TableResponseCellTo getbets(Set<RtBet> bets, IUrlFactory urlFactory) {
		TableResponseCellTo result = new TableResponseCellTo();
		List<ExternalLinkTo> externalLinkToList = new ArrayList<ExternalLinkTo>();
		ExternalLinkTo externalLinkTo;
		List<RtBet> ordernateBets = getBetsInOrder(bets);
		for (RtBet rtBet : ordernateBets) {
			externalLinkTo = new ExternalLinkTo();
			String formattedBet = FormatterUtil.formatBet(rtBet.getBetOdd()
					.getOdds(), NUMBER_DIGITS_BET_FORMAT);
			externalLinkTo.setLinkText(formattedBet);
			IUrlConversor conversor = urlFactory.makeUrlConversor(rtBet
					.getBookmaker().getObjectId().toString());
			externalLinkTo.setUrl(conversor.makeUrl(rtBet.getWebUrl().getUrl(),
					rtBet.getBookmaker().getBookmakerConfiguration()
							.getIdAfiliado()));
			externalLinkTo.setActionAnalytics(rtBet.getBookmaker().getNameId());
			externalLinkTo.setCategoryAnalytics("surebets");

			externalLinkToList.add(externalLinkTo);

		}
		result.setExternalLinkToList(externalLinkToList);
		return result;
	}

	public TableResponseCellTo getBookmakers(Set<RtBet> bets,
			IUrlFactory urlFactory) {

		TableResponseCellTo result = new TableResponseCellTo();
		List<ExternalLinkTo> externalLinkToList = new ArrayList<ExternalLinkTo>();
		ExternalLinkTo externalLinkTo;
		List<RtBet> ordernateBets = getBetsInOrder(bets);
		for (RtBet rtBet : ordernateBets) {
			externalLinkTo = new ExternalLinkTo();
			externalLinkTo.setLinkImgLocation(rtBet.getBookmaker()
					.getResourceSmallImg().getLocation());
			IUrlConversor conversor = urlFactory.makeUrlConversor(rtBet
					.getBookmaker().getObjectId().toString());
			externalLinkTo.setUrl(conversor.makeUrl(rtBet.getWebUrl().getUrl(),
					rtBet.getBookmaker().getBookmakerConfiguration()
							.getIdAfiliado()));
			externalLinkTo.setActionAnalytics(rtBet.getBookmaker().getNameId());
			externalLinkTo.setCategoryAnalytics("surebets");
			externalLinkToList.add(externalLinkTo);
		}
		result.setExternalLinkToList(externalLinkToList);
		return result;
	}

	protected List<RtBet> getBetsInOrder(Set<RtBet> bets) {
		RtBet bet1 = null;
		RtBet betX = null;
		RtBet bet2 = null;
		List<RtBet> result = new ArrayList<RtBet>();
		for (RtBet rtBet : bets) {
			if (rtBet.getParticipant().isHomeParticipant()
					&& !rtBet.getParticipant().isAwayParticipant()) {
				bet1 = rtBet;
			}
			if (!rtBet.getParticipant().isHomeParticipant()
					&& !rtBet.getParticipant().isAwayParticipant()) {
				betX = rtBet;
			}
			if (!rtBet.getParticipant().isHomeParticipant()
					&& rtBet.getParticipant().isAwayParticipant()) {
				bet2 = rtBet;
			}
		}
		if (bet1 != null) {
			result.add(bet1);
		}
		if (betX != null) {
			result.add(betX);
		}
		if (bet2 != null) {
			result.add(bet2);
		}
		return result;
	}

}
