/**
 *
 * Copyright (C) FACTORIA ETSIA S.L.
 * All Rights Reserved.
 * www.factoriaetsia.com
 *
 */
package com.comparadorad.bet.comparer.model.config.repository.writer;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import com.comparadorad.bet.comparer.model.config.bean.CfgSport;
import com.comparadorad.bet.comparer.model.config.bean.CfgSportSynonyms;
import com.comparadorad.bet.comparer.model.core.bean.CoreActiveElement;
import com.comparadorad.bet.comparer.util.commons.locale.LocaleUtil;

/**
 * The Class CfgSportWriter.
 */
public class CfgSportWriter extends
		AbstractSynonymsWriterXML<List<CfgSport>, CfgSportSynonyms> {

	/**
	 * Adds the sport.
	 * 
	 * @param cfgSport
	 *            the cfg sport
	 * @param result
	 *            the result
	 */
	protected void addSport(CfgSport cfgSport, List<CfgSport> result) {
		// cfgSport.setHistoricCreationData(getWriterAppUser());
		result.add(cfgSport);
	}

	/**
	 * Adds the sport.
	 * 
	 * @param id
	 *            the id
	 * @param code
	 *            the code
	 * @param nameEs
	 *            the name es
	 * @param nameEn
	 *            the name en
	 * @param nameCat
	 *            the name cat
	 * @param nameFr
	 *            the name fr
	 * @param nameSw
	 *            the name sw
	 * @param creationDate
	 *            the creation date
	 * @param result
	 *            the result
	 * @param active
	 *            the active
	 * @param configured
	 *            the configured
	 * @param hashkeyParticipants
	 *            the hashkey participants
	 * @param sinonyms
	 *            the sinonyms
	 */
	protected void addSport(String id, String code, String nameEs,
			String nameEn, String nameCat, String nameFr, String nameSw,
			String creationDate, List<CfgSport> result, Boolean active,
			Boolean configured, Boolean hashkeyParticipants, String... sinonyms) {
		CfgSport cfgSport = new CfgSport();
		cfgSport.setObjectId(id);
		cfgSport.setCode(code);

		cfgSport.setHistoricCreationData(getWriterAppUser(),
				getWriterAppDate(creationDate));
		CfgSportSynonyms sportSynonyms = new CfgSportSynonyms();
		sportSynonyms.setHistoricCreationData(getWriterAppUser(),
				getWriterAppDate(creationDate));
		sportSynonyms.setRelatedDocument(new CfgSport(cfgSport.getObjectId()));
		sportSynonyms.setObjectId(cfgSport.getObjectId());

		setName(cfgSport, sportSynonyms, nameEs, LocaleUtil.SPANISH);
		setName(cfgSport, sportSynonyms, nameEn, Locale.ENGLISH);
		setName(cfgSport, sportSynonyms, nameCat, LocaleUtil.CATALONIAN);
		setName(cfgSport, sportSynonyms, nameFr, Locale.FRENCH);
		setName(cfgSport, sportSynonyms, nameSw, LocaleUtil.SWEDISH);
		for (String synonym : sinonyms) {
			sportSynonyms.addSynonimWord(synonym);
		}
		getSynonymsList().add(sportSynonyms);
		CoreActiveElement coreActiveElement = new CoreActiveElement(active);
		cfgSport.setCoreActiveElement(coreActiveElement);
		cfgSport.setConfigured(configured);
		cfgSport.setHashKeyParticipants(hashkeyParticipants);
		addSport(cfgSport, result);
	}

	/**
	 * Checks if is extended.
	 * 
	 * @return true, if is extended {@inheritDoc}
	 */
	@Override
	protected boolean isExtended() {
		return false;
	}

	/**
	 * Make object.
	 * 
	 * @return the list {@inheritDoc}
	 */
	@Override
	protected List<CfgSport> makeObject() {
		List<CfgSport> result = new ArrayList<CfgSport>();
		addSport("1", "football", "Fútbol", "Football", "Futbol", "Football",
				"fotboll", "26/09/2011", result, Boolean.TRUE, Boolean.TRUE,
				Boolean.FALSE);
		addSport("2", "basketball", "Baloncesto", "Basketball", "Bàsquet",
				"Basket-ball", "Basket", "26/09/2011", result, Boolean.TRUE,
				Boolean.TRUE, Boolean.FALSE);
		addSport("3", "tennis", "Tenis", "Tennis", "Tennis", "Tenis", "Tennis",
				"26/09/2011", result, Boolean.TRUE, Boolean.TRUE, Boolean.FALSE);
		addSport("4", "paddle", "Pádel", "Paddle", "Pàdel", "Paddle", "Paddle",
				"26/09/2011", result, Boolean.TRUE, Boolean.FALSE,
				Boolean.FALSE);
		addSport("5", "table_tennis", "Tenis de mesa", "Table tennis",
				"Tenis taula", "Table tennis", "Table tennis", "26/09/2011",
				result, Boolean.TRUE, Boolean.FALSE, Boolean.FALSE);
		addSport("6", "f1", "F1", "F1", "F1", "F1", "F1", "26/09/2011", result,
				Boolean.TRUE, Boolean.TRUE, Boolean.FALSE);
		addSport("7", "motorcycling", "Motociclismo", "Motorcycling",
				"Motociclisme", "Motorcycling", "Motorcycling", "26/09/2011",
				result, Boolean.TRUE, Boolean.TRUE, Boolean.FALSE);
		addSport("8", "rally", "Rally", "Rally", "Ral·li", "Rally", "Rally",
				"26/09/2011", result, Boolean.TRUE, Boolean.TRUE, Boolean.FALSE);
		addSport("9", "nascar", "Náscar", "Nascar", "Nàscar", "Nascar",
				"Nascar", "26/09/2011", result, Boolean.TRUE, Boolean.TRUE,
				Boolean.FALSE);
		addSport("10", "darts", "Dardos", "Darts", "Dards", "Darts", "Darts",
				"26/09/2011", result, Boolean.TRUE, Boolean.FALSE,
				Boolean.FALSE);
		addSport("11", "snooker", "Snooker", "Snooker", "Snooker", "Snooker",
				"Snooker", "26/09/2011", result, Boolean.TRUE, Boolean.FALSE,
				Boolean.FALSE);
		addSport("12", "golf", "Golf", "Golf", "Golf", "Golf", "Golf",
				"26/09/2011", result, Boolean.TRUE, Boolean.FALSE,
				Boolean.FALSE);
		addSport("13", "athletics", "Atletismo", "Athletics", "Atletisme",
				"Athletics", "Athletics", "26/09/2011", result, Boolean.TRUE,
				Boolean.FALSE, Boolean.FALSE);
		addSport("14", "cycling", "Ciclismo", "Cycling", "Ciclisme", "Cycling",
				"Cycling", "26/09/2011", result, Boolean.TRUE, Boolean.TRUE,
				Boolean.TRUE);
		addSport("15", "triathlon", "Triatlón", "Triathlon", "Triatló",
				"Triathlon", "Triathlon", "26/09/2011", result, Boolean.TRUE,
				Boolean.FALSE, Boolean.FALSE);
		addSport("16", "greyhounds", "Carreras de galgos", "Greyhounds",
				"Curses de galgos", "Greyhounds", "Greyhounds", "26/09/2011",
				result, Boolean.TRUE, Boolean.FALSE, Boolean.FALSE);
		addSport("17", "horse_racing", "Carreras de caballos", "Horse Racing",
				"Curses de cavalls", "Horse Racing", "Horse Racing",
				"26/09/2011", result, Boolean.TRUE, Boolean.FALSE,
				Boolean.FALSE);
		addSport("18", "handball", "Balonmano", "Handball", "Handbol",
				"Handball", "Handball", "26/09/2011", result, Boolean.TRUE,
				Boolean.TRUE, Boolean.FALSE);
		addSport("19", "volleyball", "Voleibol", "Volleyball", "Voleibol",
				"Voleibol", "Voleibol", "26/09/2011", result, Boolean.TRUE,
				Boolean.FALSE, Boolean.FALSE);
		addSport("20", "boxing", "Boxeo", "Boxing", "Boxa", "Boxing", "Boxing",
				"26/09/2011", result, Boolean.TRUE, Boolean.FALSE,
				Boolean.FALSE);
		addSport("21", "combatSports", "Deportes de combate", "Combat sports",
				"Esports de lluita", "Combat sports", "Combat sports",
				"26/09/2011", result, Boolean.TRUE, Boolean.FALSE,
				Boolean.FALSE);
		addSport("22", "cross_country_skiing", "Esquí de fondo",
				"Cross-country skiing", "Esquí de fons",
				"Cross-country skiing", "Cross-country skiing", "26/09/2011",
				result, Boolean.TRUE, Boolean.FALSE, Boolean.FALSE);
		addSport("23", "ski", "Esquí", "Ski", "Esquí", "Ski", "Ski",
				"26/09/2011", result, Boolean.TRUE, Boolean.FALSE,
				Boolean.FALSE);
		addSport("24", "ice_hockey", "Hockey sobre hielo", "Ice hockey",
				"Hoquei sobre gel", "Ice hockey", "Ice hockey", "26/09/2011",
				result, Boolean.TRUE, Boolean.TRUE, Boolean.FALSE);
		addSport("25", "cricket", "Cricket", "Cricket", "Cricket", "Cricket",
				"Cricket", "26/09/2011", result, Boolean.TRUE, Boolean.FALSE,
				Boolean.FALSE);
		addSport("26", "american_fotball", "Fútbol americano",
				"American football", "Futbol americà", "American football",
				"American football", "26/09/2011", result, Boolean.TRUE,
				Boolean.TRUE, Boolean.FALSE);
		addSport("27", "baseball", "Béisbol", "Baseball", "Beisbol",
				"Baseball", "Baseball", "26/09/2011", result, Boolean.TRUE,
				Boolean.TRUE, Boolean.FALSE);
		addSport("28", "rowing", "Remo", "Rowing", "Rem", "Rowing", "Rowing",
				"26/09/2011", result, Boolean.TRUE, Boolean.FALSE,
				Boolean.FALSE);
		addSport("29", "lacrosse", "Lacrosse", "Lacrosse", "Lacrosse",
				"Lacrosse", "Lacrosse", "26/09/2011", result, Boolean.TRUE,
				Boolean.FALSE, Boolean.FALSE);
		addSport("30", "aussie_rules", "Aussie Rules", "Aussie Rules",
				"Aussie Rules", "Aussie Rules", "Aussie Rules", "26/09/2011",
				result, Boolean.TRUE, Boolean.FALSE, Boolean.FALSE);
		addSport("31", "cycling", "Ciclismo", "Cycling", "Ciclisme", "Cycling",
				"Cycling", "26/09/2011", result, Boolean.TRUE, Boolean.TRUE,
				Boolean.FALSE);
		addSport("32", "rugby_league", "Rugby League", "Rugby League",
				"Rugby League", "Rugby League", "Rugby League", "26/09/2011",
				result, Boolean.TRUE, Boolean.TRUE, Boolean.FALSE);
		return result;

	}

	/**
	 * Sets the name.
	 * 
	 * @param sport
	 *            the sport
	 * @param sportSynonyms
	 *            the sport synonyms
	 * @param name
	 *            the name
	 * @param locale
	 *            the locale
	 */
	private void setName(CfgSport sport, CfgSportSynonyms sportSynonyms,
			String name, Locale locale) {
		if (name != null) {
			sport.setName(name, locale);
			sportSynonyms.addSynonimWord(name);
		}
	}

}
