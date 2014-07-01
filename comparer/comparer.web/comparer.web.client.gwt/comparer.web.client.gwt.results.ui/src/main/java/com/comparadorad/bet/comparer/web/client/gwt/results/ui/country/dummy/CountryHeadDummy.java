/**
 *
 * Copyright (C) FACTORIA ETSIA S.L.
 * All Rights Reserved.
 * www.factoriaetsia.com
 *
 */
package com.comparadorad.bet.comparer.web.client.gwt.results.ui.country.dummy;

import java.util.ArrayList;
import java.util.List;

import com.comparadorad.bet.comparer.web.client.gwt.common.bean.HeadResponseTo;
import com.comparadorad.bet.comparer.web.client.gwt.common.bean.LinkTo;
import com.comparadorad.bet.comparer.web.client.gwt.common.bean.ObjectToId;
import com.comparadorad.bet.comparer.web.client.gwt.common.bean.cfg.response.ResourceTo;

/**
 * The Class CountryHeadDummy.
 */
public class CountryHeadDummy {

	/**
	 * Gets the head data.
	 * 
	 * @param sportId
	 *            the sport id
	 * @param countryId
	 *            the country id
	 * @return the head data
	 */
	public HeadResponseTo getHeadData(String sportId, String countryId) {
		HeadResponseTo headResponseTo = new HeadResponseTo();

		if (sportId.equalsIgnoreCase("futbol")
				&& countryId.equalsIgnoreCase("espana")) {
			headResponseTo.setTitle("España");

			headResponseTo.setDate("23/07/2013 17:45");

			List<LinkTo> links = new ArrayList<LinkTo>();
			LinkTo link = new LinkTo();
			link.setName("Fútbol");
			link.setObjectToId(new ObjectToId("fútbol"));
			links.add(link);

			LinkTo link2 = new LinkTo();
			link2.setName("España");
			links.add(link2);

			headResponseTo.setLinkTos(links);

			headResponseTo.setResourceTo(new ResourceTo(
					"comparer/country/small/es.png"));
		}
		return headResponseTo;
	}

}
