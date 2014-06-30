/**
 *
 * Copyright (C) FACTORIA ETSIA S.L.
 * All Rights Reserved.
 * www.factoriaetsia.com
 *
 */
package com.comparadorad.bet.comparer.synchro.reader.readerbookmaker.core.readers.youwin;

import org.springframework.stereotype.Component;

import com.comparadorad.bet.comparer.model.config.bean.CfgBookmaker;

/**
 * The Class XMLBetClickFileReader.
 */
@Component
public class XMLYouWinFileReader extends AbstractYouWinUwinDecorator {

	/**
	 * Gets the bookmaker id.
	 * 
	 * @return the bookmaker id {@inheritDoc}
	 */
	@Override
	public String getBookmakerId() {
		return CfgBookmaker.CfgBookmakerId.YOUWIN_COM_ID.objectId().toString();
	}

}
