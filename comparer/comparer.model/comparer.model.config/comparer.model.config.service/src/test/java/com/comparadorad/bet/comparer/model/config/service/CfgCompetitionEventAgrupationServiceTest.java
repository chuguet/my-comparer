package com.comparadorad.bet.comparer.model.config.service;

import javax.inject.Inject;

import com.comparadorad.bet.comparer.model.config.bean.CfgCompetitionEventAgrupation;
import com.comparadorad.bet.comparer.model.core.service.IGenericCrudService;

public class CfgCompetitionEventAgrupationServiceTest extends AbstractServiceTest<CfgCompetitionEventAgrupation> {
	
	
	@Inject
	private ICfgCompetitionEventAgrupationService competitionEventAgrupationService;

	@Override
	protected IGenericCrudService<CfgCompetitionEventAgrupation> getIGenericService() {
		return competitionEventAgrupationService;
	}

}
