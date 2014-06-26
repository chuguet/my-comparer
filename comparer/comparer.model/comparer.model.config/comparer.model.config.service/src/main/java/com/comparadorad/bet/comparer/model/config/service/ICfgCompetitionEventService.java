/**
 *
 * Copyright (C) FACTORIA ETSIA S.L.
 * All Rights Reserved.
 * www.factoriaetsia.com
 *
 */
package com.comparadorad.bet.comparer.model.config.service;

import java.util.List;

import com.comparadorad.bet.comparer.model.config.bean.CfgCompetitionEvent;
import com.comparadorad.bet.comparer.model.core.service.IGenericCrudService;

/**
 * The Interface ICfgCompetitionEventService.
 */
public interface ICfgCompetitionEventService extends
		IGenericCrudService<CfgCompetitionEvent> {

	/**
	 * Custom find byname.
	 * 
	 * @param pName
	 *            the name
	 * @return the list
	 */
	List<CfgCompetitionEvent> customFindByname(String pName);
}
