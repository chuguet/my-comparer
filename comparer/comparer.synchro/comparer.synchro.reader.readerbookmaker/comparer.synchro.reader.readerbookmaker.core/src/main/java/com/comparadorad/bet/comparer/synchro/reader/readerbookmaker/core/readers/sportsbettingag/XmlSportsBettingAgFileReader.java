/**
 *
 * Copyright (C) FACTORIA ETSIA S.L.
 * All Rights Reserved.
 * www.factoriaetsia.com
 *
 */
package com.comparadorad.bet.comparer.synchro.reader.readerbookmaker.core.readers.sportsbettingag;

import org.springframework.stereotype.Component;

import com.comparadorad.bet.comparer.model.config.bean.CfgBookmaker;
import com.comparadorad.bet.comparer.synchro.reader.readerbookmaker.core.readers.betonline.AbstractBetonlineDecorator;

/**
 * The Class XmlSportsBettingAgFileReader.
 */
@Component
public class XmlSportsBettingAgFileReader extends AbstractBetonlineDecorator {

	/**
	 * Gets the bookmaker id.
	 * 
	 * @return the bookmaker id {@inheritDoc}
	 */
	@Override
	public String getBookmakerId() {
		return CfgBookmaker.CfgBookmakerId.SPORTSBETTING_AG_ID.objectId()
				.toString();
	}

}
