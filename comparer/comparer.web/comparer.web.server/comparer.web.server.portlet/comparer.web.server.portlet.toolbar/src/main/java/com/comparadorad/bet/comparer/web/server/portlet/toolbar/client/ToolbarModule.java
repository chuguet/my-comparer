/**
 *
 * Copyright (C) FACTORIA ETSIA S.L.
 * All Rights Reserved.
 * www.factoriaetsia.com
 *
 */
package com.comparadorad.bet.comparer.web.server.portlet.toolbar.client;

import com.comparadorad.bet.comparer.web.client.gwt.core.module.AbstractModule;
import com.comparadorad.bet.comparer.web.client.gwt.toolbar.sports.ui.LeftToolbar;

/**
 * Entry point classes define <code>onModuleLoad()</code>.
 */
public class ToolbarModule extends AbstractModule {

	/** {@inheritDoc} */
	@Override
	protected String getAppPath() {
		return "com.comparadorad.bet.comparer.web.server.portlet.toolbar";
	}

	/** {@inheritDoc} */
	@Override
	protected String getMainContainerId() {
		return "toolbarModuleContainer";
	}

	/**
	 * This is the entry point method.
	 */
	@Override
	public void onModuleLoadActions() {
		LeftToolbar leftToolbar = new LeftToolbar();
		getMainContainerRootPanel().add(leftToolbar);
	}
}
