/**
 *
 * Copyright (C) FACTORIA ETSIA S.L.
 * All Rights Reserved.
 * www.factoriaetsia.com
 *
 */
package com.comparadorad.bet.comparer.dbsynchro.usertask.state;

import com.comparadorad.bet.comparer.dbsynchro.usertask.exception.StateException;
import com.comparadorad.bet.comparer.model.autosender.bean.ActionType.ActionTypeName;
import com.comparadorad.bet.comparer.payment.beans.PaymentInfo;
import com.comparadorad.bet.comparer.payment.beans.UserInfo;
import com.comparadorad.bet.comparer.payment.enums.PaymentDuration;
import com.comparadorad.bet.comparer.payment.enums.PaymentType;

/**
 * The Class AbstractState.
 */
public abstract class AbstractState extends AbstractUtil {

	@Override
	public void changeRoles() throws StateException {
		getLog().debug(
				new StringBuffer("Estamos en el estado: ")
						.append(getActionType().toString()));
		super.changeRoles(super.getUserContext().getUser().getUserPayments());
		super.getUserContext().setStateByActionTypeName(
				ActionTypeName.CHANGE_ROLES);
		super.succesAction(super.getUserAction().findOne(
				getUserContext().getActionToExecute()));
		getLog().debug("Fin de cambiar roles a un usuario de liferay");
	}

	/**
	 * Adds the content list afiliados state.
	 * 
	 * @throws StateException
	 *             the state exception {@inheritDoc}
	 */
	@Override
	public void addContentListAfiliadosState() throws StateException {
		getLog().debug(
				new StringBuffer("Estamos en el estado: ")
						.append(getActionType().toString()));
		getLog().info("Añadimos al usuario a la lista de contenido de afiliados");
		super.addContentList(ActionTypeName.ADD_CONTENT_LIST_AFILIADOS
				.getName());
		super.getUserContext().setStateByActionTypeName(
				ActionTypeName.ADD_CONTENT_LIST_AFILIADOS);
		super.succesAction(super.getUserAction().findOne(
				getUserContext().getActionToExecute()));
		getLog().info("Fin de añadir usuario a lista de contenido afiliados");
	}

	/**
	 * Adds the content list blog state.
	 * 
	 * @throws StateException
	 *             the state exception {@inheritDoc}
	 */
	@Override
	public void addContentListBlogState() throws StateException {
		getLog().debug(
				new StringBuffer("Estamos en el estado: ")
						.append(getActionType().toString()));
		getLog().info("Añadimos al usuario a la lista de contenido de blog");
		super.addContentList(ActionTypeName.ADD_CONTENT_LIST_BLOG.getName());
		super.getUserContext().setStateByActionTypeName(
				ActionTypeName.ADD_CONTENT_LIST_BLOG);
		super.succesAction(super.getUserAction().findOne(
				getUserContext().getActionToExecute()));
		getLog().debug("Fin de añadir usuario a lista de contenido blog");
	}

	/**
	 * Adds the content list referidos state.
	 * 
	 * @throws StateException
	 *             the state exception {@inheritDoc}
	 */
	@Override
	public void addContentListReferidosState() throws StateException {
		getLog().debug(
				new StringBuffer("Estamos en el estado: ")
						.append(getActionType().toString()));
		getLog().info("Añadimos al usuario a la lista de contenido de referidos");
		super.addContentList(ActionTypeName.ADD_CONTENT_LIST_REFERIDOS
				.getName());
		super.getUserContext().setStateByActionTypeName(
				ActionTypeName.ADD_CONTENT_LIST_REFERIDOS);
		super.succesAction(super.getUserAction().findOne(
				getUserContext().getActionToExecute()));
		getLog().debug("Fin de añadir usuario a lista de contenido referidos");
	}

	/**
	 * Adds the content list surebet state.
	 * 
	 * @throws StateException
	 *             the state exception {@inheritDoc}
	 */
	@Override
	public void addContentListSurebetState() throws StateException {
		getLog().debug(
				new StringBuffer("Estamos en el estado: ")
						.append(getActionType().toString()));
		getLog().info("Añadimos al usuario a la lista de contenido de apuesta segura");
		super.addContentList(ActionTypeName.ADD_CONTENT_LIST_SUREBET.getName());
		super.getUserContext().setStateByActionTypeName(
				ActionTypeName.ADD_CONTENT_LIST_SUREBET);
		super.succesAction(super.getUserAction().findOne(
				getUserContext().getActionToExecute()));
		getLog().debug("Fin de añadir usuario a lista de contenido surebet");
	}

