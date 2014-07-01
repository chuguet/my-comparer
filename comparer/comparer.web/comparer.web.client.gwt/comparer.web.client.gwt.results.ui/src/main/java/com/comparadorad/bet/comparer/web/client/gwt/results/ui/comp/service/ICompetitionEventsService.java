/**
 *
 * Copyright (C) FACTORIA ETSIA S.L.
 * All Rights Reserved.
 * www.factoriaetsia.com
 *
 */
package com.comparadorad.bet.comparer.web.client.gwt.results.ui.comp.service;

import java.util.List;

import javax.ws.rs.POST;
import javax.ws.rs.Path;

import org.fusesource.restygwt.client.MethodCallback;

import com.comparadorad.bet.comparer.web.client.gwt.common.bean.HeadResponseTo;
import com.comparadorad.bet.comparer.web.client.gwt.common.bean.cfg.request.CompetitionRequestTo;
import com.comparadorad.bet.comparer.web.client.gwt.common.bean.tab.response.TabResponseTo;
import com.comparadorad.bet.comparer.web.client.gwt.common.bean.table.TableResponseTo;
import com.comparadorad.bet.comparer.web.client.gwt.core.service.IService;

public interface ICompetitionEventsService extends IService {

	@POST
	@Path("/getHead")
	void getHead(CompetitionRequestTo viewToCompetition,
			MethodCallback<HeadResponseTo> callback);
	
	@POST
	@Path("/getBetTypes")
	void getBetTypes(CompetitionRequestTo viewToCompetition,
			MethodCallback<TabResponseTo> callback);
	
	@POST
	@Path("/getBetOdds")
	void getBetOdds(CompetitionRequestTo viewToCompetition,
			MethodCallback<List<TableResponseTo>> callback);
}
