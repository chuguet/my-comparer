/**
 *
 * Copyright (C) FACTORIA ETSIA S.L.
 * All Rights Reserved.
 * www.factoriaetsia.com
 *
 */
package com.comparadorad.bet.comparer.util.mock.factory;

import static org.mockito.Mockito.mock;

import com.comparadorad.bet.comparer.util.mock.exception.MockException;

/**
 * A factory for creating Mock objects.
 *
 * @param <I> the generic type
 */
public abstract class MockFactory<I> implements IMockFactory<I> {
	
	 /** {@inheritDoc} */ 
	@SuppressWarnings("unchecked")
	@Override
	public I getObject() throws MockException {
		I i = null;
		try{			
			i = (I) mock(getObjectType());
			mockAction(i);
		}catch (Exception e) {
			throw new MockException(e.getMessage(),e);
		}
		return i;
	}
	
	@Override
	public String getBeanName() {
		return getObjectType().getName();
	}
	
	 /** {@inheritDoc} */ 
	@Override
	public boolean isSingleton() {
		return false;
	}
	
	/**
	 * Mock action.
	 *
	 * @param i the i
	 */
	protected abstract void mockAction(final I i);


}
