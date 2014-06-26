/**
 *
 * Copyright (C) FACTORIA ETSIA S.L.
 * All Rights Reserved.
 * www.factoriaetsia.com
 *
 */
package com.comparadorad.bet.comparer.synchro.reader.filter.plugin;

import com.comparadorad.bet.comparer.model.config.bean.CfgBookmaker;
import com.comparadorad.bet.comparer.synchro.reader.filter.bean.FilterConfigurationBean;
import com.comparadorad.bet.comparer.synchro.reader.filter.exception.FilterException;
import com.comparadorad.bet.comparer.synchro.reader.model.XmlMatch;

/**
 * The Interface PluginFilter.
 */
public interface PluginFilter {

	/**
	 * Delete element.
	 * 
	 * @param match
	 *            the match
	 * @param bookmaker
	 *            the bookmaker
	 * @param configurationBean
	 *            the configuration bean
	 * @return the boolean
	 * @throws FilterException
	 *             the filter exception
	 */
	Boolean deleteElement(XmlMatch match, CfgBookmaker bookmaker,
			FilterConfigurationBean configurationBean) throws FilterException;

}
