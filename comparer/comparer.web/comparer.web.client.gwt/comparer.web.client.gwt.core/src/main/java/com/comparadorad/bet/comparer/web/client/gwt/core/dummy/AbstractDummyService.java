/**
 *
 * Copyright (C) FACTORIA ETSIA S.L.
 * All Rights Reserved.
 * www.factoriaetsia.com
 *
 */
package com.comparadorad.bet.comparer.web.client.gwt.core.dummy;

import com.google.gwt.user.client.Timer;

/**
 * The Class AbstractDummyService.
 */
public abstract class AbstractDummyService {

	/**
	 * The Class AsyncExec.
	 */
	public abstract class AbstractAsyncExec extends Timer {

		/**
		 * Instantiates a new async exec.
		 */
		public AbstractAsyncExec() {
			super();
		}

		/**
		 * Exec.
		 */
		public final void exec() {
			schedule(1000);
		}
	}
}
