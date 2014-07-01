/**
 *
 * Copyright (C) FACTORIA ETSIA S.L.
 * All Rights Reserved.
 * www.factoriaetsia.com
 *
 */
package com.comparadorad.bet.comparer.web.client.gwt.core.ipc;

import java.util.HashMap;
import java.util.Map;
import java.util.NoSuchElementException;

/**
 * The Enum InternalLinkEventNames.
 */
public enum InternalLinkEventNames {

	/** The IMAG e_ slide r_ competitio n_ event. */
	IMAGE_SLIDER_COMPETITION_EVENT("imageSliderMatchEvent"),

	/** The IMAG e_ slide r_ matc h_ event. */
	IMAGE_SLIDER_MATCH_EVENT("imageSliderCompetitionEvent"),

	/** The NEX t_ even t_ matc h_ event. */
	NEXT_EVENT_MATCH_EVENT("nextEventMatchEvent"),

	/** The RESULT s_ competitio n_ event. */
	RESULTS_COMPETITION_EVENT("resultsCompetitionEvent"),

	/** The RESULT s_ competitio n_ l t_ event. */
	RESULTS_COMPETITION_LT_EVENT("resultsCompetitionLTEvent"),

	/** The RESULT s_ countr y_ event. */
	RESULTS_COUNTRY_EVENT("resultsCountryEvent"),

	/** The RESULT s_ mai n_ event. */
	RESULTS_MAIN_EVENT("resultsMainEvent"),

	/** The RESULT s_ matc h_ event. */
	RESULTS_MATCH_EVENT("resultsMatchEvent"),

	/** The RESULT s_ spor t_ event. */
	RESULTS_SPORT_EVENT("resultsSportEvent"),

	/** The SUR e_ be t_ matc h_ event. */
	SURE_BET_MATCH_EVENT("sureBetMatchEvent"),

	/** The TOOLBA r_ competitio n_ event. */
	TOOLBAR_COMPETITION_EVENT("toolbarCompetitionEvent"),

	/** The VALU e_ be t_ matc h_ event. */
	VALUE_BET_MATCH_EVENT("valueBetMatchEvent");

	/** The Constant lookup. */
	private static final Map<String, InternalLinkEventNames> lookup = new HashMap<String, InternalLinkEventNames>();

	static {
		for (InternalLinkEventNames i : InternalLinkEventNames.values())
			lookup.put(i.getEventName(), i);
	}

	/**
	 * Gets the internal link event name.
	 * 
	 * @param name
	 *            the name
	 * @return the internal link event name
	 */
	public static InternalLinkEventNames getInternalLinkEventName(String name) {
		if (lookup.containsKey(name)) {
			return lookup.get(name);
		}
		throw new NoSuchElementException(name + " not found");
	}

	/** The event name. */
	private final String eventName;

	/**
	 * Instantiates a new internal link event names.
	 * 
	 * @param eventName
	 *            the event name
	 */
	InternalLinkEventNames(String eventName) {
		this.eventName = eventName;
	}

	/**
	 * Gets the event name.
	 * 
	 * @return the event name
	 */
	public String getEventName() {
		return eventName;
	};

	/**
	 * To string.
	 * 
	 * @return the string {@inheritDoc}
	 */
	@Override
	public String toString() {
		return new StringBuffer().append(getEventName()).toString();
	}

}
