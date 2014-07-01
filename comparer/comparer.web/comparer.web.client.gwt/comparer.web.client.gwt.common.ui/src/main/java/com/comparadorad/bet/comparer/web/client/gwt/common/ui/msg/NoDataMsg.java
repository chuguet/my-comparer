/**
 *
 * Copyright (C) FACTORIA ETSIA S.L.
 * All Rights Reserved.
 * www.factoriaetsia.com
 *
 */
package com.comparadorad.bet.comparer.web.client.gwt.common.ui.msg;

import com.comparadorad.bet.comparer.web.client.gwt.common.ui.Messages;
import com.google.gwt.core.client.GWT;
import com.smartgwt.client.widgets.Label;
import com.smartgwt.client.widgets.layout.VLayout;

/**
 * The Class NoDataMsg.
 */
public class NoDataMsg extends VLayout {

	/** The Constant STYLE_NAME. */
	private static final String STYLE_NAME = "msgNoData";

	/** The height msg. */
	private Integer heightMsg = 40;

	/** The label. */
	private Label label;

	/** The messages. */
	private Messages messages = GWT.create(Messages.class);

	/** The msg. */
	private String msg = messages.noHayDatos();

	/** The width msg. */
	private Integer widthMsg;

	/**
	 * Instantiates a new no data msg.
	 */
	public NoDataMsg() {
		super();
		initNoDataMsg();
	}

	/**
	 * Instantiates a new no data msg.
	 * 
	 * @param pMsg
	 *            the msg
	 */
	public NoDataMsg(String pMsg) {
		super();
		msg = pMsg;
		initNoDataMsg();
	}

	/**
	 * Instantiates a new no data msg.
	 * 
	 * @param pMsg
	 *            the msg
	 * @param pHeight
	 *            the height
	 * @param pWidth
	 *            the width
	 */
	public NoDataMsg(String pMsg, int pHeight, int pWidth) {
		super();
		msg = pMsg;
		this.heightMsg = pHeight;
		this.widthMsg = pWidth;
		initNoDataMsg();
	}

	/**
	 * Gets the height msg.
	 * 
	 * @return the height msg
	 */
	public int getHeightMsg() {
		return heightMsg;
	}

	/**
	 * Gets the label.
	 * 
	 * @return the label
	 */
	public Label getLabel() {
		return label;
	}

	/**
	 * Gets the msg.
	 * 
	 * @return the msg
	 */
	public String getMsg() {
		return msg;
	}

	/**
	 * Gets the width msg.
	 * 
	 * @return the width msg
	 */
	public int getWidthMsg() {
		return widthMsg;
	}

	/**
	 * Inits the no data msg.
	 */
	private void initNoDataMsg() {
		label = new Label(msg);
		label.setWrap(false);
		label.setStyleName(STYLE_NAME);
		if (heightMsg != null) {
			setHeight(heightMsg);
			label.setHeight(heightMsg);
		} else {
			setAutoHeight();
			label.setAutoFit(true);
		}
		if (widthMsg != null) {
			setWidth(widthMsg);
			label.setWidth(widthMsg);
		} else {
			setAutoWidth();
			label.setAutoFit(true);
		}
		addMember(label);
		setStyleName(STYLE_NAME);
	}

	/**
	 * Sets the height msg.
	 * 
	 * @param pHeightMsg
	 *            the new height msg
	 */
	public void setHeightMsg(int pHeightMsg) {
		heightMsg = pHeightMsg;
	}

	/**
	 * Sets the label.
	 * 
	 * @param pLabel
	 *            the new label
	 */
	public void setLabel(Label pLabel) {
		label = pLabel;
	}

	/**
	 * Sets the msg.
	 * 
	 * @param pMsg
	 *            the new msg
	 */
	public void setMsg(String pMsg) {
		msg = pMsg;
	}

	/**
	 * Sets the width msg.
	 * 
	 * @param pWidthMsg
	 *            the new width msg
	 */
	public void setWidthMsg(int pWidthMsg) {
		widthMsg = pWidthMsg;
	}

}
