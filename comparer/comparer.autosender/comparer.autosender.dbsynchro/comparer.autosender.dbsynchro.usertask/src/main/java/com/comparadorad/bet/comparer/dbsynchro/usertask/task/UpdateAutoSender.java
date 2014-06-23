/**
 *
 * Copyright (C) FACTORIA ETSIA S.L.
 * All Rights Reserved.
 * www.factoriaetsia.com
 *
 */
package com.comparadorad.bet.comparer.dbsynchro.usertask.task;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collection;
import java.util.Collections;
import java.util.Date;
import java.util.List;

import javax.inject.Inject;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import com.comparadorad.bet.comparer.dbsynchro.usertask.comparator.SortedActionTypeByDate;
import com.comparadorad.bet.comparer.dbsynchro.usertask.context.IUserContext;
import com.comparadorad.bet.comparer.dbsynchro.usertask.exception.StateException;
import com.comparadorad.bet.comparer.model.autosender.bean.ActionType;
import com.comparadorad.bet.comparer.model.autosender.bean.ActionType.ActionTypeName;
import com.comparadorad.bet.comparer.model.autosender.bean.DurationPayment;
import com.comparadorad.bet.comparer.model.autosender.bean.LogAction;
import com.comparadorad.bet.comparer.model.autosender.bean.LogAction.isCorrect;
import com.comparadorad.bet.comparer.model.autosender.bean.User;
import com.comparadorad.bet.comparer.model.autosender.bean.UserAction;
import com.comparadorad.bet.comparer.model.autosender.bean.UserCreacion;
import com.comparadorad.bet.comparer.model.autosender.bean.UserPayment;
import com.comparadorad.bet.comparer.model.autosender.bean.UserPayment.StatePayment;
import com.comparadorad.bet.comparer.model.autosender.service.IUserService;

/**
 * The Class UpdateAutoSender.
 */
@Service
class UpdateAutoSender implements IUpdateAutoSender {

	/** The Constant LOG. */
	private static final Log LOG = LogFactory.getLog(UpdateAutoSender.class);

	/** The user service. */
	@Inject
	private IUserService userService;

	/** The user context. */
	@Inject
	private IUserContext userContext;

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.comparadorad.autosender.usertask.task.IUpdateAutoSender#
	 * updateExternalSystem()
	 */
	/** {@inheritDoc} */
	@Scheduled(fixedDelay = 10000)
	@Override
	public void updateExternalSystem() {
		Collection<User> users = userService.findActiveUsers();
		LOG.info(new StringBuffer("Se van a procesar un total de ")
		.append(users.size()).append(" usuarios.").toString());
		for (User user : users) {
			LOG.info(new StringBuffer("Al contexto se le informa del usuario: ")
			.append(user.getEmail()).toString());
			userContext.setUser(user);
			ActionTypeName actionTypeName = getLastStateCorrect(user
					.getActions());
			List<UserAction> listTasksLeft = getTasksLeft(user);
			if (actionTypeName == null && !listTasksLeft.isEmpty()) {
				actionTypeName = getLastUserActionCreated(user.getActions());
				LOG.info(new StringBuffer(
						"Ninguna de las acciones tienen logs, por lo tanto habrá que usar la última acción creada. La ultima acción a creada es: ")
				.append(actionTypeName).toString());
			} else if (!listTasksLeft.isEmpty()) {
				LOG.info("Se ejecutará una acción con Log");
			} else {
				LOG.info(new StringBuffer("El usuario ")
				.append(user.getEmail())
				.append(" no tiene operaciones pendientes a ejecutar.")
				.toString());
			}
			userContext.setStateByActionTypeName(actionTypeName);
			executeTasksLeft(listTasksLeft);
		}
	}

	/**
	 * Gets the last user action created.
	 * 
	 * @param pActions
	 *            the actions
	 * @return the last user action created
	 */
	private ActionTypeName getLastUserActionCreated(
			Collection<UserAction> pActions) {
		Date date = pActions.iterator().next().getCreationDate();
		ActionTypeName result = null;
		for (UserAction userAction : pActions) {
			if (date.before(userAction.getCreationDate())) {
				date = userAction.getCreationDate();
				result = userAction.getActionType().getName();
			}
		}
		return result;
	}

