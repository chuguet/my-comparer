/**
 *
 * Copyright (C) FACTORIA ETSIA S.L.
 * All Rights Reserved.
 * www.factoriaetsia.com
 *
 */
package com.comparadorad.bet.comparer.web.client.gwt.common.ui.util;

import com.allen_sauer.gwt.log.client.Log;
import com.comparadorad.bet.comparer.web.client.gwt.core.ipc.AppLinkUtil;
import com.comparadorad.bet.comparer.web.client.gwt.core.ipc.InternalLinkEventNames;
import com.smartgwt.client.types.Alignment;
import com.smartgwt.client.types.Cursor;
import com.smartgwt.client.types.VerticalAlignment;
import com.smartgwt.client.widgets.Label;
import com.smartgwt.client.widgets.events.ClickEvent;
import com.smartgwt.client.widgets.events.ClickHandler;
import com.smartgwt.client.widgets.events.RightMouseDownEvent;
import com.smartgwt.client.widgets.events.RightMouseDownHandler;

/**
 * The Class InternalLinkNew.
 */
public class InternalLinkNew extends Label {

	/** The ipc event name. */
	private InternalLinkEventNames eventName;

	/** The id. */
	private String id;

	/** The id aux. */
	private String idAux;

	/** The link name. */
	private String linkName;

	/** The link util. */
	private AppLinkUtil linkUtil = new AppLinkUtil();

	/** The link width. */
	private Integer linkWidth;

	/**
	 * Instantiates a new internal link new.
	 * 
	 * @param pId
	 *            the id
	 * @param pIdAux
	 *            the id aux
	 * @param pEventName
	 *            the event name
	 * @param pLinkName
	 *            the link name
	 * @param pLinkWidth
	 *            the link width
	 */
	public InternalLinkNew(String pId, String pIdAux,
			InternalLinkEventNames pEventName, String pLinkName,
			Integer pLinkWidth) {
		super();
		id = pId;
		idAux = pIdAux;
		eventName = pEventName;
		linkName = pLinkName;
		if (pLinkWidth == null) {
			setAutoFit(true);
			setWrap(false);
		} else {
			setWidth(pLinkWidth);
		}
		setAutoHeight();
		setContents(linkName);
		setCursor(Cursor.HAND);

		setContextMenu(new InternalLinkContextMenu(pId, pIdAux, eventName));

		addClickHandler(new ClickHandler() {

			@Override
			public void onClick(ClickEvent pEvent) {
				if (pEvent.isCtrlKeyDown() && pEvent.isLeftButtonDown()) {
					linkUtil.openInternalLinkInNewWindow(id, idAux, null,
							eventName);
				} else {
					linkUtil.openInternalLinkInCurrentWindow(id, idAux,
							eventName);
				}
			}
		});

		addRightMouseDownHandler(new RightMouseDownHandler() {
			@Override
			public void onRightMouseDown(RightMouseDownEvent pEvent) {
				Log.debug("Tipo de evento: RightMouseDownEvent");
			}
		});
	}

	/**
	 * Center link.
	 */
	public void centerLink() {
		setAlign(Alignment.CENTER);
		setValign(VerticalAlignment.CENTER);
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
	 * Gets the link name.
	 * 
	 * @return the link name
	 */
	public String getLinkName() {
		return linkName;
	}

	/**
	 * Gets the link width.
	 * 
	 * @return the link width
	 */
	public int getLinkWidth() {
		return linkWidth;
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
	 * Sets the link name.
	 * 
	 * @param pLinkName
	 *            the new link name
	 */
	public void setLinkName(String pLinkName) {
		linkName = pLinkName;
	}

	/**
	 * Sets the link width.
	 * 
	 * @param pLinkWidth
	 *            the new link width
	 */
	public void setLinkWidth(int pLinkWidth) {
		linkWidth = pLinkWidth;
	}

}
