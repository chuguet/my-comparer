/**
 *
 * Copyright (C) FACTORIA ETSIA S.L.
 * All Rights Reserved.
 * www.factoriaetsia.com
 *
 */
package com.comparadorad.bet.comparer.model.repository;

import com.comparadorad.bet.comparer.model.config.bean.CfgParticipant;
import com.comparadorad.bet.comparer.model.core.repository.IGenericRepository;

/**
 * The Interface CfgTeamRepository.
 */
public interface CfgParticipantRepository extends
		IGenericRepository<CfgParticipant>,
		CfgParticipantRepositoryCustom<CfgParticipant> {

}
