package com.comparadorad.bet.comparer.web.server.portlet.systemHour.client;
import com.comparadorad.bet.comparer.web.client.gwt.core.module.AbstractModule;
import com.google.gwt.core.client.EntryPoint;


public class SystemHourModule extends AbstractModule implements EntryPoint{

	/** The Constant SECUREBET_MODULE_CONTAINER. */
	private static final String SYSTEMHOUR_MODULE_CONTAINER = "systemHourModuleContainer";
	
	@Override
	protected String getAppPath() {
		return "com.comparadorad.bet.comparer.web.server.portlet.systemHour";
	}

	@Override
	protected String getMainContainerId() {
		return SYSTEMHOUR_MODULE_CONTAINER;
	}

	@Override
	protected void onModuleLoadActions() {
		// TODO Auto-generated method stub

	}

}
