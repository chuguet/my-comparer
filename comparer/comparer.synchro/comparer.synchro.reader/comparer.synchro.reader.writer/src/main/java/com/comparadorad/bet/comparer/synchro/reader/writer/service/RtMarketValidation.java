/**
 *
 * Copyright (C) FACTORIA ETSIA S.L.
 * All Rights Reserved.
 * www.factoriaetsia.com
 *
 */
package com.comparadorad.bet.comparer.synchro.reader.writer.service;

import java.util.HashSet;
import java.util.Set;

import javax.annotation.Resource;
import javax.inject.Inject;
import javax.validation.ConstraintViolation;
import javax.validation.Validator;

import org.springframework.stereotype.Component;

import com.comparadorad.bet.comparer.bet.bean.validator.CorrectMarketGroup;
import com.comparadorad.bet.comparer.model.bet.bean.RtMarket;
import com.comparadorad.bet.comparer.model.bet.bean.RtMatch;
import com.comparadorad.bet.comparer.synchro.reader.writer.exception.InvalidMarketsException;
import com.comparadorad.bet.comparer.synchro.reader.writer.exception.NoValidMarketsException;
import com.comparadorad.bet.comparer.util.logger.core.ComparerWrapperLog;

/**
 * The Class RtMarketValidation.
 */
@Component
class RtMarketValidation {

	/** The LOG. */
	@Inject
	private ComparerWrapperLog LOG;

	/** The validator. */
	@Inject
	@Resource(name = "getLocalValidatorFactoryBeanConfig")
	private Validator validator;

	/**
	 * Gets the valid markets.
	 * 
	 * @param rtMatch
	 *            the rt match
	 * @return the valid markets
	 * @throws NoValidMarketsException
	 *             the no valid markets exception
	 */
	public Set<RtMarket> getValidMarkets(RtMatch rtMatch)
			throws NoValidMarketsException {
		

		Set<RtMarket> validMarkets;

		try {
			Set<ConstraintViolation<RtMatch>> marketConstraintViolations = validator
					.validate(rtMatch, CorrectMarketGroup.class);
			if (marketConstraintViolations.size() > 0) {
				throw new InvalidMarketsException(marketConstraintViolations,
						rtMatch);
			}

		} catch (InvalidMarketsException e) {
			LOG.error(Thread.currentThread(), new StringBuffer().append("Mercado inválido: ").append(e.getMessage()).toString());
		}

		validMarkets = getValidMarkets(rtMatch.getRtMarkets());

		
		return validMarkets;

	}

	/**
	 * Gets the valid markets.
	 * 
	 * @param rtMarkets
	 *            the rt markets
	 * @return the valid markets
	 * @throws NoValidMarketsException
	 *             the no valid markets exception
	 */
	private Set<RtMarket> getValidMarkets(Set<RtMarket> rtMarkets)
			throws NoValidMarketsException {

		Set<RtMarket> validMarkets = new HashSet<RtMarket>();

		for (RtMarket market : rtMarkets) {
			if (market.isValid()) {
				validMarkets.add(market);
			}
		}
		if (validMarkets.size() == 0) {
			throw new NoValidMarketsException(
					"El partido no tiene ningun mercado valido");
		}

		return validMarkets;
	}
}
