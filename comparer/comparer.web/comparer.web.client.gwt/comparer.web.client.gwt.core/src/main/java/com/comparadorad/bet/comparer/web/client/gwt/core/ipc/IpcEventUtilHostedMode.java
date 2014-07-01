/**
 *
 * Copyright (C) FACTORIA ETSIA S.L.
 * All Rights Reserved.
 * www.factoriaetsia.com
 *
 */
package com.comparadorad.bet.comparer.web.client.gwt.core.ipc;

import com.allen_sauer.gwt.log.client.Log;

/**
 * The Class IpcEventUtilLiferay.
 */
public class IpcEventUtilHostedMode implements IIpcEventUtil {

	/**
	 * Adds the hash param.
	 * 
	 * @param name
	 *            the name
	 * @param value
	 *            the value {@inheritDoc}
	 */
	@Override
	public void addHashParam(String name, String value) {
		// NOTHING TO DO

	}

	/**
	 * Change tab navigation.
	 * 
	 * @param newViewName
	 *            the new view name {@inheritDoc}
	 */
	@Override
	public void changeTabNavigation(String newViewName) {
		// NOTHING TO DO

	}

	/**
	 * Change view.
	 * 
	 * {@inheritDoc}
	 */
	@Override
	public void changeView() {
		// NOTHING TO DO

	}

	/**
	 * Fire.
	 * 
	 * @param pObjectId
	 *            the object id
	 * @param pMessage
	 *            the message
	 * @param pObjectIdSec
	 *            the object id sec
	 * @param eventName
	 *            the event name {@inheritDoc}
	 */
	public void fire(final String pObjectId, final String pMessage,
			final String pObjectIdSec, final String eventName) {
		// NOTHING TO DO
		Log.info("fire in " + getClass());
	}

	/** {@inheritDoc} */
	@Override
	public void fireInternalLinkEvent(String pObjectId, String pObjectIdSec,
			String pMessage, String pEventName) {
		// TODO Auto-generated method stub

	}

	/**
	 * Gets the cookie.
	 * 
	 * @param name
	 *            the name
	 * @return the cookie {@inheritDoc}
	 */
	@Override
	public String getCookie(String name) {
		// NOTHING TO DO
		Log.info(new StringBuffer().append("getCookie").append(getClass())
				.toString());
		return "";
	}

	/**
	 * Gets the hash param.
	 * 
	 * @param name
	 *            the name
	 * @return the hash param {@inheritDoc}
	 */
	@Override
	public String getHashParam(String name) {
		// NOTHING TO DO
		return "";
	}

	/**
	 * Listen.
	 * 
	 * @param ipcEvent
	 *            the ipc event
	 * @param eventName
	 *            the event name {@inheritDoc}
	 */
	public void listen(final IIpcEvent ipcEvent, final String eventName) {
		// NOTHING TO DO
		Log.info("listen in " + getClass());
	}

	/** {@inheritDoc} */
	@Override
	public void openLinkInCurrentWindow(String pUrl) {
		// TODO Auto-generated method stub

	}

	/** {@inheritDoc} */
	@Override
	public void openLinkInNewWindow(String pUrl) {
		// TODO Auto-generated method stub

	}

	/**
	 * Removes the hash.
	 * 
	 * {@inheritDoc}
	 */
	@Override
	public void removeHash() {
		// NOTHING TO DO

	}

	/**
	 * Removes the hash param.
	 * 
	 * @param name
	 *            the name
	 * @return the string {@inheritDoc}
	 */
	@Override
	public String removeHashParam(String name) {
		return "";
		// NOTHING TO DO

	}

	/**
	 * Replace hash param.
	 * 
	 * @param name
	 *            the name
	 * @param value
	 *            the value {@inheritDoc}
	 */
	@Override
	public void replaceHashParam(String name, String value) {
		// NOTHING TO DO

	}

	/** {@inheritDoc} */
	@Override
	public void scrollTop() {
		// NOTHING TO DO

	}

	/**
	 * Sets the cookie.
	 * 
	 * @param cookieName
	 *            the cookie name
	 * @param cookieValue
	 *            the cookie value {@inheritDoc}
	 */
	@Override
	public void setCookie(String cookieName, String cookieValue) {
		// NOTHING TO DO
		Log.info(new StringBuffer().append("cookie in ").append(getClass())
				.toString());

	}

	/**
	 * Sets the hash.
	 * 
	 * @param newHash
	 *            the new hash {@inheritDoc}
	 */
	@Override
	public void setHash(String newHash) {
		// NOTHING TO DO

	}
}
