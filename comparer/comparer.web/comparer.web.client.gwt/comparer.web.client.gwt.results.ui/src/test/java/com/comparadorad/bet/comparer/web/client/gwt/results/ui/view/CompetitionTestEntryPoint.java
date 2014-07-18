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
import com.comparadorad.bet.comparer.web.client.gwt.results.ui.comp.view.Competition;
import com.comparadorad.bet.comparer.web.client.gwt.results.ui.event.view.Event;
import com.google.gwt.user.client.ui.RootPanel;
import com.smartgwt.client.widgets.Button;
import com.smartgwt.client.widgets.events.ClickEvent;
import com.smartgwt.client.widgets.events.ClickHandler;

/**
 * The Class CompetitionTestEntryPoint.
 */
public class CompetitionTestEntryPoint extends AbstractTestEntryPoint {

	/**
	 * On module load.
	 * 
	 * {@inheritDoc}
	 */
	@Override
	public void onModuleLoad() {
		super.onModuleLoad();
		final Competition comp = new Competition(new ObjectToId("ligaBBVA"),
				"1");
		RootPanel.get().add(comp);
		Button button = new Button("close and open view");
		button.addClickHandler(new ClickHandler() {
			@Override
			public void onClick(ClickEvent pEvent) {
				if (comp.isViewVisible()) {
					ResultsView view = (ResultsView) RootPanel.get().getWidget(
							0);
					view.stopTimer();
					RootPanel.get().remove(comp);
					RootPanel.get().add(
							new Event(new ObjectToId("RealMadridVsBarcelona")));

				} else {
					RootPanel.get().add(comp);
				}
			}

		});
		RootPanel.get().add(button);
	}
}
