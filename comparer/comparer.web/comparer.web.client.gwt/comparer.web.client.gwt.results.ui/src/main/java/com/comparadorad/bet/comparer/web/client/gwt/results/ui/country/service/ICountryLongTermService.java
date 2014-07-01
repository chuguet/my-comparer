/**
 *
 * Copyright (C) FACTORIA ETSIA S.L.
 * All Rights Reserved.
 * www.factoriaetsia.com
 *
 */
package com.comparadorad.bet.comparer.web.client.gwt.results.ui.country.service;

import javax.ws.rs.POST;
import javax.ws.rs.Path;

import org.fusesource.restygwt.client.MethodCallback;

import com.comparadorad.bet.comparer.web.client.gwt.common.bean.HeadResponseTo;
import com.comparadorad.bet.comparer.web.client.gwt.common.bean.cfg.request.CountryRequestTo;
import com.comparadorad.bet.comparer.web.client.gwt.common.bean.table.TableResponseTo;
import com.comparadorad.bet.comparer.web.client.gwt.core.service.IService;

/**
 * The Interface ICountryCompetitionLongTermService.
 */
public interface ICountryLongTermService extends IService {

	@POST
	@Path("/getHead")
	void getHead(CountryRequestTo pViewToCountry,
			MethodCallback<HeadResponseTo> pCallback);
	
	@POST
	@Path("/getCountryLongTermCompetition")
	void getCountryLongTermCompetition(CountryRequestTo pViewToCountry,
			MethodCallback<TableResponseTo> pCallback);

	@POST
	@Path("/getCountryLongTermBetType")
	void getCountryLongTermBetType(CountryRequestTo pViewToCountry,
			MethodCallback<TableResponseTo> pCallback);
	
	@POST
	@Path("/getCountryLongTermEvent")
	void getCountryLongTermEvent(CountryRequestTo pViewToCountry,
			MethodCallback<TableResponseTo> pCallback);

}
