package com.comparadorad.bet.comparer.dbsynchro.usertask.state;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Component;

import com.comparadorad.bet.comparer.dbsynchro.usertask.exception.StateException;
import com.comparadorad.bet.comparer.model.autosender.bean.ActionType.ActionTypeName;

@Component
public class ChangeRoles extends AbstractState {

	private static final Log LOG = LogFactory.getLog(ChangeRoles.class);

	@Override
	public ActionTypeName getActionType() {
		return ActionTypeName.CHANGE_ROLES;
	}

	@Override
	protected Log getLog() {
		return LOG;
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

	@Override
	public void changeRoles() throws StateException {
		throw new StateException(new StringBuffer(
				"No se puede pasar del estado ")
				.append(this.getClass().getName())
				.append(" al estado ")
				.append(Thread.currentThread().getStackTrace()[1]
						.getMethodName().toString()).toString());
	}

	@Override
	public void addPaymentListFreeService() throws StateException {
		throw new StateException(new StringBuffer(
				"No se puede pasar del estado ")
				.append(this.getClass().getName())
				.append(" al estado ")
				.append(Thread.currentThread().getStackTrace()[1]
						.getMethodName().toString()).toString());
	}

	@Override
	public void addPaymentListLvl1_1Ano() throws StateException {
		throw new StateException(new StringBuffer(
				"No se puede pasar del estado ")
				.append(this.getClass().getName())
				.append(" al estado ")
				.append(Thread.currentThread().getStackTrace()[1]
						.getMethodName().toString()).toString());
	}

	@Override
	public void addPaymentListLvl1_1Mes() throws StateException {
		throw new StateException(new StringBuffer(
				"No se puede pasar del estado ")
				.append(this.getClass().getName())
				.append(" al estado ")
				.append(Thread.currentThread().getStackTrace()[1]
						.getMethodName().toString()).toString());
	}

	@Override
	public void addPaymentListLvl1_6Mes() throws StateException {
		throw new StateException(new StringBuffer(
				"No se puede pasar del estado ")
				.append(this.getClass().getName())
				.append(" al estado ")
				.append(Thread.currentThread().getStackTrace()[1]
						.getMethodName().toString()).toString());
	}

	@Override
	public void addPaymentListLvl2_1Ano() throws StateException {
		throw new StateException(new StringBuffer(
				"No se puede pasar del estado ")
				.append(this.getClass().getName())
				.append(" al estado ")
				.append(Thread.currentThread().getStackTrace()[1]
						.getMethodName().toString()).toString());
	}

	@Override
	public void addPaymentListLvl2_1Mes() throws StateException {
		throw new StateException(new StringBuffer(
				"No se puede pasar del estado ")
				.append(this.getClass().getName())
				.append(" al estado ")
				.append(Thread.currentThread().getStackTrace()[1]
						.getMethodName().toString()).toString());
	}

	@Override
	public void addPaymentListLvl2_6Mes() throws StateException {
		throw new StateException(new StringBuffer(
				"No se puede pasar del estado ")
				.append(this.getClass().getName())
				.append(" al estado ")
				.append(Thread.currentThread().getStackTrace()[1]
						.getMethodName().toString()).toString());
	}

	@Override
	public void addPaymentListLvl3_1Ano() throws StateException {
		throw new StateException(new StringBuffer(
				"No se puede pasar del estado ")
				.append(this.getClass().getName())
				.append(" al estado ")
				.append(Thread.currentThread().getStackTrace()[1]
						.getMethodName().toString()).toString());
	}

	@Override
	public void addPaymentListLvl3_1Mes() throws StateException {
		throw new StateException(new StringBuffer(
				"No se puede pasar del estado ")
				.append(this.getClass().getName())
				.append(" al estado ")
				.append(Thread.currentThread().getStackTrace()[1]
						.getMethodName().toString()).toString());
	}

	@Override
	public void addPaymentListLvl3_6Mes() throws StateException {
		throw new StateException(new StringBuffer(
				"No se puede pasar del estado ")
				.append(this.getClass().getName())
				.append(" al estado ")
				.append(Thread.currentThread().getStackTrace()[1]
						.getMethodName().toString()).toString());
	}

	@Override
	public void addPaymentListRegister() throws StateException {
		throw new StateException(new StringBuffer(
				"No se puede pasar del estado ")
				.append(this.getClass().getName())
				.append(" al estado ")
				.append(Thread.currentThread().getStackTrace()[1]
						.getMethodName().toString()).toString());
	}

}
