/**
 *
 * Copyright (C) FACTORIA ETSIA S.L.
 * All Rights Reserved.
 * www.factoriaetsia.com
 *
 */
package com.comparadorad.bet.comparer.web.server.portlet.nextev.client;

import java.util.Date;

import com.comparadorad.bet.comparer.web.client.gwt.livebet.ui.view.LiveBet;

/**
 * The Class ResultsModuleDev.
 */
public class NextEventsModuleDev extends NextEventsModule {

	/** {@inheritDoc} */
	protected boolean isLiferayEnvironment() {
		return false;
	}

	private LiveBet widget;

	@Override
	public void onModuleLoadActions() {
		widget = new LiveBet();
		getMainContainerRootPanel().add(widget);
	}

}
