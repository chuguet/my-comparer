/**
 *
 * Copyright (C) FACTORIA ETSIA S.L.
 * All Rights Reserved.
 * www.factoriaetsia.com
 *
 */
package com.comparadorad.bet.comparer.web.client.gwt.core.analytics;

import com.allen_sauer.gwt.log.client.Log;

/**
 * The Class IpcEventUtilLiferay.
 */
public class AnalyticsEventUtil {

	private String idAnalytics = "UA-40151842-1";
	
	public static void trackAnalytics(String categoria, String accion) {
		Log.debug("Antes de la nativa de analytics: " + categoria + " - " + accion);
		trackUrchinHit(categoria, accion);
	}
	
	private native static void trackUrchinHit(String category, String action)/*-{
//		var pageTracker = $wnd._gat._getTracker(accountId);
//		pageTracker._trackPageview(pageName);
		$wnd._gaq.push(['_trackEvent', category, action]);

	}-*/;
}
