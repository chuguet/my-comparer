package com.comparadorad.bet.comparer.dbsynchro.usertask.state;

import javax.inject.Inject;

import org.junit.Test;
import org.springframework.transaction.annotation.Transactional;

import com.comparadorad.bet.comparer.dbsynchro.usertask.exception.StateException;

public class StartUserStateTest extends AbstractUserTask {

	@Inject
	private StartUserState startUserState;

	@Override
	public IState getIState() {
		return startUserState;
	}

	@Test
	@Transactional
	public void createUserState() throws StateException {
	}

	@Test(expected = StateException.class)
	@Transactional
	public void addContentListAfiliadosState() throws StateException {
		startUserState.addContentListAfiliadosState();
	}

	@Test(expected = StateException.class)
	@Transactional
	public void addContentListBlogState() throws StateException {
		startUserState.addContentListAfiliadosState();
	}

	@Test(expected = StateException.class)
	@Transactional
	public void addContentListReferidosState() throws StateException {
		startUserState.addContentListAfiliadosState();
	}

	@Test(expected = StateException.class)
	@Transactional
	public void addContentListSurebetState() throws StateException {
		startUserState.addContentListAfiliadosState();
	}

	@Test(expected = StateException.class)
	@Transactional
	public void addContentListValuebetState() throws StateException {
		startUserState.addContentListAfiliadosState();
	}

	@Test(expected = StateException.class)
	@Transactional
	public void addContentListWebPrincipalState() throws StateException {
		startUserState.addContentListAfiliadosState();
	}

	@Test(expected = StateException.class)
	@Transactional
	public void deleteContentListAfiliadosState() throws StateException {
		startUserState.addContentListAfiliadosState();
	}

	@Test(expected = StateException.class)
	@Transactional
	public void deleteContentListBlogState() throws StateException {
		startUserState.addContentListAfiliadosState();
	}

	@Test(expected = StateException.class)
	@Transactional
	public void deleteContentListReferidosState() throws StateException {
		startUserState.addContentListAfiliadosState();
	}

	@Test(expected = StateException.class)
	@Transactional
	public void deleteContentListSurebetState() throws StateException {
		startUserState.addContentListAfiliadosState();
	}

	@Test(expected = StateException.class)
	@Transactional
	public void deleteContentListValueBetState() throws StateException {
		startUserState.addContentListAfiliadosState();
	}

	@Test(expected = StateException.class)
	@Transactional
	public void deleteContentListWebPrincipalState() throws StateException {
		startUserState.addContentListAfiliadosState();
	}

	@Test(expected = StateException.class)
	@Transactional
	public void deleteUserState() throws StateException {
		startUserState.addContentListAfiliadosState();
	}

	@Test(expected = StateException.class)
	@Transactional
	public void addPaymentListFreeService() throws StateException {
		startUserState.addContentListAfiliadosState();
	}

	@Test(expected = StateException.class)
	@Transactional
	public void addPaymentListLvl1_1Ano() throws StateException {
		startUserState.addContentListAfiliadosState();
	}

	@Test(expected = StateException.class)
	@Transactional
	public void addPaymentListLvl1_1Mes() throws StateException {
		startUserState.addContentListAfiliadosState();
	}

	@Test(expected = StateException.class)
	@Transactional
	public void addPaymentListLvl1_6Mes() throws StateException {
		startUserState.addContentListAfiliadosState();
	}

	@Test(expected = StateException.class)
	@Transactional
	public void addPaymentListLvl2_1Ano() throws StateException {
		startUserState.addContentListAfiliadosState();
	}

	@Test(expected = StateException.class)
	@Transactional
	public void addPaymentListLvl2_1Mes() throws StateException {
		startUserState.addContentListAfiliadosState();
	}

	@Test(expected = StateException.class)
	@Transactional
	public void addPaymentListLvl2_6Mes() throws StateException {
		startUserState.addContentListAfiliadosState();
	}

	@Test(expected = StateException.class)
	@Transactional
	public void addPaymentListLvl3_1Ano() throws StateException {
		startUserState.addContentListAfiliadosState();
	}

	@Test(expected = StateException.class)
	@Transactional
	public void addPaymentListLvl3_1Mes() throws StateException {
		startUserState.addContentListAfiliadosState();
	}

	@Test(expected = StateException.class)
	@Transactional
	public void addPaymentListLvl3_6Mes() throws StateException {
		startUserState.addContentListAfiliadosState();
	}

	@Test(expected = StateException.class)
	@Transactional
	public void addPaymentListRegister() throws StateException {
		startUserState.addContentListAfiliadosState();
	}

	@Test(expected = StateException.class)
	@Transactional
	public void modifyPaymentListAfterFreeService() throws StateException {
		startUserState.addContentListAfiliadosState();
	}

	@Test(expected = StateException.class)
	@Transactional
	public void modifyPaymentListAfterPaymentService() throws StateException {
		startUserState.addContentListAfiliadosState();
	}

	@Test(expected = StateException.class)
	@Transactional
	public void modifyPaymentListFreeService() throws StateException {
		startUserState.addContentListAfiliadosState();
	}

	@Test(expected = StateException.class)
	@Transactional
	public void modifyPaymentListLimb2() throws StateException {
		startUserState.addContentListAfiliadosState();
	}

	@Test(expected = StateException.class)
	@Transactional
	public void modifyPaymentListLimb3() throws StateException {
		startUserState.addContentListAfiliadosState();
	}

	@Test(expected = StateException.class)
	@Transactional
	public void modifyPaymentListLvl1_1Ano() throws StateException {
		startUserState.addContentListAfiliadosState();
	}

	@Test(expected = StateException.class)
	@Transactional
	public void modifyPaymentListLvl1_1Mes() throws StateException {
		startUserState.addContentListAfiliadosState();
	}

	@Test(expected = StateException.class)
	@Transactional
	public void modifyPaymentListLvl1_6Mes() throws StateException {
		startUserState.addContentListAfiliadosState();
	}

	@Test(expected = StateException.class)
	@Transactional
	public void modifyPaymentListLvl2_1Ano() throws StateException {
		startUserState.addContentListAfiliadosState();
	}

	@Test(expected = StateException.class)
	@Transactional
	public void modifyPaymentListLvl2_1Mes() throws StateException {
		startUserState.addContentListAfiliadosState();
	}

	@Test(expected = StateException.class)
	@Transactional
	public void modifyPaymentListLvl2_6Mes() throws StateException {
		startUserState.addContentListAfiliadosState();
	}

	@Test(expected = StateException.class)
	@Transactional
	public void modifyPaymentListLvl3_1Ano() throws StateException {
		startUserState.addContentListAfiliadosState();
	}

	@Test(expected = StateException.class)
	@Transactional
	public void modifyPaymentListLvl3_1Mes() throws StateException {
		startUserState.addContentListAfiliadosState();
	}

	@Test(expected = StateException.class)
	@Transactional
	public void modifyPaymentListLvl3_6Mes() throws StateException {
		startUserState.addContentListAfiliadosState();
	}

	@Test(expected = StateException.class)
	@Transactional
	public void modifyPaymentListRegister() throws StateException {
		startUserState.addContentListAfiliadosState();
	}

	@Test(expected = StateException.class)
	@Transactional
	public void changeRoles() throws StateException {
		startUserState.addContentListAfiliadosState();
	}

}
