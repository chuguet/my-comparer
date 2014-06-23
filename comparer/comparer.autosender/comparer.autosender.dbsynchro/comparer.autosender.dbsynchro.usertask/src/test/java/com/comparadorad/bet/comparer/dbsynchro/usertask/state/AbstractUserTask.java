/**
 *
 * Copyright (C) FACTORIA ETSIA S.L.
 * All Rights Reserved.
 * www.factoriaetsia.com
 *
 */
package com.comparadorad.bet.comparer.dbsynchro.usertask.state;

import javax.inject.Inject;

import org.junit.Test;
import org.springframework.transaction.annotation.Transactional;

import com.comparadorad.bet.comparer.dbsynchro.usertask.AbstractTest;
import com.comparadorad.bet.comparer.dbsynchro.usertask.exception.StateException;
import com.comparadorad.bet.comparer.model.autosender.bean.ActionType;
import com.comparadorad.bet.comparer.model.autosender.service.IUserService;

/**
 * The Class AbstractUserTask.
 */
public abstract class AbstractUserTask extends AbstractTest {

	/**
	 * Gets the i state.
	 * 
	 * @return the i state
	 */
	public abstract IState getIState();

	@Inject
	private IUserService userService;

	/**
	 * Adds the content list afiliados state.
	 * 
	 * @throws StateException
	 *             the state exception
	 */
	@Test
	@Transactional
	public void addContentListAfiliadosState() throws StateException {
		getIState().getUserContext().setActionToExecute(
				ActionType.ActionTypeName.ADD_CONTENT_LIST_AFILIADOS.ordinal());
		getIState().addContentListAfiliadosState();
	}

	/**
	 * Adds the content list blog state.
	 * 
	 * @throws StateException
	 *             the state exception
	 */
	@Test
	@Transactional
	public void addContentListBlogState() throws StateException {
		getIState().getUserContext().setActionToExecute(
				ActionType.ActionTypeName.ADD_CONTENT_LIST_BLOG.ordinal());
		getIState().addContentListBlogState();
	}

	/**
	 * Adds the content list referidos state.
	 * 
	 * @throws StateException
	 *             the state exception
	 */
	@Test
	@Transactional
	public void addContentListReferidosState() throws StateException {
		getIState().getUserContext().setActionToExecute(
				ActionType.ActionTypeName.ADD_CONTENT_LIST_REFERIDOS.ordinal());
		getIState().addContentListReferidosState();
	}

	/**
	 * Adds the content list surebet state.
	 * 
	 * @throws StateException
	 *             the state exception
	 */
	@Test
	@Transactional
	public void addContentListSurebetState() throws StateException {
		getIState().getUserContext().setActionToExecute(
				ActionType.ActionTypeName.ADD_CONTENT_LIST_SUREBET.ordinal());
		getIState().addContentListSurebetState();
	}

	/**
	 * Adds the content list valuebet state.
	 * 
	 * @throws StateException
	 *             the state exception
	 */
	@Test
	@Transactional
	public void addContentListValuebetState() throws StateException {
		getIState().getUserContext().setActionToExecute(
				ActionType.ActionTypeName.ADD_CONTENT_LIST_VALUEBET.ordinal());
		getIState().addContentListValuebetState();
	}

	/**
	 * Adds the content list web principal state.
	 * 
	 * @throws StateException
	 *             the state exception
	 */
	@Test
	@Transactional
	public void addContentListWebPrincipalState() throws StateException {
		getIState().getUserContext().setActionToExecute(
				ActionType.ActionTypeName.ADD_CONTENT_LIST_WEB_PRINCIPAL
						.ordinal());
		getIState().addContentListWebPrincipalState();
	}

