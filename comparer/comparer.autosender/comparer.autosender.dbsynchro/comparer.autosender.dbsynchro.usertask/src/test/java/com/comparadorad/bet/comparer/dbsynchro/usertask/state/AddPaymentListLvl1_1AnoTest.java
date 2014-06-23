package com.comparadorad.bet.comparer.dbsynchro.usertask.state;

import javax.inject.Inject;

import org.junit.Test;
import org.springframework.transaction.annotation.Transactional;

import com.comparadorad.bet.comparer.dbsynchro.usertask.exception.StateException;

public class AddPaymentListLvl1_1AnoTest extends AbstractUserTask {

	@Inject
	private AddPaymentListLvl1_1Ano addPaymentListLvl1_1Ano;

	@Override
	public IState getIState() {
		return addPaymentListLvl1_1Ano;
	}

	@Test(expected = StateException.class)
	@Transactional
	public void deleteContentListAfiliadosState() throws StateException {
		addPaymentListLvl1_1Ano.deleteContentListAfiliadosState();
	}

	@Test(expected = StateException.class)
	@Transactional
	public void deleteContentListBlogState() throws StateException {
		addPaymentListLvl1_1Ano.deleteContentListBlogState();
	}

	@Test(expected = StateException.class)
	@Transactional
	public void deleteContentListReferidosState() throws StateException {
		addPaymentListLvl1_1Ano.deleteContentListReferidosState();
	}

	@Test(expected = StateException.class)
	@Transactional
	public void deleteContentListSurebetState() throws StateException {
		addPaymentListLvl1_1Ano.deleteContentListSurebetState();
	}

	@Test(expected = StateException.class)
	@Transactional
	public void deleteContentListValueBetState() throws StateException {
		addPaymentListLvl1_1Ano.deleteContentListValueBetState();
	}

	@Test(expected = StateException.class)
	@Transactional
	public void deleteContentListWebPrincipalState() throws StateException {
		addPaymentListLvl1_1Ano.deleteContentListWebPrincipalState();
	}

	@Test(expected = StateException.class)
	@Transactional
	public void createUserState() throws StateException {
		addPaymentListLvl1_1Ano.createUserState();
	}

	@Test(expected = StateException.class)
	@Transactional
	public void deleteUserState() throws StateException {
		addPaymentListLvl1_1Ano.deleteUserState();
	}

	@Test(expected = StateException.class)
	@Transactional
	public void addPaymentListFreeService() throws StateException {
		addPaymentListLvl1_1Ano.addPaymentListFreeService();
	}

	@Test(expected = StateException.class)
	@Transactional
	public void addPaymentListLvl1_1Ano() throws StateException {
		addPaymentListLvl1_1Ano.addPaymentListLvl1_1Ano();
	}
	
	@Test(expected = StateException.class)
	@Transactional
	public void addPaymentListLvl1_1Mes() throws StateException {
		addPaymentListLvl1_1Ano.addPaymentListLvl1_1Mes();
	}

	@Test(expected = StateException.class)
	@Transactional
	public void addPaymentListLvl1_6Mes() throws StateException {
		addPaymentListLvl1_1Ano.addPaymentListLvl1_6Mes();
	}

	@Test(expected = StateException.class)
	@Transactional
	public void addPaymentListLvl2_1Ano() throws StateException {
		addPaymentListLvl1_1Ano.addPaymentListLvl2_1Ano();
	}

	@Test(expected = StateException.class)
	@Transactional
	public void addPaymentListLvl2_1Mes() throws StateException {
		addPaymentListLvl1_1Ano.addPaymentListLvl2_1Mes();
	}

	@Test(expected = StateException.class)
	@Transactional
	public void addPaymentListLvl2_6Mes() throws StateException {
		addPaymentListLvl1_1Ano.addPaymentListLvl2_6Mes();
	}

	@Test(expected = StateException.class)
	@Transactional
	public void addPaymentListLvl3_1Ano() throws StateException {
		addPaymentListLvl1_1Ano.addPaymentListLvl3_1Ano();
	}

