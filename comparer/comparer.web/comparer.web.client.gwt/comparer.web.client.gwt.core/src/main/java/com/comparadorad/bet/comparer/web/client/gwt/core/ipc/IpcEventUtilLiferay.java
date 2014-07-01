/**
 *
 * Copyright (C) FACTORIA ETSIA S.L.
 * All Rights Reserved.
 * www.factoriaetsia.com
 *
 */
package com.comparadorad.bet.comparer.web.client.gwt.core.ipc;

/**
 * The Class IpcEventUtilLiferay.
 */
public class IpcEventUtilLiferay implements IIpcEventUtil {

	/** {@inheritDoc} */
	public native void addHashParam(String name, String value) /*-{
		$wnd.location.hash = $wnd.location.hash + name + "=" + value + ";"

	}-*/;

	/** {@inheritDoc} */
	public native void changeTabNavigation(String newViewName) /*-{
		$wnd._navigation = newViewName;
	}-*/;

	/** {@inheritDoc} */
	public native void changeView() /*-{
		$wnd._actualView = $wnd.location.hash;
	}-*/;

	/** {@inheritDoc} */
	public native void fireInternalLinkEvent(String pObjectId,
			String pObjectIdSec, String pMessage, String eventName) /*-{
		$wnd.Liferay.fire(eventName, {
			objectId : pObjectId,
			objectIdSec : pObjectIdSec,
			message : pMessage,
		});
	}-*/;

	/** {@inheritDoc} */
	public native String getCookie(String name) /*-{
		var cookies = $doc.cookie;
		if (!cookies)
			return "-1";
		var comienzo = cookies.indexOf(name);
		if (comienzo == -1)
			return "-1";
		comienzo = comienzo + name.length + 1;
		cantidad = cookies.indexOf("; ", comienzo) - comienzo;
		if (cantidad <= 0)
			cantidad = cookies.length;
		return cookies.substr(comienzo, cantidad);
	}-*/;

	/** {@inheritDoc} */
	public native String getHashParam(String name) /*-{
		var hash = $wnd.location.hash;
		if (!hash)
			return "-1";
		var comienzo = hash.indexOf(name);
		if (comienzo == -1)
			return "-1";
		comienzo = comienzo + name.length + 1;
		cantidad = hash.indexOf(";", comienzo) - comienzo;
		if (cantidad <= 0)
			cantidad = hash.length;
		return hash.substr(comienzo, cantidad);
	}-*/;

	/**
	 * Listen.
	 * 
	 * @param ipcEvent
	 *            the ipc event
	 * @param eventName
	 *            the event name {@inheritDoc}
	 */
	public native void listen(IIpcEvent ipcEvent, String eventName) /*-{
		$wnd.Liferay
				.on(
						eventName,
						function(event) {
							// See http://code.google.com/webtoolkit/doc/latest/DevGuideCodingBasicsJSNI.html
							ipcEvent.@com.comparadorad.bet.comparer.web.client.gwt.core.ipc.IIpcEvent::change(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)(event.objectId, event.objectIdSec, event.message);
						});
	}-*/;

	/** {@inheritDoc} */
	public native void openLinkInCurrentWindow(String url) /*-{
		$wnd.location = url;
	}-*/;

	/** {@inheritDoc} */
	public native void openLinkInNewWindow(String url) /*-{
		window
				.open(
						url,
						'_blank',
						'width=400,height=200,toolbar=yes,location=yes,directories=yes,status=yes,menubar=yes,scrollbars=yes,copyhistory=yes,resizable=yes')
	}-*/;

	/**
	 * Redirect to event.
	 * 
	 * @param eventId
	 *            the event id
	 * @param betTypeId
	 *            the bet type id
	 * @param betTypeEvent
	 *            the bet type event
	 */
	public native void redirectToEvent(String eventId, String betTypeId,
			String betTypeEvent) /*-{
		$wnd.location = "/inicio#" + "event=" + eventId + ";"
				+ "head=0;betType=" + betTypeId + ";" + "betTypeEvent="
				+ betTypeEvent + ";";
	}-*/;

	/** {@inheritDoc} */
	public native void removeHash() /*-{
		$wnd._actualView = "#";
		$wnd.location.hash = '';

	}-*/;

	/** {@inheritDoc} */
	@Override
	public native String removeHashParam(String name) /*-{

		var hash = $wnd.location.hash;
		if (!hash)
			return "-1";
		var comienzo = hash.indexOf(name);
		if (comienzo == -1)
			return "-1";
		cantidad = hash.indexOf(";", comienzo) - comienzo;
		if (cantidad <= 0)
			cantidad = hash.length;
		var aux = hash.substr(comienzo, cantidad + 1);
		var newValue = hash.replace(aux, "");
		$wnd._actualView = newValue;
		$wnd.location.hash = newValue;
		return "1";

	}-*/;

	/** {@inheritDoc} */
	@Override
	public native void replaceHashParam(String name, String value) /*-{
		var result = "0";
		var hash = $wnd.location.hash;
		if (!hash) {
			result = "-1";
		} else {
			var comienzo = hash.indexOf(name);
			if (comienzo == -1) {
				result = "-1";
			} else {
				cantidad = hash.indexOf(";", comienzo) - comienzo;
				if (cantidad <= 0)
					cantidad = hash.length;
				var oldValue = hash.substr(comienzo, cantidad + 1);
				var newValue = name + "=" + value + ";";
				var finalresult = hash.replace(oldValue, newValue);
				$wnd._actualView = finalresult;
				$wnd.location.hash = finalresult;
			}

		}
		if (result == "-1") {
			$wnd._actualView = $wnd.location.hash + name + "=" + value + ";";
			$wnd.location.hash = $wnd.location.hash + name + "=" + value + ";";
		}

	}-*/;

	/** {@inheritDoc} */
	@Override
	public native void scrollTop() /*-{
		$wnd.scrollTo(0, 0);

	}-*/;

	/** {@inheritDoc} */
	public native void setCookie(final String cookieName,
			final String cookieValue) /*-{
		$doc.cookie = cookieName + "=" + cookieValue;
	}-*/;

	/** {@inheritDoc} */
	public native void setHash(String newHash) /*-{
		$wnd._actualView = "#" + newHash;
		$wnd.location.hash = newHash;

	}-*/;

}
