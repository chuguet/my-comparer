/**
 *
 * Copyright (C) FACTORIA ETSIA S.L.
 * All Rights Reserved.
 * www.factoriaetsia.com
 *
 */
package com.comparadorad.bet.comparer.web.client.gwt.core.ipc;

/**
 * The Interface IIpcEvent.
 */
public interface IIpcEvent {

	/**
	 * Change.
	 * 
	 * @param id
	 *            the id
	 * @param name
	 *            the name
	 */
	void change(String objectId, String pObjectIdSec, String name);
}
