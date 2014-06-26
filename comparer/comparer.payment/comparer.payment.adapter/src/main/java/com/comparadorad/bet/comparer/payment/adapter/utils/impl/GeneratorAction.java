package com.comparadorad.bet.comparer.payment.adapter.utils.impl;

import java.util.Date;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Component;

import com.comparadorad.bet.comparer.model.autosender.bean.ActionType;
import com.comparadorad.bet.comparer.model.autosender.bean.ActionType.ActionTypeName;
import com.comparadorad.bet.comparer.model.autosender.bean.LogAction;
import com.comparadorad.bet.comparer.model.autosender.bean.LogAction.isCorrect;
import com.comparadorad.bet.comparer.model.autosender.bean.User;
import com.comparadorad.bet.comparer.model.autosender.bean.UserAction;
import com.comparadorad.bet.comparer.payment.adapter.utils.IGeneratorAction;
import com.comparadorad.bet.comparer.payment.enums.PaymentDuration;
import com.comparadorad.bet.comparer.payment.enums.PaymentType;

@Component
public class GeneratorAction implements IGeneratorAction {

	/** The Constant LOG. */
	private static final Log LOG = LogFactory.getLog(GeneratorAction.class);

	@Override
	public UserAction createActionPayment(final User user,
			final Date creationDate, final PaymentType pPaymentType,
			final PaymentDuration pPaymentDuration, final Boolean primerPago) {
		UserAction result = new UserAction();

		ActionType actionType = new ActionType();
		// Se clasifica el tipo de acción dependiendo de lo que nos venga en la
		// petición del interfaz
		ActionTypeName actionTypeName = clasifyTypeAction(pPaymentType,
				pPaymentDuration, primerPago);
		actionType.setName(actionTypeName);
		result.setActionType(actionType);

		// A la acción se le especifica el usuario que la ha ejecutado y la
		// fecha de cuando la ha ejecutado
		result.setUser(user);
		result.setCreationDate(creationDate);

		// Se añade el log incorrecto para ser tratado por el autosender
		LogAction log = createLogAction(result);
		result.setLogAction(log);

		return result;
	}

	private ActionTypeName clasifyTypeAction(final PaymentType pPaymentType,
			final PaymentDuration pPaymentDuration, final boolean primerPago) {
		ActionTypeName result = null;
		if (primerPago) {
			LOG.info("Es la primera vez que el usuario paga.");
			if (pPaymentType.equals(PaymentType.NIVEL_1)) {
				if (pPaymentDuration.equals(PaymentDuration.UN_MES)) {
					result = ActionTypeName.ADD_PAYMENT_LIST_LVL_1_1MES;
				}
				if (pPaymentDuration.equals(PaymentDuration.SEIS_MESES)) {
					result = ActionTypeName.ADD_PAYMENT_LIST_LVL_1_6MES;
				}
				if (pPaymentDuration.equals(PaymentDuration.UN_ANYO)) {
					result = ActionTypeName.ADD_PAYMENT_LIST_LVL_1_1ANO;
				}
			} else if (pPaymentType.equals(PaymentType.NIVEL_2)) {
				if (pPaymentDuration.equals(PaymentDuration.UN_MES)) {
					result = ActionTypeName.ADD_PAYMENT_LIST_LVL_2_1MES;
				}
				if (pPaymentDuration.equals(PaymentDuration.SEIS_MESES)) {
					result = ActionTypeName.ADD_PAYMENT_LIST_LVL_2_6MES;
				}
				if (pPaymentDuration.equals(PaymentDuration.UN_ANYO)) {
					result = ActionTypeName.ADD_PAYMENT_LIST_LVL_2_1ANO;
				}
			} else if (pPaymentType.equals(PaymentType.NIVEL_3)) {
				if (pPaymentDuration.equals(PaymentDuration.UN_MES)) {
					result = ActionTypeName.ADD_PAYMENT_LIST_LVL_3_1MES;
				}
				if (pPaymentDuration.equals(PaymentDuration.SEIS_MESES)) {
					result = ActionTypeName.ADD_PAYMENT_LIST_LVL_3_6MES;
				}
				if (pPaymentDuration.equals(PaymentDuration.UN_ANYO)) {
					result = ActionTypeName.ADD_PAYMENT_LIST_LVL_3_1ANO;
				}
			} else if(pPaymentType.equals(PaymentType.PROMOTION)){
				result = ActionTypeName.ADD_PAYMENT_LIST_FREE_SERVICE;
			}
		} else {
			LOG.info("No es la primera vez que el usuario paga, se procede a modificarlo de vista.");
			if (pPaymentType.equals(PaymentType.NIVEL_1)) {
				if (pPaymentDuration.equals(PaymentDuration.UN_MES)) {
					result = ActionTypeName.MODIFY_PAYMENT_LIST_LVL_1_1MES;
				}
				if (pPaymentDuration.equals(PaymentDuration.SEIS_MESES)) {
					result = ActionTypeName.MODIFY_PAYMENT_LIST_LVL_1_6MES;
				}
				if (pPaymentDuration.equals(PaymentDuration.UN_ANYO)) {
					result = ActionTypeName.MODIFY_PAYMENT_LIST_LVL_1_1ANO;
				}
			} else if (pPaymentType.equals(PaymentType.NIVEL_2)) {
				if (pPaymentDuration.equals(PaymentDuration.UN_MES)) {
					result = ActionTypeName.MODIFY_PAYMENT_LIST_LVL_2_1MES;
				}
				if (pPaymentDuration.equals(PaymentDuration.SEIS_MESES)) {
					result = ActionTypeName.MODIFY_PAYMENT_LIST_LVL_2_6MES;
				}
				if (pPaymentDuration.equals(PaymentDuration.UN_ANYO)) {
					result = ActionTypeName.MODIFY_PAYMENT_LIST_LVL_2_1ANO;
				}
			} else if (pPaymentType.equals(PaymentType.NIVEL_3)) {
				if (pPaymentDuration.equals(PaymentDuration.UN_MES)) {
					result = ActionTypeName.MODIFY_PAYMENT_LIST_LVL_3_1MES;
				}
				if (pPaymentDuration.equals(PaymentDuration.SEIS_MESES)) {
					result = ActionTypeName.MODIFY_PAYMENT_LIST_LVL_3_6MES;
				}
				if (pPaymentDuration.equals(PaymentDuration.UN_ANYO)) {
					result = ActionTypeName.MODIFY_PAYMENT_LIST_LVL_3_1ANO;
				}
			}
		}
		return result;
	}

	/**
	 * Creates the log action.
	 * 
	 * @param action
	 *            the action
	 * @return the log action
	 */
	private LogAction createLogAction(final UserAction action) {
		LogAction log = new LogAction();
		log.setCorrect(isCorrect.WRONG);
		log.setUserAction(action);
		return log;
	}
}
