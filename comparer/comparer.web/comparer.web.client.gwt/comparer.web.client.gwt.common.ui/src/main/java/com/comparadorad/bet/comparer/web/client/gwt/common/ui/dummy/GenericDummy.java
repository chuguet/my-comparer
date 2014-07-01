/**
 *
 * Copyright (C) FACTORIA ETSIA S.L.
 * All Rights Reserved.
 * www.factoriaetsia.com
 *
 */
package com.comparadorad.bet.comparer.web.client.gwt.common.ui.dummy;

import com.comparadorad.bet.comparer.web.client.gwt.common.bean.ExternalLinkTo;
import com.comparadorad.bet.comparer.web.client.gwt.common.bean.LinkTo;
import com.comparadorad.bet.comparer.web.client.gwt.common.bean.ObjectToId;
import com.comparadorad.bet.comparer.web.client.gwt.common.bean.ValueTo;
import com.comparadorad.bet.comparer.web.client.gwt.common.bean.cfg.response.ResourceTo;
import com.comparadorad.bet.comparer.web.client.gwt.common.bean.table.TableResponseCellTo;
import com.comparadorad.bet.comparer.web.client.gwt.common.bean.table.TableResponseRowTitleTo;
import com.comparadorad.bet.comparer.web.client.gwt.common.bean.table.TableResponseRowTo;
import com.comparadorad.bet.comparer.web.client.gwt.core.encrypt.EncryptUtil;
import com.google.gwt.i18n.client.DateTimeFormat;

/**
 * The Class GenericDummy.
 */
public class GenericDummy {

	/** The Constant DATE. */
	protected static final DateTimeFormat DATE = DateTimeFormat
			.getFormat("dd/MM/yyyy");

	/** The Constant TIME. */
	protected static final DateTimeFormat TIME = DateTimeFormat
			.getFormat("HH:mm");

	/**
	 * Gets the bookmaker img medium.
	 * 
	 * @param bookmakerName
	 *            the bookmaker name
	 * @return the bookmaker img medium
	 */
	protected String getBookmakerImgMedium(String bookmakerName) {
		return new StringBuffer("comparer/bookmaker/medium/")
				.append(bookmakerName).append("_105x20").append(".jpg")
				.toString();
	}

	/**
	 * Gets the bookmaker img small.
	 * 
	 * @param bookmakerName
	 *            the bookmaker name
	 * @return the bookmaker img small
	 */
	protected String getBookmakerImgSmall(String bookmakerName) {
		return new StringBuffer("comparer/bookmaker/small/")
				.append(bookmakerName).append("_65x15").append(".jpg")
				.toString();
	}

	/**
	 * Gets the new cell.
	 * 
	 * @param cellId
	 *            the cell id
	 * @param value
	 *            the value
	 * @param date
	 *            the date
	 * @param internalLinkName
	 *            the internal link name
	 * @param internalLinkId
	 *            the internal link id
	 * @param internalLinkIdAux
	 *            the internal link id aux
	 * @param externalLinkUrl
	 *            the external link url
	 * @param externalLinkName
	 *            the external link name
	 * @param externalLinkImg
	 *            the external link img
	 * @param imgLocation
	 *            the img location
	 * @return the new cell
	 */
	public TableResponseCellTo getNewCell(String cellId, String value,
			String date, String internalLinkName, ObjectToId internalLinkId,
			ObjectToId internalLinkIdAux, String externalLinkUrl,
			String externalLinkName, String externalLinkImg, String imgLocation) {
		TableResponseCellTo cell = new TableResponseCellTo();
		if (cellId != null) {
			cell.setId(new ObjectToId(cellId));
		}
		if (value != null || date != null) {
			cell.setValueTo(new ValueTo(date, value));
		}
		if (internalLinkName != null || internalLinkId != null
				|| internalLinkIdAux != null) {
			LinkTo link = new LinkTo();
			link.setName(internalLinkName);
			link.setObjectToId(internalLinkId);
			link.setObjectToIdAux(internalLinkIdAux);
			cell.setLinkTo(link);
		}
		if (externalLinkImg != null || externalLinkName != null
				|| externalLinkUrl != null) {
			cell.setExternalLinkTo(new ExternalLinkTo(EncryptUtil
					.encryptString(externalLinkUrl), externalLinkName,
					externalLinkImg));
		}
		if (imgLocation != null) {
			cell.add(new ResourceTo(imgLocation));
		}
		return cell;
	}