	/**
	 * Gets the tasks left.
	 * 
	 * @param user
	 *            the user
	 * @return the tasks left
	 */
	private List<UserAction> getTasksLeft(User user) {
		List<UserAction> result = new ArrayList<UserAction>();

		LOG.info(new StringBuffer(
				"Se entra en el metodo getTasksLeft con el usuario ")
		.append(user.getName()));

		for (UserAction action : user.getActions()) {
			if (action.getLogAction() == null
					|| action.getLogAction().getCorrect() == null
					|| action.getLogAction().getCorrect()
					.equals(isCorrect.WRONG)) {
				result.add(action);
			}
		}
//		Collections.sort(result, new SortedActionTypeByDate());

		for (UserAction userAction : result) {
			LOG.info(new StringBuffer("El metodo getTasksLeft devuelve: ")
			.append(" El usuario: ")
			.append(userAction.getUser().getName())
			.append(" tiene asignado la accion con id: ")
			.append(userAction.getActionType().getActionTypeId())
			.append(" Con el nombre: ")
			.append(userAction.getActionType().getName()));
		}

		return result;
	}

	/**
	 * Execute tasks left.
	 * 
	 * @param listTasksLeft
	 *            the list tasks left
	 */
	private void executeTasksLeft(List<UserAction> listTasksLeft) {
		try {
			for (UserAction actionType : listTasksLeft) {
				LOG.info(new StringBuffer(
						"Se procede a modificar el estado del usuario: ")
				.append(userContext.getUser().getEmail())
				.append(" le quedan ").append(listTasksLeft.size())
				.append(" tareas por realizar.").toString());
				ActionType.ActionTypeName name = actionType.getActionType()
						.getName();
				switch (name) {
				case CREATE_USER:
					LOG.info(new StringBuffer(
							"La accion a ejecutar es CREATE_USER con id: ")
					.append(actionType.getUserActionId()).toString());
					userContext
					.setActionToExecute(actionType.getUserActionId());
					userContext.getUserState().createUserState();
					break;
				case DELETE_USER:
					LOG.info(new StringBuffer(
							"La accion a ejecutar es DELETE_USER con id: ")
					.append(actionType.getUserActionId()).toString());
					userContext
					.setActionToExecute(actionType.getUserActionId());
					userContext.getUserState().deleteUserState();
					break;
				case ADD_CONTENT_LIST_BLOG:
					LOG.info(new StringBuffer(
							"La accion a ejecutar es ADD_CONTENT_LIST_BLOG con id: ")
					.append(actionType.getUserActionId()).toString());
					userContext
					.setActionToExecute(actionType.getUserActionId());
					userContext.getUserState().addContentListBlogState();
					break;
				case ADD_CONTENT_LIST_SUREBET:
					LOG.info(new StringBuffer(
							"La accion a ejecutar es ADD_CONTENT_LIST_SUREBET con id: ")
					.append(actionType.getUserActionId()).toString());
					userContext
					.setActionToExecute(actionType.getUserActionId());
					userContext.getUserState().addContentListSurebetState();
					break;
				case ADD_CONTENT_LIST_AFILIADOS:
					LOG.info(new StringBuffer(
							"La accion a ejecutar es ADD_CONTENT_LIST_AFILIADOS con id: ")
					.append(actionType.getUserActionId()).toString());
					userContext
					.setActionToExecute(actionType.getUserActionId());
					userContext.getUserState().addContentListAfiliadosState();
					break;
				case ADD_CONTENT_LIST_REFERIDOS:
					LOG.info(new StringBuffer(
							"La accion a ejecutar es ADD_CONTENT_LIST_REFERIDOS con id: ")
					.append(actionType.getUserActionId()).toString());
					userContext
					.setActionToExecute(actionType.getUserActionId());
					userContext.getUserState().addContentListReferidosState();
					break;
				case ADD_CONTENT_LIST_VALUEBET:
					LOG.info(new StringBuffer(
							"La accion a ejecutar es ADD_CONTENT_LIST_VALUEBET con id: ")
					.append(actionType.getUserActionId()).toString());
					userContext
					.setActionToExecute(actionType.getUserActionId());
					userContext.getUserState().addContentListValuebetState();
					break;
				case ADD_CONTENT_LIST_WEB_PRINCIPAL:
					LOG.info(new StringBuffer(
							"La accion a ejecutar es ADD_CONTENT_LIST_WEB_PRINCIPAL con id: ")
					.append(actionType.getUserActionId()).toString());
					userContext
					.setActionToExecute(actionType.getUserActionId());
					userContext.getUserState()
					.addContentListWebPrincipalState();
					break;
				case DELETE_CONTENT_LIST_BLOG:
					LOG.info(new StringBuffer(
							"La accion a ejecutar es DELETE_CONTENT_LIST_BLOG con id: ")
					.append(actionType.getUserActionId()).toString());
					userContext
					.setActionToExecute(actionType.getUserActionId());
					userContext.getUserState().deleteContentListBlogState();
					break;
				case DELETE_CONTENT_LIST_SUREBET:
					LOG.info(new StringBuffer(
							"La accion a ejecutar es DELETE_CONTENT_LIST_SUREBET con id: ")
					.append(actionType.getUserActionId()).toString());
					userContext
					.setActionToExecute(actionType.getUserActionId());
					userContext.getUserState().deleteContentListSurebetState();
					break;
				case DELETE_CONTENT_LIST_AFILIADOS:
					LOG.info(new StringBuffer(
							"La accion a ejecutar es DELETE_CONTENT_LIST_AFILIADOS con id: ")
					.append(actionType.getUserActionId()).toString());
					userContext
					.setActionToExecute(actionType.getUserActionId());
					userContext.getUserState()
					.deleteContentListAfiliadosState();
					break;
				case DELETE_CONTENT_LIST_REFERIDOS:
					LOG.info(new StringBuffer(
							"La accion a ejecutar es DELETE_CONTENT_LIST_REFERIDOS con id: ")
					.append(actionType.getUserActionId()).toString());
					userContext
					.setActionToExecute(actionType.getUserActionId());
					userContext.getUserState()
					.deleteContentListReferidosState();
					break;
				case DELETE_CONTENT_LIST_VALUEBET:
					LOG.info(new StringBuffer(
							"La accion a ejecutar es DELETE_CONTENT_LIST_VALUEBET con id: ")
					.append(actionType.getUserActionId()).toString());
					userContext
					.setActionToExecute(actionType.getUserActionId());
					userContext.getUserState().deleteContentListValueBetState();
					break;
				case DELETE_CONTENT_LIST_WEB_PRINCIPAL:
					LOG.info(new StringBuffer(
							"La accion a ejecutar es DELETE_CONTENT_LIST_WEB_PRINCIPAL con id: ")
					.append(actionType.getUserActionId()).toString());
					userContext
					.setActionToExecute(actionType.getUserActionId());
					userContext.getUserState()
					.deleteContentListWebPrincipalState();
					break;
				case ADD_PAYMENT_LIST_REGISTER:
					LOG.info(new StringBuffer(
							"La accion a ejecutar es ADD_PAYMENT_LIST_REGISTER con id: ")
					.append(actionType.getUserActionId()).toString());
					userContext
					.setActionToExecute(actionType.getUserActionId());
					userContext.getUserState().addPaymentListRegister();
					break;
				case ADD_PAYMENT_LIST_FREE_SERVICE:
					LOG.info(new StringBuffer(
							"La accion a ejecutar es ADD_PAYMENT_LIST_FREE_SERVICE con id: ")
					.append(actionType.getUserActionId()).toString());
					userContext
					.setActionToExecute(actionType.getUserActionId());
					userContext.getUserState().addPaymentListFreeService();
					break;
				case ADD_PAYMENT_LIST_LVL_1_6MES:
					LOG.info(new StringBuffer(
							"La accion a ejecutar es ADD_PAYMENT_LIST_LVL_1_6MES con id: ")
					.append(actionType.getUserActionId()).toString());
					userContext
					.setActionToExecute(actionType.getUserActionId());
					userContext.getUserState().addPaymentListLvl1_6Mes();
					break;
				case ADD_PAYMENT_LIST_LVL_1_1ANO:
					LOG.info(new StringBuffer(
							"La accion a ejecutar es ADD_PAYMENT_LIST_LVL_1_1ANO con id: ")
					.append(actionType.getUserActionId()).toString());
					userContext
					.setActionToExecute(actionType.getUserActionId());
					userContext.getUserState().addPaymentListLvl1_1Ano();
					break;
				case ADD_PAYMENT_LIST_LVL_1_1MES:
					LOG.info(new StringBuffer(
							"La accion a ejecutar es ADD_PAYMENT_LIST_LVL_1_1MES con id: ")
					.append(actionType.getUserActionId()).toString());
					userContext
					.setActionToExecute(actionType.getUserActionId());
					userContext.getUserState().addPaymentListLvl1_1Mes();
					break;
				case ADD_PAYMENT_LIST_LVL_2_6MES:
					LOG.info(new StringBuffer(
							"La accion a ejecutar es ADD_PAYMENT_LIST_LVL_2_6MES con id: ")
					.append(actionType.getUserActionId()).toString());
					userContext
					.setActionToExecute(actionType.getUserActionId());
					userContext.getUserState().addPaymentListLvl2_6Mes();
					break;
				case ADD_PAYMENT_LIST_LVL_2_1ANO:
					LOG.info(new StringBuffer(
							"La accion a ejecutar es ADD_PAYMENT_LIST_LVL_2_1ANO con id: ")
					.append(actionType.getUserActionId()).toString());
					userContext
					.setActionToExecute(actionType.getUserActionId());
					userContext.getUserState().addPaymentListLvl2_1Ano();
					break;
				case ADD_PAYMENT_LIST_LVL_2_1MES:
					LOG.info(new StringBuffer(
							"La accion a ejecutar es ADD_PAYMENT_LIST_LVL_2_1MES con id: ")
					.append(actionType.getUserActionId()).toString());
					userContext
					.setActionToExecute(actionType.getUserActionId());
					userContext.getUserState().addPaymentListLvl2_1Mes();
					break;
				case ADD_PAYMENT_LIST_LVL_3_6MES:
					LOG.info(new StringBuffer(
							"La accion a ejecutar es ADD_PAYMENT_LIST_LVL_3_6MES con id: ")
					.append(actionType.getUserActionId()).toString());
					userContext
					.setActionToExecute(actionType.getUserActionId());
					userContext.getUserState().addPaymentListLvl3_6Mes();
					break;
				case ADD_PAYMENT_LIST_LVL_3_1ANO:
					LOG.info(new StringBuffer(
							"La accion a ejecutar es ADD_PAYMENT_LIST_LVL_3_1ANO con id: ")
					.append(actionType.getUserActionId()).toString());
					userContext
					.setActionToExecute(actionType.getUserActionId());
					userContext.getUserState().addPaymentListLvl3_1Ano();
					break;
				case ADD_PAYMENT_LIST_LVL_3_1MES:
					LOG.info(new StringBuffer(
							"La accion a ejecutar es ADD_PAYMENT_LIST_LVL_3_1MES con id: ")
					.append(actionType.getUserActionId()).toString());
					userContext
					.setActionToExecute(actionType.getUserActionId());
					userContext.getUserState().addPaymentListLvl3_1Mes();
					break;
				case MODIFY_PAYMENT_LIST_REGISTER:
					LOG.info(new StringBuffer(
							"La accion a ejecutar es MODIFY_PAYMENT_LIST_REGISTER con id: ")
					.append(actionType.getUserActionId()).toString());
					userContext
					.setActionToExecute(actionType.getUserActionId());
					userContext.getUserState().modifyPaymentListRegister();
					break;
				case MODIFY_PAYMENT_LIST_FREE_SERVICE:
					LOG.info(new StringBuffer(
							"La accion a ejecutar es MODIFY_PAYMENT_LIST_FREE_SERVICE con id: ")
					.append(actionType.getUserActionId()).toString());
					userContext
					.setActionToExecute(actionType.getUserActionId());
					userContext.getUserState().modifyPaymentListFreeService();
					break;
				case MODIFY_PAYMENT_LIST_AFTER_FREE_SERVICE:
					LOG.info(new StringBuffer(
							"La accion a ejecutar es MODIFY_PAYMENT_LIST_AFTER_FREE_SERVICE con id: ")
					.append(actionType.getUserActionId()).toString());
					userContext
					.setActionToExecute(actionType.getUserActionId());
					userContext.getUserState()
					.modifyPaymentListAfterFreeService();
					break;
				case MODIFY_PAYMENT_LIST_AFTER_PAYMENT_SERVICE:
					LOG.info(new StringBuffer(
							"La accion a ejecutar es MODIFY_PAYMENT_LIST_AFTER_PAYMENT_SERVICE con id: ")
					.append(actionType.getUserActionId()).toString());
					userContext
					.setActionToExecute(actionType.getUserActionId());
					userContext.getUserState()
					.modifyPaymentListAfterPaymentService();
					break;
				case MODIFY_PAYMENT_LIST_LVL_1_1MES:
					LOG.info(new StringBuffer(
							"La accion a ejecutar es MODIFY_PAYMENT_LIST_LVL_1_1MES con id: ")
					.append(actionType.getUserActionId()).toString());
					userContext
					.setActionToExecute(actionType.getUserActionId());
					userContext.getUserState().modifyPaymentListLvl1_1Mes();
					break;
				case MODIFY_PAYMENT_LIST_LVL_1_6MES:
					LOG.info(new StringBuffer(
							"La accion a ejecutar es MODIFY_PAYMENT_LIST_LVL_1_6MES con id: ")
					.append(actionType.getUserActionId()).toString());
					userContext
					.setActionToExecute(actionType.getUserActionId());
					userContext.getUserState().modifyPaymentListLvl1_6Mes();
					break;
				case MODIFY_PAYMENT_LIST_LVL_1_1ANO:
					LOG.info(new StringBuffer(
							"La accion a ejecutar es MODIFY_PAYMENT_LIST_LVL_1_1ANO con id: ")
					.append(actionType.getUserActionId()).toString());
					userContext
					.setActionToExecute(actionType.getUserActionId());
					userContext.getUserState().modifyPaymentListLvl1_1Ano();
					break;
				case MODIFY_PAYMENT_LIST_LVL_2_1MES:
					LOG.info(new StringBuffer(
							"La accion a ejecutar es MODIFY_PAYMENT_LIST_LVL_2_1MES con id: ")
					.append(actionType.getUserActionId()).toString());
					userContext
					.setActionToExecute(actionType.getUserActionId());
					userContext.getUserState().modifyPaymentListLvl2_1Mes();
					break;
				case MODIFY_PAYMENT_LIST_LVL_2_6MES:
					LOG.info(new StringBuffer(
							"La accion a ejecutar es MODIFY_PAYMENT_LIST_LVL_2_6MES con id: ")
					.append(actionType.getUserActionId()).toString());
					userContext
					.setActionToExecute(actionType.getUserActionId());
					userContext.getUserState().modifyPaymentListLvl2_6Mes();
					break;
				case MODIFY_PAYMENT_LIST_LVL_2_1ANO:
					LOG.info(new StringBuffer(
							"La accion a ejecutar es MODIFY_PAYMENT_LIST_LVL_2_1ANO con id: ")
					.append(actionType.getUserActionId()).toString());
					userContext
					.setActionToExecute(actionType.getUserActionId());
					userContext.getUserState().modifyPaymentListLvl2_1Ano();
					break;
				case MODIFY_PAYMENT_LIST_LVL_3_1MES:
					LOG.info(new StringBuffer(
							"La accion a ejecutar es MODIFY_PAYMENT_LIST_LVL_3_1MES con id: ")
					.append(actionType.getUserActionId()).toString());
					userContext
					.setActionToExecute(actionType.getUserActionId());
					userContext.getUserState().modifyPaymentListLvl3_1Mes();
					break;
				case MODIFY_PAYMENT_LIST_LVL_3_6MES:
					LOG.info(new StringBuffer(
							"La accion a ejecutar es MODIFY_PAYMENT_LIST_LVL_3_6MES con id: ")
					.append(actionType.getUserActionId()).toString());
					userContext
					.setActionToExecute(actionType.getUserActionId());
					userContext.getUserState().modifyPaymentListLvl3_6Mes();
					break;
				case MODIFY_PAYMENT_LIST_LVL_3_1ANO:
					LOG.info(new StringBuffer(
							"La accion a ejecutar es MODIFY_PAYMENT_LIST_LVL_3_1ANO con id: ")
					.append(actionType.getUserActionId()).toString());
					userContext
					.setActionToExecute(actionType.getUserActionId());
					userContext.getUserState().modifyPaymentListLvl3_1Ano();
					break;
				case MODIFY_PAYMENT_LIST_LIMB2:
					LOG.info(new StringBuffer(
							"La accion a ejecutar es MODIFY_PAYMENT_LIST_LIMB2 con id: ")
					.append(actionType.getUserActionId()).toString());
					userContext
					.setActionToExecute(actionType.getUserActionId());
					userContext.getUserState().modifyPaymentListLimb2();
					break;
				case MODIFY_PAYMENT_LIST_LIMB3:
					LOG.info(new StringBuffer(
							"La accion a ejecutar es MODIFY_PAYMENT_LIST_LIMB3 con id: ")
					.append(actionType.getUserActionId()).toString());
					userContext
					.setActionToExecute(actionType.getUserActionId());
					userContext.getUserState().modifyPaymentListLimb3();
					break;
				case CHANGE_ROLES:
					LOG.info(new StringBuffer(
							"La accion a ejecutar es CHANGE_ROLES con id: ")
					.append(actionType.getUserActionId()).toString());
					userContext
					.setActionToExecute(actionType.getUserActionId());
					userContext.getUserState().changeRoles();
					break;
				case ADD_REFERIDOS_NO_PERTENECE_U_ACTIVO:
					LOG.info(new StringBuffer(
							"La accion a ejecutar es ADD_REFERIDOS_NO_PERTENECE_U_ACTIVO con id: ")
					.append(actionType.getUserActionId()).toString());
					userContext
					.setActionToExecute(actionType.getUserActionId());
					userContext.getUserState().addRefererBelongActive();
					break;	
				default:
					throw new StateException("Sin estado permitido");
				}
				LOG.info(new StringBuffer(
						"Se finaliza la tarea de modificacion del estado del usuario: ")
				.append(userContext.getUser().getEmail()).toString());
			}
		} catch (StateException e) {
			LOG.error(e.getMessage());
		}
	}

