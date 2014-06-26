/**
 *
 * Copyright (C) FACTORIA ETSIA S.L.
 * All Rights Reserved.
 * www.factoriaetsia.com
 *
 */
package com.comparadorad.bet.comparer.model.core.bean;

import java.math.BigInteger;
import java.util.Locale;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import org.springframework.data.mongodb.core.mapping.Field;

/**
 * The Class AbstractI18nTable.
 */
@SuppressWarnings("serial")
public abstract class AbstractI18nTable extends AbstractHistoricChange {

	/** The cfg name. */
	@Field
	private String cfgName;
	
	
	/** The i18n. */
	@Field
	@NotNull
	@Valid
	private I18n i18n;
	

	/**
	 * Instantiates a new abstract i18n table.
	 */
	public AbstractI18nTable() {
		super();

	}

	/**
	 * Instantiates a new abstract i18n table.
	 * 
	 * @param pObjectId
	 *            the object id
	 */
	public AbstractI18nTable(BigInteger pObjectId) {
		super(pObjectId);
	}
	
	/**
	 * Instantiates a new abstract i18n table.
	 * 
	 * @param pObjectId
	 *            the object id
	 */
	public AbstractI18nTable(IObjectIdEnum pObjectId) {
		super(pObjectId);
	}

	/**
	 * Instantiates a new abstract i18n table.
	 * 
	 * @param pObjectId
	 *            the object id
	 */
	public AbstractI18nTable(String pObjectId) {
		super(pObjectId);
	}

	/**
	 * Gets the cfg name.
	 *
	 * @return the cfg name
	 */
	public String getCfgName() {
		return cfgName;
	}

	/**
	 * Gets the i18n.
	 * 
	 * @return the i18n
	 */
	public final I18n getI18n() {
		return i18n;
	}

	/**
	 * Gets the name.
	 * 
	 * @param locale
	 *            the locale
	 * @return the name
	 */
	public String getName(Locale locale) {
		if (i18n == null) {
			return null;
		}
		I18nField field = i18n.getI18nField(locale);
		if (field == null) {
			return null;
		} else {
			return field.getString();
		}
	}

	/**
	 * Sets the cfg name.
	 *
	 * @param cfgName the new cfg name
	 */
	public void setCfgName(String cfgName) {
		this.cfgName = cfgName;
	}

	/**
	 * Sets the default name.
	 * 
	 * @param pName
	 *            the name
	 * @param locale
	 *            the locale
	 */
	public final void setDefaultName(final String pName, Locale locale) {
		if (i18n == null) {
			i18n = new I18n();
		}
		i18n.addI18nFieldDefault(pName, locale);
	}

	/**
	 * Sets the i18n.
	 * 
	 * @param pI18n
	 *            the new i18n
	 */
	public final void setI18n(final I18n pI18n) {
		i18n = pI18n;
	}

	/**
	 * Sets the name.
	 * 
	 * @param pName
	 *            the new name
	 */
	public final void setName(final String pName) {
		if (i18n == null) {
			i18n = new I18n();
		}
		i18n.addI18nField(pName);
	}

	/**
	 * Sets the name.
	 * 
	 * @param pName
	 *            the name
	 * @param locale
	 *            the locale
	 */
	public final void setName(final String pName, Locale locale) {
		if (i18n == null) {
			i18n = new I18n();
		}
		i18n.addI18nField(pName, locale);
	}
}
