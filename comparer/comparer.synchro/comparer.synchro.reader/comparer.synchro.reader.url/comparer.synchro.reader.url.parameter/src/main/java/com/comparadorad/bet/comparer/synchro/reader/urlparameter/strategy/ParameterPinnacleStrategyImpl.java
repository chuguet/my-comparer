package com.comparadorad.bet.comparer.synchro.reader.urlparameter.strategy;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Component;

import com.comparadorad.bet.comparer.model.config.bean.CfgBookmaker;
import com.comparadorad.bet.comparer.synchro.reader.model.BeanParameterPinnacle;
import com.comparadorad.bet.comparer.synchro.reader.model.XmlMatch;
import com.comparadorad.bet.comparer.synchro.reader.url.core.StrategyType;
import com.comparadorad.bet.comparer.synchro.reader.url.core.bean.UriParameterBean;
import com.comparadorad.bet.comparer.synchro.reader.urlparameter.exception.NoParameterException;
import com.comparadorad.bet.comparer.synchro.reader.urlparameter.exception.UrlParameterException;

@Component
final class ParameterPinnacleStrategyImpl implements ParameterStrategy {

	private static final Log LOG = LogFactory
			.getLog(ParameterPinnacleStrategyImpl.class);

	private final static String value = "last";

	@Override
	public void readParameter(XmlMatch xmlMatch, CfgBookmaker bookmaker)
			throws UrlParameterException {
		
		List<UriParameterBean> parameterBeans;
		BeanParameterPinnacle beanParameterPinnacle;

		LOG.debug("La estrategia para leer parametros es de pinnacle");
		if (xmlMatch.getAbstractBeanParameters() instanceof BeanParameterPinnacle) {
			

			parameterBeans = new ArrayList<UriParameterBean>();
			beanParameterPinnacle = (BeanParameterPinnacle) xmlMatch
					.getAbstractBeanParameters();
			
			parameterBeans.add(new UriParameterBean(value,
					beanParameterPinnacle.getIdTimePinnacle()));
			
			StrategyType.PINNACLE.setUriParameter(parameterBeans);
			
			LOG.debug(new StringBuffer("Se ha añadido los parametros: ").append(
					value).append(beanParameterPinnacle.getIdTimePinnacle()));
			

		} else {
			throw new NoParameterException(
					"La estrategia pinnacle no puede leer ningun parametro de la clase XmlMatch");
		}
	}

	@Override
	public StrategyType getStrategyType() {
		return StrategyType.PINNACLE;
	}

}
