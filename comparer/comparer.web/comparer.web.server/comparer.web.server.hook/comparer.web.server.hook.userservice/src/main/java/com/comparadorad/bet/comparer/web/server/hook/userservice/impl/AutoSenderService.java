/**
 *
 * Copyright (C) FACTORIA ETSIA S.L.
 * All Rights Reserved.
 * www.factoriaetsia.com
 *
 */
package com.comparadorad.bet.comparer.web.server.hook.userservice.impl;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.comparadorad.bet.comparer.model.autosender.bean.ActionType;
import com.comparadorad.bet.comparer.model.autosender.bean.ActionType.ActionTypeName;
import com.comparadorad.bet.comparer.model.autosender.bean.User;
import com.comparadorad.bet.comparer.model.autosender.bean.UserAction;
import com.comparadorad.bet.comparer.model.autosender.bean.UserContent;
import com.comparadorad.bet.comparer.model.autosender.bean.UserContent.UserContentName;
import com.comparadorad.bet.comparer.web.server.hook.userservice.database.IUserService;
import com.comparadorad.bet.comparer.web.server.hook.userservice.database.UserService;
import com.comparadorad.bet.comparer.web.server.hook.userservice.mail.IMailTool;
import com.comparadorad.bet.comparer.web.server.hook.userservice.mail.Mail;
import com.comparadorad.bet.comparer.web.server.hook.userservice.mail.MailTool;

/**
 * The Class AutoSenderService.
 */
public class AutoSenderService {

	/** The user service. */
	private IUserService userService = new UserService();

	private IMailTool mailTool = new MailTool();

	private static final Log LOG = LogFactory.getLog(AutoSenderService.class);

	/**
	 * Instantiates a new auto sender service.
	 */
	public AutoSenderService() {
		super();
	}

	/**
	 * Adds the user.
	 * 
	 * @param userId
	 *            the user id
	 * @param emailAddress
	 *            the email address
	 * @param name
	 *            the name
	 * @param location
	 *            the location
	 */
	public void addUser(long userId, String emailAddress, String name,
			String location) {
		User user;
		ActionTypeName actionTypeNameForLocation;

		LOG.info(new StringBuffer("AutoSenderService: addUser: userId = ")
				.append(userId).append(", emailAddress = ")
				.append(emailAddress).append(", name = ").append(name)
				.append(" , location = ").append(location));

		user = getUser(userId);
		if (user == null) {
			user = new User();
			user.setLiferayUserId(new Integer((int) userId));
			user.setName(name);
			user.setEmail(emailAddress);
			user.setActive(true);
			setUserContent(user, location);

			actionTypeNameForLocation = getActionTypeName(location);

			LOG.info(new StringBuffer("Se decide la accion: ")
					.append(actionTypeNameForLocation));

			setUserAction(user, ActionTypeName.CREATE_USER);
			setUserAction(user, ActionTypeName.ADD_PAYMENT_LIST_FREE_SERVICE);
			setUserAction(user, ActionTypeName.ADD_REFERIDOS_NO_PERTENECE_U_ACTIVO);
			setUserAction(user, actionTypeNameForLocation);

			userService.save(user);
			mailTool.sendMail(new Mail("info@betcompara.com",
					createTextUserMail(user), "Nueva alta de usuario"));
		}
	}

	private String createTextUserMail(User user) {
		StringBuffer result = new StringBuffer("<p>El usuario <b>")
				.append(user.getName()).append(" </b> con id de liferay <b>")
				.append(user.getLiferayUserId())
				.append("</b> ha sido dado de alta en el sistema.</p>");
		return result.toString();
	}

	private ActionTypeName getActionTypeName(String location) {
		ActionTypeName result = null;

		LOG.info(new StringBuffer("Se entra en el metodo getActionTypeName"));
		LOG.info(new StringBuffer("Se recibe el parametro: ").append(location));

		for (ActionTypeName actionTypeName : ActionTypeName.values()) {
			if (actionTypeName.getName().equals(location)) {
				LOG.info(new StringBuffer("Se ha recibido la localizacion: ")
						.append(location).append(" La accion seleccionada: ")
						.append(actionTypeName));
				result = actionTypeName;
				break;
			}
		}

		return result;
	}

	/**
	 * Delete user.
	 * 
	 * @param userId
	 *            the user id
	 */
	public void deleteUser(long userId) {
		LOG.info("Serv - deleteUser: userId = " + userId);
		User user = getUser(userId);
		if (user != null) {
			userService.delete(user.getLiferayUserId()); // borrado f�sico
		}
	}

