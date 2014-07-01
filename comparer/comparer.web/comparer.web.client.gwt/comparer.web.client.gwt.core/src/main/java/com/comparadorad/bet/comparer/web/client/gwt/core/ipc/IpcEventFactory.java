/**
 *
 * Copyright (C) FACTORIA ETSIA S.L.
 * All Rights Reserved.
 * www.factoriaetsia.com
 *
 */
package com.comparadorad.bet.comparer.web.client.gwt.core.ipc;

import com.allen_sauer.gwt.log.client.Log;
import com.comparadorad.bet.comparer.web.client.gwt.core.prop.AppProperties;
import com.google.gwt.core.client.GWT;

/**
 * A factory for creating IpcEvent objects.
 * 
 * Factory event creation, designed to create objects for testing mode (hosted
 * mode), and if that was implanted in another portal different than liferay .
 */
public class IpcEventFactory {

	/** The instance. */
	private static IpcEventFactory instance;

	/**
	 * Gets the single instance of IpcEventFactory.
	 * 
	 * @return single instance of IpcEventFactory
	 */
	public static IpcEventFactory getInstance() {
		if (instance == null) {
			synchronized (IpcEventFactory.class) {
				instance = new IpcEventFactory();
			}
		}
		return instance;
	}

	/**
	 * Creates a new IpcEvent object.
	 * 
	 * @return the i ipc event util
	 */
	public IIpcEventUtil createIpcEventUtil() {
		IIpcEventUtil ipcEventUtil = null;
		if (AppProperties.getInstance().isGwtNoServer()
				|| !AppProperties.getInstance().isLiferayEnvironment()) {
			ipcEventUtil = GWT.create(IpcEventUtilHostedMode.class);
			Log.info("Created IpcEventUtilHostedMode");
		} else {
			ipcEventUtil = GWT.create(IpcEventUtilLiferay.class);
			Log.info("Created IpcEventUtilLiferay");
		}
		return ipcEventUtil;
	}
}
