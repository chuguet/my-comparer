/**
 *
 * Copyright (C) FACTORIA ETSIA S.L.
 * All Rights Reserved.
 * www.factoriaetsia.com
 *
 */
package com.comparadorad.bet.comparer.model.config.bean.bmconf;

import java.util.ArrayList;
import java.util.List;

import org.springframework.data.mongodb.core.mapping.Field;

import com.comparadorad.bet.comparer.model.core.bean.IDocumentField;

/**
 * The Class CfgBookmakerXmlReader.
 */
@SuppressWarnings("serial")
public class CfgBookmakerXmlReader implements IDocumentField {

	/**
	 * The Enumeration DataLocation.
	 */
	public enum DataLocation {

		/** The BROTHE r_ nod e_ attribute. */
		BROTHER_NODE_ATTRIBUTE,
		/** The BROTHE r_ nod e_ body. */
		BROTHER_NODE_BODY,
		/** The CHIL d_ nod e_ attribute. */
		CHILD_NODE_ATTRIBUTE,
		/** The CHIL d_ nod e_ body. */
		CHILD_NODE_BODY,
		/** The CURREN t_ nod e_ attribute. */
		CURRENT_NODE_ATTRIBUTE,
		/** The CURREN t_ nod e_ body. */
		CURRENT_NODE_BODY,
		/** The CURREN t_ nod e_ pat h_ name. */
		CURRENT_NODE_PATH_NAME,
		/** The PAREN t_ nod e_ attribute. */
		PARENT_NODE_ATTRIBUTE,
		/** The PAREN t_ nod e_ body. */
		PARENT_NODE_BODY;
	}

	/** The xml reader config date format. */
	@Field
	private CfgBookmakerXmlReaderDateFormat cfgBookmakerXmlReaderDateFormat;

	/** The general xml reader config data parameters. */
	@Field
	private final List<CfgBookmakerXmlReaderParam> generalConfigDataParameters = new ArrayList<CfgBookmakerXmlReaderParam>();

	/** The xml reader config data list. */
	@Field
	private final List<AbstractCfgBookmakerXmlReaderData> xmlReaderConfigDataList = new ArrayList<AbstractCfgBookmakerXmlReaderData>();

	/** The cfg bookmaker xml reader time zone format. */
	@Field
	private String cfgBookmakerXmlReaderTimeZoneFormat;
	
	@Field
	private boolean xmlMarketBetEnabled = false;

	public boolean isXmlMarketBetEnabled() {
		return xmlMarketBetEnabled;
	}

	public void setXmlMarketBetEnabled(boolean pXmlMarketBetEnabled) {
		xmlMarketBetEnabled = pXmlMarketBetEnabled;
	}

	/**
	 * Gets the cfg bookmaker xml reader time zone format.
	 * 
	 * @return the cfg bookmaker xml reader time zone format
	 */
	public String getCfgBookmakerXmlReaderTimeZoneFormat() {
		return cfgBookmakerXmlReaderTimeZoneFormat;
	}

	/**
	 * Sets the cfg bookmaker xml reader time zone format.
	 * 
	 * @param pCfgBookmakerXmlReaderTimeZoneFormat
	 *            the new cfg bookmaker xml reader time zone format
	 */
	public void setCfgBookmakerXmlReaderTimeZoneFormat(
			String pCfgBookmakerXmlReaderTimeZoneFormat) {
		cfgBookmakerXmlReaderTimeZoneFormat = pCfgBookmakerXmlReaderTimeZoneFormat;
	}

	/**
	 * Adds the general xml reader config data parameter.
	 * 
	 * @param pCfgBookmakerXmlReaderParam
	 *            the xml reader config data parameter
	 */
	public void addGeneralXmlReaderConfigDataParameter(
			CfgBookmakerXmlReaderParam pCfgBookmakerXmlReaderParam) {
		this.generalConfigDataParameters.add(pCfgBookmakerXmlReaderParam);
	}

	/**
	 * Adds the general xml reader config data parameter.
	 * 
	 * @param pDataLocation
	 *            the data location
	 * @param pReaderId
	 *            the reader id
	 * @param pXmlAttributeName
	 *            the xml attribute name
	 * @param pXmlNodeName
	 *            the xml node name
	 */
	public void addGeneralXmlReaderConfigDataParameter(
			DataLocation pDataLocation, String pReaderId,
			String pXmlAttributeName, String pXmlNodeName) {
		this.addGeneralXmlReaderConfigDataParameter(new CfgBookmakerXmlReaderParam(
				pReaderId, pXmlAttributeName, pXmlNodeName, pDataLocation));
	}

