/**
 *
 * Copyright (C) FACTORIA ETSIA S.L.
 * All Rights Reserved.
 * www.factoriaetsia.com
 *
 */
package com.comparadorad.bet.comparer.web.client.gwt.results.ui.view;

import com.comparadorad.bet.comparer.web.client.gwt.common.bean.ObjectToId;
import com.comparadorad.bet.comparer.web.client.gwt.core.module.AbstractTestEntryPoint;
import com.google.gwt.user.client.ui.RootPanel;

/**
 * The Class CountryTestEntryPoint.
 */
public class CountryTestEntryPoint extends AbstractTestEntryPoint {

	/**
	 * On module load.
	 * 
	 * {@inheritDoc}
	 */
	@Override
	public void onModuleLoad() {
		super.onModuleLoad();
		RootPanel.get().add(
				new Country(new ObjectToId("futbol"), new ObjectToId("espana"),
						"1"));
	}
}
