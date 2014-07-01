/**
 *
 * Copyright (C) FACTORIA ETSIA S.L.
 * All Rights Reserved.
 * www.factoriaetsia.com
 *
 */
package com.comparadorad.bet.comparer.web.client.gwt.imageslider.ui.view;

import com.allen_sauer.gwt.log.client.Log;
import com.comparadorad.bet.comparer.web.client.gwt.common.bean.table.TableResponseCellTo;
import com.comparadorad.bet.comparer.web.client.gwt.common.bean.table.TableResponseRowTo;
import com.comparadorad.bet.comparer.web.client.gwt.common.bean.table.TableResponseTo;
import com.comparadorad.bet.comparer.web.client.gwt.core.ipc.AppLinkUtil;
import com.comparadorad.bet.comparer.web.client.gwt.core.ipc.InternalLinkEventNames;
import com.comparadorad.bet.comparer.web.client.gwt.imageslider.bean.response.ImageSliderResponseTo;
import com.comparadorad.bet.comparer.web.client.gwt.imageslider.ui.Messages;
import com.google.gwt.core.client.GWT;
import com.google.gwt.i18n.client.NumberFormat;
import com.smartgwt.client.types.Alignment;
import com.smartgwt.client.types.Overflow;
import com.smartgwt.client.widgets.Canvas;
import com.smartgwt.client.widgets.IButton;
import com.smartgwt.client.widgets.Label;
import com.smartgwt.client.widgets.events.ClickEvent;
import com.smartgwt.client.widgets.events.ClickHandler;
import com.smartgwt.client.widgets.layout.HLayout;
import com.smartgwt.client.widgets.layout.VLayout;

/**
 * The Class CompareQuotasWidget.
 */
public class CompareQuotasWidget extends VLayout {

	/** The Constant HEIGHT. */
	private static final int HEIGHT = 190;

	/** The Constant HEIGHT_BUTTON. */
	private static final int HEIGHT_BUTTON = 15;

	/** The Constant HEIGHT_FIRST. */
	private static final int HEIGHT_FIRST = 20;

	/** The Constant HEIGHT_SECOND. */
	private static final int HEIGHT_SECOND = 20;

	/** The Constant HEIGHT_THIRD. */
	private static final int HEIGHT_THIRD = 15;

	/** The Constant STYLE_NAME_BLACK_LABEL. */
	private final static String STYLE_NAME_BLACK_LABEL = "imgSliderRightSideLabelBlack";

	/** The Constant STYLE_NAME_COMPARE_QUOTAS_LABEL. */
	private final static String STYLE_NAME_COMPARE_QUOTAS_LABEL = "imgSliderRightSideLabel";

	/** The Constant STYLE_NAME_SMALL_LABEL. */
	private final static String STYLE_NAME_SMALL_LABEL = "imgSliderRightSideSmallLabel";

	/** The Constant STYLE_NAME_YELLOW_LABEL. */
	private final static String STYLE_NAME_YELLOW_LABEL = "imgSliderRightSideLabelYellow";

	/** The Constant TOP_BUTTON. */
	private static final int TOP_BUTTON = 130;

	/** The Constant TOP_FIRST. */
	private static final int TOP_FIRST = 30;

	/** The Constant TOP_SECOND. */
	private static final int TOP_SECOND = 60;

	/** The Constant TOP_THIRD. */
	private static final int TOP_THIRD = 80;

	/** The Constant WIDTH. */
	private static final int WIDTH = 152;

	/** The link util. */
	private AppLinkUtil linkUtil = new AppLinkUtil();

	/** The messages. */
	private Messages messages = GWT.create(Messages.class);

	/**
	 * Instantiates a new compare quotas widget.
	 */
	public CompareQuotasWidget() {
		setWidth(WIDTH);
		setHeight(HEIGHT);
	}

