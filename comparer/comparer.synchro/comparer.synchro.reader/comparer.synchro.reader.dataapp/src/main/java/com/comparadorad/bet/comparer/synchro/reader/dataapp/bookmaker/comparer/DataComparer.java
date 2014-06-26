/**
 *
 * Copyright (C) FACTORIA ETSIA S.L.
 * All Rights Reserved.
 * www.factoriaetsia.com
 *
 */
package com.comparadorad.bet.comparer.synchro.reader.dataapp.bookmaker.comparer;

import com.comparadorad.bet.comparer.model.config.bean.CfgMaster;
import com.comparadorad.bet.comparer.model.config.bean.ICfgSynonyms;
import com.comparadorad.bet.comparer.synchro.reader.dataapp.bookmaker.creator.bean.StrikeAMatchData;

/**
 * The Interface DataComparer.
 * 
 * @param <I>
 *            the generic type
 */
public interface DataComparer<I extends ICfgSynonyms> {

	/**
	 * Compare strings.
	 * 
	 * @param cfgMaster
	 *            the cfg master
	 * @return the strike a match data
	 */
	void compareStrings(CfgMaster cfgMaster, StrikeAMatchData<I> data);

}
