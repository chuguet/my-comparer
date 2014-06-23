package com.comparadorad.bet.comparer.dbsynchro.usertask.state;

import javax.inject.Inject;

import org.junit.Test;
import org.springframework.transaction.annotation.Transactional;

import com.comparadorad.bet.comparer.dbsynchro.usertask.exception.StateException;

public class AddContentListSurebetStateTest extends AbstractUserTask {

	@Inject
	private AddContentListSurebetState addContentListSurebetState;

	@Override
	public IState getIState() {
		return addContentListSurebetState;
	}

	@Test(expected = StateException.class)
	@Transactional
	public void addContentListSurebetState() throws StateException {
		addContentListSurebetState.addContentListSurebetState();
	}

	@Test(expected = StateException.class)
	@Transactional
	public void createUserState() throws StateException {
		addContentListSurebetState.createUserState();
	}

	@Test(expected = StateException.class)
	@Transactional
	public void addPaymentListFreeService() throws StateException {
		addContentListSurebetState.addPaymentListFreeService();
	}

	@Test(expected = StateException.class)
	@Transactional
	public void addPaymentListLvl1_1Ano() throws StateException {
		addContentListSurebetState.addPaymentListLvl1_1Ano();
	}

	@Test(expected = StateException.class)
	@Transactional
	public void addPaymentListLvl1_1Mes() throws StateException {
		addContentListSurebetState.addPaymentListLvl1_1Mes();
	}

	@Test(expected = StateException.class)
	@Transactional
	public void addPaymentListLvl1_6Mes() throws StateException {
		addContentListSurebetState.addPaymentListLvl1_6Mes();
	}

	@Test(expected = StateException.class)
	@Transactional
	public void addPaymentListLvl2_1Ano() throws StateException {
		addContentListSurebetState.addPaymentListLvl2_1Ano();
	}

	@Test(expected = StateException.class)
	@Transactional
	public void addPaymentListLvl2_1Mes() throws StateException {
		addContentListSurebetState.addPaymentListLvl2_1Mes();
	}

	@Test(expected = StateException.class)
	@Transactional
	public void addPaymentListLvl2_6Mes() throws StateException {
		addContentListSurebetState.addPaymentListLvl2_6Mes();
	}

	@Test(expected = StateException.class)
	@Transactional
	public void addPaymentListLvl3_1Ano() throws StateException {
		addContentListSurebetState.addPaymentListLvl3_1Ano();
	}

	@Test(expected = StateException.class)
	@Transactional
	public void addPaymentListLvl3_1Mes() throws StateException {
		addContentListSurebetState.addPaymentListLvl3_1Mes();
	}

	@Test(expected = StateException.class)
	@Transactional
	public void addPaymentListLvl3_6Mes() throws StateException {
		addContentListSurebetState.addPaymentListLvl3_6Mes();
	}

	@Test(expected = StateException.class)
	@Transactional
	public void addPaymentListRegister() throws StateException {
		addContentListSurebetState.addPaymentListRegister();
	}

}
