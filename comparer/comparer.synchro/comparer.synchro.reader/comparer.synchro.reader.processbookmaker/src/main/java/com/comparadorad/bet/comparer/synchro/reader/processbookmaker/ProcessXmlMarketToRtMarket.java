/**
 *
 * Copyright (C) FACTORIA ETSIA S.L.
 * All Rights Reserved.
 * www.factoriaetsia.com
 *
 */
package com.comparadorad.bet.comparer.synchro.reader.processbookmaker;

import java.util.Date;
import java.util.Set;

import javax.annotation.Resource;
import javax.inject.Inject;
import javax.validation.ConstraintViolation;
import javax.validation.Validator;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Service;

import com.comparadorad.bet.comparer.model.bet.bean.RtMatch;
import com.comparadorad.bet.comparer.model.config.bean.CfgBookmaker;
import com.comparadorad.bet.comparer.synchro.reader.model.XmlMatch;
import com.comparadorad.bet.comparer.synchro.reader.processbookmaker.exception.BetBySportNotAllowedException;
import com.comparadorad.bet.comparer.synchro.reader.processbookmaker.log.ISynchroErrorEvent;
import com.comparadorad.bet.comparer.synchro.reader.processbookmaker.xml.resolver.bean.XmlToRtResolverData;
import com.comparadorad.bet.comparer.synchro.reader.processbookmaker.xml.resolver.impl.IXmlToRtMatchResolver;

/**
 * The Class ProcessXmlMarketToRtMarket.
 */
@Service
public class ProcessXmlMarketToRtMarket {

	/** The Constant LOG. */
	private static final Log LOG = LogFactory
			.getLog(ProcessXmlMarketToRtMarket.class);

	/** The match resolver. */
	@Inject
	private IXmlToRtMatchResolver matchResolver;

	/** The validator. */
	@Inject
	@Resource(name = "localValidatorFactoryBean")
	private Validator validator;

	/** The synchro error event. */
	@Inject
	private ISynchroErrorEvent synchroErrorEvent;

	/** The constraint violations. */
	private Set<ConstraintViolation<RtMatch>> constraintViolations;

	/**
	 * Process.
	 * 
	 * @param item
	 *            the item
	 * @param bookmaker
	 *            the bookmaker
	 * @return the rt match
	 */
	public RtMatch process(final XmlMatch item, final CfgBookmaker bookmaker) {
		LOG.debug("Inicio del procesado del evento");
		RtMatch rtMatch = null;
		XmlToRtResolverData resolverData = new XmlToRtResolverData(bookmaker);

		// Para algunas casas de apuestas puede venir el xmlMatch a nulo
		// directamente por problemas en sus xml
		if (item != null) {
				try {
					rtMatch = matchResolver.resolve(item, new RtMatch(), resolverData);
				} catch (BetBySportNotAllowedException e1) {
					LOG.warn(e1.getMessage());
				}
			try {
				constraintViolations = validator.validate(rtMatch);
				if (constraintViolations.size() != 0) {
					synchroErrorEvent.errorLog(constraintViolations.toString(),
							item, bookmaker, new Date());
				}
			} catch (Throwable e) {
				synchroErrorEvent.errorLog(e.getMessage(), e, item, bookmaker, new Date());
			}
			LOG.debug("Fin del procesado del evento. Procedemos a su almacenado en BD");
		}

		return rtMatch;
	}
}
