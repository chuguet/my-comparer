/**
 *
 * Copyright (C) FACTORIA ETSIA S.L.
 * All Rights Reserved.
 * www.factoriaetsia.com
 *
 */
package com.comparadorad.bet.comparer.synchro.reader.readerbookmaker.core;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.comparadorad.bet.comparer.synchro.reader.readerbookmaker.core.data.XmlBetFileReaderData;
import com.comparadorad.bet.comparer.synchro.reader.readerbookmaker.core.data.XmlBetFileReaderResult;
import com.comparadorad.bet.comparer.synchro.reader.readerbookmaker.core.exception.XmlReaderException;
import com.comparadorad.bet.comparer.synchro.reader.readerbookmaker.core.readers.IXMLFileReader;

/**
 * The Class XMLBetFileReaderBookMakerService.
 */
@Service
public class XMLBetFileReaderBookMakerService implements
		IXmlBetFileReaderBookMakerService {

	/** The readers. */
	@Inject
	private List<IXMLFileReader> readers;

	/**
	 * Read.
	 * 
	 * @param pXmlBetFileReaderData
	 *            the xml bet file reader data
	 * @return the xml bet file reader result
	 * @throws XmlReaderException
	 *             the xml reader exception {@inheritDoc}
	 */
	@Override
	public XmlBetFileReaderResult read(
			XmlBetFileReaderData pXmlBetFileReaderData)
			throws XmlReaderException {
		IXMLFileReader theReader = null;
		for (IXMLFileReader reader : readers) {
			if (pXmlBetFileReaderData.getXmlBookmakerData().getBookmakerId()
					.equals(reader.getBookmakerId())) {
				theReader = reader;
				break;
			}
		}
		// InputStream[] dataFileInputStream = new
		// InputStream[pXmlBetFileReaderData
		// .getXmlBookmakerFile().getDataFiles().size()];
		//
		// for (int i = 0; i < pXmlBetFileReaderData.getXmlBookmakerFile()
		// .getDataFiles().size(); i++) {
		// dataFileInputStream[i] = pXmlBetFileReaderData
		// .getXmlBookmakerFile().getDataFiles().get(i)
		// .getDataFileInputStream();
		// }
		// return theReader.read(dataFileInputStream);
		return theReader.read(pXmlBetFileReaderData.getXmlBookmakerFile()
				.getDataFileInputStream(), pXmlBetFileReaderData
				.getXmlBookmakerData().getBookmakerConfiguration(),
				pXmlBetFileReaderData.getBeanAdditionalXmlInfoReader(), pXmlBetFileReaderData.getXmlBookmakerFile().getUrl());
	}

}
