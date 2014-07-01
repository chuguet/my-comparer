package com.comparadorad.bet.comparer.web.client.gwt.results.ui.comp.service;

import javax.ws.rs.Path;

import org.fusesource.restygwt.client.RestService;

@Path("/rest/competitionEventController")
public interface CompetitionEventsService extends RestService,
		ICompetitionEventsService {
}