	/**
	 * Delete content list afiliados state.
	 * 
	 * @throws StateException
	 *             the state exception
	 */
	@Test
	@Transactional
	public void deleteContentListAfiliadosState() throws StateException {
		getIState().getUserContext().setActionToExecute(
				ActionType.ActionTypeName.DELETE_CONTENT_LIST_AFILIADOS
						.ordinal());
		getIState().deleteContentListAfiliadosState();
	}

	/**
	 * Delete content list blog state.
	 * 
	 * @throws StateException
	 *             the state exception
	 */
	@Test
	@Transactional
	public void deleteContentListBlogState() throws StateException {
		getIState().getUserContext().setActionToExecute(
				ActionType.ActionTypeName.DELETE_CONTENT_LIST_BLOG.ordinal());
		getIState().deleteContentListBlogState();
	}

	/**
	 * Delete content list referidos state.
	 * 
	 * @throws StateException
	 *             the state exception
	 */
	@Test
	@Transactional
	public void deleteContentListReferidosState() throws StateException {
		getIState().getUserContext().setActionToExecute(
				ActionType.ActionTypeName.DELETE_CONTENT_LIST_REFERIDOS
						.ordinal());
		getIState().deleteContentListReferidosState();
	}

	/**
	 * Delete content list surebet state.
	 * 
	 * @throws StateException
	 *             the state exception
	 */
	@Test
	@Transactional
	public void deleteContentListSurebetState() throws StateException {
		getIState().getUserContext()
				.setActionToExecute(
						ActionType.ActionTypeName.DELETE_CONTENT_LIST_SUREBET
								.ordinal());
		getIState().deleteContentListSurebetState();
	}

	/**
	 * Delete content list value bet state.
	 * 
	 * @throws StateException
	 *             the state exception
	 */
	@Test
	@Transactional
	public void deleteContentListValueBetState() throws StateException {
		getIState().getUserContext().setActionToExecute(
				ActionType.ActionTypeName.DELETE_CONTENT_LIST_VALUEBET
						.ordinal());
		getIState().deleteContentListValueBetState();
	}

	/**
	 * Delete content list web principal state.
	 * 
	 * @throws StateException
	 *             the state exception
	 */
	@Test
	@Transactional
	public void deleteContentListWebPrincipalState() throws StateException {
		getIState().getUserContext().setActionToExecute(
				ActionType.ActionTypeName.DELETE_CONTENT_LIST_WEB_PRINCIPAL
						.ordinal());
		getIState().deleteContentListWebPrincipalState();
	}

	/**
	 * Creates the user state.
	 * 
	 * @throws StateException
	 *             the state exception
	 */
	@Test
	@Transactional
	public void createUserState() throws StateException {
		getIState().getUserContext().setActionToExecute(
				ActionType.ActionTypeName.CREATE_USER.ordinal());
		getIState().createUserState();
	}

	/**
	 * Delete user state.
	 * 
	 * @throws StateException
	 *             the state exception
	 */
	@Test
	@Transactional
	public void deleteUserState() throws StateException {
		getIState().getUserContext().setUser(
				userService.findByLiferayId(super.getLiferayId()));
		getIState().getUserContext().setActionToExecute(
				ActionType.ActionTypeName.DELETE_USER.ordinal());
		getIState().deleteUserState();
	}

	/**
	 * Adds the payment list free service.
	 * 
	 * @throws StateException
	 *             the state exception
	 */
	@Test
	@Transactional
	public void addPaymentListFreeService() throws StateException {
		getIState().getUserContext().setActionToExecute(
				ActionType.ActionTypeName.ADD_PAYMENT_LIST_FREE_SERVICE
						.ordinal());
		getIState().addPaymentListFreeService();
	}

	/**
	 * Adds the payment list lvl1_1 ano.
	 * 
	 * @throws StateException
	 *             the state exception
	 */
	@Test
	@Transactional
	public void addPaymentListLvl1_1Ano() throws StateException {
		getIState().getUserContext()
				.setActionToExecute(
						ActionType.ActionTypeName.ADD_PAYMENT_LIST_LVL_1_1ANO
								.ordinal());
		getIState().addPaymentListLvl1_1Ano();
	}

