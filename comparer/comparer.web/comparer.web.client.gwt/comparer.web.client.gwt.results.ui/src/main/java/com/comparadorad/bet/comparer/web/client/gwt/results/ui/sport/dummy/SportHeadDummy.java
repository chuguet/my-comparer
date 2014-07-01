/**
 *
 * Copyright (C) FACTORIA ETSIA S.L.
 * All Rights Reserved.
 * www.factoriaetsia.com
 *
 */
package com.comparadorad.bet.comparer.web.client.gwt.results.ui.sport.dummy;

import java.util.ArrayList;
import java.util.List;

import com.comparadorad.bet.comparer.web.client.gwt.common.bean.HeadResponseTo;
import com.comparadorad.bet.comparer.web.client.gwt.common.bean.LinkTo;
import com.comparadorad.bet.comparer.web.client.gwt.common.bean.cfg.response.ResourceTo;

public class SportHeadDummy {

	public HeadResponseTo getHeadData(String sportId) {
		HeadResponseTo headResponseTo = new HeadResponseTo();

		if (sportId.equalsIgnoreCase("futbol")) {
			headResponseTo.setTitle("F�tbol");

			List<LinkTo> links = new ArrayList<LinkTo>();
			LinkTo link = new LinkTo();
			link.setName("F�tbol");
			links.add(link);

			headResponseTo.setLinkTos(links);

			headResponseTo.setResourceTo(new ResourceTo(
					"comparer/sport/futbol.png"));
		}
		return headResponseTo;
	}

}
