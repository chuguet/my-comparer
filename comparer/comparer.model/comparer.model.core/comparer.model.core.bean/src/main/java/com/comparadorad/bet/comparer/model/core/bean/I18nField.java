/**
 *
 * Copyright (C) FACTORIA ETSIA S.L.
 * All Rights Reserved.
 * www.factoriaetsia.com
 *
 */
package com.comparadorad.bet.comparer.model.core.bean;

import java.util.Locale;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import org.apache.commons.lang.builder.HashCodeBuilder;
import org.hibernate.validator.constraints.NotEmpty;

/**
 * The Class I18n.
 * 
 * @author imayoral
 * @version 1.0
 */
public class I18nField extends AbstractId {

	/** The locale. */
	private Locale locale;

	/** The string. */
	@NotEmpty
	@Valid
	private String string;

	/**
	 * Instantiates a new i18n.
	 */
	public I18nField() {
		super();
	}

	/**
	 * Instantiates a new i18n.
	 * 
	 * @param pString
	 *            the string
	 * @param pLocale
	 *            the locale
	 */
	public I18nField(final String pString, final Locale pLocale) {
		super();
		this.string = pString;
		this.locale = pLocale;
	}

	/**
	 * Equals.
	 * 
	 * @param object
	 *            the object
	 * @return true, if successful
	 * @see java.lang.Object#equals(Object)
	 */
	// public boolean equals(final Object object) {
	// if (!(object instanceof I18nField)) {
	// return false;
	// }
	// final I18nField rhs = (I18nField) object;
	// return new EqualsBuilder().appendSuper(super.equals(object))
	// .append(this.locale, rhs.locale)
	// .append(this.string, rhs.string).isEquals();
	// }

	/**
	 * Gets the locale.
	 * 
	 * @return the locale
	 */
	public Locale getLocale() {
		return locale;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		I18nField other = (I18nField) obj;
		if (locale == null) {
			if (other.locale != null)
				return false;
		} else if (!locale.equals(other.locale))
			return false;
		if (string == null) {
			if (other.string != null)
				return false;
		} else if (!string.equals(other.string))
			return false;
		return true;
	}

	/**
	 * Gets the string.
	 * 
	 * @return the string
	 */
	public String getString() {
		return string;
	}

	/**
	 * Hash code.
	 * 
	 * @return the int
	 * @see java.lang.Object#hashCode()
	 */
	public int hashCode() {
		return new HashCodeBuilder(969253333, -160028025)
				.appendSuper(super.hashCode()).append(this.locale)
				.append(this.string).toHashCode();
	}

	/**
	 * Sets the locale.
	 * 
	 * @param pLocale
	 *            the new locale
	 */
	public void setLocale(final Locale pLocale) {
		locale = pLocale;
	}

	/**
	 * Sets the string.
	 * 
	 * @param pString
	 *            the new string
	 */
	public void setString(final String pString) {
		string = pString;
	}

}