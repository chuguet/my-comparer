/**
 *
 * Copyright (C) FACTORIA ETSIA S.L.
 * All Rights Reserved.
 * www.factoriaetsia.com
 *
 */
package com.comparadorad.bet.comparer.web.client.gwt.imageslider.ui.view;

import java.util.List;

import com.allen_sauer.gwt.log.client.Log;
import com.comparadorad.bet.comparer.web.client.gwt.common.bean.literal.CommonLiterals;
import com.comparadorad.bet.comparer.web.client.gwt.common.bean.table.TableResponseCellTo;
import com.comparadorad.bet.comparer.web.client.gwt.common.bean.table.TableResponseRowTo;
import com.comparadorad.bet.comparer.web.client.gwt.common.bean.table.TableResponseTo;
import com.comparadorad.bet.comparer.web.client.gwt.common.ui.Messages;
import com.comparadorad.bet.comparer.web.client.gwt.common.ui.util.ExternalLinkContextMenu;
import com.comparadorad.bet.comparer.web.client.gwt.core.analytics.AnalyticsEventUtil;
import com.comparadorad.bet.comparer.web.client.gwt.core.ipc.AppLinkUtil;
import com.comparadorad.bet.comparer.web.client.gwt.imageslider.bean.response.ImageSliderResponseTo;
import com.google.gwt.core.client.GWT;
import com.smartgwt.client.types.Alignment;
import com.smartgwt.client.types.Cursor;
import com.smartgwt.client.types.Overflow;
import com.smartgwt.client.types.VerticalAlignment;
import com.smartgwt.client.widgets.Canvas;
import com.smartgwt.client.widgets.Img;
import com.smartgwt.client.widgets.Label;
import com.smartgwt.client.widgets.events.ClickEvent;
import com.smartgwt.client.widgets.events.ClickHandler;
import com.smartgwt.client.widgets.events.ShowContextMenuEvent;
import com.smartgwt.client.widgets.events.ShowContextMenuHandler;
import com.smartgwt.client.widgets.layout.HLayout;
import com.smartgwt.client.widgets.layout.VLayout;

/**
 * The Class TransparentTable.
 */
public class TransparentTable extends VLayout {

	/** The Constant AT. */
	private static final String AT = "@";

	/** The Constant HEIGHT. */
	private final static int HEIGHT = 90;

	/** The Constant HEIGHT_CELL4. */
	private final static int HEIGHT_CELL4 = 10;

	/** The Constant HEIGHT_CELLS. */
	private final static int HEIGHT_CELLS = 15;

	/** The Constant HEIGHT_IMG_COMTAINER. */
	private final static int HEIGHT_IMG_COMTAINER = 15;

	/** The Constant LEFT_CELL0. */
	private final static int LEFT_CELL0 = 3;

	/** The Constant LEFT_CELL1. */
	private final static int LEFT_CELL1 = 80;

	/** The Constant LEFT_CELL2. */
	private final static int LEFT_CELL2 = 90;

	/** The Constant LEFT_CELL3. */
	private final static int LEFT_CELL3 = 120;

	/** The Constant LEFT_IMAGE_CONTAINER. */
	private final static int LEFT_IMAGE_CONTAINER = 135;

	/** The Constant SEPERATOR. */
	private static final String SEPERATOR = " : ";

	/** The Constant STYLE_NAME. */
	private static final String STYLE_NAME = "imgSliderTransparentLabel";

	/** The Constant WIDTH. */
	private final static int WIDTH = 179;

	/** The Constant WIDTH_CELL0. */
	private final static int WIDTH_CELL0 = 80;

	/** The Constant WIDTH_CELL1. */
	private final static int WIDTH_CELL1 = 5;

	/** The Constant WIDTH_CELL2. */
	private final static int WIDTH_CELL2 = 10;

	/** The Constant WIDTH_CELL3. */
	private final static int WIDTH_CELL3 = 5;

	/** The Constant WIDTH_CELL4. */
	private final static int WIDTH_CELL4 = 40;

