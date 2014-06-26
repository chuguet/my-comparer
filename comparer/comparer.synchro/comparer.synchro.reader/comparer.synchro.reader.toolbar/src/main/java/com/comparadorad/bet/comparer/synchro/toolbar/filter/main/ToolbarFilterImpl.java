/**
 *
 * Copyright (C) FACTORIA ETSIA S.L.
 * All Rights Reserved.
 * www.factoriaetsia.com
 *
 */
package com.comparadorad.bet.comparer.synchro.toolbar.filter.main;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.comparadorad.bet.comparer.model.bet.bean.RtMatch;
import com.comparadorad.bet.comparer.synchro.toolbar.filter.bean.ToolbarConfigurationBean;
import com.comparadorad.bet.comparer.synchro.toolbar.filter.exception.ToolbarException;
import com.comparadorad.bet.comparer.synchro.toolbar.filter.plugin.PluginToolbarFilter;

/**
 * The Class ToolbarFilterImpl.
 */
@Service
public class ToolbarFilterImpl implements ToolbarFilter {

	/** The plugin toolbar filters. */
	@Inject
	private List<PluginToolbarFilter> pluginToolbarFilters;

	/** {@inheritDoc} */ 
	@Override
	public Boolean isNew(final RtMatch rtMatch,
			final ToolbarConfigurationBean configurationBean)
			throws ToolbarException {
		Boolean result = Boolean.FALSE;
		for (PluginToolbarFilter filter : pluginToolbarFilters) {
			if (!filter.deleteElement(rtMatch, configurationBean)) {
				result = Boolean.TRUE;
				break;
			}
		}
		return result;
	}

}
