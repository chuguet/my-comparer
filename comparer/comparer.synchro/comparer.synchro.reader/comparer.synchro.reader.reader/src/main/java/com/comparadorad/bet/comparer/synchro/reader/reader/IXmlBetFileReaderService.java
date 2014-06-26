/**
 *
 * Copyright (C) FACTORIA ETSIA S.L.
 * All Rights Reserved.
 * www.factoriaetsia.com
 *
 */
package com.comparadorad.bet.comparer.synchro.reader.reader;

import com.comparadorad.bet.comparer.synchro.reader.reader.data.XmlBetFileReaderData;
import com.comparadorad.bet.comparer.synchro.reader.reader.data.XmlBetFileReaderResult;
import com.comparadorad.bet.comparer.synchro.reader.reader.exception.XmlReaderException;

/**
 * The Interface IXmlBetFileReader.
 */
public interface IXmlBetFileReaderService {

	/**
	 * Read.
	 * 
	 * @param pXmlBetFileReaderData
	 *            the xml bet file reader data
	 * @return the xml bet file reader result
	 * @throws XmlReaderException
	 *             the xml reader exception
	 */
	XmlBetFileReaderResult read(final XmlBetFileReaderData pXmlBetFileReaderData)
			throws XmlReaderException;

}