	/** The Constant WIDTH_IMG_CONTAINER. */
	private final static int WIDTH_IMG_CONTAINER = 45;

	/** The external link context menu. */
	private ExternalLinkContextMenu externalLinkContextMenu = new ExternalLinkContextMenu();

	/** The link util. */
	private AppLinkUtil linkUtil = new AppLinkUtil();

	/** The messages. */
	private Messages messages = GWT.create(Messages.class);

	/** The urls. */
	private String[] urls = new String[3];

	/**
	 * Instantiates a new transparent table.
	 * 
	 * @param response
	 *            the response
	 */
	TransparentTable(ImageSliderResponseTo response) {
		setWidth(WIDTH);
		setHeight(HEIGHT);
		setTableData(response.getTable(), response.getCompetitionLink().getName() + response.getEventLink().getName());
		setOverflow(Overflow.HIDDEN);
	}

	/**
	 * New window.
	 * 
	 * @param url
	 *            the url
	 */
	public native void newWindow(String url) /*-{
		window
				.open(
						url,
						'mywindow',
						'width=400,height=200,toolbar=yes,location=yes,directories=yes,status=yes,menubar=yes,scrollbars=yes,copyhistory=yes,resizable=yes')
	}-*/;

	/**
	 * Sets the table data.
	 * 
	 * @param response
	 *            the new table data
	 */
	protected void setTableData(TableResponseTo response, final String categoryAnalytics) {
		Log.debug("setTableData");
		for (int rowNumber = 0; rowNumber < 3
				&& rowNumber < response.getRows().size(); rowNumber++) {
			TableResponseRowTo row = response.getRows().get(rowNumber);
			List<TableResponseCellTo> cellData = row.getCellList();
			HLayout record = new HLayout();
			record.setAutoHeight();
			record.setWidth(WIDTH);

			Label cell0 = new Label();
			Label cell1 = new Label();
			Label cell2 = new Label();
			Label cell3 = new Label();

			cell0.setStyleName(STYLE_NAME);
			cell1.setStyleName(STYLE_NAME);
			cell2.setStyleName(STYLE_NAME);
			cell3.setStyleName(STYLE_NAME);

			cell0.setAlign(Alignment.CENTER);
			cell1.setAlign(Alignment.CENTER);
			cell2.setAlign(Alignment.CENTER);
			cell3.setAlign(Alignment.CENTER);

			// cell0.setWrap(false);
			cell1.setWrap(false);
			cell2.setWrap(false);
			cell3.setWrap(false);

			cell0.setWidth(WIDTH_CELL0);
			cell1.setWidth(WIDTH_CELL1);
			cell2.setWidth(WIDTH_CELL2);
			cell3.setWidth(WIDTH_CELL3);

			cell0.setHeight(HEIGHT_CELLS);
			cell1.setHeight(HEIGHT_CELLS);
			cell2.setHeight(HEIGHT_CELLS);
			cell3.setHeight(HEIGHT_CELLS);

			// String partName = cellData.get(0).getValueStr();
			String partName = "";
			if (cellData.get(0).getValueTo() != null) {
				partName = cellData.get(0).getValueTo().getValueStr();
			} else {
				partName = null;
			}

			if (partName.equalsIgnoreCase(CommonLiterals.getEmpate())) {
				partName = messages.empate();
			}
			cell0.setContents(partName);
			cell1.setContents(SEPERATOR);
			// cell2.setContents(cellData.get(1).getValueStr())
			if (cellData.get(0).getValueTo() != null) {
				cell2.setContents(cellData.get(1).getValueTo().getValueStr());
			} else {
				cell2.setContents(null);
			}

			cell3.setContents(AT);
			Img cell4 = new Img(cellData.get(2).getExternalLinkTo()
					.getLinkImgLocation());
			urls[rowNumber] = cellData.get(2).getExternalLinkTo().getUrl();
			cell4.setWidth(WIDTH_CELL4);
			cell4.setHeight(HEIGHT_CELL4);
			cell4.setCursor(Cursor.HAND);
			final int staticRowNum = rowNumber;
			final String nombreBookmaker = cellData.get(2).getExternalLinkTo().getActionAnalytics();
			cell4.addClickHandler(new ClickHandler() {

				@Override
				public void onClick(ClickEvent pEvent) {
					String encryptedUrl = urls[staticRowNum];
					AnalyticsEventUtil.trackAnalytics(categoryAnalytics, nombreBookmaker);
					Log.debug("Tipo de evento: onExternalLinkClick");
					linkUtil.openExternalLinkInNewWindow(encryptedUrl);
				}
			});

			cell4.setContextMenu(externalLinkContextMenu);

			cell4.addShowContextMenuHandler(new ShowContextMenuHandler() {
				@Override
				public void onShowContextMenu(ShowContextMenuEvent pEvent) {
					Log.debug("Tipo de evento: showContextMenu");
					externalLinkContextMenu.setEncryptedUrl(urls[staticRowNum]);
					setContextMenu(externalLinkContextMenu);
				}

			});

			VLayout imgContainer = new VLayout();
			imgContainer.setAlign(Alignment.RIGHT);
			imgContainer.setAlign(VerticalAlignment.CENTER);
			imgContainer.addMember(cell4);
			imgContainer.setWidth(WIDTH_IMG_CONTAINER);
			imgContainer.setHeight(HEIGHT_IMG_COMTAINER);

			cell0.setLeft(LEFT_CELL0);
			cell1.setLeft(LEFT_CELL1);
			cell2.setLeft(LEFT_CELL2);
			cell3.setLeft(LEFT_CELL3);
			imgContainer.setLeft(LEFT_IMAGE_CONTAINER);

			record.addChild(cell0);
			record.addChild(cell1);
			record.addChild(cell2);
			record.addChild(cell3);
			record.addChild(imgContainer);

			addMember(record);
		}
	}

