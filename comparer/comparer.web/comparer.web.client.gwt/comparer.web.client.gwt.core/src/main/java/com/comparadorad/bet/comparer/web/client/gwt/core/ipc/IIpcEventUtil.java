/**
 *
 * Copyright (C) FACTORIA ETSIA S.L.
 * All Rights Reserved.
 * www.factoriaetsia.com
 *
 */
package com.comparadorad.bet.comparer.web.client.gwt.core.ipc;

/**
 * The Interface IIpcEventUtil.
 */
public interface IIpcEventUtil {

	/**
	 * Adds the hash param.
	 * 
	 * @param name
	 *            the name
	 * @param value
	 *            the value
	 */
	void addHashParam(String name, String value);

	/**
	 * Change tab navigation.
	 * 
	 * @param newViewName
	 *            the new view name
	 */
	void changeTabNavigation(String newViewName);

	/**
	 * Change view.
	 * 
	 */
	void changeView();

	/**
	 * Fire internal link event.
	 * 
	 * @param pObjectId
	 *            the object id
	 * @param pObjectIdSec
	 *            the object id sec
	 * @param pMessage
	 *            the message
	 * @param eventName
	 *            the event name
	 */
	void fireInternalLinkEvent(final String pObjectId,
			final String pObjectIdSec, final String pMessage,
			final String eventName);

	/**
	 * Gets the cookie.
	 * 
	 * @param name
	 *            the name
	 * @return the cookie
	 */
	String getCookie(String name);

	/**
	 * Gets the hash param.
	 * 
	 * @param name
	 *            the name
	 * @return the hash param
	 */
	String getHashParam(String name);

	/**
	 * Listen.
	 * 
	 * @param ipcEvent
	 *            the ipc event
	 * @param eventName
	 *            the event name
	 */
	void listen(IIpcEvent ipcEvent, String eventName);

	/**
	 * Open link in current window.
	 * 
	 * @param url
	 *            the url
	 */
	void openLinkInCurrentWindow(String url);

	/**
	 * Open link in new window.
	 * 
	 * @param url
	 *            the url
	 */
	void openLinkInNewWindow(String url);

	/**
	 * Removes the hash.
	 */
	void removeHash();

	/**
	 * Removes the hash param.
	 * 
	 * @param name
	 *            the name
	 * @return the string
	 */
	String removeHashParam(String name);

	/**
	 * Replace hash param.
	 * 
	 * @param name
	 *            the name
	 * @param value
	 *            the value
	 */
	void replaceHashParam(String name, String value);

	/**
	 * Scroll top.
	 */
	void scrollTop();

	/**
	 * Sets the cookie.
	 * 
	 * @param cookieName
	 *            the cookie name
	 * @param cookieValue
	 *            the cookie value
	 */
	void setCookie(final String cookieName, final String cookieValue);

	/**
	 * Sets the hash.
	 * 
	 * @param newHash
	 *            the new hash
	 */
	void setHash(String newHash);
}
