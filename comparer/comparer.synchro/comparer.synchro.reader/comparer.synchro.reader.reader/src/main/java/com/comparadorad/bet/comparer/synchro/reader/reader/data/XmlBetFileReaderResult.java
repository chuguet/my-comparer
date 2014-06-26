/**
 *
 * Copyright (C) FACTORIA ETSIA S.L.
 * All Rights Reserved.
 * www.factoriaetsia.com
 *
 */
package com.comparadorad.bet.comparer.synchro.reader.reader.data;

import com.comparadorad.bet.comparer.synchro.reader.model.XmlBookmakerEvents;

/**
 * The Class XmlBetFileReaderResult.
 */
public class XmlBetFileReaderResult {

	/** The xml bookmaker events. */
	private final XmlBookmakerEvents xmlBookmakerEvents;

	/**
	 * Instantiates a new xml bet file reader result.
	 * 
	 * @param pXmlBookmakerEvents
	 *            the xml bookmaker events
	 */
	public XmlBetFileReaderResult(XmlBookmakerEvents pXmlBookmakerEvents) {
		super();
		xmlBookmakerEvents = pXmlBookmakerEvents;
	}

	/**
	 * Gets the xml bookmaker events.
	 * 
	 * @return the xml bookmaker events
	 */
	public XmlBookmakerEvents getXmlBookmakerEvents() {
		return xmlBookmakerEvents;
	}
}
