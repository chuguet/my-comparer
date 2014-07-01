/**
 *
 * Copyright (C) FACTORIA ETSIA S.L.
 * All Rights Reserved.
 * www.factoriaetsia.com
 *
 */
package com.comparadorad.bet.comparer.web.client.gwt.securebet.ui.view;

import com.comparadorad.bet.comparer.web.client.gwt.common.bean.ObjectToId;
import com.comparadorad.bet.comparer.web.client.gwt.core.module.AbstractTestEntryPoint;
import com.google.gwt.user.client.ui.RootPanel;

/**
 * The Class SecureBetTestEntryPoint.
 */
public class SecureBetTestEntryPoint extends AbstractTestEntryPoint {

	/** {@inheritDoc} */
	@Override
	public void onModuleLoad() {
		super.onModuleLoad();
		// Test mostrar una surebet
		RootPanel.get().add(new SecureBet(new ObjectToId("111")));
		
		// Test mostrar surebet
//		RootPanel.get().add(new SecureBet());
	}

}
