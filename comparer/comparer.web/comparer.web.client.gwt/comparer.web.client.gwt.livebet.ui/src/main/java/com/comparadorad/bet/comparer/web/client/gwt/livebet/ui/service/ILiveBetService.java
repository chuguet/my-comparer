/**
 *
 * Copyright (C) FACTORIA ETSIA S.L.
 * All Rights Reserved.
 * www.factoriaetsia.com
 *
 */
package com.comparadorad.bet.comparer.web.client.gwt.livebet.ui.service;

import java.util.List;

import javax.ws.rs.POST;
import javax.ws.rs.Path;

import org.fusesource.restygwt.client.MethodCallback;

import com.comparadorad.bet.comparer.web.client.gwt.common.bean.table.TableResponseTo;
import com.comparadorad.bet.comparer.web.client.gwt.core.service.IService;
import com.comparadorad.bet.comparer.web.client.gwt.livebet.bean.request.LiveBetRequestTo;

/**
 * The Interface ILiveBetService.
 */
public interface ILiveBetService extends IService {

	/**
	 * Gets the live bet.
	 * 
	 * @param request
	 *            the request
	 * @param pCallback
	 *            the callback
	 * @return the live bet
	 */
	@POST
	@Path("/getLiveBet")
	void getLiveBet(LiveBetRequestTo request,
			MethodCallback<List<TableResponseTo>> pCallback);

}