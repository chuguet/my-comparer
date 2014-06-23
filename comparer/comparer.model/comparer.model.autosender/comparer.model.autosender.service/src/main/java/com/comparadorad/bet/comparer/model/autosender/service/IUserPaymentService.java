/**
 *
 * Copyright (C) FACTORIA ETSIA S.L.
 * All Rights Reserved.
 * www.factoriaetsia.com
 *
 */
package com.comparadorad.bet.comparer.model.autosender.service;

import com.comparadorad.bet.comparer.model.autosender.bean.TypePaymentName;
import com.comparadorad.bet.comparer.model.autosender.bean.UserCreacion;
import com.comparadorad.bet.comparer.model.autosender.bean.UserPayment;

/**
 * The Interface IUserPaymentService.
 */
public interface IUserPaymentService extends
		IModelService<UserPayment, Integer> {
	
	
	/**
	 * Make payment.
	 *
	 * @param userId the user id
	 * @param typePaymentName the type payment name
	 * @param creacion the creacion
	 * @return true, if successful
	 */
//	void makePayment(Integer userId, TypePaymentName typePaymentName, UserCreacion creacion);
//	
//	/**
//	 * Make payment by liferay user.
//	 *
//	 * @param userId the user id
//	 * @param typePaymentName the type payment name
//	 * @param creacion the creacion
//	 */
//	void makePaymentByLiferayUser(Integer userId, TypePaymentName typePaymentName, UserCreacion creacion);

}
