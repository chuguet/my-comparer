/**
 *
 * Copyright (C) FACTORIA ETSIA S.L.
 * All Rights Reserved.
 * www.factoriaetsia.com
 *
 */
package com.comparadorad.bet.comparer.web.client.gwt.results.ui.sport.service;

import javax.ws.rs.Path;

import org.fusesource.restygwt.client.RestService;

@Path("/rest/sportCountriesController")
public interface SportCountriesService extends RestService,
		ISportCountriesService {
}