/**
 *
 * Copyright (C) FACTORIA ETSIA S.L.
 * All Rights Reserved.
 * www.factoriaetsia.com
 *
 */
package com.comparadorad.bet.comparer.synchro.reader.datasource.connect.xml;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * The Class XMLBookmaker.
 */
@SuppressWarnings("serial")
public class XmlDataFiles implements Serializable, Iterable<XmlDataFile> {

	/** The data files. */
	private List<XmlDataFile> dataFiles;

	/**
	 * Aet data file.
	 * 
	 * @param pXmlDataFile
	 *            the xml data file
	 * @return true, if successful
	 */
	public boolean addDataFile(XmlDataFile pXmlDataFile) {
		if (dataFiles == null) {
			dataFiles = new ArrayList<XmlDataFile>();
		}
		return dataFiles.add(pXmlDataFile);
	}

	/**
	 * Gets the data files.
	 * 
	 * @return the data files
	 */
	public List<XmlDataFile> getDataFiles() {
		return dataFiles;
	}

	/** {@inheritDoc} */
	@Override
	public Iterator<XmlDataFile> iterator() {
		if (dataFiles != null) {
			return dataFiles.iterator();
		}
		return null;
	}

	/**
	 * Sets the data files.
	 * 
	 * @param pDataFiles
	 *            the new data files
	 */
	public void setDataFiles(List<XmlDataFile> pDataFiles) {
		dataFiles = pDataFiles;
	}

}
