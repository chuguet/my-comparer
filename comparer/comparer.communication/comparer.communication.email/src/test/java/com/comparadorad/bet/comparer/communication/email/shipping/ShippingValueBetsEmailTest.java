/**
 *
 * Copyright (C) FACTORIA ETSIA S.L.
 * All Rights Reserved.
 * www.factoriaetsia.com
 *
 */
package com.comparadorad.bet.comparer.communication.email.shipping;

import javax.inject.Inject;

/**
 * The Class ShippingValueBetsEmailTest.
 */
public class ShippingValueBetsEmailTest extends AbstractShipping {
	
	@Inject
	private ShippingValueBetsEmail shippingEmail;

	@Override
	protected IShippingEmail getShippingEmail() {
		return shippingEmail;
	}


}
