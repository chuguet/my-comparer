/**
 *
 * Copyright (C) FACTORIA ETSIA S.L.
 * All Rights Reserved.
 * www.factoriaetsia.com
 *
 */
package com.comparadorad.bet.comparer.synchro.reader.readerbookmaker.core;

import com.comparadorad.bet.comparer.synchro.reader.readerbookmaker.core.data.XmlBetFileReaderData;
import com.comparadorad.bet.comparer.synchro.reader.readerbookmaker.core.data.XmlBetFileReaderResult;
import com.comparadorad.bet.comparer.synchro.reader.readerbookmaker.core.exception.XmlReaderException;

/**
 * The Interface IXmlBetFileReaderBookMakerService.
 */
public interface IXmlBetFileReaderBookMakerService {

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
