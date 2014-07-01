/**
 *
 * Copyright (C) FACTORIA ETSIA S.L.
 * All Rights Reserved.
 * www.factoriaetsia.com
 *
 */
package com.comparadorad.bet.comparer.web.client.gwt.livebet.ui.view;

import com.comparadorad.bet.comparer.web.client.gwt.core.module.AbstractTestEntryPoint;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.RootPanel;

/**
 * The Class LiveBetTestEntryPoint.
 */
public class LiveBetTestEntryPoint extends AbstractTestEntryPoint {

	private LiveBet liveBet;
	
	/** {@inheritDoc} */
	@Override
	public void onModuleLoad() {
		super.onModuleLoad();
		liveBet = new LiveBet();
		RootPanel.get().add(liveBet);
//		Button b = new Button("close");
//		b.addClickHandler(new ClickHandler() {
//			@Override
//			public void onClick(ClickEvent pEvent) {
//				if (liveBet.isVisible()) {
//					liveBet.stopTimer();
//					liveBet.hide();
//				}
//				else {
//					liveBet.startTimer();
//					liveBet.show();
//				}
//				
//			}
//		});
//		RootPanel.get().add(b);
	}

}
