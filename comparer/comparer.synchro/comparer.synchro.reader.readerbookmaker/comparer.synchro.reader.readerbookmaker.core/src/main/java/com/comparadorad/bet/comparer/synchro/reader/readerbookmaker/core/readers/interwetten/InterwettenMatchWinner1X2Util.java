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
 * The Class InterwettenMatchWinner1X2Util. Se obtiene informacion de la url:
 * http://ad.interwetten.com/XMLFeeder/feeder.asmx
 * /getfeed?FEEDPARAMS=ValidOffertypes|LANGUAGE=EN
 * 
 * Los siguientes tipos son los que vamos a tratar. Sólo se incluyen tipos de
 * 1x2/ganador partido que se han visto en los xml o que tengan un nombre tan
 * significativo que se arriesga a tratarlo.
 * 
 * El id 9919219 (Winning Team) se asocia a partido completo con prorroga y se
 * tendria en cuenta para el deporte hockey que hasta el momento es el unico
 * deporte donde se ha detectado su uso.
 * 
 * PARTIDO COMPLETO:
 * 
 * <OFFERTYPE ID="13" NAME="Match"/>
 * 
 * <OFFERTYPE ID="9905357" NAME="Match NHL"/>
 * 
 * PARTIDO COMPLETO Y PRORROGA:
 * 
 * <OFFERTYPE ID="9905472"
 * NAME="Game (including Overtime and Penalty Shootout) "/>
 * 
 * <OFFERTYPE ID="9919219" NAME="Winning Team"/>
 * 
 * PARTES:
 * 
 * <OFFERTYPE ID="9905365" NAME="1st periode"/>
 * 
 * <OFFERTYPE ID="9905552" NAME="2nd period"/>
 * 
 * <OFFERTYPE ID="9905553" NAME="3rd period"/>
 * 
 * <OFFERTYPE ID="12" NAME="HalfTime"/>
 * 
 * SETS:
 * 
 * <OFFERTYPE ID="9905505" NAME="1st set"/>
 * 
 * <OFFERTYPE ID="9905506" NAME="2nd set"/>
 * 
 * <OFFERTYPE ID="9905507" NAME="3rd set"/>
 * 
 * <OFFERTYPE ID="9905517" NAME="4th set"/>
 * 
 * <OFFERTYPE ID="9905724" NAME="5th set"/>
 * 
 * QUARTOS:
 * 
 * 
 * ENTRADAS:
 * 
 * 
 * Los siguientes apuestas no se han visto nunca en los xml. Por eso no los
 * vamos a tratar hasta que se ha visto algun ejemplo. Esto se hace siguendo una
 * filosofia de 'mejor leer menos partidos que leer un partido mal y arriesgar
 * machacar algo que se había leido bien'.
 * 
 * 
 */
public class InterwettenMatchWinner1X2Util {

	/** The fifth set match winner1 x2. */
	private static List<Integer> fifthSetMatchWinner1X2;

	/** The first part match winner1 x2. */
	private static List<Integer> firstPartMatchWinner1X2;

	/** The first set match winner1 x2. */
	private static List<Integer> firstSetMatchWinner1X2;

	/** The fourth set match winner1 x2. */
	private static List<Integer> fourthSetMatchWinner1X2;

	/** The game match winner1 x2. */
	private static List<Integer> gameMatchWinner1X2;

	/** The overtime match winner1 x2. */
	private static List<Integer> overtimeMatchWinner1X2;

	/** The second part match winner1 x2. */
	private static List<Integer> secondPartMatchWinner1X2;

	/** The second set match winner1 x2. */
	private static List<Integer> secondSetMatchWinner1X2;

	/** The third part match winner1 x2. */
	private static List<Integer> thirdPartMatchWinner1X2;

	/** The third set match winner1 x2. */
	private static List<Integer> thirdSetMatchWinner1X2;

	/** The match winner overtime 1 2. */
	private static List<Integer> overtimeMatchWinner;

