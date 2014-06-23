/**
 *
 * Copyright (C) FACTORIA ETSIA S.L.
 * All Rights Reserved.
 * www.factoriaetsia.com
 *
 */
package com.comparadorad.bet.comparer.model.bet.service;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.inject.Inject;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Service;

import com.comparadorad.bet.comparer.model.bet.bean.RtToolbarElementCache;
import com.comparadorad.bet.comparer.model.bet.repository.RtToolbarElementCacheRepository;
import com.comparadorad.bet.comparer.model.core.repository.IGenericRepository;
import com.comparadorad.bet.comparer.model.core.service.AbstractGenericCrudService;

/**
 * The Class RtToolbarElementService.
 */
@Service
public class RtToolbarElementCacheService extends
		AbstractGenericCrudService<RtToolbarElementCache> implements
		IRtToolbarElementCacheService {

	/** The Constant DATE_FORMATTER. */
	private static final SimpleDateFormat DATE_FORMATTER = new SimpleDateFormat(
			"HH:mm:ss");

	/** The Constant LOG. */
	private static final Log LOG = LogFactory
			.getLog(RtToolbarElementCacheService.class);

	@Inject
	private RtToolbarElementCacheRepository toolbarElementCacheRepository;

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.comparadorad.bet.comparer.model.core.service.AbstractGenericCrudService
	 * #getCrudRepository()
	 */
	@Override
	protected IGenericRepository<RtToolbarElementCache> getCrudRepository() {
		return toolbarElementCacheRepository;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.comparadorad.bet.comparer.model.bet.service.IRtToolbarElementService
	 * #generateToolbar()
	 */
	@Override
	public List<RtToolbarElementCache> cacheableToolbar() {
		LOG.info(new StringBuffer(
				"Se comienza el cacheado en base de datos a las ").append(
				DATE_FORMATTER.format(new Date())).toString());
		toolbarElementCacheRepository.deleteAll();
		List<RtToolbarElementCache> firstLevel;
		List<RtToolbarElementCache> secondLevel;
		List<RtToolbarElementCache> thirdLevel;
		List<RtToolbarElementCache> toolbar = new ArrayList<RtToolbarElementCache>();

		firstLevel = toolbarElementCacheRepository.generateFirstLevelToolbar();
		firstLevel = toolbarElementCacheRepository.save(firstLevel);
		for (RtToolbarElementCache firstToolbarElement : firstLevel) {
			secondLevel = toolbarElementCacheRepository
					.generateSecondLevelToolbar(firstToolbarElement,
							firstToolbarElement.getToolbarConfigurable()
									.getObjectId().toString());
			secondLevel = toolbarElementCacheRepository.save(secondLevel);
			for (RtToolbarElementCache secondToolbarElement : secondLevel) {
				thirdLevel = toolbarElementCacheRepository
						.generateThirdLevelToolbar(secondToolbarElement,
								firstToolbarElement.getToolbarConfigurable()
										.getObjectId().toString(),
								secondToolbarElement.getToolbarConfigurable()
										.getObjectId().toString());
				toolbarElementCacheRepository.save(thirdLevel);
			}
		}
		LOG.info(new StringBuffer(
				"Se finaliza el cacheado en base de datos a las ").append(
				DATE_FORMATTER.format(new Date())).toString());
		LOG.info(new StringBuffer(
				"Se comienza la consulta a la tabla de cache a las ").append(
				DATE_FORMATTER.format(new Date())).toString());
		Long count = toolbarElementCacheRepository.count();
		for (int i = 0; i < count; i += 100) {
			toolbar.addAll(toolbarElementCacheRepository.findAllLimit(i));
		}
		LOG.info(new StringBuffer(
				"Se finaliza la consulta a la tabla de cache a las ").append(
				DATE_FORMATTER.format(new Date())).toString());
		return toolbar;
	}

}
