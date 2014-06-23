package com.comparadorad.bet.comparer.dbsynchro.usertask.state;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Component;

import com.comparadorad.bet.comparer.dbsynchro.usertask.exception.StateException;
import com.comparadorad.bet.comparer.model.autosender.bean.ActionType.ActionTypeName;

@Component
public class AddPaymentListLvl1_1Mes extends AbstractState {

	private static final Log LOG = LogFactory
			.getLog(AddPaymentListLvl1_1Mes.class);

	@Override
	public ActionTypeName getActionType() {
		return ActionTypeName.ADD_PAYMENT_LIST_LVL_1_1MES;
	}

	@Override
	protected Log getLog() {
		return LOG;
	}

	@Override
	public void deleteContentListAfiliadosState() throws StateException {
		throw new StateException(new StringBuffer(
				"No se puede pasar del estado ")
				.append(this.getClass().getName())
				.append(" al estado ")
				.append(Thread.currentThread().getStackTrace()[1]
						.getMethodName().toString()).toString());
	}

	@Override
	public void deleteContentListBlogState() throws StateException {
		throw new StateException(new StringBuffer(
				"No se puede pasar del estado ")
				.append(this.getClass().getName())
				.append(" al estado ")
				.append(Thread.currentThread().getStackTrace()[1]
						.getMethodName().toString()).toString());
	}

	@Override
	public void deleteContentListReferidosState() throws StateException {
		throw new StateException(new StringBuffer(
				"No se puede pasar del estado ")
				.append(this.getClass().getName())
				.append(" al estado ")
				.append(Thread.currentThread().getStackTrace()[1]
						.getMethodName().toString()).toString());
	}

	@Override
	public void deleteContentListSurebetState() throws StateException {
		throw new StateException(new StringBuffer(
				"No se puede pasar del estado ")
				.append(this.getClass().getName())
				.append(" al estado ")
				.append(Thread.currentThread().getStackTrace()[1]
						.getMethodName().toString()).toString());
	}

	@Override
	public void deleteContentListValueBetState() throws StateException {
		throw new StateException(new StringBuffer(
				"No se puede pasar del estado ")
				.append(this.getClass().getName())
				.append(" al estado ")
				.append(Thread.currentThread().getStackTrace()[1]
						.getMethodName().toString()).toString());
	}

	@Override
	public void deleteContentListWebPrincipalState() throws StateException {
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

	@Override
	public void deleteUserState() throws StateException {
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

	@Override
	public void modifyPaymentListAfterFreeService() throws StateException {
		throw new StateException(new StringBuffer(
				"No se puede pasar del estado ")
				.append(this.getClass().getName())
				.append(" al estado ")
				.append(Thread.currentThread().getStackTrace()[1]
						.getMethodName().toString()).toString());
	}

	@Override
	public void modifyPaymentListAfterPaymentService() throws StateException {
		throw new StateException(new StringBuffer(
				"No se puede pasar del estado ")
				.append(this.getClass().getName())
				.append(" al estado ")
				.append(Thread.currentThread().getStackTrace()[1]
						.getMethodName().toString()).toString());
	}

	@Override
	public void modifyPaymentListFreeService() throws StateException {
		throw new StateException(new StringBuffer(
				"No se puede pasar del estado ")
				.append(this.getClass().getName())
				.append(" al estado ")
				.append(Thread.currentThread().getStackTrace()[1]
						.getMethodName().toString()).toString());
	}

	@Override
	public void modifyPaymentListLimb2() throws StateException {
		throw new StateException(new StringBuffer(
				"No se puede pasar del estado ")
				.append(this.getClass().getName())
				.append(" al estado ")
				.append(Thread.currentThread().getStackTrace()[1]
						.getMethodName().toString()).toString());
	}

	@Override
	public void modifyPaymentListLimb3() throws StateException {
		throw new StateException(new StringBuffer(
				"No se puede pasar del estado ")
				.append(this.getClass().getName())
				.append(" al estado ")
				.append(Thread.currentThread().getStackTrace()[1]
						.getMethodName().toString()).toString());
	}

	@Override
	public void modifyPaymentListLvl1_1Ano() throws StateException {
		throw new StateException(new StringBuffer(
				"No se puede pasar del estado ")
				.append(this.getClass().getName())
				.append(" al estado ")
				.append(Thread.currentThread().getStackTrace()[1]
						.getMethodName().toString()).toString());
	}

	@Override
	public void modifyPaymentListLvl1_1Mes() throws StateException {
		throw new StateException(new StringBuffer(
				"No se puede pasar del estado ")
				.append(this.getClass().getName())
				.append(" al estado ")
				.append(Thread.currentThread().getStackTrace()[1]
						.getMethodName().toString()).toString());
	}

	@Override
	public void modifyPaymentListLvl1_6Mes() throws StateException {
		throw new StateException(new StringBuffer(
				"No se puede pasar del estado ")
				.append(this.getClass().getName())
				.append(" al estado ")
				.append(Thread.currentThread().getStackTrace()[1]
						.getMethodName().toString()).toString());
	}

	@Override
	public void modifyPaymentListLvl2_1Ano() throws StateException {
		throw new StateException(new StringBuffer(
				"No se puede pasar del estado ")
				.append(this.getClass().getName())
				.append(" al estado ")
				.append(Thread.currentThread().getStackTrace()[1]
						.getMethodName().toString()).toString());
	}

	@Override
	public void modifyPaymentListLvl2_1Mes() throws StateException {
		throw new StateException(new StringBuffer(
				"No se puede pasar del estado ")
				.append(this.getClass().getName())
				.append(" al estado ")
				.append(Thread.currentThread().getStackTrace()[1]
						.getMethodName().toString()).toString());
	}

	@Override
	public void modifyPaymentListLvl2_6Mes() throws StateException {
		throw new StateException(new StringBuffer(
				"No se puede pasar del estado ")
				.append(this.getClass().getName())
				.append(" al estado ")
				.append(Thread.currentThread().getStackTrace()[1]
						.getMethodName().toString()).toString());
	}

	@Override
	public void modifyPaymentListLvl3_1Ano() throws StateException {
		throw new StateException(new StringBuffer(
				"No se puede pasar del estado ")
				.append(this.getClass().getName())
				.append(" al estado ")
				.append(Thread.currentThread().getStackTrace()[1]
						.getMethodName().toString()).toString());
	}

	@Override
	public void modifyPaymentListLvl3_1Mes() throws StateException {
		throw new StateException(new StringBuffer(
				"No se puede pasar del estado ")
				.append(this.getClass().getName())
				.append(" al estado ")
				.append(Thread.currentThread().getStackTrace()[1]
						.getMethodName().toString()).toString());
	}

	@Override
	public void modifyPaymentListLvl3_6Mes() throws StateException {
		throw new StateException(new StringBuffer(
				"No se puede pasar del estado ")
				.append(this.getClass().getName())
				.append(" al estado ")
				.append(Thread.currentThread().getStackTrace()[1]
						.getMethodName().toString()).toString());
	}

	@Override
	public void modifyPaymentListRegister() throws StateException {
		throw new StateException(new StringBuffer(
				"No se puede pasar del estado ")
				.append(this.getClass().getName())
				.append(" al estado ")
				.append(Thread.currentThread().getStackTrace()[1]
						.getMethodName().toString()).toString());
	}

}