	static {

		gameMatchWinner1X2 = new ArrayList<Integer>();
		gameMatchWinner1X2.add(13);
		gameMatchWinner1X2.add(9905357);

		overtimeMatchWinner1X2 = new ArrayList<Integer>();
		overtimeMatchWinner1X2.add(9905472);

		overtimeMatchWinner = new ArrayList<Integer>();
		overtimeMatchWinner.add(9919219);

		firstPartMatchWinner1X2 = new ArrayList<Integer>();
		firstPartMatchWinner1X2.add(12);
		firstPartMatchWinner1X2.add(9905365);

		thirdPartMatchWinner1X2 = new ArrayList<Integer>();
		thirdPartMatchWinner1X2.add(9905553);

		secondPartMatchWinner1X2 = new ArrayList<Integer>();
		secondPartMatchWinner1X2.add(9905552);

		firstSetMatchWinner1X2 = new ArrayList<Integer>();
		firstSetMatchWinner1X2.add(9905505);

		secondSetMatchWinner1X2 = new ArrayList<Integer>();
		secondSetMatchWinner1X2.add(9905506);

		thirdSetMatchWinner1X2 = new ArrayList<Integer>();
		thirdSetMatchWinner1X2.add(9905507);

		fourthSetMatchWinner1X2 = new ArrayList<Integer>();
		fourthSetMatchWinner1X2.add(9905517);

		fifthSetMatchWinner1X2 = new ArrayList<Integer>();
		fifthSetMatchWinner1X2.add(9905724);

	}

	/**
	 * Gets the match winner1 x2 bet event.
	 * 
	 * @param typeId
	 *            the type id
	 * @return the match winner1 x2 bet event
	 * @throws InterwettenBetTypeEventNotFoundException
	 *             the interwetten bet type event exception
	 */
	public static BetTypeEventInterwetten getMatchWinner1X2BetEvent(
			Integer typeId) throws InterwettenBetTypeEventNotFoundException {
		BetTypeEventInterwetten result;
		if (isGameMatchWinner1X2(typeId)) {
			result = BetTypeEventInterwetten.PARTIDO_COMPLETO;
		} else if (isOvertimeMatchWinner1X2(typeId) || isOvertimeMatchWinner(typeId)) {
			result = BetTypeEventInterwetten.PARTIDO_COMPLETO_PRORROGA;
		} else if (isFirstPartMatchWinner1X2(typeId)) {
			result = BetTypeEventInterwetten.PRIMERA_PARTE;
		} else if (isSecondPartMatchWinner1X2(typeId)) {
			result = BetTypeEventInterwetten.SEGUNDA_PARTE;
		} else if (isThirdPartMatchWinner1X2(typeId)) {
			result = BetTypeEventInterwetten.TERCERA_PARTE;
		} else if (isFirstSetMatchWinner1X2(typeId)) {
			result = BetTypeEventInterwetten.PRIMER_SET;
		} else if (isSecondSetMatchWinner1X2(typeId)) {
			result = BetTypeEventInterwetten.SEGUNDO_SET;
		} else if (isThirdSetMatchWinner1X2(typeId)) {
			result = BetTypeEventInterwetten.TERCER_SET;
		} else if (isFourthSetMatchWinner1X2(typeId)) {
			result = BetTypeEventInterwetten.CUARTO_SET;
		} else if (isFifthSetMatchWinner1X2(typeId)) {
			result = BetTypeEventInterwetten.QUINTO_SET;
		} else {
			throw new InterwettenBetTypeEventNotFoundException();
		}
		return result;
	}

	/**
	 * Is1 x2.
	 * 
	 * @param number
	 *            the number
	 * @param bets
	 *            the bets
	 * @return the boolean
	 */
	public static Boolean is1X2(Integer number, List<BET> bets) {
		Boolean result = Boolean.FALSE;
		if (bets.size() == 3 && isMatchWinner1X2(number)) {
			result = Boolean.TRUE;
		}
		return result;
	}

	/**
	 * Checks if is fifth set match winner1 x2.
	 * 
	 * @param integer
	 *            the integer
	 * @return the boolean
	 */
	public static Boolean isFifthSetMatchWinner1X2(Integer integer) {
		return fifthSetMatchWinner1X2.contains(integer);
	}

