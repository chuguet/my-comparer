/**
 *
 * Copyright (C) FACTORIA ETSIA S.L.
 * All Rights Reserved.
 * www.factoriaetsia.com
 *
 */
package com.comparadorad.bet.comparer.web.client.gwt.common.bean;

import java.util.ArrayList;
import java.util.List;

import com.comparadorad.bet.comparer.web.client.gwt.common.bean.cfg.response.ResourceTo;
import com.comparadorad.bet.comparer.web.client.gwt.core.bean.AbstractClientToResponse;

/**
 * The Class HeadResponseTo.
 */
public class HeadResponseTo extends AbstractClientToResponse {

	/** The date. */
	private String date;

	/** The link tos. */
	private List<LinkTo> linkTos;

	/** The resource to. */
	private ResourceTo resourceTo;

	/** The title. */
	private String title;

	/**
	 * Instantiates a new head response to.
	 */
	public HeadResponseTo() {
		super();
	}

	/**
	 * Instantiates a new head response to.
	 * 
	 * @param competitionName
	 *            the competition name
	 * @param date
	 *            the date
	 */
	public HeadResponseTo(String competitionName, String date) {
		super();
		this.title = competitionName;
		this.date = date;
	}


	/**
	 * Adds the.
	 * 
	 * @param linkTo
	 *            the link to
	 */
	public void add(LinkTo linkTo) {
		getLinkTos().add(linkTo);
	}


	/**
	 * Gets the date.
	 * 
	 * @return the date
	 */
	public String getDate() {
		return date;
	}

	/**
	 * Gets the link tos.
	 * 
	 * @return the link tos
	 */
	public List<LinkTo> getLinkTos() {
		if (linkTos == null) {
			linkTos = new ArrayList<LinkTo>();
		}
		return linkTos;
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
	 * Gets the title.
	 * 
	 * @return the title
	 */
	public String getTitle() {
		return title;
	}

	/**
	 * Sets the date.
	 * 
	 * @param pDate
	 *            the new date
	 */
	public void setDate(String pDate) {
		date = pDate;
	}

	/**
	 * Sets the link tos.
	 * 
	 * @param linkTos
	 *            the new link tos
	 */
	public void setLinkTos(List<LinkTo> linkTos) {
		this.linkTos = linkTos;
	}

	/**
	 * Sets the resource to.
	 * 
	 * @param pResourceTo
	 *            the new resource to
	 */
	public void setResourceTo(ResourceTo pResourceTo) {
		resourceTo = pResourceTo;
	}

	/**
	 * Sets the title.
	 * 
	 * @param pTitle
	 *            the new title
	 */
	public void setTitle(String pTitle) {
		title = pTitle;
	}
}
