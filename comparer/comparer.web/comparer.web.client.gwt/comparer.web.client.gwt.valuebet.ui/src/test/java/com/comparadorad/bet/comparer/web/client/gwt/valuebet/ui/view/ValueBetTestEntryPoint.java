/**
 *
 * Copyright (C) FACTORIA ETSIA S.L.
 * All Rights Reserved.
 * www.factoriaetsia.com
 *
 */
package com.comparadorad.bet.comparer.web.client.gwt.valuebet.ui.view;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.user.client.ui.RootPanel;
import com.smartgwt.client.widgets.Button;
import com.smartgwt.client.widgets.events.ClickEvent;
import com.smartgwt.client.widgets.events.ClickHandler;

/**
 * The Class ValueBetTestEntryPoint.
 */
public class ValueBetTestEntryPoint implements EntryPoint {

	/** {@inheritDoc} */
	@Override
	public void onModuleLoad() {
		final ValueBet valueBet = new ValueBet();
		RootPanel.get().add(valueBet);
//		Button button = new Button("close and open view");
//		button.addClickHandler(new ClickHandler() {
//			@Override
//			public void onClick(ClickEvent pEvent) {
//				if (valueBet.getTableRefreshService().isTimerOn()) {
//					valueBet.stopTimer();
//					RootPanel.get().remove(0);
//				}
//				else {
//					valueBet.startTimer();
//					RootPanel.get().add(valueBet);
//				}	
//			}
//			
//		});
//		RootPanel.get().add(button);
	}

}
