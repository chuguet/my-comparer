/**
 *
 * Copyright (C) FACTORIA ETSIA S.L.
 * All Rights Reserved.
 * www.factoriaetsia.com
 *
 */
package com.comparadorad.bet.comparer.synchro.reader.readerbookmaker.core.readers.sportingbet;

import com.comparadorad.bet.comparer.model.config.bean.CfgBookmaker;

/**
 * The Class XMLSportingBetFileReader.
 */
public class XMLSportingBetFileReader extends
		AbstractSportingBetCentreBetMiApuestaDecorator {

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.comparadorad.bet.comparer.synchro.reader.readerbookmaker.core.readers
	 * .AbstractXmlFilereader#getBookmakerId()
	 */
	@Override
	public String getBookmakerId() {
		return CfgBookmaker.CfgBookmakerId.SPORTINGBET_ID.objectId().toString();
	}

}