	/**
	 * Adds the content list valuebet state.
	 * 
	 * @throws StateException
	 *             the state exception {@inheritDoc}
	 */
	@Override
	public void addContentListValuebetState() throws StateException {
		getLog().debug(
				new StringBuffer("Estamos en el estado: ")
						.append(getActionType().toString()));
		getLog().info("Añadimos al usuario a la lista de contenido de apuesta de valor");
		super.addContentList(ActionTypeName.ADD_CONTENT_LIST_VALUEBET.getName());
		super.getUserContext().setStateByActionTypeName(
				ActionTypeName.ADD_CONTENT_LIST_VALUEBET);
		super.succesAction(super.getUserAction().findOne(
				getUserContext().getActionToExecute()));
		getLog().debug("Fin de añadir usuario a lista de contenido valuebet");
	}

	/**
	 * Adds the content list web principal state.
	 * 
	 * @throws StateException
	 *             the state exception {@inheritDoc}
	 */
	@Override
	public void addContentListWebPrincipalState() throws StateException {
		getLog().debug(
				new StringBuffer("Estamos en el estado: ")
						.append(getActionType().toString()));
		getLog().info(
				"Añadimos al usuario a la lista de contenido web principal");
		super.addContentList(ActionTypeName.ADD_CONTENT_LIST_WEB_PRINCIPAL
				.getName());
		super.getUserContext().setStateByActionTypeName(
				ActionTypeName.ADD_CONTENT_LIST_WEB_PRINCIPAL);
		super.succesAction(super.getUserAction().findOne(
				getUserContext().getActionToExecute()));
		getLog().debug(
				"Fin de añadir usuario a lista de contenido web principal");
	}

	/**
	 * Delete content list afiliados state.
	 * 
	 * @throws StateException
	 *             the state exception {@inheritDoc}
	 */
	@Override
	public void deleteContentListAfiliadosState() throws StateException {
		getLog().debug(
				new StringBuffer("Estamos en el estado: ")
						.append(getActionType().toString()));
		getLog().info(
				"Eliminamos al usuario de lista de contenido afiliados");
		super.deleteContentList(ActionTypeName.DELETE_CONTENT_LIST_AFILIADOS
				.getName());
		super.getUserContext().setStateByActionTypeName(
				ActionTypeName.DELETE_CONTENT_LIST_AFILIADOS);
		super.succesAction(super.getUserAction().findOne(
				getUserContext().getActionToExecute()));
		getLog().debug(
				"Fin de eliminar a un usuario de lista de contenido afiliados");
	}

	/**
	 * Delete content list blog state.
	 * 
	 * @throws StateException
	 *             the state exception {@inheritDoc}
	 */
	@Override
	public void deleteContentListBlogState() throws StateException {
		getLog().debug(
				new StringBuffer("Estamos en el estado: ")
						.append(getActionType().toString()));
		getLog().info(
				"Eliminamos al usuario de lista de contenido blog");
		super.deleteContentList(ActionTypeName.DELETE_CONTENT_LIST_BLOG
				.getName());
		super.getUserContext().setStateByActionTypeName(
				ActionTypeName.DELETE_CONTENT_LIST_BLOG);
		super.succesAction(super.getUserAction().findOne(
				getUserContext().getActionToExecute()));
		getLog().debug("Fin de eliminar a un usuario de lista de contenido blog");
	}

	/**
	 * Delete content list referidos state.
	 * 
	 * @throws StateException
	 *             the state exception {@inheritDoc}
	 */
	@Override
	public void deleteContentListReferidosState() throws StateException {
		getLog().debug(
				new StringBuffer("Estamos en el estado: ")
						.append(getActionType().toString()));
		getLog().info(
				"Eliminamos al usuario de lista de contenido referidos");
		super.deleteContentList(ActionTypeName.DELETE_CONTENT_LIST_REFERIDOS
				.getName());
		super.getUserContext().setStateByActionTypeName(
				ActionTypeName.DELETE_CONTENT_LIST_REFERIDOS);
		super.succesAction(super.getUserAction().findOne(
				getUserContext().getActionToExecute()));
		getLog().debug(
				"Fin de eliminar a un usuario de lista de contenido referidos");
	}

	/**
	 * Delete content list surebet state.
	 * 
	 * @throws StateException
	 *             the state exception {@inheritDoc}
	 */
	@Override
	public void deleteContentListSurebetState() throws StateException {
		getLog().debug(
				new StringBuffer("Estamos en el estado: ")
						.append(getActionType().toString()));
		getLog().info(
				"Eliminamos al usuario de lista de contenido surebet");
		super.deleteContentList(ActionTypeName.DELETE_CONTENT_LIST_SUREBET
				.getName());
		super.getUserContext().setStateByActionTypeName(
				ActionTypeName.DELETE_CONTENT_LIST_SUREBET);
		super.succesAction(super.getUserAction().findOne(
				getUserContext().getActionToExecute()));
		getLog().debug(
				"Fin de eliminar a un usuario de lista de contenido surebet");
	}

