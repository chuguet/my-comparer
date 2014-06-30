/**
 *
 * Copyright (C) FACTORIA ETSIA S.L.
 * All Rights Reserved.
 * www.factoriaetsia.com
 *
 */
package com.comparadorad.bet.comparer.synchro.reader.readerbookmaker.core.readers;

import java.io.IOException;
import java.io.InputStream;
import java.io.StringWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collection;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.TimeZone;

import javax.annotation.Resource;
import javax.xml.datatype.XMLGregorianCalendar;

import org.apache.commons.io.IOUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.dozer.Mapper;

import com.comparadorad.bet.comparer.model.config.bean.CfgBetType.CfgBetTypeId;
import com.comparadorad.bet.comparer.model.config.bean.LongTerm;
import com.comparadorad.bet.comparer.model.config.bean.bmconf.CfgBookmakerConfiguration;
import com.comparadorad.bet.comparer.synchro.reader.model.XmlBookmakerEvents;
import com.comparadorad.bet.comparer.synchro.reader.model.XmlDate;
import com.comparadorad.bet.comparer.synchro.reader.model.XmlMarket;
import com.comparadorad.bet.comparer.synchro.reader.model.XmlMarketBet;
import com.comparadorad.bet.comparer.synchro.reader.model.XmlMatch;
import com.comparadorad.bet.comparer.synchro.reader.model.XmlMatchParticipant;
import com.comparadorad.bet.comparer.synchro.reader.model.XmlRegion;
import com.comparadorad.bet.comparer.synchro.reader.model.XmlSport;
import com.comparadorad.bet.comparer.synchro.reader.model.XmlTournament;
import com.comparadorad.bet.comparer.synchro.reader.model.XmlTournamentEvent;
import com.comparadorad.bet.comparer.synchro.reader.readerbookmaker.core.data.XmlBetFileReaderResult;
import com.comparadorad.bet.comparer.synchro.reader.readerbookmaker.core.exception.XmlReaderException;
import com.comparadorad.bet.comparer.synchro.reader.readerbookmaker.core.util.StringFormatterUtil;
import com.comparadorad.bet.comparer.synchro.reader.url.maker.bean.BeanAdditionalXmlInfoReader;

/**
 * The Class AbstractXmlFilereader.
 */
public abstract class AbstractXmlFilereader implements IXMLFileReader {

	/** The Constant LOG. */
	private static final Log LOG = LogFactory
			.getLog(AbstractXmlFilereader.class);

	/** The mapper. */
	@Resource(name = "reader")
	private Mapper mapper;

	/** The participants names. */
	protected List<String> participantsNames;

	
	/**
	 * Método que elimina los partidos que tengan alguna de las palabras de la
	 * lista negra de la casa de apuestas.
	 * 
	 * @param blackList
	 *            , lista negra de palabras a eliminar de los partidos de la
	 *            casa de apuestas
	 * @param matches
	 *            , lista de eventos procesador por el reader
	 * @return lista de partidos ya sin los eventos que contengan alguna de las
	 *         palabras que tenamos en la lista negra
	 */
	private Collection<XmlMatch> applyBookmakerWordsBlackListToEvents(
			final Set<String> blackList, final Collection<XmlMatch> matches) {
		Collection<XmlMatch> result = new ArrayList<XmlMatch>();
		for (XmlMatch match : matches) {
			result.add(match);
		}

		Collection<XmlMatch> blackListMatches = new ArrayList<XmlMatch>();
		if (blackList != null && blackList.size() > 0) {
			for (String word : blackList) {
				// Nivel de deporte competicion y region
				for (XmlMatch match : matches) {
					Boolean agregar = Boolean.TRUE;
					if (match.getName().toLowerCase()
							.contains(word.toLowerCase())
							|| match.getXmlTournament().getName().toLowerCase()
									.contains(word.toLowerCase())
							|| match.getXmlTournament().getXmlSport().getName()
									.toLowerCase().contains(word.toLowerCase())
							|| (match.getXmlTournament().getRegion() != null && match
									.getXmlTournament().getRegion().getName()
									.toLowerCase().contains(word.toLowerCase()))) {
						LOG.debug(new StringBuffer()
								.append("Se ha detectado un evento con la palabra de la lista negra ")
								.append(word)
								.append(", no procesamos el evento").toString());
						agregar = Boolean.FALSE;
						result.remove(match);
						blackListMatches.add(match);
					}
					if (agregar) {
						// Nivel de participantes
						for (XmlMatchParticipant participant : match
								.getXmlMatchParticipants()) {
							if (participant.getName() != null
									&& participant.getName().toLowerCase()
											.contains(word.toLowerCase())) {
								agregar = Boolean.FALSE;
								LOG.debug(new StringBuffer()
										.append("Se ha detectado un evento con la palabra de la lista negra ")
										.append(word)
										.append(", no procesamos el evento")
										.toString());
								result.remove(match);
								blackListMatches.add(match);
							}
						}
					}
				}
			}

		} else {
			result = matches;
		}
		return result;
	}

