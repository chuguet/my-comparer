/**
 *
 * Copyright (C) FACTORIA ETSIA S.L.
 * All Rights Reserved.
 * www.factoriaetsia.com
 *
 */
package com.comparadorad.bet.comparer.synchro.toolbar.filter.plugin;

import com.comparadorad.bet.comparer.model.bet.bean.RtMatch;
import com.comparadorad.bet.comparer.synchro.toolbar.filter.bean.ToolbarConfigurationBean;
import com.comparadorad.bet.comparer.synchro.toolbar.filter.exception.ToolbarException;

/**
 * The Interface PluginToolbarFilter.
 */
public interface PluginToolbarFilter {
	
	/**
	 * Delete element.
	 *
	 * @param match the match
	 * @param configurationBean the configuration bean
	 * @return the boolean
	 * @throws ToolbarException the toolbar exception
	 */
	Boolean deleteElement(RtMatch match, ToolbarConfigurationBean configurationBean) throws ToolbarException;
	

	/**
	 * Reset.
	 */
	void reset();

}
