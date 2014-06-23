/**
 *
 * Copyright (C) FACTORIA ETSIA S.L.
 * All Rights Reserved.
 * www.factoriaetsia.com
 *
 */
package com.comparadorad.bet.comparer.model.config.bean.bmconf;

import java.io.Serializable;

import org.springframework.data.mongodb.core.mapping.Field;

import com.comparadorad.bet.comparer.model.config.bean.bmconf.CfgBookmakerXmlReader.DataLocation;

/**
 * The Class CfgBookmakerXmlReaderParam.
 */
@SuppressWarnings("serial")
public class CfgBookmakerXmlReaderParam implements Serializable {

	/** The Constant XML_ID_PARAM. */
	public static final String XML_ID_PARAM = "bmInternalId";

	/** The Constant XML_NAME_PARAM. */
	public static final String XML_NAME_PARAM = "name";

	/** True data location. */
	@Field
	private DataLocation dataLocation;

	/** The reader id. */
	@Field
	private String readerId;

	/** The xml attribute name. */
	@Field
	private String xmlAttributeName;

	/** The xml extra information parameter. */
	@Field
	private String xmlExtraInfoParam;

	/** The xml node name. */
	@Field
	private String xmlNodeName;

	/**
	 * Instantiates a new xml reader config data parameter.
	 */
	public CfgBookmakerXmlReaderParam() {
		super();
	}

	/**
	 * Instantiates a new xml reader config data parameter.
	 * 
	 * @param readerId
	 *            the reader id
	 * @param dataLocation
	 *            the data location
	 */
	public CfgBookmakerXmlReaderParam(String readerId, DataLocation dataLocation) {
		super();
		this.readerId = readerId;
		this.dataLocation = dataLocation;
	}

	/**
	 * Instantiates a new xml reader config data parameter.
	 * 
	 * @param pReaderId
	 *            the reader id
	 * @param pXmlExtraInfoParam
	 *            the xml extra info param
	 */
	public CfgBookmakerXmlReaderParam(String pReaderId,
			String pXmlExtraInfoParam) {
		super();
		readerId = pReaderId;
		xmlExtraInfoParam = pXmlExtraInfoParam;
	}

	/**
	 * Instantiates a new xml reader config data parameter.
	 * 
	 * @param readerId
	 *            the reader id
	 * @param xmlAttributeName
	 *            the xml attribute name
	 * @param dataLocation
	 *            the dataLocation
	 */
	public CfgBookmakerXmlReaderParam(String readerId, String xmlAttributeName,
			DataLocation dataLocation) {
		super();
		this.readerId = readerId;
		this.xmlAttributeName = xmlAttributeName;
		this.dataLocation = dataLocation;
	}

	/**
	 * Instantiates a new xml reader config data parameter.
	 * 
	 * @param readerId
	 *            the reader id
	 * @param xmlAttributeName
	 *            the xml attribute name
	 * @param xmlNodeName
	 *            the xml node name
	 * @param dataLocation
	 *            the dataLocation
	 */
	public CfgBookmakerXmlReaderParam(String readerId, String xmlAttributeName,
			String xmlNodeName, DataLocation dataLocation) {
		super();
		this.readerId = readerId;
		this.xmlAttributeName = xmlAttributeName;
		this.xmlNodeName = xmlNodeName;
		this.dataLocation = dataLocation;
	}

	/**
	 * Equals reader id.
	 * 
	 * @param pReaderId
	 *            the reader id
	 * @return true, if successful
	 */
	public boolean equalsReaderId(String pReaderId) {
		return pReaderId != null && readerId != null
				&& readerId.equals(pReaderId);
	}

	/**
	 * Gets the data location.
	 * 
	 * @return the data location
	 */
	public DataLocation getDataLocation() {
		return dataLocation;
	}

	/**
	 * Gets the reader id.
	 * 
	 * @return the reader id
	 */
	public String getReaderId() {
		return readerId;
	}

	/**
	 * Gets the xml attribute name.
	 * 
	 * @return the xml attribute name
	 */
	public String getXmlAttributeName() {
		return xmlAttributeName;
	}

	/**
	 * Gets the xml extra info param.
	 * 
	 * @return the xml extra info param
	 */
	public String getXmlExtraInfoParam() {
		return xmlExtraInfoParam;
	}

	/**
	 * Gets the xml node name.
	 * 
	 * @return the xml node name
	 */
	public String getXmlNodeName() {
		return xmlNodeName;
	}

	/**
	 * Sets the data location.
	 * 
	 * @param dataLocation
	 *            the new data location
	 */
	public void setDataLocation(DataLocation dataLocation) {
		this.dataLocation = dataLocation;
	}

	/**
	 * Sets the reader id.
	 * 
	 * @param pReaderId
	 *            the new reader id
	 */
	public void setReaderId(String pReaderId) {
		readerId = pReaderId;
	}

	/**
	 * Sets the xml attribute name.
	 * 
	 * @param pXmlAttributeName
	 *            the new xml attribute name
	 */
	public void setXmAttributelName(String pXmlAttributeName) {
		xmlAttributeName = pXmlAttributeName;
	}

	/**
	 * Sets the xml extra info param.
	 * 
	 * @param pXmlExtraInfoParam
	 *            the new xml extra info param
	 */
	public void setXmlExtraInfoParam(String pXmlExtraInfoParam) {
		xmlExtraInfoParam = pXmlExtraInfoParam;
	}

	/**
	 * Sets the xml node name.
	 * 
	 * @param pXmlNodeName
	 *            the new xml node name
	 */
	public void setXmlNodeName(String pXmlNodeName) {
		xmlNodeName = pXmlNodeName;
	}
}