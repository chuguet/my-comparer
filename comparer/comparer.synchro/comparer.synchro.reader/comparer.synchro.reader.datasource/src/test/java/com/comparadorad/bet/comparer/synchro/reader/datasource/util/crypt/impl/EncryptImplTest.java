/**
 *
 * Copyright (C) FACTORIA ETSIA S.L.
 * All Rights Reserved.
 * www.factoriaetsia.com
 *
 */
package com.comparadorad.bet.comparer.synchro.reader.datasource.util.crypt.impl;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotSame;

import javax.inject.Inject;

import org.junit.Test;

import com.comparadorad.bet.comparer.synchro.reader.datasource.AbstractSynchroReaderDatasourceTest;
import com.comparadorad.bet.comparer.synchro.reader.datasource.crypt.Encrypt;

/**
 * The Class EncryptImplTest.
 */
public final class EncryptImplTest extends AbstractSynchroReaderDatasourceTest {
	
	/** The encrypt. */
	@Inject
	private Encrypt encrypt;

	/**
	 * Test.
	 *
	 * {@inheritDoc}
	 */ 
	@Test
	public final void test() {
		String Test1 = "test1";
		String test2 = "test2";		
		Test1 = encrypt.sha1(Test1);
		test2 = encrypt.sha1(test2);
		assertNotSame(Test1, test2);
	}

	/**
	 * Test different m d5.
	 */
	@Test
	public final void testDifferentMD5() {
		String test1 = "test1";
		String test2 = "test2";
		test1 = encrypt.md5(test1);
		test2 = encrypt.md5(test2);
		assertNotSame(test1, test2);

	}

	/**
	 * Test equal m d5.
	 */
	@Test
	public final void testEqualMD5() {
		String seed = "exampleSeed";
		String test1;
		String test2;
		test1 = encrypt.sha1(seed);
		test2 = encrypt.sha1(seed);
		assertEquals(test1, test2);
	}

	/**
	 * Test equal sh a1.
	 */
	@Test
	public final void testEqualSHA1() {
		String seed = "exampleSeed";
		String test1;
		String test2;
		test1 = encrypt.sha1(seed);
		test2 = encrypt.sha1(seed);
		assertEquals(test1, test2);
		
	}
	
	/**
	 * Test size m d5.
	 */
	@Test
	public final void testSizeMD5(){
		int lenght = 32;
		assertEquals(lenght, encrypt.md5("1").length());
		assertEquals(lenght, encrypt.md5("1234567890").length());
		assertEquals(lenght, encrypt.md5("12345678901234567890").length());
		assertEquals(lenght, encrypt.md5("123456789012345678901234567890").length());
		assertEquals(lenght, encrypt.md5("1234567890123456789012345678901234567890").length());
		assertEquals(lenght, encrypt.md5("Abce13232DtdfaqjhkuhYEWasd7667fvghjqwasd").length());
	}
	

}
