/**
 *
 * Copyright (C) FACTORIA ETSIA S.L.
 * All Rights Reserved.
 * www.factoriaetsia.com
 *
 */
package com.comparadorad.bet.comparer.synchro.reader.readerbookmaker.core.readers;

import java.io.InputStream;

import com.comparadorad.bet.comparer.model.config.bean.bmconf.CfgBookmakerConfiguration;
import com.comparadorad.bet.comparer.synchro.reader.readerbookmaker.core.data.XmlBetFileReaderResult;
import com.comparadorad.bet.comparer.synchro.reader.readerbookmaker.core.exception.XmlReaderException;
import com.comparadorad.bet.comparer.synchro.reader.url.maker.bean.BeanAdditionalXmlInfoReader;

/**
 * The Interface IXMLFileReader.
 */
public interface IXMLFileReader {

	/**
	 * Read.
	 * 
	 * @param file
	 *            the file
	 * @param cfgBookmakerConfiguration
	 * @return the xml bet file reader result
	 * @throws XmlReaderException
	 *             the xml reader exception
	 */
	XmlBetFileReaderResult read(final InputStream file,
			final CfgBookmakerConfiguration cfgBookmakerConfiguration,
			final BeanAdditionalXmlInfoReader pBeanAdditionalXmlInfoReader, final String fileUrl)
			throws XmlReaderException;

	/**
	 * Gets the bookmaker id.
	 * 
	 * @return the bookmaker id
	 */
	String getBookmakerId();

}
