package com.comparadorad.bet.comparer.dbsynchro.usertask.state;

import javax.inject.Inject;

import org.junit.Test;
import org.springframework.transaction.annotation.Transactional;

import com.comparadorad.bet.comparer.dbsynchro.usertask.exception.StateException;

public class CreateUserStateTest extends AbstractUserTask {

	@Inject
	private CreateUserState createUserState;

	@Override
	public IState getIState() {
		return createUserState;
	}

	@Test(expected = StateException.class)
	@Transactional
	public void addContentListAfiliadosState() throws StateException {
		createUserState.addContentListAfiliadosState();
	}

	@Test(expected = StateException.class)
	@Transactional
	public void addContentListBlogState() throws StateException {
		createUserState.addContentListBlogState();
	}

	@Test(expected = StateException.class)
	@Transactional
	public void addContentListReferidosState() throws StateException {
		createUserState.addContentListReferidosState();
	}

	@Test(expected = StateException.class)
	@Transactional
	public void addContentListSurebetState() throws StateException {
		createUserState.addContentListSurebetState();
	}

	@Test(expected = StateException.class)
	@Transactional
	public void addContentListValuebetState() throws StateException {
		createUserState.addContentListValuebetState();
	}

	@Test(expected = StateException.class)
	@Transactional
	public void addContentListWebPrincipalState() throws StateException {
		createUserState.addContentListWebPrincipalState();
	}

	@Test(expected = StateException.class)
	@Transactional
	public void deleteContentListAfiliadosState() throws StateException {
		createUserState.deleteContentListAfiliadosState();
	}

	@Test(expected = StateException.class)
	@Transactional
	public void deleteContentListBlogState() throws StateException {
		createUserState.deleteContentListBlogState();
	}

	@Test(expected = StateException.class)
	@Transactional
	public void deleteContentListReferidosState() throws StateException {
		createUserState.deleteContentListReferidosState();
	}

	@Test(expected = StateException.class)
	@Transactional
	public void deleteContentListSurebetState() throws StateException {
		createUserState.deleteContentListSurebetState();
	}

	@Test(expected = StateException.class)
	@Transactional
	public void deleteContentListValueBetState() throws StateException {
		createUserState.deleteContentListValueBetState();
	}

	@Test(expected = StateException.class)
	@Transactional
	public void deleteContentListWebPrincipalState() throws StateException {
		createUserState.deleteContentListWebPrincipalState();
	}

	@Test(expected = StateException.class)
	@Transactional
	public void createUserState() throws StateException {
		createUserState.createUserState();
	}

	@Test(expected = StateException.class)
	@Transactional
	public void deleteUserState() throws StateException {
		createUserState.deleteUserState();
	}

	@Test(expected = StateException.class)
	@Transactional
	public void modifyPaymentListAfterFreeService() throws StateException {
		createUserState.modifyPaymentListAfterFreeService();
	}

	@Test(expected = StateException.class)
	@Transactional
	public void modifyPaymentListAfterPaymentService() throws StateException {
		createUserState.modifyPaymentListAfterPaymentService();
	}

	@Test(expected = StateException.class)
	@Transactional
	public void modifyPaymentListFreeService() throws StateException {
		createUserState.modifyPaymentListFreeService();
	}

	@Test(expected = StateException.class)
	@Transactional
	public void modifyPaymentListLimb2() throws StateException {
		createUserState.modifyPaymentListLimb2();
	}

	@Test(expected = StateException.class)
	@Transactional
	public void modifyPaymentListLimb3() throws StateException {
		createUserState.modifyPaymentListLimb3();
	}

	@Test(expected = StateException.class)
	@Transactional
	public void modifyPaymentListLvl1_1Ano() throws StateException {
		createUserState.modifyPaymentListLvl1_1Ano();
	}

	@Test(expected = StateException.class)
	@Transactional
	public void modifyPaymentListLvl1_1Mes() throws StateException {
		createUserState.modifyPaymentListLvl1_1Mes();
	}

	@Test(expected = StateException.class)
	@Transactional
	public void modifyPaymentListLvl1_6Mes() throws StateException {
		createUserState.modifyPaymentListLvl1_6Mes();
	}

	@Test(expected = StateException.class)
	@Transactional
	public void modifyPaymentListLvl2_1Ano() throws StateException {
		createUserState.modifyPaymentListLvl2_1Ano();
	}

	@Test(expected = StateException.class)
	@Transactional
	public void modifyPaymentListLvl2_1Mes() throws StateException {
		createUserState.modifyPaymentListLvl2_1Mes();
	}

	@Test(expected = StateException.class)
	@Transactional
	public void modifyPaymentListLvl2_6Mes() throws StateException {
		createUserState.modifyPaymentListLvl2_6Mes();
	}

	@Test(expected = StateException.class)
	@Transactional
	public void modifyPaymentListLvl3_1Ano() throws StateException {
		createUserState.modifyPaymentListLvl3_1Ano();
	}

	@Test(expected = StateException.class)
	@Transactional
	public void modifyPaymentListLvl3_1Mes() throws StateException {
		createUserState.modifyPaymentListLvl3_1Mes();
	}

	@Test(expected = StateException.class)
	@Transactional
	public void modifyPaymentListLvl3_6Mes() throws StateException {
		createUserState.modifyPaymentListLvl3_6Mes();
	}

	@Test(expected = StateException.class)
	@Transactional
	public void modifyPaymentListRegister() throws StateException {
		createUserState.modifyPaymentListRegister();
	}

	@Test(expected = StateException.class)
	@Transactional
	public void changeRoles() throws StateException {
		createUserState.changeRoles();
	}

}
