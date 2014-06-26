/**
 *
 * Copyright (C) FACTORIA ETSIA S.L.
 * All Rights Reserved.
 * www.factoriaetsia.com
 *
 */
package com.comparadorad.bet.comparer.synchro.reader.app.bookmaker;

import java.io.Serializable;

import com.comparadorad.bet.comparer.synchro.reader.model.XmlMatch;

/**
 * The Class XmlMatchWithHash.
 */
@SuppressWarnings("serial")
public class XmlMatchWithHash implements Serializable {

	/** The xml match. */
	private final XmlMatch xmlMatch;

	/** The hash. */
	private final String hash;

	/**
	 * Instantiates a new xml match with hash.
	 *
	 * @param xmlMatch the xml match
	 * @param hash the hash
	 */
	public XmlMatchWithHash(XmlMatch xmlMatch, String hash) {
		super();
		this.xmlMatch = xmlMatch;
		this.hash = hash;
	}

	/**
	 * Gets the xml match.
	 *
	 * @return the xml match
	 */
	public XmlMatch getXmlMatch() {
		return xmlMatch;
	}

	/**
	 * Gets the hash.
	 *
	 * @return the hash
	 */
	public String getHash() {
		return hash;
	}

	/** {@inheritDoc} */ 
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((hash == null) ? 0 : hash.hashCode());
		result = prime * result
				+ ((xmlMatch == null) ? 0 : xmlMatch.hashCode());
		return result;
	}

	/** {@inheritDoc} */ 
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		XmlMatchWithHash other = (XmlMatchWithHash) obj;
		if (hash == null) {
			if (other.hash != null)
				return false;
		} else if (!hash.equals(other.hash))
			return false;
		if (xmlMatch == null) {
			if (other.xmlMatch != null)
				return false;
		} else if (!xmlMatch.equals(other.xmlMatch))
			return false;
		return true;
	}

}
