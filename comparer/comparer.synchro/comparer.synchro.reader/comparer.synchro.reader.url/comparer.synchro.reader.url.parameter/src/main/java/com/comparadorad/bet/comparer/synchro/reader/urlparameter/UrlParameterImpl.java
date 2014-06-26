/**
 *
 * Copyright (C) FACTORIA ETSIA S.L.
 * All Rights Reserved.
 * www.factoriaetsia.com
 *
 */
package com.comparadorad.bet.comparer.synchro.reader.urlparameter;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.comparadorad.bet.comparer.model.config.bean.CfgBookmaker;
import com.comparadorad.bet.comparer.synchro.reader.model.XmlMatch;
import com.comparadorad.bet.comparer.synchro.reader.urlparameter.exception.UrlParameterException;
import com.comparadorad.bet.comparer.synchro.reader.urlparameter.strategy.ParameterStrategy;

/**
 * The Class UrlParameterImpl.
 */
@Service
public class UrlParameterImpl implements UrlParameter {

	/** The strategies. */
	@Inject
	private List<ParameterStrategy> strategies;

	/** {@inheritDoc} */
	@Override
	public void readParameter(XmlMatch xmlMatch, CfgBookmaker bookmaker) throws UrlParameterException {

		if (xmlMatch != null && bookmaker != null) {
			ParameterStrategy parameterStrategyFound = null;
			for (ParameterStrategy parameterStrategy : strategies) {
				if (parameterStrategy.getStrategyType().getBookmakerId() != null
						&& parameterStrategy.getStrategyType().getBookmakerId()
								.equals(bookmaker.getNameId())) {
					parameterStrategyFound = parameterStrategy;
					break;
				}
			}
			if (parameterStrategyFound != null) {
				parameterStrategyFound.readParameter(xmlMatch, bookmaker);
			}

		}

	}

}
