/**
 *
 * Copyright (C) FACTORIA ETSIA S.L.
 * All Rights Reserved.
 * www.factoriaetsia.com
 *
 */
package com.comparadorad.bet.comparer.synchro.reader.readerbookmaker.core.readers.interwetten;

import java.util.ArrayList;
import java.util.List;

/**
 * The Class InterwettenWinnerUtil. Se obtiene informacion de la url:
 * http://ad.interwetten.com/XMLFeeder/feeder.asmx
 * /getfeed?FEEDPARAMS=ValidOffertypes|LANGUAGE=EN
 * 
 * Los siguientes tipos son los que vamos a tratar. Sólo se incluyen tipos de
 * over/under que se han visto en los xml o que tengan un nombre tan
 * significativo que se arriesga a tratarlo.
 * 
 * <OFFERTYPE ID="70" NAME="Longterm Team"/>
 * 
 * <OFFERTYPE ID="71" NAME="Longterm Player"/>
 * 
 * <OFFERTYPE ID="9905559" NAME="Winner"/>
 * 
 * <OFFERTYPE ID="9905742" NAME="World Champion"/>
 * 
 * <OFFERTYPE ID="9905500" NAME="Tour de France Winner"/>
 * 
 * Los siguientes apuestas no se han visto nunca en los xml. Por eso no los
 * vamos a tratar hasta que se ha visto algun ejemplo. Esto se hace siguendo una
 * filosofia de 'mejor leer menos partidos que leer un partido mal y arriesgar
 * machacar algo que se había leido bien'.
 * 
 * <OFFERTYPE ID="9905476" NAME="Winner(OT,PS)"/>
 * 
 * <OFFERTYPE ID="9905390" NAME="Group Winner"/>
 * 
 */
public class InterwettenWinnerUtil {

	/** The winner. */
	private static List<Integer> winner;

	static {
		winner = new ArrayList<Integer>();
		winner.add(70);
		winner.add(71);
		winner.add(9905500);
		winner.add(9905559);
		winner.add(9905742);
	}

	/**
	 * Interwetten winner util.
	 * 
	 * @param number
	 *            the number
	 * @return the boolean
	 */
	public static Boolean isWinner(Integer number) {
		return winner.contains(number);
	}

}
