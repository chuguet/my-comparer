package com.comparadorad.bet.comparer.dbsynchro.usertask.state;

import javax.inject.Inject;

import org.junit.Test;
import org.springframework.transaction.annotation.Transactional;

import com.comparadorad.bet.comparer.dbsynchro.usertask.exception.StateException;

public class ChangeRolesTest extends AbstractUserTask {

	@Inject
	private ChangeRoles changeRoles;

	@Override
	public IState getIState() {
		return changeRoles;
	}

	@Test(expected = StateException.class)
	@Transactional
	public void createUserState() throws StateException {
		changeRoles.createUserState();
	}

	@Test(expected = StateException.class)
	@Transactional
	public void changeRoles() throws StateException {
		changeRoles.changeRoles();
	}

	@Test(expected = StateException.class)
	@Transactional
	public void addPaymentListFreeService() throws StateException {
		changeRoles.addPaymentListFreeService();
	}

	@Test(expected = StateException.class)
	@Transactional
	public void addPaymentListLvl1_1Ano() throws StateException {
		changeRoles.addPaymentListLvl1_1Ano();
	}

	@Test(expected = StateException.class)
	@Transactional
	public void addPaymentListLvl1_1Mes() throws StateException {
		changeRoles.addPaymentListLvl1_1Mes();
	}

	@Test(expected = StateException.class)
	@Transactional
	public void addPaymentListLvl1_6Mes() throws StateException {
		changeRoles.addPaymentListLvl1_6Mes();
	}

	@Test(expected = StateException.class)
	@Transactional
	public void addPaymentListLvl2_1Ano() throws StateException {
		changeRoles.addPaymentListLvl2_1Ano();
	}

	@Test(expected = StateException.class)
	@Transactional
	public void addPaymentListLvl2_1Mes() throws StateException {
		changeRoles.addPaymentListLvl2_1Mes();
	}

	@Test(expected = StateException.class)
	@Transactional
	public void addPaymentListLvl2_6Mes() throws StateException {
		changeRoles.addPaymentListLvl2_6Mes();
	}

	@Test(expected = StateException.class)
	@Transactional
	public void addPaymentListLvl3_1Ano() throws StateException {
		changeRoles.addPaymentListLvl3_1Ano();
	}

	@Test(expected = StateException.class)
	@Transactional
	public void addPaymentListLvl3_1Mes() throws StateException {
		changeRoles.addPaymentListLvl3_1Mes();
	}

	@Test(expected = StateException.class)
	@Transactional
	public void addPaymentListLvl3_6Mes() throws StateException {
		changeRoles.addPaymentListLvl3_6Mes();
	}

	@Test(expected = StateException.class)
	@Transactional
	public void addPaymentListRegister() throws StateException {
		changeRoles.addPaymentListRegister();
	}

}
