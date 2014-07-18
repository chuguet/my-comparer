/**
 *
 * Copyright (C) FACTORIA ETSIA S.L.
 * All Rights Reserved.
 * www.factoriaetsia.com
 *
 */
package com.comparadorad.bet.comparer.web.client.gwt.valuebet.ui.service;

import javax.ws.rs.POST;
import javax.ws.rs.Path;

import org.fusesource.restygwt.client.MethodCallback;

import com.comparadorad.bet.comparer.web.client.gwt.core.service.IService;
import com.comparadorad.bet.comparer.web.client.gwt.valuebet.bean.request.ValueBetRequestTo;
import com.comparadorad.bet.comparer.web.client.gwt.valuebet.bean.response.ValueBetResponseTo;

public interface IValueBetService extends IService {

	@POST
	@Path("/getValueBet")
	void getValueBet(ValueBetRequestTo valueBetRequestTo,
			MethodCallback<ValueBetResponseTo> pCallback);
}
