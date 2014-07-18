/**
 *
 * Copyright (C) FACTORIA ETSIA S.L.
 * All Rights Reserved.
 * www.factoriaetsia.com
 *
 */
package com.comparadorad.bet.comparer.web.client.gwt.imageslider.ui.view;

import com.comparadorad.bet.comparer.web.client.gwt.core.module.AbstractTestEntryPoint;
import com.google.gwt.user.client.ui.RootPanel;
import com.smartgwt.client.widgets.Button;
import com.smartgwt.client.widgets.events.ClickEvent;
import com.smartgwt.client.widgets.events.ClickHandler;

/**
 * The Class ImageSliderTestEntryPoint.
 */
public class ImageSliderTestEntryPoint extends AbstractTestEntryPoint {

	/** {@inheritDoc} */
	@Override
	public void onModuleLoad() {
		super.onModuleLoad();
		final ImageSlider slider = new ImageSlider();
		RootPanel.get().add(slider);
		Button button = new Button("show and hide");
		button.addClickHandler(new ClickHandler() {
			@Override
			public void onClick(ClickEvent pEvent) {
				if (slider != null) {
					slider.stopTimer();
					RootPanel.get().remove(slider);
				}
			}
		});
		RootPanel.get().add(button);
	}
}
