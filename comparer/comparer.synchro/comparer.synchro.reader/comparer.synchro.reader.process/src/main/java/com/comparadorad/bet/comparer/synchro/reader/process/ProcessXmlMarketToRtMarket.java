/**
 *
 * Copyright (C) FACTORIA ETSIA S.L.
 * All Rights Reserved.
 * www.factoriaetsia.com
 *
 */
package com.comparadorad.bet.comparer.synchro.reader.process;

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
import com.comparadorad.bet.comparer.synchro.reader.process.log.ISynchroErrorEvent;
import com.comparadorad.bet.comparer.synchro.reader.process.xml.know.bean.ExistData;
import com.comparadorad.bet.comparer.synchro.reader.process.xml.know.bean.ExistMatchData;
import com.comparadorad.bet.comparer.synchro.reader.process.xml.know.impl.IExistRtMatch;
import com.comparadorad.bet.comparer.synchro.reader.process.xml.resolver.bean.XmlToRtResolverData;
import com.comparadorad.bet.comparer.synchro.reader.process.xml.resolver.impl.IXmlToRtMatchResolver;

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

	/** The exist rt match. */
	@Inject
	private IExistRtMatch existRtMatch;

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
		ExistData existsData = new ExistData();
		existsData.setBookmaker(bookmaker);
		ExistMatchData existMatchData;
		existsData.setXmlToRtResolverData(resolverData);
		// Compruebo si ya existe alguna casa de apuestas dada de alta en BD
		existMatchData = existRtMatch.exist(item, existsData);
		// Si no existe ninguna referencia anterior en BD es nuevo el proceso
		// de alta
		if (existMatchData.getIsNew()) {
			LOG.debug("El evento no estaba dado de alta previamente con lo que es un alta nueva.");
			rtMatch = matchResolver.resolve(item,new RtMatch(), resolverData);
		} else {
			LOG.debug("El evento ya estaba dado de alta con lo que actualizamos el existente.");
			rtMatch = (RtMatch) existMatchData.getRtData();
		}
		try {
			constraintViolations = validator.validate(rtMatch);
			if (constraintViolations.size() != 0) {
				synchroErrorEvent.errorLog(constraintViolations.toString(),
						item, bookmaker);
			}
		} catch (Throwable e) {
			synchroErrorEvent.errorLog(e.getMessage(), e, item, bookmaker);
		}
		LOG.debug("Fin del procesado del evento. Procedemos a su almacenado en BD");
		return rtMatch;
	}
}
