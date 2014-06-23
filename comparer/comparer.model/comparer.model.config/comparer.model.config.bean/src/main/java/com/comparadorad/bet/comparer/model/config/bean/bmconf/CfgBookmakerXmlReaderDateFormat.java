/**
 *
 * Copyright (C) FACTORIA ETSIA S.L.
 * All Rights Reserved.
 * www.factoriaetsia.com
 *
 */
package com.comparadorad.bet.comparer.model.config.bean.bmconf;

import java.io.Serializable;

import javax.validation.constraints.NotNull;

import org.springframework.data.mongodb.core.mapping.Field;

/**
 * The Class CfgBookmakerXmlReaderDateFormat.
 */
@SuppressWarnings("serial")
public class CfgBookmakerXmlReaderDateFormat implements Serializable {

	/** The format. */
	@Field
	@NotNull
	private String format;

	/** The remove chars. */
	@Field
	private String[] removeChars;

	/**
	 * Instantiates a new cfg bookmaker xml reader date format.
	 */
	public CfgBookmakerXmlReaderDateFormat() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * Instantiates a new xml reader config date format.
	 * 
	 * @param pFormat
	 *            the format
	 */
	public CfgBookmakerXmlReaderDateFormat(final String pFormat) {
		super();
		format = pFormat;
	}

	/**
	 * Instantiates a new xml reader config date format.
	 * 
	 * @param pFormat
	 *            the format
	 * @param pRemoveChars
	 *            the remove chars
	 */
	public CfgBookmakerXmlReaderDateFormat(final String pFormat,
			String[] pRemoveChars) {
		super();
		format = pFormat;
		removeChars = pRemoveChars;
	}

	/**
	 * Gets the format.
	 * 
	 * @return the format
	 */
	public String getFormat() {
		return format;
	}

	/**
	 * Gets the removes the chars.
	 * 
	 * @return the removes the chars
	 */
	public String[] getRemoveChars() {
		return removeChars;
	}

	/**
	 * Sets the format.
	 * 
	 * @param pFormat
	 *            the new format
	 */
	public void setFormat(final String pFormat) {
		format = pFormat;
	}

	/**
	 * Sets the removes the chars.
	 * 
	 * @param pRemoveChars
	 *            the new removes the chars
	 */
	public void setRemoveChars(final String[] pRemoveChars) {
		removeChars = pRemoveChars;
	}
}