	/**
	 * Delete content list value bet state.
	 * 
	 * @throws StateException
	 *             the state exception {@inheritDoc}
	 */
	@Override
	public void deleteContentListValueBetState() throws StateException {
		getLog().debug(
				new StringBuffer("Estamos en el estado: ")
						.append(getActionType().toString()));
		getLog().info(
				"Eliminamos al usuario de lista de contenido valuebet");
		super.deleteContentList(ActionTypeName.DELETE_CONTENT_LIST_VALUEBET
				.getName());
		super.getUserContext().setStateByActionTypeName(
				ActionTypeName.DELETE_CONTENT_LIST_VALUEBET);
		super.succesAction(super.getUserAction().findOne(
				getUserContext().getActionToExecute()));
		getLog().debug(
				"Fin de eliminar a un usuario de lista de contenido valuebet");
	}

	/**
	 * Delete content list web principal state.
	 * 
	 * @throws StateException
	 *             the state exception {@inheritDoc}
	 */
	@Override
	public void deleteContentListWebPrincipalState() throws StateException {
		getLog().debug(
				new StringBuffer("Estamos en el estado: ")
						.append(getActionType().toString()));
		getLog().info(
				"Eliminamos al usuario de lista de contenido web principal");
		super.deleteContentList(ActionTypeName.DELETE_CONTENT_LIST_WEB_PRINCIPAL
				.getName());
		super.getUserContext().setStateByActionTypeName(
				ActionTypeName.DELETE_CONTENT_LIST_WEB_PRINCIPAL);
		super.succesAction(super.getUserAction().findOne(
				getUserContext().getActionToExecute()));
		getLog().debug(
				"Fin de eliminar a un usuario de lista de contenido web principal");
	}

//	/**
//	 * Creates the user state.
//	 * 
//	 * @throws StateException
//	 *             the state exception {@inheritDoc}
//	 */
//	@Override
//	public void createUserState() throws StateException {
//		getLog().info(
//				new StringBuffer("Estamos en el estado: ")
//						.append(getActionType().toString()));
//		throw new StateException(
//				"No se permite cambiar del estado AddContentListAfiliadosState al estado createUserState");
//	}

	/**
	 * Delete user state.
	 * 
	 * @throws StateException
	 *             the state exception {@inheritDoc}
	 */
	@Override
	public void deleteUserState() throws StateException {
		getLog().debug(
				new StringBuffer("Estamos en el estado: ")
						.append(getActionType().toString()));
		getLog().info("Borramos al usuario");
		super.deleteUser();
		super.getUserContext().setStateByActionTypeName(
				ActionTypeName.DELETE_USER);
		super.succesAction(super.getUserAction().findOne(
				getUserContext().getActionToExecute()));
		getLog().debug("Fin de borrado de usuario");
	}

	/**
	 * Adds the payment list free service.
	 * 
	 * @throws StateException
	 *             the state exception {@inheritDoc}
	 */
	@Override
	public void addPaymentListFreeService() throws StateException {
		getLog().debug(
				new StringBuffer("Estamos en el estado: ")
						.append(getActionType().toString()));
		getLog().info(
				"Añadimos al usuario a la lista de pago servicio gratuito");
		super.addPaymentList(ActionTypeName.ADD_PAYMENT_LIST_FREE_SERVICE
				.getName());


		UserInfo userInfo = new UserInfo();
		userInfo.setLiferayUserId(super.getUserContext().getUser().getLiferayUserId());
		PaymentInfo paymentInfo = new PaymentInfo();
		paymentInfo.setPaymentDuration(PaymentDuration.TRES_MESES);
		paymentInfo.setPaymentType(PaymentType.PROMOTION);
		super.getPaymentFacade().addPayment(userInfo, paymentInfo);
		
		super.getUserContext().setStateByActionTypeName(
				ActionTypeName.ADD_PAYMENT_LIST_FREE_SERVICE);
		super.succesAction(super.getUserAction().findOne(
				getUserContext().getActionToExecute()));
		
		super.changeRolesLevelOne();
		
		getLog().debug(
				"Fin de añadir a un usuario a la lista de pago servicio gratuito");
	}

