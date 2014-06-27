package com.comparadorad.bet.comparer.synchro.reader.readerbookmaker.core.readers.test;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

import com.comparadorad.bet.comparer.synchro.reader.readerbookmaker.core.util.StringFormatterUtil;

public class UtilTest extends AbstractTest {

	@Test
	public void normalizeReaderStringTest() {
		String cadenaEntrada = "Basel - Grasshoppers<BR/><span>Final in Bern</span>: time of first goal";
		String cadenaSalidaEsperada = "Basel - Grasshoppers";
		String result = "";
		
		result = StringFormatterUtil.normalizeReaderString(cadenaEntrada);
		
		assertTrue(result.equals(cadenaSalidaEsperada));
		
	}
	
	@Test
	public void normalizeReaderSpecialCharactersTest() {
		String cadenaEntrada = "Örebro SK";
		String cadenaSalidaEsperada = "Orebro SK";
		String result = "";
		
		result = StringFormatterUtil.normalizeReaderString(cadenaEntrada);
		
		assertTrue(result.equals(cadenaSalidaEsperada));
		
	}
	
	
}
