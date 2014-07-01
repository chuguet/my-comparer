/**
 *
 * Copyright (C) FACTORIA ETSIA S.L.
 * All Rights Reserved.
 * www.factoriaetsia.com
 *
 */
package com.comparadorad.bet.comparer.web.client.gwt.common.ui.img;

import com.comparadorad.bet.comparer.web.client.gwt.common.bean.cfg.response.ResourceTo;
import com.smartgwt.client.widgets.Img;

/**
 * A factory for creating Image objects.
 */
public class ImageFactory {

	/**
	 * Creates a new Image object.
	 * 
	 * @param pResourceTo
	 *            the resource to
	 * @return the img
	 */
	public static Img createImage(ResourceTo pResourceTo) {
		return createImage(pResourceTo, null, null);
	}

	/**
	 * Creates a new Image object.
	 * 
	 * @param pResourceTo
	 *            the resource to
	 * @param pWidth
	 *            the width
	 * @param pHeight
	 *            the height
	 * @return the img
	 */
	public static Img createImage(ResourceTo pResourceTo, Integer pWidth,
			Integer pHeight) {
		Integer widht = pWidth;
		Integer height = pHeight;
		if (pResourceTo.getWidth() != null) {
			widht = pResourceTo.getWidth();
		}
		if (pResourceTo.getHeight() != null) {
			height = pResourceTo.getHeight();
		}
		Img result = null;
		if (widht != null && height != null) {
			result = new Img(pResourceTo.getLocation(), widht, height);
		} else {
			result = new Img(pResourceTo.getLocation());
		}
		if (pResourceTo.getTooltip() != null) {
			result.setTooltip(pResourceTo.getTooltip());
		}
		return result;
	}

	/**
	 * Creates a new Image object.
	 * 
	 * @param location
	 *            the location
	 * @return the img
	 */
	public static Img createImage(String location) {

		Img result = new Img(location);
		return result;
	}

	public static Img createImage(String location, Integer pWidth,
			Integer pHeight) {

		Img result = new Img(location, pWidth, pHeight);
		return result;
	}
}
