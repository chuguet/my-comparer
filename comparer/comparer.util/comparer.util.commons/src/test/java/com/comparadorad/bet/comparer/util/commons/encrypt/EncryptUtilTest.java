/**
 *
 * Copyright (C) FACTORIA ETSIA S.L.
 * All Rights Reserved.
 * www.factoriaetsia.com
 *
 */
package com.comparadorad.bet.comparer.util.commons.encrypt;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

import org.junit.Test;

/**
 * The Class EncryptUtilTest.
 */
public class EncryptUtilTest {

	/**
	 * Encrypt ok test.
	 */
	@Test
	public void encryptOKTest() {
		String palabraAntesEncrypt = "prueba";
		String palabraEncriptada = "";

		palabraEncriptada = EncryptUtil.encryptString(palabraAntesEncrypt);

		assertNotEquals(palabraAntesEncrypt, palabraEncriptada);
	}

	/**
	 * Desencrypt ok test.
	 */
	@Test
	public void desencryptOKTest() {
		String palabraAntesEncrypt = "prueba";
		String palabraEncriptada = "";

		palabraEncriptada = EncryptUtil.encryptString(palabraAntesEncrypt);

		assertNotEquals(palabraAntesEncrypt, palabraEncriptada);

		String desencriptado = EncryptUtil.desencryptString(palabraEncriptada);
		assertEquals(palabraAntesEncrypt, desencriptado);

	}
}
