/**
 *
 * Copyright (C) FACTORIA ETSIA S.L.
 * All Rights Reserved.
 * www.factoriaetsia.com
 *
 */
package com.comparadorad.bet.comparer.model.bet.bean;

import java.math.BigInteger;
import java.util.Date;
import java.util.Locale;

import org.apache.commons.lang.builder.CompareToBuilder;
import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import com.comparadorad.bet.comparer.model.config.bean.CfgResource;
import com.comparadorad.bet.comparer.model.config.bean.IToolbarConfigurable;
import com.comparadorad.bet.comparer.model.core.bean.AbstractId;
import com.comparadorad.bet.comparer.model.core.bean.CoreActiveElement;
import com.comparadorad.bet.comparer.model.core.bean.IActivable;

/**
 * The Class RtToolbarElement.
 * 
 * @author chuguet
 * */
@SuppressWarnings("serial")
@Document
public class RtToolbarElement extends AbstractId implements IRtData,
		IActivable, Comparable<RtToolbarElement> {

	/** The core active element. */
	@Field
	private CoreActiveElement coreActiveElement;

	/** The locale. */
	@Transient
	private transient Locale locale;

	/** The parent element. */
	@DBRef
	private RtToolbarElement parentElement;

	/** The toolbar configurable. */
	@DBRef
	private IToolbarConfigurable toolbarConfigurable;

	/**
	 * Instantiates a new rt toolbar element.
	 */
	public RtToolbarElement() {
	}

	/**
	 * Instantiates a new rt toolbar element.
	 * 
	 * @param pParentElement
	 *            the parent element
	 * @param pToolbarConfigurable
	 *            the toolbar configurable
	 * @param pCoreActiveElement
	 *            the core active element
	 */
	public RtToolbarElement(RtToolbarElement pParentElement,
			IToolbarConfigurable pToolbarConfigurable,
			CoreActiveElement pCoreActiveElement) {
		this.coreActiveElement = pCoreActiveElement;
		this.toolbarConfigurable = pToolbarConfigurable;
		this.parentElement = pParentElement;
	}

	/**
	 * Instantiates a new rt toolbar element.
	 * 
	 * @param pParentElement
	 *            the parent element
	 * @param pToolbarConfigurable
	 *            the toolbar configurable
	 * @param pCoreActiveElement
	 *            the core active element
	 * @param pId
	 *            the id
	 */
	public RtToolbarElement(RtToolbarElement pParentElement,
			IToolbarConfigurable pToolbarConfigurable,
			CoreActiveElement pCoreActiveElement, BigInteger pId) {
		this.coreActiveElement = pCoreActiveElement;
		this.toolbarConfigurable = pToolbarConfigurable;
		this.parentElement = pParentElement;
		this.setObjectId(pId);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Comparable#compareTo(java.lang.Object)
	 */
	@Override
	public int compareTo(RtToolbarElement pToolbarElement) {
		int result = 0;

		if (this.getTitle(locale) != null
				&& pToolbarElement.getTitle(locale) != null) {
			result = new CompareToBuilder().append(this.getTitle(locale),
					pToolbarElement.getTitle(locale)).toComparison();
		}
		return result;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.comparadorad.bet.comparer.model.core.bean.AbstractId#equals(java.
	 * lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		RtToolbarElement other = (RtToolbarElement) obj;
		if (coreActiveElement == null) {
			if (other.coreActiveElement != null)
				return false;
		} else if (!coreActiveElement.equals(other.coreActiveElement))
			return false;
		if (parentElement == null) {
			if (other.parentElement != null)
				return false;
		} else if (!parentElement.equals(other.parentElement))
			return false;
		if (toolbarConfigurable == null) {
			if (other.toolbarConfigurable != null)
				return false;
		} else if (!toolbarConfigurable.equals(other.toolbarConfigurable))
			return false;
		return true;
	}

	/**
	 * Gets the core active element.
	 * 
	 * @return the core active element
	 */
	public CoreActiveElement getCoreActiveElement() {
		return coreActiveElement;
	}

	/**
	 * Gets the locale.
	 * 
	 * @return the locale
	 */
	public Locale getLocale() {
		return locale;
	}

	/**
	 * Gets the parent element.
	 * 
	 * @return the parent element
	 */
	public RtToolbarElement getParentElement() {
		return parentElement;
	}

	/**
	 * Gets the resource.
	 * 
	 * @return the resource
	 */
	public CfgResource getResource() {
		CfgResource result = null;
		if (getToolbarConfigurable() != null) {
			result = getToolbarConfigurable().getResource();
		}
		return result;
	}

	/**
	 * Gets the title.
	 * 
	 * @return the title
	 */
	public String getTitle() {
		String result = null;
		if (toolbarConfigurable != null) {
			result = toolbarConfigurable.getName(this.locale);
		}
		return result;
	}

	/**
	 * Gets the title.
	 * 
	 * @param pLocale
	 *            the locale
	 * @return the title
	 */
	public String getTitle(final Locale pLocale) {
		String result = null;
		if (toolbarConfigurable != null) {
			result = toolbarConfigurable.getName(pLocale);
		}
		return result;
	}

	/**
	 * Gets the toolbar configurable.
	 * 
	 * @return the toolbar configurable
	 */
	public IToolbarConfigurable getToolbarConfigurable() {
		return toolbarConfigurable;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		return this.getObjectId().toString().hashCode();
	}

	/**
	 * Checks if is active.
	 * 
	 * @param pDate
	 *            the date
	 * @return true, if is active
	 */
	public boolean isActive(Date pDate) {
		boolean result = true;
		if (coreActiveElement != null) {
			result = coreActiveElement.isActive(pDate);
		}
		return result;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.comparadorad.bet.comparer.model.core.bean.IActivable#setCoreActiveElement
	 * (com.comparadorad.bet.comparer.model.core.bean.CoreActiveElement)
	 */
	@Override
	public void setCoreActiveElement(CoreActiveElement pCoreActiveElement) {
		coreActiveElement = pCoreActiveElement;
	}

	/**
	 * Sets the locale.
	 * 
	 * @param pLocale
	 *            the new locale
	 */
	public void setLocale(Locale pLocale) {
		locale = pLocale;
	}

	/**
	 * Sets the parent element.
	 * 
	 * @param parentElement
	 *            the new parent element
	 */
	public void setParentElement(RtToolbarElement parentElement) {
		this.parentElement = parentElement;
	}

	/**
	 * Sets the title.
	 * 
	 * @param title
	 *            the title
	 * @param pLocale
	 *            the locale
	 */
	public void setTitle(final String title, final Locale pLocale) {
		if (toolbarConfigurable != null) {
			toolbarConfigurable.setName(title, pLocale);
		}
	}

	/**
	 * Sets the toolbar configurable.
	 * 
	 * @param toolbarConfigurable
	 *            the new toolbar configurable
	 */
	public void setToolbarConfigurable(IToolbarConfigurable toolbarConfigurable) {
		this.toolbarConfigurable = toolbarConfigurable;
	}

}