	/**
	 * Update table data.
	 * 
	 * @param response
	 *            the response
	 */
	protected void updateTableData(TableResponseTo response) {
		Log.debug("updateTableData");
		Canvas[] records = getChildren();
		for (int rowNumber = 0; rowNumber < 3
				&& rowNumber < response.getRows().size(); rowNumber++) {
			TableResponseRowTo row = response.getRows().get(rowNumber);
			List<TableResponseCellTo> cellData = row.getCellList();
			HLayout record = (HLayout) records[rowNumber];
			Canvas[] cells = record.getChildren();

			Label cell0 = (Label) cells[0];
			// if (!cell0.getContents().equalsIgnoreCase(
			// cellData.get(0).getValueStr())) {
			// cell0.setContents(cellData.get(0).getValueStr());
			// }
			if (cellData.get(0).getValueTo() != null
					&& !cell0.getContents().equalsIgnoreCase(
							cellData.get(0).getValueTo().getValueStr())) {
				cell0.setContents(cellData.get(0).getValueTo().getValueStr());
			}
			Label cell2 = (Label) cells[2];
			// if (!cell2.getContents().equalsIgnoreCase(
			// cellData.get(1).getValueStr())) {
			// cell2.setContents(cellData.get(1).getValueStr());
			// }
			if (cellData.get(1).getValueTo() != null
					&& !cell2.getContents().equalsIgnoreCase(
							cellData.get(1).getValueTo().getValueStr())) {
				cell2.setContents(cellData.get(1).getValueTo().getValueStr());
			}
			VLayout cell4 = (VLayout) cells[4];
			Img image = (Img) cell4.getChildren()[0];
			if (!image.getSrc().equalsIgnoreCase(
					cellData.get(2).getExternalLinkTo().getLinkImgLocation())) {
				image.setSrc(cellData.get(2).getExternalLinkTo()
						.getLinkImgLocation());
				urls[rowNumber] = cellData.get(2).getExternalLinkTo().getUrl();
			}
			addMember(record);
		}
	}

}
