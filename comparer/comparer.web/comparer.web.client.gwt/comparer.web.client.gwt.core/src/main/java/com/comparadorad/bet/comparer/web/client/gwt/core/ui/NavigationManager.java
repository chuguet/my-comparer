/**
 *
 * Copyright (C) FACTORIA ETSIA S.L.
 * All Rights Reserved.
 * www.factoriaetsia.com
 *
 */
package com.comparadorad.bet.comparer.web.client.gwt.core.ui;

import com.allen_sauer.gwt.log.client.Log;
import com.comparadorad.bet.comparer.web.client.gwt.core.prop.AppProperties;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.RootPanel;

/**
 * The Class NavigationManager.
 * 
 * Controls for the navigation.
 */
public class NavigationManager {

	/** The instance. */
	public static NavigationManager instance;

	/**
	 * Gets the single instance of NavigationManager.
	 * 
	 * @return single instance of NavigationManager
	 */
	public static NavigationManager getInstance() {
		if (instance == null) {
			synchronized (NavigationManager.class) {
				instance = new NavigationManager();
			}
		}
		return instance;
	}

	/**
	 * Sets the composite in main panel.
	 * 
	 * @param composite
	 *            the new composite in main panel
	 */
	public void setCompositeInMainPanel(Composite composite) {
		Log.info("setCompositeInMainPanel");
		RootPanel mainPanel = RootPanel.get(AppProperties.getInstance()
				.getMainContainerRootPanelName());
		if (mainPanel == null) {
			mainPanel = RootPanel.get();
		}
		mainPanel.clear();
		mainPanel.add(composite);
	}
}