	/**
	 * Gets the last state correct.
	 * 
	 * @param userActions
	 *            the user actions
	 * @return the last state correct
	 */
	private ActionTypeName getLastStateCorrect(
			Collection<UserAction> userActions) {
		Date lastCorrect = null;
		ActionTypeName result = null;

		LOG.info(new StringBuffer("Se entra en el metodo getLastStateCorrect"));

		// Setear la primera fecha
		for (UserAction userAction : userActions) {
			if (userAction.getLogAction() != null
					&& userAction.getLogAction().getCorrect().name()
					.equals(isCorrect.SUCCESS.name())) {
				lastCorrect = userAction.getCreationDate();
				break;
			}
		}

		// Buscar el mas reciente y que sea correcto
		if (lastCorrect != null) {
			for (UserAction userAction : userActions) {
				if (userAction.getLogAction() != null
						&& (userAction.getCreationDate().after(lastCorrect) || userAction
								.getCreationDate().equals(lastCorrect))
								&& (userAction.getLogAction().getCorrect().name()
										.equals(isCorrect.SUCCESS.name()))) {
					result = userAction.getActionType().getName();
				}
			}
		}

		LOG.info(new StringBuffer("El metodo getLastStateCorrect devuelve: ")
		.append(result));

		return result;
	}

