package com.comparadorad.bet.comparer.communication.email.shipping;

import javax.inject.Inject;

public class ShippingSureBetsEmailTest extends AbstractShipping {
	
	@Inject
	private FirstShippingSureBetsEmail ShippingSureBetsEmail;

	@Override
	protected IShippingEmail getShippingEmail() {
		return ShippingSureBetsEmail;
	}

}