	/**
	 * Apply long term xml matchs.
	 * 
	 * @param xmlMatchs
	 *            the xml matchs
	 */
	private void applyLongTermXmlMatchs(Collection<XmlMatch> xmlMatchs) {
		Boolean isLongTerm = Boolean.FALSE;
		for (XmlMatch xmlMatch : xmlMatchs) {
			for (XmlMarket xmlMarket : xmlMatch.getXmlMarkets()) {
				if (xmlMarket.getXmlBetType().getBetType().getTypes()[0]
						.equals(CfgBetTypeId.GANADOR.nameId())
						|| xmlMarket.getXmlBetType().getBetType().getTypes()[0]
								.equals(CfgBetTypeId.MAXIMO_GOLEADOR.nameId())) {
					isLongTerm = Boolean.TRUE;
					break;
				} else {
					isLongTerm = Boolean.FALSE;
				}
			}
			XmlTournamentEvent xmlTournamentEvent = new XmlTournamentEvent();
			LongTerm longTerm = new LongTerm();
			longTerm.setLongTerm(isLongTerm);
			xmlTournamentEvent.setLongTerm(longTerm);
			xmlMatch.setXmlTournamentEvent(xmlTournamentEvent);
		}

	}

	/**
	 * Convert input stream to string.
	 * 
	 * @param inputStream
	 *            the input stream
	 * @return the string
	 */
	protected String convertInputStreamToString(InputStream inputStream) {
		StringWriter writer = new StringWriter();
		try {
			IOUtils.copy(inputStream, writer, "UTF-8");
		} catch (IOException e) {
			LOG.error(e.getMessage());
		}
		return writer.toString();
	}

	/**
	 * Este metodo devuelve la fecha 'providerDate' expresada en la zona horaria
	 * del sistema desde donde se ejecuta el código. Esto se hace debido a que
	 * mongo siempre guarda una fecha en el formato GMT0/UTC0 TENIENDO EN CUENTA
	 * la zona horaria del sistema desde donde se pida el guardado. Así que si
	 * queremos tener fechas expresadas en GMT0 en la BD, tenemos que mandar a
	 * mongo la fecha expresada en la zona horaria local y dejar a mongo hacer
	 * la transformación a GMT0.
	 * 
	 * @param providerDate
	 *            the provider date
	 * @param bookmakerTimeZone
	 *            the bookmaker time zone
	 * @return the date
	 */
	private Date convertToLocalGMT(final Date providerDate,
			final String bookmakerTimeZone) {

		Long msDate = providerDate.getTime();
		int bookmakerTimeZoneOffset = TimeZone.getTimeZone(bookmakerTimeZone)
				.getOffset(Calendar.getInstance().getTimeInMillis());
		int localeTimeZoneOffset = TimeZone.getDefault().getOffset(
				Calendar.getInstance().getTimeInMillis());

		int totalMsOffset = -bookmakerTimeZoneOffset + localeTimeZoneOffset;
		msDate = msDate + totalMsOffset;

		return new Date(msDate);
	}

