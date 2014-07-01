/**
 *
 * Copyright (C) FACTORIA ETSIA S.L.
 * All Rights Reserved.
 * www.factoriaetsia.com
 *
 */
package com.comparadorad.bet.comparer.web.client.gwt.results.ui.comp.dummy;

import java.util.ArrayList;
import java.util.List;

import com.comparadorad.bet.comparer.web.client.gwt.common.bean.HeadResponseTo;
import com.comparadorad.bet.comparer.web.client.gwt.common.bean.LinkTo;
import com.comparadorad.bet.comparer.web.client.gwt.common.bean.ObjectToId;
import com.comparadorad.bet.comparer.web.client.gwt.common.bean.cfg.response.ResourceTo;

/**
 * The Class CompHeadDummy.
 */
public class CompHeadDummy {

	/**
	 * Gets the head data.
	 * 
	 * @param competitionId
	 *            the competition id
	 * @return the head data
	 */
	public HeadResponseTo getHeadData(String competitionId) {
		HeadResponseTo headResponseTo = new HeadResponseTo();

		if (competitionId.equalsIgnoreCase("ligaBBVA")) {
			headResponseTo.setTitle("Liga BBVA");

			// headResponseTo.setCoreDateTo("23/07/2013 17:45");

			List<LinkTo> links = new ArrayList<LinkTo>();
			LinkTo link = new LinkTo();
			link.setName("Fútbol");
			link.setObjectToId(new ObjectToId("fútbol"));
			links.add(link);

			LinkTo link2 = new LinkTo();
			link2.setName("España");
			link2.setObjectToId(new ObjectToId("españa"));
			link2.setObjectToIdAux(new ObjectToId("fútbol"));
			links.add(link2);

			LinkTo link3 = new LinkTo();
			link3.setName("Liga BBVA");
			links.add(link3);

			headResponseTo.setLinkTos(links);
			headResponseTo.setLinkTos(links);
			headResponseTo.setResourceTo(new ResourceTo(
					"comparer/country/small/es.png"));
		}
		return headResponseTo;
	}

}
