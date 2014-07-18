/**
 *
 * Copyright (C) FACTORIA ETSIA S.L.
 * All Rights Reserved.
 * www.factoriaetsia.com
 *
 */
package com.comparadorad.bet.comparer.web.server.mvc.valuebet.control.factory;

import java.util.Date;

import com.comparadorad.bet.comparer.model.bet.bean.RtBet;
import com.comparadorad.bet.comparer.model.config.bean.CfgBetType;
import com.comparadorad.bet.comparer.model.core.bean.user.UserData;
import com.comparadorad.bet.comparer.model.valuebet.bean.InfoMatch;
import com.comparadorad.bet.comparer.util.commons.betOdds.FormatterUtil;
import com.comparadorad.bet.comparer.web.client.gwt.common.bean.LinkTo;
import com.comparadorad.bet.comparer.web.client.gwt.common.bean.ObjectToId;
import com.comparadorad.bet.comparer.web.client.gwt.common.bean.ValueTo;
import com.comparadorad.bet.comparer.web.client.gwt.common.bean.table.TableResponseCellTo;
import com.comparadorad.bet.comparer.web.server.mvc.core.beans.DateUtilJava;

/**
 * A factory for creating AbstractTableValuebet objects.
 */
public abstract class AbstractTableValuebetFactory implements IValueFactory {

	/** The Constant EMPATE. */
	private static final String EMPATE = "Empate";// TODO: Esto tiene que tener
													// I18N.............

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

	public TableResponseCellTo getBetTypeCell(final RtBet bet,
			final UserData userData) {
		TableResponseCellTo result = new TableResponseCellTo();
		ValueTo valueTo = new ValueTo();
		StringBuffer buff;

		if (bet.getBetType() != null) {
			buff = new StringBuffer(bet.getBetType().getName(
					userData.getLocale()));
			if (bet.getAttribute().getFinalValue() != null) {
				buff.append("|").append(
						FormatterUtil.formatBetHandicap(bet.getAttribute()
								.getFinalValue()));
			}
			valueTo.setValueStr(buff.toString());
			result.setValueTo(valueTo);
		}

		return result;
	}

	public TableResponseCellTo makeResulCell(final RtBet bet,
			final UserData userData) {
		TableResponseCellTo result = new TableResponseCellTo();
		ValueTo valueTo = new ValueTo();

		if (bet.getParticipant().getCfgParticipant() != null) {
			valueTo.setValueStr(bet.getParticipant().getCfgParticipant()
					.getName(userData.getLocale()));
		} else {
			valueTo.setValueStr(EMPATE);
		}

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
			final RtBet bet);

	public abstract CfgBetType.CfgBetTypeId getBetType();

}
