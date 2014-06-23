/**
 *
 * Copyright (C) FACTORIA ETSIA S.L.
 * All Rights Reserved.
 * www.factoriaetsia.com
 *
 */
package com.comparadorad.bet.comparer.communication.surebets.send;

import com.comparadorad.bet.comparer.model.securebet.bean.SecureBeanData;


/**
 * The Interface ISendSureBetEmail.
 */
public interface ISendSureBetEmail {
	
	/**
	 * Send.
	 *
	 * @param sureBetQueue the sure bet queue
	 * @return the boolean
	 */
	Boolean send(SecureBeanData secureBeanData);

}
