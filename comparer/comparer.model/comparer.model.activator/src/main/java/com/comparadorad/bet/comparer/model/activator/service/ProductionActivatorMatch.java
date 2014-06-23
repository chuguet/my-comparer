/**
 *
 * Copyright (C) FACTORIA ETSIA S.L.
 * All Rights Reserved.
 * www.factoriaetsia.com
 *
 */
package com.comparadorad.bet.comparer.model.activator.service;

import java.math.BigInteger;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.comparadorad.bet.comparer.model.bet.bean.RtBet;
import com.comparadorad.bet.comparer.model.bet.bean.RtMarket;
import com.comparadorad.bet.comparer.model.bet.bean.RtMatch;
import com.comparadorad.bet.comparer.model.config.bean.CfgBookmaker;
import com.comparadorad.bet.comparer.util.commons.profile.ProfileConstant;

/**
 * The Class ProductionActivatorMatch.
 */
@Component
@Scope("singleton")
final class ProductionActivatorMatch extends AbstractActivatorMatch {

	/** The Constant LOG. */
	private static final Log LOG = LogFactory
			.getLog(ProductionActivatorMatch.class);

	/**
	 * Execute.
	 * 
	 * @param match
	 *            the match
	 * @param isNew
	 *            the is new
	 * @return the rt match {@inheritDoc}
	 */
	@Override
	public RtMatch execute(final RtMatch match, final Boolean isNew) {
		RtMatch result = match;
		CfgBookmaker pastBookmaker = null;
		Boolean flag = Boolean.FALSE;
		if (!isNew) {
			for (RtMarket market : match.getRtMarkets()) {
				for (RtBet bet : market.getBets()) {
					if (pastBookmaker != null
							&& !bet.getBookmaker().getObjectId()
									.equals(pastBookmaker.getObjectId())
							&& (!bet.getBookmaker().getGroupId()
									.equals(pastBookmaker.getGroupId()) || bet
									.getBookmaker().getGroupId()
									.equals(BigInteger.ZERO))) {
						flag = Boolean.TRUE;
						break;
					}
					pastBookmaker = bet.getBookmaker();
				}
				if (flag) {
					break;
				}
			}
			if (flag && isMatchActive(match)) {
				LOG.info(new StringBuffer("Se activa partido: ").append(result
						.getHashKey()));
				result.getCoreActiveElement().setActive(Boolean.TRUE);
			} else {
				LOG.info(new StringBuffer("Se desactiva partido: ").append(result
						.getHashKey()));
				result.getCoreActiveElement().setActive(Boolean.FALSE);
			}
		} else {
			if (isMatchActive(match)) {
				LOG.info(new StringBuffer("Se activa partido: ").append(result
						.getHashKey()));
				result.getCoreActiveElement().setActive(Boolean.TRUE);
			} else {
				LOG.info(new StringBuffer("Se desactiva partido: ").append(result
						.getHashKey()));
				result.getCoreActiveElement().setActive(Boolean.FALSE);
			}
		}
		return result;
	}

	/**
	 * Gets the enviroment.
	 * 
	 * @return the enviroment {@inheritDoc}
	 */
	@Override
	public String getEnviroment() {
		return ProfileConstant.PRODUCTION;
	}

}