	/**
	 * Adds the payment list lvl1_1 mes.
	 * 
	 * @throws StateException
	 *             the state exception
	 */
	@Test
	@Transactional
	public void addPaymentListLvl1_1Mes() throws StateException {
		getIState().getUserContext()
				.setActionToExecute(
						ActionType.ActionTypeName.ADD_PAYMENT_LIST_LVL_1_1MES
								.ordinal());
		getIState().addPaymentListLvl1_1Mes();
	}

	/**
	 * Adds the payment list lvl1_6 mes.
	 * 
	 * @throws StateException
	 *             the state exception
	 */
	@Test
	@Transactional
	public void addPaymentListLvl1_6Mes() throws StateException {
		getIState().getUserContext()
				.setActionToExecute(
						ActionType.ActionTypeName.ADD_PAYMENT_LIST_LVL_1_6MES
								.ordinal());
		getIState().addPaymentListLvl1_6Mes();
	}

	/**
	 * Adds the payment list lvl2_1 ano.
	 * 
	 * @throws StateException
	 *             the state exception
	 */
	@Test
	@Transactional
	public void addPaymentListLvl2_1Ano() throws StateException {
		getIState().getUserContext()
				.setActionToExecute(
						ActionType.ActionTypeName.ADD_PAYMENT_LIST_LVL_2_1ANO
								.ordinal());
		getIState().addPaymentListLvl2_1Ano();
	}

	/**
	 * Adds the payment list lvl2_1 mes.
	 * 
	 * @throws StateException
	 *             the state exception
	 */
	@Test
	@Transactional
	public void addPaymentListLvl2_1Mes() throws StateException {
		getIState().getUserContext()
				.setActionToExecute(
						ActionType.ActionTypeName.ADD_PAYMENT_LIST_LVL_2_1MES
								.ordinal());
		getIState().addPaymentListLvl2_1Mes();
	}

	/**
	 * Adds the payment list lvl2_6 mes.
	 * 
	 * @throws StateException
	 *             the state exception
	 */
	@Test
	@Transactional
	public void addPaymentListLvl2_6Mes() throws StateException {
		getIState().getUserContext()
				.setActionToExecute(
						ActionType.ActionTypeName.ADD_PAYMENT_LIST_LVL_2_6MES
								.ordinal());
		getIState().addPaymentListLvl2_6Mes();
	}

	/**
	 * Adds the payment list lvl3_1 ano.
	 * 
	 * @throws StateException
	 *             the state exception
	 */
	@Test
	@Transactional
	public void addPaymentListLvl3_1Ano() throws StateException {
		getIState().getUserContext()
				.setActionToExecute(
						ActionType.ActionTypeName.ADD_PAYMENT_LIST_LVL_3_1ANO
								.ordinal());
		getIState().addPaymentListLvl3_1Ano();
	}

	/**
	 * Adds the payment list lvl3_1 mes.
	 * 
	 * @throws StateException
	 *             the state exception
	 */
	@Test
	@Transactional
	public void addPaymentListLvl3_1Mes() throws StateException {
		getIState().getUserContext()
				.setActionToExecute(
						ActionType.ActionTypeName.ADD_PAYMENT_LIST_LVL_3_1MES
								.ordinal());
		getIState().addPaymentListLvl3_1Mes();
	}

	/**
	 * Adds the payment list lvl3_6 mes.
	 * 
	 * @throws StateException
	 *             the state exception
	 */
	@Test
	@Transactional
	public void addPaymentListLvl3_6Mes() throws StateException {
		getIState().getUserContext()
				.setActionToExecute(
						ActionType.ActionTypeName.ADD_PAYMENT_LIST_LVL_3_6MES
								.ordinal());
		getIState().addPaymentListLvl3_6Mes();
	}

