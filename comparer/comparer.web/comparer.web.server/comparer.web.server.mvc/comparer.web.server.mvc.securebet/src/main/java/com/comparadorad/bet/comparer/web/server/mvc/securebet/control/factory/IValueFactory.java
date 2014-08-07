/**
 *
 * Copyright (C) FACTORIA ETSIA S.L.
 * All Rights Reserved.
 * www.factoriaetsia.com
 *
 */
package com.comparadorad.bet.comparer.web.server.mvc.securebet.control.factory;

import java.util.Date;
import java.util.Set;

import com.comparadorad.bet.comparer.model.bet.bean.RtBet;
import com.comparadorad.bet.comparer.model.config.bean.CfgBetType;
import com.comparadorad.bet.comparer.model.config.bean.CfgBetTypeEvent;
import com.comparadorad.bet.comparer.model.core.bean.user.UserData;
import com.comparadorad.bet.comparer.model.securebet.bean.InfoMatch;
import com.comparadorad.bet.comparer.web.client.gwt.common.bean.ObjectToId;
import com.comparadorad.bet.comparer.web.client.gwt.common.bean.table.TableResponseCellTo;
import com.comparadorad.bet.comparer.web.server.redirection.factory.IUrlFactory;

/**
 * A factory for creating IValue objects.
 */
public interface IValueFactory {

	/**
	 * Make event cell.
	 * 
	 * @param match
	 *            the match
	 * @param userData
	 *            the user data
	 * @return the table response cell to
	 */
	public TableResponseCellTo makeEventCell(final String betTypeEvent,
			final InfoMatch match, final UserData userData);

	/**
	 * Gets the bet type cell.
	 * 
	 * @param bet
	 *            the bet
	 * @param userData
	 *            the user data
	 * @return the bet type cell
	 */
	public TableResponseCellTo getBetTypeCell(final CfgBetType betType,
			final CfgBetTypeEvent betTypeEvent, RtBet bet,
			final UserData userData);

	/**
	 * Make object id.
	 * 
	 * @param match
	 *            the match
	 * @param date
	 *            the date
	 * @return the object to id
	 */
	public ObjectToId makeObjectId(final InfoMatch match, final Date date,
			int index);

	/**
	 * Gets the bet type.
	 * 
	 * @return the bet type
	 */
	public CfgBetType.CfgBetTypeId getBetType();

	/**
	 * Gets the bets.
	 * 
	 * @param bets
	 *            the bets
	 * @param urlFactory
	 *            the url factory
	 * @return the bets
	 */
	public TableResponseCellTo getbets(Set<RtBet> bets, IUrlFactory urlFactory);

	/**
	 * Gets the bookmakers.
	 * 
	 * @param bets
	 *            the bets
	 * @param urlFactory
	 *            the url factory
	 * @return the bookmakers
	 */
	public TableResponseCellTo getBookmakers(Set<RtBet> bets,
			IUrlFactory urlFactory);

}
