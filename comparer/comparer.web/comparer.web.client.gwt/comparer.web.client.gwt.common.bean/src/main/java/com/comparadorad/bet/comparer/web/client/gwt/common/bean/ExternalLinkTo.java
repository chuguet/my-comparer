/**
 *
 * Copyright (C) FACTORIA ETSIA S.L.
 * All Rights Reserved.
 * www.factoriaetsia.com
 *
 */
package com.comparadorad.bet.comparer.web.client.gwt.common.bean;

/**
 * The Class ExternalLinkTo.
 */
public class ExternalLinkTo {

	/** The url. */
	private String url;

	/** The link text. */
	private String linkText;

	/** The link img location. */
	private String linkImgLocation;

	/** The bookmaker name. */
	private String actionAnalytics;
	
	/** The category analytics. */
	private String categoryAnalytics;
	
	

	/**
	 * Instantiates a new external link to.
	 */
	public ExternalLinkTo() {
		super();
	}

	/**
	 * Instantiates a new external link to.
	 * 
	 * @param pUrl
	 *            the url
	 * @param pLinkText
	 *            the link text
	 * @param pLinkImgLocation
	 *            the link img location
	 */
	public ExternalLinkTo(String pUrl, String pLinkText, String pLinkImgLocation) {
		super();
		this.url = pUrl;
		this.linkText = pLinkText;
		this.linkImgLocation = pLinkImgLocation;
	}

	/**
	 * Instantiates a new external link to.
	 *
	 * @param pUrl the url
	 * @param pLinkText the link text
	 * @param pLinkImgLocation the link img location
	 * @param pActionAnalytics the action analytics
	 */
	public ExternalLinkTo(String pUrl, String pLinkText, String pLinkImgLocation, String pActionAnalytics, String pCategoryAnalytics) {
		super();
		this.url = pUrl;
		this.linkText = pLinkText;
		this.linkImgLocation = pLinkImgLocation;
		this.actionAnalytics = pActionAnalytics;
		this.categoryAnalytics = pCategoryAnalytics;
	}
	
	/**
	 * Gets the link img location.
	 * 
	 * @return the link img location
	 */
	public String getLinkImgLocation() {
		return linkImgLocation;
	}

	/**
	 * Gets the link text.
	 * 
	 * @return the link text
	 */
	public String getLinkText() {
		return linkText;
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
	 * Sets the link img location.
	 * 
	 * @param pLinkImgLocation
	 *            the new link img location
	 */
	public void setLinkImgLocation(String pLinkImgLocation) {
		this.linkImgLocation = pLinkImgLocation;
	}

	/**
	 * Sets the link text.
	 * 
	 * @param pLinkText
	 *            the new link text
	 */
	public void setLinkText(String pLinkText) {
		this.linkText = pLinkText;
	}

	/**
	 * Sets the url.
	 * 
	 * @param pUrl
	 *            the new url
	 */
	public void setUrl(String pUrl) {
		this.url = pUrl;
	}

	/**
	 * Gets the bookmaker name.
	 * 
	 * @return the bookmaker name
	 */
	public String getActionAnalytics() {
		return actionAnalytics;
	}

	/**
	 * Sets the bookmaker name.
	 *
	 * @param actionAnalytics the new bookmaker name
	 */
	public void setActionAnalytics(String actionAnalytics) {
		this.actionAnalytics = actionAnalytics;
	}
	
	
	

	/**
	 * Gets the category analytics.
	 *
	 * @return the category analytics
	 */
	public String getCategoryAnalytics() {
		return categoryAnalytics;
	}

	/**
	 * Sets the category analytics.
	 *
	 * @param categoryAnalytics the new category analytics
	 */
	public void setCategoryAnalytics(String categoryAnalytics) {
		this.categoryAnalytics = categoryAnalytics;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#hashCode()
	 */
	/**
	 * Hash code.
	 *
	 * @return the int
	 * {@inheritDoc}
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((linkImgLocation == null) ? 0 : linkImgLocation.hashCode());
		result = prime * result + ((linkText == null) ? 0 : linkText.hashCode());
		result = prime * result + ((url == null) ? 0 : url.hashCode());
		result = prime * result + ((actionAnalytics == null) ? 0 : actionAnalytics.hashCode());
		result = prime * result + ((categoryAnalytics == null) ? 0 : categoryAnalytics.hashCode());
		return result;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	/**
	 * Equals.
	 *
	 * @param obj the obj
	 * @return true, if successful
	 * {@inheritDoc}
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ExternalLinkTo other = (ExternalLinkTo) obj;
		if (linkImgLocation == null) {
			if (other.linkImgLocation != null)
				return false;
		} else if (!linkImgLocation.equals(other.linkImgLocation))
			return false;
		if (linkText == null) {
			if (other.linkText != null)
				return false;
		} else if (!linkText.equals(other.linkText))
			return false;
		if (url == null) {
			if (other.url != null)
				return false;
		} else if (!url.equals(other.url))
			return false;
		if (actionAnalytics == null) {
			if (other.actionAnalytics != null)
				return false;
		} else if (!actionAnalytics.equals(other.actionAnalytics))
			return false;
		if (categoryAnalytics == null) {
			if (other.categoryAnalytics != null)
				return false;
		} else if (!categoryAnalytics.equals(other.categoryAnalytics))
			return false;
		return true;
	}

}
