/**
 *
 * Copyright (C) FACTORIA ETSIA S.L.
 * All Rights Reserved.
 * www.factoriaetsia.com
 *
 */
package com.comparadorad.bet.comparer.model.core.bean;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Set;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import org.springframework.data.mongodb.core.mapping.Field;

/**
 * The Class I18n.
 * 
 * @author imayoral
 * @version 1.0
 */
public class I18n extends AbstractId {

	/**
	 * The replace word.
	 */
	@Field
	// @SetWithAtLeastOneElement
	@NotNull
	@Valid
	private Set<I18nField> i18nFields;

	/**
	 * Gets the i18n fields.
	 * 
	 * @return the i18n fields
	 */
	public Set<I18nField> getI18nFields() {
		return i18nFields;
	}

	/**
	 * Sets the i18n fields.
	 * 
	 * @param pI18nFields
	 *            the new i18n fields
	 */
	public void setI18nFields(final Set<I18nField> pI18nFields) {
		i18nFields = pI18nFields;
	}

	/**
	 * Adds the i18n field.
	 * 
	 * @param pI18nField
	 *            the i18n field
	 */
	public void addI18nField(final I18nField pI18nField) {
		boolean first = false;
		if (i18nFields == null) {
			i18nFields = new HashSet<I18nField>();
			first = true;
		}
		if (!i18nFields.contains(pI18nField)) {
			i18nFields.add(pI18nField);
		}
		if (first && pI18nField.getLocale() != null) {
			// We put the field as the default
			I18nField defaultI18NField = new I18nField(pI18nField.getString(),
					null);
			i18nFields.add(defaultI18NField);
		}
	}

	/**
	 * Adds the i18n field default.
	 * 
	 * @param pI18nField
	 *            the i18n field
	 */
	public void addI18nFieldDefault(final I18nField pI18nField) {
		if (i18nFields == null) {
			i18nFields = new HashSet<I18nField>();
		}
		if (!i18nFields.contains(pI18nField)) {
			i18nFields.add(pI18nField);
		}
		// We put the field as the default
		I18nField defaultI18NField = null;
		for (Iterator<I18nField> iterator2 = i18nFields.iterator(); iterator2
				.hasNext();) {
			I18nField i18nField = iterator2.next();
			if (i18nField.getLocale() == null) {
				defaultI18NField = i18nField;
			}
		}
		if (defaultI18NField == null) {
			defaultI18NField = new I18nField(pI18nField.getString(), null);
		}
		i18nFields.add(defaultI18NField);
	}

	/**
	 * Adds the i18n field.
	 * 
	 * @param message
	 *            the message
	 */
	public void addI18nField(final String message) {
		I18nField field = new I18nField(message, null);
		addI18nField(field);
	}

	/**
	 * Adds the i18n field default.
	 * 
	 * @param message
	 *            the message
	 * @param locale
	 *            the locale
	 */
	public void addI18nFieldDefault(final String message, final Locale locale) {
		I18nField field = new I18nField(message, locale);
		addI18nFieldDefault(field);
	}

	/**
	 * Adds the i18n field.
	 * 
	 * @param message
	 *            the message
	 * @param locale
	 *            the locale
	 */
	public void addI18nField(final String message, final Locale locale) {
		I18nField field = new I18nField(message, locale);
		addI18nField(field);
	}

	/**
	 * Gets the i18n field.
	 * 
	 * @param locale
	 *            the locale
	 * @return the i18n field
	 */
	public I18nField getI18nField(final Locale locale) {
		I18nField result = null;

		for (Iterator<I18nField> iterator2 = i18nFields.iterator(); iterator2
				.hasNext();) {
			I18nField i18nField = iterator2.next();
			if (i18nField.getLocale() == null) {
				// default value
				result = i18nField;
				if (locale == null) {
					break;
				}
			} else if (i18nField.getLocale().equals(locale)) {
				result = i18nField;
				break;
			} else if (i18nField.getLocale() != null
					&& i18nField.getLocale().getLanguage() != null
					&& locale != null
					&& i18nField.getLocale().getLanguage()
							.equals(locale.getLanguage())) {
				result = i18nField;
				break;
			}
		}
		return result;
	}

	/*
	 * @Override public int hashCode() { return new HashCodeBuilder(969253333,
	 * -160028025) .appendSuper(super.hashCode()).append(this.hashCode())
	 * .toHashCode(); }
	 */
	// TO DO
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		I18n other = (I18n) obj;
		if (i18nFields == null) {
			if (other.i18nFields != null)
				return false;
		} else if (notEquals(other.getI18nFields(), this.getI18nFields())) {
			return false;
		}
		return true;
	}

	private boolean notEquals(Set<I18nField> set1, Set<I18nField> set2) {
		List<I18nField> list1 = new ArrayList<I18nField>();
		List<I18nField> list2 = new ArrayList<I18nField>();
		for (I18nField i18nField : set1) {
			list1.add(i18nField);
		}
		for (I18nField i18nField : set2) {
			list2.add(i18nField);
		}

		return !list1.containsAll(list2);
	}

}