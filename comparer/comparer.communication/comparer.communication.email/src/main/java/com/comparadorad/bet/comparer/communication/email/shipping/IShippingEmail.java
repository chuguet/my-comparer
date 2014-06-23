/**
 *
 * Copyright (C) FACTORIA ETSIA S.L.
 * All Rights Reserved.
 * www.factoriaetsia.com
 *
 */
package com.comparadorad.bet.comparer.communication.email.shipping;

import com.comparadorad.bet.comparer.communication.email.exception.ShippingEmailException;

/**
 * The Interface IShippingEmail.
 */

public interface IShippingEmail {
	
	/**
	 * Ship mail.
	 *
	 * @param message the message
	 * @throws ShippingEmailException the shipping email exception
	 */
	void shipMail(final String message) throws ShippingEmailException;

}
