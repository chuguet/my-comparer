/**
 *
 * Copyright (C) FACTORIA ETSIA S.L.
 * All Rights Reserved.
 * www.factoriaetsia.com
 *
 */
package com.comparadorad.bet.comparer.web.client.gwt.securebet.ui.service;

import javax.ws.rs.POST;
import javax.ws.rs.Path;

import org.fusesource.restygwt.client.MethodCallback;

import com.comparadorad.bet.comparer.web.client.gwt.core.service.IService;
import com.comparadorad.bet.comparer.web.client.gwt.securebet.bean.request.SureBetRequestTo;
import com.comparadorad.bet.comparer.web.client.gwt.securebet.bean.response.SureBetResponseTo;

/**
 * The Interface ISecureBetService.
 */
public interface ISecureBetService extends IService {

	/**
	 * Gets the secure bet controller.
	 * 
	 * @param secureBetRequestTo
	 *            the secure bet request to
	 * @param pCallback
	 *            the callback
	 * @return the secure bet controller
	 */
	@POST
	@Path("/getAllSureBet")
	void getAllSureBet(SureBetRequestTo secureBetRequestTo,
			MethodCallback<SureBetResponseTo> pCallback);

	/**
	 * Gets the one sure bet.
	 * 
	 * @param secureBetRequestTo
	 *            the secure bet request to
	 * @param pCallback
	 *            the callback
	 * @return the one sure bet
	 */
	@POST
	@Path("/getOneSureBet")
	void getOneSureBet(SureBetRequestTo secureBetRequestTo,
			MethodCallback<SureBetResponseTo> pCallback);
}
