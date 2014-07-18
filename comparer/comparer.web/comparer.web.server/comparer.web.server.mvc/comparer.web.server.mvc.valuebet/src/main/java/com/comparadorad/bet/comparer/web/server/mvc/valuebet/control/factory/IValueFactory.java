/**
 *
 * Copyright (C) FACTORIA ETSIA S.L.
 * All Rights Reserved.
 * www.factoriaetsia.com
 *
 */
package com.comparadorad.bet.comparer.web.server.mvc.valuebet.control.factory;

import com.comparadorad.bet.comparer.model.bet.bean.RtBet;
import com.comparadorad.bet.comparer.model.config.bean.CfgBetType;
import com.comparadorad.bet.comparer.model.core.bean.user.UserData;
import com.comparadorad.bet.comparer.model.valuebet.bean.InfoMatch;
import com.comparadorad.bet.comparer.web.client.gwt.common.bean.ObjectToId;
import com.comparadorad.bet.comparer.web.client.gwt.common.bean.table.TableResponseCellTo;

/**
 * A factory for creating IValue objects.
 */
public interface IValueFactory {

	/**
	 * Make event cell.
	 *
	 * @param bet the bet
	 * @param match the match
	 * @param userData the user data
	 * @return the table response cell to
	 */
	public TableResponseCellTo makeEventCell(final String betTypeEvent, final InfoMatch match,final UserData userData);

	/**
	 * Gets the bet type cell.
	 *
	 * @param bet the bet
	 * @param userData the user data
	 * @return the bet type cell
	 */
	public TableResponseCellTo getBetTypeCell(final RtBet bet,final UserData userData);
	
	/**
	 * Make resul cell.
	 *
	 * @param bet the bet
	 * @param userData the user data
	 * @return the table response cell to
	 */
	public TableResponseCellTo makeResulCell(final RtBet bet,final UserData userData);

	/**
	 * Make object id.
	 *
	 * @param match the match
	 * @param bet the bet
	 * @return the object to id
	 */
	public ObjectToId makeObjectId(final InfoMatch match,final RtBet bet );
	/**
	 * Gets the bet type.
	 *
	 * @return the bet type
	 */
	public CfgBetType.CfgBetTypeId getBetType();


}
