/**
 *
 * Copyright (C) FACTORIA ETSIA S.L.
 * All Rights Reserved.
 * www.factoriaetsia.com
 *
 */
package com.comparadorad.bet.comparer.model.config.bean.bmconf;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import org.springframework.data.mongodb.core.mapping.Field;

import com.comparadorad.bet.comparer.model.config.bean.bmconf.CfgBookmakerXmlReader.DataLocation;

/**
 * The Class AbstractCfgBookmakerXmlReaderData.
 */
@SuppressWarnings("serial")
public abstract class AbstractCfgBookmakerXmlReaderData implements Serializable {

	/** The Constant XML_ID_PARAM. */
	public static final String XML_ID_PARAM = "bmInternalId";

	/** The Constant XML_NAME_PARAM. */
	public static final String XML_NAME_PARAM = "name";

	/** The xml reader config data parameters. */
	@Field
	private List<CfgBookmakerXmlReaderParam> cfgBookmakerXmlReaderParams = new ArrayList<CfgBookmakerXmlReaderParam>();

	/** The different id param. */
	@Field
	private boolean differentIdParam;

	/** The different name param. */
	@Field
	private boolean differentNameParam;

	/** The empty reader. */
	private boolean emptyReader = false;

	/** The general xml reader config data parameters. */
	@Field
	private List<CfgBookmakerXmlReaderParam> generalConfigDataParameters;

	/** The generator. */
	@Field
	private String generator;

	/** The node name. */
	@Field
	private String nodePath;

	/** The ResetDataInResolver. */
	@Field
	private ResetDataInResolver resetDataInResolver;

	/**
	 * Instantiates a new abstract cfg bookmaker xml reader data.
	 */
	public AbstractCfgBookmakerXmlReaderData() {
		super();
	}

	/**
	 * Instantiates a new abstract cfg bookmaker xml reader data.
	 * 
	 * @param pGenerator
	 *            the generator
	 */
	public AbstractCfgBookmakerXmlReaderData(String pGenerator) {
		super();
		generator = pGenerator;
	}

	/**
	 * Instantiates a new abstract cfg bookmaker xml reader data.
	 * 
	 * @param pNodeName
	 *            the node name
	 * @param pGenerator
	 *            the generator
	 */
	public AbstractCfgBookmakerXmlReaderData(String pNodeName, String pGenerator) {
		super();
		nodePath = pNodeName;
		generator = pGenerator;
	}

	/**
	 * Adds the general xml reader config data parameter.
	 * 
	 * @param pReaderConfigDataParameters
	 *            the reader config data parameters
	 */
	public void addGeneralXmlReaderConfigDataParameter(
			List<CfgBookmakerXmlReaderParam> pReaderConfigDataParameters) {
		if (this.generalConfigDataParameters == null) {
			this.generalConfigDataParameters = pReaderConfigDataParameters;
		}
	}

	/**
	 * Adds the xml reader config data parameter.
	 * 
	 * @param pCfgBookmakerXmlReaderParam
	 *            the xml reader config data parameter
	 */
	public void addXmlReaderConfigDataParameter(
			CfgBookmakerXmlReaderParam pCfgBookmakerXmlReaderParam) {
		this.cfgBookmakerXmlReaderParams.add(pCfgBookmakerXmlReaderParam);
	}

	/**
	 * Adds the xml reader config data parameter.
	 * 
	 * @param pReaderId
	 *            the reader id
	 * @param dataLocation
	 *            the data location
	 */
	public void addXmlReaderConfigDataParameter(String pReaderId,
			DataLocation dataLocation) {
		this.addXmlReaderConfigDataParameter(new CfgBookmakerXmlReaderParam(
				pReaderId, dataLocation));
	}

	/**
	 * Adds the xml reader config data parameter.
	 * 
	 * @param pReaderId
	 *            the reader id
	 * @param pXmlExtraInfoParam
	 *            the xml extra info param
	 */
	public void addXmlReaderConfigDataParameter(String pReaderId,
			String pXmlExtraInfoParam) {
		this.addXmlReaderConfigDataParameter(new CfgBookmakerXmlReaderParam(
				pReaderId, pXmlExtraInfoParam));
	}

	/**
	 * Adds the xml reader config data parameter.
	 * 
	 * @param pReaderId
	 *            the reader id
	 * @param pXmlAttributeName
	 *            the xml attribute name
	 * @param pXmlNodeName
	 *            the xml node name
	 * @param pDataLocation
	 *            the data location
	 */
	public void addXmlReaderConfigDataParameter(String pReaderId,
			String pXmlAttributeName, String pXmlNodeName,
			DataLocation pDataLocation) {
		this.addXmlReaderConfigDataParameter(new CfgBookmakerXmlReaderParam(
				pReaderId, pXmlAttributeName, pXmlNodeName, pDataLocation));
	}

	/**
	 * Gets the bm internal id param param.
	 * 
	 * @return the bm internal id param param
	 */
	public CfgBookmakerXmlReaderParam getBmInternalIdParamParam() {
		return getXmlReaderConfigDataParameter(XML_ID_PARAM);
	}

	/**
	 * Gets the generator.
	 * 
	 * @return the generator
	 */
	public String getGenerator() {
		return generator;
	}

	/**
	 * Gets the xml name param.
	 * 
	 * @return the xml name param
	 */
	public CfgBookmakerXmlReaderParam getNameParam() {
		return getXmlReaderConfigDataParameter(XML_NAME_PARAM);
	}

