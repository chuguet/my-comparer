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
import com.comparadorad.bet.comparer.web.client.gwt.results.ui.event.view.Event;
import com.google.gwt.user.client.ui.RootPanel;

/**
 * The Class EventTestEntryPoint.
 */
public class EventTestEntryPoint extends AbstractTestEntryPoint {

	/**
	 * On module load.
	 * 
	 * {@inheritDoc}
	 */
	@Override
	public void onModuleLoad() {
		super.onModuleLoad();
		super.onModuleLoad();
//		final Event event = new Event(new ObjectToId("RealMadridVsBarcelona"),
//				"0");
		final Event event = new Event(new ObjectToId("100mLisos"));
		RootPanel.get().add(event);
	}
}