	/**
	 * Gets the random.
	 * 
	 * @param maxNumber
	 *            the max number
	 * @param maxDecimalNumbers
	 *            the max decimal numbers
	 * @return the random
	 */
	public String getRandom(int maxNumber, int maxDecimalNumbers) {
		StringBuffer result = new StringBuffer();
		result.append("" + (int) (Math.random() * maxNumber));
		if (maxDecimalNumbers > 0) {
			result.append("." + (int) (Math.random() * maxDecimalNumbers));
		}
		return result.toString();
	}

	/**
	 * Gets the random bookmaker img.
	 * 
	 * @param size
	 *            the size
	 * @param imgAppendix
	 *            the img appendix
	 * @return the random bookmaker img
	 */
	public String getRandomBookmakerImg(String size, String imgAppendix) {
		int num = (int) (Math.random() * 5);
		StringBuffer imgLocation = new StringBuffer();
		imgLocation.append("comparer/bookmaker/").append(size).append("/");
		switch (num) {
		case 0:
			imgLocation.append("bet365");
			break;
		case 1:
			imgLocation.append("boylesports");
			break;
		case 2:
			imgLocation.append("expekt");
			break;
		case 3:
			imgLocation.append("intertops");
			break;
		case 4:
			imgLocation.append("nordicbet");
			break;
		}
		imgLocation.append(imgAppendix).append(".jpg");
		return imgLocation.toString();
	}

	/**
	 * Gets the random bookmaker img medium.
	 * 
	 * @return the random bookmaker img medium
	 */
	public String getRandomBookmakerImgMedium() {
		return getRandomBookmakerImg("medium", "_105x20");
	}

	/**
	 * Gets the random bookmaker img small.
	 * 
	 * @return the random bookmaker img small
	 */
	public String getRandomBookmakerImgSmall() {
		return getRandomBookmakerImg("small", "_65x15");
	}

	/**
	 * Gets the random payout.
	 * 
	 * @return the random payout
	 */
	public String getRandomPayout() {
		StringBuffer result = new StringBuffer();
		result.append("" + (int) ((Math.random() * 9) + 90));
		result.append("%");
		return result.toString();
	}

	/**
	 * Gets the random url.
	 * 
	 * @return the random url
	 */
	public String getRandomUrl() {
		int num = (int) (Math.random() * 5);
		StringBuffer imgLocation = new StringBuffer();
		imgLocation.append("http://www.");
		switch (num) {
		case 0:
			imgLocation.append("bet365");
			break;
		case 1:
			imgLocation.append("comeon");
			break;
		case 2:
			imgLocation.append("ladebrokes");
			break;
		case 3:
			imgLocation.append("betfred");
			break;
		case 4:
			imgLocation.append("10bet");
			break;
		}
		imgLocation.append(".com");
		return imgLocation.toString();
	}

	/**
	 * Gets the row.
	 * 
	 * @param bookmakerId
	 *            the bookmaker id
	 * @param bookmakerImgLocation
	 *            the bookmaker img location
	 * @param bookmakerName
	 *            the bookmaker name
	 * @param bookmakerUrl
	 *            the bookmaker url
	 * @param odds
	 *            the odds
	 * @param urls
	 *            the urls
	 * @param pago
	 *            the pago
	 * @return the row
	 */
	protected TableResponseRowTo getRow(String bookmakerId,
			String bookmakerImgLocation, String bookmakerName,
			String bookmakerUrl, String[] odds, String[] urls, String pago) {
		TableResponseRowTo row = new TableResponseRowTo();
		row.setObjectToId((new ObjectToId(bookmakerId)));
		row.add(getNewCell(null, null, null, null, null, null, bookmakerUrl,
				bookmakerName, bookmakerImgLocation, null));
		for (int colNum = 0; colNum < odds.length; colNum++) {
			row.add(getNewCell(null, null, null, null, null, null,
					urls[colNum], odds[colNum], null, null));
		}
		row.add(getNewCell(null, pago, null, null, null, null, null, null,
				null, null));
		return row;
	}

	/**
	 * Gets the row.
	 * 
	 * @param valueStr
	 *            the value str
	 * @return the row
	 */
	protected TableResponseRowTo getRow(String[] valueStr) {
		TableResponseRowTo row = new TableResponseRowTo();
		for (int i = 0; i < valueStr.length; i++) {
			row.add(getNewCell(null, valueStr[i], null, null, null, null, null,
					null, null, null));
		}
		return row;
	}

	/**
	 * Gets the row.
	 * 
	 * @param participantIds
	 *            the participant ids
	 * @param valueStr
	 *            the value str
	 * @return the row
	 */
	protected TableResponseRowTo getRow(String[] participantIds,
			String[] valueStr) {
		TableResponseRowTo row = new TableResponseRowTo();
		for (int i = 0; i < participantIds.length; i++) {
			row.add(getNewCell(participantIds[i], valueStr[i], null, null,
					null, null, null, null, null, null));
		}
		return row;
	}

