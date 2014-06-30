/**
 *
 * Copyright (C) FACTORIA ETSIA S.L.
 * All Rights Reserved.
 * www.factoriaetsia.com
 *
 */
package com.comparadorad.bet.comparer.synchro.reader.readerbookmaker.core.readers.expekt;

import org.springframework.stereotype.Component;

import com.comparadorad.bet.comparer.model.config.bean.CfgBookmaker;
import com.comparadorad.bet.comparer.synchro.reader.readerbookmaker.core.readers.betclick.AbstractBetClickDecorator;

/**
 * The Class XMLBetClickFileReader.
 */
@Component
public class XMLExpektFileReader extends AbstractBetClickDecorator {

	/**
	 * Gets the bookmaker id.
	 * 
	 * @return the bookmaker id {@inheritDoc}
	 */
	@Override
	public String getBookmakerId() {
		return CfgBookmaker.CfgBookmakerId.EXPEKT_COM_ID.objectId().toString();
	}
	
}
