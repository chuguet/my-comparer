/**
 *
 * Copyright (C) FACTORIA ETSIA S.L.
 * All Rights Reserved.
 * www.factoriaetsia.com
 *
 */
package com.comparadorad.bet.comparer.web.server.portlet.valuebet.client;

import com.comparadorad.bet.comparer.web.client.gwt.valuebet.ui.view.ValueBet;
/**
 * The Class ResultsModuleDev.
 */
public class ValueBetModuleDev extends ValueBetModule {

	/** The value bet. */
	private ValueBet valueBet;

	/**
	 * Checks if is liferay environment.
	 *
	 * @return true, if is liferay environment
	 * {@inheritDoc}
	 */
	protected boolean isLiferayEnvironment() {
		return false;
	}

	/** {@inheritDoc} */
	@Override
	public void onModuleLoadActions() {
		valueBet = new ValueBet();
		getMainContainerRootPanel().add(valueBet);
	}

}
