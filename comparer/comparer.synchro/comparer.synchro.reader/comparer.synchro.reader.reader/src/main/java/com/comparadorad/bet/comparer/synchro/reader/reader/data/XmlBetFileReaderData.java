/**
 *
 * Copyright (C) FACTORIA ETSIA S.L.
 * All Rights Reserved.
 * www.factoriaetsia.com
 *
 */
package com.comparadorad.bet.comparer.synchro.reader.reader.data;

import com.comparadorad.bet.comparer.model.config.bean.CfgBookmaker;
import com.comparadorad.bet.comparer.model.config.bean.bmconf.CfgBookmakerXmlReader;
import com.comparadorad.bet.comparer.synchro.reader.datasource.connect.xml.XmlDataFile;

/**
 * The Class XmlBetFileReaderData.
 */
public class XmlBetFileReaderData {

	/**
	 * The Class XmlBookmakerData.
	 */
	public static class XmlBookmakerData {

		/**
		 * Instantiates a new xml bookmaker data.
		 * 
		 * @param pCfgBookmaker
		 *            the cfg bookmaker
		 */
		public XmlBookmakerData(CfgBookmaker pCfgBookmaker) {
			super();
			cfgBookmaker = pCfgBookmaker;
		}

		/**
		 * Instantiates a new xml bookmaker data.
		 */
		public XmlBookmakerData() {
			super();
		}

		/** The cfg bookmaker. */
		private CfgBookmaker cfgBookmaker;

		/** The bookmakerId. */
		private String bookmakerId;

		/** The name. */
		private String name;

		/**
		 * Instantiates a new xml bookmaker data.
		 * 
		 * @param pName
		 *            the name
		 */
		public XmlBookmakerData(String pName) {
			super();
			name = pName;
		}

		/**
		 * Gets the bookmakerId.
		 * 
		 * @return the bookmakerId
		 */
		public String getBookmakerId() {
			if (cfgBookmaker != null && cfgBookmaker.getObjectId() != null) {
				return cfgBookmaker.getObjectId().toString();
			}
			return bookmakerId;
		}

		/**
		 * Gets the name.
		 * 
		 * @return the name
		 */
		public String getName() {
			if (cfgBookmaker != null) {
				return cfgBookmaker.getName(null);
			}
			return name;
		}

		/**
		 * Sets the bookmakerId.
		 * 
		 * @param pId
		 *            the new bookmakerId
		 */
		public void setBookmakerId(String pId) {
			bookmakerId = pId;
		}
	}

	/** The xml bookmaker data. */
	private final XmlBookmakerData xmlBookmakerData;

	/** The xml bookmaker file. */
	private final XmlDataFile xmlBookmakerFile;

	/** The xml reader config. */
	private final CfgBookmakerXmlReader cfgBookmakerXmlReader;

	/**
	 * Instantiates a new xml bet file reader data.
	 * 
	 * @param pXmlBookmakerFile
	 *            the xml bookmaker file
	 * @param pCfgBookmakerXmlReader
	 *            the xml reader config
	 * @param pXmlBookmakerData
	 *            the xml bookmaker data
	 */
	public XmlBetFileReaderData(final XmlDataFile pXmlBookmakerFile,
			CfgBookmakerXmlReader pCfgBookmakerXmlReader,
			final XmlBookmakerData pXmlBookmakerData) {
		super();
		xmlBookmakerFile = pXmlBookmakerFile;
		this.cfgBookmakerXmlReader = pCfgBookmakerXmlReader;
		this.xmlBookmakerData = pXmlBookmakerData;
	}

	/**
	 * Instantiates a new xml bet file reader data.
	 * 
	 * @param pXmlBookmakerFile
	 *            the xml bookmaker file
	 * @param bookmaker
	 *            the bookmaker
	 */
	public XmlBetFileReaderData(final XmlDataFile pXmlBookmakerFile,
			final CfgBookmaker bookmaker) {
		super();
		xmlBookmakerFile = pXmlBookmakerFile;
		this.cfgBookmakerXmlReader = bookmaker.getBookmakerXmlReader();
		this.xmlBookmakerData = new XmlBookmakerData(bookmaker);
	}

	/**
	 * Gets the xml bookmaker data.
	 * 
	 * @return the xml bookmaker data
	 */
	public XmlBookmakerData getXmlBookmakerData() {
		return xmlBookmakerData;
	}

	/**
	 * Gets the xml bookmaker file.
	 * 
	 * @return the xml bookmaker file
	 */
	public XmlDataFile getXmlBookmakerFile() {
		return xmlBookmakerFile;
	}

	/**
	 * Gets the xml reader config.
	 * 
	 * @return the xml reader config
	 */
	public CfgBookmakerXmlReader getXmlReaderConfig() {
		return cfgBookmakerXmlReader;
	}
}
