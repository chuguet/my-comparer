/**
 *
 * Copyright (C) FACTORIA ETSIA S.L.
 * All Rights Reserved.
 * www.factoriaetsia.com
 *
 */
package com.comparadorad.bet.comparer.web.client.gwt.core.schedule;

import com.google.gwt.user.client.Timer;

/**
 * The Class GwtScheduler.
 */
public abstract class GwtScheduler extends Timer {

	/** The delay millis. */
	private Integer delayMillis;

	/** The Constant DEFAULT_DELAY_MILLIS. */
	private static final int DEFAULT_DELAY_MILLIS = 1000;

	/**
	 * Gets the delay millis.
	 * 
	 * @return the delay millis
	 */
	protected int getDelayMillis() {
		if (delayMillis == null) {
			delayMillis = DEFAULT_DELAY_MILLIS;
		}
		return delayMillis;
	}

	/**
	 * Sets the delay millis.
	 * 
	 * @param pDelayMillis
	 *            the new delay millis
	 */
	protected void setDelayMillis(Integer pDelayMillis) {
		delayMillis = pDelayMillis;
	}

	/**
	 * Instantiates a new async exec.
	 */
	public GwtScheduler() {
		super();
	}

	/**
	 * Exec.
	 */
	public final void exec() {
		// schedule(1);
		scheduleRepeating(10 * 1700);
	}

}
