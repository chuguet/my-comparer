/**
 *
 * Copyright (C) FACTORIA ETSIA S.L.
 * All Rights Reserved.
 * www.factoriaetsia.com
 *
 */
package com.comparadorad.bet.comparer.synchro.reader.datasource.connect.xml.director;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.io.IOException;

import javax.inject.Inject;

import org.junit.Test;

import com.comparadorad.bet.comparer.synchro.reader.datasource.connect.xml.XmlDataFile;
import com.comparadorad.bet.comparer.synchro.reader.datasource.connect.xml.XmlDataFiles;
import com.comparadorad.bet.comparer.synchro.reader.datasource.connect.xml.builder.AbstractXmlBuilder;
import com.comparadorad.bet.comparer.synchro.reader.datasource.connect.xml.builder.XMLMultipleFeedBuilder;
import com.comparadorad.bet.comparer.synchro.reader.datasource.connect.xml.builder.XmlFeedBuilder;
import com.comparadorad.bet.comparer.synchro.reader.datasource.exception.XmlNotFoundException;
import com.comparadorad.bet.comparer.synchro.reader.datasource.test.util.AbstractServerTest;

/**
 * The Class XmlDirectorTest.
 */
public final class XmlDirectorTest extends AbstractServerTest {

	/** The Constant A_EXPRESSION. */
	private final static String A_EXPRESSION = "//a[contains(@href,'.')]/@href";

	/** The Constant HTTP_EXPRESSION. */
	private final static String XPATH_EXPRESSION = "//URL";
	
	@Inject
	private XmlFeedBuilder feedBuilder;
	
	@Test
	public final void testXMLbluesque() throws IOException, XmlNotFoundException {
		XmlDirector director = new XmlDirector();
		feedBuilder.setUrl("http://cubs.bluesq.com/cubs/cubs.php?action=dictionary");
		director.setBuilder(feedBuilder);
		XmlDataFiles xmlDataFiles = director.makeXML();
		assertEquals(xmlDataFiles.getDataFiles().size(), 1);
	}

	/**
	 * Test xml bookmaker feed builder.
	 * 
	 * @throws IOException
	 *             Signals that an I/O exception has occurred.
	 * @throws XmlNotFoundException 
	 */
	@Test
	public final void testXMLBookmakerFeedBuilder() throws IOException, XmlNotFoundException {
//		XmlDirector director = new XmlDirector();
//		AbstractXmlBuilder builder = new XmlFeedBuilder(getServerUrl()
//				+ "/?xmlFile=bet-at-home_1.xml");
//		director.setBuilder(builder);
//		XmlDataFiles xmlDataFiles = director.makeXML();
//		assertEquals(xmlDataFiles.getDataFiles().size(), 1);
//		for (XmlDataFile XmlDataFile : xmlDataFiles.getDataFiles()) {
//			assertTrue(XmlDataFile.isElementNew());
//		}
	}

	/**
	 * Test xml bookmaker feed builder two request.
	 * 
	 * @throws IOException
	 *             Signals that an I/O exception has occurred.
	 * @throws XmlNotFoundException 
	 */
	@Test
	public final void testXMLBookmakerFeedBuilderTwoRequest()
			throws IOException, XmlNotFoundException {

//		XmlDirector director;
//		AbstractXmlBuilder builder;
//		director = new XmlDirector();
//		builder = new XmlFeedBuilder(getServerUrl()
//				+ "/?xmlFile=bet-at-home_1.xml");
//		director.setBuilder(builder);
//		XmlDataFiles xmlDataFiles = director.makeXML();
//		assertEquals(xmlDataFiles.getDataFiles().size(), 1);
//		for (XmlDataFile XmlDataFile : xmlDataFiles.getDataFiles()) {
//			assertTrue(XmlDataFile.isElementNew());
//		}
//
//		builder = new XmlFeedBuilder(getServerUrl()
//				+ "/?xmlFile=bet-at-home_1.xml");
//		director.setBuilder(builder);
//		xmlDataFiles = director.makeXML();
//		for (XmlDataFile XmlDataFile : xmlDataFiles.getDataFiles()) {
//			assertFalse(XmlDataFile.isElementNew());
//		}
	}

