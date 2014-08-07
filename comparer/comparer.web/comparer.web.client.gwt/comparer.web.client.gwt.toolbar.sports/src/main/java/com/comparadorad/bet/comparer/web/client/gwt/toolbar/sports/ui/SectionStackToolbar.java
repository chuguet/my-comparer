/**
 *
 * Copyright (C) FACTORIA ETSIA S.L.
 * All Rights Reserved.
 * www.factoriaetsia.com
 *
 */
package com.comparadorad.bet.comparer.web.client.gwt.toolbar.sports.ui;

import com.smartgwt.client.types.Overflow;
import com.smartgwt.client.types.VisibilityMode;
import com.smartgwt.client.widgets.layout.SectionStack;

/**
 * The Class SectionStackToolbar.
 */
public class SectionStackToolbar extends SectionStack {

	/**
	 * Instantiates a new section stack toolbar.
	 */
	public SectionStackToolbar() {
		setAnimateSections(false);
		setVisibilityMode(VisibilityMode.MULTIPLE);
		setOverflow(Overflow.VISIBLE);
		setWidth(180);
		setAutoHeight();
		setShowExpandControls(false);
	}

}
