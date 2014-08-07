/**
 *
 * Copyright (C) FACTORIA ETSIA S.L.
 * All Rights Reserved.
 * www.factoriaetsia.com
 *
 */
package com.comparadorad.bet.comparer.web.client.gwt.toolbar.sports.ui;

import com.smartgwt.client.widgets.Img;
import com.smartgwt.client.widgets.Label;
import com.smartgwt.client.widgets.layout.HLayout;

/**
 * The Class FirstLevel.
 */
public class FirstAndSecondLevel extends HLayout {

	/** The Constant HEIGHT. */
	private static final int HEIGHT = 20;

	/** The Constant ICON_CLOSED. */
	private static final String ICON_CLOSED = "[SKIN]/SectionHeader/opener_closed.png";

	/** The Constant ICON_LEFT. */
	private static final int ICON_LEFT = 155;

	/** The Constant ICON_OPENED. */
	private static final String ICON_OPENED = "[SKIN]/SectionHeader/opener_opened.png";

	/** The Constant ICON_SIZE. */
	private static final int ICON_SIZE = 15;

	/** The Constant WIDTH. */
	private static final int WIDTH = 175;

	/** The Constant WIDTH_LABEL. */
	private static final int WIDTH_LABEL = 120;

	/** The icon. */
	private Img icon;

	/** The Constant IMG_HEIGHT. */
	private int iconHeight;

	/** The Constant IMG_WIDTH. */
	private int iconWidth;

	/** The img. */
	private Img img;

	/** The label. */
	private Label label;

	/**
	 * Instantiates a new first level.
	 * 
	 * @param location
	 *            the location
	 * @param name
	 *            the name
	 * @param pIconHeight
	 *            the icon height
	 * @param pIconWidth
	 *            the icon width
	 */
	public FirstAndSecondLevel(String location, String name, int pIconHeight,
			int pIconWidth) {

		this.iconHeight = pIconHeight;
		this.iconWidth = pIconWidth;

		setWidth(WIDTH);
		setHeight(HEIGHT);

		if (location != null) {
			img = new Img(location, iconWidth, iconHeight);
			img.setTop((HEIGHT - iconHeight) / 2);
			addChild(img);
		}

		label = new Label(name);
		label.setHeight(HEIGHT);
		label.setWidth(WIDTH_LABEL);
		label.setWrap(false);
		addChild(label);

		icon = new Img();
		icon.setSrc(ICON_CLOSED);
		icon.setWidth(ICON_SIZE);
		icon.setHeight(ICON_SIZE);
		icon.setLeft(ICON_LEFT);
		addChild(icon);

	}

	/**
	 * Change to closed icon.
	 */
	public void changeToClosedIcon() {
		icon.setSrc(ICON_CLOSED);
	}

	/**
	 * Change to open icon.
	 */
	public void changeToOpenIcon() {
		icon.setSrc(ICON_OPENED);
	}

	/**
	 * Gets the icon.
	 * 
	 * @return the icon
	 */
	public Img getIcon() {
		return icon;
	}

	/**
	 * Gets the icon height.
	 * 
	 * @return the icon height
	 */
	public int getIconHeight() {
		return iconHeight;
	}

	/**
	 * Gets the icon width.
	 * 
	 * @return the icon width
	 */
	public int getIconWidth() {
		return iconWidth;
	}

	/**
	 * Gets the img.
	 * 
	 * @return the img
	 */
	public Img getImg() {
		return img;
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
	 * Sets the icon.
	 * 
	 * @param pIcon
	 *            the new icon
	 */
	public void setIcon(Img pIcon) {
		icon = pIcon;
	}

	/**
	 * Sets the icon height.
	 * 
	 * @param pIconHeight
	 *            the new icon height
	 */
	public void setIconHeight(int pIconHeight) {
		iconHeight = pIconHeight;
	}

	/**
	 * Sets the icon width.
	 * 
	 * @param pIconWidth
	 *            the new icon width
	 */
	public void setIconWidth(int pIconWidth) {
		iconWidth = pIconWidth;
	}

	/**
	 * Sets the img.
	 * 
	 * @param pImg
	 *            the new img
	 */
	public void setImg(Img pImg) {
		img = pImg;
	}

	/**
	 * Sets the img left.
	 * 
	 * @param left
	 *            the new img left
	 */
	public void setImgLeft(int left) {
		if (img != null) {
			img.setLeft(left);
		}
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
	 * Sets the label left.
	 * 
	 * @param left
	 *            the new label left
	 */
	public void setLabelLeft(int left) {
		label.setLeft(left);
	}

	/**
	 * Sets the label style name.
	 * 
	 * @param styleName
	 *            the new label style name
	 */
	public void setLabelStyleName(String styleName) {
		label.setStyleName(styleName);
	}

}
