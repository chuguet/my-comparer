/**
 *
 * Copyright (C) FACTORIA ETSIA S.L.
 * All Rights Reserved.
 * www.factoriaetsia.com
 *
 */
package com.comparadorad.bet.comparer.synchro.reader.readerbookmaker.core.readers.triobet;

import org.springframework.stereotype.Component;

import com.comparadorad.bet.comparer.model.config.bean.CfgBookmaker;
import com.comparadorad.bet.comparer.synchro.reader.readerbookmaker.core.readers.nordicbet.AbstractXMLFileReaderDecorator;

/**
 * The Class XMLTrioBetFileReader.
 */
@Component
public class XMLTrioBetFileReader extends AbstractXMLFileReaderDecorator {

	/** {@inheritDoc} */
	@Override
	public String getBookmakerId() {
		return CfgBookmaker.CfgBookmakerId.TRIOBET_COM_ID.objectId().toString();
	}

}
