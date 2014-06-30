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
 * The Class XMLBetdsiFileReader.
 */
@Component
public class XMLBetdsiFileReader extends AbstractBookmakerDecorator {

	/** {@inheritDoc} */
	@Override
	public String getBookmakerId() {
		return CfgBookmaker.CfgBookmakerId.BETDSI_COM_ID.objectId().toString();
	}

}
