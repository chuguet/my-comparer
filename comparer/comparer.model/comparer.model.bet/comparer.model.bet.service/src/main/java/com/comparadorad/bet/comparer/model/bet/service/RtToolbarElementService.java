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
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import com.comparadorad.bet.comparer.model.bet.bean.RtToolbarElement;
import com.comparadorad.bet.comparer.model.bet.bean.RtToolbarElementCache;
import com.comparadorad.bet.comparer.model.bet.repository.RtToolbarElementRepository;
import com.comparadorad.bet.comparer.model.core.repository.IGenericRepository;
import com.comparadorad.bet.comparer.model.core.service.AbstractGenericCrudService;

/**
 * The Class RtToolbarElementService.
 */
@Service
public class RtToolbarElementService extends
		AbstractGenericCrudService<RtToolbarElement> implements
		IRtToolbarElementService {

	/** The Constant DATE_FORMATTER. */
	private static final SimpleDateFormat DATE_FORMATTER = new SimpleDateFormat(
			"HH:mm:ss");

	/** The Constant LOG. */
	private static final Log LOG = LogFactory
			.getLog(RtToolbarElementService.class);

	/** The rt toolbar element cache service. */
	@Inject
	private RtToolbarElementCacheService rtToolbarElementCacheService;
	
	/** The rt toolbar element repository. */
	@Inject
	private RtToolbarElementRepository rtToolbarElementRepository;

	/**
	 * Convert toolbar elements.
	 * 
	 * @param toolbarCache
	 *            the toolbar cache
	 * @return the list
	 */
	private List<RtToolbarElement> convertToolbarElements(
			List<RtToolbarElementCache> toolbarCache) {
		List<RtToolbarElement> result = new ArrayList<RtToolbarElement>();
		RtToolbarElement toolbarElement;
		for (RtToolbarElementCache toolbarElementCache : toolbarCache) {
			toolbarElement = convertToolbarElements(toolbarElementCache);
			result.add(toolbarElement);
		}
		return result;
	}
	
	/**
	 * Convert toolbar elements.
	 * 
	 * @param toolbarElementCache
	 *            the toolbar element cache
	 * @return the rt toolbar element
	 */
	private RtToolbarElement convertToolbarElements(
			RtToolbarElementCache toolbarElementCache) {
		RtToolbarElement result = null;
		if (toolbarElementCache != null) {
			result = new RtToolbarElement(
					convertToolbarElements(toolbarElementCache
							.getParentElementCache()),
					toolbarElementCache.getToolbarConfigurable(),
					toolbarElementCache.getCoreActiveElement(),
					toolbarElementCache.getObjectId());
		}
		return result;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.comparadorad.bet.comparer.model.bet.service.IRtToolbarElementService
	 * #freeCache()
	 */
	/**
	 * Free cache.
	 */
	@CacheEvict(value = { "toolbarLVL1", "toolbarLVL2", "toolbarLVL3" }, allEntries = true)
	public void freeCache() {
		LOG.info("Se libera la cache de la toolbar");
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.comparadorad.bet.comparer.model.bet.service.IRtToolbarElementService
	 * #generateToolbar()
	 */
	/**
	 * Generate toolbar.
	 */
	@Override
	public void generateToolbar() {
		List<RtToolbarElementCache> toolbarCache = rtToolbarElementCacheService
				.cacheableToolbar();
		List<RtToolbarElement> toolbar = convertToolbarElements(toolbarCache);
		LOG.info(new StringBuffer(
				"Se comienza el copiado a la tabla de la toolbar a las ")
				.append(DATE_FORMATTER.format(new Date())).toString());
		long init = System.currentTimeMillis();
		rtToolbarElementRepository.deleteAll();
		rtToolbarElementRepository.save(toolbar);
		long finish = System.currentTimeMillis();
		LOG.info(new StringBuffer(
				"Se finaliza el copiado a la tabla de la toolbar a las ")
				.append(DATE_FORMATTER.format(new Date())).append(" milis: ")
				.append(finish - init).toString());
		this.freeCache();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.comparadorad.bet.comparer.model.core.service.AbstractGenericCrudService
	 * #getCrudRepository()
	 */
	/**
	 * Gets the crud repository.
	 * 
	 * @return the crud repository
	 */
	@Override
	protected IGenericRepository<RtToolbarElement> getCrudRepository() {
		return rtToolbarElementRepository;
	}

	/**
	 * Gets the first level.
	 * 
	 * @return the first level
	 */
	@Override
	@Cacheable(value = "toolbarLVL1")
	public List<RtToolbarElement> getFirstLevel() {
		return rtToolbarElementRepository.getFirstLevel();
	}

	/**
	 * Gets the second level.
	 * 
	 * @param sportId
	 *            the sport id
	 * @return the second level
	 */
	@Override
	@Cacheable(value = "toolbarLVL2")
	public List<RtToolbarElement> getSecondLevel(String sportId) {
		return rtToolbarElementRepository.getSecondLevel(sportId);
	}

	/**
	 * Gets the third level.
	 * 
	 * @param sportId
	 *            the sport id
	 * @param regionId
	 *            the region id
	 * @return the third level
	 */
	@Override
	@Cacheable(value = "toolbarLVL3")
	public List<RtToolbarElement> getThirdLevel(String sportId, String regionId) {
		return rtToolbarElementRepository.getThirdLevel(sportId, regionId);
	}
}