	/**
	 * Adds the payment list lvl1_1 ano.
	 * 
	 * @throws StateException
	 *             the state exception {@inheritDoc}
	 */
	@Override
	public void addPaymentListLvl1_1Ano() throws StateException {
		getLog().debug(
				new StringBuffer("Estamos en el estado: ")
						.append(getActionType().toString()));
		getLog().info(
				"Inicio de añadir a un usuario a la lista de pago servicio Lvl1 1Ano");
		super.addPaymentList(ActionTypeName.ADD_PAYMENT_LIST_LVL_1_1ANO
				.getName());
		super.getUserContext().setStateByActionTypeName(
				ActionTypeName.ADD_PAYMENT_LIST_LVL_1_1ANO);
		super.succesAction(super.getUserAction().findOne(
				getUserContext().getActionToExecute()));
		getLog().debug(
				"Inicio de añadir a un usuario a la lista de pago servicio Lvl1 1Ano");
	}

	/**
	 * Adds the payment list lvl1_1 mes.
	 * 
	 * @throws StateException
	 *             the state exception {@inheritDoc}
	 */
	@Override
	public void addPaymentListLvl1_1Mes() throws StateException {
		getLog().debug(
				new StringBuffer("Estamos en el estado: ")
						.append(getActionType().toString()));
		getLog().info(
				"Inicio de añadir a un usuario a la lista de pago servicio Lvl1 1Mes");
		super.addPaymentList(ActionTypeName.ADD_PAYMENT_LIST_LVL_1_1MES
				.getName());
		super.getUserContext().setStateByActionTypeName(
				ActionTypeName.ADD_PAYMENT_LIST_LVL_1_1MES);
		super.succesAction(super.getUserAction().findOne(
				getUserContext().getActionToExecute()));
		getLog().debug(
				"Fin de añadir a un usuario a la lista de pago servicio Lvl1 1Mes");
	}

	/**
	 * Adds the payment list lvl1_6 mes.
	 * 
	 * @throws StateException
	 *             the state exception {@inheritDoc}
	 */
	@Override
	public void addPaymentListLvl1_6Mes() throws StateException {
		getLog().debug(
				new StringBuffer("Estamos en el estado: ")
						.append(getActionType().toString()));
		getLog().info(
				"Inicio de añadir a un usuario a la lista de pago servicio Lvl1 6Mes");
		super.addPaymentList(ActionTypeName.ADD_PAYMENT_LIST_LVL_1_6MES
				.getName());
		super.getUserContext().setStateByActionTypeName(
				ActionTypeName.ADD_PAYMENT_LIST_LVL_1_6MES);
		super.succesAction(super.getUserAction().findOne(
				getUserContext().getActionToExecute()));
		getLog().debug(
				"Fin de añadir a un usuario a la lista de pago servicio Lvl1 6Mes");
	}

	/**
	 * Adds the payment list lvl2_1 ano.
	 * 
	 * @throws StateException
	 *             the state exception {@inheritDoc}
	 */
	@Override
	public void addPaymentListLvl2_1Ano() throws StateException {
		getLog().debug(
				new StringBuffer("Estamos en el estado: ")
						.append(getActionType().toString()));
		getLog().info(
				"Inicio de añadir a un usuario a la lista de pago servicio Lvl2 1Ano");
		super.addPaymentList(ActionTypeName.ADD_PAYMENT_LIST_LVL_2_1ANO
				.getName());
		super.getUserContext().setStateByActionTypeName(
				ActionTypeName.ADD_PAYMENT_LIST_LVL_2_1ANO);
		super.succesAction(super.getUserAction().findOne(
				getUserContext().getActionToExecute()));
		getLog().debug(
				"Fin de añadir a un usuario a la lista de pago servicio Lvl2 1Ano");
	}

	/**
	 * Adds the payment list lvl2_1 mes.
	 * 
	 * @throws StateException
	 *             the state exception {@inheritDoc}
	 */
	@Override
	public void addPaymentListLvl2_1Mes() throws StateException {
		getLog().debug(
				new StringBuffer("Estamos en el estado: ")
						.append(getActionType().toString()));
		getLog().info(
				"Inicio de añadir a un usuario a la lista de pago servicio Lvl2 1Mes");
		super.addPaymentList(ActionTypeName.ADD_PAYMENT_LIST_LVL_2_1MES
				.getName());
		super.getUserContext().setStateByActionTypeName(
				ActionTypeName.ADD_PAYMENT_LIST_LVL_2_1MES);
		super.succesAction(super.getUserAction().findOne(
				getUserContext().getActionToExecute()));
		getLog().debug(
				"Fin de añadir a un usuario a la lista de pago servicio Lvl2 1Mes");
	}

