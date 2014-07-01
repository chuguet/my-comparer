/**
 *
 * Copyright (C) FACTORIA ETSIA S.L.
 * All Rights Reserved.
 * www.factoriaetsia.com
 *
 */
package com.comparadorad.bet.comparer.web.client.gwt.core.module;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.core.client.GWT;

/**
 * The Class AbstractTestEntryPoint.
 */
public abstract class AbstractTestEntryPoint implements EntryPoint {

	/** {@inheritDoc} */
	@Override
	public void onModuleLoad() {
		GWT.setUncaughtExceptionHandler(new ClientExceptionHandler());

	}

}
