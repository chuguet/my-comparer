/**
 *
 * Copyright (C) FACTORIA ETSIA S.L.
 * All Rights Reserved.
 * www.factoriaetsia.com
 *
 */
package com.comparadorad.bet.comparer.synchro.valuebet.process.factory;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.comparadorad.bet.comparer.model.config.bean.CfgBetType;
import com.comparadorad.bet.comparer.synchro.valuebet.process.calculate.ICalculateValueBet;

/**
 * The Class FactoryCalculateValueBet.
 */
@Service
class FactoryCalculateValueBet extends AbstractFactoryCalculateValueBet {

	/** The calculate value bets. */
	@Inject
	private List<ICalculateValueBet> calculateValueBets;

	/** {@inheritDoc} */
	@Override
	public ICalculateValueBet calculateValueBet(CfgBetType betType) {
		ICalculateValueBet result = null;
		for (ICalculateValueBet calculateValueBet : calculateValueBets) {
			if (calculateValueBet.getBetTypeId().nameId()
					.equals(betType.getNameId())) {
				result = calculateValueBet;
				break;
			}
		}
		return result;
	}

}
