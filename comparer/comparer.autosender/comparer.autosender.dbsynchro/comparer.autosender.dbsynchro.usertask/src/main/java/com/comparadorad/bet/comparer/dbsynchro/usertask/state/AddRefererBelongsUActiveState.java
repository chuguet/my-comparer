/**
 *
 * Copyright (C) FACTORIA ETSIA S.L.
 * All Rights Reserved.
 * www.factoriaetsia.com
 *
 */
package com.comparadorad.bet.comparer.dbsynchro.usertask.state;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Component;

import com.comparadorad.bet.comparer.dbsynchro.usertask.exception.StateException;
import com.comparadorad.bet.comparer.model.autosender.bean.ActionType.ActionTypeName;


@Component
public class AddRefererBelongsUActiveState extends AbstractState {

	private static final Log LOG = LogFactory
			.getLog(AddRefererBelongsUActiveState.class);

	@Override
	public ActionTypeName getActionType() {
		return ActionTypeName.ADD_REFERIDOS_NO_PERTENECE_U_ACTIVO;
	}

	@Override
	public Log getLog() {
		return LOG;
	}
	
	@Override
	public void addRefererBelongActive() throws StateException {
		throw new StateException(new StringBuffer(
				"No se puede pasar del estado ")
				.append(this.getClass().getName())
				.append(" al estado ")
				.append(Thread.currentThread().getStackTrace()[1]
						.getMethodName().toString()).toString());
	}

	@Override
	public void createUserState() throws StateException {
		throw new StateException(new StringBuffer(
				"No se puede pasar del estado ")
				.append(this.getClass().getName())
				.append(" al estado ")
				.append(Thread.currentThread().getStackTrace()[1]
						.getMethodName().toString()).toString());
	}

	
}
