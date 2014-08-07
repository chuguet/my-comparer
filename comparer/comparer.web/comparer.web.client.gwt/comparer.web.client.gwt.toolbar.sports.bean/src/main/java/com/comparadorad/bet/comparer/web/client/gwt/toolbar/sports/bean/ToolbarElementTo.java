/**
 *
 * Copyright (C) FACTORIA ETSIA S.L.
 * All Rights Reserved.
 * www.factoriaetsia.com
 *
 */
package com.comparadorad.bet.comparer.web.client.gwt.toolbar.sports.bean;

import com.comparadorad.bet.comparer.web.client.gwt.common.bean.cfg.response.ResourceTo;

/**
 * The Class ToolbarElement.
 */
public class ToolbarElementTo {

	/** The competition id. */
	private String competitionId;

	/** The sport name. */
	private String elementName;

	/** The competition data to. */
	private Level level;

	/** The region id. */
	private String regionId;

	/** The resource to. */
	private ResourceTo resourceTo;

	/** The sport id. */
	private String sportId;

	/**
	 * Gets the competition id.
	 * 
	 * @return the competition id
	 */
	public String getCompetitionId() {
		return competitionId;
	}

	/**
	 * Gets the element name.
	 * 
	 * @return the element name
	 */
	public String getElementName() {
		return elementName;
	}

	/**
	 * Gets the level.
	 * 
	 * @return the level
	 */
	public Level getLevel() {
		return level;
	}

	/**
	 * Gets the region id.
	 * 
	 * @return the region id
	 */
	public String getRegionId() {
		return regionId;
	}

	/**
	 * Gets the resource to.
	 * 
	 * @return the resource to
	 */
	public ResourceTo getResourceTo() {
		return resourceTo;
	}

	/**
	 * Gets the sport id.
	 * 
	 * @return the sport id
	 */
	public String getSportId() {
		return sportId;
	}

	/**
	 * Sets the competition id.
	 * 
	 * @param competitionId
	 *            the new competition id
	 */
	public void setCompetitionId(String competitionId) {
		this.competitionId = competitionId;
	}

	/**
	 * Sets the element name.
	 * 
	 * @param elementName
	 *            the new element name
	 */
	public void setElementName(String elementName) {
		this.elementName = elementName;
	}

	/**
	 * Sets the level.
	 * 
	 * @param level
	 *            the new level
	 */
	public void setLevel(Level level) {
		this.level = level;
	}

	/**
	 * Sets the region id.
	 * 
	 * @param regionId
	 *            the new region id
	 */
	public void setRegionId(String regionId) {
		this.regionId = regionId;
	}

	/**
	 * Sets the resource to.
	 * 
	 * @param resourceTo
	 *            the new resource to
	 */
	public void setResourceTo(ResourceTo resourceTo) {
		this.resourceTo = resourceTo;
	}

	/**
	 * Sets the sport id.
	 * 
	 * @param sportId
	 *            the new sport id
	 */
	public void setSportId(String sportId) {
		this.sportId = sportId;
	}

}