	/**
	 * Gets the row with bet value.
	 * 
	 * @param bookmakerId
	 *            the bookmaker id
	 * @param bookmakerImgLocation
	 *            the bookmaker img location
	 * @param bookmakerName
	 *            the bookmaker name
	 * @param bookmakerUrl
	 *            the bookmaker url
	 * @param odds
	 *            the odds
	 * @param urls
	 *            the urls
	 * @param pago
	 *            the pago
	 * @param value
	 *            the value
	 * @return the row with bet value
	 */
	protected TableResponseRowTo getRowWithBetValue(String bookmakerId,
			String bookmakerImgLocation, String bookmakerName,
			String bookmakerUrl, String[] odds, String[] urls, String pago,
			String value) {
		TableResponseRowTo row = new TableResponseRowTo();
		row.setObjectToId((new ObjectToId(bookmakerId)));
		row.add(getNewCell(null, null, null, null, null, null, bookmakerUrl,
				bookmakerName, bookmakerImgLocation, null));
		row.add(getNewCell(null, value, null, null, null, null, null, null,
				null, null));
		for (int colNum = 0; colNum < odds.length; colNum++) {
			row.add(getNewCell(null, null, null, null, null, null,
					urls[colNum], odds[colNum], null, null));
		}
		row.add(getNewCell(null, pago, null, null, null, null, null, null,
				null, null));
		return row;
	}

	/**
	 * Gets the tree node row.
	 * 
	 * @param imgLocation
	 *            the img location
	 * @param nodeId
	 *            the node id
	 * @param linkId
	 *            the link id
	 * @param linkIdAux
	 *            the link id aux
	 * @param name
	 *            the name
	 * @param numComp
	 *            the num comp
	 * @param numEvents
	 *            the num events
	 * @return the tree node row
	 */
	protected TableResponseRowTo getTreeNodeRow(String imgLocation,
			String nodeId, String linkId, String linkIdAux, String name,
			String numComp, String numEvents) {
		TableResponseRowTo row = new TableResponseRowTo();
		row.setObjectToId(new ObjectToId(nodeId));

		// Celda 0 - imagen bandera
		if (imgLocation != null) {
			row.add(getNewCell(null, null, null, null, null, null, null, null,
					null, null));
			row.getCellList().get(0).add(new ResourceTo(imgLocation));
		}

		// Celda 1 - Link
		if (name != null) {
			row.add(getNewCell(null, null, null, name, new ObjectToId(linkId),
					new ObjectToId(linkIdAux), null, null, null, null));
		}

		// Celda 2 - num competiciones
		if (numComp != null) {
			row.add(getNewCell(null, numComp, null, null, null, null, null,
					null, null, null));
		}

		// Celda 3 - num eventos
		if (numEvents != null) {
			row.add(getNewCell(null, numEvents, null, null, null, null, null,
					null, null, null));
		}

		return row;
	}

	/**
	 * Sets the cell link to.
	 * 
	 * @param cell
	 *            the cell
	 * @param name
	 *            the name
	 * @param id
	 *            the id
	 * @param idAux
	 *            the id aux
	 */
	public void setCellLinkTo(TableResponseCellTo cell, String name,
			ObjectToId id, ObjectToId idAux) {
		cell.setLinkTo(new LinkTo(name, id, idAux));
	}

	/**
	 * Sets the cell resources.
	 * 
	 * @param cell
	 *            the cell
	 * @param location
	 *            the location
	 */
	public void setCellResources(TableResponseCellTo cell, String location) {
		cell.add(new ResourceTo(location));
	}

	/**
	 * Sets the cell value to.
	 * 
	 * @param cell
	 *            the cell
	 * @param value
	 *            the value
	 * @param date
	 *            the date
	 */
	public void setCellValueTo(TableResponseCellTo cell, String value,
			String date) {
		cell.setValueTo(new ValueTo(date, value));
	}

	/**
	 * Sets the title row with id and col name.
	 * 
	 * @param values
	 *            the values
	 * @return the table response row title to
	 */
	public TableResponseRowTitleTo setTitleRowWithIdAndColName(String... values) {
		TableResponseRowTitleTo row = new TableResponseRowTitleTo();
		for (String value : values) {
			TableResponseCellTo field = new TableResponseCellTo(new ObjectToId(
					value.replaceAll("\\s", "")), new ValueTo(null, value));
			row.add(field);
		}
		return row;
	}

}
