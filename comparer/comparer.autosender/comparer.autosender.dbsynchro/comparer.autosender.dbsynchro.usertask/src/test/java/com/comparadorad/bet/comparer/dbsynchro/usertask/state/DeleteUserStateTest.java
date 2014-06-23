package com.comparadorad.bet.comparer.dbsynchro.usertask.state;

import javax.inject.Inject;

import org.junit.Test;
import org.springframework.transaction.annotation.Transactional;

import com.comparadorad.bet.comparer.dbsynchro.usertask.exception.StateException;

public class DeleteUserStateTest extends AbstractUserTask {

	@Inject
	private DeleteUserState deleteUserState;

	@Override
	public IState getIState() {
		return deleteUserState;
	}

	@Test(expected = StateException.class)
	@Transactional
	public void createUserState() throws StateException {
		deleteUserState.createUserState();
	}

	@Test(expected = StateException.class)
	@Transactional
	public void addContentListAfiliadosState() throws StateException {
		deleteUserState.addContentListAfiliadosState();
	}

	@Test(expected = StateException.class)
	@Transactional
	public void addContentListBlogState() throws StateException {
		deleteUserState.addContentListBlogState();
	}

	@Test(expected = StateException.class)
	@Transactional
	public void addContentListReferidosState() throws StateException {
		deleteUserState.addContentListReferidosState();
	}

	@Test(expected = StateException.class)
	@Transactional
	public void addContentListSurebetState() throws StateException {
		deleteUserState.addContentListSurebetState();
	}

	@Test(expected = StateException.class)
	@Transactional
	public void addContentListValuebetState() throws StateException {
		deleteUserState.addContentListValuebetState();
	}

	@Test(expected = StateException.class)
	@Transactional
	public void addContentListWebPrincipalState() throws StateException {
		deleteUserState.addContentListWebPrincipalState();
	}

	@Test(expected = StateException.class)
	@Transactional
	public void deleteContentListAfiliadosState() throws StateException {
		deleteUserState.deleteContentListAfiliadosState();
	}

	@Test(expected = StateException.class)
	@Transactional
	public void deleteContentListBlogState() throws StateException {
		deleteUserState.deleteContentListBlogState();
	}

	@Test(expected = StateException.class)
	@Transactional
	public void deleteContentListReferidosState() throws StateException {
		deleteUserState.deleteContentListReferidosState();
	}

	@Test(expected = StateException.class)
	@Transactional
	public void deleteContentListSurebetState() throws StateException {
		deleteUserState.deleteContentListSurebetState();
	}

	@Test(expected = StateException.class)
	@Transactional
	public void deleteContentListValueBetState() throws StateException {
		deleteUserState.deleteContentListValueBetState();
	}

	@Test(expected = StateException.class)
	@Transactional
	public void deleteContentListWebPrincipalState() throws StateException {
		deleteUserState.deleteContentListWebPrincipalState();
	}

	@Test(expected = StateException.class)
	@Transactional
	public void deleteUserState() throws StateException {
		deleteUserState.deleteUserState();
	}

	@Test(expected = StateException.class)
	@Transactional
	public void addPaymentListFreeService() throws StateException {
		deleteUserState.addPaymentListFreeService();
	}

	@Test(expected = StateException.class)
	@Transactional
	public void addPaymentListLvl1_1Ano() throws StateException {
		deleteUserState.addPaymentListLvl1_1Ano();
	}

	@Test(expected = StateException.class)
	@Transactional
	public void addPaymentListLvl1_1Mes() throws StateException {
		deleteUserState.addPaymentListLvl1_1Mes();
	}

	@Test(expected = StateException.class)
	@Transactional
	public void addPaymentListLvl1_6Mes() throws StateException {
		deleteUserState.addPaymentListLvl1_6Mes();
	}

	@Test(expected = StateException.class)
	@Transactional
	public void addPaymentListLvl2_1Ano() throws StateException {
		deleteUserState.addPaymentListLvl2_1Ano();
	}