	/**
	 * Test xml multiple feed builder htpp.
	 * 
	 * @throws IOException
	 *             Signals that an I/O exception has occurred.
	 */
	@Test
	public final void testXMLMultipleFeedBuilderFound() throws IOException {
//		XmlDirector director;
//		AbstractXmlBuilder builder;
//		director = new XmlDirector();
//		builder = new XMLMultipleFeedBuilder(getServerUrl()
//				+ "/?xmlFile=BetFred.xml", XPATH_EXPRESSION);
//		director.setBuilder(builder);
//		XmlDataFiles xmlDataFiles = director.makeXML();
//		assertNotNull(xmlDataFiles.getDataFiles());
//		assertEquals(xmlDataFiles.getDataFiles().size(), 2);
//		for (XmlDataFile XmlDataFile : xmlDataFiles.getDataFiles()) {
//			assertTrue(XmlDataFile.isElementNew());
//		}

	}

	/**
	 * Test xml multiple feed builder found1.
	 * 
	 * @throws IOException
	 *             Signals that an I/O exception has occurred.
	 */
	@Test
	public final void testXMLMultipleFeedBuilderFound1() throws IOException {
//		XmlDirector director;
//		AbstractXmlBuilder builder;
//		director = new XmlDirector();
//		builder = new XMLMultipleFeedBuilder(getServerUrl()
//				+ "/?xmlFile=Example_1.xml", A_EXPRESSION);
//		director.setBuilder(builder);
//		XmlDataFiles xmlDataFiles = director.makeXML();
//		assertNotNull(xmlDataFiles.getDataFiles());
//		assertEquals(xmlDataFiles.getDataFiles().size(), 1);
//		for (XmlDataFile XmlDataFile : xmlDataFiles.getDataFiles()) {
//			assertTrue(XmlDataFile.isElementNew());
//		}

	}

	/**
	 * Test xml multiple feed builder a.
	 * 
	 * @throws IOException
	 *             Signals that an I/O exception has occurred.
	 * @throws XmlNotFoundException 
	 */
	public final void testXMLMultipleFeedBuilderNotFound() throws IOException, XmlNotFoundException {
//		XmlDirector director;
//		AbstractXmlBuilder builder;
//		director = new XmlDirector();
//		builder = new XMLMultipleFeedBuilder(getServerUrl()
//				+ "/?xmlFile=BetFred.xml", A_EXPRESSION);
//		director.setBuilder(builder);
//		XmlDataFiles xmlDataFiles = director.makeXML();
//		assertEquals(xmlDataFiles.getDataFiles().size(), 0);
//		assertNotNull(xmlDataFiles.getDataFiles());
//		for (XmlDataFile XmlDataFile : xmlDataFiles.getDataFiles()) {
//			assertTrue(XmlDataFile.isElementNew());
//		}
	}

	/**
	 * Test xml multiple feed builder two request.
	 * 
	 * @throws IOException
	 *             Signals that an I/O exception has occurred.
	 */
	@Test
	public final void testXMLMultipleFeedBuilderTwoRequest() throws IOException {
//		XmlDirector director;
//		AbstractXmlBuilder builder;
//		director = new XmlDirector();
//		builder = new XMLMultipleFeedBuilder(getServerUrl()
//				+ "/?xmlFile=Example_2.xml", A_EXPRESSION);
//		director.setBuilder(builder);
//		XmlDataFiles xmlDataFiles = director.makeXML();
//		assertNotNull(xmlDataFiles.getDataFiles());
//		assertEquals(xmlDataFiles.getDataFiles().size(), 1);
//		for (XmlDataFile XmlDataFile : xmlDataFiles.getDataFiles()) {
//			assertTrue(XmlDataFile.isElementNew());
//		}
//		director = new XmlDirector();
//		builder = new XMLMultipleFeedBuilder(getServerUrl()
//				+ "/?xmlFile=Example_2.xml", A_EXPRESSION);
//		director.setBuilder(builder);
//		xmlDataFiles = director.makeXML();
//		assertNotNull(xmlDataFiles.getDataFiles());
//		assertEquals(xmlDataFiles.getDataFiles().size(), 1);
//		for (XmlDataFile XmlDataFile : xmlDataFiles.getDataFiles()) {
//			assertFalse(XmlDataFile.isElementNew());
//		}
//
	}

}
