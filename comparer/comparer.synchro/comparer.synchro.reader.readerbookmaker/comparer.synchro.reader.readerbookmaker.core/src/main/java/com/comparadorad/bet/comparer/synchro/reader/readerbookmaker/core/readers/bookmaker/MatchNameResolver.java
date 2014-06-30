/**
 *
 * Copyright (C) FACTORIA ETSIA S.L.
 * All Rights Reserved.
 * www.factoriaetsia.com
 *
 */
package com.comparadorad.bet.comparer.synchro.reader.readerbookmaker.core.readers.bookmaker;

/**
 * The Class MatchNameResolver.
 */
class MatchNameResolver {

	/** The Constant VS. */
	private static final String VS = " vs ";

	/**
	 * Resolve short term match name.
	 * 
	 * @param homeParticipantName
	 *            the home participant name
	 * @param awayParticipantName
	 *            the away participant name
	 * @return the string
	 */
	public static String resolveShortTermMatchName(String homeParticipantName,
			String awayParticipantName) {
		StringBuffer nameMatch = new StringBuffer();
		nameMatch.append(homeParticipantName);
		nameMatch.append(VS);
		nameMatch.append(awayParticipantName);
		return nameMatch.toString();
	}

}
