/**
 *
 * Copyright (C) FACTORIA ETSIA S.L.
 * All Rights Reserved.
 * www.factoriaetsia.com
 *
 */
package com.comparadorad.bet.comparer.model.config.bean.bmconf;

import java.net.MalformedURLException;
import java.net.URL;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.springframework.data.mongodb.core.mapping.Field;

import com.comparadorad.bet.comparer.model.core.bean.AbstractId;
import com.comparadorad.bet.comparer.model.core.bean.IDocumentField;

/**
 * The Class BookmakerUrl.
 * 
 * @author imayoral
 * @version 1.0
 */
public class CfgBookmakerWebUrl extends AbstractId implements IDocumentField {

	/** The url. */
	@Field
	private String url;

	/**
	 * Instantiates a new bookmaker url.
	 */
	public CfgBookmakerWebUrl() {
		super();
	}

	/**
	 * Instantiates a new bookmaker url.
	 * 
	 * @param pUrl
	 *            the url
	 */
	public CfgBookmakerWebUrl(final String pUrl) {
		super();
		url = pUrl;
	}

	/**
	 * Equals.
	 * 
	 * @param object
	 *            the object
	 * @return true, if successful
	 * @see java.lang.Object#equals(Object)
	 */
	public boolean equals(final Object object) {
		if (!(object instanceof CfgBookmakerWebUrl)) {
			return false;
		}
		final CfgBookmakerWebUrl rhs = (CfgBookmakerWebUrl) object;
		return new EqualsBuilder().appendSuper(super.equals(object))
				.append(this.url, rhs.url).isEquals();
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
	 * Hash code.
	 * 
	 * @return the int
	 * @see java.lang.Object#hashCode()
	 */
	public int hashCode() {
		return new HashCodeBuilder(1033368571, -2056658453)
				.appendSuper(super.hashCode()).append(this.url).toHashCode();
	}

	/**
	 * Sets the url.
	 * 
	 * @param pUrl
	 *            the new url
	 */
	public void setUrl(final String pUrl) {
		try {
			new URL(pUrl);
			this.url = pUrl;
		} catch (MalformedURLException e) {
			throw new RuntimeException(e.getMessage(), e);
		}
	}
}