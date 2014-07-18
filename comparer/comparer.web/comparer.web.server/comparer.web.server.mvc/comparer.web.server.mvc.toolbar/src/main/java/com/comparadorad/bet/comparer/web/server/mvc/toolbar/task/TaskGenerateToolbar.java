/**
 *
 * Copyright (C) FACTORIA ETSIA S.L.
 * All Rights Reserved.
 * www.factoriaetsia.com
 *
 */
package com.comparadorad.bet.comparer.web.server.mvc.toolbar.task;

import javax.inject.Inject;

import org.springframework.context.annotation.Profile;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.comparadorad.bet.comparer.model.bet.service.IRtToolbarElementService;
import com.comparadorad.bet.comparer.util.commons.profile.ProfileConstant;

/**
 * The Class TaskGenerateToolbar.
 */
@Component
@Profile(value = { ProfileConstant.DEV, ProfileConstant.PREPRODUCTION,
		ProfileConstant.PRODUCTION })
class TaskGenerateToolbar implements ITaskGenerateToolbar {

	/** The toolbar element service. */
	@Inject
	private IRtToolbarElementService toolbarElementService;

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.comparadorad.bet.comparer.web.server.mvc.toolbar.task.
	 * ITaskGenerateToolbar#generateToolbar()
	 */
	@Override
	@Scheduled(fixedDelay = 300000)
	public void generateToolbar() {
		toolbarElementService.generateToolbar();
	}

}
