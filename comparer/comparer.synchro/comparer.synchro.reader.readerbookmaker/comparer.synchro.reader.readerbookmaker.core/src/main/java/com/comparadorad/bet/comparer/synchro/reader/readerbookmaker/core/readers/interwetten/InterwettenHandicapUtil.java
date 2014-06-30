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

import com.comparadorad.bet.comparer.synchro.reader.readerbookmaker.bean.interwetten.FEED.KINDOFSPORT.LEAGUE.EVENT.BET;

/**
 * The Class InterwettenHandicapUtil.
 * 
 * Se obtiene informacion de la url:
 * http://ad.interwetten.com/XMLFeeder/feeder.asmx
 * /getfeed?FEEDPARAMS=ValidOffertypes|LANGUAGE=EN
 * 
 * Los siguientes tipos son los que vamos a tratar. Sólo se incluyen tipos de
 * over/under que se han visto en los xml o que tengan un nombre tan
 * significativo que se arriesga a tratarlo.
 * 
 * PARTIDO COMPLETO:
 * 
 * <OFFERTYPE ID="52" NAME=" Asia Handicap -1,5/+1,5"/>
 * 
 * <OFFERTYPE ID="54" NAME=" Asia Handicap -1/+1"/>
 * 
 * <OFFERTYPE ID="69" NAME="Asia Handicap  0/0 "/>
 * 
 * <OFFERTYPE ID="68" NAME="Asia Handicap -0,5/+0,5 "/>
 * 
 * <OFFERTYPE ID="53" NAME="Asia Handicap-2/+2"/>
 * 
 * <OFFERTYPE ID="72" NAME="Asia Handicap -2,5/+2,5"/>
 * 
 * <OFFERTYPE ID="74" NAME="Asia Handicap -3,5/+3,5"/>
 * 
 * <OFFERTYPE ID="73" NAME="Asia Handicap -3/+3 "/>
 * 
 * <OFFERTYPE ID="76" NAME="Asia Handicap -4,5/+4,5"/>
 * 
 * <OFFERTYPE ID="75" NAME="Asia Handicap -4/+4"/>
 * 
 * <OFFERTYPE ID="51" NAME="Handicap -0,5/+0,5"/>
 * 
 * <OFFERTYPE ID="32" NAME="Handicap 0:1"/>
 * 
 * <OFFERTYPE ID="78" NAME="Handicap 0:2"/>
 * 
 * <OFFERTYPE ID="79" NAME="Handicap 0:3"/>
 * 
 * <OFFERTYPE ID="80" NAME="Handicap 0:4"/>
 * 
 * <OFFERTYPE ID="81" NAME="Handicap 0:5"/>
 * 
 * <OFFERTYPE ID="82" NAME="Handicap 0:6"/>
 * 
 * <OFFERTYPE ID="9905747" NAME="Handicap 0:7"/>
 * 
 * <OFFERTYPE ID="47" NAME="Handicap 1,5"/>
 * 
 * <OFFERTYPE ID="5" NAME="Handicap 1:0"/>
 * 
 * <OFFERTYPE ID="9905353" NAME="Handicap 1:0"/>
 * 
 * <OFFERTYPE ID="77" NAME="Handicap 2"/>
 * 
 * <OFFERTYPE ID="97" NAME="Handicap 2,5 "/>
 * 
 * <OFFERTYPE ID="83" NAME="Handicap 2:0"/>
 * 
 * <OFFERTYPE ID="84" NAME="Handicap 3:0"/>
 * 
 * <OFFERTYPE ID="85" NAME="Handicap 4:0"/>
 * 
 * <OFFERTYPE ID="86" NAME="Handicap 5:0"/>
 * 
 * <OFFERTYPE ID="87" NAME="Handicap 6:0"/>
 * 
 * <OFFERTYPE ID="9905554" NAME="Handicap Rugby"/>
 * 
 * <OFFERTYPE ID="39" NAME="Handicap USA"/>
 * 
 * <OFFERTYPE ID="90" NAME="Handicap USA 0"/>
 * 
 * <OFFERTYPE ID="91" NAME="Handicap USA 0,5"/>
 * 
 * <OFFERTYPE ID="92" NAME="Handicap USA 1,5"/>
 * 
 * <OFFERTYPE ID="9905362" NAME="Handicap USA 2,5"/>
 * 
 * 
 * PARTES:
 * 
 * <OFFERTYPE ID="94" NAME="Handicap USA HT"/>
 * 
 * <OFFERTYPE ID="9946464" NAME="HT Handicap 0:1"/>
 * 
 * 
 * QUARTOS:
 * 
 * <OFFERTYPE ID="9905402" NAME="Handicap USA 1st quarter"/>
 * 
 * <OFFERTYPE ID="9905410" NAME="Handicap USA 1st quarter"/>
 * 
 * <OFFERTYPE ID="9905403" NAME="Handicap USA 2nd quarter "/>
 * 
 * <OFFERTYPE ID="9905405" NAME="Handicap USA 3rd quarter"/>
 * 
 * <OFFERTYPE ID="9905406" NAME="Handicap USA 4th quarter"/>
 * 
 * 
 * SETS:
 * 
 * <OFFERTYPE ID="9905668" NAME="1st set Handicap"/>
 * 
 * <OFFERTYPE ID="9905669" NAME="1st Set Handicap"/>
 * 
 * <OFFERTYPE ID="9905670" NAME="2nd Set Handicap"/>
 * 
 * 
 * 
 * Los siguientes apuestas no se han visto nunca en los xml. Por eso no los
 * vamos a tratar hasta que se ha visto algun ejemplo. Esto se hace siguendo una
 * filosofia de 'mejor leer menos partidos que leer un partido mal y arriesgar
 * machacar algo que se había leido bien'.
 * 
 * <OFFERTYPE ID="9905563" NAME=" LIVE Baseball Handicap"/>
 * 
 * <OFFERTYPE ID="9925493" NAME="Handicap Games "/> De momento no tratamos games
 * en partidos de tennis
 * 
 * <OFFERTYPE ID="9905509" NAME="Handicap Tennis Games"/> De momento no tratamos
 * games en partidos de tennis
 * 
 * <OFFERTYPE ID="9905508" NAME="Handicap Tennis Live"/>
 * 
 * <OFFERTYPE ID="9905492" NAME="Handicap USA Live"/>
 * 
 * <OFFERTYPE ID="9905493" NAME="Handicap USA Live 1"/>
 * 
 * <OFFERTYPE ID="9905494" NAME="Handicap USA Live 2"/>
 * 
 */
