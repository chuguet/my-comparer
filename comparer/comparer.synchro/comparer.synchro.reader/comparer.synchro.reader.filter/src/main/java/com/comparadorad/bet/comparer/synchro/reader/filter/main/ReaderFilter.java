/**
 *
 * Copyright (C) FACTORIA ETSIA S.L.
 * All Rights Reserved.
 * www.factoriaetsia.com
 *
 */
package com.comparadorad.bet.comparer.synchro.reader.filter.main;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.comparadorad.bet.comparer.model.config.bean.CfgBookmaker;
import com.comparadorad.bet.comparer.synchro.reader.filter.bean.FilterConfigurationBean;
import com.comparadorad.bet.comparer.synchro.reader.filter.exception.FilterException;
import com.comparadorad.bet.comparer.synchro.reader.filter.plugin.PluginFilter;
import com.comparadorad.bet.comparer.synchro.reader.model.XmlMatch;

/**
 * The Class ReaderFilter.
 */
@Service
class ReaderFilter implements IReaderFilter {

	/** The filters. */
	@Inject
	private List<PluginFilter> filters;

	@Override
	public Boolean isNew(XmlMatch xmlMatch, CfgBookmaker cfgBookmaker,
			FilterConfigurationBean configurationBean) throws FilterException {
		Boolean result = Boolean.FALSE;
		for (PluginFilter filter : filters) {
			if( !filter.deleteElement(xmlMatch, cfgBookmaker,configurationBean) ){
				result = Boolean.TRUE;
				break;
			}
		}
		return result;
	}
}
