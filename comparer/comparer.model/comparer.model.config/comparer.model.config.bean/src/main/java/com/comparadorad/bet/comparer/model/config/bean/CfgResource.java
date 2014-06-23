/**
 *
 * Copyright (C) FACTORIA ETSIA S.L.
 * All Rights Reserved.
 * www.factoriaetsia.com
 *
 */
package com.comparadorad.bet.comparer.model.config.bean;

import java.math.BigInteger;

import javax.validation.constraints.NotNull;

import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import com.comparadorad.bet.comparer.model.core.bean.AbstractI18nTableActivable;
import com.comparadorad.bet.comparer.model.core.bean.HasActive;
import com.comparadorad.bet.comparer.model.core.bean.IDocument;
import com.comparadorad.bet.comparer.model.core.bean.IObjectIdEnum;

/**
 * The Class CfgResource.
 */
@SuppressWarnings("serial")
@Document
public class CfgResource extends AbstractI18nTableActivable implements
		IDocument, HasActive {

	/** The height. */
	@Field
	private Integer height;

	/** The location. */
	@NotNull
	@Field
	private String location;

	/** The tooltip. */
	@Field
	private String tooltip;

	/** The width. */
	@Field
	private Integer width;

	/**
	 * Instantiates a new cfg resource.
	 */
	public CfgResource() {
		super();
	}

	/**
	 * Instantiates a new cfg resource.
	 * 
	 * @param pObjectId
	 *            the object id
	 */
	public CfgResource(BigInteger pObjectId) {
		super(pObjectId);
	}

	/**
	 * Instantiates a new cfg resource.
	 * 
	 * @param pObjectId
	 *            the object id
	 */
	public CfgResource(IObjectIdEnum pObjectId) {
		super(pObjectId);
	}

	/**
	 * Instantiates a new cfg resource.
	 * 
	 * @param pLocation
	 *            the location
	 */
	public CfgResource(String pLocation) {
		super();
		location = pLocation;
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
	 * @param pLocation
	 *            the new location
	 */
	public void setLocation(String pLocation) {
		location = pLocation;
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

}
