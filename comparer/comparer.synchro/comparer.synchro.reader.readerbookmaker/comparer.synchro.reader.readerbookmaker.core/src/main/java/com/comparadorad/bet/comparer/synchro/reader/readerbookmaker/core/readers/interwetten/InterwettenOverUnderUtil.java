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
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.comparadorad.bet.comparer.model.bet.bean.MasMenos;
import com.comparadorad.bet.comparer.synchro.reader.model.XmlMoreLessAttribute;
import com.comparadorad.bet.comparer.synchro.reader.readerbookmaker.bean.interwetten.FEED.KINDOFSPORT.LEAGUE.EVENT.BET;

/**
 * The Class InterwettenUnderOverUtil.
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
 * <OFFERTYPE ID="37" NAME="Over/Under"/>
 * 
 * <OFFERTYPE ID="88" NAME="Over/Under USA"/>
 * 
 * <OFFERTYPE ID="9924972" NAME="Over/Under 0-8/9+"/>
 * 
 * <OFFERTYPE ID="9909057" NAME="over/under EH 0-6"/>
 * 
 * <OFFERTYPE ID="9909043" NAME="over/under EH II"/>
 * 
 * <OFFERTYPE ID="9905356" NAME="Over/Under IceHockey Europe"/>
 * 
 * <OFFERTYPE ID="9944289" NAME="Wieviele Tore 1"/>
 * 
 * <OFFERTYPE ID="9930764" NAME="Wieviele Tore 4"/>
 * 
 * <OFFERTYPE ID="9944288" NAME="Wieviele Tore 5"/>
 * 
 * PARTES:
 * 
 * <OFFERTYPE ID="95" NAME="Over/Under USA Halftime"/>
 * 
 * <OFFERTYPE ID="9953954" NAME="Over/Under1 Periode"/>
 * 
 * <OFFERTYPE ID="9953955" NAME="over/Under2 Periode"/>
 * 
 * <OFFERTYPE ID="9953956" NAME="Over/Under3 Periode"/>
 * 
 * QUARTOS:
 * 
 * <OFFERTYPE ID="9905407" NAME="Over/Under 1st quarter"/>
 * 
 * <OFFERTYPE ID="9905404" NAME="Over/Under 2nd quarter"/>
 * 
 * <OFFERTYPE ID="9905408" NAME="Over/Under 3rd quarter"/>
 * 
 * <OFFERTYPE ID="9905409" NAME="Over/Under 4th quarter"/>
 * 
 * ENTRADAS:
 * 
 * <OFFERTYPE ID="9905690" NAME="Baseball Over/Under 5"/>
 * 
 * Los siguientes apuestas no se han visto nunca en los xml. Por eso no los
 * vamos a tratar hasta que se ha visto algun ejemplo. Esto se hace siguendo una
 * filosofia de 'mejor leer menos partidos que leer un partido mal y arriesgar
 * machacar algo que se había leido bien'.
 * 
 * <OFFERTYPE ID="9905490" NAME="Over/Under Live"/>
 * 
 * <OFFERTYPE ID="9905495" NAME="Over/Under Live"/>
 * 
 * <OFFERTYPE ID="9924796" NAME="OVER/UNDER"/>
 * 
 * <OFFERTYPE ID="9924882" NAME="Over/Under"/>
 * 
 * <OFFERTYPE ID="9905491" NAME="Over/Under 45"/> No se sabe si 45 se refiera a
 * 45 minutos (que sería primera o segunda parte en un partido de fútbol, o a 45
 * puntos/goles)
 * 
 * <OFFERTYPE ID="9905592" NAME="Over/Under BB"/>
 * 
 * <OFFERTYPE ID="9969743" NAME="over/under EH 0-4"/>
 * 
 * <OFFERTYPE ID="9905745" NAME="Over/Under GM"/>
 * 
 * <OFFERTYPE ID="9905689" NAME="Over/Under Live"/>
 * 
 * <OFFERTYPE ID="9905496" NAME="Over/Under Live 1"/>
 * 
 * <OFFERTYPE ID="9905746" NAME="Over/Under M"/>
 * 
 * <OFFERTYPE ID="9905688" NAME="OVER/UNDER NHL"/>
 * 
 * <OFFERTYPE ID="9905677" NAME="Over/Under Nowitzki"/>
 * 
 * <OFFERTYPE ID="9905678" NAME="Over/Under Papadopoulos"/>
 * 
 * <OFFERTYPE ID="9939847" NAME="over/under Player"/>
 * 
 * <OFFERTYPE ID="9905679" NAME="Over/Under Roller"/>
 * 
 * <OFFERTYPE ID="9905680" NAME="Over/Under Spanoulis"/>
 * 
 */
class InterwettenOverUnderUtil {

	/** The first five innings under over. */
	private static List<Integer> firstFiveInningsUnderOver;

	/** The first part under over. */
	private static List<Integer> firstPartUnderOver;

