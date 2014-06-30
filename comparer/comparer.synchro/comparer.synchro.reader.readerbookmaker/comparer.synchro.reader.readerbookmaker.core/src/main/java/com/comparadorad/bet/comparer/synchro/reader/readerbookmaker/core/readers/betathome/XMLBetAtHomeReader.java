/**
 *
 * Copyright (C) FACTORIA ETSIA S.L.
 * All Rights Reserved.
 * www.factoriaetsia.com
 *
 */
package com.comparadorad.bet.comparer.synchro.reader.readerbookmaker.core.readers.betathome;

import java.io.InputStream;
import java.text.ParseException;
import java.util.HashSet;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.inject.Inject;
import javax.xml.bind.JAXBException;

import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Component;

import sun.misc.FloatingDecimal;

import com.comparadorad.bet.comparer.model.bet.bean.AsianResult;
import com.comparadorad.bet.comparer.model.bet.bean.IBetEvent;
import com.comparadorad.bet.comparer.model.bet.bean.IBetType;
import com.comparadorad.bet.comparer.model.bet.bean.MasMenos;
import com.comparadorad.bet.comparer.model.bet.bean.Result;
import com.comparadorad.bet.comparer.model.config.bean.CfgBetType.CfgBetTypeId;
import com.comparadorad.bet.comparer.model.config.bean.CfgBetTypeEvent.CfgBetTypeEventId;
import com.comparadorad.bet.comparer.model.config.bean.CfgBookmaker;
import com.comparadorad.bet.comparer.model.config.bean.LongTerm;
import com.comparadorad.bet.comparer.model.config.bean.bmconf.CfgBookmakerConfiguration;
import com.comparadorad.bet.comparer.synchro.reader.model.Xml1X2Attribute;
import com.comparadorad.bet.comparer.synchro.reader.model.Xml1X2HandicapAttribute;
import com.comparadorad.bet.comparer.synchro.reader.model.XmlAsianHandicapAttribute;
import com.comparadorad.bet.comparer.synchro.reader.model.XmlBetEvent;
import com.comparadorad.bet.comparer.synchro.reader.model.XmlBetType;
import com.comparadorad.bet.comparer.synchro.reader.model.XmlBookmakerEvents;
import com.comparadorad.bet.comparer.synchro.reader.model.XmlMarket;
import com.comparadorad.bet.comparer.synchro.reader.model.XmlMarketBet;
import com.comparadorad.bet.comparer.synchro.reader.model.XmlMarketBetOdd;
import com.comparadorad.bet.comparer.synchro.reader.model.XmlMatch;
import com.comparadorad.bet.comparer.synchro.reader.model.XmlMatchParticipant;
import com.comparadorad.bet.comparer.synchro.reader.model.XmlMatchWinnerAttribute;
import com.comparadorad.bet.comparer.synchro.reader.model.XmlMaximumGoalerAttribute;
import com.comparadorad.bet.comparer.synchro.reader.model.XmlMoreLessAttribute;
import com.comparadorad.bet.comparer.synchro.reader.model.XmlSport;
import com.comparadorad.bet.comparer.synchro.reader.model.XmlTournament;
import com.comparadorad.bet.comparer.synchro.reader.model.XmlTournamentEvent;
import com.comparadorad.bet.comparer.synchro.reader.model.XmlWinnerAttribute;
import com.comparadorad.bet.comparer.synchro.reader.readerbookmaker.bean.betathome.List;
import com.comparadorad.bet.comparer.synchro.reader.readerbookmaker.bean.utils.JaxbUtils;
import com.comparadorad.bet.comparer.synchro.reader.readerbookmaker.core.exception.XmlReaderException;
import com.comparadorad.bet.comparer.synchro.reader.readerbookmaker.core.readers.AbstractXmlFilereader;
import com.comparadorad.bet.comparer.synchro.reader.url.maker.bean.BeanAdditionalXmlInfoReader;
import com.comparadorad.bet.comparer.util.logger.core.ComparerWrapperLog;

/**
 * The Class XMLBetAtHomeReader.
 */
@SuppressWarnings("restriction")
@Component
public class XMLBetAtHomeReader extends AbstractXmlFilereader {

	/** The Constant DATE_FORMAT. */
	private static final String DATE_FORMAT = "yyyy-MM-dd HH:mm:SS";

	/** The Constant OTHER. */
	private static final String OTHER = "Other";

	private Set<String> whiteList;

	{
		whiteList = new HashSet<String>();
		whiteList.add("2Way Special");
		whiteList.add("Under/Over 1st half");
		whiteList.add("Under/Over 2nd half");
		whiteList.add("Winner 2nd half");
		whiteList.add("1st third");
	}

	/**
	 * The Enum BetTypeBetatHome.
	 */
	public enum BetTypeBetatHome implements IBetType {

		/** The GANADOR. */
		GANADOR(CfgBetTypeId.GANADOR.nameId(), "Outright"),

		/** The GANADO r_ partido. */
		GANADOR_PARTIDO(CfgBetTypeId.GANADOR_PARTIDO.nameId(), "2W", "2Way Special"),

		/** The MA s_ menos. */
		HANDICAP_ASIATICO(CfgBetTypeId.HANDICAP_ASIATICO.nameId(), "Spread"),

		/** The UN o_ x_ dos. */
		UNO_X_DOS(CfgBetTypeId.UNO_X_DOS.nameId(), "3W", "Winner 2nd half", "1st third"),

