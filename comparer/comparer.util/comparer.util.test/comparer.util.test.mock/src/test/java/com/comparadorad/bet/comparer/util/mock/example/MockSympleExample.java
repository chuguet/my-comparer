/**
 *
 * Copyright (C) FACTORIA ETSIA S.L.
 * All Rights Reserved.
 * www.factoriaetsia.com
 *
 */
package com.comparadorad.bet.comparer.util.mock.example;

import static org.mockito.Mockito.when;

import org.springframework.stereotype.Service;

import com.comparadorad.bet.comparer.util.mock.factory.MockFactory;

/**
 * The Class MockSympleExample.
 */
/*
 * Se registra el object en el contexto de Spring
 */
@Service
public class MockSympleExample extends MockFactory<ISympleExample> {

	/*
	 *  Se debe indicar el tipo de objecto que se quiere implementar
	 */
	@Override
	public Class<?> getObjectType() {
		return ISympleExample.class;
	}

	/*
	 *  Añadir funcionalidad al objecto utilizando mockito
	 */	
	@SuppressWarnings("unchecked")
	@Override
	protected void mockAction(ISympleExample i) {
		when(i.exampleWithString("ejemplo")).thenReturn("ejemplo");
		when(i.exampleWithString("excepcion")).thenThrow(Exception.class);
	}
}
