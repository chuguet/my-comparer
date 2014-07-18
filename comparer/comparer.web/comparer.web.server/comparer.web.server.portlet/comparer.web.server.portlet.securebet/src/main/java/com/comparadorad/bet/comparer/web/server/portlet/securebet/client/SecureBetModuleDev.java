/**
 *
 * Copyright (C) FACTORIA ETSIA S.L.
 * All Rights Reserved.
 * www.factoriaetsia.com
 *
 */
package com.comparadorad.bet.comparer.web.server.portlet.securebet.client;

import com.comparadorad.bet.comparer.web.client.gwt.securebet.ui.view.SecureBet;

/**
 * The Class ResultsModuleDev.
 */
public class SecureBetModuleDev extends SecureBetModule {

	private SecureBet secureBet;

	/** {@inheritDoc} */
	protected boolean isLiferayEnvironment() {
		return false;
	}

	@Override
	public void onModuleLoadActions() {
		secureBet = new SecureBet();
		getMainContainerRootPanel().add(secureBet);
	}

}
