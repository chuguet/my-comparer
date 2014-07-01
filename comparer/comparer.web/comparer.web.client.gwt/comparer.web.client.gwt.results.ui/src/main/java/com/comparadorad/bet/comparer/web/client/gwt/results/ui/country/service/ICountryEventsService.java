/**
 *
 * Copyright (C) FACTORIA ETSIA S.L.
 * All Rights Reserved.
 * www.factoriaetsia.com
 *
 */
package com.comparadorad.bet.comparer.web.client.gwt.results.ui.country.service;

import java.util.List;

import javax.ws.rs.POST;
import javax.ws.rs.Path;

import org.fusesource.restygwt.client.MethodCallback;

import com.comparadorad.bet.comparer.web.client.gwt.common.bean.HeadResponseTo;
import com.comparadorad.bet.comparer.web.client.gwt.common.bean.cfg.request.CountryRequestTo;
import com.comparadorad.bet.comparer.web.client.gwt.common.bean.table.TableResponseTo;
import com.comparadorad.bet.comparer.web.client.gwt.core.service.IService;

/**
 * The Interface ICountryCompetitionOddsService.
 */
public interface ICountryEventsService extends IService {

	@POST
	@Path("/getHead")
	void getHead(CountryRequestTo pViewToCountry,
			MethodCallback<HeadResponseTo> pCallback);
	
	@POST
	@Path("/getCountryEventsCompetition")
	void getCountryEventsCompetition(CountryRequestTo pViewToCountry,
			MethodCallback<TableResponseTo> pCallback);
	
	@POST
	@Path("/getCountryEventsEvent")
	void getCountryEventsEvent(CountryRequestTo pViewToCountry,
			MethodCallback<List<TableResponseTo>> pCallback);
}
