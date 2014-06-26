/**
 *
 * Copyright (C) FACTORIA ETSIA S.L.
 * All Rights Reserved.
 * www.factoriaetsia.com
 *
 */
package com.comparadorad.bet.comparer.synchro.reader.datasource.connect.xml;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.Serializable;

import org.apache.commons.io.IOUtils;
import org.apache.commons.io.input.CloseShieldInputStream;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.comparadorad.bet.comparer.synchro.reader.datasource.exception.XmlDataFileReaderException;

/**
 * The Class XMLBookmaker.
 */
@SuppressWarnings("serial")
public class XmlDataFile implements Serializable {

	/** The Constant LOG. */
	private static final Log LOG = LogFactory.getLog(XmlDataFile.class);

	/** The close shield input stream. */
	private final byte[] dataFile;

	/** The element new. */
	private boolean elementNew;

	/** The url. */
	private String url;

	/**
	 * Instantiates a new xML bookmaker.
	 *
	 * @param closeShieldInputStream the close shield input stream
	 * @param elementNew the element new
	 * @param url the url
	 * @throws XmlDataFileReaderException the xml data file reader exception
	 */
	public XmlDataFile(CloseShieldInputStream closeShieldInputStream,
			boolean elementNew, String url) throws XmlDataFileReaderException {
		this(closeShieldInputStream, url);
		this.elementNew = elementNew;
	}

	/**
	 * Instantiates a new xml data file.
	 *
	 * @param closeShieldInputStream the close shield input stream
	 * @param url the url
	 * @throws XmlDataFileReaderException the xml data file reader exception
	 */
	public XmlDataFile(final CloseShieldInputStream closeShieldInputStream, final String url)
			throws XmlDataFileReaderException {
		super();
		try {
			InputStream inputStream = closeShieldInputStream;
			if(inputStream != null){
				this.dataFile = IOUtils.toByteArray(inputStream);
			}else{
				this.dataFile = null;
			}
						
		} catch (IOException e) {
			LOG.error(e.getMessage(), e);
			throw new XmlDataFileReaderException(e.getMessage(), e);
		}
		this.url = url;
	}

	public byte[] getDataFile() {
		return dataFile;
	}

	/**
	 * Gets the close shield input stream.
	 * 
	 * @return the close shield input stream
	 */
	public InputStream getDataFileInputStream() {
		return new ByteArrayInputStream(this.dataFile);
	}
	
	


	/**
	 * Gets the url.
	 *
	 * @return the url
	 */
	public String getUrl() {
		return url;
	}

	/**
	 * Checks if is element new.
	 * 
	 * @return true, if is element new
	 */
	public boolean isElementNew() {
		return elementNew;
	}

	/**
	 * Sets the element new.
	 *
	 * @param pElementNew the new element new
	 */
	public void setElementNew(boolean pElementNew) {
		elementNew = pElementNew;
	}

	/**
	 * Sets the url.
	 *
	 * @param pUrl the new url
	 */
	public void setUrl(String pUrl) {
		url = pUrl;
	}
	
	
	
	

}
