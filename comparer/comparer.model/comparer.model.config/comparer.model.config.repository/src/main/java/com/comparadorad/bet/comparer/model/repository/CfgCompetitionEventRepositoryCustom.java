/**
 *
 * Copyright (C) FACTORIA ETSIA S.L.
 * All Rights Reserved.
 * www.factoriaetsia.com
 *
 */
package com.comparadorad.bet.comparer.model.repository;

import java.util.List;

import com.comparadorad.bet.comparer.model.config.bean.CfgCompetitionEvent;
import com.comparadorad.bet.comparer.model.core.repository.IGenericCustomRepository;

/**
 * The Interface CfgCompetitionEventRepositoryCustom.
 * 
 * @param <T>
 *            the generic type
 */
interface CfgCompetitionEventRepositoryCustom<T extends CfgCompetitionEvent>
		extends IGenericCustomRepository<T> {

	/**
	 * Custom find byname.
	 * 
	 * @param name
	 *            the name
	 * @return the list
	 */
	List<CfgCompetitionEvent> customFindByname(String name);
	
	
	
	/**
	 * Custom find by long term.
	 *
	 * @param isLongTerm the is long term
	 * @return the list
	 */
	List<CfgCompetitionEvent> customFindByLongTerm(boolean isLongTerm);

}
