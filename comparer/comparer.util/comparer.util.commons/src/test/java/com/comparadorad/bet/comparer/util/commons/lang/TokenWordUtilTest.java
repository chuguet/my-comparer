package com.comparadorad.bet.comparer.util.commons.lang;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class TokenWordUtilTest {
	
	@Test
	public void createTokens() {
		String phrase = "González,Märtín-Pèkas Foto";
		String[] tokens = TokenWordUtil.createTokens(phrase);
		
		assertEquals(tokens.length, 4);
		assertEquals(tokens[0], "gonzalez");
		assertEquals(tokens[1], "martin");
		assertEquals(tokens[2], "pekas");
		assertEquals(tokens[3], "foto");
	}
}
