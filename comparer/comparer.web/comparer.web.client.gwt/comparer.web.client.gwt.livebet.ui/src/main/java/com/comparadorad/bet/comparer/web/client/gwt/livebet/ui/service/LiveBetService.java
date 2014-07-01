/**
 *
 * Copyright (C) FACTORIA ETSIA S.L.
 * All Rights Reserved.
 * www.factoriaetsia.com
 *
 */
package com.comparadorad.bet.comparer.web.client.gwt.livebet.ui.service;

import javax.ws.rs.Path;

import org.fusesource.restygwt.client.RestService;

/**
 * The Interface SecureBetService.
 */
@Path("/rest/liveBetController")
public interface LiveBetService extends RestService, ILiveBetService {

}
