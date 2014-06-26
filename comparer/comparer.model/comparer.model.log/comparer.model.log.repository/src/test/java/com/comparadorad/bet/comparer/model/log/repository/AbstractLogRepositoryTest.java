/**
 *
 * Copyright (C) FACTORIA ETSIA S.L.
 * All Rights Reserved.
 * www.factoriaetsia.com
 *
 */
package com.comparadorad.bet.comparer.model.log.repository;

import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.support.AnnotationConfigContextLoader;

import com.comparadorad.bet.comparer.log.repository.config.LogRepositoryConfig;
import com.comparadorad.bet.comparer.model.core.repository.AbstractRepositoryTest;
import com.comparadorad.bet.comparer.model.core.repository.IGenericRepository;
import com.comparadorad.bet.comparer.model.log.bean.LogEvent;
import com.comparadorad.bet.comparer.model.log.bean.LogEvent.LogLevel;
import com.comparadorad.bet.comparer.util.commons.profile.ProfileConstant;

/**
 * The Class AbstractConfigRepositoryTest.
 * 
 * @param <T>
 *            the generic type
 */
@SuppressWarnings("rawtypes")
@ContextConfiguration(classes = { LogRepositoryConfig.class }, loader = AnnotationConfigContextLoader.class)
@ActiveProfiles(ProfileConstant.TEST)
abstract class AbstractLogRepositoryTest<T extends IGenericRepository> extends
		AbstractRepositoryTest<T> {

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.comparadorad.bet.comparer.model.core.repository.AbstractRepositoryTest
	 * #getNewElement()
	 */
	protected Object getNewElement() {
		final LogEvent register = new LogEvent();
		register.setObjectId("1");
		register.setData(new String("data"));
		register.setLogLevel(LogLevel.DEBUG);
		register.setMessage("Message...");
		register.setProcessId("PROCES ID...");
		return register;
	}

}
