/**
 *
 * Copyright (C) FACTORIA ETSIA S.L.
 * All Rights Reserved.
 * www.factoriaetsia.com
 *
 */
package com.comparadorad.bet.comparer.web.server.mvc.match.factory;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Component;

import com.comparadorad.bet.comparer.web.server.mvc.match.enums.BetTypesView;
import com.comparadorad.bet.comparer.web.server.mvc.match.tabs.IMakeTabs;

/**
 * A factory for creating Tabs objects.
 */
@Component
public class TabsFactory extends AbstractFactoryTabs {

	/** The make tabs. */
	@Inject
	private List<IMakeTabs> makeTabs;

	/** {@inheritDoc} */
	@Override
	public IMakeTabs getMakeTabs(BetTypesView betTypesView) {
		IMakeTabs result = null;
		for (IMakeTabs makeTab : makeTabs) {
			if (makeTab.getBetTypesView().equals(betTypesView)) {
				result = makeTab;
				break;
			}
		}
		return result;
	}

}
