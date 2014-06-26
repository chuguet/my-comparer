/**
 *
 * Copyright (C) FACTORIA ETSIA S.L.
 * All Rights Reserved.
 * www.factoriaetsia.com
 *
 */
package com.comparadorad.bet.comparer.synchro.reader.reader;

import java.io.IOException;
import java.io.InputStream;

import javax.annotation.Resource;

import org.apache.commons.io.IOUtils;
import org.apache.commons.io.input.CloseShieldInputStream;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.custommonkey.xmlunit.XMLAssert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.AnnotationConfigContextLoader;
import org.xml.sax.SAXException;

import com.comparadorad.bet.comparer.model.config.bean.bmconf.CfgBookmakerXmlReader;
import com.comparadorad.bet.comparer.synchro.reader.datasource.connect.xml.XmlDataFile;
import com.comparadorad.bet.comparer.synchro.reader.datasource.exception.XmlDataFileReaderException;
import com.comparadorad.bet.comparer.synchro.reader.reader.config.SynchroReaderReaderConfig;
import com.comparadorad.bet.comparer.synchro.reader.reader.data.XmlBetFileReaderData;
import com.comparadorad.bet.comparer.synchro.reader.reader.data.XmlBetFileReaderData.XmlBookmakerData;
import com.comparadorad.bet.comparer.synchro.reader.reader.data.XmlBetFileReaderResult;
import com.comparadorad.bet.comparer.synchro.reader.reader.exception.XmlReaderException;
import com.comparadorad.bet.comparer.util.commons.profile.ProfileConstant;
import com.comparadorad.bet.comparer.util.commons.xstream.XStreamUtil;
import com.thoughtworks.xstream.XStream;

/**
 * The Class AbstractXmlBetFileReaderServiceTest.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ActiveProfiles(ProfileConstant.TEST)
@ContextConfiguration(classes = SynchroReaderReaderConfig.class, loader = AnnotationConfigContextLoader.class)
public abstract class AbstractXmlBetFileReaderServiceTest {

	/** The Constant LOG. */
	private static final Log LOG = LogFactory
			.getLog(AbstractXmlBetFileReaderServiceTest.class);

	/** The xml bet file reader service. */
	@Resource
	private IXmlBetFileReaderService xmlBetFileReaderService;

	/**
	 * Do xml equal assertion.
	 * 
	 * @return true, if successful
	 */
	protected abstract boolean doXmlEqualAssertion();

	/**
	 * Gets the bookmaker name.
	 * 
	 * @return the bookmaker name
	 */
	protected abstract String getBookmakerName();

	/**
	 * Gets the cfg bookmaker xml reader.
	 * 
	 * @return the cfg bookmaker xml reader
	 */
	protected abstract CfgBookmakerXmlReader getCfgBookmakerXmlReader();

	/**
	 * Gets the xml bet file reader data.
	 * 
	 * @param fileName
	 *            the file name
	 * @param cfgBookmakerXmlReader
	 *            the xml reader config
	 * @return the xml bet file reader data
	 * @throws XmlDataFileReaderException
	 */
	private XmlBetFileReaderData getXmlBetFileReaderData(String fileName,
			CfgBookmakerXmlReader cfgBookmakerXmlReader)
			throws XmlDataFileReaderException {
		XmlDataFile xmlBookmakerFile = new XmlDataFile(
				new CloseShieldInputStream(getClass().getResourceAsStream(
						getClass().getSimpleName() + ".xml")), getClass()
						.getSimpleName() + ".xml");
		XmlBetFileReaderData xmlBetFileReaderData = new XmlBetFileReaderData(
				xmlBookmakerFile, cfgBookmakerXmlReader, new XmlBookmakerData(
						fileName));
		return xmlBetFileReaderData;
	}

	/**
	 * Log result.
	 * 
	 * @param obj
	 *            the obj
	 * @return the string
	 */
	private String logResult(Object obj) {
		String result = XStreamUtil.createXStream().toXML(obj);
		LOG.info(result);
		return result;
	}

	/**
	 * Test read bea at click.
	 * 
	 * @throws IOException
	 *             Signals that an I/O exception has occurred.
	 * @throws SAXException
	 *             the sAX exception
	 * @throws XmlReaderException
	 *             the xml reader exception
	 * @throws XmlDataFileReaderException
	 */
	@Test
	public void testBookmaker() throws IOException, SAXException,
			XmlReaderException, XmlDataFileReaderException {
		testRead(getBookmakerName());
	}

	/**
	 * Test read.
	 * 
	 * @param fileName
	 *            the file name
	 * @throws IOException
	 *             Signals that an I/O exception has occurred.
	 * @throws SAXException
	 *             the sAX exception
	 * @throws XmlReaderException
	 *             the xml reader exception
	 * @throws XmlDataFileReaderException
	 */
	private void testRead(String fileName) throws IOException, SAXException,
			XmlReaderException, XmlDataFileReaderException {
		final CfgBookmakerXmlReader cfgBookmakerXmlReader = getCfgBookmakerXmlReader();
		XmlBetFileReaderResult xmlBetFileReaderResult;
		xmlBetFileReaderResult = xmlBetFileReaderService
				.read(getXmlBetFileReaderData(fileName, cfgBookmakerXmlReader));
		String result = logResult(xmlBetFileReaderResult);
		if (doXmlEqualAssertion()) {
			InputStream inputStream = (getClass()
					.getResourceAsStream(getClass().getSimpleName()
							+ ".result.xml"));
			String expected = IOUtils.toString(inputStream);
			XMLAssert.assertXMLEqual(expected, result);
		}
	}
}
