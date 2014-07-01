/**
 *
 * Copyright (C) FACTORIA ETSIA S.L.
 * All Rights Reserved.
 * www.factoriaetsia.com
 *
 */
package com.comparadorad.bet.comparer.web.client.gwt.common.bean.cfg.response;

/**
 * The Class ResourceTo.
 */
public class ResourceTo {

	/** The height. */
	private Integer height;

	/** The location. */
	private String location;

	/** The name. */
	private String name;

	/** The tooltip. */
	private String tooltip;

	/** The width. */
	private Integer width;

	/**
	 * Instantiates a new resource.
	 */
	public ResourceTo() {
		super();
	}

	/**
	 * Instantiates a new resource.
	 * 
	 * @param url
	 *            the url
	 */
	public ResourceTo(String url) {
		super();
		this.location = url;
	}

	/**
	 * Instantiates a new resource to.
	 * 
	 * @param name
	 *            the name
	 * @param url
	 *            the url
	 */
	public ResourceTo(String name, String url) {
		super();
		this.name = name;
		this.location = url;
	}

	/**
	 * Gets the height.
	 * 
	 * @return the height
	 */
	public Integer getHeight() {
		return height;
	}

	/**
	 * Gets the location.
	 * 
	 * @return the location
	 */
	public String getLocation() {
		return location;
	}

	/**
	 * Gets the name.
	 * 
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * Gets the tooltip.
	 * 
	 * @return the tooltip
	 */
	public String getTooltip() {
		return tooltip;
	}

	/**
	 * Gets the width.
	 * 
	 * @return the width
	 */
	public Integer getWidth() {
		return width;
	}

	/**
	 * Sets the height.
	 * 
	 * @param pHeight
	 *            the new height
	 */
	public void setHeight(Integer pHeight) {
		height = pHeight;
	}

	/**
	 * Sets the location.
	 * 
	 * @param pUrl
	 *            the new location
	 */
	public void setLocation(String pUrl) {
		location = pUrl;
	}

	/**
	 * Sets the name.
	 * 
	 * @param pName
	 *            the new name
	 */
	public void setName(String pName) {
		name = pName;
	}

	/**
	 * Sets the tooltip.
	 * 
	 * @param pTooltip
	 *            the new tooltip
	 */
	public void setTooltip(String pTooltip) {
		tooltip = pTooltip;
	}

	/**
	 * Sets the width.
	 * 
	 * @param pWidth
	 *            the new width
	 */
	public void setWidth(Integer pWidth) {
		width = pWidth;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((height == null) ? 0 : height.hashCode());
		result = prime * result
				+ ((location == null) ? 0 : location.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((tooltip == null) ? 0 : tooltip.hashCode());
		result = prime * result + ((width == null) ? 0 : width.hashCode());
		return result;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ResourceTo other = (ResourceTo) obj;
		if (height == null) {
			if (other.height != null)
				return false;
		} else if (!height.equals(other.height))
			return false;
		if (location == null) {
			if (other.location != null)
				return false;
		} else if (!location.equals(other.location))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (tooltip == null) {
			if (other.tooltip != null)
				return false;
		} else if (!tooltip.equals(other.tooltip))
			return false;
		if (width == null) {
			if (other.width != null)
				return false;
		} else if (!width.equals(other.width))
			return false;
		return true;
	}

}