	/**
	 * Adds the payment list lvl2_6 mes.
	 * 
	 * @throws StateException
	 *             the state exception {@inheritDoc}
	 */
	@Override
	public void addPaymentListLvl2_6Mes() throws StateException {
		getLog().debug(
				new StringBuffer("Estamos en el estado: ")
						.append(getActionType().toString()));
		getLog().info(
				"Inicio de añadir a un usuario a la lista de pago servicio Lvl2 6Mes");
		super.addPaymentList(ActionTypeName.ADD_PAYMENT_LIST_LVL_2_6MES
				.getName());
		super.getUserContext().setStateByActionTypeName(
				ActionTypeName.ADD_PAYMENT_LIST_LVL_2_6MES);
		super.succesAction(super.getUserAction().findOne(
				getUserContext().getActionToExecute()));
		getLog().debug(
				"Fin de añadir a un usuario a la lista de pago servicio Lvl2 6Mes");
	}

	/**
	 * Adds the payment list lvl3_1 mes.
	 * 
	 * @throws StateException
	 *             the state exception {@inheritDoc}
	 */
	@Override
	public void addPaymentListLvl3_1Mes() throws StateException {
		getLog().debug(
				new StringBuffer("Estamos en el estado: ")
						.append(getActionType().toString()));
		getLog().info(
				"Inicio de añadir a un usuario a la lista de pago servicio Lvl3 1Mes");
		super.addPaymentList(ActionTypeName.ADD_PAYMENT_LIST_LVL_3_1MES
				.getName());
		super.getUserContext().setStateByActionTypeName(
				ActionTypeName.ADD_PAYMENT_LIST_LVL_3_1MES);
		super.succesAction(super.getUserAction().findOne(
				getUserContext().getActionToExecute()));
		getLog().debug(
				"Fin de añadir a un usuario a la lista de pago servicio Lvl3 1Mes");
	}

	/**
	 * Adds the payment list lvl3_6 mes.
	 * 
	 * @throws StateException
	 *             the state exception {@inheritDoc}
	 */
	@Override
	public void addPaymentListLvl3_6Mes() throws StateException {
		getLog().debug(
				new StringBuffer("Estamos en el estado: ")
						.append(getActionType().toString()));
		getLog().info(
				"Inicio de añadir a un usuario a la lista de pago servicio Lvl3 6Mes");
		super.addPaymentList(ActionTypeName.ADD_PAYMENT_LIST_LVL_3_6MES
				.getName());
		super.getUserContext().setStateByActionTypeName(
				ActionTypeName.ADD_PAYMENT_LIST_LVL_3_6MES);
		super.succesAction(super.getUserAction().findOne(
				getUserContext().getActionToExecute()));
		getLog().debug(
				"Fin de añadir a un usuario a la lista de pago servicio Lvl3 6Mes");
	}

	/**
	 * Adds the payment list lvl3_1 ano.
	 * 
	 * @throws StateException
	 *             the state exception {@inheritDoc}
	 */
	@Override
	public void addPaymentListLvl3_1Ano() throws StateException {
		getLog().debug(
				new StringBuffer("Estamos en el estado: ")
						.append(getActionType().toString()));
		getLog().info(
				"Inicio de añadir a un usuario a la lista de pago servicio Lvl3 1Ano");
		super.addPaymentList(ActionTypeName.ADD_PAYMENT_LIST_LVL_3_1ANO
				.getName());
		super.getUserContext().setStateByActionTypeName(
				ActionTypeName.ADD_PAYMENT_LIST_LVL_3_1ANO);
		super.succesAction(super.getUserAction().findOne(
				getUserContext().getActionToExecute()));
		getLog().debug(
				"Fin de añadir a un usuario a la lista de pago servicio Lvl3 1Ano");
	}

	/**
	 * Adds the payment list register.
	 * 
	 * @throws StateException
	 *             the state exception {@inheritDoc}
	 */
	@Override
	public void addPaymentListRegister() throws StateException {
		getLog().debug(
				new StringBuffer("Estamos en el estado: ")
						.append(getActionType().toString()));
		getLog().info(
				"Inicio de añadir a un usuario a la lista de pago registrados");
		super.addPaymentList(ActionTypeName.ADD_PAYMENT_LIST_REGISTER.getName());
		super.getUserContext().setStateByActionTypeName(
				ActionTypeName.ADD_PAYMENT_LIST_REGISTER);
		super.succesAction(super.getUserAction().findOne(
				getUserContext().getActionToExecute()));
		getLog().debug(
				"Fin de añadir a un usuario a la lista de pago registrados");
	}

