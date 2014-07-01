/**
 *
 * Copyright (C) FACTORIA ETSIA S.L.
 * All Rights Reserved.
 * www.factoriaetsia.com
 *
 */
package com.comparadorad.bet.comparer.web.client.gwt.results.ui.view.tabset;

import com.allen_sauer.gwt.log.client.Log;
import com.smartgwt.client.widgets.Canvas;
import com.smartgwt.client.widgets.Label;
import com.smartgwt.client.widgets.layout.Layout;
import com.smartgwt.client.widgets.layout.VLayout;
import com.smartgwt.client.widgets.layout.VStack;

/**
 * The Class HeadTab.
 */
public class HeadTab extends ResultsTab {

	/** The Constant ID_PREFIX. */
	private static final String ID_PREFIX = "HT";

	/** The Constant ID_PREFIX. */
	private final static String RES_STYLE_LINE = "resStyleLine";

	/** The Constant RES_TAB_CONTENT_TITLE_BIG. */
	private final static String RES_TAB_CONTENT_TITLE_BIG = "resTabContentTitleBig";

	/** The Constant RES_TAB_CONTENT_TITLE_SMALL. */
	private final static String RES_TAB_CONTENT_TITLE_SMALL = "resTabContentTitleSmall";

	/** The child. */
	private Canvas child;

	/** The content title. */
	private String contentTitle;

	/** The google analytics msg. */
	String googleAnalyticsMsg;

	/** The loaded. */
	private boolean loaded;

	/** The tab content. */
	private Layout tabContent;

	/** The two lines. */
	private boolean twoLines;

	/**
	 * Instantiates a new head tab.
	 * 
	 * @param pContentTitle
	 *            the content title
	 * @param pTwoLines
	 *            the two lines
	 * @param pChild
	 *            the child
	 * @param pTitle
	 *            the title
	 * @param pId
	 *            the id
	 * @param tabSetId
	 *            the tab set id
	 * @param pGoogleAnalyticsMsg
	 *            the google analytics msg
	 * @param pFixHash
	 *            the fix hash
	 */
	public HeadTab(final String pContentTitle, final boolean pTwoLines,
			final Canvas pChild, final String pTitle, final String pId,
			final String tabSetId, final String pGoogleAnalyticsMsg,
			final boolean pFixHash) {
		super(pId, tabSetId, ID_PREFIX);
		contentTitle = pContentTitle;
		twoLines = pTwoLines;
		child = pChild;
		setTitle(pTitle);
		loaded = false;
		setFixHash(pFixHash);
		this.googleAnalyticsMsg = pGoogleAnalyticsMsg;
	}

	/**
	 * Gets the child.
	 * 
	 * @return the child
	 */
	public Canvas getChild() {
		return child;
	}

	/**
	 * Gets the content title.
	 * 
	 * @return the content title
	 */
	public String getContentTitle() {
		return contentTitle;
	}

	/**
	 * Gets the google analytics msg.
	 * 
	 * @return the google analytics msg
	 */
	public String getGoogleAnalyticsMsg() {
		return googleAnalyticsMsg;
	}

	/**
	 * Gets the tab content.
	 * 
	 * @return the tab content
	 */
	public Layout getTabContent() {
		return tabContent;
	}

	/**
	 * Inicial load.
	 */
	public void inicialLoad() {
		Log.debug("inicial head tab load");
		loadContentTitleStyle();
	}

	/**
	 * Checks if is loaded.
	 * 
	 * @return true, if is loaded
	 */
	public boolean isLoaded() {
		boolean loaded = false;
		if (getPane() != null && getPane().getChildren() != null
				&& getPane().getChildren().length > 0) {
			loaded = true;
		}
		return loaded;
	}

	/**
	 * Checks if is two lines.
	 * 
	 * @return true, if is two lines
	 */
	public boolean isTwoLines() {
		return twoLines;
	}

	/**
	 * Load content title style.
	 */
	private void loadContentTitleStyle() {
		tabContent = new VStack();
		VLayout line1 = new VLayout();
		line1.setHeight(4);
		line1.setStyleName(RES_STYLE_LINE);
		Label label = new Label(contentTitle);
		label.setWrap(false);
		tabContent.addMember(line1);
		tabContent.addMember(label);
		if (twoLines) {
			label.setStyleName(RES_TAB_CONTENT_TITLE_SMALL);
			label.setHeight(20);
			VLayout line2 = new VLayout();
			line2.setHeight(4);
			line2.setStyleName(RES_STYLE_LINE);
			tabContent.addMember(line2);
		} else {
			label.setHeight(40);
			label.setStyleName(RES_TAB_CONTENT_TITLE_BIG);
		}
		if (child != null) {
			tabContent.addMember(child);
		}
		setPane(tabContent);
		setLoaded(true);
	}

	/**
	 * Sets the child.
	 * 
	 * @param pChild
	 *            the new child
	 */
	public void setChild(Canvas pChild) {
		child = pChild;
	}

	/**
	 * Sets the content title.
	 * 
	 * @param pContentTitle
	 *            the new content title
	 */
	public void setContentTitle(String pContentTitle) {
		contentTitle = pContentTitle;
	}

	/**
	 * Sets the google analytics msg.
	 * 
	 * @param pGoogleAnalyticsMsg
	 *            the new google analytics msg
	 */
	public void setGoogleAnalyticsMsg(String pGoogleAnalyticsMsg) {
		googleAnalyticsMsg = pGoogleAnalyticsMsg;
	}

	/**
	 * Sets the loaded.
	 * 
	 * @param pLoaded
	 *            the new loaded
	 */
	public void setLoaded(boolean pLoaded) {
		loaded = pLoaded;
	}

	/**
	 * Sets the tab content.
	 * 
	 * @param pTabContent
	 *            the new tab content
	 */
	public void setTabContent(Layout pTabContent) {
		tabContent = pTabContent;
	}

	/**
	 * Sets the two lines.
	 * 
	 * @param pTwoLines
	 *            the new two lines
	 */
	public void setTwoLines(boolean pTwoLines) {
		twoLines = pTwoLines;
	}

}
