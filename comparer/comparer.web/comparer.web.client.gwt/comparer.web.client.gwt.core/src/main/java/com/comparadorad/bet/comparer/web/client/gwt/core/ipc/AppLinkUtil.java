/**
 *
 * Copyright (C) FACTORIA ETSIA S.L.
 * All Rights Reserved.
 * www.factoriaetsia.com
 *
 */
package com.comparadorad.bet.comparer.web.client.gwt.core.ipc;

import com.allen_sauer.gwt.log.client.Log;
import com.comparadorad.bet.comparer.web.client.gwt.core.encrypt.EncryptUtil;

/**
 * The Class InternalLinkClickHandler.
 */
public class AppLinkUtil {

	/** The Constant internalLinkUrlFactory. */
	private static final InternalLinkUrlFactory internalLinkUrlFactory = new InternalLinkUrlFactory();

	/** The Constant ipcEventUtil. */
	private static final IIpcEventUtil ipcEventUtil = IpcEventFactory
			.getInstance().createIpcEventUtil();

	/**
	 * Open external link in new window.
	 * 
	 * @param encryptedUrl
	 *            the encrypted url
	 */
	public void openExternalLinkInNewWindow(String encryptedUrl) {
		if (encryptedUrl != null && !encryptedUrl.equalsIgnoreCase("")
				&& !encryptedUrl.isEmpty()) {
			String desencryptedUrl = EncryptUtil.desencryptString(encryptedUrl);
			Log.debug(new StringBuffer()
					.append("Abrir enlace externo en nueva ventana: url = ")
					.append(desencryptedUrl).toString());
			ipcEventUtil.openLinkInNewWindow(desencryptedUrl);
		}
	}

	/**
	 * Open internal link in current window.
	 * 
	 * @param pId
	 *            the id
	 * @param pIdAux
	 *            the id aux
	 * @param pEventName
	 *            the event name
	 */
	public void openInternalLinkInCurrentWindow(final String pId,
			final String pIdAux, final InternalLinkEventNames pEventName) {
		Log.debug(new StringBuffer()
				.append("Abrir enlace interno en ventana actual: eventName = ")
				.append(pEventName.getEventName()).append(", id = ")
				.append(pId).append(", pIdAux = ").append(pIdAux).toString());
		ipcEventUtil.fireInternalLinkEvent(pId, pIdAux, "",
				pEventName.getEventName());
	}

	/**
	 * Open internal link in new window.
	 * 
	 * @param pId
	 *            the id
	 * @param pIdAux
	 *            the id aux
	 * @param pIdAux2
	 *            the id aux2
	 * @param pEventName
	 *            the event name
	 */
	public void openInternalLinkInNewWindow(String pId, String pIdAux,
			String pIdAux2, InternalLinkEventNames pEventName) {
		Log.debug(new StringBuffer()
				.append("Abrir enlace interno en nueva ventana: eventName = ")
				.append(pEventName.getEventName()).append(", id = ")
				.append(pId).append(", pIdAux = ").append(pIdAux).toString());
		String url = internalLinkUrlFactory.getUrl(pId, pIdAux, pIdAux2,
				pEventName);
		Log.debug(new StringBuffer().append("Url de la nueva ventana: ")
				.append(url).toString());
		ipcEventUtil.openLinkInNewWindow(url);
	}

	/**
	 * Redirect internal link in current window.
	 * 
	 * @param pId
	 *            the id
	 * @param pBetTypeId
	 *            the bet type id
	 * @param pBetTypeEventId
	 *            the bet type event id
	 * @param pEventName
	 *            the event name
	 */
	public void redirectInternalLinkInCurrentWindow(String pId,
			String pBetTypeId, String pBetTypeEventId,
			InternalLinkEventNames pEventName) {
		Log.debug(new StringBuffer()
				.append("Redirect enlace interno a ventana actual: eventName = ")
				.append(pEventName.getEventName()).append(", id = ")
				.append(pId).append(", pBetTypeId = ").append(pBetTypeId)
				.append(", pBetTypeEventId = ").append(pBetTypeEventId)
				.toString());
		String url = internalLinkUrlFactory.getUrl(pId, pBetTypeId,
				pBetTypeEventId, pEventName);
		Log.debug(new StringBuffer().append("Url de la nueva ventana: ")
				.append(url).toString());
		ipcEventUtil.openLinkInCurrentWindow(url);
	}
}
