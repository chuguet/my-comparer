/**
 *
 * Copyright (C) FACTORIA ETSIA S.L.
 * All Rights Reserved.
 * www.factoriaetsia.com
 *
 */

package com.comparadorad.bet.comparer.model.securebet.service;

import java.util.List;

import com.comparadorad.bet.comparer.model.core.bean.CoreDate;
import com.comparadorad.bet.comparer.model.core.service.IGenericCrudService;
import com.comparadorad.bet.comparer.model.securebet.bean.SecureBeanData;
import com.comparadorad.bet.comparer.model.securebet.exception.SureBetNotFoundException;

/**
 * The Interface ISecureBetService.
 */

public interface ISecureBetService extends IGenericCrudService<SecureBeanData> {

	/**
	 * Exist.
	 *
	 * @param secureBeanData the secure bean data
	 * @return the boolean
	 * @throws SureBetNotFoundException the sure bet not found exception
	 */
	public SecureBeanData exist(SecureBeanData secureBeanData) throws SureBetNotFoundException;

	/**
	 * Find one custom.
	 * 
	 * @param pId
	 *            the id
	 * @return the secure bean data
	 */
	SecureBeanData findOneCustom(String pId);

	/**
	 * Gets the count.
	 * 
	 * @param coreDate
	 *            the core date
	 * @return the count
	 */
	long getCount(CoreDate coreDate);

	/**
	 * Gets the sure bet page.
	 * 
	 * @param coreDate
	 *            the core date
	 * @param PageSize
	 *            the page size
	 * @param PageNumber
	 *            the page number
	 * @return the sure bet page
	 */
	List<SecureBeanData> getSureBetPage(CoreDate coreDate, int PageSize,
			long PageNumber);

	/**
	 * Last date ssurebet.
	 * 
	 * @param secureBeanData
	 *            the secure bean data
	 * @return the core date
	 */
	SecureBeanData lastDateSurebet(SecureBeanData secureBeanData);

	/**
	 * Update.
	 *
	 * @param secureBeanData the secure bean data
	 * @param surebetDB the surebet db
	 */
	void update(SecureBeanData secureBeanData, SecureBeanData surebetDB);

	/**
	 * Gets the sure bet paginate for historic.
	 *
	 * @param PageSize the page size
	 * @param PageNumber the page number
	 * @return the sure bet paginate for historic
	 */
	public List<SecureBeanData> getSureBetPaginateForHistoric(int PageSize,
			long PageNumber);
	
	public void directUpdate(SecureBeanData secureBeanData, SecureBeanData surebetDB);
}