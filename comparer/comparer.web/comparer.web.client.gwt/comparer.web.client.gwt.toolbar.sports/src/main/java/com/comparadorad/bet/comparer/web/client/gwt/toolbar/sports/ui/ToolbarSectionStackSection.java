/**
 *
 * Copyright (C) FACTORIA ETSIA S.L.
 * All Rights Reserved.
 * www.factoriaetsia.com
 *
 */
package com.comparadorad.bet.comparer.web.client.gwt.toolbar.sports.ui;

import com.smartgwt.client.widgets.layout.SectionStackSection;

/**
 * The Class ToolbarSectionStackSection.
 */
public class ToolbarSectionStackSection extends SectionStackSection {

	/** The Constant TOOLBAR_ID. */
	private static final String TOOLBAR_ID = "toolbarID";

	/** The Constant TOOLBAR_NAME. */
	private static final String TOOLBAR_NAME = "toolbarName";

	/**
	 * Instantiates a new toolbar section stack section.
	 * 
	 * @param id
	 *            the id
	 * @param name
	 *            the name
	 */
	public ToolbarSectionStackSection(String id, String name) {
		super(""); // Obligatorio!!
		setID(id); // Obligatorio!!
		setSectionId(id);
		setSectionName(name);
		setExpanded(false);
	}

	/**
	 * Gets the section id.
	 * 
	 * @return the section id
	 */
	public String getSectionId() {
		return getAttribute(TOOLBAR_ID);
	}

	/**
	 * Gets the section name.
	 * 
	 * @return the section name
	 */
	public String getSectionName() {
		return getAttribute(TOOLBAR_NAME);
	}

	/**
	 * Sets the section id.
	 * 
	 * @param id
	 *            the new section id
	 */
	public void setSectionId(String id) {
		setAttribute(TOOLBAR_ID, id);
	}

	/**
	 * Sets the section name.
	 * 
	 * @param name
	 *            the new section name
	 */
	public void setSectionName(String name) {
		setAttribute(TOOLBAR_NAME, name);
	}

}
