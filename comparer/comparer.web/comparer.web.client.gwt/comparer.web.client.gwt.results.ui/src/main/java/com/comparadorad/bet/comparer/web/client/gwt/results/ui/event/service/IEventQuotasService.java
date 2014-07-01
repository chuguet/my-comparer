/**
 *
 * Copyright (C) FACTORIA ETSIA S.L.
 * All Rights Reserved.
 * www.factoriaetsia.com
 *
 */
package com.comparadorad.bet.comparer.web.client.gwt.results.ui.event.service;

import java.util.List;

import javax.ws.rs.POST;
import javax.ws.rs.Path;

import org.fusesource.restygwt.client.MethodCallback;

import com.comparadorad.bet.comparer.web.client.gwt.common.bean.HeadResponseTo;
import com.comparadorad.bet.comparer.web.client.gwt.common.bean.cfg.request.EventRequestTo;
import com.comparadorad.bet.comparer.web.client.gwt.common.bean.tab.response.TabResponseTo;
import com.comparadorad.bet.comparer.web.client.gwt.common.bean.table.TableResponseTo;
import com.comparadorad.bet.comparer.web.client.gwt.core.service.IService;

/**
 * The Interface IEventQuotasService.
 */
public interface IEventQuotasService extends IService {

	/**
	 * Gets the bet odds.
	 * 
	 * @param eventRequestTo
	 *            the event request to
	 * @param callback
	 *            the callback
	 * @return the bet odds
	 */
	@POST
	@Path("/getBetOdds")
	void getBetOdds(EventRequestTo eventRequestTo,
			MethodCallback<List<TableResponseTo>> callback);

	/**
	 * Gets the bet type event.
	 * 
	 * @param eventRequestTo
	 *            the event request to
	 * @param callback
	 *            the callback
	 * @return the bet type event
	 */
	@POST
	@Path("/getBetTypeEvent")
	void getBetTypeEvent(EventRequestTo eventRequestTo,
			MethodCallback<TabResponseTo> callback);

	/**
	 * Gets the bet types.
	 * 
	 * @param eventRequestTo
	 *            the event request to
	 * @param callback
	 *            the callback
	 * @return the bet types
	 */
	@POST
	@Path("/getBetTypes")
	void getBetTypes(EventRequestTo eventRequestTo,
			MethodCallback<TabResponseTo> callback);

	/**
	 * Gets the head.
	 * 
	 * @param eventRequestTo
	 *            the event request to
	 * @param callback
	 *            the callback
	 * @return the head
	 */
	@POST
	@Path("/getHead")
	void getHead(EventRequestTo eventRequestTo,
			MethodCallback<HeadResponseTo> callback);

}
