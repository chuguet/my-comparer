/**
 *
 * Copyright (C) FACTORIA ETSIA S.L.
 * All Rights Reserved.
 * www.factoriaetsia.com
 *
 */
package com.comparadorad.bet.comparer.synchro.reader.datasource.bookmaker;

import java.io.IOException;
import java.util.Date;
import java.util.List;

import javax.inject.Inject;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Service;

import com.comparadorad.bet.comparer.model.config.bean.CfgBookmaker;
import com.comparadorad.bet.comparer.model.config.bean.bmconf.CfgBookmakerDataUrl;
import com.comparadorad.bet.comparer.model.log.bean.LogEventBookmakerMasterWords;
import com.comparadorad.bet.comparer.model.log.service.ILogEventService;
import com.comparadorad.bet.comparer.synchro.reader.datasource.connect.xml.XmlDataFile;
import com.comparadorad.bet.comparer.synchro.reader.datasource.connect.xml.XmlDataFiles;
import com.comparadorad.bet.comparer.synchro.reader.datasource.connect.xml.builder.AbstractXmlBuilder;
import com.comparadorad.bet.comparer.synchro.reader.datasource.connect.xml.builder.XMLMultipleFeedBuilder;
import com.comparadorad.bet.comparer.synchro.reader.datasource.connect.xml.builder.XmlFeedBuilder;
import com.comparadorad.bet.comparer.synchro.reader.datasource.connect.xml.director.XmlDirector;
import com.comparadorad.bet.comparer.synchro.reader.datasource.exception.XmlNotFoundException;

/**
 * The Class DsBookmakerDatasource.
 */
@Service
public class DsBookmakerDatasource {

	private static final Log LOG = LogFactory.getLog(DsBookmakerDatasource.class);

	/** The application context. */
	@Inject
	private ApplicationContext applicationContext;

	/**
	 * Gets the xml data files.
	 * 
	 * @param bookmaker
	 *            the bookmaker
	 * @return the xml data files
	 * @throws IOException
	 *             Signals that an I/O exception has occurred.
	 * @throws XmlNotFoundException 
	 */
	public XmlDataFiles getXmlDataFiles(final CfgBookmaker bookmaker) throws IOException, XmlNotFoundException {
		XmlDirector director;
		AbstractXmlBuilder builder;
		director = new XmlDirector();

		XmlDataFiles xmlDataFiles = new XmlDataFiles();
		if (bookmaker.getBookmakerConfiguration() == null || bookmaker.getBookmakerConfiguration().getBookmakerUrl() == null) {
			LOG.error(new StringBuffer("DATASOURCE_READER: No está informada la configuración del bookmaker").append(bookmaker)
					.append(" - ").append(new Date()).toString());
		} else {
			for (CfgBookmakerDataUrl bookmakerDataUrl : bookmaker.getBookmakerConfiguration().getBookmakerUrl()) {
				// TODO recoger el xpath
				String xpath = null;
				if (xpath == null || "".equals(xpath)) {
					builder = applicationContext.getBean(XmlFeedBuilder.class);
				} else {
					builder = applicationContext.getBean(XMLMultipleFeedBuilder.class);
					// TODO poner el xpat
					((XMLMultipleFeedBuilder) builder).setXpathExpression(null);
				}
				builder.setUrl(bookmakerDataUrl.getUrl());

				director.setBuilder(builder);

				XmlDataFiles tmpXmlDataFiles = director.makeXML();
				for (XmlDataFile xmlDataFile : tmpXmlDataFiles) {
					xmlDataFiles.addDataFile(xmlDataFile);
				}

			}
		}

		return xmlDataFiles;
	}

	/**
	 * Gets the xml data files.
	 * 
	 * @param url
	 *            the url
	 * @return the xml data files
	 * @throws IOException
	 *             Signals that an I/O exception has occurred.
	 * @throws XmlNotFoundException 
	 */
	public XmlDataFiles getXmlDataFiles(final String url) throws IOException, XmlNotFoundException {

		XmlDirector director;
		AbstractXmlBuilder builder;
		XmlDataFiles xmlDataFiles;
		XmlDataFiles tmpXmlDataFiles;

		director = new XmlDirector();
		xmlDataFiles = new XmlDataFiles();

		builder = applicationContext.getBean(XmlFeedBuilder.class);
		builder.setUrl(url);

		director.setBuilder(builder);

		tmpXmlDataFiles = director.makeXML();
		for (XmlDataFile xmlDataFile : tmpXmlDataFiles) {
			xmlDataFiles.addDataFile(xmlDataFile);
		}

		return xmlDataFiles;
	}

	/**
	 * Gets the xml data files.
	 * 
	 * @param urls
	 *            the urls
	 * @return the xml data files
	 * @throws IOException
	 *             Signals that an I/O exception has occurred.
	 * @throws XmlNotFoundException 
	 */
	public XmlDataFiles getXmlDataFiles(final List<String> urls) throws IOException, XmlNotFoundException {

		XmlDirector director;
		AbstractXmlBuilder builder;
		XmlDataFiles xmlDataFiles;
		XmlDataFiles tmpXmlDataFiles;

		director = new XmlDirector();
		xmlDataFiles = new XmlDataFiles();

		for (String url : urls) {

			builder = applicationContext.getBean(XmlFeedBuilder.class);
			builder.setUrl(url);

			director.setBuilder(builder);

			tmpXmlDataFiles = director.makeXML();
			for (XmlDataFile xmlDataFile : tmpXmlDataFiles) {
				xmlDataFiles.addDataFile(xmlDataFile);
			}

		}

		return xmlDataFiles;
	}
}
