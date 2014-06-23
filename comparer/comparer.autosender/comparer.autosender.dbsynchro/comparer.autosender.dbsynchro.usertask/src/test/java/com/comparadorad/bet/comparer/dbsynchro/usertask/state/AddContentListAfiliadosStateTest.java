package com.comparadorad.bet.comparer.dbsynchro.usertask.state;

import javax.inject.Inject;

import org.junit.Test;
import org.springframework.transaction.annotation.Transactional;

import com.comparadorad.bet.comparer.dbsynchro.usertask.exception.StateException;

public class AddContentListAfiliadosStateTest extends AbstractUserTask {

	@Inject
	private AddContentListAfiliadosState addContentListAfiliadosState;

	@Override
	public IState getIState() {
		return addContentListAfiliadosState;
	}

	@Test(expected = StateException.class)
	@Transactional
	public void addContentListAfiliadosState() throws StateException {
		addContentListAfiliadosState.addContentListAfiliadosState();
	}
	
	@Test(expected = StateException.class)
	@Transactional
	public void createUserState() throws StateException {
		addContentListAfiliadosState.createUserState();
	}


	@Test(expected = StateException.class)
	@Transactional
	public void addPaymentListFreeService() throws StateException {
		addContentListAfiliadosState.addPaymentListFreeService();
	}

	@Test(expected = StateException.class)
	@Transactional
	public void addPaymentListLvl1_1Ano() throws StateException {
		addContentListAfiliadosState.addPaymentListLvl1_1Ano();
	}

	@Test(expected = StateException.class)
	@Transactional
	public void addPaymentListLvl1_1Mes() throws StateException {
		addContentListAfiliadosState.addPaymentListLvl1_1Mes();
	}

	@Test(expected = StateException.class)
	@Transactional
	public void addPaymentListLvl1_6Mes() throws StateException {
		addContentListAfiliadosState.addPaymentListLvl1_6Mes();
	}

	@Test(expected = StateException.class)
	@Transactional
	public void addPaymentListLvl2_1Ano() throws StateException {
		addContentListAfiliadosState.addPaymentListLvl2_1Ano();
	}

	@Test(expected = StateException.class)
	@Transactional
	public void addPaymentListLvl2_1Mes() throws StateException {
		addContentListAfiliadosState.addPaymentListLvl2_1Mes();
	}

	@Test(expected = StateException.class)
	@Transactional
	public void addPaymentListLvl2_6Mes() throws StateException {
		addContentListAfiliadosState.addPaymentListLvl2_6Mes();
	}

	@Test(expected = StateException.class)
	@Transactional
	public void addPaymentListLvl3_1Ano() throws StateException {
		addContentListAfiliadosState.addPaymentListLvl3_1Ano();
	}

	@Test(expected = StateException.class)
	@Transactional
	public void addPaymentListLvl3_1Mes() throws StateException {
		addContentListAfiliadosState.addPaymentListLvl3_1Mes();
	}

	@Test(expected = StateException.class)
	@Transactional
	public void addPaymentListLvl3_6Mes() throws StateException {
		addContentListAfiliadosState.addPaymentListLvl3_6Mes();
	}

	@Test(expected = StateException.class)
	@Transactional
	public void addPaymentListRegister() throws StateException {
		addContentListAfiliadosState.addPaymentListRegister();
	}
}