	@Test(expected = StateException.class)
	@Transactional
	public void addPaymentListLvl3_1Mes() throws StateException {
		addPaymentListLvl1_1Ano.addPaymentListLvl3_1Mes();
	}

	@Test(expected = StateException.class)
	@Transactional
	public void addPaymentListLvl3_6Mes() throws StateException {
		addPaymentListLvl1_1Ano.addPaymentListLvl3_6Mes();
	}

	@Test(expected = StateException.class)
	@Transactional
	public void addPaymentListRegister() throws StateException {
		addPaymentListLvl1_1Ano.addPaymentListRegister();
	}

	@Test(expected = StateException.class)
	@Transactional
	public void modifyPaymentListAfterFreeService() throws StateException {
		addPaymentListLvl1_1Ano.modifyPaymentListAfterFreeService();
	}

	@Test(expected = StateException.class)
	@Transactional
	public void modifyPaymentListAfterPaymentService() throws StateException {
		addPaymentListLvl1_1Ano.modifyPaymentListAfterPaymentService();
	}

	@Test(expected = StateException.class)
	@Transactional
	public void modifyPaymentListFreeService() throws StateException {
		addPaymentListLvl1_1Ano.modifyPaymentListFreeService();
	}

	@Test(expected = StateException.class)
	@Transactional
	public void modifyPaymentListLimb2() throws StateException {
		addPaymentListLvl1_1Ano.modifyPaymentListLimb2();
	}

	@Test(expected = StateException.class)
	@Transactional
	public void modifyPaymentListLimb3() throws StateException {
		addPaymentListLvl1_1Ano.modifyPaymentListLimb3();
	}

	@Test(expected = StateException.class)
	@Transactional
	public void modifyPaymentListLvl1_1Ano() throws StateException {
		addPaymentListLvl1_1Ano.modifyPaymentListLvl1_1Ano();
	}

	@Test(expected = StateException.class)
	@Transactional
	public void modifyPaymentListLvl1_1Mes() throws StateException {
		addPaymentListLvl1_1Ano.modifyPaymentListLvl1_1Mes();
	}

	@Test(expected = StateException.class)
	@Transactional
	public void modifyPaymentListLvl1_6Mes() throws StateException {
		addPaymentListLvl1_1Ano.modifyPaymentListLvl1_6Mes();
	}

	@Test(expected = StateException.class)
	@Transactional
	public void modifyPaymentListLvl2_1Ano() throws StateException {
		addPaymentListLvl1_1Ano.modifyPaymentListLvl2_1Ano();
	}

	@Test(expected = StateException.class)
	@Transactional
	public void modifyPaymentListLvl2_1Mes() throws StateException {
		addPaymentListLvl1_1Ano.modifyPaymentListLvl2_1Mes();
	}

	@Test(expected = StateException.class)
	@Transactional
	public void modifyPaymentListLvl2_6Mes() throws StateException {
		addPaymentListLvl1_1Ano.modifyPaymentListLvl2_6Mes();
	}

	@Test(expected = StateException.class)
	@Transactional
	public void modifyPaymentListLvl3_1Ano() throws StateException {
		addPaymentListLvl1_1Ano.modifyPaymentListLvl3_1Ano();
	}

	@Test(expected = StateException.class)
	@Transactional
	public void modifyPaymentListLvl3_1Mes() throws StateException {
		addPaymentListLvl1_1Ano.modifyPaymentListLvl3_1Mes();
	}

	@Test(expected = StateException.class)
	@Transactional
	public void modifyPaymentListLvl3_6Mes() throws StateException {
		addPaymentListLvl1_1Ano.modifyPaymentListLvl3_6Mes();
	}

	@Test(expected = StateException.class)
	@Transactional
	public void modifyPaymentListRegister() throws StateException {
		addPaymentListLvl1_1Ano.modifyPaymentListRegister();
	}

}
