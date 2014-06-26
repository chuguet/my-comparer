/**
 *
 * Copyright (C) FACTORIA ETSIA S.L.
 * All Rights Reserved.
 * www.factoriaetsia.com
 *
 */
package com.comparadorad.bet.comparer.synchro.reader.filter.plugin.hashkey;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.Stack;

import javax.inject.Inject;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.comparadorad.bet.comparer.model.config.bean.CfgBookmaker;
import com.comparadorad.bet.comparer.synchro.reader.filter.bean.FilterConfigurationBean;
import com.comparadorad.bet.comparer.synchro.reader.filter.bean.RtMatchFilterIdentificator;
import com.comparadorad.bet.comparer.synchro.reader.filter.config.AbstractReaderFilterConfig;
import com.comparadorad.bet.comparer.synchro.reader.filter.exception.FilterException;
import com.comparadorad.bet.comparer.synchro.reader.filter.exception.FilterListNotFoundException;
import com.comparadorad.bet.comparer.synchro.reader.filter.exception.FilterNotFoundException;
import com.comparadorad.bet.comparer.synchro.reader.filter.exception.HashKeyFilterException;
import com.comparadorad.bet.comparer.synchro.reader.filter.plugin.PluginFilter;
import com.comparadorad.bet.comparer.synchro.reader.filter.plugin.PluginFilterWithIdentificator;
import com.comparadorad.bet.comparer.synchro.reader.model.XmlMarket;
import com.comparadorad.bet.comparer.synchro.reader.model.XmlMarketBet;
import com.comparadorad.bet.comparer.synchro.reader.model.XmlMatch;
import com.comparadorad.bet.comparer.synchro.reader.model.XmlMatchParticipant;

/**
 * The Class HashKeyFilter.
 */
