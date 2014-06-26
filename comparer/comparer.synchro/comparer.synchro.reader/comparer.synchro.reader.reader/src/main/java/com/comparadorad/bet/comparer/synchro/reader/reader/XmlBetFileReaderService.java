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

import javax.inject.Inject;

import nu.xom.Builder;
import nu.xom.Document;
import nu.xom.ParsingException;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Service;

import com.comparadorad.bet.comparer.synchro.reader.model.XmlBookmakerEvents;
import com.comparadorad.bet.comparer.synchro.reader.reader.XmlReaderHandlerConfiguration.XmlDateFormatUtil;
import com.comparadorad.bet.comparer.synchro.reader.reader.data.XmlBetFileReaderData;
import com.comparadorad.bet.comparer.synchro.reader.reader.data.XmlBetFileReaderResult;
import com.comparadorad.bet.comparer.synchro.reader.reader.exception.XmlReaderException;
import com.comparadorad.bet.comparer.synchro.reader.reader.exception.XmlReaderRuntimeException;

/**
 * The Class XmlBetFileReaderService.
 */
@Service
class XmlBetFileReaderService implements IXmlBetFileReaderService {

	/** The Constant LOG. */
	private static final Log LOG = LogFactory
			.getLog(XmlBetFileReaderService.class);

	/** The xml bet file reader node reader. */
	@Inject
	private XmlBetFileReaderNodeVisitor xmlBetFileReaderNodeVisitor;

	/**
	 * Read.
	 * 
	 * @param pXmlBetFileReaderData
	 *            the xml bet file reader data
	 * @return the xml bet file reader result {@inheritDoc}
	 */
	@Override
	public XmlBetFileReaderResult read(
			final XmlBetFileReaderData pXmlBetFileReaderData)
			throws XmlReaderException {
		Document document = readXom(pXmlBetFileReaderData.getXmlBookmakerFile()
				.getDataFileInputStream());
		XmlReaderHandlerConfiguration xmlReaderHandlerConfiguration = new XmlReaderHandlerConfiguration(
				pXmlBetFileReaderData);

		if (pXmlBetFileReaderData.getXmlReaderConfig() == null
				|| pXmlBetFileReaderData.getXmlReaderConfig()
						.getXmlReaderConfigDateFormat() == null
				|| pXmlBetFileReaderData.getXmlReaderConfig()
						.getXmlReaderConfigDateFormat().getFormat() == null) {
			throw new XmlReaderRuntimeException(
					"Date format configuration is mandatory");
		}
		xmlReaderHandlerConfiguration.setDateUtil(new XmlDateFormatUtil(
				pXmlBetFileReaderData.getXmlReaderConfig()
						.getXmlReaderConfigDateFormat().getFormat(),
				pXmlBetFileReaderData.getXmlReaderConfig()
						.getXmlReaderConfigDateFormat().getRemoveChars(),
				pXmlBetFileReaderData.getXmlReaderConfig()
						.getCfgBookmakerXmlReaderTimeZoneFormat()));

		XmlBookmakerEvents xmlBookmakerEvents = xmlBetFileReaderNodeVisitor
				.readDocument(document, pXmlBetFileReaderData,
						xmlReaderHandlerConfiguration);
		XmlBetFileReaderResult xmlBetFileReaderResult = new XmlBetFileReaderResult(
				xmlBookmakerEvents);
		return xmlBetFileReaderResult;
	}

	/**
	 * Read xsom.
	 * 
	 * @param inputStream
	 *            the input stream
	 * @return the document
	 */
	private Document readXom(InputStream inputStream) {
		try {
			// Date initTime = new Date();
			Builder parser = new Builder();
			Document doc = parser.build(inputStream);

			// Date endTime = new Date();
			// LOG.info("initTime: " + initTime + "  endTime: " + endTime);
			return doc;
		} catch (ParsingException ex) {
			LOG.error(ex.getMessage(), ex);
			throw new XmlReaderRuntimeException(ex.getMessage(), ex);
		} catch (IOException ex) {
			LOG.error(ex.getMessage(), ex);
			throw new XmlReaderRuntimeException(ex.getMessage(), ex);
		}
	}
}
