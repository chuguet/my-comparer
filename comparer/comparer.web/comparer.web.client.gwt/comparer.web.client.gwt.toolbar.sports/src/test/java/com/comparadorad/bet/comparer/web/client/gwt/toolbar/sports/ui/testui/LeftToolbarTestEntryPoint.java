/**
 *
 * Copyright (C) FACTORIA ETSIA S.L.
 * All Rights Reserved.
 * www.factoriaetsia.com
 *
 */
package com.comparadorad.bet.comparer.web.client.gwt.toolbar.sports.ui.testui;

import com.comparadorad.bet.comparer.web.client.gwt.core.module.AbstractTestEntryPoint;
import com.comparadorad.bet.comparer.web.client.gwt.toolbar.sports.ui.LeftToolbar;
import com.google.gwt.user.client.ui.RootPanel;

/**
 * The Class SportToolbarTestEntryPoint.
 */
public class LeftToolbarTestEntryPoint extends AbstractTestEntryPoint {

	/** {@inheritDoc} */
	@Override
	public void onModuleLoad() {
		super.onModuleLoad();
		LeftToolbar leftToolbar = new LeftToolbar();
		RootPanel.get().add(leftToolbar);
	}

}
