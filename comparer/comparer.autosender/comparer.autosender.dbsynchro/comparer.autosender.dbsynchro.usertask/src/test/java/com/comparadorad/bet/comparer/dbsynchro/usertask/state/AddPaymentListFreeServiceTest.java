package com.comparadorad.bet.comparer.dbsynchro.usertask.state;

import javax.inject.Inject;

import org.junit.Test;
import org.springframework.transaction.annotation.Transactional;

import com.comparadorad.bet.comparer.dbsynchro.usertask.exception.StateException;

public class AddPaymentListFreeServiceTest extends AbstractUserTask {

	@Inject
	private AddPaymentListFreeService addPaymentListFreeService;

	@Override
	public IState getIState() {
		return addPaymentListFreeService;
	}

	@Test(expected = StateException.class)
	@Transactional
	public void deleteContentListAfiliadosState() throws StateException {
		addPaymentListFreeService.deleteContentListAfiliadosState();
	}

	@Test(expected = StateException.class)
	@Transactional
	public void deleteContentListBlogState() throws StateException {
		addPaymentListFreeService.deleteContentListBlogState();
	}

	@Test(expected = StateException.class)
	@Transactional
	public void deleteContentListReferidosState() throws StateException {
		addPaymentListFreeService.deleteContentListReferidosState();
	}

	@Test(expected = StateException.class)
	@Transactional
	public void deleteContentListSurebetState() throws StateException {
		addPaymentListFreeService.deleteContentListSurebetState();
	}

	@Test(expected = StateException.class)
	@Transactional
	public void deleteContentListValueBetState() throws StateException {
		addPaymentListFreeService.deleteContentListValueBetState();
	}

	@Test(expected = StateException.class)
	@Transactional
	public void deleteContentListWebPrincipalState() throws StateException {
		addPaymentListFreeService.deleteContentListWebPrincipalState();
	}

	@Test(expected = StateException.class)
	@Transactional
	public void createUserState() throws StateException {
		addPaymentListFreeService.createUserState();
	}

	@Test(expected = StateException.class)
	@Transactional
	public void deleteUserState() throws StateException {
		addPaymentListFreeService.deleteUserState();
	}

	@Test(expected = StateException.class)
	@Transactional
	public void addPaymentListFreeService() throws StateException {
		addPaymentListFreeService.addPaymentListFreeService();
	}

	@Test(expected = StateException.class)
	@Transactional
	public void addPaymentListLvl1_1Ano() throws StateException {
		addPaymentListFreeService.addPaymentListLvl1_1Ano();
	}

	@Test(expected = StateException.class)
	@Transactional
	public void addPaymentListLvl1_1Mes() throws StateException {
		addPaymentListFreeService.addPaymentListLvl1_1Mes();
	}

	@Test(expected = StateException.class)
	@Transactional
	public void addPaymentListLvl1_6Mes() throws StateException {
		addPaymentListFreeService.addPaymentListLvl1_6Mes();
	}

	@Test(expected = StateException.class)
	@Transactional
	public void addPaymentListLvl2_1Ano() throws StateException {
		addPaymentListFreeService.addPaymentListLvl2_1Ano();
	}

	@Test(expected = StateException.class)
	@Transactional
	public void addPaymentListLvl2_1Mes() throws StateException {
		addPaymentListFreeService.addPaymentListLvl2_1Mes();
	}

	@Test(expected = StateException.class)
	@Transactional
	public void addPaymentListLvl2_6Mes() throws StateException {
		addPaymentListFreeService.addPaymentListLvl2_6Mes();
	}

	@Test(expected = StateException.class)
	@Transactional
	public void addPaymentListLvl3_1Ano() throws StateException {
		addPaymentListFreeService.addPaymentListLvl3_1Ano();
	}

	@Test(expected = StateException.class)
	@Transactional
	public void addPaymentListLvl3_1Mes() throws StateException {
		addPaymentListFreeService.addPaymentListLvl3_1Mes();
	}
	
	@Test(expected = StateException.class)
	@Transactional
	public void addPaymentListLvl3_6Mes() throws StateException {
		addPaymentListFreeService.addPaymentListLvl3_6Mes();
	}

	@Test(expected = StateException.class)
	@Transactional
	public void addPaymentListRegister() throws StateException {
		addPaymentListFreeService.addPaymentListRegister();
	}

	@Test(expected = StateException.class)
	@Transactional
	public void modifyPaymentListAfterFreeService() throws StateException {
		addPaymentListFreeService.modifyPaymentListAfterFreeService();
	}

	@Test(expected = StateException.class)
	@Transactional
	public void modifyPaymentListAfterPaymentService() throws StateException {
		addPaymentListFreeService.modifyPaymentListAfterPaymentService();
	}

	@Test(expected = StateException.class)
	@Transactional
	public void modifyPaymentListFreeService() throws StateException {
		addPaymentListFreeService.modifyPaymentListFreeService();
	}

	@Test(expected = StateException.class)
	@Transactional
	public void modifyPaymentListLimb2() throws StateException {
		addPaymentListFreeService.modifyPaymentListLimb2();
	}

	@Test(expected = StateException.class)
	@Transactional
	public void modifyPaymentListLimb3() throws StateException {
		addPaymentListFreeService.modifyPaymentListLimb3();
	}

	@Test(expected = StateException.class)
	@Transactional
	public void modifyPaymentListLvl1_1Ano() throws StateException {
		addPaymentListFreeService.modifyPaymentListLvl1_1Ano();
	}

	@Test(expected = StateException.class)
	@Transactional
	public void modifyPaymentListLvl1_1Mes() throws StateException {
		addPaymentListFreeService.modifyPaymentListLvl1_1Mes();
	}

	@Test(expected = StateException.class)
	@Transactional
	public void modifyPaymentListLvl1_6Mes() throws StateException {
		addPaymentListFreeService.modifyPaymentListLvl1_6Mes();
	}

	@Test(expected = StateException.class)
	@Transactional
	public void modifyPaymentListLvl2_1Ano() throws StateException {
		addPaymentListFreeService.modifyPaymentListLvl2_1Ano();
	}

	@Test(expected = StateException.class)
	@Transactional
	public void modifyPaymentListLvl2_1Mes() throws StateException {
		addPaymentListFreeService.modifyPaymentListLvl2_1Mes();
	}

	@Test(expected = StateException.class)
	@Transactional
	public void modifyPaymentListLvl2_6Mes() throws StateException {
		addPaymentListFreeService.modifyPaymentListLvl2_6Mes();
	}

	@Test(expected = StateException.class)
	@Transactional
	public void modifyPaymentListLvl3_1Ano() throws StateException {
		addPaymentListFreeService.modifyPaymentListLvl3_1Ano();
	}

	@Test(expected = StateException.class)
	@Transactional
	public void modifyPaymentListLvl3_1Mes() throws StateException {
		addPaymentListFreeService.modifyPaymentListLvl3_1Mes();
	}

	@Test(expected = StateException.class)
	@Transactional
	public void modifyPaymentListLvl3_6Mes() throws StateException {
		addPaymentListFreeService.modifyPaymentListLvl3_6Mes();
	}

	@Test(expected = StateException.class)
	@Transactional
	public void modifyPaymentListRegister() throws StateException {
		addPaymentListFreeService.modifyPaymentListRegister();
	}

}