	/**
	 * Adds the payment list register.
	 * 
	 * @throws StateException
	 *             the state exception
	 */
	@Test
	@Transactional
	public void addPaymentListRegister() throws StateException {
		getIState().getUserContext().setActionToExecute(
				ActionType.ActionTypeName.ADD_PAYMENT_LIST_REGISTER.ordinal());
		getIState().addPaymentListRegister();
	}

	/**
	 * Modify payment list after free service.
	 * 
	 * @throws StateException
	 *             the state exception
	 */
	@Test
	@Transactional
	public void modifyPaymentListAfterFreeService() throws StateException {
		getIState()
				.getUserContext()
				.setActionToExecute(
						ActionType.ActionTypeName.MODIFY_PAYMENT_LIST_AFTER_FREE_SERVICE
								.ordinal());
		getIState().modifyPaymentListAfterFreeService();
	}

	/**
	 * Modify payment list after payment service.
	 * 
	 * @throws StateException
	 *             the state exception
	 */
	@Test
	@Transactional
	public void modifyPaymentListAfterPaymentService() throws StateException {
		getIState()
				.getUserContext()
				.setActionToExecute(
						ActionType.ActionTypeName.MODIFY_PAYMENT_LIST_AFTER_PAYMENT_SERVICE
								.ordinal());
		getIState().modifyPaymentListAfterPaymentService();
	}

	/**
	 * Modify payment list free service.
	 * 
	 * @throws StateException
	 *             the state exception
	 */
	@Test
	@Transactional
	public void modifyPaymentListFreeService() throws StateException {
		getIState().getUserContext().setActionToExecute(
				ActionType.ActionTypeName.MODIFY_PAYMENT_LIST_FREE_SERVICE
						.ordinal());
		getIState().modifyPaymentListFreeService();
	}

	/**
	 * Modify payment list limb2.
	 * 
	 * @throws StateException
	 *             the state exception
	 */
	@Test
	@Transactional
	public void modifyPaymentListLimb2() throws StateException {
		getIState().getUserContext().setActionToExecute(
				ActionType.ActionTypeName.MODIFY_PAYMENT_LIST_LIMB2.ordinal());
		getIState().modifyPaymentListLimb2();
	}

	/**
	 * Modify payment list limb3.
	 * 
	 * @throws StateException
	 *             the state exception
	 */
	@Test
	@Transactional
	public void modifyPaymentListLimb3() throws StateException {
		getIState().getUserContext().setActionToExecute(
				ActionType.ActionTypeName.MODIFY_PAYMENT_LIST_LIMB3.ordinal());
		getIState().modifyPaymentListLimb3();
	}

	/**
	 * Modify payment list lvl1_1 ano.
	 * 
	 * @throws StateException
	 *             the state exception
	 */
	@Test
	@Transactional
	public void modifyPaymentListLvl1_1Ano() throws StateException {
		getIState().getUserContext().setActionToExecute(
				ActionType.ActionTypeName.MODIFY_PAYMENT_LIST_LVL_1_1ANO
						.ordinal());
		getIState().modifyPaymentListLvl1_1Ano();
	}

	/**
	 * Modify payment list lvl1_1 mes.
	 * 
	 * @throws StateException
	 *             the state exception
	 */
	@Test
	@Transactional
	public void modifyPaymentListLvl1_1Mes() throws StateException {
		getIState().getUserContext().setActionToExecute(
				ActionType.ActionTypeName.MODIFY_PAYMENT_LIST_LVL_1_1MES
						.ordinal());
		getIState().modifyPaymentListLvl1_1Mes();
	}

	/**
	 * Modify payment list lvl1_6 mes.
	 * 
	 * @throws StateException
	 *             the state exception
	 */
	@Test
	@Transactional
	public void modifyPaymentListLvl1_6Mes() throws StateException {
		getIState().getUserContext().setActionToExecute(
				ActionType.ActionTypeName.MODIFY_PAYMENT_LIST_LVL_1_6MES
						.ordinal());
		getIState().modifyPaymentListLvl1_6Mes();
	}

