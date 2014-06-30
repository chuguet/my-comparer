/**
 *
 * Copyright (C) FACTORIA ETSIA S.L.
 * All Rights Reserved.
 * www.factoriaetsia.com
 *
 */
package com.comparadorad.bet.comparer.synchro.reader.readerbookmaker.core.readers.centrebet;

import com.comparadorad.bet.comparer.model.config.bean.CfgBookmaker;
import com.comparadorad.bet.comparer.synchro.reader.readerbookmaker.core.readers.sportingbet.AbstractSportingBetCentreBetMiApuestaDecorator;

/**
 * The Class XMLCentreBetFileReader.
 */
public class XMLCentreBetFileReader extends
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
		return CfgBookmaker.CfgBookmakerId.CENTREBET_COM_ID.objectId()
				.toString();
	}

}
