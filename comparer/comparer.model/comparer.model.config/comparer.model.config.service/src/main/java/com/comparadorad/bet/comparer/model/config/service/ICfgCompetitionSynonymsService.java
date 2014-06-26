/**
 *
 * Copyright (C) FACTORIA ETSIA S.L.
 * All Rights Reserved.
 * www.factoriaetsia.com
 *
 */
package com.comparadorad.bet.comparer.model.config.service;

import java.math.BigInteger;

import org.springframework.cache.annotation.Cacheable;

import com.comparadorad.bet.comparer.model.config.bean.CfgCompetition;
import com.comparadorad.bet.comparer.model.config.bean.CfgCompetitionSynonyms;
import com.comparadorad.bet.comparer.model.core.service.IGenericCrudService;
import com.comparadorad.bet.comparer.model.repository.exception.CompetitionNotVerifiedException;

/**
 * The Interface ICfgCompetitionSynonymsService.
 */
public interface ICfgCompetitionSynonymsService extends
		IGenericCrudService<CfgCompetitionSynonyms>,
		ISynonymsService<CfgCompetitionSynonyms> {

	/**
	 * Find by competition name and sport.
	 * 
	 * @param name
	 *            the name
	 * @param sportId
	 *            the sport id
	 * @return the cfg competition
	 * @throws CompetitionNotVerifiedException
	 */
	@Cacheable({ "findByCompetitionNameAndSportConfig" })
	CfgCompetition findByCompetitionNameAndSport(String name, BigInteger sportId)
			throws CompetitionNotVerifiedException;

}
