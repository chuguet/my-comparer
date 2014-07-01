/**
 *
 * Copyright (C) FACTORIA ETSIA S.L.
 * All Rights Reserved.
 * www.factoriaetsia.com
 *
 */
package com.comparadorad.bet.comparer.web.client.gwt.core.ui;

import com.smartgwt.client.types.Alignment;
import com.smartgwt.client.util.Page;
import com.smartgwt.client.widgets.Dialog;
import com.smartgwt.client.widgets.Label;
import com.smartgwt.client.widgets.layout.HLayout;

/**
 * The Class GhxWaitModalWindow.
 */
public class GhxWaitModalWindow extends Dialog {

	/** The Constant loadingIcon. */
	private static final String loadingIcon = Page.getSkinImgDir()
			+ "loadingSmall.gif";;

	/** The Constant messageBoxBgColor. */
	private static final String messageBoxBgColor = "#fff";

	/** The message box. */
	private HLayout messageBox = new HLayout();

	/** The label. */
	private Label label = new Label();

	/** The singleton. */
	private static GhxWaitModalWindow singleton;

	/**
	 * Show.
	 * 
	 * @param message
	 *            the message
	 */
	public static void show(String message) {
		initAndShowMessage(message, true);
	}

	/**
	 * Show.
	 * 
	 * @param message
	 *            the message
	 * @param showLoadingIcon
	 *            the show loading icon
	 */
	public static void show(String message, boolean showLoadingIcon) {
		initAndShowMessage(message, showLoadingIcon);
	}

	/**
	 * Close.
	 */
	public static void close() {
		if (singleton != null) {
			singleton.hide();
		}
	}

	/**
	 * Inits the and show message.
	 * 
	 * @param message
	 *            the message
	 * @param showLoadingIcon
	 *            the show loading icon
	 */
	private static void initAndShowMessage(String message,
			boolean showLoadingIcon) {
		if (singleton == null) {
			singleton = new GhxWaitModalWindow();
		}
		singleton.showMessage(message, showLoadingIcon);
	}

	/**
	 * Instantiates a new ghx wait modal window.
	 */
	private GhxWaitModalWindow() {
		super();
		setIsModal(false);
		setShowModalMask(false);
		setShowEdges(false);
		setShowTitle(false);
		setShowCloseButton(false);
		setShowFooter(false);
		setShowHeader(false);
		setShowResizer(false);
		setShowMinimizeButton(false);
		setShowStatusBar(false);
		setShowTitle(false);
		setShowToolbar(false);
		setShowStatusBar(false);
		setShowShadow(false);
		setAutoHeight();
		setAutoSize(true);
		setLeaveScrollbarGap(false);

		label.setWrap(false);
		label.setBorder("3px double #999");
		label.setAlign(Alignment.CENTER);
		label.setAutoFit(true);
		label.setHeight(16);
		label.setPadding(14);
		label.setBackgroundColor(messageBoxBgColor);

		messageBox.setAutoHeight();
		messageBox.setAutoWidth();
		messageBox.setMembers(label);

		addItem(messageBox);
	}

	/**
	 * Show message.
	 * 
	 * @param message
	 *            the message
	 * @param showLoadingIcon
	 *            the show loading icon
	 */
	private void showMessage(String message, boolean showLoadingIcon) {
		label.setContents(message);

		if (showLoadingIcon) {
			label.setIcon(loadingIcon);
		} else {
			label.setIcon(null);
		}

		show();
	}

}