	/**
	 * Gets the node path.
	 * 
	 * @return the node path
	 */
	public String getNodePath() {
		return nodePath;
	}

	/**
	 * Gets the reset data in resolver.
	 * 
	 * @return the reset data in resolver
	 */
	public ResetDataInResolver getResetDataInResolver() {
		if (resetDataInResolver == null) {
			resetDataInResolver = new ResetDataInResolver();
		}
		return resetDataInResolver;
	}

	/**
	 * Gets the xml reader config data parameter.
	 * 
	 * @param pReaderId
	 *            the reader id
	 * @return the xml reader config data parameter
	 */
	public CfgBookmakerXmlReaderParam getXmlReaderConfigDataParameter(
			String pReaderId) {
		CfgBookmakerXmlReaderParam result = null;
		for (CfgBookmakerXmlReaderParam pXmlReaderConfigDataParameter : cfgBookmakerXmlReaderParams) {
			if (pXmlReaderConfigDataParameter != null
					&& pXmlReaderConfigDataParameter.equalsReaderId(pReaderId)) {
				result = pXmlReaderConfigDataParameter;
				break;
			}
		}
		if (result == null) {
			if (generalConfigDataParameters != null) {
				for (CfgBookmakerXmlReaderParam pXmlReaderConfigDataParameter : generalConfigDataParameters) {
					if (pXmlReaderConfigDataParameter != null
							&& pXmlReaderConfigDataParameter
									.equalsReaderId(pReaderId)) {
						result = pXmlReaderConfigDataParameter;
						break;
					}
				}
			}
		}
		return result;
	}

	/**
	 * Gets the xml reader config data parameter xml attribute name.
	 * 
	 * @param pReaderId
	 *            the reader id
	 * @return the xml reader config data parameter xml attribute name
	 */
	public String getXmlReaderConfigDataParameterXmlAttributeName(
			String pReaderId) {
		CfgBookmakerXmlReaderParam result = this
				.getXmlReaderConfigDataParameter(pReaderId);
		if (result != null) {
			return result.getXmlAttributeName();
		}
		return null;
	}

	/**
	 * Gets the xml reader config data parameter xml extra info param.
	 * 
	 * @param pReaderId
	 *            the reader id
	 * @return the xml reader config data parameter xml extra info param
	 */
	public String getXmlReaderConfigDataParameterXmlExtraInfoParam(
			String pReaderId) {
		CfgBookmakerXmlReaderParam result = this
				.getXmlReaderConfigDataParameter(pReaderId);
		if (result != null) {
			return result.getXmlExtraInfoParam();
		}
		return null;
	}

	/**
	 * Gets the xml reader config data parameter xml node name.
	 * 
	 * @param pReaderId
	 *            the reader id
	 * @return the xml reader config data parameter xml node name
	 */
	public String getXmlReaderConfigDataParameterXmlNodeName(String pReaderId) {
		CfgBookmakerXmlReaderParam result = this
				.getXmlReaderConfigDataParameter(pReaderId);
		if (result != null) {
			return result.getXmlNodeName();
		}
		return null;
	}

	/**
	 * Checks if is different id param.
	 * 
	 * @return true, if is different id param
	 */
	public boolean isDifferentIdParam() {
		return differentIdParam;
	}

	/**
	 * Checks if is different name param.
	 * 
	 * @return true, if is different name param
	 */
	public boolean isDifferentNameParam() {
		return differentNameParam;
	}

	/**
	 * Checks if is empty reader.
	 * 
	 * @return true, if is empty reader
	 */
	public boolean isEmptyReader() {
		return emptyReader;
	}

	/**
	 * Sets the different id param.
	 * 
	 * @param dataLocation
	 *            the data location
	 * @param xmlAttributeName
	 *            the xml attribute name
	 * @param xmlNodeName
	 *            the xml node name
	 */
	public void setDifferentIdParam(DataLocation dataLocation,
			String xmlAttributeName, String xmlNodeName) {
		differentIdParam = true;
		this.addXmlReaderConfigDataParameter(XML_ID_PARAM, xmlAttributeName,
				xmlNodeName, dataLocation);
	}

	/**
	 * Sets the different name param.
	 * 
	 * @param dataLocation
	 *            the data location
	 * @param xmlAttributeName
	 *            the xml attribute name
	 * @param xmlNodeName
	 *            the xml node name
	 */
	public void setDifferentNameParam(DataLocation dataLocation,
			String xmlAttributeName, String xmlNodeName) {
		differentNameParam = true;
		this.addXmlReaderConfigDataParameter(XML_NAME_PARAM, xmlAttributeName,
				xmlNodeName, dataLocation);
	}

	/**
	 * Sets the empty reader.
	 * 
	 * @param pEmptyReader
	 *            the new empty reader
	 */
	public void setEmptyReader(boolean pEmptyReader) {
		emptyReader = pEmptyReader;
	}

	/**
	 * Sets the generator.
	 * 
	 * @param pGenerator
	 *            the new generator
	 */
	public void setGenerator(String pGenerator) {
		generator = pGenerator;
	}

	/**
	 * Sets the node path.
	 * 
	 * @param pNodePath
	 *            the new node path
	 */
	public void setNodePath(String pNodePath) {
		nodePath = pNodePath;
	}

	/**
	 * Sets the Reset data in resolver.
	 * 
	 * @param resetDataInResolver
	 *            the new reset data in resolver
	 */
	public void setResetDataInResolver(ResetDataInResolver resetDataInResolver) {
		this.resetDataInResolver = resetDataInResolver;
	}
}