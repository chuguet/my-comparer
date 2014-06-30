/**
 *
 * Copyright (C) FACTORIA ETSIA S.L.
 * All Rights Reserved.
 * www.factoriaetsia.com
 *
 */
package com.comparadorad.bet.comparer.synchro.valuebet.reader;

import org.junit.Test;
import org.springframework.batch.item.NonTransientResourceException;
import org.springframework.batch.item.ParseException;
import org.springframework.batch.item.UnexpectedInputException;

/**
 * The Class ReaderValueBetTest.
 */
public final class ReaderValueBetTest extends AbstractTest {

	/**
	 * Read test. Hay 22 bookmakers activos en BD. Seteamos el porcentage
	 * quantityPercentBookmakers a 30% lo que significa que solo se va a
	 * procesar partidos con 7 bookmakers. En BD hay 25 partidos, todos con
	 * algun mercado con 3 bookmakers. Se va a recuperar los partidos 10 a 10.
	 * 
	 * @throws UnexpectedInputException
	 *             the unexpected input exception
	 * @throws ParseException
	 *             the parse exception
	 * @throws NonTransientResourceException
	 *             the non transient resource exception
	 * @throws Exception
	 *             the exception
	 */
	@Test
	public final void readTest() throws UnexpectedInputException,
			ParseException, NonTransientResourceException, Exception {

		// List<String> matchIds = new ArrayList<String>();
		//
		// dataConfiguration.setQuantityLimitMatchs(10);
		// dataConfiguration.setQuantityPercentBookmakers(5);
		//
		// assertEquals(25, rtMatchService.count());
		//
		// RtMatch match;
		//
		// // Estado inicial
		// assertNotNull(ReaderValueBet.getMatchs());
		// assertEquals(0, ReaderValueBet.getMatchs().size());
		//
		// // Partidos 0 a 9
		// // **************************************
		// for (int i = 1; i <= 10; i++) {
		// match = readerValueBet.read();
		//
		// // Skip igual a 0 (empezar por el primer partido)
		// assertEquals(Integer.valueOf("0"), ReaderValueBet.getSkip());
		//
		// // Por cada llamada al read() se disminuye el numero de RtMatchs del
		// // list del reader.
		// assertEquals(10 - i, ReaderValueBet.getMatchs().size());
		//
		// // Verificamos que se devuelve un RtMatch distinto por cada llamada
		// assertNotNull(match);
		// assertFalse(matchIds.contains(match.getObjectId().toString()));
		// matchIds.add(match.getObjectId().toString());
		// }
		//
		// assertEquals(0, ReaderValueBet.getMatchs().size());
		//
		// // Partidos 10 a 19
		// // **************************************
		// for (int i = 1; i <= 10; i++) {
		// match = readerValueBet.read();
		//
		// assertEquals(Integer.valueOf("10"), ReaderValueBet.getSkip());
		//
		// assertEquals(10 - i, ReaderValueBet.getMatchs().size());
		//
		// assertNotNull(match);
		// assertFalse(matchIds.contains(match.getObjectId().toString()));
		// matchIds.add(match.getObjectId().toString());
		// }
		//
		// assertEquals(0, ReaderValueBet.getMatchs().size());
		//
		// // Partidos 20 a 25
		// // **************************************
		// for (int i = 1; i <= 5; i++) {
		// match = readerValueBet.read();
		//
		// assertEquals(Integer.valueOf("20"), ReaderValueBet.getSkip());
		//
		// assertEquals(5 - i, ReaderValueBet.getMatchs().size());
		//
		// assertNotNull(match);
		// assertFalse(matchIds.contains(match.getObjectId().toString()));
		// matchIds.add(match.getObjectId().toString());
		// }
		//
		// assertEquals(0, ReaderValueBet.getMatchs().size());
		//
		// // Partidos 1 a 10 otra vez
		// // **************************************
		// for (int i = 1; i <= 10; i++) {
		// match = readerValueBet.read();
		//
		// // Skip igual a 0 (empezar por el primer partido)
		// assertEquals(Integer.valueOf("0"), ReaderValueBet.getSkip());
		//
		// assertEquals(10 - i, ReaderValueBet.getMatchs().size());
		//
		// // Verificamos que se devuelve un RtMatch que ya se había procesado
		// assertNotNull(match);
		// assertTrue(matchIds.contains(match.getObjectId().toString()));
		// }
		//
		// assertEquals(0, ReaderValueBet.getMatchs().size());

	}

}
