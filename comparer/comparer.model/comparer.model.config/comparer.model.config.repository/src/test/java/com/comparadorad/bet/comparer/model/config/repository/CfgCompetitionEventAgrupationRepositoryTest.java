package com.comparadorad.bet.comparer.model.config.repository;

import javax.inject.Inject;

import com.comparadorad.bet.comparer.model.config.bean.CfgCompetitionEventAgrupation;
import com.comparadorad.bet.comparer.model.core.bean.Order;
import com.comparadorad.bet.comparer.model.repository.CfgCompetitionEventAgrupationRepository;

public class CfgCompetitionEventAgrupationRepositoryTest extends
AbstractConfigRepositoryTest<CfgCompetitionEventAgrupationRepository> {
	
	@Inject
	private CfgCompetitionEventAgrupationRepository repository;

	@Override
	public CfgCompetitionEventAgrupationRepository getCrudRepository() {
		return repository;
	}

	@Override
	protected Object getNewElement() {
		CfgCompetitionEventAgrupation cfgCompetitionEventAgrupation = new CfgCompetitionEventAgrupation();
		Order order = new Order();
		cfgCompetitionEventAgrupation.setName("Esto es una prueba de grupos");
		order.setPriority(1);
		cfgCompetitionEventAgrupation.setOrder(order);
		return cfgCompetitionEventAgrupation;
	}

}
