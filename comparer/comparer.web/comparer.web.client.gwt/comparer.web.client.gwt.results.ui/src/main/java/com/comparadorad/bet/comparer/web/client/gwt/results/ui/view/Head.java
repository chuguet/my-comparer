/**
 *
 * Copyright (C) FACTORIA ETSIA S.L.
 * All Rights Reserved.
 * www.factoriaetsia.com
 *
 */
package com.comparadorad.bet.comparer.web.client.gwt.results.ui.view;

import java.util.List;

import com.allen_sauer.gwt.log.client.Log;
import com.comparadorad.bet.comparer.web.client.gwt.common.bean.LinkTo;
import com.smartgwt.client.widgets.Img;
import com.smartgwt.client.widgets.Label;
import com.smartgwt.client.widgets.layout.HLayout;
import com.smartgwt.client.widgets.layout.LayoutSpacer;
import com.smartgwt.client.widgets.layout.VLayout;

/**
 * The Class Head.
 */
public class Head extends VLayout {

	/** The Constant DATE_HEIGHT. */
	private static final int DATE_HEIGHT = 25;

	/** The Constant IMG_HEIGHT. */
	private static final int IMG_HEIGHT = 16;

	/** The Constant IMG_WIDTH. */
	private static final int IMG_WIDTH = 23;

	/** The Constant LOCATION_CALENDAR_IMG. */
	private static final String LOCATION_CALENDAR_IMG = "comparer/calendar/small_calendar.jpg";

	/** The Constant TITLE_HEIGHT. */
	private static final int TITLE_HEIGHT = 25;

	/** The Constant WIDTH. */
	private static final int WIDTH = 680;

	/** The breadcrumbs. */
	private Breadcrumbs breadcrumbs;

	/** The date. */
	private Label date;

	/** The date img. */
	private Img dateImg;

	/** The date row. */
	private HLayout dateRow;

	/** The title. */
	private Label title;

	/** The title img. */
	private Img titleImg;

	/** The title row. */
	private HLayout titleRow;

	/**
	 * Instantiates a new head.
	 */
	public Head() {
		Log.debug("new Head");
		setStyleName("resHead");
		setWidth(WIDTH);
		setAutoHeight();
		setPadding(0);

		titleRow = new HLayout();
		title = new Label();
		breadcrumbs = new Breadcrumbs();

		titleRow.setHeight(TITLE_HEIGHT);
		titleRow.setWidth(WIDTH);
		title.setAutoFit(true);
		title.setWrap(false);
		title.setStyleName("resHeadTitle");
		titleRow.addMember(title);

		addMember(titleRow);
		addMember(breadcrumbs);

	}

	/**
	 * Sets the breadcrumbs.
	 * 
	 * @param pBreadcrumbs
	 *            the new breadcrumbs
	 */
	public void setBreadcrumbs(List<LinkTo> pBreadcrumbs) {
		Log.debug("setBreadcrumbs");
		breadcrumbs.addBreadcrumbs(pBreadcrumbs);
	}

	/**
	 * Sets the date.
	 * 
	 * @param pDate
	 *            the new date
	 */
	public void setDate(String pDate) {
		dateRow = new HLayout();
		dateImg = new Img(LOCATION_CALENDAR_IMG, IMG_WIDTH, IMG_HEIGHT);

		date = new Label(pDate);
		date.setAutoFit(true);
		date.setWrap(false);
		date.setStyleName("resDate");

		dateRow.setHeight(DATE_HEIGHT);
		dateRow.setAutoWidth();
		dateRow.addMember(dateImg);
		dateRow.addMember(date);

		addMember(dateRow);
	}

	/**
	 * Sets the title.
	 * 
	 * @param pTitle
	 *            the new title {@inheritDoc}
	 */
	public void setTitle(String pTitle) {
		Log.debug("setTitle");
		title.setContents(pTitle);
	}

	/**
	 * Sets the title img.
	 * 
	 * @param src
	 *            the src
	 * @param left
	 *            the left
	 */
	public void setTitleImg(String src, boolean left) {
		Log.debug("setTitleImg");
		titleImg = new Img();
		titleImg.setSrc(src);
		titleImg.setWidth(IMG_WIDTH);
		titleImg.setHeight(IMG_HEIGHT);
		LayoutSpacer spacer = new LayoutSpacer();
		if (left) {
			titleRow.addMember(spacer);
		} else {
			spacer.setWidth(7);
			titleRow.addMember(spacer);
		}
		titleRow.addMember(titleImg);
	}

}
