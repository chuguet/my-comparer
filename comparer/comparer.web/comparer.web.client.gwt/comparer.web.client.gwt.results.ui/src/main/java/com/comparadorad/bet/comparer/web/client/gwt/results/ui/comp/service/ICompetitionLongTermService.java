/**
 *
 * Copyright (C) FACTORIA ETSIA S.L.
 * All Rights Reserved.
 * www.factoriaetsia.com
 *
 */
package com.comparadorad.bet.comparer.web.client.gwt.results.ui.comp.service;

import javax.ws.rs.POST;
import javax.ws.rs.Path;

import org.fusesource.restygwt.client.MethodCallback;

import com.comparadorad.bet.comparer.web.client.gwt.common.bean.HeadResponseTo;
import com.comparadorad.bet.comparer.web.client.gwt.common.bean.cfg.request.CompetitionRequestTo;
import com.comparadorad.bet.comparer.web.client.gwt.common.bean.table.TableResponseTo;
import com.comparadorad.bet.comparer.web.client.gwt.core.service.IService;

/**
 * The Interface ICompetitionLongTermService.
 */
public interface ICompetitionLongTermService extends IService {

	/**
	 * Gets the bet odds.
	 * 
	 * @param viewToCompetition
	 *            the view to competition
	 * @param callback
	 *            the callback
	 * @return the bet odds
	 */
	@POST
	@Path("/getBetOdds")
	void getBetOdds(CompetitionRequestTo viewToCompetition,
			MethodCallback<TableResponseTo> callback);

	/**
	 * Gets the bet types.
	 * 
	 * @param viewToCompetition
	 *            the view to competition
	 * @param callback
	 *            the callback
	 * @return the bet types
	 */
	@POST
	@Path("/getBetTypes")
	void getBetTypes(CompetitionRequestTo viewToCompetition,
			MethodCallback<TableResponseTo> callback);

	/**
	 * Gets the head.
	 * 
	 * @param viewToCompetition
	 *            the view to competition
	 * @param callback
	 *            the callback
	 * @return the head
	 */
	@POST
	@Path("/getHead")
	void getHead(CompetitionRequestTo viewToCompetition,
			MethodCallback<HeadResponseTo> callback);

	/**
	 * Gets the long term events.
	 * 
	 * @param viewToCompetition
	 *            the view to competition
	 * @param callback
	 *            the callback
	 * @return the long term events
	 */
	@POST
	@Path("/getMatchs")
	void getLongTermEvents(CompetitionRequestTo viewToCompetition,
			MethodCallback<TableResponseTo> callback);

}
