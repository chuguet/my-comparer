/**
 *
 * Copyright (C) FACTORIA ETSIA S.L.
 * All Rights Reserved.
 * www.factoriaetsia.com
 *
 */
package com.comparadorad.bet.comparer.model.securebet.service;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.comparadorad.bet.comparer.model.bet.bean.RtBet;
import com.comparadorad.bet.comparer.model.core.bean.CoreDate;
import com.comparadorad.bet.comparer.model.core.repository.IGenericRepository;
import com.comparadorad.bet.comparer.model.core.service.AbstractGenericCrudService;
import com.comparadorad.bet.comparer.model.securebet.bean.HistoricInfo.Cause;
import com.comparadorad.bet.comparer.model.securebet.bean.SecureBeanData;
import com.comparadorad.bet.comparer.model.securebet.exception.SureBetNotFoundException;
import com.comparadorad.bet.comparer.model.securebet.repository.SecureBetHistoricRepository;
import com.comparadorad.bet.comparer.model.securebet.repository.SecureBetRepository;

/**
 * The Class CfgSportService.
 */
@Service
class SecureBetService extends AbstractGenericCrudService<SecureBeanData>
		implements ISecureBetService {

	/** The sport repository. */
	@Inject
	private SecureBetRepository secureBetRepository;
	
	@Inject
	private SecureBetHistoricRepository secureBetHistoricRepository;

	/**
	 * Exist.
	 * 
	 * @param secureBeanData
	 *            the secure bean data
	 * @return the boolean {@inheritDoc}
	 */
	@Override
	public SecureBeanData exist(SecureBeanData secureBeanData) throws SureBetNotFoundException {
		List<SecureBeanData> result = secureBetRepository.exist(secureBeanData);
		if(result.isEmpty()){
			throw new SureBetNotFoundException();
		}
		return result.get(0);
	}

	/** {@inheritDoc} */
	@Override
	public SecureBeanData findOneCustom(String sureBetId) {
		return secureBetRepository.findOneCustom(sureBetId);
	}

	/**
	 * Gets the count.
	 * 
	 * @param coreDate
	 *            the core date
	 * @return the count {@inheritDoc}
	 */
	@Override
	public long getCount(CoreDate coreDate) {
		return secureBetRepository.getCount(coreDate);
	}

	/**
	 * Gets the crud repository.
	 * 
	 * @return the crud repository {@inheritDoc}
	 */
	@Override
	protected IGenericRepository<SecureBeanData> getCrudRepository() {
		return secureBetRepository;
	}

	/**
	 * Gets the sure bet page.
	 * 
	 * @param coreDate
	 *            the core date
	 * @param PageSize
	 *            the page size
	 * @param PageNumber
	 *            the page number
	 * @return the sure bet page {@inheritDoc}
	 */
	@Override
	public List<SecureBeanData> getSureBetPage(CoreDate coreDate, int PageSize,
			long PageNumber) {
		return secureBetRepository.getSureBetPage(coreDate, PageSize,
				PageNumber);
	}

	/**
	 * Last date surebet.
	 * 
	 * @param secureBeanData
	 *            the secure bean data
	 * @return the secure bean data {@inheritDoc}
	 */
	@Override
	public SecureBeanData lastDateSurebet(SecureBeanData secureBeanData) {
		return secureBetRepository.lastDateSurebet(secureBeanData);
	}

	public List<SecureBeanData> getSureBetPaginateForHistoric(int PageSize,
			long PageNumber){
		
		return secureBetRepository.getSureBetPaginateForHistoric(PageSize, PageNumber);
	}
	
	
	@Override
	public void update(SecureBeanData secureBeanData, SecureBeanData surebetDB) {
		Boolean update = Boolean.FALSE;
		
		for (RtBet bet : secureBeanData.getBets()) {
			if(!surebetDB.containEqualsBet(bet)){
				update = Boolean.TRUE;
				break;
			}
		}
		
		if(update){
			secureBetRepository.update(surebetDB,secureBeanData.getBets(),secureBeanData.getBenefit());
			secureBetHistoricRepository.saveWithOutValidation(surebetDB.convertToHistoric(Cause.CambioDeCuotas_SigueSiendoSureBet));
			
		}
	}
	@Override
	public void directUpdate(SecureBeanData secureBeanData, SecureBeanData surebetDB) {
		
			secureBetRepository.update(surebetDB,secureBeanData.getBets(),secureBeanData.getBenefit());
			secureBetHistoricRepository.saveWithOutValidation(surebetDB.convertToHistoric(Cause.CambioDeCuotas_SigueSiendoSureBet));
	}
}