class InterwettenHandicapUtil {

	/** The asian handicap game. */
	private static List<Integer> asianHandicapGame;

	/** The handicap first part. */
	private static List<Integer> handicapFirstPart;

	/** The handicap first quarter. */
	private static List<Integer> handicapFirstQuarter;

	/** The handicap first set. */
	private static List<Integer> handicapFirstSet;

	/** The handicap fourth quarter. */
	private static List<Integer> handicapFourthQuarter;

	/** The handicap game. */
	private static List<Integer> handicapGame;

	/** The handicap second quarter. */
	private static List<Integer> handicapSecondQuarter;

	/** The handicap second set. */
	private static List<Integer> handicapSecondSet;

	/** The handicap third quarter. */
	private static List<Integer> handicapThirdQuarter;

	static {
		handicapGame = new ArrayList<Integer>();

		handicapGame.add(5);
		handicapGame.add(39);
		handicapGame.add(47);
		handicapGame.add(51);
		handicapGame.add(32);
		handicapGame.add(77);
		handicapGame.add(78);
		handicapGame.add(79);
		handicapGame.add(80);
		handicapGame.add(81);
		handicapGame.add(82);
		handicapGame.add(83);
		handicapGame.add(84);
		handicapGame.add(85);
		handicapGame.add(86);
		handicapGame.add(87);
		handicapGame.add(90);
		handicapGame.add(91);
		handicapGame.add(92);
		handicapGame.add(97);
		handicapGame.add(9905353);
		handicapGame.add(9905362);
		handicapGame.add(9905554);
		handicapGame.add(9905747);
	}

	static {
		asianHandicapGame = new ArrayList<Integer>();
		asianHandicapGame.add(52);
		asianHandicapGame.add(53);
		asianHandicapGame.add(54);
		asianHandicapGame.add(68);
		asianHandicapGame.add(69);
		asianHandicapGame.add(72);
		asianHandicapGame.add(73);
		asianHandicapGame.add(74);
		asianHandicapGame.add(75);
		asianHandicapGame.add(76);
	}

	static {
		handicapFirstQuarter = new ArrayList<Integer>();
		handicapFirstQuarter.add(9905402);
		handicapFirstQuarter.add(9905410);
	}

	static {
		handicapFourthQuarter = new ArrayList<Integer>();
		handicapFourthQuarter.add(9905406);
	}

