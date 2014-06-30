/**
 *
 * Copyright (C) FACTORIA ETSIA S.L.
 * All Rights Reserved.
 * www.factoriaetsia.com
 *
 */
package com.comparadorad.bet.comparer.util.commons.string;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

/**
 * The Class StringUtilTest.
 */
public class StringUtilTest {

	/** The cadena. */
	private String cadena = "";

	/** The result. */
	private String result = "";

	/**
	 * Delete parenthesis test.
	 */
	@Test
	public void deleteParenthesisTest() {
		cadena = "(cadena)";

		StringUtil string = new StringUtil();

		result = string.deleteParenthesis(cadena);

		assertNotNull(result);
		assertNotEquals(cadena, result);
		assertTrue(result.indexOf("(") == -1);
		assertTrue(result.indexOf(")") == -1);
	}

	/**
	 * Delete numbers test.
	 */
	@Test
	public void deleteNumbersTest() {
		cadena = "abdc1";

		StringUtil string = new StringUtil();
		result = string.deleteNumbers(cadena);

		assertNotNull(result);
		assertTrue(result.indexOf("1") == -1);

	}

	/**
	 * Delete negatives.
	 */
	@Test
	public void deleteNegatives() {
		cadena = "-1";

		StringUtil stringUtil = new StringUtil();
		result = stringUtil.deleteNegatives(cadena);

		assertNotNull(result);
		assertEquals(result, "1");

	}

	/**
	 * Delete character test.
	 */
	@Test
	public void deleteCharacterTest() {
		cadena = "abcd*e";
		String character = "*";

		StringUtil stringUtil = new StringUtil();
		result = stringUtil.deleteCharacter(cadena, character);

		assertNotNull(result);
		assertTrue(result.indexOf(character) == -1);
	}

	/**
	 * Replace character test.
	 */
	@Test
	public void replaceCharacterTest() {
		cadena = "abcd*e";
		String character = "*";
		int characterPosition = cadena.indexOf(character);
		String replacementCharacter = "@";

		StringUtil stringUtil = new StringUtil();
		result = stringUtil.replaceCharacter(cadena, character,
				replacementCharacter);

		assertNotNull(result);
		assertTrue(result.indexOf(character) == -1);
		assertTrue(result.indexOf(replacementCharacter) == characterPosition);

	}
	
	@Test
	public void removeSpecialCharactersTest() {
		cadena = "España";
		StringUtil stringUtil = new StringUtil();
		result = stringUtil.removeSpecialCharacters(cadena);
		
		assertTrue(result.equals("Espana"));
		
		cadena = "Cigüeña";
		result = stringUtil.removeSpecialCharacters(cadena);
		
		assertTrue(result.equals("Ciguena"));
		
		cadena = "Barça";
		result = stringUtil.removeSpecialCharacters(cadena);
		
		assertTrue(result.equals("Barca"));
	}

}
