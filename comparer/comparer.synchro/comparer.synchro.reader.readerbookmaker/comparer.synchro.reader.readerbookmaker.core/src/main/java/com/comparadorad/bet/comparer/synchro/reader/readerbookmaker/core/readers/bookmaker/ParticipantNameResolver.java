/**
 *
 * Copyright (C) FACTORIA ETSIA S.L.
 * All Rights Reserved.
 * www.factoriaetsia.com
 *
 */
package com.comparadorad.bet.comparer.synchro.reader.readerbookmaker.core.readers.bookmaker;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 * The Class ParticipantNameResolver.
 */
class ParticipantNameResolver {

	/** The Constant LOG. */
	private static final Log LOG = LogFactory
			.getLog(ParticipantNameResolver.class);

	/** The Constant PATTERNS_TO_DELETE. */
	private static final String[] PATTERNS_TO_DELETE = { "1H ", "2H ", "1Q ",
			"2Q ", "3Q ", "4Q ", " GM1", " GM2", " GM3", " GM4", " GM5", "1P ",
			"2P ", "3P " };

	/**
	 * Resolve participant name. Si el partido es de primera parte, segundo
	 * cuarto etc el nombre de los participantes viene con esta información y lo
	 * quitamos. Por ejemplo: '4Q SEATTLE' y '2H NEW ORLEANS'.
	 * 
	 * @param originalName
	 *            the original name
	 * @return the string
	 */
	public static String resolveParticipantName(String originalName) {
		String participantName = originalName;
		for (String patternToDelete : PATTERNS_TO_DELETE) {
			participantName = participantName.replace(patternToDelete, "");
		}
		if (LOG.isDebugEnabled()) {
			LOG.debug(new StringBuffer()
					.append("Resolvemos nombre de participante. En el xml viene como: ")
					.append(originalName).append(". Nosotros guardamos: ")
					.append(participantName));
		}
		return participantName;
	}

	/**
	 * Resolve participant name future event.
	 * 
	 * @param originalName
	 *            the original name
	 * @return the string
	 */
	public static String resolveParticipantNameFutureEvent(String originalName) {
		String participantName = originalName;
		for (String patternToDelete : PATTERNS_TO_DELETE) {
			participantName = participantName.replace(patternToDelete, "");
		}
		if (LOG.isDebugEnabled()) {
			LOG.debug(new StringBuffer()
					.append("Resolvemos nombre de participante. En el xml viene como: ")
					.append(originalName).append(". Nosotros guardamos: ")
					.append(participantName));
		}
		return participantName;
	}

}
