/**
 *
 * Copyright (C) FACTORIA ETSIA S.L.
 * All Rights Reserved.
 * www.factoriaetsia.com
 *
 */
package com.comparadorad.bet.comparer.synchro.reader.dataapp.bookmaker.creator;

import com.comparadorad.bet.comparer.model.config.bean.CfgBookmaker;
import com.comparadorad.bet.comparer.model.config.bean.ICfgSynonyms;
import com.comparadorad.bet.comparer.model.core.bean.AbstractI18nTableActivable;
import com.comparadorad.bet.comparer.model.log.bean.LogEventBookmakerMasterWords;
import com.comparadorad.bet.comparer.synchro.reader.dataapp.bookmaker.exception.CfgFromXmlCreatorException;
import com.comparadorad.bet.comparer.synchro.reader.model.AbstractXmlData;

/**
 * The Interface ICfgFromXmlCreator.
 * 
 * @param <T>
 *            the generic type
 * @param <I>
 *            the generic type
 * @param <S>
 *            the generic type
 */
public interface ICfgFromXmlCreator<T extends AbstractXmlData, I extends AbstractI18nTableActivable, S extends ICfgSynonyms> {

	/**
	 * Creates the.
	 * 
	 * @param xmlTournament
	 *            the xml tournament
	 * @return the cfg creator data
	 */
	CfgCreatorData<I, S> create(T xmlTournament, CfgBookmaker dataBookmaker, LogEventBookmakerMasterWords logEventBookmaker)
			throws CfgFromXmlCreatorException;

}