	@Override
	@Scheduled(fixedDelay = 10000)
	public void updatePayments() {
		LOG.info(new StringBuffer("Verificamos los pagos activos").toString());
		Collection<User> users = userService.findActiveUsers();
		LOG.info(new StringBuffer("Se van a procesar un total de ")
		.append(users.size()).append(" usuarios.").toString());
		for (User user : users) {
			for(UserPayment payment : user.getUserPayments()){
				if(payment.getStatePayment().equals(StatePayment.ACTIVE)){
					for(DurationPayment duration : payment.getDurationPayment()){
						Date today = Calendar.getInstance().getTime();
						if(duration.getExpectedDate().before(today)){
							payment.setStatePayment(StatePayment.FINISH);
							duration.setFinishDate(today);
							UserAction action = getAction();
							action.setUser(user);
							user.getActions().add(action);
							LOG.info(new StringBuffer("El pago ha finalizado ").append(duration.getExpectedDate()).toString());
							userService.update(user);
						}else{
							LOG.info(new StringBuffer("El pago con fecha ").append(duration.getExpectedDate())
									.append(" no ha finalizado.").toString());
						}
					}
				}
			}
		}

	}

	private UserAction getAction() {

		//TODO... esta puesto a fuego, para dejarlo bien, hay que rehacer muchas cosas...............
		UserAction action = new UserAction();
		action.setCreacionUser(UserCreacion.USER_TASK);
		action.setCreationDate(new Date());
		ActionType actionType = new ActionType();
		actionType.setCreacionUser(UserCreacion.USER_TASK);
		actionType.setCreationDate(new Date());
		actionType.setName(ActionTypeName.MODIFY_PAYMENT_LIST_AFTER_FREE_SERVICE);

		action.setActionType(actionType);

		return action;
	}

}
