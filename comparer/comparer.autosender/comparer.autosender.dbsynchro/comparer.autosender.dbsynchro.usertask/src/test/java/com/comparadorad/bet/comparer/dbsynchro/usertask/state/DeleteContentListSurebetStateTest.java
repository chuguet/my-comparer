package com.comparadorad.bet.comparer.dbsynchro.usertask.state;

import javax.inject.Inject;

import org.junit.Test;
import org.springframework.transaction.annotation.Transactional;

import com.comparadorad.bet.comparer.dbsynchro.usertask.exception.StateException;

public class DeleteContentListSurebetStateTest extends AbstractUserTask {

	@Inject
	private DeleteContentListSurebetState deleteContentListSurebetState;

	@Override
	public IState getIState() {
		return deleteContentListSurebetState;
	}

	@Test(expected = StateException.class)
	@Transactional
	public void deleteContentListSurebetState() throws StateException {
		deleteContentListSurebetState.deleteContentListSurebetState();
	}

	@Test(expected = StateException.class)
	@Transactional
	public void createUserState() throws StateException {
		deleteContentListSurebetState.createUserState();
	}

	@Test(expected = StateException.class)
	@Transactional
	public void addPaymentListFreeService() throws StateException {
		deleteContentListSurebetState.addPaymentListFreeService();
	}

	@Test(expected = StateException.class)
	@Transactional
	public void addPaymentListLvl1_1Ano() throws StateException {
		deleteContentListSurebetState.addPaymentListLvl1_1Ano();
	}

	@Test(expected = StateException.class)
	@Transactional
	public void addPaymentListLvl1_1Mes() throws StateException {
		deleteContentListSurebetState.addPaymentListLvl1_1Mes();
	}

	@Test(expected = StateException.class)
	@Transactional
	public void addPaymentListLvl1_6Mes() throws StateException {
		deleteContentListSurebetState.addPaymentListLvl1_6Mes();
	}

	@Test(expected = StateException.class)
	@Transactional
	public void addPaymentListLvl2_1Ano() throws StateException {
		deleteContentListSurebetState.addPaymentListLvl2_1Ano();
	}

	@Test(expected = StateException.class)
	@Transactional
	public void addPaymentListLvl2_1Mes() throws StateException {
		deleteContentListSurebetState.addPaymentListLvl2_1Mes();
	}

	@Test(expected = StateException.class)
	@Transactional
	public void addPaymentListLvl2_6Mes() throws StateException {
		deleteContentListSurebetState.addPaymentListLvl2_6Mes();
	}

	@Test(expected = StateException.class)
	@Transactional
	public void addPaymentListLvl3_1Ano() throws StateException {
		deleteContentListSurebetState.addPaymentListLvl3_1Ano();
	}

	@Test(expected = StateException.class)
	@Transactional
	public void addPaymentListLvl3_1Mes() throws StateException {
		deleteContentListSurebetState.addPaymentListLvl3_1Mes();
	}

	@Test(expected = StateException.class)
	@Transactional
	public void addPaymentListLvl3_6Mes() throws StateException {
		deleteContentListSurebetState.addPaymentListLvl3_6Mes();
	}

	@Test(expected = StateException.class)
	@Transactional
	public void addPaymentListRegister() throws StateException {
		deleteContentListSurebetState.addPaymentListRegister();
	}

}
