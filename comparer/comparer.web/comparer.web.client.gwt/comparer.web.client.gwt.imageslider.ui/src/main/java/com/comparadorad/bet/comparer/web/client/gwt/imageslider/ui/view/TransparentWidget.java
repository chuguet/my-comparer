/**
 *
 * Copyright (C) FACTORIA ETSIA S.L.
 * All Rights Reserved.
 * www.factoriaetsia.com
 *
 */
package com.comparadorad.bet.comparer.web.client.gwt.imageslider.ui.view;

import com.comparadorad.bet.comparer.web.client.gwt.common.ui.util.InternalLinkNew;
import com.comparadorad.bet.comparer.web.client.gwt.core.ipc.InternalLinkEventNames;
import com.comparadorad.bet.comparer.web.client.gwt.imageslider.bean.response.ImageSliderResponseTo;
import com.comparadorad.bet.comparer.web.client.gwt.imageslider.bean.response.ImageSliderUpdateResponseTo;
import com.comparadorad.bet.comparer.web.client.gwt.imageslider.ui.Messages;
import com.google.gwt.core.client.GWT;
import com.smartgwt.client.types.Alignment;
import com.smartgwt.client.widgets.Label;
import com.smartgwt.client.widgets.layout.HLayout;
import com.smartgwt.client.widgets.layout.VLayout;

/**
 * The Class TransparentWidget.
 */
public class TransparentWidget extends VLayout {

	/** The Constant HEIGHT. */
	private final static int HEIGHT = 190;

	/** The Constant HEIGHT_FIRST. */
	private final static int HEIGHT_FIRST = 20;

	/** The Constant SEPERATOR. */
	private static final String SEPERATOR = " : ";

	/** The Constant STYLE_NAME. */
	private static final String STYLE_NAME = "imgSliderTransparentLabel";

	/** The Constant STYLE_NAME_LINK. */
	private static final String STYLE_NAME_LINK = "imgSliderLink";

	/** The Constant TOP_COMPETITION_LINK. */
	private final static int TOP_COMPETITION_LINK = 44;

	/** The Constant TOP_EVENT_LINK. */
	private final static int TOP_EVENT_LINK = 29;

	/** The Constant TOP_FIRST. */
	private final static int TOP_FIRST = 7;

	/** The Constant TOP_TABLE. */
	private final static int TOP_TABLE = 100;

	/** The Constant TOP_THIRD. */
	private final static int TOP_THIRD = 74;

	/** The Constant WIDTH. */
	private final static int WIDTH = 179;

	/** The messages. */
	private Messages messages = GWT.create(Messages.class);

	/** The table. */
	TransparentTable table;

	/**
	 * Instantiates a new transparent widget.
	 */
	public TransparentWidget() {
		super();
		setWidth(WIDTH);
		setHeight(HEIGHT);
	}

	/**
	 * Instantiates a new transparent widget.
	 * 
	 * @param response
	 *            the response
	 */
	public TransparentWidget(ImageSliderResponseTo response) {
		setStyleName(STYLE_NAME);
		setWidth(WIDTH);
		setHeight(HEIGHT);
		animateFade(70);
		setMembersMargin(0);

		Label first = new Label(messages.consigaLasMejoresCuotasEn());
		first.setStyleName(STYLE_NAME);
		first.setAlign(Alignment.CENTER);
		first.setWidth(WIDTH);
		first.setHeight(HEIGHT_FIRST);
		first.setTop(TOP_FIRST);
		addChild(first);

		InternalLinkNew eventLink = new InternalLinkNew(response.getEventLink()
				.getObjectToId().getId(), response.getEventLink()
				.getObjectToIdAux().getId(),
				InternalLinkEventNames.IMAGE_SLIDER_MATCH_EVENT, response
						.getEventLink().getName(), new Integer(WIDTH));
		eventLink.setAlign(Alignment.CENTER);
		eventLink.setStyleName(STYLE_NAME_LINK);
		eventLink.setTop(TOP_EVENT_LINK);
		addChild(eventLink);

		InternalLinkNew competitionLink = new InternalLinkNew(response
				.getCompetitionLink().getObjectToId().getId(), response
				.getCompetitionLink().getObjectToIdAux().getId(),
				InternalLinkEventNames.IMAGE_SLIDER_COMPETITION_EVENT, response
						.getCompetitionLink().getName(), new Integer(179));
		competitionLink.setAlign(Alignment.CENTER);
		competitionLink.setStyleName(STYLE_NAME_LINK);
		competitionLink.setTop(TOP_COMPETITION_LINK);
		addChild(competitionLink);

		HLayout transparentThird = new HLayout();
		transparentThird.setAlign(Alignment.CENTER);
		transparentThird.setWidth(WIDTH);
		transparentThird.setAutoHeight();
		Label eventDate = new Label(response.getEventDate());
		eventDate.setAlign(Alignment.CENTER);
		eventDate.setStyleName(STYLE_NAME);
		eventDate.setAutoFit(true);
		eventDate.setWrap(false);
		Label seperator = new Label(SEPERATOR);
		seperator.setStyleName(STYLE_NAME);
		seperator.setAlign(Alignment.CENTER);
		seperator.setAutoFit(true);
		Label betType = new Label(response.getBetType());
		betType.setStyleName(STYLE_NAME);
		betType.setAlign(Alignment.CENTER);
		betType.setAutoFit(true);
		betType.setWrap(false);
		transparentThird.addMember(eventDate);
		transparentThird.addMember(seperator);
		transparentThird.addMember(betType);
		transparentThird.setTop(TOP_THIRD);
		addChild(transparentThird);
		table = new TransparentTable(response);
		table.setTop(TOP_TABLE);
		addChild(table);

		bringToFront();
		setVisible(false);

	}

	/**
	 * Update table data.
	 * 
	 * @param response
	 *            the response
	 */
	protected void updateTableData(ImageSliderUpdateResponseTo response) {
		table.updateTableData(response.getTable());
	}

}
