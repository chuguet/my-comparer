/**
 *
 * Copyright (C) FACTORIA ETSIA S.L.
 * All Rights Reserved.
 * www.factoriaetsia.com
 *
 */
package com.comparadorad.bet.comparer.web.client.gwt.common.ui.util;

import com.comparadorad.bet.comparer.web.client.gwt.common.ui.Messages;
import com.comparadorad.bet.comparer.web.client.gwt.core.ipc.AppLinkUtil;
import com.google.gwt.core.client.GWT;
import com.smartgwt.client.widgets.menu.Menu;
import com.smartgwt.client.widgets.menu.MenuItem;
import com.smartgwt.client.widgets.menu.events.MenuItemClickEvent;

/**
 * The Class ExternalLinkContextMenu.
 */
public class ExternalLinkContextMenu extends Menu {

	/** The messages. */
	private final static Messages messages = GWT.create(Messages.class);

	/** The encrypted url. */
	private String encryptedUrl;

	/** The item1. */
	private MenuItem item1 = new MenuItem(messages.abrirEnlaceEnUnaVentanaNueva());

	/** The link util. */
	private AppLinkUtil linkUtil = new AppLinkUtil();

	/**
	 * Instantiates a new external link context menu.
	 */
	public ExternalLinkContextMenu() {
		initInternalLinkContextMenu();
	}

	/**
	 * Instantiates a new external link context menu.
	 * 
	 * @param encryptedUrl
	 *            the encrypted url
	 */
	public ExternalLinkContextMenu(final String encryptedUrl) {
		this.encryptedUrl = encryptedUrl;
		initInternalLinkContextMenu();
	}

	/**
	 * Gets the encrypted url.
	 * 
	 * @return the encrypted url
	 */
	public String getEncryptedUrl() {
		return encryptedUrl;
	}

	/**
	 * Inits the internal link context menu.
	 */
	private void initInternalLinkContextMenu() {
		item1.addClickHandler(new com.smartgwt.client.widgets.menu.events.ClickHandler() {

			@Override
			public void onClick(MenuItemClickEvent pEvent) {
				linkUtil.openExternalLinkInNewWindow(encryptedUrl);
			}
		});

		addItem(item1);

	}

	/**
	 * Sets the encrypted url.
	 * 
	 * @param pEncryptedUrl
	 *            the new encrypted url
	 */
	public void setEncryptedUrl(String pEncryptedUrl) {
		encryptedUrl = pEncryptedUrl;
	}

}
