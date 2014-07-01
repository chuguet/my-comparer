/**
 *
 * Copyright (C) FACTORIA ETSIA S.L.
 * All Rights Reserved.
 * www.factoriaetsia.com
 *
 */
package com.comparadorad.bet.comparer.web.client.gwt.results.ui.country.service;

import javax.ws.rs.Path;

import org.fusesource.restygwt.client.RestService;

/**
 * The Interface CountryCompetitionOddsService.
 */
@Path("/rest/countryEventsController")
public interface CountryEventsService extends RestService,
		ICountryEventsService {

}
