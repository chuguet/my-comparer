/**
 *
 * Copyright (C) FACTORIA ETSIA S.L.
 * All Rights Reserved.
 * www.factoriaetsia.com
 *
 */
package com.comparadorad.bet.comparer.web.client.gwt.imageslider.ui.dummy;

import java.util.ArrayList;
import java.util.List;

import org.fusesource.restygwt.client.MethodCallback;

import com.allen_sauer.gwt.log.client.Log;
import com.comparadorad.bet.comparer.web.client.gwt.common.bean.ExternalLinkTo;
import com.comparadorad.bet.comparer.web.client.gwt.common.bean.LinkTo;
import com.comparadorad.bet.comparer.web.client.gwt.common.bean.ObjectToId;
import com.comparadorad.bet.comparer.web.client.gwt.common.bean.ValueTo;
import com.comparadorad.bet.comparer.web.client.gwt.common.bean.cfg.response.ResourceTo;
import com.comparadorad.bet.comparer.web.client.gwt.common.bean.table.TableResponseCellTo;
import com.comparadorad.bet.comparer.web.client.gwt.common.bean.table.TableResponseRowTo;
import com.comparadorad.bet.comparer.web.client.gwt.common.bean.table.TableResponseTo;
import com.comparadorad.bet.comparer.web.client.gwt.common.ui.dummy.GenericDummy;
import com.comparadorad.bet.comparer.web.client.gwt.imageslider.bean.request.ImageSliderRequestTo;
import com.comparadorad.bet.comparer.web.client.gwt.imageslider.bean.response.ImageSliderResponseTo;
import com.comparadorad.bet.comparer.web.client.gwt.imageslider.bean.response.ImageSliderUpdateResponseTo;
import com.comparadorad.bet.comparer.web.client.gwt.imageslider.ui.service.IImageSliderService;

/**
 * The Class ImageSliderDummyService.
 */
