package com.comparadorad.bet.comparer.dbsynchro.usertask.state;

import javax.inject.Inject;

import org.junit.Test;
import org.springframework.transaction.annotation.Transactional;

import com.comparadorad.bet.comparer.dbsynchro.usertask.exception.StateException;

public class DeleteContentListAfiliadosStateTest extends AbstractUserTask {

	@Inject
	private DeleteContentListAfiliadosState deleteContentListAfiliadosState;

	@Override
	public IState getIState() {
		return deleteContentListAfiliadosState;
	}

	@Test(expected = StateException.class)
	@Transactional
	public void deleteContentListAfiliadosState() throws StateException {
		deleteContentListAfiliadosState.deleteContentListAfiliadosState();
	}

	@Test(expected = StateException.class)
	@Transactional
	public void createUserState() throws StateException {
		deleteContentListAfiliadosState.createUserState();
	}

	@Test(expected = StateException.class)
	@Transactional
	public void addPaymentListFreeService() throws StateException {
		deleteContentListAfiliadosState.addPaymentListFreeService();
	}

	@Test(expected = StateException.class)
	@Transactional
	public void addPaymentListLvl1_1Ano() throws StateException {
		deleteContentListAfiliadosState.addPaymentListLvl1_1Ano();
	}

	@Test(expected = StateException.class)
	@Transactional
	public void addPaymentListLvl1_1Mes() throws StateException {
		deleteContentListAfiliadosState.addPaymentListLvl1_1Mes();
	}

	@Test(expected = StateException.class)
	@Transactional
	public void addPaymentListLvl1_6Mes() throws StateException {
		deleteContentListAfiliadosState.addPaymentListLvl1_6Mes();
	}

	@Test(expected = StateException.class)
	@Transactional
	public void addPaymentListLvl2_1Ano() throws StateException {
		deleteContentListAfiliadosState.addPaymentListLvl2_1Ano();
	}

	@Test(expected = StateException.class)
	@Transactional
	public void addPaymentListLvl2_1Mes() throws StateException {
		deleteContentListAfiliadosState.addPaymentListLvl2_1Mes();
	}

	@Test(expected = StateException.class)
	@Transactional
	public void addPaymentListLvl2_6Mes() throws StateException {
		deleteContentListAfiliadosState.addPaymentListLvl2_6Mes();
	}

	@Test(expected = StateException.class)
	@Transactional
	public void addPaymentListLvl3_1Ano() throws StateException {
		deleteContentListAfiliadosState.addPaymentListLvl3_1Ano();
	}

	@Test(expected = StateException.class)
	@Transactional
	public void addPaymentListLvl3_1Mes() throws StateException {
		deleteContentListAfiliadosState.addPaymentListLvl3_1Mes();
	}

	@Test(expected = StateException.class)
	@Transactional
	public void addPaymentListLvl3_6Mes() throws StateException {
		deleteContentListAfiliadosState.addPaymentListLvl3_6Mes();
	}

	@Test(expected = StateException.class)
	@Transactional
	public void addPaymentListRegister() throws StateException {
		deleteContentListAfiliadosState.addPaymentListRegister();
	}

}
