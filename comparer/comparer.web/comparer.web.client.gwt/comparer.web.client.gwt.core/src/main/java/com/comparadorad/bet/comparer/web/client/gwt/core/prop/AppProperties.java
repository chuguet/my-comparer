/**
 *
 * Copyright (C) FACTORIA ETSIA S.L.
 * All Rights Reserved.
 * www.factoriaetsia.com
 *
 */
package com.comparadorad.bet.comparer.web.client.gwt.core.prop;

import com.google.gwt.core.client.GWT;

/**
 * The Class AppProperties.
 */
public class AppProperties {

	/** The Constant DEV. */
	public static final String _BETCOMPARAENV = "betcompara";
	
	public static final String _BETCOMPARAZEROENV = "betcomparaZERO";

	public static final GwtEnvironment environmentFile = (GwtEnvironment) GWT.create(GwtEnvironment.class);

	private static final String GWT_ENVIRONMENT = environmentFile.environment();


	/** The instance. */
	private static AppProperties instance;

	/**
	 * Gets the instance.
	 * 
	 * @return the instance
	 */
	public static final AppProperties getInstance() {
		if (instance == null) {
			instance = new AppProperties();
		}
		return instance;
	}

	/** The gwt no server. */
	private Boolean gwtNoServer = null;

	/** The liferay environment. */
	private boolean liferayEnvironment = false;

	public boolean isLiferayEnvironment() {
		return liferayEnvironment;
	}

	public void setLiferayEnvironment(boolean pLiferayEnvironment) {
		liferayEnvironment = pLiferayEnvironment;
	}

	/**
	 * Checks if is gwt no server.
	 * 
	 * @return true, if checks if is gwt no server
	 */
	public boolean isGwtNoServer() {
		if (gwtNoServer != null) {
			return gwtNoServer.booleanValue();
		}
		return !GWT.isProdMode();
	}

	/**
	 * Sets the gwt no server.
	 * 
	 * @param pGwtNoServer
	 *            the new gwt no server
	 */
	public void setGwtNoServer(Boolean pGwtNoServer) {
		gwtNoServer = pGwtNoServer;
	}

	/**
	 * Gets the main container root panel name.
	 * 
	 * @return the main container root panel name
	 */
	public String getMainContainerRootPanelName() {
		return mainContainerRootPanelName;
	}

	/** The main container root panel name. */
	private String mainContainerRootPanelName;

	/**
	 * Sets the main container root panel name.
	 * 
	 * @param pMainContainerRootPanelName
	 *            the new main container root panel name
	 */
	public void setMainContainerRootPanelName(String pMainContainerRootPanelName) {
		mainContainerRootPanelName = pMainContainerRootPanelName;
	}

	public String getGwtEnvironment() {
		return GWT_ENVIRONMENT;
	}
}