	/**
	 * Gets the user.
	 * 
	 * @param userId
	 *            the user id
	 * @return the user
	 */
	private User getUser(long userId) {
		LOG.info("AutoSenderService: getUserById");
		User user = null;
		user = userService.findByLiferayUser((int) userId);
		if (user != null && user.getUserId() != null
				&& user.getLiferayUserId() != null) {
			return user;
		} else {
			return null;
		}
	}

	private UserContentName getUserContentName(String nameId) {
		UserContentName result = null;
 
		LOG.info("Se entra en el metodo getUserContentName");
		LOG.info(new StringBuffer("Se recibe el parametro: ").append(nameId));

		for (UserContentName contentName : UserContentName.values()) {

			LOG.info(new StringBuffer("Se compara: ").append(contentName.getName().toString())
					.append(" con: ").append(nameId));

			if (contentName.getName().toString().equals(nameId)) {

				LOG.info(new StringBuffer("Se seleciona el contenido: ")
						.append(contentName));

				result = contentName;
			}
		}

		return result;
	}

	/**
	 * Modify user active status.
	 * 
	 * @param userId
	 *            the user id
	 * @param status
	 *            the status
	 */
	public void deactivateUser(long userId, int status) {
		// Deactivar el usuario cuando se desactiva en Liferay.
		// Equivalente a un borrado l�gico
		LOG.info("AutoSenderService: deactivateUser userId = " + userId
				+ ", status = " + status);
		User user = getUser(userId);
		if (user != null && user.getUserId() != null
				&& user.getLiferayUserId() != null) {
			// Status = 0 significa que el usuario sea vuele a activar, caso que
			// ser� imposible
			if (status != 0) {
				System.out.println("AutoSenderService: deactivate user");
				setUserAction(user, ActionTypeName.DELETE_USER); // TODO a�adir
				// ActionType
				// DEACTIVATE
				userService.deactivate(user.getLiferayUserId(),
						ActionTypeName.DELETE_USER); // borrado l�gico
			}
		}
	}

	/**
	 * Sets the user action.
	 * 
	 * @param user
	 *            the user
	 * @param actionTypeName
	 *            the action type name
	 * @return the user
	 */
	private void setUserAction(User user, ActionTypeName actionTypeName) {
		List<UserAction> actionList;

		LOG.info("Se entra en el metodo setUserAction");

		LOG.info(new StringBuffer("Se recibe el usuario: ").append(user
				.getName()));
		LOG.info(new StringBuffer("Se recibe la accion: ")
				.append(actionTypeName));

		actionList = (List<UserAction>) user.getActions();
		if (actionList == null) {
			actionList = new ArrayList<UserAction>();
		}

		UserAction action = new UserAction();

		LOG.info(new StringBuffer("Se crea una nueva accion para el usuario: ")
				.append(user.getName()));

		action.setUser(user);
		ActionType actionType = new ActionType();

		LOG.info(new StringBuffer("Se añade la accion: ")
				.append(actionTypeName));

		actionType.setName(actionTypeName);

		LOG.info(new StringBuffer("La accion es del tipo: ").append(actionType
				.getName()));

		action.setActionType(actionType);
		actionList.add(action);

		LOG.info(new StringBuffer("La lista de usuario actua es: ")
				.append(actionList));

		user.setActions(actionList);
	}

	/**
	 * Sets the user content.
	 * 
	 * @param user
	 *            the user
	 * @param location
	 *            the location
	 * @return the user
	 */
	public void setUserContent(User user, String location) {
		LOG.info("AutoSenderService: - setUserContent: location = " + location);
		List<UserContent> contentList = (List<UserContent>) user
				.getUserContents();
		if (contentList == null) {
			contentList = new ArrayList<UserContent>();
		}
		UserContent content = new UserContent();
		UserContentName userContentName = getUserContentName(location);
		content.setName(userContentName);
		contentList.add(content);
		user.setUserContents(contentList);
	}

	/**
	 * Update user name.
	 * 
	 * @param userId
	 *            the user id
	 * @param firstName
	 *            the first name
	 */
	public void updateUserName(long userId, String firstName) {
		LOG.info("AutoSenderService: updateUserName: userId = " + userId
				+ ", firstName = " + firstName);
		User user = getUser(userId);
		if (user != null) {
			System.out.println("update el nombre del usr");
			if (!user.getName().equalsIgnoreCase(firstName)) {
				user.setName(firstName);
				userService.update(user, null);
			}
		}
	}

}
