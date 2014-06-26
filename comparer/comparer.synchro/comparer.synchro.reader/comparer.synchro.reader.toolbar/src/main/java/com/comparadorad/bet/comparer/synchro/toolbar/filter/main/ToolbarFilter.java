/**
 *
 * Copyright (C) FACTORIA ETSIA S.L.
 * All Rights Reserved.
 * www.factoriaetsia.com
 *
 */
package com.comparadorad.bet.comparer.synchro.toolbar.filter.main;

import com.comparadorad.bet.comparer.model.bet.bean.RtMatch;
import com.comparadorad.bet.comparer.synchro.toolbar.filter.bean.ToolbarConfigurationBean;
import com.comparadorad.bet.comparer.synchro.toolbar.filter.exception.ToolbarException;


/**
 * The Interface IReaderFilter.
 */
public interface ToolbarFilter {
	


	/**
	 * Checks if is new.
	 *
	 * @param rtMatch the rt match
	 * @param configurationBean the configuration bean
	 * @return the boolean
	 * @throws ToolbarException the toolbar exception
	 */
	Boolean isNew(RtMatch rtMatch, ToolbarConfigurationBean configurationBean ) throws ToolbarException;
	
	

}
