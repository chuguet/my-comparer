/**
 *
 * Copyright (C) FACTORIA ETSIA S.L.
 * All Rights Reserved.
 * www.factoriaetsia.com
 *
 */
package com.comparadorad.bet.comparer.model.config.service;

import com.comparadorad.bet.comparer.model.config.bean.CfgBookmaker;
import com.comparadorad.bet.comparer.model.core.service.IGenericCrudService;

/**
 * The Interface ICfgBookmakerService.
 */
public interface ICfgBookmakerService extends IGenericCrudService<CfgBookmaker> {

	/**
	 * Gets the active bookmakers.
	 * 
	 * @return the active bookmakers
	 */
	Long getActiveBookmakers();

}