@Component
@Scope("singleton")
final class HashKeyFilter implements PluginFilterWithIdentificator,
		PluginFilter {

	/** The config. */
	@Inject
	private AbstractReaderFilterConfig config;

	/** The filters. */

	/** The calculated hashkey. */
	private Map<CfgBookmaker, Set<RtMatchFilterIdentificator>> calculatedHashkey;

	/** The Constant LOG. */
	private static final Log LOG = LogFactory.getLog(HashKeyFilter.class);

	{
		calculatedHashkey = new HashMap<CfgBookmaker, Set<RtMatchFilterIdentificator>>();
	}

	/**
	 * Encrypt.
	 * 
	 * @param message
	 *            the message
	 * @param codification
	 *            the codification
	 * @param type
	 *            the type
	 * @return the string
	 */
	private static String encrypt(String message, String codification,
			String type) {
		MessageDigest messageDigest;
		byte[] buffer, digest;
		StringBuilder hash;
		hash = new StringBuilder();
		try {
			buffer = message.getBytes(codification);
			messageDigest = MessageDigest.getInstance(type);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
		messageDigest.update(buffer);
		digest = messageDigest.digest();
		for (byte b : digest) {
			hash.append(String.format("%02x", b & 0xff));
		}
		return hash.toString();
	}

	@Override
	public String createHash(XmlMatch match) throws FilterException {
		String valueXmlMatch;
		String result;

		valueXmlMatch = getValuesXmlMatch(match);

		result = encrypt(valueXmlMatch, config.getCodification(),
				config.getHashkeyType());

		return result;

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.comparadorad.bet.comparer.synchro.reader.filter.plugin.PluginFilter
	 * #deleteElement
	 * (com.comparadorad.bet.comparer.synchro.reader.model.XmlMatch,
	 * com.comparadorad.bet.comparer.model.config.bean.CfgBookmaker)
	 */
	@Override
	public Boolean deleteElement(XmlMatch match, CfgBookmaker bookmaker,
			FilterConfigurationBean configurationBean) throws FilterException {

		String hashkey;
		Boolean result = Boolean.FALSE;
		Set<RtMatchFilterIdentificator> filterInformations;
		RtMatchFilterIdentificator filterIdentificator = null;

		hashkey = createHash(match);

		if (calculatedHashkey.containsKey(bookmaker)) {

			filterInformations = calculatedHashkey.get(bookmaker);

			if (configurationBean.getMemoryMaxElement() > filterInformations
					.size()) {

				for (RtMatchFilterIdentificator identificator : filterInformations) {
					if (identificator.getHashkeyXmlMatchs().contains(hashkey)) {
						filterIdentificator = identificator;
						result = Boolean.TRUE;
						break;
					}
				}

				if (!result) {

					filterIdentificator = new RtMatchFilterIdentificator(
							hashkey);

					filterInformations.add(filterIdentificator);

					LOG.info(new StringBuffer(
							"Se introduce en la lista de hash del bookmaker: ")
							.append(bookmaker.getNameId())
							.append(". El elemento: ")
							.append(filterIdentificator));

					calculatedHashkey.put(bookmaker, filterInformations);
				} else {
					LOG.info(new StringBuffer("Existe el hash en el elemento: ")
							.append(filterIdentificator));
				}

			} else {
				LOG.info(new StringBuffer("La lista del ").append(
						bookmaker.getNameId()).append(" esta llena"));
			}

		} else {
			LOG.info(new StringBuffer(
					"No se encontrado la lista de hash para el bookmaker: ")
					.append(bookmaker.getNameId()));

			filterInformations = new HashSet<RtMatchFilterIdentificator>();

			filterInformations.add(new RtMatchFilterIdentificator(hashkey));

			LOG.info(new StringBuffer(
					"Se introduce en la lista de hash del bookmaker: ")
					.append(bookmaker.getNameId()).append(". El elemento: ")
					.append(filterInformations));

			calculatedHashkey.put(bookmaker, filterInformations);
		}

		return result;
	}

	@Override
	public RtMatchFilterIdentificator findRtMatchFilterIdentificator(
			CfgBookmaker bookmaker, String hashXmlMatch) throws FilterException {
		Set<RtMatchFilterIdentificator> filterInformations;
		RtMatchFilterIdentificator result = null;

		if (calculatedHashkey.containsKey(bookmaker)) {

			filterInformations = calculatedHashkey.get(bookmaker);

			for (RtMatchFilterIdentificator identificator : filterInformations) {
				if (identificator.getHashkeyXmlMatchs().contains(hashXmlMatch)) {
					result = identificator;
					break;
				}
			}

			if (result == null) {
				throw new FilterListNotFoundException(new StringBuffer(
						"Not found the match hash: ").append(
						bookmaker.getNameId()).toString());
			}

		} else {
			throw new FilterNotFoundException(new StringBuffer(
					"Not found the match hash: ").append(hashXmlMatch)
					.append(". Not exist list for the bookmaker: ")
					.append(bookmaker.getNameId()).toString());
		}

		return result;

	}

	@Override
	public Boolean completeRtMatchFilterIdentificatorWithXmlMatchHashkey(
			CfgBookmaker bookmaker, String hashkeyXmlMatch,
			String hashkeyRtMatch, List<String> hashKeyMarkets)
			throws FilterException {
		Boolean result = Boolean.FALSE;
		Set<RtMatchFilterIdentificator> filterInformations;
		RtMatchFilterIdentificator filterIdentificator;

		if (calculatedHashkey.containsKey(bookmaker)) {
			filterInformations = calculatedHashkey.get(bookmaker);

			synchronized (filterInformations) {
				for (RtMatchFilterIdentificator rtMatchFilterIdentificator : filterInformations) {

					if (StringUtils.equals(
							rtMatchFilterIdentificator.getHashkeyRtMatch(),
							hashkeyRtMatch)) {

						LOG.info(new StringBuffer(
								"Se encuentra un elemento por hashkey de RtMatch: ")
								.append(rtMatchFilterIdentificator));

						filterIdentificator = rtMatchFilterIdentificator;
						filterInformations.remove(rtMatchFilterIdentificator);
						filterIdentificator.setHashkeyRtMarkets(hashKeyMarkets);
						filterIdentificator.add(hashkeyXmlMatch);
						filterInformations.add(filterIdentificator);

						LOG.info(new StringBuffer(
								"Se rellena elemento y se obtiene: ")
								.append(filterIdentificator));

						result = Boolean.TRUE;
						break;
					} else if (rtMatchFilterIdentificator.getHashkeyXmlMatchs()
							.contains(hashkeyXmlMatch)) {
						LOG.info(new StringBuffer(
								"Se encuentra un elemento por hashkey de XMLMatch: ")
								.append(rtMatchFilterIdentificator));

						filterInformations.remove(rtMatchFilterIdentificator);
						filterIdentificator = new RtMatchFilterIdentificator(
								rtMatchFilterIdentificator.getHashkeyXmlMatchs(),
								hashkeyRtMatch, hashKeyMarkets);

						filterInformations.add(filterIdentificator);

						LOG.info(new StringBuffer(
								"Se rellena elemento y se obtiene: ")
								.append(filterIdentificator));

						result = Boolean.TRUE;
						break;
					}

				}
			}
			

		} else {
			throw new FilterListNotFoundException(new StringBuffer(
					"Not found the market hash: ").append(hashkeyXmlMatch)
					.append(". Not exist list for the bookmaker: ")
					.append(bookmaker.getNameId()).toString());
		}

		return result;
	}

	/**
	 * Returns the haskkey for bookmaker, because the hashkey must go between
	 * process steps.
	 * 
	 * @param bookmaker
	 * @return
	 */
	public Stack<String> getHashKey(CfgBookmaker bookmaker) {
		return null;
	}

	/**
	 * Gets the values xml match.
	 * 
	 * @param match
	 *            the match
	 * @return the values xml match
	 * @throws HashKeyFilterException
	 *             the hash key filter exception
	 */
	private String getValuesXmlMatch(XmlMatch match)
			throws HashKeyFilterException {
		StringBuilder result = new StringBuilder();
		try {
			result.append(match.getLiveId());
			result.append(match.getName());
			result.append(match.getStreaming());
			result.append(match.getCfgObjectId());
			if (match.getBmInternalId() != null) {
				result.append(match.getBmInternalId().getValue());
			}
			for (XmlMatchParticipant xmlMatchParticipant : match
					.getXmlMatchParticipants()) {
				result.append(getValuesXmlMatchParticipants(xmlMatchParticipant));
			}
			for (XmlMarket xmlMarket : match.getXmlMarkets()) {
				result.append(getValuesXmlMatch(xmlMarket));
			}
		} catch (NullPointerException e) {
			LOG.error(e.getMessage());
			throw new HashKeyFilterException(e);
		}
		return result.toString();
	}

	/**
	 * Gets the values xml match.
	 * 
	 * @param market
	 *            the market
	 * @return the values xml match
	 * @throws HashKeyFilterException
	 *             the hash key filter exception
	 */
	private String getValuesXmlMatch(XmlMarket market)
			throws HashKeyFilterException {
		StringBuilder result = new StringBuilder();
		try {
			if (market.getXmlBetType() != null) {
				result.append(market.getXmlBetType().getName());
			} else {
				result.append("null");

			}
			for (XmlMarketBet marketBet : market.getXmlMarketBets()) {
				result.append(getValuesXmlMarketBet(marketBet));
			}
		} catch (NullPointerException e) {
			LOG.error(e.getMessage());
			throw new HashKeyFilterException(e);
		}
		return result.toString();
	}

	/**
	 * Gets the values xml match participants.
	 * 
	 * @param xmlMatchParticipant
	 *            the xml match participant
	 * @return the values xml match participants
	 * @throws HashKeyFilterException
	 *             the hash key filter exception
	 */
	private String getValuesXmlMatchParticipants(
			XmlMatchParticipant xmlMatchParticipant)
			throws HashKeyFilterException {

		StringBuilder result = new StringBuilder();
		try {
			result.append(xmlMatchParticipant.getName());
			result.append(xmlMatchParticipant.getRole());
			if (xmlMatchParticipant.getBmInternalId() != null) {
				result.append(xmlMatchParticipant.getBmInternalId().getValue());
			}
			result.append(xmlMatchParticipant.getCfgObjectId());
		} catch (NullPointerException e) {
			LOG.error(e.getMessage());
			throw new HashKeyFilterException(e);
		}
		return result.toString();
	}

	/**
	 * Gets the values xml market bet.
	 * 
	 * @param marketBet
	 *            the market bet
	 * @return the values xml market bet
	 * @throws HashKeyFilterException
	 *             the hash key filter exception
	 */
	private String getValuesXmlMarketBet(XmlMarketBet marketBet)
			throws HashKeyFilterException {
		StringBuilder result = new StringBuilder();
		try {
			if (StringUtils.isNotEmpty(marketBet.getName())) {
				result.append(marketBet.getName());
			}
			result.append(marketBet.getXmlAttribute().getCfgBetTypeId());
			result.append(marketBet.getXmlBetOdd().getOdds());
			result.append(marketBet.getXmlBetOdd().getAmericanOdds());
		} catch (NullPointerException e) {
			LOG.error(e.getMessage());
			throw new HashKeyFilterException(e);
		}
		return result.toString();
	}

}