	static {
		handicapFirstPart = new ArrayList<Integer>();
		handicapFirstPart.add(94);
		handicapFirstPart.add(9946464);
	}

	static {
		handicapSecondQuarter = new ArrayList<Integer>();
		handicapSecondQuarter.add(9905403);
	}

	static {
		handicapThirdQuarter = new ArrayList<Integer>();
		handicapThirdQuarter.add(9905405);
	}

	static {
		handicapFirstSet = new ArrayList<Integer>();
		handicapFirstSet.add(9905668);
		handicapFirstSet.add(9905669);
	}

	static {
		handicapSecondSet = new ArrayList<Integer>();
		handicapSecondSet.add(9905670);
	}

	/**
	 * Gets the first handicap.
	 * 
	 * @param bets
	 *            the bets
	 * @return the first handicap
	 * @throws InterwettenUnknowHandicapNodeStructureException
	 *             the interwetten unknow handicap exception
	 * @throws InterwettenHandicapException
	 *             the interwetten handicap exception
	 */
	public static Double getFirstHandicap(final List<BET> bets)
			throws InterwettenUnknowHandicapNodeStructureException,
			InterwettenHandicapException {
		Double result = null;
		Integer stringPosition;
		String handicap = null;
		BET bet;

		bet = bets.get(0);

		try {
			if (!bet.getPLAYER1().contains("(")
					&& bet.getTYPENAME().contains(":")) {
				// <BET /../ TYPENAME="Handicap 0:1" />
				handicap = bet.getTYPENAME();
				stringPosition = handicap.indexOf(":");
				handicap = handicap.substring(stringPosition - 2,
						handicap.length());
				Double handicapAux1 = Double.parseDouble(handicap.substring(0,
						2));
				Double HandicapAux2 = Double.parseDouble(handicap.substring(3,
						4));
				result = handicapAux1 - HandicapAux2;
			} else if (bet.getPLAYER1().contains("(")
					&& bet.getPLAYER1().contains(")")) {
				// <BET /../ PLAYER1="KC Royals(+6)" />
				handicap = bet.getPLAYER1();
				stringPosition = handicap.indexOf("(");
				handicap = handicap.substring(handicap.indexOf("(") + 1,
						handicap.indexOf(")")).replace(",", ".");
				result = Double.parseDouble(handicap);
			} else if (bet.getTYPEID() == 51) {
				result = 0.5d;
			} else {
				throw new InterwettenUnknowHandicapNodeStructureException(
						new StringBuffer()
								.append("No es posible reconocer la estructura de la informacion del handicap en el siguiente nodo:\n ")
								.append(bet).toString());
			}
		} catch (NumberFormatException e) {
			throw new InterwettenHandicapException(
					new StringBuffer()
							.append("No ha sido posible determinar el valor del handicap a partir del siguiente string: ")
							.append(handicap)
							.append(" que se ha sacado del siguiente nodo:\n")
							.append(bet).toString());
		}

		return result;
	}

	/**
	 * Gets the handicap bet event.
	 * 
	 * @param typeId
	 *            the type id
	 * @return the handicap bet event
	 * @throws InterwettenBetTypeEventNotFoundException
	 *             the interwetten bet type event not found exception
	 */
	public static BetTypeEventInterwetten getHandicapBetEvent(Integer typeId)
			throws InterwettenBetTypeEventNotFoundException {
		BetTypeEventInterwetten result;
		if (isHandicapGame(typeId) || isAsianHandicap(typeId)) {
			result = BetTypeEventInterwetten.PARTIDO_COMPLETO;
		} else if (isHandicapFirstPart(typeId)) {
			result = BetTypeEventInterwetten.PRIMERA_PARTE;
		} else if (isHandicapFirstQuarter(typeId)) {
			result = BetTypeEventInterwetten.PRIMER_CUARTO;
		} else if (isHandicapSecondQuarter(typeId)) {
			result = BetTypeEventInterwetten.SEGUNDO_CUARTO;
		} else if (isHandicapThirdQuarter(typeId)) {
			result = BetTypeEventInterwetten.TERCER_CUARTO;
		} else if (isHandicapFourthQuarter(typeId)) {
			result = BetTypeEventInterwetten.CUARTO_CUARTO;
		} else if (isHandicapFirstSet(typeId)) {
			result = BetTypeEventInterwetten.PRIMER_SET;
		} else if (isHandicapSecondSet(typeId)) {
			result = BetTypeEventInterwetten.SEGUNDO_SET;
		} else {
			throw new InterwettenBetTypeEventNotFoundException();
		}
		return result;
	}

