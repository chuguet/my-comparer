package com.comparadorad.bet.comparer.model.config.repository;

import javax.inject.Inject;

import com.comparadorad.bet.comparer.model.config.bean.CfgBetTypeEventAgrupation;
import com.comparadorad.bet.comparer.model.core.bean.Order;
import com.comparadorad.bet.comparer.model.repository.CfgBetTypeEventAgrupationRepository;

public class CfgBetTypeEventAgrupationRepositoryTest extends
AbstractConfigRepositoryTest<CfgBetTypeEventAgrupationRepository> {
	
	@Inject
	private CfgBetTypeEventAgrupationRepository repository;

	@Override
	public CfgBetTypeEventAgrupationRepository getCrudRepository() {
		return repository;
	}

	@Override
	protected Object getNewElement() {
		CfgBetTypeEventAgrupation result = new CfgBetTypeEventAgrupation();
		Order order = new Order();
		order.setPriority(1);
		result.setName("Esto es una prueba");
		result.setOrder(order);
		return result;
	}


}
