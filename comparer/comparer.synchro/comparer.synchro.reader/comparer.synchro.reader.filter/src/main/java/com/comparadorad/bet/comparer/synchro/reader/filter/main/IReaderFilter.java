/**
 *
 * Copyright (C) FACTORIA ETSIA S.L.
 * All Rights Reserved.
 * www.factoriaetsia.com
 *
 */
package com.comparadorad.bet.comparer.synchro.reader.filter.main;

import com.comparadorad.bet.comparer.model.config.bean.CfgBookmaker;
import com.comparadorad.bet.comparer.synchro.reader.filter.bean.FilterConfigurationBean;
import com.comparadorad.bet.comparer.synchro.reader.filter.exception.FilterException;
import com.comparadorad.bet.comparer.synchro.reader.model.XmlMatch;

/**
 * The Interface IReaderFilter.
 */
public interface IReaderFilter {
	
	/**
	 * Checks if is new.
	 *
	 * @param xmlMatch the xml match
	 * @param cfgBookmaker the cfg bookmaker
	 * @return the boolean
	 * @throws FilterException the filter exception
	 */
	Boolean isNew(XmlMatch xmlMatch, CfgBookmaker cfgBookmaker, FilterConfigurationBean configurationBean ) throws FilterException;
	
	

}