	/** The first quarter under over. */
	private static List<Integer> firstQuarterUnderOver;

	/** The forth quarter under over. */
	private static List<Integer> forthQuarterUnderOver;

	/** The game under over. */
	private static List<Integer> gameUnderOver;

	/** The Constant GUION. */
	private static final String GUION = "-";

	/** The Constant NO_GOAL. */
	private static final String NO_GOAL = "NO goal";

	/** The Constant OR MORE. */
	private static final String OR_MORE = "or more";

	/** The Constant OVER. */
	private static final String OVER = "Over";

	/** The second part under over. */
	private static List<Integer> secondPartUnderOver;

	/** The second quarter under over. */
	private static List<Integer> secondQuarterUnderOver;

	/** The third part under over. */
	private static List<Integer> thirdPartUnderOver;

	/** The third quarter under over. */
	private static List<Integer> thirdQuarterUnderOver;

	/** The Constant UNDER. */
	private static final String UNDER = "Under";

	static {

		gameUnderOver = new ArrayList<Integer>();
		gameUnderOver.add(37);
		gameUnderOver.add(88);
		gameUnderOver.add(9909057);
		gameUnderOver.add(9924972);
		gameUnderOver.add(9909043);
		gameUnderOver.add(9905356);
		gameUnderOver.add(9930764);
		gameUnderOver.add(9944288);
		gameUnderOver.add(9944289);

		firstQuarterUnderOver = new ArrayList<Integer>();
		firstQuarterUnderOver.add(9905407);

		secondQuarterUnderOver = new ArrayList<Integer>();
		secondQuarterUnderOver.add(9905404);

		thirdQuarterUnderOver = new ArrayList<Integer>();
		thirdQuarterUnderOver.add(9905408);

		forthQuarterUnderOver = new ArrayList<Integer>();
		forthQuarterUnderOver.add(9905409);

		firstPartUnderOver = new ArrayList<Integer>();
		firstPartUnderOver.add(9953954);
		firstPartUnderOver.add(9953955);
		firstPartUnderOver.add(9953956);

		secondPartUnderOver = new ArrayList<Integer>();
		secondPartUnderOver.add(95);

		thirdPartUnderOver = new ArrayList<Integer>();

		firstFiveInningsUnderOver = new ArrayList<Integer>();
		firstFiveInningsUnderOver.add(9905690);
	}

	/**
	 * Delete character.
	 * 
	 * @param cadena
	 *            the cadena
	 * @param character
	 *            the character
	 * @return the string
	 */
	public static String deleteCharacter(final String cadena,
			final String character) {
		String result = cadena;

		final String patronABuscar = new StringBuffer().append("[")
				.append(character).append("]").toString();
		Pattern patron = Pattern.compile(patronABuscar);
		Matcher matcher = patron.matcher(result);

		result = matcher.replaceAll("");

		return result;
	}

	/**
	 * Atributte more less.
	 * 
	 * @param bet
	 *            the bet
	 * @return the xml more less attribute
	 */
	public static XmlMoreLessAttribute getOverUnderAttribute(BET bet) {
		XmlMoreLessAttribute result = new XmlMoreLessAttribute();
		String tmp;
		if (bet.getPLAYER2().contains(OVER)) {
			// <BET /.../ PLAYER2="Over 156.5"/> --> 156.5
			result.setMasMenos(MasMenos.MAS);
			tmp = deleteCharacter(bet.getPLAYER2(), OVER);
			result.setTotalGoal(Double.valueOf(tmp.trim()));
		} else if (bet.getPLAYER2().contains(UNDER)) {
			// <BET /.../ PLAYER2="Under 156.5"/> --> 156.5
			result.setMasMenos(MasMenos.MENOS);
			tmp = deleteCharacter(bet.getPLAYER2(), UNDER);
			result.setTotalGoal(Double.valueOf(tmp.trim()));
		} else if (bet.getPLAYER2().contains(OR_MORE)) {
			// <BET /../ PLAYER2="3 or more" /> --> 2.5
			result.setMasMenos(MasMenos.MAS);
			tmp = deleteCharacter(bet.getPLAYER2(), OR_MORE);
			result.setTotalGoal(Double.valueOf(tmp.trim()) - 0.5d);
		} else if (bet.getPLAYER2().contains(GUION)) {
			// <BET /../ PLAYER2="0-2" /> --> 2.5
			result.setMasMenos(MasMenos.MENOS);
			tmp = bet.getPLAYER2().split(GUION)[1];
			result.setTotalGoal(Double.valueOf(tmp.trim()) + 0.5d);
		} else if (bet.getPLAYER2().contains(NO_GOAL)) {
			// <BET /../ PLAYER2="NO goal" /> --> 0.5
			result.setMasMenos(MasMenos.MENOS);
			result.setTotalGoal(0.5d);
		}
		return result;
	}

