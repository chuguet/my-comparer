/**
 *
 * Copyright (C) FACTORIA ETSIA S.L.
 * All Rights Reserved.
 * www.factoriaetsia.com
 *
 */
package com.comparadorad.bet.comparer.web.server.portlet.results.client;

import com.comparadorad.bet.comparer.web.client.gwt.common.bean.ObjectToId;
import com.comparadorad.bet.comparer.web.client.gwt.results.ui.comp.view.Competition;
import com.comparadorad.bet.comparer.web.client.gwt.results.ui.event.view.Event;
import com.comparadorad.bet.comparer.web.client.gwt.results.ui.view.Country;
import com.comparadorad.bet.comparer.web.client.gwt.results.ui.view.Sport;

/**
 * The Class ResultsModuleDev.
 */
public class ResultsModuleDev extends ResultsModule {

	/** {@inheritDoc} */
	@Override
	protected boolean isLiferayEnvironment() {
		return false;
	}

	private Sport sport;
	private Country country;
	private Event evento;
	private Competition competition;

	/**
	 * On module load.
	 * 
	 * {@inheritDoc}
	 */
	@Override
	public void onModuleLoadActions() {
//		sport = new Sport(new ObjectToId("123456789"));
		sport = new Sport(new ObjectToId("1"));
//		evento = new Event(new ObjectToId("25311870505952402470394253579"), "0", "5", "1");
//		evento = new Event(new ObjectToId("25313450178638995485407932034"));
//		competition = new Competition(new ObjectToId("745300813"), "1");//, "0", "3");
//		country = new Country(new ObjectToId("1"), new ObjectToId("246"));
		getMainContainerRootPanel().add(sport);
	}
}