	/**
	 * Instantiates a new compare quotas widget.
	 * 
	 * @param response
	 *            the response
	 */
	public CompareQuotasWidget(final ImageSliderResponseTo response) {
		setWidth(WIDTH);
		setHeight(HEIGHT);
		setStyleName(STYLE_NAME_COMPARE_QUOTAS_LABEL);
		setDefaultLayoutAlign(Alignment.CENTER);

		Label compareQuotasFirst = new Label(messages.puedeGanarDesde());
		compareQuotasFirst.setStyleName(STYLE_NAME_BLACK_LABEL);
		compareQuotasFirst.setWidth(WIDTH);
		compareQuotasFirst.setHeight(HEIGHT_FIRST);
		compareQuotasFirst.setTop(TOP_FIRST);
		compareQuotasFirst.setAlign(Alignment.CENTER);
		addChild(compareQuotasFirst);

		HLayout compareQuotasSecond = new HLayout();
		compareQuotasSecond.setMembersMargin(0);
		compareQuotasSecond.setTop(TOP_SECOND);
		compareQuotasSecond.setWidth(WIDTH);
		compareQuotasSecond.setHeight(HEIGHT_SECOND);
		compareQuotasSecond.setAlign(Alignment.CENTER);
		compareQuotasSecond.setMembersMargin(3);
		Label cqs1 = new Label(NumberFormat.getFormat("00.0").format(
				Double.parseDouble(getLowestOdd(response.getTable())) * 10));
		cqs1.setStyleName(STYLE_NAME_YELLOW_LABEL);
		Label cqs2 = new Label(messages.euro());
		cqs2.setStyleName(STYLE_NAME_YELLOW_LABEL);
		Label cqs3 = new Label(messages.a());
		cqs3.setStyleName(STYLE_NAME_BLACK_LABEL);
		Label cqs4 = new Label(NumberFormat.getFormat("00.0").format(
				Double.parseDouble(getHighestOdd(response.getTable())) * 10));
		cqs4.setStyleName(STYLE_NAME_YELLOW_LABEL);
		Label cqs5 = new Label(messages.euro());
		cqs5.setStyleName(STYLE_NAME_YELLOW_LABEL);

		cqs1.setAutoFit(true);
		cqs2.setAutoFit(true);
		cqs3.setAutoFit(true);
		cqs4.setAutoFit(true);
		cqs5.setAutoFit(true);
		compareQuotasSecond.addMember(cqs1);
		compareQuotasSecond.addMember(cqs2);
		compareQuotasSecond.addMember(cqs3);
		compareQuotasSecond.addMember(cqs4);
		compareQuotasSecond.addMember(cqs5);
		addChild(compareQuotasSecond);

		Label compareQuotasThird = new Label(
				messages.invirtiendoTanSolo10Euros());
		compareQuotasThird.setStyleName(STYLE_NAME_SMALL_LABEL);
		compareQuotasThird.setWrap(false);
		compareQuotasThird.setWidth(WIDTH);
		compareQuotasThird.setHeight(HEIGHT_THIRD);
		compareQuotasThird.setTop(TOP_THIRD);
		compareQuotasThird.setAlign(Alignment.CENTER);
		addChild(compareQuotasThird);

		HLayout buttonLayout = new HLayout();
		buttonLayout.setAlign(Alignment.CENTER);
		buttonLayout.setWidth(WIDTH);
		buttonLayout.setTop(TOP_BUTTON);
		buttonLayout.setHeight(HEIGHT_BUTTON);

		IButton compareQuotasButton = new IButton();
		compareQuotasButton.setTitle(messages.compareLasCuotas());
		compareQuotasButton.setOverflow(Overflow.VISIBLE);
		compareQuotasButton.setAutoWidth();

		compareQuotasButton.addClickHandler(new ClickHandler() {

			@Override
			public void onClick(ClickEvent pEvent) {
				if (pEvent.isCtrlKeyDown() && pEvent.isLeftButtonDown()) {
					linkUtil.openInternalLinkInNewWindow(response.getEventId()
							.getId(), response.getBetTypeId().getId(), null,
							InternalLinkEventNames.IMAGE_SLIDER_MATCH_EVENT);
				} else {
					linkUtil.openInternalLinkInCurrentWindow(response
							.getEventId().getId(), response.getBetTypeId()
							.getId(),
							InternalLinkEventNames.IMAGE_SLIDER_MATCH_EVENT);
				}
			}
		});

		buttonLayout.addMember(compareQuotasButton);
		addChild(buttonLayout);

		setVisible(false);
	}

	/**
	 * Gets the highest odd.
	 * 
	 * @param response
	 *            the response
	 * @return the highest odd
	 */
	public String getHighestOdd(TableResponseTo response) {
		double max = 0;
		for (TableResponseRowTo rowData : response.getRows()) {
			for (TableResponseCellTo cellData : rowData.getCellList()) {
				// if (cellData.getValueStr() != null
				// && isDouble(cellData.getValueStr())
				// && Double.parseDouble(cellData.getValueStr()) > max) {
				// max = Double.parseDouble(cellData.getValueStr());
				// }
				if (cellData.getValueTo() != null
						&& cellData.getValueTo().getValueStr() != null
						&& isDouble(cellData.getValueTo().getValueStr())
						&& Double.parseDouble(cellData.getValueTo()
								.getValueStr()) > max) {
					max = Double.parseDouble(cellData.getValueTo()
							.getValueStr());
				}
			}
		}
		return Double.toString(max);
	}

	/**
	 * Gets the lowest odd.
	 * 
	 * @param response
	 *            the response
	 * @return the lowest odd
	 */
	public String getLowestOdd(TableResponseTo response) {
		double min = Double.parseDouble(getHighestOdd(response));
		for (TableResponseRowTo rowData : response.getRows()) {
			for (TableResponseCellTo cellData : rowData.getCellList()) {
				// if (cellData.getValueStr() != null
				// && isDouble(cellData.getValueStr())
				// && Double.parseDouble(cellData.getValueStr()) < min) {
				// min = Double.parseDouble(cellData.getValueStr());
				// }
				if (cellData.getValueTo() != null
						&& cellData.getValueTo().getValueStr() != null
						&& isDouble(cellData.getValueTo().getValueStr())
						&& Double.parseDouble(cellData.getValueTo()
								.getValueStr()) < min) {
					min = Double.parseDouble(cellData.getValueTo()
							.getValueStr());
				}
			}
		}
		return Double.toString(min);
	}

	/**
	 * Checks if is double.
	 * 
	 * @param stringValue
	 *            the string value
	 * @return true, if is double
	 */
	private boolean isDouble(String stringValue) {
		try {
			Double.parseDouble(stringValue);
		} catch (NumberFormatException e) {
			return false;
		}
		return true;
	}

	/**
	 * Update profits.
	 * 
	 * @param response
	 *            the response
	 */
	public void updateProfits(TableResponseTo response) {
		Log.debug("updateProfits");
		Canvas[] children = getChildren();
		HLayout quotas = (HLayout) children[1];
		Canvas[] children2 = quotas.getChildren();
		Label odd1 = (Label) children2[0];
		odd1.setContents(NumberFormat.getFormat("00.0").format(
				Double.parseDouble(getLowestOdd(response)) * 10));
		Label odd2 = (Label) children2[3];
		odd2.setContents(NumberFormat.getFormat("00.0").format(
				Double.parseDouble(getHighestOdd(response)) * 10));
	}

}
