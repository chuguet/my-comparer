/**
 *
 * Copyright (C) FACTORIA ETSIA S.L.
 * All Rights Reserved.
 * www.factoriaetsia.com
 *
 */
package com.comparadorad.bet.comparer.app.util.xml.download.app;

import java.io.IOException;
import java.net.URL;
import java.util.Date;

import javax.inject.Inject;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.junit.Test;

import com.comparadorad.bet.comparer.app.util.xml.download.AbstractXmlDownloadTest;
import com.comparadorad.bet.comparer.app.util.xml.download.app.task.DownloadXmlTasklet;
import com.comparadorad.bet.comparer.synchro.reader.datasource.exception.XmlNotFoundException;
import com.comparadorad.bet.comparer.synchro.server.dummy.XmlBetDummyServerParams;

/**
 * The Class DownloadXmlTaskletTest.
 */
public class DownloadXmlTaskletTest extends AbstractXmlDownloadTest {

	/** The Constant LOG. */
	private static final Log LOG = LogFactory
			.getLog(DownloadXmlTaskletTest.class);

	@Inject
	private XmlBetDummyServerParams xmlBetDummyServerParams;

	/**
	 * Test.
	 * 
	 * @throws IOException
	 *             Signals that an I/O exception has occurred.
	 * @throws XmlNotFoundException 
	 */
	@Test
	public void testExecuteBetatHome() throws IOException, XmlNotFoundException {
		DownloadXmlTasklet downloadXmlTasklet = new DownloadXmlTasklet();
		downloadXmlTasklet.setDate(new Date());
		downloadXmlTasklet.setName("betAtHome");
		downloadXmlTasklet.setUrl(new URL(xmlBetDummyServerParams
				.getServerUrl() + "/?xmlFile=bet-at-home.xml"));
		downloadXmlTasklet.setXpath("");
		LOG.info("Reading: [" + downloadXmlTasklet.getName() + "] URL: ["
				+ downloadXmlTasklet.getUrl() + "]");
		downloadXmlTasklet.execute();
	}

	/**
	 * Test execute bet click.
	 * 
	 * @throws IOException
	 *             Signals that an I/O exception has occurred.
	 * @throws XmlNotFoundException 
	 */
	@Test
	public void testExecuteBetClick() throws IOException, XmlNotFoundException {
		DownloadXmlTasklet downloadXmlTasklet = new DownloadXmlTasklet();
		downloadXmlTasklet.setDate(new Date());
		downloadXmlTasklet.setName("betClick");
		downloadXmlTasklet.setUrl(new URL(xmlBetDummyServerParams
				.getServerUrl()
				+ "/?"
				+ xmlBetDummyServerParams.getProxiedUrlparam()
				+ "=http://xml.betclick.com/odds_en.xml"));
		//downloadXmlTasklet.setXpath("//a[contains(@href,'.')]/@href");
		LOG.info("Reading: [" + downloadXmlTasklet.getName() + "] URL: ["
				+ downloadXmlTasklet.getUrl() + "]");
		downloadXmlTasklet.execute();
	}
}