	/**
	 * Modify payment list after free service.
	 * 
	 * @throws StateException
	 *             the state exception {@inheritDoc}
	 */
	@Override
	public void modifyPaymentListAfterFreeService() throws StateException {
		getLog().debug(
				new StringBuffer("Estamos en el estado: ")
						.append(getActionType().toString()));
		getLog().info(
				"Inicio de modificar a un usuario a la lista de pago afterfreeservice");
		super.modifyPaymentList(ActionTypeName.MODIFY_PAYMENT_LIST_AFTER_FREE_SERVICE
				.getName());
		super.changeRolesToFree();
		super.getUserContext().setStateByActionTypeName(
				ActionTypeName.MODIFY_PAYMENT_LIST_AFTER_FREE_SERVICE);
		super.succesAction(super.getUserAction().findOne(
				getUserContext().getActionToExecute()));
		getLog().debug(
				"Fin de modificar a un usuario a la lista de pago afterfreeservice");
	}

	/**
	 * Modify payment list after payment service.
	 * 
	 * @throws StateException
	 *             the state exception {@inheritDoc}
	 */
	@Override
	public void modifyPaymentListAfterPaymentService() throws StateException {
		getLog().debug(
				new StringBuffer("Estamos en el estado: ")
						.append(getActionType().toString()));
		getLog().info(
				"Inicio de modificar a un usuario a la lista de pago afterpaymentservice");
		super.modifyPaymentList(ActionTypeName.MODIFY_PAYMENT_LIST_AFTER_PAYMENT_SERVICE
				.getName());
		super.getUserContext().setStateByActionTypeName(
				ActionTypeName.MODIFY_PAYMENT_LIST_AFTER_PAYMENT_SERVICE);
		super.succesAction(super.getUserAction().findOne(
				getUserContext().getActionToExecute()));
		getLog().debug(
				"Fin de modificar a un usuario a la lista de pago afterpaymentservice");
	}

	/**
	 * Modify payment list free service.
	 * 
	 * @throws StateException
	 *             the state exception {@inheritDoc}
	 */
	@Override
	public void modifyPaymentListFreeService() throws StateException {
		getLog().debug(
				new StringBuffer("Estamos en el estado: ")
						.append(getActionType().toString()));
		getLog().info(
				"Inicio de modificar a un usuario a la lista de pago freeservice");
		super.modifyPaymentList(ActionTypeName.MODIFY_PAYMENT_LIST_FREE_SERVICE
				.getName());
		super.getUserContext().setStateByActionTypeName(
				ActionTypeName.MODIFY_PAYMENT_LIST_FREE_SERVICE);
		super.succesAction(super.getUserAction().findOne(
				getUserContext().getActionToExecute()));
		getLog().debug(
				"Fin de modificar a un usuario a la lista de pago freeservice");
	}

	/**
	 * Modify payment list limb2.
	 * 
	 * @throws StateException
	 *             the state exception {@inheritDoc}
	 */
	@Override
	public void modifyPaymentListLimb2() throws StateException {
		getLog().debug(
				new StringBuffer("Estamos en el estado: ")
						.append(getActionType().toString()));
		getLog().info(
				"Inicio de modificar a un usuario a la lista de pago limb2");
		super.modifyPaymentList(ActionTypeName.MODIFY_PAYMENT_LIST_LIMB2
				.getName());
		super.getUserContext().setStateByActionTypeName(
				ActionTypeName.MODIFY_PAYMENT_LIST_LIMB2);
		super.succesAction(super.getUserAction().findOne(
				getUserContext().getActionToExecute()));
		getLog().debug("Fin de modificar a un usuario a la lista de pago limb2");
	}

	/**
	 * Modify payment list limb3.
	 * 
	 * @throws StateException
	 *             the state exception {@inheritDoc}
	 */
	@Override
	public void modifyPaymentListLimb3() throws StateException {
		getLog().debug(
				new StringBuffer("Estamos en el estado: ")
						.append(getActionType().toString()));
		getLog().info(
				"Inicio de modificar a un usuario a la lista de pago limb3");
		super.modifyPaymentList(ActionTypeName.MODIFY_PAYMENT_LIST_LIMB3
				.getName());
		super.getUserContext().setStateByActionTypeName(
				ActionTypeName.MODIFY_PAYMENT_LIST_LIMB3);
		super.succesAction(super.getUserAction().findOne(
				getUserContext().getActionToExecute()));
		getLog().debug("Fin de modificar a un usuario a la lista de pago limb3");
	}

	/**
	 * Modify payment list lvl1_1 ano.
	 * 
	 * @throws StateException
	 *             the state exception {@inheritDoc}
	 */
	@Override
	public void modifyPaymentListLvl1_1Ano() throws StateException {
		getLog().debug(
				new StringBuffer("Estamos en el estado: ")
						.append(getActionType().toString()));
		getLog().info(
				"Inicio de modificar a un usuario a la lista de pago lvl1_1ano");
		super.modifyPaymentList(ActionTypeName.MODIFY_PAYMENT_LIST_LVL_1_1ANO
				.getName());
		super.getUserContext().setStateByActionTypeName(
				ActionTypeName.MODIFY_PAYMENT_LIST_LVL_1_1ANO);
		super.succesAction(super.getUserAction().findOne(
				getUserContext().getActionToExecute()));
		getLog().debug(
				"Fin de modificar a un usuario a la lista de pago lvl1_1ano");
	}