	/**
	 * Checks if is first part match winner1 x2.
	 * 
	 * @param integer
	 *            the integer
	 * @return the boolean
	 */
	public static Boolean isFirstPartMatchWinner1X2(Integer integer) {
		return firstPartMatchWinner1X2.contains(integer);
	}

	/**
	 * Checks if is first set match winner1 x2.
	 * 
	 * @param integer
	 *            the integer
	 * @return the boolean
	 */
	public static Boolean isFirstSetMatchWinner1X2(Integer integer) {
		return firstSetMatchWinner1X2.contains(integer);
	}

	/**
	 * Checks if is fourth set match winner1 x2.
	 * 
	 * @param integer
	 *            the integer
	 * @return the boolean
	 */
	public static Boolean isFourthSetMatchWinner1X2(Integer integer) {
		return fourthSetMatchWinner1X2.contains(integer);
	}

	/**
	 * Checks if is game match winner1 x2.
	 * 
	 * @param integer
	 *            the integer
	 * @return the boolean
	 */
	public static Boolean isGameMatchWinner1X2(Integer integer) {
		return gameMatchWinner1X2.contains(integer);
	}

	/**
	 * Checks if is match winner.
	 * 
	 * @param number
	 *            the number
	 * @param bets
	 *            the bets
	 * @return the boolean
	 */
	public static Boolean isMatchWinner(Integer number, List<BET> bets) {
		Boolean result = Boolean.FALSE;
		if ((bets.size() == 2 && isMatchWinner1X2(number)) || isOvertimeMatchWinner(number)) {
			result = Boolean.TRUE;
		}
		return result;
	}
	
	
	/**
	 * Checks if is match winner including overtime.
	 * 
	 * @param number
	 *            the number
	 * @param bets
	 *            the bets
	 * @return the boolean
	 */
	public static Boolean isOvertimeMatchWinner (Integer number){
		return overtimeMatchWinner.contains(number);
	}

	/**
	 * Checks if is match winner1 x2.
	 * 
	 * @param number
	 *            the number
	 * @return the boolean
	 */
	public static Boolean isMatchWinner1X2(Integer number) {
		Boolean result = Boolean.FALSE;
		if (isGameMatchWinner1X2(number) || isFirstPartMatchWinner1X2(number)
				|| isSecondPartMatchWinner1X2(number)
				|| isThirdPartMatchWinner1X2(number)
				|| isFirstSetMatchWinner1X2(number)
				|| isSecondSetMatchWinner1X2(number)
				|| isThirdSetMatchWinner1X2(number)
				|| isFourthSetMatchWinner1X2(number)
				|| isFifthSetMatchWinner1X2(number)) {
			result = Boolean.TRUE;
		}
		return result;
	}

	/**
	 * Checks if is game match winner1 x2.
	 * 
	 * @param integer
	 *            the integer
	 * @return the boolean
	 */
	public static Boolean isOvertimeMatchWinner1X2(Integer integer) {
		return overtimeMatchWinner1X2.contains(integer);
	}

	/**
	 * Checks if is second part match winner1 x2.
	 * 
	 * @param integer
	 *            the integer
	 * @return the boolean
	 */
	public static Boolean isSecondPartMatchWinner1X2(Integer integer) {
		return secondPartMatchWinner1X2.contains(integer);
	}

	/**
	 * Checks if is second set match winner1 x2.
	 * 
	 * @param integer
	 *            the integer
	 * @return the boolean
	 */
	public static Boolean isSecondSetMatchWinner1X2(Integer integer) {
		return secondSetMatchWinner1X2.contains(integer);
	}

	/**
	 * Checks if is third part match winner1 x2.
	 * 
	 * @param integer
	 *            the integer
	 * @return the boolean
	 */
	public static Boolean isThirdPartMatchWinner1X2(Integer integer) {
		return thirdPartMatchWinner1X2.contains(integer);
	}

	/**
	 * Checks if is third set match winner1 x2.
	 * 
	 * @param integer
	 *            the integer
	 * @return the boolean
	 */
	public static Boolean isThirdSetMatchWinner1X2(Integer integer) {
		return thirdSetMatchWinner1X2.contains(integer);
	}

}
