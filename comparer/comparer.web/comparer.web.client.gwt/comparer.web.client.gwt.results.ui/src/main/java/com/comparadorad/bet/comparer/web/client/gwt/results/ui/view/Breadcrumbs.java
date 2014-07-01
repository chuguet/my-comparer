/**
 *
 * Copyright (C) FACTORIA ETSIA S.L.
 * All Rights Reserved.
 * www.factoriaetsia.com
 *
 */
package com.comparadorad.bet.comparer.web.client.gwt.results.ui.view;

import java.util.List;

import com.allen_sauer.gwt.log.client.Log;
import com.comparadorad.bet.comparer.web.client.gwt.common.bean.LinkTo;
import com.comparadorad.bet.comparer.web.client.gwt.common.ui.util.InternalLinkNew;
import com.comparadorad.bet.comparer.web.client.gwt.core.ipc.InternalLinkEventNames;
import com.comparadorad.bet.comparer.web.client.gwt.results.ui.Messages;
import com.google.gwt.core.client.GWT;
import com.smartgwt.client.types.Alignment;
import com.smartgwt.client.types.VerticalAlignment;
import com.smartgwt.client.widgets.Label;
import com.smartgwt.client.widgets.layout.HLayout;
import com.smartgwt.client.widgets.layout.LayoutSpacer;

/**
 * The Class Breadcrumbs.
 */
public class Breadcrumbs extends HLayout {

	/** The Constant BREADCRUMB_SEPARATOR. */
	private static final String BREADCRUMB_SEPARATOR = ">";

	/** The Constant BREADCRUMBS_HEIGHT. */
	private static final int BREADCRUMBS_HEIGHT = 25;

	/** The Constant eventNames. */
	private static final InternalLinkEventNames[] eventNames = {
			InternalLinkEventNames.RESULTS_SPORT_EVENT,
			InternalLinkEventNames.RESULTS_COUNTRY_EVENT,
			InternalLinkEventNames.RESULTS_COMPETITION_EVENT };

	/** The main. */
	private InternalLinkNew main;

	/** The messages. */
	private Messages messages = GWT.create(Messages.class);

	/**
	 * Instantiates a new breadcrumbs.
	 */
	public Breadcrumbs() {
		Log.debug("Breadcrumbs constr");
		setHeight(BREADCRUMBS_HEIGHT);
		setAutoWidth();
		main = new InternalLinkNew("", "",
				InternalLinkEventNames.RESULTS_MAIN_EVENT, messages.inicio(),
				(Integer) null);
		main.setStyleName("resBreadcrumbLink");
		addMember(main);
	}

	/**
	 * Adds the breadcrumbs.
	 * 
	 * @param breadcrumbs
	 *            the breadcrumbs
	 */
	public void addBreadcrumbs(List<LinkTo> breadcrumbs) {
		int eventNameIndex = 0;
		LayoutSpacer space;
		for (LinkTo breadrumb : breadcrumbs) {
			space = new LayoutSpacer();
			space.setWidth(5);
			addMember(space);
			Label separator = new Label(BREADCRUMB_SEPARATOR);
			separator.setAutoFit(true);
			separator.setWrap(false);
			separator.setAlign(Alignment.CENTER);
			separator.setValign(VerticalAlignment.TOP);
			addMember(separator);
			space = new LayoutSpacer();
			space.setWidth(5);
			addMember(space);
			String id = null;
			String idAux = null;
			if (breadrumb.getObjectToId() != null) {
				id = breadrumb.getObjectToId().getId();
			}
			if (breadrumb.getObjectToIdAux() != null) {
				idAux = breadrumb.getObjectToIdAux().getId();
			}
			if (eventNameIndex < breadcrumbs.size() - 1) {
				InternalLinkNew breadcrumb = new InternalLinkNew(id, idAux,
						eventNames[eventNameIndex], breadrumb.getName(), null);
				breadcrumb.setStyleName("resBreadcrumbLink");
				addMember(breadcrumb);
			} else {
				Label lastBreadcrumb = new Label(breadrumb.getName());
				lastBreadcrumb.setAutoFit(true);
				lastBreadcrumb.setWrap(false);
				lastBreadcrumb.setAutoHeight();
				lastBreadcrumb.setStyleName("resBreadcrumbNoLink");
				addMember(lastBreadcrumb);
			}

			eventNameIndex++;
		}
	}

}