		/** The HANDICA p_ asiatico. */
		UNO_X_DOS_HANDICAP(CfgBetTypeId.UNO_X_DOS_HANDICAP.nameId(), "HC"),

		/** The MA s_ menos. */
		MAS_MENOS(CfgBetTypeId.MAS_MENOS.nameId(), "Total", "Under/Over 1st half", "Under/Over 2nd half"),

		/** The MAXIM o_ goleador. */
		MAXIMO_GOLEADOR(CfgBetTypeId.MAXIMO_GOLEADOR.nameId(), "Outright"),

		/** The OTHER. */
		OTHER(CfgBetTypeId.MAXIMO_GOLEADOR.nameId(), "Other");

		/**
		 * Gets the type by value.
		 * 
		 * @param pValue
		 *            the value
		 * @return the type by value
		 */
		public static IBetType getTypeByValue(String pValue) {
			BetTypeBetatHome[] values = BetTypeBetatHome.values();
			for (int i = 0; i < values.length; i++) {
				String[] types = values[i].getTypes();
				for (int j = 1; j < types.length; j++) {
					if (pValue.contains(types[j])) {
						return values[i];
					}
				}
			}
			return null;
		}

		/** The value. */
		private final String[] type;

		/**
		 * Instantiates a new bet type.
		 * 
		 * @param pValue
		 *            the value
		 */
		BetTypeBetatHome(String... pValue) {
			this.type = pValue;
		}

		/**
		 * Gets the id.
		 * 
		 * @return the id {@inheritDoc}
		 */
		@Override
		public String getId() {
			return type[0];
		}

		/**
		 * Gets the types.
		 * 
		 * @return the types {@inheritDoc}
		 */
		@Override
		public String[] getTypes() {
			return type;
		}

	}

	/**
	 * The Enum BetTypeEventBetatHome.
	 */
	public enum BetTypeEventBetatHome implements IBetEvent {

		/** The PARTID o_ completo. */
		PARTIDO_COMPLETO(CfgBetTypeEventId.PARTIDO_COMPLETO.nameId(), "Match Betting"),

		/** The */
		PARTIDO_COMPLETO_PRORROGA(CfgBetTypeEventId.PARTIDO_COMPLETO_PRORROGA.nameId()),

		/** The PRIMER a_ parte. */
		PRIMERA_PARTE(CfgBetTypeEventId.PRIMERA_PARTE.nameId(), "1st halftime", "Under/Over 1st half", "1st third"),

		/** The QUINC e_ minutos. */
		QUINCE_MINUTOS(CfgBetTypeEventId.QUINCE_MINUTOS.nameId(), "15 Minutes Betting"),

		/** The SEGUND a_ parte. */
		SEGUNDA_PARTE(CfgBetTypeEventId.SEGUNDA_PARTE.nameId(), "2nd Half Betting", "Under/Over 2nd half", "Winner 2nd half"),

		/** The TREINT a_ minutos. */
		TREINTA_MINUTOS(CfgBetTypeEventId.TREINTA_MINUTOS.nameId(), "30 Minutes Betting");

		/**
		 * Gets the type by value.
		 * 
		 * @param pValue
		 *            the value
		 * @return the type by value
		 */
		public static IBetEvent getEventByValue(String pValue) {
			BetTypeEventBetatHome[] values = BetTypeEventBetatHome.values();
			for (int i = 0; i < values.length; i++) {
				String[] types = values[i].getEvents();
				for (int j = 1; j < types.length; j++) {
					if (pValue.contains(types[j])) {
						return values[i];
					}
				}
			}
			return null;
		}

		/** The events. */
		private final String[] events;

		/**
		 * Instantiates a new bet event bet click.
		 * 
		 * @param pValue
		 *            the value
		 */
		private BetTypeEventBetatHome(String... pValue) {
			this.events = pValue;
		}

		/**
		 * Gets the events.
		 * 
		 * @return the events {@inheritDoc}
		 */
		@Override
		public String[] getEvents() {
			return events;
		}

		/**
		 * Gets the id.
		 * 
		 * @return the id {@inheritDoc}
		 */
		@Override
		public String getId() {
			return events[0];
		}

	}

