/**
 *
 * Copyright (C) FACTORIA ETSIA S.L.
 * All Rights Reserved.
 * www.factoriaetsia.com
 *
 */
package com.comparadorad.bet.comparer.synchro.reader.model;

import static org.junit.Assert.assertNotNull;

import java.io.InputStream;

import org.junit.Test;

import com.comparadorad.bet.comparer.util.commons.xstream.XStreamUtil;
import com.thoughtworks.xstream.XStream;

/**
 * The Class XmlXstreamReaderSampleTest.
 * 
 * Example class of how to read an XML with xstream with XmlBookMakerEvents
 * structure
 */
public class XmlXstreamReaderSampleTest {

	/**
	 * Read xstream test1.
	 */
	@Test
	public void readXstreamTest1() {
		XmlBookmakerEvents xmlBookmakerEvents = readFile("readXstreamTest1");
		assertNotNull(xmlBookmakerEvents);
	}

	/**
	 * Read file.
	 * 
	 * @param subName
	 *            the sub name
	 * @return the xml bookmaker events
	 */
	private XmlBookmakerEvents readFile(String subName) {
		String fileName = getClass().getSimpleName() + "." + subName + ".xml";
		// XmlXstreamReaderSampleTest.readXstreamTest1.xml
		InputStream inputStream = getClass().getResourceAsStream(fileName);
		XmlBookmakerEvents result = (XmlBookmakerEvents) XStreamUtil
				.createXStream().fromXML(inputStream);
		return result;

	}
}