	/**
	 * Modify payment list lvl1_1 mes.
	 * 
	 * @throws StateException
	 *             the state exception {@inheritDoc}
	 */
	@Override
	public void modifyPaymentListLvl1_1Mes() throws StateException {
		getLog().debug(
				new StringBuffer("Estamos en el estado: ")
						.append(getActionType().toString()));
		getLog().info(
				"Inicio de modificar a un usuario a la lista de pago lvl1_1mes");
		super.modifyPaymentList(ActionTypeName.MODIFY_PAYMENT_LIST_LVL_1_1MES
				.getName());
		super.getUserContext().setStateByActionTypeName(
				ActionTypeName.MODIFY_PAYMENT_LIST_LVL_1_1MES);
		super.succesAction(super.getUserAction().findOne(
				getUserContext().getActionToExecute()));
		getLog().debug(
				"Fin de modificar a un usuario a la lista de pago lvl1_1mes");
	}

	/**
	 * Modify payment list lvl1_6 mes.
	 * 
	 * @throws StateException
	 *             the state exception {@inheritDoc}
	 */
	@Override
	public void modifyPaymentListLvl1_6Mes() throws StateException {
		getLog().debug(
				new StringBuffer("Estamos en el estado: ")
						.append(getActionType().toString()));
		getLog().info(
				"Inicio de modificar a un usuario a la lista de pago lvl1_6mes");
		super.modifyPaymentList(ActionTypeName.MODIFY_PAYMENT_LIST_LVL_1_6MES
				.getName());
		super.getUserContext().setStateByActionTypeName(
				ActionTypeName.MODIFY_PAYMENT_LIST_LVL_1_6MES);
		super.succesAction(super.getUserAction().findOne(
				getUserContext().getActionToExecute()));
		getLog().debug(
				"Fin de modificar a un usuario a la lista de pago lvl1_6mes");
	}

	/**
	 * Modify payment list lvl2_1 ano.
	 * 
	 * @throws StateException
	 *             the state exception {@inheritDoc}
	 */
	@Override
	public void modifyPaymentListLvl2_1Ano() throws StateException {
		getLog().debug(
				new StringBuffer("Estamos en el estado: ")
						.append(getActionType().toString()));
		getLog().info(
				"Inicio de modificar a un usuario a la lista de pago lvl2_1ano");
		super.modifyPaymentList(ActionTypeName.MODIFY_PAYMENT_LIST_LVL_2_1ANO
				.getName());
		super.getUserContext().setStateByActionTypeName(
				ActionTypeName.MODIFY_PAYMENT_LIST_LVL_2_1ANO);
		super.succesAction(super.getUserAction().findOne(
				getUserContext().getActionToExecute()));
		getLog().debug(
				"Fin de modificar a un usuario a la lista de pago lvl2_1ano");
	}

	/**
	 * Modify payment list lvl2_1 mes.
	 * 
	 * @throws StateException
	 *             the state exception {@inheritDoc}
	 */
	@Override
	public void modifyPaymentListLvl2_1Mes() throws StateException {
		getLog().debug(
				new StringBuffer("Estamos en el estado: ")
						.append(getActionType().toString()));
		getLog().info(
				"Inicio de modificar a un usuario a la lista de pago lvl2_1mes");
		super.modifyPaymentList(ActionTypeName.MODIFY_PAYMENT_LIST_LVL_2_1MES
				.getName());
		super.getUserContext().setStateByActionTypeName(
				ActionTypeName.MODIFY_PAYMENT_LIST_LVL_2_1MES);
		super.succesAction(super.getUserAction().findOne(
				getUserContext().getActionToExecute()));
		getLog().debug(
				"Fin de modificar a un usuario a la lista de pago lvl2_1mes");
	}

	/**
	 * Modify payment list lvl2_6 mes.
	 * 
	 * @throws StateException
	 *             the state exception {@inheritDoc}
	 */
	@Override
	public void modifyPaymentListLvl2_6Mes() throws StateException {
		getLog().debug(
				new StringBuffer("Estamos en el estado: ")
						.append(getActionType().toString()));
		getLog().info(
				"Inicio de modificar a un usuario a la lista de pago lvl2_6mes");
		super.modifyPaymentList(ActionTypeName.MODIFY_PAYMENT_LIST_LVL_2_6MES
				.getName());
		super.getUserContext().setStateByActionTypeName(
				ActionTypeName.MODIFY_PAYMENT_LIST_LVL_2_6MES);
		super.succesAction(super.getUserAction().findOne(
				getUserContext().getActionToExecute()));
		getLog().debug(
				"Fin de modificar a un usuario a la lista de pago lvl2_6mes");
	}

