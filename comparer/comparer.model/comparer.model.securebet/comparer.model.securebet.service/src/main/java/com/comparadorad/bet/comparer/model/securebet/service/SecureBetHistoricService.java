package com.comparadorad.bet.comparer.model.securebet.service;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.comparadorad.bet.comparer.model.core.repository.IGenericRepository;
import com.comparadorad.bet.comparer.model.core.service.AbstractGenericCrudService;
import com.comparadorad.bet.comparer.model.securebet.bean.SecureBeanHistoricData;
import com.comparadorad.bet.comparer.model.securebet.repository.SecureBetHistoricRepository;

/**
 * The Class SecureBetHistoricService.
 */
@Service
class SecureBetHistoricService extends
		AbstractGenericCrudService<SecureBeanHistoricData> implements
		ISecureBetHistoricService {

	/** The secure bet historic repository. */
	@Inject
	private SecureBetHistoricRepository secureBetHistoricRepository;

	/**
	 * Gets the crud repository.
	 * 
	 * @return the crud repository {@inheritDoc}
	 */
	@Override
	protected IGenericRepository<SecureBeanHistoricData> getCrudRepository() {
		return secureBetHistoricRepository;
	}

	public void saveWithOutValidation(SecureBeanHistoricData entity){
		secureBetHistoricRepository.saveWithOutValidation(entity);
	}
}