	/**
	 * Modify payment list lvl2_1 ano.
	 * 
	 * @throws StateException
	 *             the state exception
	 */
	@Test
	@Transactional
	public void modifyPaymentListLvl2_1Ano() throws StateException {
		getIState().getUserContext().setActionToExecute(
				ActionType.ActionTypeName.MODIFY_PAYMENT_LIST_LVL_2_1ANO
						.ordinal());
		getIState().modifyPaymentListLvl2_1Ano();
	}

	/**
	 * Modify payment list lvl2_1 mes.
	 * 
	 * @throws StateException
	 *             the state exception
	 */
	@Test
	@Transactional
	public void modifyPaymentListLvl2_1Mes() throws StateException {
		getIState().getUserContext().setActionToExecute(
				ActionType.ActionTypeName.MODIFY_PAYMENT_LIST_LVL_2_1MES
						.ordinal());
		getIState().modifyPaymentListLvl2_1Mes();
	}

	/**
	 * Modify payment list lvl2_6 mes.
	 * 
	 * @throws StateException
	 *             the state exception
	 */
	@Test
	@Transactional
	public void modifyPaymentListLvl2_6Mes() throws StateException {
		getIState().getUserContext().setActionToExecute(
				ActionType.ActionTypeName.MODIFY_PAYMENT_LIST_LVL_2_6MES
						.ordinal());
		getIState().modifyPaymentListLvl2_6Mes();
	}

	/**
	 * Modify payment list lvl3_1 ano.
	 * 
	 * @throws StateException
	 *             the state exception
	 */
	@Test
	@Transactional
	public void modifyPaymentListLvl3_1Ano() throws StateException {
		getIState().getUserContext().setActionToExecute(
				ActionType.ActionTypeName.MODIFY_PAYMENT_LIST_LVL_3_1ANO
						.ordinal());
		getIState().modifyPaymentListLvl3_1Ano();
	}

	/**
	 * Modify payment list lvl3_1 mes.
	 * 
	 * @throws StateException
	 *             the state exception
	 */
	@Test
	@Transactional
	public void modifyPaymentListLvl3_1Mes() throws StateException {
		getIState().getUserContext().setActionToExecute(
				ActionType.ActionTypeName.MODIFY_PAYMENT_LIST_LVL_3_1MES
						.ordinal());
		getIState().modifyPaymentListLvl3_1Mes();
	}

	/**
	 * Modify payment list lvl3_6 mes.
	 * 
	 * @throws StateException
	 *             the state exception
	 */
	@Test
	@Transactional
	public void modifyPaymentListLvl3_6Mes() throws StateException {
		getIState().getUserContext().setActionToExecute(
				ActionType.ActionTypeName.MODIFY_PAYMENT_LIST_LVL_3_6MES
						.ordinal());
		getIState().modifyPaymentListLvl3_6Mes();
	}

	/**
	 * Modify payment list register.
	 * 
	 * @throws StateException
	 *             the state exception
	 */
	@Test
	@Transactional
	public void modifyPaymentListRegister() throws StateException {
		getIState().getUserContext().setActionToExecute(
				ActionType.ActionTypeName.MODIFY_PAYMENT_LIST_REGISTER
						.ordinal());
		getIState().modifyPaymentListRegister();
	}

	/**
	 * Change roles.
	 * 
	 * @throws StateException
	 *             the state exception
	 */
	@Test
	@Transactional
	public void changeRoles() throws StateException {
		getIState().getUserContext().setUser(
				userService.findByLiferayId(super.getLiferayId()));
		getIState().getUserContext().setActionToExecute(
				ActionType.ActionTypeName.CHANGE_ROLES.ordinal());
		getIState().changeRoles();
	}

}