	/**
	 * Gets the over under bet event.
	 * 
	 * @param typeId
	 *            the type id
	 * @return the over under bet event
	 * @throws InterwettenBetTypeEventNotFoundException
	 *             the interwetten bet type event not found exception
	 */
	public static BetTypeEventInterwetten getOverUnderBetEvent(Integer typeId)
			throws InterwettenBetTypeEventNotFoundException {
		BetTypeEventInterwetten result;
		if (isGameUnderOver(typeId)) {
			result = BetTypeEventInterwetten.PARTIDO_COMPLETO;
		} else if (isFirstPartUnderOver(typeId)) {
			result = BetTypeEventInterwetten.PRIMERA_PARTE;
		} else if (isSecondPartUnderOver(typeId)) {
			result = BetTypeEventInterwetten.SEGUNDA_PARTE;
		} else if (isThirdPartUnderOver(typeId)) {
			result = BetTypeEventInterwetten.TERCERA_PARTE;
		} else if (isFirstQuarterUnderOver(typeId)) {
			result = BetTypeEventInterwetten.PRIMER_CUARTO;
		} else if (isSecondQuarterUnderOver(typeId)) {
			result = BetTypeEventInterwetten.SEGUNDO_CUARTO;
		} else if (isThirdQuarterUnderOver(typeId)) {
			result = BetTypeEventInterwetten.TERCER_CUARTO;
		} else if (isForthQuarterUnderOver(typeId)) {
			result = BetTypeEventInterwetten.CUARTO_CUARTO;
		} else if (isFirstFiveInninngsUnderOver(typeId)) {
			result = BetTypeEventInterwetten.CINCO_PRIMERAS_ENTRADAS;
		} else {
			throw new InterwettenBetTypeEventNotFoundException("");
		}
		return result;
	}

	/**
	 * Checks if is first five inninngs under over.
	 * 
	 * @param integer
	 *            the integer
	 * @return the boolean
	 */
	public static Boolean isFirstFiveInninngsUnderOver(Integer integer) {
		return firstFiveInningsUnderOver.contains(integer);
	}

	/**
	 * Checks if is first part time under over.
	 * 
	 * @param integer
	 *            the integer
	 * @return the boolean
	 */
	public static Boolean isFirstPartUnderOver(Integer integer) {
		return firstPartUnderOver.contains(integer);
	}

	/**
	 * Checks if is first quarter under over.
	 * 
	 * @param integer
	 *            the integer
	 * @return the boolean
	 */
	public static Boolean isFirstQuarterUnderOver(Integer integer) {
		return firstQuarterUnderOver.contains(integer);
	}

	/**
	 * Checks if is forth quarter under over.
	 * 
	 * @param integer
	 *            the integer
	 * @return the boolean
	 */
	public static Boolean isForthQuarterUnderOver(Integer integer) {
		return forthQuarterUnderOver.contains(integer);
	}

	/**
	 * Checks if is game under over.
	 * 
	 * @param integer
	 *            the integer
	 * @return the boolean
	 */
	public static Boolean isGameUnderOver(Integer integer) {
		return gameUnderOver.contains(integer);
	}

	/**
	 * Checks if is over under.
	 * 
	 * @param number
	 *            the number
	 * @param bets
	 *            the bets
	 * @return the boolean
	 */
	public static Boolean isOverUnder(Integer number, List<BET> bets) {
		Boolean result = Boolean.FALSE;
		if (bets.size() == 2
				&& (isGameUnderOver(number) || isFirstQuarterUnderOver(number)
						|| isSecondQuarterUnderOver(number)
						|| isThirdQuarterUnderOver(number)
						|| isForthQuarterUnderOver(number)
						|| isFirstPartUnderOver(number)
						|| isSecondPartUnderOver(number)
						|| isThirdPartUnderOver(number) || isFirstFiveInninngsUnderOver(number))) {
			result = Boolean.TRUE;
		}
		return result;
	}

	/**
	 * Checks if is second part time under over.
	 * 
	 * @param integer
	 *            the integer
	 * @return the boolean
	 */
	public static Boolean isSecondPartUnderOver(Integer integer) {
		return secondPartUnderOver.contains(integer);
	}

	/**
	 * Checks if is second quarter under over.
	 * 
	 * @param integer
	 *            the integer
	 * @return the boolean
	 */
	public static Boolean isSecondQuarterUnderOver(Integer integer) {
		return secondQuarterUnderOver.contains(integer);
	}

	/**
	 * Checks if is third part time under over.
	 * 
	 * @param integer
	 *            the integer
	 * @return the boolean
	 */
	public static Boolean isThirdPartUnderOver(Integer integer) {
		return thirdPartUnderOver.contains(integer);
	}

	/**
	 * Checks if is third quarter under over.
	 * 
	 * @param integer
	 *            the integer
	 * @return the boolean
	 */
	public static Boolean isThirdQuarterUnderOver(Integer integer) {
		return thirdQuarterUnderOver.contains(integer);
	}
}
