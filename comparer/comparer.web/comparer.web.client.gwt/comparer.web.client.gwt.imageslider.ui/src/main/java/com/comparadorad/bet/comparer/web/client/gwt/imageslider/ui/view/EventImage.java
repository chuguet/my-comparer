/**
 *
 * Copyright (C) FACTORIA ETSIA S.L.
 * All Rights Reserved.
 * www.factoriaetsia.com
 *
 */
package com.comparadorad.bet.comparer.web.client.gwt.imageslider.ui.view;

import com.allen_sauer.gwt.log.client.Log;
import com.smartgwt.client.types.Alignment;
import com.smartgwt.client.types.AnimationAcceleration;
import com.smartgwt.client.types.VerticalAlignment;
import com.smartgwt.client.types.Visibility;
import com.smartgwt.client.widgets.Img;

/**
 * The Class EventImage.
 */
public class EventImage extends Img {

	/** The src. */
	String src;

	/**
	 * Instantiates a new event image.
	 */
	public EventImage() {
		super();
		initEventImage();
	}

	/**
	 * Instantiates a new event image.
	 * 
	 * @param pSrc
	 *            the src
	 */
	public EventImage(String pSrc) {
		this.src = verifyImgSrc(pSrc);
		setSrc(src);
		initEventImage();
	}

	private final static int WIDTH = 680;
	private final static int HEIGHT = 190;
	
	/**
	 * Inits the event image.
	 */
	private void initEventImage() {
		setPadding(0);
		setWidth(WIDTH);
		setHeight(HEIGHT);
		setVisibility(Visibility.HIDDEN);
		setValign(VerticalAlignment.CENTER);
		setAlign(Alignment.CENTER);
		setAnimateTime(1200);
		setAnimateAcceleration(AnimationAcceleration.SMOOTH_START);
	}

	/**
	 * Verify img src.
	 * 
	 * @param src
	 *            the src
	 * @return the string
	 */
	private String verifyImgSrc(String src) {
		Log.debug("original img src= " + src);
		if (src.substring(0, 7).equalsIgnoreCase("/images")) {
			src = src.substring(6, src.length());
		}
		return src;
	}

}
