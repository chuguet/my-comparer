/**
 *
 * Copyright (C) FACTORIA ETSIA S.L.
 * All Rights Reserved.
 * www.factoriaetsia.com
 *
 */
package com.comparadorad.bet.comparer.web.server.mvc.imageslider.factory;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.comparadorad.bet.comparer.model.config.bean.CfgBetType;
import com.comparadorad.bet.comparer.web.server.mvc.imageslider.table.IMakeTableImageSlider;

/**
 * A factory for creating TableResponse objects.
 */
@Service
public class TableResponseFactory extends AbstractObjectResponseFactory {

	/** The make tables image slider. */
	@Inject
	private List<IMakeTableImageSlider> makeTablesImageSlider;

	/** {@inheritDoc} */
	@Override
	public IMakeTableImageSlider makeTableImageSlider(CfgBetType cfgBetType) {
		IMakeTableImageSlider table = null;
		for (IMakeTableImageSlider makeTable : makeTablesImageSlider) {
			if (makeTable.getBetTypeId().nameId()
					.equals(cfgBetType.getNameId())) {
				table = makeTable;
				break;
			}
		}
		return table;
	}

}