	@Test(expected = StateException.class)
	@Transactional
	public void addPaymentListLvl2_1Mes() throws StateException {
		deleteUserState.addPaymentListLvl2_1Mes();
	}

	@Test(expected = StateException.class)
	@Transactional
	public void addPaymentListLvl2_6Mes() throws StateException {
		deleteUserState.addPaymentListLvl2_6Mes();
	}

	@Test(expected = StateException.class)
	@Transactional
	public void addPaymentListLvl3_1Ano() throws StateException {
		deleteUserState.addPaymentListLvl3_1Ano();
	}

	@Test(expected = StateException.class)
	@Transactional
	public void addPaymentListLvl3_1Mes() throws StateException {
		deleteUserState.addPaymentListLvl3_1Mes();
	}

	@Test(expected = StateException.class)
	@Transactional
	public void addPaymentListLvl3_6Mes() throws StateException {
		deleteUserState.addPaymentListLvl3_6Mes();
	}

	@Test(expected = StateException.class)
	@Transactional
	public void addPaymentListRegister() throws StateException {
		deleteUserState.addPaymentListRegister();
	}

	@Test(expected = StateException.class)
	@Transactional
	public void modifyPaymentListAfterFreeService() throws StateException {
		deleteUserState.modifyPaymentListAfterFreeService();
	}

	@Test(expected = StateException.class)
	@Transactional
	public void modifyPaymentListAfterPaymentService() throws StateException {
		deleteUserState.modifyPaymentListAfterPaymentService();
	}

	@Test(expected = StateException.class)
	@Transactional
	public void modifyPaymentListFreeService() throws StateException {
		deleteUserState.modifyPaymentListFreeService();
	}

	@Test(expected = StateException.class)
	@Transactional
	public void modifyPaymentListLimb2() throws StateException {
		deleteUserState.modifyPaymentListLimb2();
	}

	@Test(expected = StateException.class)
	@Transactional
	public void modifyPaymentListLimb3() throws StateException {
		deleteUserState.modifyPaymentListLimb3();
	}

	@Test(expected = StateException.class)
	@Transactional
	public void modifyPaymentListLvl1_1Ano() throws StateException {
		deleteUserState.modifyPaymentListLvl1_1Ano();
	}

	@Test(expected = StateException.class)
	@Transactional
	public void modifyPaymentListLvl1_1Mes() throws StateException {
		deleteUserState.modifyPaymentListLvl1_1Mes();
	}

	@Test(expected = StateException.class)
	@Transactional
	public void modifyPaymentListLvl1_6Mes() throws StateException {
		deleteUserState.modifyPaymentListLvl1_6Mes();
	}

	@Test(expected = StateException.class)
	@Transactional
	public void modifyPaymentListLvl2_1Ano() throws StateException {
		deleteUserState.modifyPaymentListLvl2_1Ano();
	}

	@Test(expected = StateException.class)
	@Transactional
	public void modifyPaymentListLvl2_1Mes() throws StateException {
		deleteUserState.modifyPaymentListLvl2_1Mes();
	}

	@Test(expected = StateException.class)
	@Transactional
	public void modifyPaymentListLvl2_6Mes() throws StateException {
		deleteUserState.modifyPaymentListLvl2_6Mes();
	}

	@Test(expected = StateException.class)
	@Transactional
	public void modifyPaymentListLvl3_1Ano() throws StateException {
		deleteUserState.modifyPaymentListLvl3_1Ano();
	}

	@Test(expected = StateException.class)
	@Transactional
	public void modifyPaymentListLvl3_1Mes() throws StateException {
		deleteUserState.modifyPaymentListLvl3_1Mes();
	}

	@Test(expected = StateException.class)
	@Transactional
	public void modifyPaymentListLvl3_6Mes() throws StateException {
		deleteUserState.modifyPaymentListLvl3_6Mes();
	}

	@Test(expected = StateException.class)
	@Transactional
	public void modifyPaymentListRegister() throws StateException {
		deleteUserState.modifyPaymentListRegister();
	}

	@Test(expected = StateException.class)
	@Transactional
	public void changeRoles() throws StateException {
		deleteUserState.changeRoles();
	}

}
