/**
 *
 * Copyright (C) FACTORIA ETSIA S.L.
 * All Rights Reserved.
 * www.factoriaetsia.com
 *
 */
package com.comparadorad.bet.comparer.web.client.gwt.results.ui.sport.service;

import java.util.List;

import javax.ws.rs.POST;
import javax.ws.rs.Path;

import org.fusesource.restygwt.client.MethodCallback;

import com.comparadorad.bet.comparer.web.client.gwt.common.bean.HeadResponseTo;
import com.comparadorad.bet.comparer.web.client.gwt.common.bean.cfg.request.SportRequestTo;
import com.comparadorad.bet.comparer.web.client.gwt.common.bean.table.TableResponseTo;
import com.comparadorad.bet.comparer.web.client.gwt.core.service.IService;

public interface ISportCountriesService extends IService {

	@POST
	@Path("/getHead")
	void getHead(SportRequestTo sportRequestTo,
			MethodCallback<HeadResponseTo> pCallback);
	
	@POST
	@Path("/getSportCountriesCountries")
	void getSportCountriesCountries(SportRequestTo sportRequestTo,
			MethodCallback<TableResponseTo> callback);
	
	@POST
	@Path("/getSportCountriesCompetitions")
	void getSportCountriesCompetitions(SportRequestTo sportRequestTo,
			MethodCallback<TableResponseTo> callback);
	
	@POST
	@Path("/getSportCountriesEvents")
	void getSportCountriesBetOdds(SportRequestTo sportRequestTo,
			MethodCallback<List<TableResponseTo>> callback);

}
