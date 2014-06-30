package com.comparadorad.bet.comparer.synchro.reader.readerbookmaker.core.readers.pinnacle;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;

/**
 * The Class StringUtilTournamentNamePinnacle. Clase para resolver el nombre de
 * la competicion. El xml de pinnacle indica el nombre de la competicion para un
 * evento especial en dos nodos. Ejemplo1: 'Division Winners: Winner of 2013 AL
 * Central' y 'Winner of 2013 AL Central'. Ejemplo2: 'Player To Win' y 'Player
 * To Win 2013 French Open? (All In)'. Ejemplo3: '100* Puerto Rico Open: Odds To
 * Win The Tournament' y 'Odds To Win Puerto Rico Open'. Estrategia para sacar
 * el nombre de la competicion es: 1) Quitar caracteres especiales. 2) Quitar
 * palabras como 'win', 'the', 'player'. 3) Comparar los dos nombres guardando
 * solo las palabras que tengan en comun. Si no tienen nada en comun elegir uno
 * o otro.
 */
class PinnacleSpecialEventTournamentName {

	/** The Constant REPLACEMENT_STRING. */
	private static final String WHITE_SPACE = " ";

	/** The special characters to omit. */
	private final String[] specialCharactersToOmit = { "-", "?", ":", "*", "(",
			")" };

	/** The words to omit. */
	private final List<String> wordsToOmit = Arrays.asList("all", "country",
			"in", "odds", "player", "season", "team", "the", "to",
			"tournament", "win", "winner", "winners");

	/**
	 * Construct string from array.
	 * 
	 * @param pStringArray
	 *            the string array
	 * @return the string
	 */
	private String constructStringFromArray(List<String> pStringArray) {
		StringBuffer buffer = new StringBuffer();
		for (String s : pStringArray) {
			buffer.append(s);
			buffer.append(WHITE_SPACE);
		}
		return buffer.toString().trim();
	}

	/**
	 * Gets the pinncale tournament name.
	 * 
	 * @param pTournamentName
	 *            the tournament name
	 * @param pTournamentDescription
	 *            the tournament description
	 * @return the pinncale tournament name
	 */
	public String getPinncaleTournamentName(String pTournamentName,
			String pTournamentDescription) {
		String tournamentName = null;

		// 1 - Quitar caracteres especiales
		pTournamentName = omitSpecialCharacters(pTournamentName);
		pTournamentDescription = omitSpecialCharacters(pTournamentDescription);

		// 2 - Quitar palabras
		List<String> pTournamentNameArray = omitWords(pTournamentName
				.split(" "));
		List<String> pTournamentDescriptionArray = omitWords(pTournamentDescription
				.split(" "));

		// 3 - Comparar los dos arrays.
		List<String> pFinalTournamentNameArray = getWordsInCommon(
				pTournamentNameArray, pTournamentDescriptionArray);
		if (pFinalTournamentNameArray.size() != 0) {
			tournamentName = constructStringFromArray(pFinalTournamentNameArray);
		} else if (pTournamentDescriptionArray.size() != 0) {
			tournamentName = constructStringFromArray(pTournamentDescriptionArray);
		} else if (pTournamentNameArray.size() != 0) {
			tournamentName = constructStringFromArray(pTournamentNameArray);
		} else {
			tournamentName = pTournamentDescription;
		}
		return tournamentName;
	}

	/**
	 * Gets the words in common.
	 * 
	 * @param pStringArray1
	 *            the string array1
	 * @param pStringArray2
	 *            the string array2
	 * @return the words in common
	 */
	private List<String> getWordsInCommon(List<String> pStringArray1,
			List<String> pStringArray2) {
		List<String> arrayWithWordsInCommun = new ArrayList<String>();
		for (String wordStringArray2 : pStringArray2) {
			if (pStringArray1.contains(wordStringArray2)) {
				arrayWithWordsInCommun.add(wordStringArray2);
			}
		}
		return arrayWithWordsInCommun;
	}

	/**
	 * Omit special characters.
	 * 
	 * @param pString
	 *            the string
	 * @return the string
	 */
	private String omitSpecialCharacters(String pString) {
		for (String specialChar : specialCharactersToOmit) {
			pString = pString.replace(specialChar, WHITE_SPACE);
			pString = pString.replace("  ", WHITE_SPACE);
			pString = pString.trim();
		}
		return pString;
	}

	/**
	 * Omit words.
	 * 
	 * @param pStringArray
	 *            the string array
	 * @return the string[]
	 */
	private List<String> omitWords(String[] pStringArray) {
		List<String> arrayWithWordsOmitted = new ArrayList<String>();
		for (String word : pStringArray) {
			if (!wordsToOmit.contains(word.toLowerCase(Locale.ENGLISH))) {
				arrayWithWordsOmitted.add(word);
			}
		}
		return arrayWithWordsOmitted;
	}

}