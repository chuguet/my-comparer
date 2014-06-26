/**
 *
 * Copyright (C) FACTORIA ETSIA S.L.
 * All Rights Reserved.
 * www.factoriaetsia.com
 *
 */
package com.comparadorad.bet.comparer.synchro.reader.url.maker.strategy;

import java.util.List;

import com.comparadorad.bet.comparer.model.config.bean.CfgBookmaker;
import com.comparadorad.bet.comparer.synchro.reader.url.core.StrategyType;
import com.comparadorad.bet.comparer.synchro.reader.url.maker.bean.BeanUrlMaker;
import com.comparadorad.bet.comparer.synchro.reader.url.maker.exception.TimeOutReaderURLException;
import com.comparadorad.bet.comparer.synchro.reader.url.maker.exception.URLOutConfigurationException;

/**
 * The Interface StrategyMakeUrl.
 */
public interface StrategyMakeUrl {

	/**
	 * Gets the urls.
	 * 
	 * @param bookmaker
	 *            the bookmaker
	 * @return the urls
	 */
	List<BeanUrlMaker> getUrls(CfgBookmaker bookmaker)
			throws TimeOutReaderURLException, URLOutConfigurationException;

	/**
	 * Gets the strategy type.
	 * 
	 * @return the strategy type
	 */
	StrategyType getStrategyType();

}