	/**
	 * Se recorre todos los matches y para cada uno de los torneos les añade la
	 * lista de sus participantes.
	 * 
	 * @param xmlMatchReaded
	 *            the xml match readed
	 * @return the list
	 */
	private Set<XmlMatch> fillTournamentParticipants(
			final Collection<XmlMatch> xmlMatchReaded) {
		Set<XmlMatch> matches = new HashSet<XmlMatch>();
		for (XmlMatch match : xmlMatchReaded) {

			XmlMatch newMatch = new XmlMatch();
			// Clono el partido por uno nuevo.
			newMatch = match;
			XmlTournament matchTournament = match.getXmlTournament();
			Set<String> tournamentParticipants = new HashSet<String>();
			// Meto todos los participantes de cada partido en el torneo
			for (XmlMatchParticipant participant : match
					.getXmlMatchParticipants()) {
				tournamentParticipants.add(participant.getName());
			}
			matchTournament.setParticipantNames(tournamentParticipants);
			newMatch.setXmlTournament(matchTournament);
			// agrego a la nueva lista de partidos los partidos con los torneos
			// con sus participantes.
			matches.add(newMatch);
		}

		return matches;
	}

	/**
	 * Gets the bookmaker id.
	 * 
	 * @return the bookmaker id {@inheritDoc}
	 */
	@Override
	public abstract String getBookmakerId();

	/**
	 * Gets the draw participant.
	 * 
	 * @return the draw participant
	 */
	protected XmlMatchParticipant getDrawParticipant() {
		XmlMatchParticipant participant = new XmlMatchParticipant();
		participant.setAwayParticipant(false);
		participant.setHomeParticipant(false);
		return participant;
	}

	/**
	 * Gets the mapper.
	 * 
	 * @return the mapper
	 */
	protected Mapper getMapper() {
		return mapper;
	}

	/**
	 * Gets the participant.
	 * 
	 * @param pXmlMatchParticipants
	 *            the xml match participants
	 * @param homeParticipant
	 *            the home participant
	 * @return the participant
	 */
	protected XmlMatchParticipant getParticipant(
			final Collection<XmlMatchParticipant> pXmlMatchParticipants,
			final boolean homeParticipant) {
		for (XmlMatchParticipant xmlMatchParticipant : pXmlMatchParticipants) {
			if (homeParticipant && xmlMatchParticipant.isHomeParticipant()) {
				return xmlMatchParticipant;
			}
			if (!homeParticipant && xmlMatchParticipant.isAwayParticipant()) {
				return xmlMatchParticipant;
			}
		}
		return null;
	}

	/**
	 * Gets the participant by name.
	 * 
	 * @param pXmlMatchParticipants
	 *            the xml match participants
	 * @param nameParticipant
	 *            the name participant
	 * @return the participant by name
	 */
	protected XmlMatchParticipant getParticipantByName(
			final Collection<XmlMatchParticipant> pXmlMatchParticipants,
			final String nameParticipant) {
		for (XmlMatchParticipant xmlMatchParticipant : pXmlMatchParticipants) {
			if (xmlMatchParticipant.getName().equals(nameParticipant)) {
				return xmlMatchParticipant;
			}
		}
		return null;
	}

	/**
	 * Gets the start date.
	 * 
	 * @param date
	 *            the date
	 * @param format
	 *            the format
	 * @param bookmakerTimeZone
	 *            the bookmaker time zone
	 * @return the start date
	 * @throws ParseException
	 *             the parse exception
	 */
	protected XmlDate getStartDate(final String date, final String format,
			String bookmakerTimeZone) throws ParseException {
		SimpleDateFormat dateFormat = new SimpleDateFormat(format);
		Date providerDate = dateFormat.parse(date);
		// Date zeroGmtDate = convertToGMT0(providerDate, bookmakerTimeZone);
		Date localGmtDate = convertToLocalGMT(providerDate, bookmakerTimeZone);
		XmlDate xmlDate = new XmlDate(providerDate, bookmakerTimeZone,
				localGmtDate);
		return xmlDate;
	}

	/**
	 * Gets the start date.
	 * 
	 * @param date
	 *            the date
	 * @param dateFormat
	 *            the date format
	 * @param bookmakerConfiguration
	 *            the bookmaker configuration
	 * @return the start date
	 * @throws ParseException
	 *             the parse exception
	 */
	protected XmlDate getStartDate(final XMLGregorianCalendar date,
			final String dateFormat,
			final CfgBookmakerConfiguration bookmakerConfiguration)
			throws ParseException {
		return getStartDate(date.toString().replace("T", " "), dateFormat,
				bookmakerConfiguration.getTimeZone());
	}

