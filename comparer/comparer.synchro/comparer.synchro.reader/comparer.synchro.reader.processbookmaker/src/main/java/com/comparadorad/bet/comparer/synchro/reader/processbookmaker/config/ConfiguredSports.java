/**
 *
 * Copyright (C) FACTORIA ETSIA S.L.
 * All Rights Reserved.
 * www.factoriaetsia.com
 *
 */
package com.comparadorad.bet.comparer.synchro.reader.processbookmaker.config;

import java.util.Date;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.inject.Inject;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.comparadorad.bet.comparer.model.config.bean.CfgSportActive;
import com.comparadorad.bet.comparer.model.repository.CfgSportActiveRepository;
import com.comparadorad.bet.comparer.util.commons.lang.RemoveAccents;

/**
 * The Class ActiveSports.
 */
@Component
@Scope("singleton")
public class ConfiguredSports {

	/** The Constant LOG. */
	private static final Log LOG = LogFactory.getLog(ConfiguredSports.class);

	/** The sport active repository. */
	@Inject
	private CfgSportActiveRepository sportActiveRepository;

	/** The init time. */
	private static Date initTime;

	/** The active sports. */
	private static List<CfgSportActive> activeSports;

	/** The participants competition separator. */
	@Value("${timeBetweenActiveSports}")
	private int timeBetweenActiveSports;

	static {
		initTime = new Date();
	}

	/**
	 * Inits the.
	 */
	@PostConstruct
	private void init() {
		activeSports = sportActiveRepository.findAll();
		initTime = new Date();
	}

	/**
	 * Checks if is active sport.
	 * 
	 * @param sportName
	 *            the sport name
	 * @return true, if is active sport
	 */
	public Boolean isActiveSport(final String sportName) {
		Boolean result = false;
		String normalizedSportName = RemoveAccents.normalizeString(sportName);
		result = calculateActiveSport(normalizedSportName);
		return result;
	}

	public Boolean isAvailableBet(final String betName, final String sportName) {
		Boolean result = false;
		if (activeSports == null || activeSports.size() == 0 || new Date().getTime() - initTime.getTime() >= timeBetweenActiveSports) {
			if (LOG.isDebugEnabled()) {
				LOG.debug("El tiempo entre comprobaciones ha expirado, buscamos de nuevo en BD");
			}

			activeSports = sportActiveRepository.findAll();
			initTime = new Date();
		}
		for (CfgSportActive sportActive : activeSports) {
			if (sportActive.getSportName().equals(sportName)) {
				for (String bet : sportActive.getBetsBySportAllowed()) {
					if (betName.equals(bet)) {
						LOG.debug(new StringBuffer().append("La apuesta ").append(betName).append(" esta permitida para el deporte ")
								.append(sportName).toString());
						result = true;
						break;
					}
				}
				break;
			}
		}

		return result;
	}

	/**
	 * Calculate active sport.
	 * 
	 * @param sportName
	 *            the sport name
	 * @return true, if successful
	 */
	private Boolean calculateActiveSport(final String sportName) {
		Boolean result = false;
		if (LOG.isDebugEnabled()) {
			LOG.debug(new StringBuffer().append("Calculamos si el deporte: ").append(sportName).append(" esta activo").toString());
		}
		if (activeSports.size() == 0 || new Date().getTime() - initTime.getTime() >= timeBetweenActiveSports) {
			if (LOG.isDebugEnabled()) {
				LOG.debug("El tiempo entre comprobaciones ha expirado, buscamos de nuevo en BD");
			}

			activeSports = sportActiveRepository.findAll();
			initTime = new Date();
		}
		for (CfgSportActive sport : activeSports) {
			if (sport.getSportName().equals(sportName)) {
				if (LOG.isDebugEnabled()) {
					LOG.debug(new StringBuffer().append("El deporte : ").append(sportName).append(" esta configurado").toString());
				}

				result = true;
				break;
			}
		}
		return result;
	}

}
