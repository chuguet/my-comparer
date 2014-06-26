/**
 *
 * Copyright (C) FACTORIA ETSIA S.L.
 * All Rights Reserved.
 * www.factoriaetsia.com
 *
 */
package com.comparadorad.bet.comparer.synchro.reader.url.maker;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.comparadorad.bet.comparer.model.config.bean.CfgBookmaker;
import com.comparadorad.bet.comparer.synchro.reader.url.maker.bean.BeanUrlMaker;
import com.comparadorad.bet.comparer.synchro.reader.url.maker.exception.CoreUrlMakerException;
import com.comparadorad.bet.comparer.synchro.reader.url.maker.exception.TimeOutReaderURLException;
import com.comparadorad.bet.comparer.synchro.reader.url.maker.strategy.StrategyMakeUrl;

/**
 * The Class MakeUrlImpl.
 */
@Service
final class MakeUrlImpl implements MakeUrl {

	@Inject
	private List<StrategyMakeUrl> makeUrls;

	/**
	 * {@inheritDoc}
	 * 
	 * @throws CoreUrlMakerException
	 * @throws TimeOutReaderURLException
	 */
	@Override
	public List<BeanUrlMaker> getUrl(CfgBookmaker bookmaker)
			throws CoreUrlMakerException, TimeOutReaderURLException {
		StrategyMakeUrl strategyMakeUrlFound = null;
		for (StrategyMakeUrl strategyMakeUrl : makeUrls) {
			if (strategyMakeUrl.getStrategyType().getBookmakerId() == null) {
				strategyMakeUrlFound = strategyMakeUrl;
			} else if (strategyMakeUrl.getStrategyType().getBookmakerId() != null
					&& strategyMakeUrl.getStrategyType().getBookmakerId()
							.equals(bookmaker.getNameId())) {
				strategyMakeUrlFound = strategyMakeUrl;
				break;
			}
		}
		return strategyMakeUrlFound.getUrls(bookmaker);
	}

}
