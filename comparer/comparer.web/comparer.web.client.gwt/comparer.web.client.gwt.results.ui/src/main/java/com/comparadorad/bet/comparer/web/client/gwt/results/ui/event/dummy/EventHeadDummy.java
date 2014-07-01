/**
 *
 * Copyright (C) FACTORIA ETSIA S.L.
 * All Rights Reserved.
 * www.factoriaetsia.com
 *
 */
package com.comparadorad.bet.comparer.web.client.gwt.results.ui.event.dummy;

import java.util.ArrayList;
import java.util.List;

import com.comparadorad.bet.comparer.web.client.gwt.common.bean.HeadResponseTo;
import com.comparadorad.bet.comparer.web.client.gwt.common.bean.LinkTo;
import com.comparadorad.bet.comparer.web.client.gwt.common.bean.ObjectToId;
import com.comparadorad.bet.comparer.web.client.gwt.common.bean.cfg.response.ResourceTo;

/**
 * The Class EventHeadDummy.
 */
public class EventHeadDummy {

	/**
	 * Gets the head data.
	 * 
	 * @param eventId
	 *            the event id
	 * @return the head data
	 */
	public HeadResponseTo getHeadData(String eventId) {
		HeadResponseTo headResponseTo = new HeadResponseTo();

		if (eventId.equalsIgnoreCase("RealMadridVsBarcelona")) {
			headResponseTo.setTitle("Real Madrid Vs Barcelona");

			headResponseTo.setDate("23/07/2013 17:45");

			List<LinkTo> links = new ArrayList<LinkTo>();
			LinkTo link = new LinkTo();
			link.setName("Fútbol");
			link.setObjectToId(new ObjectToId("fútbol"));
			links.add(link);

			LinkTo link2 = new LinkTo();
			link2.setName("España");
			link2.setObjectToId(new ObjectToId("españa"));
			links.add(link2);

			LinkTo link3 = new LinkTo();
			link3.setName("Liga BBVA");
			link2.setObjectToId(new ObjectToId("LigaBBVA"));
			links.add(link3);

			LinkTo link4 = new LinkTo();
			link4.setName("Real Madrid Vs Barcelona");
			links.add(link4);

			headResponseTo.setLinkTos(links);
			headResponseTo.setResourceTo(new ResourceTo(
					"comparer/country/small/es.png"));
		} else if (eventId.equalsIgnoreCase("100mLisos")) {
			headResponseTo.setTitle("100 m lisos");

			headResponseTo.setDate("23/07/2013 17:45");

			List<LinkTo> links = new ArrayList<LinkTo>();
			LinkTo link = new LinkTo();
			link.setName("Atletismo");
			link.setObjectToId(new ObjectToId("atletismo"));
			links.add(link);

			LinkTo link2 = new LinkTo();
			link2.setName("España");
			link2.setObjectToId(new ObjectToId("españa"));
			links.add(link2);

			LinkTo link3 = new LinkTo();
			link3.setName("Juegos Olímpicos");
			link2.setObjectToId(new ObjectToId("juegosOlimpicos"));
			links.add(link3);

			LinkTo link4 = new LinkTo();
			link4.setName("100mLisos");
			links.add(link4);

			headResponseTo.setLinkTos(links);
			headResponseTo.setResourceTo(new ResourceTo(
					"comparer/country/small/es.png"));
		}
		return headResponseTo;
	}

}
