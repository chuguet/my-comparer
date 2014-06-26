package com.comparadorad.bet.comparer.synchro.reader.urlparameter.strategy;

import com.comparadorad.bet.comparer.model.config.bean.CfgBookmaker;
import com.comparadorad.bet.comparer.synchro.reader.model.XmlMatch;
import com.comparadorad.bet.comparer.synchro.reader.url.core.StrategyType;
import com.comparadorad.bet.comparer.synchro.reader.urlparameter.exception.UrlParameterException;

public interface ParameterStrategy {
	
	void readParameter(XmlMatch xmlMatch, CfgBookmaker bookmaker) throws UrlParameterException;
	
	StrategyType getStrategyType();

}
