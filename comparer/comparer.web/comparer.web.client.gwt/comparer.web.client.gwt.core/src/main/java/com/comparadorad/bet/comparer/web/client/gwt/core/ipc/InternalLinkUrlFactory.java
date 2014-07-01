/**
 *
 * Copyright (C) FACTORIA ETSIA S.L.
 * All Rights Reserved.
 * www.factoriaetsia.com
 *
 */
package com.comparadorad.bet.comparer.web.client.gwt.core.ipc;

/**
 * A factory for creating InternalLinkUrl objects.
 */
public class InternalLinkUrlFactory {

	private static final String APP_BASE_PATH = "/inicio#";
	
	/**
	 * Gets the url.
	 * 
	 * @param id
	 *            the id
	 * @param idAux
	 *            the id aux
	 * @param idAux2
	 *            the id aux2
	 * @param eventName
	 *            the event name
	 * @return the url
	 */
	public String getUrl(String id, String idAux, String idAux2,
			InternalLinkEventNames eventName) {
		StringBuffer url = new StringBuffer();
		url.append(APP_BASE_PATH);
		if (eventName.equals(InternalLinkEventNames.RESULTS_MAIN_EVENT)) {

		} else if (eventName.equals(InternalLinkEventNames.RESULTS_SPORT_EVENT)) {
			url.append(HashNames.SPORT_HASH).append("=").append(id);
			url.append(";");
			url.append(HashNames.TAB_HEAD_HASH).append("=0");
			url.append(";");
		} else if (eventName
				.equals(InternalLinkEventNames.RESULTS_COUNTRY_EVENT)) {
			url.append(HashNames.COUNTRY_SP_HASH).append("=").append(idAux);
			url.append(";");
			url.append(HashNames.COUNTRY_CO_HASH).append("=").append(id);
			url.append(";");
			url.append(HashNames.TAB_HEAD_HASH).append("=0");
			url.append(";");
		} else if (eventName
				.equals(InternalLinkEventNames.RESULTS_COMPETITION_EVENT)
				|| eventName
						.equals(InternalLinkEventNames.IMAGE_SLIDER_COMPETITION_EVENT)
				|| eventName
						.equals(InternalLinkEventNames.TOOLBAR_COMPETITION_EVENT)) {
			url.append(HashNames.COMPETITION_HASH).append("=").append(id);
			url.append(";");
			url.append(HashNames.TAB_HEAD_HASH).append("=").append("0");
			url.append(";");
			if (idAux != null && !idAux.isEmpty()) {
				url.append(HashNames.TAB_BET_TYPE_HASH).append("=")
						.append(idAux);
				url.append(";");
			}
		} else if (eventName
				.equals(InternalLinkEventNames.RESULTS_COMPETITION_LT_EVENT)) {
			url.append(HashNames.COMPETITION_HASH).append("=").append(id);
			url.append(";");
			url.append(HashNames.TAB_HEAD_HASH).append("=").append("1");
			url.append(";");
		} else if (eventName.equals(InternalLinkEventNames.RESULTS_MATCH_EVENT)
				|| eventName
						.equals(InternalLinkEventNames.IMAGE_SLIDER_MATCH_EVENT)
				|| eventName
						.equals(InternalLinkEventNames.NEXT_EVENT_MATCH_EVENT)) {
			url.append(HashNames.EVENT_HASH).append("=").append(id);
			url.append(";");
			url.append(HashNames.TAB_HEAD_HASH).append("=").append("0");
			url.append(";");
			if (idAux != null && !idAux.isEmpty()) {
				url.append(HashNames.TAB_BET_TYPE_HASH).append("=")
						.append(idAux);
				url.append(";");
			}
		} else if (eventName
				.equals(InternalLinkEventNames.SURE_BET_MATCH_EVENT)
				|| eventName
						.equals(InternalLinkEventNames.VALUE_BET_MATCH_EVENT)) {
			url.append(HashNames.EVENT_HASH).append("=").append(id);
			url.append(";");
			url.append(HashNames.TAB_HEAD_HASH).append("=").append("0");
			url.append(";");
			if (idAux != null && !idAux.isEmpty()) {
				url.append(HashNames.TAB_BET_TYPE_HASH).append("=")
						.append(idAux);
				url.append(";");
				if (idAux2 != null && !idAux2.isEmpty()) {
					url.append(HashNames.TAB_BET_TYPE__EVENT_HASH).append("=")
							.append(idAux2);
					url.append(";");
				}
			}
		}
		return url.toString();
	}
}
