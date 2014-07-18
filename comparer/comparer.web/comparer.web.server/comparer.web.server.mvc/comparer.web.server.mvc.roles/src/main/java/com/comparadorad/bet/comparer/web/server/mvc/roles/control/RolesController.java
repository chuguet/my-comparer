/**
 *
 * Copyright (C) FACTORIA ETSIA S.L.
 * All Rights Reserved.
 * www.factoriaetsia.com
 *
 */
package com.comparadorad.bet.comparer.web.server.mvc.roles.control;

import java.util.List;

import javax.inject.Inject;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.comparadorad.bet.comparer.model.core.bean.user.UserData;
import com.comparadorad.bet.comparer.web.rest.beans.UserInfoRequest;
import com.comparadorad.bet.comparer.web.rest.beans.UserInfoResponse;
import com.comparadorad.bet.comparer.web.rest.beans.enume.ResponseType;
import com.comparadorad.bet.comparer.web.rest.beans.enume.UserTypes;
import com.comparadorad.bet.comparer.web.server.mvc.core.control.AbstractComparerController;
import com.comparadorad.bet.comparer.web.server.mvc.roles.config.WebServerMvcRolesConfig;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.model.UserGroup;
import com.liferay.portal.service.UserGroupLocalServiceUtil;

/**
 * The Class RolesController.
 */
@Controller
@RequestMapping("/rolesController")
public class RolesController extends AbstractComparerController {

	private static final Log LOG = LogFactory.getLog(RolesController.class);

	@Inject
	private WebServerMvcRolesConfig config;

	/**
	 * Change roles.
	 * 
	 * @param infoRequest
	 *            the info request
	 * @param userData
	 *            the user data
	 * @return the user info response
	 * @throws NumberFormatException
	 *             the number format exception
	 * @throws PortalException
	 *             the portal exception
	 * @throws SystemException
	 *             the system exception
	 */
	@RequestMapping(value = "/changeRoles", method = RequestMethod.POST)
	@ResponseBody
	public UserInfoResponse changeRoles(
			@RequestBody final UserInfoRequest infoRequest,
			final UserData userData) {

		UserInfoResponse response = new UserInfoResponse();
		Long userId;
		List<UserGroup> userGroups;
		long[] userGroupIds = new long[1];
		StringBuffer buffer;

		LOG.info("Se entra en el metodo changeRoles.");
		LOG.info(new StringBuffer("Se recibe el bean: ").append(infoRequest));

		try {
			userId = Long.parseLong(infoRequest.getLiferayUserId());
			userGroups = UserGroupLocalServiceUtil.getUserUserGroups(userId);

			userGroupIds[0] = processGroup(infoRequest.getDestinyGroup());

			buffer = new StringBuffer(
					"El usuario esta en los siguientes grupos: ");
			for (UserGroup userGroup : userGroups) {
				buffer.append(userGroup.getName());
			}
			LOG.info(buffer);

			LOG.info(new StringBuffer("Se limpia el usuario").append(userId)
					.append(" .De todos los grupos"));
			UserGroupLocalServiceUtil.clearUserUserGroups(userId);
			
			
			LOG.info(new StringBuffer("Se añade el usuario").append(userId)
					.append(" .Al grupo: ").append(userGroupIds[0]) );			
			UserGroupLocalServiceUtil.setUserUserGroups(userId, userGroupIds);

			response.setResponse(ResponseType.OK);

		} catch (Exception e) {
			LOG.error(new StringBuffer("Se ha producido el siguiente error: ")
					.append(e.getMessage()));
			response.setResponse(ResponseType.KO);
		}

		return response;
	}

	private long processGroup(UserTypes originGroup) {

		long id = 0;

		switch (originGroup) {

		case NIVEL_1:
			id = config.getLevel_1();
			break;

		case NIVEL_2:
			id = config.getLevel_2();
			break;

		case NIVEL_3:
			id = config.getLevel_3();
			break;

		case GRATUITO:
			id = config.getFree();
			break;

		}
		return id;
	}

}