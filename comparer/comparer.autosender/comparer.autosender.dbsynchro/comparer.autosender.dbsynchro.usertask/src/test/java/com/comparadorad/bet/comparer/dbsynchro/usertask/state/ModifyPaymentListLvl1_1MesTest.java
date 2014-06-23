package com.comparadorad.bet.comparer.dbsynchro.usertask.state;

import javax.inject.Inject;

import org.junit.Test;
import org.springframework.transaction.annotation.Transactional;

import com.comparadorad.bet.comparer.dbsynchro.usertask.exception.StateException;

public class ModifyPaymentListLvl1_1MesTest extends AbstractUserTask {

	@Inject
	private ModifyPaymentListLvl1_1Mes modifyPaymentListLvl1_1Mes;

	@Override
	public IState getIState() {
		return modifyPaymentListLvl1_1Mes;
	}

	@Test(expected = StateException.class)
	@Transactional
	public void createUserState() throws StateException {
		modifyPaymentListLvl1_1Mes.createUserState();
	}

	@Test(expected = StateException.class)
	@Transactional
	public void addPaymentListFreeService() throws StateException {
		modifyPaymentListLvl1_1Mes.addPaymentListFreeService();
	}

	@Test(expected = StateException.class)
	@Transactional
	public void addPaymentListLvl1_1Ano() throws StateException {
		modifyPaymentListLvl1_1Mes.addPaymentListLvl1_1Ano();
	}

	@Test(expected = StateException.class)
	@Transactional
	public void addPaymentListLvl1_1Mes() throws StateException {
		modifyPaymentListLvl1_1Mes.addPaymentListLvl1_1Mes();
	}

	@Test(expected = StateException.class)
	@Transactional
	public void addPaymentListLvl1_6Mes() throws StateException {
		modifyPaymentListLvl1_1Mes.addPaymentListLvl1_6Mes();
	}

	@Test(expected = StateException.class)
	@Transactional
	public void addPaymentListLvl2_1Ano() throws StateException {
		modifyPaymentListLvl1_1Mes.addPaymentListLvl2_1Ano();
	}

	@Test(expected = StateException.class)
	@Transactional
	public void addPaymentListLvl2_1Mes() throws StateException {
		modifyPaymentListLvl1_1Mes.addPaymentListLvl2_1Mes();
	}

	@Test(expected = StateException.class)
	@Transactional
	public void addPaymentListLvl2_6Mes() throws StateException {
		modifyPaymentListLvl1_1Mes.addPaymentListLvl2_6Mes();
	}

	@Test(expected = StateException.class)
	@Transactional
	public void addPaymentListLvl3_1Ano() throws StateException {
		modifyPaymentListLvl1_1Mes.addPaymentListLvl3_1Ano();
	}

	@Test(expected = StateException.class)
	@Transactional
	public void addPaymentListLvl3_1Mes() throws StateException {
		modifyPaymentListLvl1_1Mes.addPaymentListLvl3_1Mes();
	}

	@Test(expected = StateException.class)
	@Transactional
	public void addPaymentListLvl3_6Mes() throws StateException {
		modifyPaymentListLvl1_1Mes.addPaymentListLvl3_6Mes();
	}

	@Test(expected = StateException.class)
	@Transactional
	public void addPaymentListRegister() throws StateException {
		modifyPaymentListLvl1_1Mes.addPaymentListRegister();
	}

	@Test(expected = StateException.class)
	@Transactional
	public void modifyPaymentListLvl1_1Mes() throws StateException {
		modifyPaymentListLvl1_1Mes.modifyPaymentListLvl1_1Mes();
	}

}
