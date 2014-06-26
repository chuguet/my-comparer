/**
 *
 * Copyright (C) FACTORIA ETSIA S.L.
 * All Rights Reserved.
 * www.factoriaetsia.com
 *
 */
package com.comparadorad.bet.comparer.synchro.reader.reader;

import java.util.HashMap;
import java.util.Map;

/**
 * The Class XmlBetFileReaderMatchVariables.
 */
public class XmlBetFileReaderVariables {

	/** The Constant XML_PARTICIPIANS_IN_NAME_PARAM. */
	public static final String XML_PARTICIPANTS_IN_NAME_MARKET_BET_PARAM = "participantsInNameMarketBet";

	/** The matchVariables. */
	private Map<String, Object> matchVariables = new HashMap<String, Object>();

	/**
	 * Clear.
	 */
	public void clearMatchVariables() {
		matchVariables.clear();
	}

	/**
	 * Gets the.
	 * 
	 * @param pKey
	 *            the key
	 * @return the object
	 */
	public Object getMatchVariable(Object pKey) {
		return matchVariables.get(pKey);
	}

	/**
	 * Checks if is participants in name param.
	 * 
	 * @return the boolean
	 */
	public Boolean isParticipantsInNameParamMarketBet() {
		return matchVariables.get(XML_PARTICIPANTS_IN_NAME_MARKET_BET_PARAM) != null
				&& (Boolean) matchVariables
						.get(XML_PARTICIPANTS_IN_NAME_MARKET_BET_PARAM);
	}

	/**
	 * Put.
	 * 
	 * @param pKey
	 *            the key
	 * @param pValue
	 *            the value
	 * @return the object
	 */
	public Object putMatchVariable(String pKey, Object pValue) {
		return matchVariables.put(pKey, pValue);
	}

	/**
	 * Sets the participants in name param.
	 * 
	 * @param participantsInName
	 *            the new participants in name param
	 */
	public void setParticipantsInNameParamMarketBet(Boolean participantsInName) {
		matchVariables.put(XML_PARTICIPANTS_IN_NAME_MARKET_BET_PARAM,
				participantsInName);
	}

}
