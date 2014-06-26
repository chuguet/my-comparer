/**
 *
 * Copyright (C) FACTORIA ETSIA S.L.
 * All Rights Reserved.
 * www.factoriaetsia.com
 *
 */
package com.comparadorad.bet.comparer.synchro.reader.reader.handler;

import java.io.IOException;
import java.io.InputStream;
import java.util.Date;

import nu.xom.Builder;
import nu.xom.Document;
import nu.xom.Element;
import nu.xom.ParsingException;

import org.apache.commons.io.input.CloseShieldInputStream;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.comparadorad.bet.comparer.model.config.bean.bmconf.CfgBookmakerXmlReader;
import com.comparadorad.bet.comparer.model.config.repository.writer.bm.CfgBookmakerXmlReaderBetAtClickTestData;
import com.comparadorad.bet.comparer.model.config.repository.writer.bm.CfgBookmakerXmlReaderTitanBetTestData;
import com.comparadorad.bet.comparer.model.config.repository.writer.bm.ICfgBookmakerXmlReaderTestData;
import com.comparadorad.bet.comparer.synchro.reader.datasource.connect.xml.XmlDataFile;
import com.comparadorad.bet.comparer.synchro.reader.datasource.exception.XmlDataFileReaderException;
import com.comparadorad.bet.comparer.synchro.reader.reader.XmlReaderHandlerConfiguration;
import com.comparadorad.bet.comparer.synchro.reader.reader.XmlReaderHandlerConfiguration.XmlDateFormatUtil;
import com.comparadorad.bet.comparer.synchro.reader.reader.data.XmlBetFileReaderData;
import com.comparadorad.bet.comparer.synchro.reader.reader.data.XmlBetFileReaderData.XmlBookmakerData;

/**
 * The Class AbstractReadHandlerTest.
 */
abstract class AbstractReadHandlerTest {
	/** The Constant LOG. */
	private static final Log LOG = LogFactory
			.getLog(AbstractReadHandlerTest.class);

	/**
	 * Instantiates a new abstract read handler test.
	 */
	public AbstractReadHandlerTest() {
		super();
	}

	/**
	 * Gets the cfg bookmaker xml reader.
	 * 
	 * @param id
	 *            the id
	 * @return the cfg bookmaker xml reader
	 */
	private CfgBookmakerXmlReader getCfgBookmakerXmlReader(String id) {
		ICfgBookmakerXmlReaderTestData result = null;
		if ("BetAtClick".equals(id)) {
			result = new CfgBookmakerXmlReaderBetAtClickTestData();
		} else if ("TitanBet".equals(id)) {
			result = new CfgBookmakerXmlReaderTitanBetTestData();
		}
		return result.getCfgBookmakerXmlReader();
	}

	/**
	 * Gets the xml sport read handler.
	 * 
	 * @param id
	 *            the id
	 * @param path
	 *            the path
	 * @return the xml sport read handler
	 * @throws XmlDataFileReaderException
	 *             the xml data file reader exception
	 */
	protected AbstractXmlBetFileReaderHandler getXmlReadHandler(String id,
			String path) throws XmlDataFileReaderException {
		String fileName = this.getClass().getSimpleName() + "." + id + ".xml";

		final XmlDataFile pXmlBookmakerFile = new XmlDataFile(
				new CloseShieldInputStream(getClass().getResourceAsStream(
						fileName)), "url");// "ejemplo_1.xml");

		CfgBookmakerXmlReader cfgBookmakerXmlReader = getCfgBookmakerXmlReader(id);
		final XmlBookmakerData xmlBookmakerData = new XmlBookmakerData(id);

		XmlBetFileReaderData xmlBetFileReaderData = new XmlBetFileReaderData(
				pXmlBookmakerFile, cfgBookmakerXmlReader, xmlBookmakerData);
		XmlReaderHandlerConfiguration xmlReaderHandlerConfiguration = new XmlReaderHandlerConfiguration(
				xmlBetFileReaderData);

		xmlReaderHandlerConfiguration.setDateUtil(new XmlDateFormatUtil(
				xmlBetFileReaderData.getXmlReaderConfig()
						.getXmlReaderConfigDateFormat().getFormat(),
				xmlBetFileReaderData.getXmlReaderConfig()
						.getXmlReaderConfigDateFormat().getRemoveChars(),
				xmlBetFileReaderData.getXmlReaderConfig()
						.getCfgBookmakerXmlReaderTimeZoneFormat()));

		/*
		 * AbstractCfgBookmakerXmlReaderData abstractCfgBookmakerXmlReaderData =
		 * cfgBookmakerXmlReader .getXmlReaderConfigData(path);
		 */

		AbstractXmlBetFileReaderHandler readerHandler = XmlBetFileReaderHandlerFactory
				.getGeneratorObject(path, cfgBookmakerXmlReader,
						xmlReaderHandlerConfiguration);
		return readerHandler;
	}

	/**
	 * Read xsom.
	 * 
	 * @param inputStream
	 *            the input stream
	 * @return the document
	 */
	protected Document readXsom(InputStream inputStream) {
		try {
			Date initTime = new Date();
			Builder parser = new Builder();
			Document doc = parser.build(inputStream);

			Date endTime = new Date();
			LOG.info("initTime: " + initTime + "  endTime: " + endTime);
			return doc;
		} catch (ParsingException ex) {
			LOG.error(ex.getMessage(), ex);
			throw new RuntimeException(ex.getMessage(), ex);
		} catch (IOException ex) {
			LOG.error(ex.getMessage(), ex);
			throw new RuntimeException(ex.getMessage(), ex);
		}
	}

	/**
	 * Read xsom.
	 * 
	 * @param id
	 *            the id
	 * @return the document
	 */
	protected Element readXsom(String id) {
		String fileName = this.getClass().getSimpleName() + "." + id + ".xml";
		LOG.info("fileName: " + fileName);
		InputStream inputStream = getClass().getResourceAsStream(fileName);
		try {
			Date initTime = new Date();
			Builder parser = new Builder();
			Document doc = parser.build(inputStream);

			Date endTime = new Date();
			LOG.info("initTime: " + initTime + "  endTime: " + endTime);
			return doc.getRootElement();
		} catch (ParsingException ex) {
			LOG.error(ex.getMessage(), ex);
			throw new RuntimeException(ex.getMessage(), ex);
		} catch (IOException ex) {
			LOG.error(ex.getMessage(), ex);
			throw new RuntimeException(ex.getMessage(), ex);
		}
	}
}