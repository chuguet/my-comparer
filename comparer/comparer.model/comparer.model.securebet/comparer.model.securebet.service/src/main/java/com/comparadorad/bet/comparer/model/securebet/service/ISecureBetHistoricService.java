package com.comparadorad.bet.comparer.model.securebet.service;

import com.comparadorad.bet.comparer.model.core.service.IGenericCrudService;
import com.comparadorad.bet.comparer.model.securebet.bean.SecureBeanHistoricData;

/**
 * The Interface ISecureBetHistoricService.
 */
public interface ISecureBetHistoricService extends
		IGenericCrudService<SecureBeanHistoricData> {

	public void saveWithOutValidation(SecureBeanHistoricData entity);
}
