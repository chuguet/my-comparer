/**
 *
 * Copyright (C) FACTORIA ETSIA S.L.
 * All Rights Reserved.
 * www.factoriaetsia.com
 *
 */
package com.comparadorad.bet.comparer.synchro.reader.readerbookmaker.core.data;

import com.comparadorad.bet.comparer.model.config.bean.CfgBookmaker;
import com.comparadorad.bet.comparer.model.config.bean.bmconf.CfgBookmakerConfiguration;
import com.comparadorad.bet.comparer.model.config.bean.bmconf.CfgBookmakerXmlReader;
import com.comparadorad.bet.comparer.synchro.reader.datasource.connect.xml.XmlDataFile;
import com.comparadorad.bet.comparer.synchro.reader.url.maker.bean.BeanAdditionalXmlInfoReader;

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
		
		public CfgBookmakerConfiguration getBookmakerConfiguration() {
			if (cfgBookmaker != null && cfgBookmaker.getObjectId() != null) {
				return cfgBookmaker.getBookmakerConfiguration();
			}
			return null;
		}
	}

	/** The xml bookmaker data. */
	private final XmlBookmakerData xmlBookmakerData;

	/** The xml bookmaker file. */
	private final XmlDataFile xmlBookmakerFile;

	/** The xml reader config. */
	private final CfgBookmakerXmlReader cfgBookmakerXmlReader;
	
	private final BeanAdditionalXmlInfoReader beanAdditionalXmlInfoReader;

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
			final XmlBookmakerData pXmlBookmakerData, final BeanAdditionalXmlInfoReader pBeanAdditionalXmlInfoReader) {
		super();
		xmlBookmakerFile = pXmlBookmakerFile;
		this.cfgBookmakerXmlReader = pCfgBookmakerXmlReader;
		this.xmlBookmakerData = pXmlBookmakerData;
		this.beanAdditionalXmlInfoReader = pBeanAdditionalXmlInfoReader;
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
			final CfgBookmaker bookmaker ,final BeanAdditionalXmlInfoReader pBeanAdditionalXmlInfoReader) {
		super();
		xmlBookmakerFile = pXmlBookmakerFile;
		this.cfgBookmakerXmlReader = bookmaker.getBookmakerXmlReader();
		this.xmlBookmakerData = new XmlBookmakerData(bookmaker);
		this.beanAdditionalXmlInfoReader = pBeanAdditionalXmlInfoReader;
	}

	/**
	 * Gets the xml bookmaker data.
	 * 
	 * @return the xml bookmaker data
	 */
	public XmlBookmakerData getXmlBookmakerData() {
		return xmlBookmakerData;
	}

	// /**
	// * Gets the xml bookmaker file.
	// *
	// * @return the xml bookmaker file
	// */
	// public XmlDataFiles getXmlBookmakerFile() {
	// XmlDataFiles list = new XmlDataFiles();
	// list.addDataFile(xmlBookmakerFile);
	// return list;
	// }

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

	public BeanAdditionalXmlInfoReader getBeanAdditionalXmlInfoReader() {
		return beanAdditionalXmlInfoReader;
	}
	
	
}
