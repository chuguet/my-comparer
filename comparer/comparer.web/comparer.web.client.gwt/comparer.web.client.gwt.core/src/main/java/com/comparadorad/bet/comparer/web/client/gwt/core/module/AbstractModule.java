/**
 *
 * Copyright (C) FACTORIA ETSIA S.L.
 * All Rights Reserved.
 * www.factoriaetsia.com
 *
 */
package com.comparadorad.bet.comparer.web.client.gwt.core.module;

import com.allen_sauer.gwt.log.client.Log;
import com.comparadorad.bet.comparer.web.client.gwt.core.ipc.HashNames;
import com.comparadorad.bet.comparer.web.client.gwt.core.ipc.IIpcEventUtil;
import com.comparadorad.bet.comparer.web.client.gwt.core.prop.AppProperties;
import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.ui.RootPanel;
import com.smartgwt.client.util.Page;

/**
 * The Class AbstractModule.
 */
public abstract class AbstractModule implements EntryPoint {

	/**
	 * Instantiates a new abstract module.
	 */
	public AbstractModule() {
		super();
	}

	/**
	 * Gets the app path.
	 * 
	 * @return the app path
	 */
	protected abstract String getAppPath();

	/**
	 * Gets the main container id.
	 * 
	 * @return the main container id
	 */
	protected abstract String getMainContainerId();

	/**
	 * Gets the main container root panel.
	 * 
	 * @return the main container root panel
	 */
	protected RootPanel getMainContainerRootPanel() {
		return RootPanel.get(getMainContainerId());
	}

	/**
	 * Inits the environment.
	 */
	protected void initEnvironment() {
		Log.info("Initializing environment: " + GWT.getModuleName());
		GWT.setUncaughtExceptionHandler(new ClientExceptionProdHandler());
		AppProperties.getInstance().setGwtNoServer(false);
		if (isLiferayEnvironment()) {
			AppProperties.getInstance().setLiferayEnvironment(true);
		}
		AppProperties.getInstance().setMainContainerRootPanelName(
				getMainContainerId());
		if (AppProperties.getInstance().isLiferayEnvironment()) {
			Page.setAppImgDir(new StringBuffer("/").append(getAppPath())
					.append("/images/").toString());
		} else {
			Page.setAppImgDir(new StringBuffer("/images/").toString());

		}
	}

	protected boolean isURL(IIpcEventUtil ipcEventUtil) {
		String competitionC = ipcEventUtil.getHashParam(HashNames.COMPETITION_HASH);
		String countrySpC = ipcEventUtil.getHashParam(HashNames.COUNTRY_SP_HASH);
		String countryCoC = ipcEventUtil.getHashParam(HashNames.COUNTRY_CO_HASH);
		String sportC = ipcEventUtil.getHashParam(HashNames.SPORT_HASH);
		String eventC = ipcEventUtil.getHashParam(HashNames.EVENT_HASH);

		if((!competitionC.equals(HashNames.CLEAN)) ||
				(!eventC.equals(HashNames.CLEAN)) ||
				(!sportC.equals(HashNames.CLEAN)) ||
				(!countrySpC.equals(HashNames.CLEAN) && (!countryCoC.equals(HashNames.CLEAN)))){
			return true;

		}
		return false;
	}
	
	protected String buildHash(String[][] pair_key_value){
		String result = "";
		boolean addequals = true;
		for (String[] strings : pair_key_value) {
			for (String string : strings) {
				result = result + string;
				if(addequals){
					result = result + "="; 
					addequals = false;
				}
			}
			result = result + ";";
			addequals = true;
		}
		return result;
		
	}
	
	/**
	 * Checks if is liferay environment.
	 * 
	 * @return true, if is liferay environment
	 */
	protected boolean isLiferayEnvironment() {
		return true;
	}

	/**
	 * On module load.
	 * 
	 * {@inheritDoc}
	 */
	@Override
	public final void onModuleLoad() {
		initEnvironment();
		onModuleLoadActions();
	}

	/**
	 * On module load actions.
	 */
	protected abstract void onModuleLoadActions();
	
	
	
	
	
	
}