	/**
	 * Normalize strings.
	 * 
	 * @param eventos
	 *            the eventos
	 * @return the set
	 */
	private Set<XmlMatch> normalizeStrings(final XmlBookmakerEvents eventos) {
		Set<XmlMatch> result = new HashSet<XmlMatch>();

		for (XmlMatch match : eventos.getXmlMatchs()) {
			XmlMatch newMatch = new XmlMatch();
			newMatch = match;

			// Normalizamos el nombre
			newMatch.setName(StringFormatterUtil.normalizeReaderString(match
					.getName()));

			// Normalizamos la competicion
			XmlTournament tournament = match.getXmlTournament();
			tournament.setName(StringFormatterUtil
					.normalizeReaderString(tournament.getName()));
			newMatch.setXmlTournament(tournament);

			// Normalizamos la Region
			XmlRegion region = match.getXmlTournament().getRegion();
			if (region != null) {
				region.setName(StringFormatterUtil.normalizeReaderString(region
						.getName()));
				tournament.setRegion(region);
			}

			// Normalizamos el deporte
			XmlSport deporte = tournament.getXmlSport();
			deporte.setName(StringFormatterUtil.normalizeReaderString(deporte
					.getName()));
			tournament.setXmlSport(deporte);

			// Normalizamos los participantes
			Collection<XmlMatchParticipant> participants = new ArrayList<XmlMatchParticipant>();
			for (XmlMatchParticipant participant : match
					.getXmlMatchParticipants()) {
				XmlMatchParticipant participanteCorregido = participant;
				participanteCorregido.setName(StringFormatterUtil
						.normalizeReaderString(participant.getName()));
				participants.add(participanteCorregido);
			}
			// normalizar participante de bet
			for (XmlMarket market : match.getXmlMarkets()) {
				for (XmlMarketBet bet : market.getXmlMarketBets()) {
					XmlMatchParticipant participanteCorregido = bet
							.getXmlMatchParticipant();
					if (bet.getXmlMatchParticipant() != null) {
						participanteCorregido.setName(StringFormatterUtil
								.normalizeReaderString(bet
										.getXmlMatchParticipant().getName()));
						bet.setXmlMatchParticipant(participanteCorregido);
					}

				}
			}

			newMatch.setXmlMatchParticipants(participants);
			newMatch.setXmlTournament(tournament);
			result.add(newMatch);
		}

		return result;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.comparadorad.bet.comparer.synchro.reader.readerbookmaker.core.readers
	 * .IXMLFileReader#read(java.io.InputStream,
	 * com.comparadorad.bet.comparer.model
	 * .config.bean.bmconf.CfgBookmakerConfiguration)
	 */
	@Override
	public XmlBetFileReaderResult read(InputStream pFile,
			CfgBookmakerConfiguration cfgBookmakerConfiguration,
			final BeanAdditionalXmlInfoReader pBeanAdditionalXmlInfoReader, String url)
			throws XmlReaderException {
		XmlBetFileReaderResult result;
		XmlBookmakerEvents eventos;
		LOG.debug("Leemos el fichero: " + url + " - ThreadId: " + Thread.currentThread().getId());
		eventos = readXml(pFile, cfgBookmakerConfiguration,
				pBeanAdditionalXmlInfoReader);

		eventos.setXmlMatchs(applyBookmakerWordsBlackListToEvents(
				cfgBookmakerConfiguration.getBlackList(),
				eventos.getXmlMatchs()));

		applyLongTermXmlMatchs(eventos.getXmlMatchs());

		if (eventos.getXmlMatchs() != null && eventos.getXmlMatchs().size() > 0) {
			eventos.setXmlMatchs(normalizeStrings(eventos));

			eventos.setXmlMatchs(fillTournamentParticipants(eventos
					.getXmlMatchs()));
		}

		result = new XmlBetFileReaderResult(eventos);

		return result;
	}

	/**
	 * Read xml.
	 * 
	 * @param pFile
	 *            the file
	 * @param cfgBookmakerConfiguration
	 *            the cfg bookmaker configuration
	 * @param pBeanAdditionalXmlInfoReader
	 *            the bean additional xml info reader
	 * @return the xml bookmaker events
	 * @throws XmlReaderException
	 *             the xml reader exception
	 */
	protected abstract XmlBookmakerEvents readXml(InputStream pFile,
			CfgBookmakerConfiguration cfgBookmakerConfiguration,
			final BeanAdditionalXmlInfoReader pBeanAdditionalXmlInfoReader)
			throws XmlReaderException;

}
