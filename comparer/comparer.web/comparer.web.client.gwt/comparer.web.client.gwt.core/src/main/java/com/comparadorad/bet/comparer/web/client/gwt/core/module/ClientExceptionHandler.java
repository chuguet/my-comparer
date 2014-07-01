/**
 *
 * Copyright (C) FACTORIA ETSIA S.L.
 * All Rights Reserved.
 * www.factoriaetsia.com
 *
 */
package com.comparadorad.bet.comparer.web.client.gwt.core.module;

import com.allen_sauer.gwt.log.client.Log;
import com.google.gwt.core.client.GWT.UncaughtExceptionHandler;

/**
 * The Class ClientExceptionHandler.
 */
public class ClientExceptionHandler implements UncaughtExceptionHandler {

	/** {@inheritDoc} */
	@Override
	public void onUncaughtException(Throwable pE) {
		Log.error(pE.getMessage(), pE);
	}

}
