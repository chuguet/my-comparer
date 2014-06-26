/**
 *
 * Copyright (C) FACTORIA ETSIA S.L.
 * All Rights Reserved.
 * www.factoriaetsia.com
 *
 */
package com.comparadorad.bet.comparer.synchro.reader.model;

import org.springframework.stereotype.Component;

import com.comparadorad.bet.comparer.model.config.bean.CfgBetType.CfgBetTypeId;

/**
 * The Class XmlMaximumGoalerAttribute.
 */
@Component
@SuppressWarnings("serial")
public class XmlMaximumGoalerAttribute extends AbstractXMLAttribute {

	/** The cfg bet type id. */
	private String cfgBetTypeId;

	/** The winner name. */
	private XmlMatchParticipant goaler;

	/**
	 * Instantiates a new xml maximum goaler attribute.
	 */
	public XmlMaximumGoalerAttribute() {
		super();
		this.cfgBetTypeId = CfgBetTypeId.MAXIMO_GOLEADOR.nameId();
	}

	/**
	 * Instantiates a new xml maximum goaler attribute.
	 * 
	 * @param goaler
	 *            the goaler
	 */
	public XmlMaximumGoalerAttribute(XmlMatchParticipant goaler) {
		super();
		this.goaler = goaler;
		this.cfgBetTypeId = CfgBetTypeId.MAXIMO_GOLEADOR.nameId();
	}

	/**
	 * Gets the cfg bet type id.
	 * 
	 * @return the cfg bet type id
	 */
	public String getCfgBetTypeId() {
		return cfgBetTypeId;
	}

	/**
	 * Gets the goaler.
	 * 
	 * @return the goaler
	 */
	public XmlMatchParticipant getGoaler() {
		return goaler;
	}

	/**
	 * Sets the cfg bet type id.
	 * 
	 * @param cfgBetTypeId
	 *            the new cfg bet type id
	 */
	public void setCfgBetTypeId(String cfgBetTypeId) {
		this.cfgBetTypeId = cfgBetTypeId;
	}

	/**
	 * Sets the goaler.
	 * 
	 * @param goaler
	 *            the new goaler
	 */
	public void setGoaler(XmlMatchParticipant goaler) {
		this.goaler = goaler;
	}
}
