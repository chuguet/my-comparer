/**
 *
 * Copyright (C) FACTORIA ETSIA S.L.
 * All Rights Reserved.
 * www.factoriaetsia.com
 *
 */
package com.comparadorad.bet.comparer.web.client.gwt.common.ui.msg;

import com.allen_sauer.gwt.log.client.Log;
import com.comparadorad.bet.comparer.web.client.gwt.common.ui.Messages;
import com.comparadorad.bet.comparer.web.client.gwt.core.prop.AppProperties;
import com.google.gwt.core.client.GWT;
import com.smartgwt.client.util.Page;
import com.smartgwt.client.widgets.Img;
import com.smartgwt.client.widgets.Label;
import com.smartgwt.client.widgets.layout.HLayout;
import com.smartgwt.client.widgets.layout.LayoutSpacer;
import com.smartgwt.client.widgets.layout.VLayout;

/**
 * The Class ServerErrorMsg.
 */
public class ServerErrorMsg extends VLayout {

	/** The Constant STYLE_NAME. */
	private static final String STYLE_NAME = "msgServerError";

	/** The height msg. */
	private Integer heightMsg = 40;

	/** The img. */
	private Img img;

	/** The img location. */
	private String imgLocation = "comparer/error/no_disponible.jpg";

	/** The label. */
	private Label label;

	/** The messages. */
	private Messages messages = GWT.create(Messages.class);

	/** The msg. */
	private String msg = messages.paginaNoDisponibleTemporalmente();

	/** The show img. */
	private boolean showImg = false;

	/** The width msg. */
	private Integer widthMsg;

	/**
	 * Instantiates a new server error msg.
	 */
	public ServerErrorMsg() {
		super();
		initServerErrorMsg();
	}

	/**
	 * Instantiates a new server error msg.
	 * 
	 * @param pHeightMsg
	 *            the height msg
	 * @param pWidthMsg
	 *            the width msg
	 * @param pMsg
	 *            the msg
	 * @param pShowImg
	 *            the show img
	 */
	public ServerErrorMsg(Integer pHeightMsg, Integer pWidthMsg, String pMsg,
			boolean pShowImg) {
		super();
		heightMsg = pHeightMsg;
		widthMsg = pWidthMsg;
		msg = pMsg;
		showImg = pShowImg;
		initServerErrorMsg();
	}

	/**
	 * Instantiates a new server error msg.
	 * 
	 * @param pMsg
	 *            the msg
	 */
	public ServerErrorMsg(String pMsg) {
		super();
		msg = pMsg;
		initServerErrorMsg();
	}

	/**
	 * Instantiates a new server error msg.
	 * 
	 * @param pMsg
	 *            the msg
	 * @param pShowImg
	 *            the show img
	 */
	public ServerErrorMsg(String pMsg, boolean pShowImg) {
		super();
		msg = pMsg;
		showImg = pShowImg;
	}

	/**
	 * Instantiates a new server error msg.
	 * 
	 * @param pMsg
	 *            the msg
	 * @param pHeight
	 *            the height
	 * @param pWidth
	 *            the width
	 */
	public ServerErrorMsg(String pMsg, int pHeight, int pWidth) {
		super();
		this.msg = pMsg;
		this.heightMsg = pHeight;
		this.widthMsg = pWidth;
		initServerErrorMsg();
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
	 * Gets the image specific route.
	 * 
	 * @return the image specific route
	 */
	protected String getImageSpecificRoute() {
		if (AppProperties.getInstance().isLiferayEnvironment()) {
			return Page.getAppImgDir();
		} else {
			return "images/";
		}
	}

	/**
	 * Gets the img location.
	 * 
	 * @return the img location
	 */
	public String getImgLocation() {
		return imgLocation;
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
	 * Inits the server error msg.
	 */
	private void initServerErrorMsg() {
		// setBackgroundColor("red");
		// setAlign(Alignment.CENTER);
		// setAlign(VerticalAlignment.CENTER);
		if (heightMsg != null) {
			setHeight(heightMsg);
		} else {
			setAutoHeight();
		}
		if (widthMsg != null) {
			setWidth(widthMsg);
		} else {
			setAutoWidth();
		}
		label = new Label(msg);
		label.setWrap(false);
		label.setAutoFit(true);
		label.setStyleName(STYLE_NAME);
		setStyleName(STYLE_NAME);
		HLayout layoutLabel = new HLayout();
		layoutLabel.setHeight(100);
		layoutLabel.addMember(new LayoutSpacer());
		layoutLabel.addMember(label);
		layoutLabel.addMember(new LayoutSpacer());
		addMember(layoutLabel);
		if (showImg) {
			img = new Img(new StringBuffer().append(getImageSpecificRoute())
					.append(imgLocation).toString(), 154, 95);
			Log.error("route = "
					+ new StringBuffer().append(getImageSpecificRoute())
							.append(imgLocation).toString());
			HLayout layoutImg = new HLayout();
			layoutImg.setAutoHeight();
			layoutImg.addMember(new LayoutSpacer());
			layoutImg.addMember(img);
			layoutImg.addMember(new LayoutSpacer());
			addMember(layoutImg);
		}
	}

	/**
	 * Checks if is show img.
	 * 
	 * @return true, if is show img
	 */
	public boolean isShowImg() {
		return showImg;
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
	 * Sets the img location.
	 * 
	 * @param pImgLocation
	 *            the new img location
	 */
	public void setImgLocation(String pImgLocation) {
		imgLocation = pImgLocation;
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
	 * Sets the show img.
	 * 
	 * @param pShowImg
	 *            the new show img
	 */
	public void setShowImg(boolean pShowImg) {
		showImg = pShowImg;
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
