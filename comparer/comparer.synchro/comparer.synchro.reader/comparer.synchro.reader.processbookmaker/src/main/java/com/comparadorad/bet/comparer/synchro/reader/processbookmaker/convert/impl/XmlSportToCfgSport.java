/**
 *
 * Copyright (C) FACTORIA ETSIA S.L.
 * All Rights Reserved.
 * www.factoriaetsia.com
 *
 */
package com.comparadorad.bet.comparer.synchro.reader.processbookmaker.convert.impl;

import java.util.Date;
import java.util.Locale;

import javax.inject.Inject;

import org.springframework.stereotype.Component;

import com.comparadorad.bet.comparer.model.config.bean.CfgSport;
import com.comparadorad.bet.comparer.synchro.reader.model.XmlSport;
import com.comparadorad.bet.comparer.synchro.reader.processbookmaker.config.ConfiguredSports;
import com.comparadorad.bet.comparer.synchro.reader.processbookmaker.convert.CustomConvertProcess;
import com.comparadorad.bet.comparer.synchro.reader.processbookmaker.exception.ConvertException;
import com.comparadorad.bet.comparer.synchro.reader.processbookmaker.exception.MultipleSportException;
import com.comparadorad.bet.comparer.synchro.reader.processbookmaker.exception.SportException;
import com.comparadorad.bet.comparer.synchro.reader.processbookmaker.exception.SportInactiveException;
import com.comparadorad.bet.comparer.synchro.reader.processbookmaker.exception.SportNotConfiguredException;
import com.comparadorad.bet.comparer.synchro.reader.processbookmaker.exception.SportNotFoundException;
import com.comparadorad.bet.comparer.synchro.reader.processbookmaker.synonyms.ISynonymsComponent;
import com.comparadorad.bet.comparer.util.logger.core.ComparerWrapperLog;

// TODO: Auto-generated Javadoc
/**
 * The Class XmlTournamentToCfgCompetition.
 */
@Component
public class XmlSportToCfgSport extends AbstractCustomConvertProcess implements CustomConvertProcess {

	/** The Constant LOG. */
	@Inject
	private ComparerWrapperLog LOG;

	/** The synonyms component. */
	@Inject
	private ISynonymsComponent synonymsComponent;

	@Inject
	private ConfiguredSports activeSports;
	
	/**
	 * Convert.
	 * 
	 * @param targetObject
	 *            the target object
	 * @param sourceObject
	 *            the source object
	 * @param pArg2
	 *            the arg2
	 * @param pArg3
	 *            the arg3
	 * @return the object {@inheritDoc}
	 */
	@Override
	public Object convert(Object targetObject, Object sourceObject, Class<?> pArg2, Class<?> pArg3) {
		CfgSport result = null;
		if (sourceObject instanceof XmlSport) {
			XmlSport xmlSport = (XmlSport) sourceObject;
			try {
				LOG.debug(Thread.currentThread(), new StringBuffer().append("Inicio conversion deporte: ").append(xmlSport.getName()).toString());
				if (xmlSport.getName() != null) {
					result = synonymsComponent.findByNameSport(xmlSport.getName().trim());
					if (result != null) {
						if (activeSports.isActiveSport(result.getName(Locale.ENGLISH))) {
							xmlSport.setCfgObjectId(result.getObjectId());
							if (result.getCoreActiveElement() != null && !result.getCoreActiveElement().isActive(new Date())) {
								throw new SportInactiveException(new StringBuffer().append("El deporte ").append(result.getName(null))
										.append(" esta desactivado.").toString());
							}
						} else {
							throw new SportNotConfiguredException(new StringBuffer().append("El deporte ").append(result.getName(null))
									.append(" no esta configurado.").toString());
						}

					}
				} else {
					throw new SportException("El nombre del deporte no viene informado");
				}
			} catch (SportNotFoundException exception) {
				LOG.error(Thread.currentThread(), exception.getMessage(), exception);
				LOG_DATA_NO_PROCESSED.info("Deporte no encontrado: " + xmlSport.getName());
				throw new ConvertException(exception);
			} catch (MultipleSportException e) {
				LOG_DATA_NO_PROCESSED.info("Deporte duplicado en DB: " + xmlSport.getName());
				getSynchroErrorEvent().errorLog(e.getMessage(), e, xmlSport, getCfgBookmaker(), new Date());
				throw new ConvertException(e);
			} catch (SportInactiveException e) {
				LOG_DATA_NO_PROCESSED.info("Deporte inactivo en DB: " + xmlSport.getName());
				getSynchroErrorEvent().errorLog(e.getMessage(), e, xmlSport, getCfgBookmaker(), new Date());
				throw new ConvertException(e);
			} catch (SportNotConfiguredException e) {
				LOG_DATA_NO_PROCESSED.info("Deporte no configurado en DB: " + xmlSport.getName());
				getSynchroErrorEvent().errorLog(e.getMessage(), e, xmlSport, getCfgBookmaker(), new Date());
				throw new ConvertException(e);
			} catch (SportException e) {
				getSynchroErrorEvent().errorLog(e.getMessage(), e, xmlSport, getCfgBookmaker(), new Date());
				throw new ConvertException(e);
			}
		} else {
			LOG.debug(Thread.currentThread(), "No se podido asignar los valores del deporte");
		}
		return result;
	}

	/**
	 * Gets the name.
	 * 
	 * @return the name {@inheritDoc}
	 */
	@Override
	public String getName() {
		return "xmlSportToCfgSport";
	}

}