	/**
	 * Gets the second handicap.
	 * 
	 * @param bets
	 *            the bets
	 * @return the second handicap
	 * @throws InterwettenUnknowHandicapNodeStructureException
	 *             the interwetten unknow handicap exception
	 */
	public static Double getSecondHandicap(final List<BET> bets)
			throws InterwettenUnknowHandicapNodeStructureException {
		Double result = null;
		BET bet = bets.get(0);
		if (bet.getTYPEID() == 51) {
			result = 0d;
			result = +0.5d;
		}
		return result;
	}

	/**
	 * Checks if is asian handicap.
	 * 
	 * @param integer
	 *            the integer
	 * @return the boolean
	 */
	private static Boolean isAsianHandicap(Integer integer) {
		return asianHandicapGame.contains(integer);
	}

	/**
	 * Checks if is asian handicap.
	 * 
	 * @param integer
	 *            the integer
	 * @param bets
	 *            the bets
	 * @return the boolean
	 */
	public static Boolean isAsianHandicap(Integer integer, List<BET> bets) {
		Boolean result = Boolean.FALSE;
		if (bets.size() == 2
				&& (isHandicap(integer) || isAsianHandicap(integer))) {
			result = Boolean.TRUE;
		}
		return result;
	}

	/**
	 * Checks if is handicap.
	 * 
	 * @param integer
	 *            the integer
	 * @return the boolean
	 */
	public static Boolean isHandicap(Integer integer) {
		Boolean result = Boolean.FALSE;
		if (handicapGame.contains(integer)
				|| handicapFirstPart.contains(integer)
				|| handicapFirstQuarter.contains(integer)
				|| handicapSecondQuarter.contains(integer)
				|| handicapThirdQuarter.contains(integer)
				|| handicapFourthQuarter.contains(integer)
				|| handicapFirstSet.contains(integer)
				|| handicapSecondSet.contains(integer)) {
			result = Boolean.TRUE;
		}
		return result;
	}

	/**
	 * Checks if is handicap1 x2.
	 * 
	 * @param integer
	 *            the integer
	 * @param bets
	 *            the bets
	 * @return the boolean
	 */
	public static Boolean isHandicap1X2(Integer integer, List<BET> bets) {
		Boolean result = Boolean.FALSE;
		if (bets.size() == 3 && isHandicap(integer)) {
			result = Boolean.TRUE;
		}
		return result;
	}

	/**
	 * Checks if is handicap first part.
	 * 
	 * @param integer
	 *            the integer
	 * @return the boolean
	 */
	public static Boolean isHandicapFirstPart(Integer integer) {
		return handicapFirstPart.contains(integer);
	}

	/**
	 * Checks if is handicap first quarter.
	 * 
	 * @param integer
	 *            the integer
	 * @return the boolean
	 */
	public static Boolean isHandicapFirstQuarter(Integer integer) {
		return handicapFirstQuarter.contains(integer);
	}

	/**
	 * Checks if is handicap first setp.
	 * 
	 * @param integer
	 *            the integer
	 * @return the boolean
	 */
	public static Boolean isHandicapFirstSet(Integer integer) {
		return handicapFirstSet.contains(integer);
	}

	/**
	 * Checks if is handicap fourth quarter.
	 * 
	 * @param integer
	 *            the integer
	 * @return the boolean
	 */
	public static Boolean isHandicapFourthQuarter(Integer integer) {
		return handicapFourthQuarter.contains(integer);
	}

	/**
	 * Checks if is handicap game.
	 * 
	 * @param integer
	 *            the integer
	 * @return the boolean
	 */
	public static Boolean isHandicapGame(Integer integer) {
		return handicapGame.contains(integer);
	}

	/**
	 * Checks if is handicap second quarter.
	 * 
	 * @param integer
	 *            the integer
	 * @return the boolean
	 */
	public static Boolean isHandicapSecondQuarter(Integer integer) {
		return handicapSecondQuarter.contains(integer);
	}

	/**
	 * Checks if is handicap second setp.
	 * 
	 * @param integer
	 *            the integer
	 * @return the boolean
	 */
	public static Boolean isHandicapSecondSet(Integer integer) {
		return handicapSecondSet.contains(integer);
	}

	/**
	 * Checks if is handicap third quarter.
	 * 
	 * @param integer
	 *            the integer
	 * @return the boolean
	 */
	public static Boolean isHandicapThirdQuarter(Integer integer) {
		return handicapThirdQuarter.contains(integer);
	}
}
