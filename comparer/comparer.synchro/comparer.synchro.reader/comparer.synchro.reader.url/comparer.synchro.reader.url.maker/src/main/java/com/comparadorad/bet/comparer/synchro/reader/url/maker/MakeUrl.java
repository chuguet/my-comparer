/**
 *
 * Copyright (C) FACTORIA ETSIA S.L.
 * All Rights Reserved.
 * www.factoriaetsia.com
 *
 */
package com.comparadorad.bet.comparer.synchro.reader.url.maker;

import java.util.List;

import com.comparadorad.bet.comparer.model.config.bean.CfgBookmaker;
import com.comparadorad.bet.comparer.synchro.reader.url.maker.bean.BeanUrlMaker;
import com.comparadorad.bet.comparer.synchro.reader.url.maker.exception.CoreUrlMakerException;
import com.comparadorad.bet.comparer.synchro.reader.url.maker.exception.TimeOutReaderURLException;

/**
 * The Interface MakeUrl.
 */
public interface MakeUrl {
	
	/**
	 * Gets the url.
	 *
	 * @param bookmaker the bookmaker
	 * @param factoryBean the factory bean
	 * @return the url
	 * @throws CoreUrlMakerException 
	 * @throws TimeOutReaderURLException 
	 */
	List<BeanUrlMaker> getUrl(CfgBookmaker bookmaker)
			throws CoreUrlMakerException, TimeOutReaderURLException;

}
