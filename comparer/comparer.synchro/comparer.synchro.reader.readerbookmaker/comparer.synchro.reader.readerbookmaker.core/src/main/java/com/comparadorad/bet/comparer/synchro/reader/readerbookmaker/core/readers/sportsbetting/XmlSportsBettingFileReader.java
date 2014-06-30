/**
 *
 * Copyright (C) FACTORIA ETSIA S.L.
 * All Rights Reserved.
 * www.factoriaetsia.com
 *
 */
package com.comparadorad.bet.comparer.synchro.reader.readerbookmaker.core.readers.sportsbetting;

import org.springframework.stereotype.Component;

import com.comparadorad.bet.comparer.model.config.bean.CfgBookmaker;
import com.comparadorad.bet.comparer.synchro.reader.readerbookmaker.core.readers.betonline.AbstractBetonlineDecorator;

/**
 * The Class XmlSportsBettingFileReader.
 */
@Component
public class XmlSportsBettingFileReader extends AbstractBetonlineDecorator {

	/**
	 * Gets the bookmaker id.
	 * 
	 * @return the bookmaker id {@inheritDoc}
	 */
	@Override
	public String getBookmakerId() {
		return CfgBookmaker.CfgBookmakerId.SPORTSBETTING_COM_ID.objectId()
				.toString();
	}

}
