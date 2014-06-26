/**
 *
 * Copyright (C) FACTORIA ETSIA S.L.
 * All Rights Reserved.
 * www.factoriaetsia.com
 *
 */
package com.comparadorad.bet.comparer.synchro.reader.datasource.connect.xml.director;

import java.io.IOException;
import java.util.HashMap;

import org.apache.commons.io.input.CloseShieldInputStream;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.comparadorad.bet.comparer.synchro.reader.datasource.connect.xml.XmlDataFile;
import com.comparadorad.bet.comparer.synchro.reader.datasource.connect.xml.XmlDataFiles;
import com.comparadorad.bet.comparer.synchro.reader.datasource.connect.xml.builder.AbstractXmlBuilder;
import com.comparadorad.bet.comparer.synchro.reader.datasource.crypt.Encrypt;
import com.comparadorad.bet.comparer.synchro.reader.datasource.crypt.impl.EncryptImpl;
import com.comparadorad.bet.comparer.synchro.reader.datasource.exception.XmlDataFileReaderException;
import com.comparadorad.bet.comparer.synchro.reader.datasource.exception.XmlNotFoundException;

/**
 * The Class XmlDirector.
 */
public class XmlDirector {

	/** The bookmaker map. */
	private static HashMap<String, String> bookmakerMap;

	/** The Constant LOG. */
	private static final Log LOG = LogFactory.getLog(XmlDirector.class);

	static {
		bookmakerMap = new HashMap<String, String>();
	}

	/** The builder. */
	private AbstractXmlBuilder builder;

	/** The encrypt. */
	private Encrypt encrypt;

	/**
	 * Instantiates a new xML bookmaker director.
	 */
	public XmlDirector() {
		super();
	}

	/**
	 * Instantiates a new xML bookmaker director.
	 * 
	 * @param builder
	 *            the builder
	 */
	public XmlDirector(AbstractXmlBuilder builder) {
		super();
		this.builder = builder;
	}

	/**
	 * Checks if is xml new.
	 * 
	 * @param closeShieldInputStream
	 *            the close shield input stream
	 * @param url
	 *            the url
	 * @return true, if is xml new
	 * @throws XmlDataFileReaderException
	 *             the xml data file reader exception
	 */
	protected boolean isXmlNew(CloseShieldInputStream closeShieldInputStream,
			String url) throws XmlDataFileReaderException {
		encrypt = new EncryptImpl();
		int len = 0;
		int size = 1024;
		byte[] buf;
		String md5;
		String md5After = null;
		boolean result = false;
		try {
			size = closeShieldInputStream.available();
			buf = new byte[size];
			len = closeShieldInputStream.read(buf, 0, size);
			md5 = encrypt.md5(Integer.toString(len));

			if (bookmakerMap.containsKey(url)) {
				md5After = bookmakerMap.get(url);
			}
			if (!md5.equals(md5After)) {
				bookmakerMap.put(url, md5);
				result = true;
			}
		} catch (IOException e) {
			LOG.error(e.getMessage());
			throw new XmlDataFileReaderException(e.getMessage(), e);
		}
		return result;
	}

	/**
	 * Make xml.
	 * 
	 * @return the xML bookmaker
	 * @throws IOException
	 *             Signals that an I/O exception has occurred.
	 * @throws XmlNotFoundException 
	 */
	public XmlDataFiles makeXML() throws IOException, XmlNotFoundException {
		try {
			builder.connect();
			XmlDataFiles xmlDataFiles = new XmlDataFiles();
			Boolean flag = Boolean.TRUE;
			if (builder != null && builder.format() != null
					&& builder.format().getDataFiles() != null) {
				for (XmlDataFile file : builder.format()) {
					flag = isXmlNew(
							new CloseShieldInputStream(
									file.getDataFileInputStream()),
							file.getUrl());
					file.setElementNew(flag);
					xmlDataFiles.addDataFile(file);
				}
			}
			return xmlDataFiles;
		} catch (XmlDataFileReaderException e) {
			LOG.error(e.getMessage(), e);
			throw new IOException(e.getMessage(), e);
		}
	}

	/**
	 * Sets the builder.
	 * 
	 * @param builder
	 *            the new builder
	 */
	public void setBuilder(AbstractXmlBuilder builder) {
		this.builder = builder;
	}

}
