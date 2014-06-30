/**
 *
 * Copyright (C) FACTORIA ETSIA S.L.
 * All Rights Reserved.
 * www.factoriaetsia.com
 *
 */
package com.comparadorad.bet.comparer.synchro.reader.readerbookmaker.core.readers.bookmaker;

import org.springframework.stereotype.Component;

import com.comparadorad.bet.comparer.model.config.bean.CfgBookmaker;

/**
 * The Class XMLBookmakerFileReader.
 */
@Component
public class XMLBookmakerFileReader extends AbstractBookmakerDecorator {

	/** {@inheritDoc} */
	@Override
	public String getBookmakerId() {
		return CfgBookmaker.CfgBookmakerId.BOOKMAKER_EU_ID.objectId().toString();
	}
}