	/** The Constant LOG. */
	@Inject
	private ComparerWrapperLog LOG;

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.comparadorad.bet.comparer.synchro.reader.readerbookmaker.core.readers
	 * .AbstractXmlFilereader#readXml(java.io.InputStream,
	 * com.comparadorad.bet.comparer
	 * .model.config.bean.bmconf.CfgBookmakerConfiguration,
	 * com.comparadorad.bet.
	 * comparer.synchro.reader.url.maker.bean.BeanAdditionalXmlInfoReader)
	 */
	@Override
	protected XmlBookmakerEvents readXml(InputStream file, CfgBookmakerConfiguration cfgBookmakerConfiguration,
			BeanAdditionalXmlInfoReader pBeanAdditionalXmlInfoReader) throws XmlReaderException {
		XmlBookmakerEvents result = new XmlBookmakerEvents();
		List list;
		try {
			list = (List) JaxbUtils.readXML(file, List.class);
			for (List.OddsObject bet : list.getOddsObject()) {
				result.addXmlMatch(readXmlMatch(bet, cfgBookmakerConfiguration));
			}
		} catch (JAXBException e) {
			LOG.error(Thread.currentThread(), new StringBuffer("Se ha producido un error leyendo el siguiente fichero:").append(convertInputStreamToString(file)).toString(), e);
			throw new BetAtHomeAttributeException(e);
		}
		return result;
	}

	/**
	 * Read xml match.
	 * 
	 * @param bet
	 *            the bet
	 * @param configuration
	 *            the configuration
	 * @return the xml match
	 * @throws BetAtHomeAttributeException
	 *             the bet at home attribute exception
	 */
	private XmlMatch readXmlMatch(List.OddsObject bet, CfgBookmakerConfiguration configuration) throws BetAtHomeAttributeException {

		XmlMatch result = null;
		IBetType betType = readBetType(bet);
		BetTypeBetatHome betatHome;

		try {
			if (betType != null && betType.getId() != null) {
				if (betType.getId().equals("1X2")) {
					LOG.debug(Thread.currentThread(), "Se selecciona la apuesta de tipo 1X2");
					result = readOneDrawTwoXmlMatch(bet, configuration);
				} else if (betType.getId().equals("Ganador")) {
					betatHome = readBetTypeWinner(bet);
					switch (betatHome) {
					case GANADOR:
						LOG.debug(Thread.currentThread(), "Se selecciona la apuesta de tipo GANADOR");
						result = readWinnerXmlMatch(bet, configuration);
						break;
					case MAXIMO_GOLEADOR:
						LOG.debug(Thread.currentThread(), "Se selecciona la apuesta de tipo MAXIMO GOLEADOR");
						result = readTotalScoreXmlMatch(bet, configuration);
						break;
					}
				} else if (betType.getId().equals("Ganador_Partido")) {
					LOG.debug(Thread.currentThread(), "Se selecciona la apuesta de tipo GANADOR PARTIDO");
					result = readGameWinnerXmlMatch(bet, configuration);
				} else if (betType.getId().equals("1X2_Handicap")) {
					LOG.debug(Thread.currentThread(), "Se selecciona la apuesta de tipo 1X2 HANDICAP");
					result = readHandicapXmlMatch(bet, configuration);
				} else if (betType.getId().equals("Handicap_Asiatico")) {
					LOG.debug(Thread.currentThread(), "Se selecciona la apuesta de tipo HANDICAP ASIATICO");
					result = readAsianHandicapXmlMatch(bet, configuration);
				} else if (betType.getId().equals("Mas_Menos")) {
					LOG.debug(Thread.currentThread(), "Se selecciona la apuesta de tipo MAS MENOS");
					result = readMasMenosXmlMatch(bet, configuration);
				} else {
					StringBuffer buffer = new StringBuffer("No Se puede leer el tipo de apuesta: ").append(bet.getOddsType().getBetName());
					LOG.debug(Thread.currentThread(), buffer.toString());
					throw new BetAtHomeAttributeException(buffer.toString());
				}
			}
		} catch (BetAtHomeAttributeException e) {
			LOG.error(Thread.currentThread(), e.getMessage(), e);
		}

		return result;
	}

	/**
	 * Read bet type winner.
	 * 
	 * @param bet
	 *            the bet
	 * @return the bet type betat home
	 * @throws BetAtHomeAttributeException
	 *             the bet at home attribute exception
	 */
	private BetTypeBetatHome readBetTypeWinner(final List.OddsObject bet) throws BetAtHomeAttributeException {
		String betName = bet.getOddsType().getBetName().toLowerCase();
		BetTypeBetatHome result = null;
		if (betName.contains("winner") || betName.contains("Champion") || betName.contains("champion") || betName.contains("Gesamtsieger")) {
			result = BetTypeBetatHome.GANADOR;
		} else if (betName.contains("top scorer")) {
			result = BetTypeBetatHome.MAXIMO_GOLEADOR;
		}
		if (result == null) {
			throw new BetAtHomeAttributeException("Tipo de apuesta no encontrado");
		}
		return result;

	}

	/**
	 * Read total score xml match.
	 * 
	 * @param bet
	 *            the bet
	 * @param configuration
	 *            the configuration
	 * @return the xml match
	 * @throws BetAtHomeAttributeException
	 *             the bet at home attribute exception
	 */
	private XmlMatch readTotalScoreXmlMatch(final List.OddsObject bet, final CfgBookmakerConfiguration configuration)
			throws BetAtHomeAttributeException {
		XmlMatch result = new XmlMatch();
		XmlBetType betType = new XmlBetType();
		XmlBetEvent xmlBetEvent = new XmlBetEvent();
		XmlMarket market = new XmlMarket();
		XmlMaximumGoalerAttribute topScorerAttribute;
		XmlMatchParticipant matchParticipant;
		XmlTournament tournament;
		XmlMarketBet marketBet;

		tournament = readXmlTournament(bet);

		betType.setBetType(BetTypeBetatHome.MAXIMO_GOLEADOR);
		
		IBetEvent betEvent = readBetTypeEvent(bet);	
		xmlBetEvent.setBetEvent(resolveOvertimeSport(bet.getSport().getId(), betType.getBetType(), betEvent));	
//		xmlBetEvent.setBetEvent(readBetTypeEvent(bet));

		market.setXmlBetType(betType);
		betType.setXmlBetEvent(xmlBetEvent);

		for (List.OddsObject.OddsData.Outcomes.Outcome outCome : bet.getOddsData().getOutcomes().getOutcome()) {

			matchParticipant = new XmlMatchParticipant(outCome.getName(), tournament);
			result.addXmlMatchParticipant(matchParticipant);

			marketBet = new XmlMarketBet();
			topScorerAttribute = new XmlMaximumGoalerAttribute();
			topScorerAttribute.setName(outCome.getName());
			topScorerAttribute.setGoaler(matchParticipant);
			marketBet.setXmlAttribute(topScorerAttribute);
			marketBet.setXmlMarketBetOdd(new XmlMarketBetOdd(Float.toString(outCome.getValue())));
			marketBet.setXmlMatchParticipant(matchParticipant);
			market.addXmlBet(marketBet);

		}

		try {
			result.setName(bet.getOddsType().getBetName());
			result.setXmlTournament(tournament);
			result.setStartDate(getStartDate(bet.getDate(), DATE_FORMAT, configuration));
			result.addXmlMarket(market);
		} catch (ParseException e) {
			LOG.error(Thread.currentThread(), e.getMessage(), e);
			throw new BetAtHomeAttributeException(e);
		}

		return result;

	}

	/**
	 * Read mas menos xml match.
	 * 
	 * @param bet
	 *            the bet
	 * @param configuration
	 *            the configuration
	 * @return the xml match
	 * @throws BetAtHomeAttributeException
	 *             the bet at home attribute exception
	 */
	private XmlMatch readMasMenosXmlMatch(final List.OddsObject bet, final CfgBookmakerConfiguration configuration)
			throws BetAtHomeAttributeException {
		XmlMatch result = new XmlMatch();
		XmlBetType betType = new XmlBetType();
		XmlBetEvent xmlBetEvent = new XmlBetEvent();
		XmlMarket market = new XmlMarket();
		XmlTournament tournament;
		XmlMoreLessAttribute attribute;
		XmlMarketBet marketBet;
		XmlMatchParticipant homeParticipant;
		XmlMatchParticipant awayParticipant;

		tournament = readXmlTournament(bet);
		result.setXmlTournament(tournament);

		homeParticipant = readHomeParticipant(bet, tournament);
		awayParticipant = readAwayParticipant(bet, tournament);

		betType.setBetType(BetTypeBetatHome.MAS_MENOS);
//		xmlBetEvent.setBetEvent(readBetTypeEvent(bet));
		IBetEvent betEvent = readBetTypeEvent(bet);	
		xmlBetEvent.setBetEvent(resolveOvertimeSport(bet.getSport().getId(), betType.getBetType(), betEvent));	
		
		betType.setXmlBetEvent(xmlBetEvent);

		market.setXmlBetType(betType);

		marketBet = new XmlMarketBet();
		attribute = new XmlMoreLessAttribute();
		attribute.setMasMenos(MasMenos.MAS);
		attribute.setTotalGoal(Double.valueOf(bet.getOddsData().getTotal().toString()));
		marketBet.setXmlAttribute(attribute);
		marketBet.setXmlMarketBetOdd(new XmlMarketBetOdd(Float.toString(bet.getOddsData().getOverOdds().getValue())));
		market.addXmlBet(marketBet);

		marketBet = new XmlMarketBet();
		attribute = new XmlMoreLessAttribute();
		attribute.setMasMenos(MasMenos.MENOS);
		attribute.setTotalGoal(Double.valueOf(bet.getOddsData().getTotal().toString()));
		marketBet.setXmlAttribute(attribute);
		marketBet.setXmlMarketBetOdd(new XmlMarketBetOdd(Float.toString(bet.getOddsData().getUnderOdds().getValue())));
		market.addXmlBet(marketBet);

		try {
			result.setName(readName(bet));
			result.setStartDate(getStartDate(bet.getDate(), DATE_FORMAT, configuration));
			result.addXmlMarket(market);
			result.addXmlMatchParticipant(homeParticipant);
			result.addXmlMatchParticipant(awayParticipant);
		} catch (ParseException e) {
			LOG.error(Thread.currentThread(), e.getMessage(), e);
			throw new BetAtHomeAttributeException(e);
		}

		return result;
	}

	/**
	 * Read asian handicap xml match.
	 * 
	 * @param bet
	 *            the bet
	 * @param configuration
	 *            the configuration
	 * @return the xml match
	 * @throws BetAtHomeAttributeException
	 *             the bet at home attribute exception
	 */
	private XmlMatch readAsianHandicapXmlMatch(final List.OddsObject bet, final CfgBookmakerConfiguration configuration)
			throws BetAtHomeAttributeException {
		XmlMatch result = new XmlMatch();
		XmlBetEvent xmlBetEvent = new XmlBetEvent();
		XmlMarket market = new XmlMarket();
		XmlBetType betType = new XmlBetType();
		XmlTournament tournament;
		XmlAsianHandicapAttribute attribute;
		XmlMarketBet marketBet;
		Double asianHandicap;
		XmlMatchParticipant homeParticipant;
		XmlMatchParticipant awayParticipant;

		tournament = readXmlTournament(bet);
		homeParticipant = readHomeParticipant(bet, tournament);
		awayParticipant = readAwayParticipant(bet, tournament);

		betType.setBetType(BetTypeBetatHome.HANDICAP_ASIATICO);
		
//		xmlBetEvent.setBetEvent(readBetTypeEvent(bet));
		IBetEvent betEvent = readBetTypeEvent(bet);	
		xmlBetEvent.setBetEvent(resolveOvertimeSport(bet.getSport().getId(), betType.getBetType(), betEvent));	
		
		betType.setXmlBetEvent(xmlBetEvent);

		market.setXmlBetType(betType);

		asianHandicap = new FloatingDecimal(bet.getOddsData().getSpreadHome()).doubleValue();

		marketBet = new XmlMarketBet();
		attribute = new XmlAsianHandicapAttribute();
		attribute.setAsianResult(AsianResult.ONE);
		attribute.setFirstValue(asianHandicap);
		marketBet.setXmlAttribute(attribute);
		marketBet.setXmlMarketBetOdd(new XmlMarketBetOdd(Float.toString(bet.getOddsData().getSpreadOddsHome().getValue())));
		marketBet.setXmlMatchParticipant(homeParticipant);
		market.addXmlBet(marketBet);

		marketBet = new XmlMarketBet();
		attribute = new XmlAsianHandicapAttribute();
		attribute.setAsianResult(AsianResult.TWO);
		attribute.setFirstValue(asianHandicap);
		marketBet.setXmlAttribute(attribute);
		marketBet.setXmlMatchParticipant(awayParticipant);
		marketBet.setXmlAttribute(attribute);
		marketBet.setXmlMarketBetOdd(new XmlMarketBetOdd(Float.toString(bet.getOddsData().getSpreadOddsAway().getValue())));
		market.addXmlBet(marketBet);

		try {
			result.setName(readName(bet));
			result.setXmlTournament(tournament);
			result.addXmlMatchParticipant(homeParticipant);
			result.addXmlMatchParticipant(awayParticipant);
			result.setStartDate(getStartDate(bet.getDate(), DATE_FORMAT, configuration));
			result.addXmlMarket(market);
		} catch (ParseException e) {
			LOG.error(Thread.currentThread(), e.getMessage(), e);
			throw new BetAtHomeAttributeException(e);
		}

		return result;
	}

	/**
	 * Read handicap xml match.
	 * 
	 * @param bet
	 *            the bet
	 * @param configuration
	 *            the configuration
	 * @return the xml match
	 * @throws BetAtHomeAttributeException
	 *             the bet at home attribute exception
	 */
	private XmlMatch readHandicapXmlMatch(final List.OddsObject bet, final CfgBookmakerConfiguration configuration)
			throws BetAtHomeAttributeException {
		XmlMatch result = new XmlMatch();
		XmlBetType betType = new XmlBetType();
		XmlBetEvent xmlBetEvent = new XmlBetEvent();
		XmlMarket market = new XmlMarket();
		XmlMarketBet marketBet;
		XmlTournament tournament;
		XmlMatchParticipant homeParticipant;
		XmlMatchParticipant awayParticipant;
		Xml1X2HandicapAttribute attribute;
		Double firstHandicap = 0.0;
		Double secondHandicap = 0.0;
		Pattern p = Pattern.compile("[\\:]");
		Matcher matcher = p.matcher(bet.getOddsData().getHandicap());
		if (matcher.find()) {
			firstHandicap = Double.parseDouble(bet.getOddsData().getHandicap().substring(0, matcher.start()));
			secondHandicap = Double.parseDouble(bet.getOddsData().getHandicap().substring(matcher.end()));
		}
		if (firstHandicap == 0.0)
			firstHandicap = secondHandicap * -1;
		tournament = readXmlTournament(bet);
		homeParticipant = readHomeParticipant(bet, tournament);
		awayParticipant = readAwayParticipant(bet, tournament);

		betType.setBetType(BetTypeBetatHome.UNO_X_DOS_HANDICAP);
//		xmlBetEvent.setBetEvent(readBetTypeEvent(bet));
		
		IBetEvent betEvent = readBetTypeEvent(bet);	
		xmlBetEvent.setBetEvent(resolveOvertimeSport(bet.getSport().getId(), betType.getBetType(), betEvent));	
		
		market.setXmlBetType(betType);
		betType.setXmlBetEvent(xmlBetEvent);

		marketBet = new XmlMarketBet();
		attribute = new Xml1X2HandicapAttribute();
		attribute.setFirstValue(firstHandicap);
		attribute.setResult(Result.ONE);
		marketBet.setXmlMatchParticipant(homeParticipant);
		marketBet.setXmlAttribute(attribute);
		marketBet.setXmlMarketBetOdd(new XmlMarketBetOdd(Float.toString(bet.getOddsData().getHomeOdds().getValue())));
		market.addXmlBet(marketBet);

		marketBet = new XmlMarketBet();
		attribute = new Xml1X2HandicapAttribute();
		attribute.setFirstValue(firstHandicap);
		attribute.setResult(Result.DRAW);
		marketBet.setXmlAttribute(attribute);
		marketBet.setXmlMarketBetOdd(new XmlMarketBetOdd(Float.toString(bet.getOddsData().getDrawOdds().getValue())));
		market.addXmlBet(marketBet);

		marketBet = new XmlMarketBet();
		attribute = new Xml1X2HandicapAttribute();
		attribute.setFirstValue(firstHandicap);
		attribute.setResult(Result.TWO);
		marketBet.setXmlAttribute(attribute);
		marketBet.setXmlMatchParticipant(awayParticipant);
		marketBet.setXmlAttribute(attribute);
		marketBet.setXmlMarketBetOdd(new XmlMarketBetOdd(Float.toString(bet.getOddsData().getAwayOdds().getValue())));
		market.addXmlBet(marketBet);

		try {
			result.setName(readName(bet));
			result.setXmlTournament(tournament);
			result.addXmlMatchParticipant(homeParticipant);
			result.addXmlMatchParticipant(awayParticipant);
			result.setStartDate(getStartDate(bet.getDate(), DATE_FORMAT, configuration));
			result.addXmlMarket(market);
		} catch (ParseException e) {
			LOG.error(Thread.currentThread(), e.getMessage(), e);
			throw new BetAtHomeAttributeException(e);
		}

		return result;
	}

	/**
	 * Read game winner xml match.
	 * 
	 * @param bet
	 *            the bet
	 * @param configuration
	 *            the configuration
	 * @return the xml match
	 * @throws BetAtHomeAttributeException
	 *             the bet at home attribute exception
	 */
	private XmlMatch readGameWinnerXmlMatch(final List.OddsObject bet, final CfgBookmakerConfiguration configuration)
			throws BetAtHomeAttributeException {

		XmlMatch result = new XmlMatch();
		XmlBetType betType = new XmlBetType();
		XmlBetEvent xmlBetEvent = new XmlBetEvent();
		XmlMarket market = new XmlMarket();
		XmlTournament tournament;
		XmlMatchWinnerAttribute matchWinnerAttribute;
		XmlMarketBet marketBet;
		XmlMatchParticipant homeParticipant;
		XmlMatchParticipant awayParticipant;

		tournament = readXmlTournament(bet);
		homeParticipant = readHomeParticipant(bet, tournament);
		awayParticipant = readAwayParticipant(bet, tournament);

		betType.setBetType(BetTypeBetatHome.GANADOR_PARTIDO);
		IBetEvent betEvent = readBetTypeEvent(bet);	
		xmlBetEvent.setBetEvent(resolveOvertimeSport(bet.getSport().getId(), betType.getBetType(), betEvent));		
		
		market.setXmlBetType(betType);
		betType.setXmlBetEvent(xmlBetEvent);

		marketBet = new XmlMarketBet();
		matchWinnerAttribute = new XmlMatchWinnerAttribute();
		marketBet.setXmlAttribute(matchWinnerAttribute);
		matchWinnerAttribute.setResult(Result.ONE);
		matchWinnerAttribute.setWinnerName(homeParticipant);
		marketBet.setXmlMatchParticipant(homeParticipant);
		marketBet.setXmlAttribute(matchWinnerAttribute);
		marketBet.setXmlMarketBetOdd(new XmlMarketBetOdd(Float.toString(bet.getOddsData().getHomeOdds().getValue())));
		market.addXmlBet(marketBet);

		marketBet = new XmlMarketBet();
		matchWinnerAttribute = new XmlMatchWinnerAttribute();
		matchWinnerAttribute.setResult(Result.TWO);
		matchWinnerAttribute.setWinnerName(awayParticipant);
		marketBet.setXmlAttribute(matchWinnerAttribute);
		marketBet.setXmlMatchParticipant(awayParticipant);
		marketBet.setXmlAttribute(matchWinnerAttribute);
		marketBet.setXmlMarketBetOdd(new XmlMarketBetOdd(Float.toString(bet.getOddsData().getAwayOdds().getValue())));
		market.addXmlBet(marketBet);

		try {
			result.setStartDate(getStartDate(bet.getDate(), DATE_FORMAT, configuration));
			result.addXmlMatchParticipant(homeParticipant);
			result.addXmlMatchParticipant(awayParticipant);
			result.setName(readName(bet));
			result.setXmlTournament(tournament);
			result.addXmlMarket(market);
		} catch (ParseException e) {
			LOG.error(Thread.currentThread(), e.getMessage(), e);
			throw new BetAtHomeAttributeException(e);
		}

		return result;
	}

	/**
	 * Read winner xml match.
	 * 
	 * @param bet
	 *            the bet
	 * @param configuration
	 *            the configuration
	 * @return the xml match
	 * @throws BetAtHomeAttributeException
	 *             the bet at home attribute exception
	 */
	private XmlMatch readWinnerXmlMatch(final List.OddsObject bet, final CfgBookmakerConfiguration configuration)
			throws BetAtHomeAttributeException {

		XmlMatch result = new XmlMatch();
		XmlBetType betType = new XmlBetType();
		XmlBetEvent xmlBetEvent = new XmlBetEvent();
		XmlTournamentEvent tournamentEvent = new XmlTournamentEvent();
		XmlMarket market = new XmlMarket();
		XmlWinnerAttribute winnerAttribute;
		XmlMatchParticipant matchParticipant;
		XmlTournament tournament;
		XmlMarketBet marketBet;
		LongTerm longTerm;

		tournament = readXmlTournament(bet);

		betType.setBetType(BetTypeBetatHome.GANADOR);
//		xmlBetEvent.setBetEvent(readBetTypeEvent(bet));
		
		IBetEvent betEvent = readBetTypeEvent(bet);	
		xmlBetEvent.setBetEvent(resolveOvertimeSport(bet.getSport().getId(), betType.getBetType(), betEvent));	

		longTerm = new LongTerm();
		longTerm.setLongTerm(Boolean.TRUE);
		tournamentEvent.setLongTerm(longTerm);

		market.setXmlBetType(betType);
		betType.setXmlBetEvent(xmlBetEvent);

		for (List.OddsObject.OddsData.Outcomes.Outcome outCome : bet.getOddsData().getOutcomes().getOutcome()) {

			matchParticipant = new XmlMatchParticipant(outCome.getName(), tournament);
			result.addXmlMatchParticipant(matchParticipant);

			marketBet = new XmlMarketBet();
			winnerAttribute = new XmlWinnerAttribute();
			winnerAttribute.setName(outCome.getName());
			winnerAttribute.setWinner(matchParticipant);
			marketBet.setXmlAttribute(winnerAttribute);
			marketBet.setXmlMarketBetOdd(new XmlMarketBetOdd(Float.toString(outCome.getValue())));
			marketBet.setXmlMatchParticipant(matchParticipant);
			market.addXmlBet(marketBet);

		}

		try {
			result.setStartDate(getStartDate(bet.getDate(), DATE_FORMAT, configuration));
			result.setXmlTournamentEvent(tournamentEvent);
			result.setName(bet.getTournament().getValue());
			result.setXmlTournament(tournament);
			result.addXmlMarket(market);
		} catch (ParseException e) {
			LOG.error(Thread.currentThread(), e.getMessage(), e);
			throw new BetAtHomeAttributeException(e);
		}

		return result;

	}

	/**
	 * Read bet type.
	 * 
	 * @param bet
	 *            the bet
	 * @return the i bet type
	 */
	private IBetType readBetType(final List.OddsObject bet) {
		IBetType result = BetTypeBetatHome.getTypeByValue(bet.getOddsType().getValue());
		if (result != null && result.equals(BetTypeBetatHome.OTHER) && whiteList.contains(bet.getOddsType().getGroupName())) {
			result = BetTypeBetatHome.getTypeByValue(bet.getOddsType().getGroupName());
		}
		return result;
	}

	/**
	 * Read bet type event.
	 * 
	 * @param bet
	 *            the bet
	 * @return the i bet event
	 */
	private IBetEvent readBetTypeEvent(final List.OddsObject bet) {
		IBetEvent result = BetTypeEventBetatHome.getEventByValue(bet.getOddsType().getGroupName());
		if (result == null) {
			result = BetTypeEventBetatHome.PARTIDO_COMPLETO;
		}
		return result;
	}

	/**
	 * Read one draw two xml match.
	 * 
	 * @param bet
	 *            the bet
	 * @param configuration
	 *            the configuration
	 * @return the xml match
	 * @throws BetAtHomeAttributeException
	 *             the bet at home attribute exception
	 */
	private XmlMatch readOneDrawTwoXmlMatch(final List.OddsObject bet, final CfgBookmakerConfiguration configuration)
			throws BetAtHomeAttributeException {

		XmlMatch result = new XmlMatch();
		XmlMarket market = new XmlMarket();
		XmlBetType betType = new XmlBetType();
		XmlBetEvent xmlBetEvent = new XmlBetEvent();
		XmlMarketBet marketBet;
		XmlTournament tournament;
		Xml1X2Attribute xml1x2Attribute;
		XmlMatchParticipant homeParticipant;
		XmlMatchParticipant awayParticipant;

		tournament = readXmlTournament(bet);
		homeParticipant = readHomeParticipant(bet, tournament);
		awayParticipant = readAwayParticipant(bet, tournament);

		betType.setBetType(BetTypeBetatHome.UNO_X_DOS);
		
//		xmlBetEvent.setBetEvent(readBetTypeEvent(bet));
		IBetEvent betEvent = readBetTypeEvent(bet);	
		xmlBetEvent.setBetEvent(resolveOvertimeSport(bet.getSport().getId(), betType.getBetType(), betEvent));
		
		betType.setXmlBetEvent(xmlBetEvent);

		market.setXmlBetType(betType);

		marketBet = new XmlMarketBet();
		xml1x2Attribute = new Xml1X2Attribute();
		xml1x2Attribute.setResult(Result.ONE);
		marketBet.setXmlAttribute(xml1x2Attribute);
		marketBet.setXmlMarketBetOdd(new XmlMarketBetOdd(Float.toString(bet.getOddsData().getHomeOdds().getValue())));
		marketBet.setXmlMatchParticipant(homeParticipant);
		market.addXmlBet(marketBet);

		marketBet = new XmlMarketBet();
		xml1x2Attribute = new Xml1X2Attribute();
		xml1x2Attribute.setResult(Result.DRAW);
		marketBet.setXmlAttribute(xml1x2Attribute);
		marketBet.setXmlMarketBetOdd(new XmlMarketBetOdd(Float.toString(bet.getOddsData().getDrawOdds().getValue())));
		market.addXmlBet(marketBet);

		marketBet = new XmlMarketBet();
		xml1x2Attribute = new Xml1X2Attribute();
		xml1x2Attribute.setResult(Result.TWO);
		marketBet.setXmlAttribute(xml1x2Attribute);
		marketBet.setXmlMatchParticipant(awayParticipant);
		marketBet.setXmlAttribute(xml1x2Attribute);
		marketBet.setXmlMarketBetOdd(new XmlMarketBetOdd(Float.toString(bet.getOddsData().getAwayOdds().getValue())));
		market.addXmlBet(marketBet);

		try {
			result.setName(readName(bet));
			result.setXmlTournament(tournament);
			result.addXmlMatchParticipant(homeParticipant);
			result.addXmlMatchParticipant(awayParticipant);
			result.setStartDate(getStartDate(bet.getDate(), DATE_FORMAT, configuration));
			result.addXmlMarket(market);
		} catch (ParseException e) {
			LOG.error(Thread.currentThread(), e.getMessage(), e);
			throw new BetAtHomeAttributeException(e);
		}

		return result;
	}

	/**
	 * Read home participant.
	 * 
	 * @param bet
	 *            the bet
	 * @param tournament
	 *            the tournament
	 * @return the xml match participant
	 */
	private static XmlMatchParticipant readHomeParticipant(final List.OddsObject bet, final XmlTournament tournament) {
		return new XmlMatchParticipant(bet.getOddsData().getHomeTeam(), true, false, tournament);
	}

	/**
	 * Read away participant.
	 * 
	 * @param bet
	 *            the bet
	 * @param tournament
	 *            the tournament
	 * @return the xml match participant
	 */
	private static XmlMatchParticipant readAwayParticipant(final List.OddsObject bet, final XmlTournament tournament) {
		return new XmlMatchParticipant(bet.getOddsData().getAwayTeam(), false, true, tournament);
	}

	/**
	 * Read xml tournament.
	 * 
	 * @param bet
	 *            the bet
	 * @return the xml tournament
	 */
	private static XmlTournament readXmlTournament(final List.OddsObject bet) {
		XmlTournament result = new XmlTournament();
		XmlSport sport = new XmlSport();

		if (bet.getCategory() != null && StringUtils.isNotEmpty(bet.getCategory().getValue())) {
			result.setName(new StringBuffer().append(bet.getCategory().getValue()).append(" ").append(bet.getTournament().getValue())
					.toString());
		} else {
			result.setName(bet.getTournament().getValue());
		}

		sport.setName(bet.getSport().getValue());		

		result.setXmlSport(sport);

		return result;

	}

	/**
	 * Read name.
	 * 
	 * @param bet
	 *            the bet
	 * @return the string
	 */
	private static String readName(final List.OddsObject bet) {
		StringBuffer buffer;
		buffer = new StringBuffer(bet.getOddsData().getHomeTeam());
		buffer.append(" VS ");
		buffer.append(bet.getOddsData().getAwayTeam());
		return buffer.toString();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.comparadorad.bet.comparer.synchro.reader.readerbookmaker.core.readers
	 * .AbstractXmlFilereader#getBookmakerId()
	 */
	@Override
	public String getBookmakerId() {
		return CfgBookmaker.CfgBookmakerId.BET_AT_HOME_COM_ID.objectId().toString();
	}
	
	private IBetEvent resolveOvertimeSport (byte sportId, IBetType betType, IBetEvent currentIBetEvent){
		String sSport = Integer.toString((int)sportId);
		if(SportBetAtHomeIds.isIceHokey(sSport) && betType.getId().equals(BetTypeBetatHome.GANADOR_PARTIDO.getId())) {
			return BetTypeEventBetatHome.PARTIDO_COMPLETO_PRORROGA;
		}
		// Deportes que pueden ir con prórroga
		if(SportBetAtHomeIds.isBasketBall(sSport)
		   || SportBetAtHomeIds.isAmericanFootball(sSport)
		   || SportBetAtHomeIds.isBaseBall(sSport)) {
			// Si es alguno de los bettypes siguientes
			if(betType.getId().equals(BetTypeBetatHome.GANADOR_PARTIDO.getId()) 
			   || betType.getId().equals(BetTypeBetatHome.HANDICAP_ASIATICO.getId())
			   || betType.getId().equals(BetTypeBetatHome.MAS_MENOS.getId())) {
				return BetTypeEventBetatHome.PARTIDO_COMPLETO_PRORROGA;
			}
		}
		
		return currentIBetEvent;
	}

	
	public enum SportBetAtHomeIds implements IBetType {

		/** The FOOTBALL. */
		FOOTBALL("Football", "1"),
		/** The TENNIS. */
		TENNIS("Tennis", "2"),
		/** The BASKETBALL. */
		BASKETBALL("Basketball", "5"),
		/** The BASEBALL. */
		BASEBALL("Baseball", "7"),
		/** The IC e_ hockey. */
		ICE_HOCKEY("Ice hockey", "3"),
		/** The HANDBALL. */
		HANDBALL("Handball", "4"),
		/** The AMERICA n_ football. */
		AMERICAN_FOOTBALL("American Football", "6");

		/**
		 * Gets the type by value.
		 * 
		 * @param pValue
		 *            the value
		 * @return the type by value
		 */
		public static IBetType getTypeByValue(String pValue) {
			BetTypeBetatHome[] values = BetTypeBetatHome.values();
			for (int i = 0; i < values.length; i++) {
				String[] types = values[i].getTypes();
				for (int j = 1; j < types.length; j++) {
					if (pValue.contains(types[j])) {
						return values[i];
					}
				}
			}
			return null;
		}

		/** The value. */
		private final String[] type;

		/**
		 * Instantiates a new bet type.
		 * 
		 * @param pValue
		 *            the value
		 */
		SportBetAtHomeIds(String... pValue) {
			this.type = pValue;
		}

		/**
		 * Gets the id.
		 * 
		 * @return the id {@inheritDoc}
		 */
		@Override
		public String getId() {
			return type[0];
		}

		/**
		 * Gets the types.
		 * 
		 * @return the types {@inheritDoc}
		 */
		@Override
		public String[] getTypes() {
			return type;
		}

		/**
		 * Return if is BasketBall
		 * @param idSport
		 * @return
		 */
		public static Boolean isBasketBall(String idSport) {
			if(BASKETBALL.getTypes()[1].equals(idSport)) {
				return true;
			}
			
			return false;
		}
		
		/**
		 * 
		 * @param idSport
		 * @return
		 */
		public static Boolean isBaseBall(String idSport) {
			if(BASEBALL.getTypes()[1].equals(idSport)) {
				return true;
			}
			
			return false;
		}		
		
		/**
		 * 
		 * @param idSport
		 * @return
		 */
		public static Boolean isAmericanFootball(String idSport) {
			if(AMERICAN_FOOTBALL.getTypes()[1].equals(idSport)) {
				return true;
			}
			
			return false;
		}
		
		/**
		 * 
		 * @param idSport
		 * @return
		 */
		public static Boolean isIceHokey(String idSport) {
			if(ICE_HOCKEY.getTypes()[1].equals(idSport)) {
				return true;
			}
			
			return false;
		}				
	}	
}