	/**
	 * Adds the xml reader config data.
	 * 
	 * @param pAbstractCfgBookmakerXmlReaderData
	 *            the xml reader config data
	 */
	public void addXmlReaderConfigData(
			AbstractCfgBookmakerXmlReaderData pAbstractCfgBookmakerXmlReaderData) {
		if (pAbstractCfgBookmakerXmlReaderData != null) {
			this.xmlReaderConfigDataList
					.add(pAbstractCfgBookmakerXmlReaderData);
			pAbstractCfgBookmakerXmlReaderData
					.addGeneralXmlReaderConfigDataParameter(this.generalConfigDataParameters);
		}
	}

	/**
	 * Adds the xml reader config data factory.
	 * 
	 * @param <T>
	 *            the generic type
	 * @param pNodePath
	 *            the node path
	 * @param xmlReaderDataClass
	 *            the xml reader data class
	 * @return the t
	 */
	public <T extends AbstractCfgBookmakerXmlReaderData> T xmlReaderConfigDataFactory(
			String pNodePath, Class<T> xmlReaderDataClass) {
		try {
			T xmlReaderData = xmlReaderDataClass.newInstance();
			xmlReaderData.setNodePath(pNodePath);
			return xmlReaderData;
		} catch (InstantiationException e) {
			throw new CfgBookmakerXmlReaderException(e.getMessage(), e);
		} catch (IllegalAccessException e) {
			throw new CfgBookmakerXmlReaderException(e.getMessage(), e);
		}

	}

	/**
	 * Gets the xml reader config data.
	 * 
	 * @param nodePath
	 *            the node path
	 * @return the xml reader config data
	 */
	public AbstractCfgBookmakerXmlReaderData getXmlReaderConfigData(
			final String nodePath) {
		AbstractCfgBookmakerXmlReaderData result = null;
		for (AbstractCfgBookmakerXmlReaderData abstractCfgBookmakerXmlReaderData : xmlReaderConfigDataList) {
			if (nodePath.equalsIgnoreCase(abstractCfgBookmakerXmlReaderData
					.getNodePath())) {
				abstractCfgBookmakerXmlReaderData
						.addGeneralXmlReaderConfigDataParameter(this.generalConfigDataParameters);
				result = abstractCfgBookmakerXmlReaderData;
				break;
			}
		}
		return result;
	}

	/**
	 * Gets the xml reader config data list.
	 * 
	 * @return the xml reader config data list
	 */
	public List<AbstractCfgBookmakerXmlReaderData> getXmlReaderConfigDataList() {
		return xmlReaderConfigDataList;
	}

	/**
	 * Gets the xml reader config date format.
	 * 
	 * @return the xml reader config date format
	 */
	public CfgBookmakerXmlReaderDateFormat getXmlReaderConfigDateFormat() {
		return cfgBookmakerXmlReaderDateFormat;
	}

	/**
	 * Sets the xml reader config date format.
	 * 
	 * @param pCfgBookmakerXmlReaderDateFormat
	 *            the new xml reader config date format
	 */
	public void setXmlReaderConfigDateFormat(
			CfgBookmakerXmlReaderDateFormat pCfgBookmakerXmlReaderDateFormat) {
		cfgBookmakerXmlReaderDateFormat = pCfgBookmakerXmlReaderDateFormat;
	}

	/**
	 * Sets the xml reader config date format.
	 * 
	 * @param pFormat
	 *            the format
	 */
	public void setXmlReaderConfigDateFormat(final String pFormat) {
		cfgBookmakerXmlReaderDateFormat = new CfgBookmakerXmlReaderDateFormat(
				pFormat);
	}

	/**
	 * Sets the xml reader config date format.
	 * 
	 * @param pFormat
	 *            the format
	 * @param pRemoveChars
	 *            the remove chars
	 */
	public void setXmlReaderConfigDateFormat(final String pFormat,
			final String[] pRemoveChars) {
		cfgBookmakerXmlReaderDateFormat = new CfgBookmakerXmlReaderDateFormat(
				pFormat, pRemoveChars);
	}

}