public class ImageSliderDummyService extends GenericDummy implements
		IImageSliderService {

	/**
	 * Gets the event data.
	 * 
	 * @param request
	 *            the request
	 * @param pCallback
	 *            the callback
	 * @return the event data {@inheritDoc}
	 */
	public void getEventData(ImageSliderRequestTo request,
			MethodCallback<List<ImageSliderResponseTo>> pCallback) {
		List<ImageSliderResponseTo> responseList = new ArrayList<ImageSliderResponseTo>();

		if (request.getEventId() == null) {

			responseList.add(getImageSliderResponse("event1",
					"comparer/events/event.jpg", "HomeAway1", "bettype1",
					"ATP Bastas 2011", "comp1", "Rafael Nadal vs Andy Murray",
					"01/01/2011 11:11", new String[] { "Rafael Nadal",
							"Andy Murray" }, new String[] { "1.25", "1.11" },
					new String[] { "bet365", "bet24" }, new String[] {
							"http://www.google.es", "http://www.google.es" }));

			responseList.add(getImageSliderResponse("event2",
					"comparer/events/event2.jpg", "HomeAway2", "bettype2",
					"ATP Bastas 2022", "comp2", "Anders Dalqvist vs Xian Zehn",
					"22/02/2022 22:22", new String[] { "Anders Dalqvist",
							"Xian Zehn" }, new String[] { "1.25", "1.11" },
					new String[] { "boylesports", "bet24" }, new String[] {
							"http://www.google.es", "http://www.google.es" }));

			responseList.add(getImageSliderResponse("event3",
					"comparer/events/event4.jpg", "Ganador", "bettype3",
					"Ganador NBA", "comp3", "NBA", "13/03/2033 33:33",
					new String[] { "Golden State Warriors", "Milwaukee Bucks",
							"Memphis Grizzlies" }, new String[] { "3.25",
							"3.31", "3.333" }, new String[] { "bet365",
							"bet24", "pinnaclesports" }, new String[] {
							"http://www.google.es", "http://www.google.es",
							"http://www.google.es" }));
		}
		pCallback.onSuccess(null, responseList);
	}

	/**
	 * Gets the event data update.
	 * 
	 * @param request
	 *            the request
	 * @param pCallback
	 *            the callback
	 * @return the event data update {@inheritDoc}
	 */
	public void getEventDataUpdate(ImageSliderRequestTo request,
			MethodCallback<ImageSliderUpdateResponseTo> pCallback) {
		ImageSliderUpdateResponseTo response = new ImageSliderUpdateResponseTo();
		if (request.getEventId() != null) {
			String eventId = request.getEventId().getId();
			if (eventId.equalsIgnoreCase("event1")) {
				response.setTable(getImageSliderResponseUpdate(new String[] {
						"Rafael Nadal", "Andy Murray" }, new String[] {
						getRandom(10, 99), getRandom(10, 99) }, new String[] {
						"bet365", "expekt" }, new String[] {
						"http://www.google.es", "http://www.google.es" }));
			} else if (eventId.equalsIgnoreCase("event2")) {
				response.setTable(getImageSliderResponseUpdate(new String[] {
						"Anders Dalqvist", "Xian Zehn" }, new String[] {
						getRandom(10, 99), getRandom(10, 99) }, new String[] {
						"betdaq", "pinnaclesports" }, new String[] {
						"http://www.google.es", "http://www.google.es" }));
			} else if (eventId.equalsIgnoreCase("event3")) {
				response.setTable(getImageSliderResponseUpdate(new String[] {
						"Golden State Warriors", "Indiana Pacers",
						"Milwaukee Bucks" }, new String[] { getRandom(10, 99),
						getRandom(10, 99) }, new String[] { "betdaq",
						"pinnaclesports", "bet365" }, new String[] {
						"http://www.google.es", "http://www.google.es",
						"http://www.google.es" }));
			}
		} else {
			Log.warn("There is no event id in the request.");
		}
		pCallback.onSuccess(null, response);
	}

	/**
	 * Gets the image slider response.
	 * 
	 * @param eventId
	 *            the event id
	 * @param eventImgLocation
	 *            the event img location
	 * @param betType
	 *            the bet type
	 * @param betTypeId
	 *            the bet type id
	 * @param compLinkText
	 *            the comp link text
	 * @param compId
	 *            the comp id
	 * @param eventLinkText
	 *            the event link text
	 * @param date
	 *            the date
	 * @param participants
	 *            the participants
	 * @param odds
	 *            the odds
	 * @param bookmakerName
	 *            the bookmaker name
	 * @param bookmakerUrl
	 *            the bookmaker url
	 * @return the image slider response
	 */
	private ImageSliderResponseTo getImageSliderResponse(String eventId,
			String eventImgLocation, String betType, String betTypeId,
			String compLinkText, String compId, String eventLinkText,
			String date, String[] participants, String[] odds,
			String[] bookmakerName, String[] bookmakerUrl) {
		ImageSliderResponseTo response = new ImageSliderResponseTo();
		response.setEventId(new ObjectToId(eventId));
		response.setResource(new ResourceTo(eventImgLocation));
		response.setBetType(betType);
		response.setCompetitionLink(new LinkTo(compLinkText, new ObjectToId(
				compId), new ObjectToId(betTypeId)));
		response.setEventLink(new LinkTo(eventLinkText,
				new ObjectToId(eventId), new ObjectToId(betTypeId)));
		response.setBetTypeId(new ObjectToId(betTypeId));
		response.setEventDate(date);
		TableResponseTo tableResponseTo = new TableResponseTo();
		for (int i = 0; i < participants.length; i++) {
			TableResponseRowTo row = setRow(participants[i], odds[i],
					getBookmakerImgSmall(bookmakerName[i]), bookmakerUrl[i]);
			tableResponseTo.add(row);
		}
		response.setTable(tableResponseTo);
		return response;
	}

	/**
	 * Gets the image slider response update.
	 * 
	 * @param participants
	 *            the participants
	 * @param odds
	 *            the odds
	 * @param bookmakerName
	 *            the bookmaker name
	 * @param bookmakerUrl
	 *            the bookmaker url
	 * @return the image slider response update
	 */
	private TableResponseTo getImageSliderResponseUpdate(String[] participants,
			String[] odds, String[] bookmakerName, String[] bookmakerUrl) {
		TableResponseTo tableResponseTo = new TableResponseTo();
		for (int i = 0; i < participants.length; i++) {
			TableResponseRowTo row = setRow(participants[i], odds[i],
					getBookmakerImgSmall(bookmakerName[i]), bookmakerUrl[i]);
			tableResponseTo.add(row);
		}
		return tableResponseTo;
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
	 * Sets the row.
	 * 
	 * @param partName
	 *            the part name
	 * @param odd
	 *            the odd
	 * @param extLinkImg
	 *            the ext link img
	 * @param url
	 *            the url
	 * @return the table response row to
	 */
	private TableResponseRowTo setRow(String partName, String odd,
			String extLinkImg, String url) {
		TableResponseRowTo row = new TableResponseRowTo();

		TableResponseCellTo cell = new TableResponseCellTo();
		cell.setValueTo(new ValueTo(null, partName));
		row.add(cell);

		cell = new TableResponseCellTo();
		cell.setValueTo(new ValueTo(null, odd));
		row.add(cell);

		cell = new TableResponseCellTo();
		ExternalLinkTo link = new ExternalLinkTo();
		link.setLinkImgLocation(extLinkImg);
		link.setUrl(url);
		cell.setExternalLinkTo(link);
		row.add(cell);

		return row;
	}

}
