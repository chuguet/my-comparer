/**
 *
 * Copyright (C) FACTORIA ETSIA S.L.
 * All Rights Reserved.
 * www.factoriaetsia.com
 *
 */
package com.comparadorad.bet.comparer.web.client.gwt.core.ui;

import com.allen_sauer.gwt.log.client.Log;
import com.smartgwt.client.util.Page;
import com.smartgwt.client.widgets.Canvas;
import com.smartgwt.client.widgets.Img;

/**
 * The Class WaitPopup.
 */
public class WaitPopup extends Canvas {

	/**
	 * Instantiates a new wait popup.
	 */
	public WaitPopup() {

		setAutoWidth();
		setAutoHeight();
		setBackgroundColor("transparent");
		
		Img loadingIcon = new Img(Page.getSkinImgDir() + "loadingSmall.gif",
				16, 16);
		addChild(loadingIcon);
		
	}

	/**
	 * Show.
	 * 
	 * @param top
	 *            the top
	 * @param left
	 *            the left
	 */
	public void show(final Integer top, final Integer left) {
		if (top != null) {
			Log.debug("WaitPopup: top = " + top);
			setTop(top);
		}
		if (left != null) {
			Log.debug("WaitPopup: left = " + left);
			setLeft(left);
		}
		show();
	}

}