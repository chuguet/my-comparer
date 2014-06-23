/**
 *
 * Copyright (C) FACTORIA ETSIA S.L.
 * All Rights Reserved.
 * www.factoriaetsia.com
 *
 */
package com.comparadorad.bet.comparer.dbsynchro.usertask.state.generic;

import com.comparadorad.bet.comparer.dbsynchro.usertask.exception.StateException;

/**
 * The Interface IPaymentState.
 */
public interface IPaymentState {

	/**
	 * Adds the payment list free service.
	 * 
	 * @throws StateException
	 *             the state exception
	 */
	void addPaymentListFreeService() throws StateException;

	/**
	 * Adds the payment list lvl1_1 ano.
	 * 
	 * @throws StateException
	 *             the state exception
	 */
	void addPaymentListLvl1_1Ano() throws StateException;

	/**
	 * Adds the payment list lvl1_1 mes.
	 * 
	 * @throws StateException
	 *             the state exception
	 */
	void addPaymentListLvl1_1Mes() throws StateException;

	/**
	 * Adds the payment list lvl1_6 mes.
	 * 
	 * @throws StateException
	 *             the state exception
	 */
	void addPaymentListLvl1_6Mes() throws StateException;

	/**
	 * Adds the payment list lvl2_1 ano.
	 * 
	 * @throws StateException
	 *             the state exception
	 */
	void addPaymentListLvl2_1Ano() throws StateException;

	/**
	 * Adds the payment list lvl2_1 mes.
	 * 
	 * @throws StateException
	 *             the state exception
	 */
	void addPaymentListLvl2_1Mes() throws StateException;

	/**
	 * Adds the payment list lvl2_6 mes.
	 * 
	 * @throws StateException
	 *             the state exception
	 */
	void addPaymentListLvl2_6Mes() throws StateException;

	/**
	 * Adds the payment list lvl3_ ano.
	 * 
	 * @throws StateException
	 *             the state exception
	 */
	void addPaymentListLvl3_1Ano() throws StateException;

	/**
	 * Adds the payment list lvl3_1 mes.
	 * 
	 * @throws StateException
	 *             the state exception
	 */
	void addPaymentListLvl3_1Mes() throws StateException;

	/**
	 * Adds the payment list lvl3_6 mes.
	 * 
	 * @throws StateException
	 *             the state exception
	 */
	void addPaymentListLvl3_6Mes() throws StateException;

	/**
	 * Adds the payment list register.
	 * 
	 * @throws StateException
	 *             the state exception
	 */
	void addPaymentListRegister() throws StateException;

	/**
	 * Modify payment list after free service.
	 * 
	 * @throws StateException
	 *             the state exception
	 */
	void modifyPaymentListAfterFreeService() throws StateException;

	/**
	 * Modify payment list after payment service.
	 * 
	 * @throws StateException
	 *             the state exception
	 */
	void modifyPaymentListAfterPaymentService() throws StateException;

	/**
	 * Modify payment list free service.
	 * 
	 * @throws StateException
	 *             the state exception
	 */
	void modifyPaymentListFreeService() throws StateException;

	/**
	 * Modify payment list limb2.
	 * 
	 * @throws StateException
	 *             the state exception
	 */
	void modifyPaymentListLimb2() throws StateException;

	/**
	 * Modify payment list limb3.
	 * 
	 * @throws StateException
	 *             the state exception
	 */
	void modifyPaymentListLimb3() throws StateException;

	/**
	 * Modify payment list lvl1_1 ano.
	 * 
	 * @throws StateException
	 *             the state exception
	 */
	void modifyPaymentListLvl1_1Ano() throws StateException;

	/**
	 * Modify payment list lvl1.
	 * 
	 * @throws StateException
	 *             the state exception
	 */
	void modifyPaymentListLvl1_1Mes() throws StateException;

	/**
	 * Modify payment list lvl1_6 mes.
	 * 
	 * @throws StateException
	 *             the state exception
	 */
	void modifyPaymentListLvl1_6Mes() throws StateException;

	/**
	 * Modify payment list lvl2_1 ano.
	 * 
	 * @throws StateException
	 *             the state exception
	 */
	void modifyPaymentListLvl2_1Ano() throws StateException;

	/**
	 * Modify payment list lvl2.
	 * 
	 * @throws StateException
	 *             the state exception
	 */
	void modifyPaymentListLvl2_1Mes() throws StateException;

	/**
	 * Modify payment list lvl2_6 mes.
	 * 
	 * @throws StateException
	 *             the state exception
	 */
	void modifyPaymentListLvl2_6Mes() throws StateException;

	/**
	 * Modify payment list lvl3_ ano.
	 * 
	 * @throws StateException
	 *             the state exception
	 */
	void modifyPaymentListLvl3_1Ano() throws StateException;

	/**
	 * Modify payment list lvl3.
	 * 
	 * @throws StateException
	 *             the state exception
	 */
	void modifyPaymentListLvl3_1Mes() throws StateException;

	/**
	 * Modify payment list lvl3_6 mes.
	 * 
	 * @throws StateException
	 *             the state exception
	 */
	void modifyPaymentListLvl3_6Mes() throws StateException;

	/**
	 * Modify payment list register.
	 * 
	 * @throws StateException
	 *             the state exception
	 */
	void modifyPaymentListRegister() throws StateException;
}
