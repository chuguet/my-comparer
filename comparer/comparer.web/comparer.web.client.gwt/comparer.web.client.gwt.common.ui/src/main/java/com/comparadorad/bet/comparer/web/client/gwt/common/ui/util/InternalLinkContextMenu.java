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
import com.comparadorad.bet.comparer.web.client.gwt.core.ipc.InternalLinkEventNames;
import com.google.gwt.core.client.GWT;
import com.smartgwt.client.widgets.menu.Menu;
import com.smartgwt.client.widgets.menu.MenuItem;
import com.smartgwt.client.widgets.menu.events.MenuItemClickEvent;

/**
 * The Class InternalLinkContextMenu.
 */
public class InternalLinkContextMenu extends Menu {

	/** The Constant messages. */
	private final static Messages messages = GWT.create(Messages.class);

	/** The event name. */
	private InternalLinkEventNames eventName;

	/** The id. */
	private String id;

	/** The id aux. */
	private String idAux;

	/** The id aux2. */
	private String idAux2;

	/** The item1. */
	private MenuItem item1 = new MenuItem(messages.abrirEnlaceEnUnaVentanaNueva());

	/** The link util. */
	private AppLinkUtil linkUtil = new AppLinkUtil();

	/**
	 * Instantiates a new internal link context menu.
	 */
	public InternalLinkContextMenu() {
		initInternalLinkContextMenu();
	}

	/**
	 * Instantiates a new internal link context menu.
	 * 
	 * @param pId
	 *            the id
	 * @param pIdAux
	 *            the id aux
	 * @param pIpcEventName
	 *            the ipc event name
	 */
	public InternalLinkContextMenu(final String pId, final String pIdAux,
			final InternalLinkEventNames pIpcEventName) {

		this.id = pId;
		this.idAux = pIdAux;
		this.eventName = pIpcEventName;
		initInternalLinkContextMenu();
	}

	/**
	 * Gets the event name.
	 * 
	 * @return the event name
	 */
	public InternalLinkEventNames getEventName() {
		return eventName;
	}

	/**
	 * Gets the id.
	 * 
	 * @return the id
	 */
	public String getId() {
		return id;
	}

	/**
	 * Gets the id aux.
	 * 
	 * @return the id aux
	 */
	public String getIdAux() {
		return idAux;
	}

	/**
	 * Gets the id aux2.
	 * 
	 * @return the id aux2
	 */
	public String getIdAux2() {
		return idAux2;
	}

	/**
	 * Inits the internal link context menu.
	 */
	private void initInternalLinkContextMenu() {
		item1.addClickHandler(new com.smartgwt.client.widgets.menu.events.ClickHandler() {

			@Override
			public void onClick(MenuItemClickEvent pEvent) {
				linkUtil.openInternalLinkInNewWindow(id, idAux, idAux2,
						eventName);
			}
		});

		addItem(item1);

	}

	/**
	 * Sets the event name.
	 * 
	 * @param pEventName
	 *            the new event name
	 */
	public void setEventName(InternalLinkEventNames pEventName) {
		eventName = pEventName;
	}

	/**
	 * Sets the id.
	 * 
	 * @param pId
	 *            the new id
	 */
	public void setId(String pId) {
		id = pId;
	}

	/**
	 * Sets the id aux.
	 * 
	 * @param pIdAux
	 *            the new id aux
	 */
	public void setIdAux(String pIdAux) {
		idAux = pIdAux;
	}

	/**
	 * Sets the id aux2.
	 * 
	 * @param pIdAux2
	 *            the new id aux2
	 */
	public void setIdAux2(String pIdAux2) {
		idAux2 = pIdAux2;
	}

}