	/**
	 * Modify payment list lvl3_1 mes.
	 * 
	 * @throws StateException
	 *             the state exception {@inheritDoc}
	 */
	@Override
	public void modifyPaymentListLvl3_1Mes() throws StateException {
		getLog().debug(
				new StringBuffer("Estamos en el estado: ")
						.append(getActionType().toString()));
		getLog().info(
				"Inicio de modificar a un usuario a la lista de pago lvl3_1mes");
		super.modifyPaymentList(ActionTypeName.MODIFY_PAYMENT_LIST_LVL_3_1MES
				.getName());
		super.getUserContext().setStateByActionTypeName(
				ActionTypeName.MODIFY_PAYMENT_LIST_LVL_3_1MES);
		super.succesAction(super.getUserAction().findOne(
				getUserContext().getActionToExecute()));
		getLog().debug(
				"Fin de modificar a un usuario a la lista de pago lvl3_1mes");
	}

	/**
	 * Modify payment list lvl3_6 mes.
	 * 
	 * @throws StateException
	 *             the state exception {@inheritDoc}
	 */
	@Override
	public void modifyPaymentListLvl3_6Mes() throws StateException {
		getLog().debug(
				new StringBuffer("Estamos en el estado: ")
						.append(getActionType().toString()));
		getLog().info(
				"Inicio de modificar a un usuario a la lista de pago lvl3_6mes");
		super.modifyPaymentList(ActionTypeName.MODIFY_PAYMENT_LIST_LVL_3_6MES
				.getName());
		super.getUserContext().setStateByActionTypeName(
				ActionTypeName.MODIFY_PAYMENT_LIST_LVL_3_6MES);
		super.succesAction(super.getUserAction().findOne(
				getUserContext().getActionToExecute()));
		getLog().debug(
				"Fin de modificar a un usuario a la lista de pago lvl3_6mes");
	}

	/**
	 * Modify payment list lvl3_1 ano.
	 * 
	 * @throws StateException
	 *             the state exception {@inheritDoc}
	 */
	@Override
	public void modifyPaymentListLvl3_1Ano() throws StateException {
		getLog().debug(
				new StringBuffer("Estamos en el estado: ")
						.append(getActionType().toString()));
		getLog().info(
				"Inicio de modificar a un usuario a la lista de pago lvl3_1ano");
		super.modifyPaymentList(ActionTypeName.MODIFY_PAYMENT_LIST_LVL_3_1ANO
				.getName());
		super.getUserContext().setStateByActionTypeName(
				ActionTypeName.MODIFY_PAYMENT_LIST_LVL_3_1ANO);
		super.succesAction(super.getUserAction().findOne(
				getUserContext().getActionToExecute()));
		getLog().debug(
				"Fin de modificar a un usuario a la lista de pago lvl3_1ano");
	}

	/**
	 * Modify payment list register.
	 * 
	 * @throws StateException
	 *             the state exception {@inheritDoc}
	 */
	@Override
	public void modifyPaymentListRegister() throws StateException {
		getLog().debug(
				new StringBuffer("Estamos en el estado: ")
						.append(getActionType().toString()));
		getLog().info(
				"Inicio de modificar a un usuario a la lista de pago register");
		super.modifyPaymentList(ActionTypeName.MODIFY_PAYMENT_LIST_REGISTER
				.getName());
		super.getUserContext().setStateByActionTypeName(
				ActionTypeName.MODIFY_PAYMENT_LIST_REGISTER);
		super.succesAction(super.getUserAction().findOne(
				getUserContext().getActionToExecute()));
		getLog().debug(
				"Fin de modificar a un usuario a la lista de pago register");
	}
	

	@Override
	public void addRefererBelongActive() throws StateException {
		getLog().debug(
				new StringBuffer("Estamos en el estado: ")
						.append(getActionType().toString()));
		getLog().info("Añadimos al usuario a la lista de referidos-no pertenece-usuario activo");
		super.addContentList(ActionTypeName.ADD_REFERIDOS_NO_PERTENECE_U_ACTIVO.getName());
		super.getUserContext().setStateByActionTypeName(
				ActionTypeName.ADD_REFERIDOS_NO_PERTENECE_U_ACTIVO);
		super.succesAction(super.getUserAction().findOne(
				getUserContext().getActionToExecute()));
		getLog().debug("Fin de añadir usuario a la lista de referidos-no pertenece-usuario activo");
		
	}
	
}
