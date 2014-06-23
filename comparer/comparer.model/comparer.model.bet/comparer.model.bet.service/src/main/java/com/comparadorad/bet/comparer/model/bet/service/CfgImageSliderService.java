/**
 *
 * Copyright (C) FACTORIA ETSIA S.L.
 * All Rights Reserved.
 * www.factoriaetsia.com
 *
 */
package com.comparadorad.bet.comparer.model.bet.service;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.comparadorad.bet.comparer.model.bet.bean.CfgImageSlider;
import com.comparadorad.bet.comparer.model.bet.repository.CfgImageSliderRepository;
import com.comparadorad.bet.comparer.model.core.repository.IGenericRepository;
import com.comparadorad.bet.comparer.model.core.service.AbstractGenericCrudService;


/**
 * The Class ImageSliderConfigService.
 */
@Service
public class CfgImageSliderService extends AbstractGenericCrudService<CfgImageSlider>
		implements ICfgImageSliderService {

	/** The image slider config repository. */
	@Inject
	private CfgImageSliderRepository imageSliderConfigRepository;
	
	/* (non-Javadoc)
	 * @see com.comparadorad.bet.comparer.model.core.service.AbstractGenericCrudService#getCrudRepository()
	 */
	@Override
	protected IGenericRepository<CfgImageSlider> getCrudRepository() {
		return imageSliderConfigRepository;
	}

	
	

}
