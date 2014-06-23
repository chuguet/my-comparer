package com.comparadorad.bet.comparer.communication.email.shipping;

import static org.junit.Assert.assertNotNull;

import org.junit.Test;

import com.comparadorad.bet.comparer.communication.email.AbstractTest;
import com.comparadorad.bet.comparer.communication.email.exception.ShippingEmailException;

public abstract class AbstractShipping extends AbstractTest {
	
	protected abstract IShippingEmail getShippingEmail();
	
	@Test
	public final void shipMailTest() throws ShippingEmailException {
		assertNotNull(getShippingEmail());
		getShippingEmail().shipMail("Se envia correo electronico");
	}

}
