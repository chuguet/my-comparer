/**
 *
 * Copyright (C) FACTORIA ETSIA S.L.
 * All Rights Reserved.
 * www.factoriaetsia.com
 *
 */
package com.comparadorad.bet.comparer.web.server.hook.userservice.impl;

import java.util.List;
import java.util.Locale;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.liferay.portal.NoSuchTicketException;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.model.Ticket;
import com.liferay.portal.model.TicketConstants;
import com.liferay.portal.model.User;
import com.liferay.portal.service.ServiceContext;
import com.liferay.portal.service.TicketLocalServiceUtil;
import com.liferay.portal.service.UserLocalService;
import com.liferay.portal.service.UserLocalServiceUtil;
import com.liferay.portal.service.UserLocalServiceWrapper;
import com.liferay.portlet.expando.NoSuchTableException;
import com.liferay.portlet.expando.model.ExpandoColumn;
import com.liferay.portlet.expando.model.ExpandoRow;
import com.liferay.portlet.expando.model.ExpandoTable;
import com.liferay.portlet.expando.model.ExpandoValue;
import com.liferay.portlet.expando.service.ExpandoColumnLocalServiceUtil;
import com.liferay.portlet.expando.service.ExpandoRowLocalServiceUtil;
import com.liferay.portlet.expando.service.ExpandoTableLocalServiceUtil;
import com.liferay.portlet.expando.service.ExpandoValueLocalServiceUtil;

/**
 * The Class UserLocalServiceImpl.
 */
public class UserLocalServiceImpl extends UserLocalServiceWrapper {

	/**
	 * The Enum Pages.
	 */
	public enum Pages {


		/** The BLOG. */
		BLOG("blog", "TaY2"),


		/** The SUREBET. */
		SUREBET("apuestas-seguras", "TabL"),


		/** The REFERIDOS. */
		REFERIDOS_NO_PERTENECE_USUARIO_ACTIVO("referidos_NP_UA", "p1Qc"),


		/** The WE b_ principal. */
		WEB_PRINCIPAL("inicio", "TabM");

		/** The name id. */
		private final String name;
		
		/** The id. */
		private final String id;

		/**
		 * Instantiates a new pages.
		 *
		 * @param pName the name
		 * @param pId the id
		 */
		Pages(String pName, String pId) {
			this.name = pName;
			this.id = pId;
		}

		/**
		 * Gets the name.
		 *
		 * @return the name
		 */
		public String getName() {
			return this.name;
		}

		/**
		 * Gets the id.
		 *
		 * @return the id
		 */
		public String getId() {
			return this.id;
		}
	}

	/** The Constant LOG. */
	public static final Log LOG = LogFactory.getLog(UserLocalServiceImpl.class);

	/** The Constant COLUMN_TYPE. */
	private static final int COLUMN_TYPE = 15;

	/** The Constant PAGE. */
	private static final String PAGE = "page";

	/** The Constant TYPE_SETTINGS. */
	private static final String TYPE_SETTINGS = "height=0 index-type=0 hidden=1 width=0 secret=0 visible-with-update-permission=0";

	/** The auto sender service. */
	private AutoSenderService autoSenderService;

	/**
	 * Instantiates a new user local service impl.
	 * 
	 * @param userLocalService
	 *            the user local service
	 */
	public UserLocalServiceImpl(UserLocalService userLocalService) {
		super(userLocalService);
		autoSenderService = new AutoSenderService();
	}

	/**
	 * Adds the user with workflow.
	 * 
	 * @param creatorUserId
	 *            the creator user id
	 * @param companyId
	 *            the company id
	 * @param autoPassword
	 *            the auto password
	 * @param password1
	 *            the password1
	 * @param password2
	 *            the password2
	 * @param autoScreenName
	 *            the auto screen name
	 * @param screenName
	 *            the screen name
	 * @param emailAddress
	 *            the email address
	 * @param facebookId
	 *            the facebook id
	 * @param openId
	 *            the open id
	 * @param locale
	 *            the locale
	 * @param firstName
	 *            the first name
	 * @param middleName
	 *            the middle name
	 * @param lastName
	 *            the last name
	 * @param prefixId
	 *            the prefix id
	 * @param suffixId
	 *            the suffix id
	 * @param male
	 *            the male
	 * @param birthdayMonth
	 *            the birthday month
	 * @param birthdayDay
	 *            the birthday day
	 * @param birthdayYear
	 *            the birthday year
	 * @param jobTitle
	 *            the job title
	 * @param groupIds
	 *            the group ids
	 * @param organizationIds
	 *            the organization ids
	 * @param roleIds
	 *            the role ids
	 * @param userGroupIds
	 *            the user group ids
	 * @param sendEmail
	 *            the send email
	 * @param serviceContext
	 *            the service context
	 * @return the user
	 * @throws PortalException
	 *             the portal exception
	 * @throws SystemException
	 *             the system exception {@inheritDoc}
	 */
	@Override
	public User addUserWithWorkflow(long creatorUserId, long companyId,
			boolean autoPassword, String password1, String password2,
			boolean autoScreenName, String screenName, String emailAddress,
			long facebookId, String openId, Locale locale, String firstName,
			String middleName, String lastName, int prefixId, int suffixId,
			boolean male, int birthdayMonth, int birthdayDay, int birthdayYear,
			String jobTitle, long[] groupIds, long[] organizationIds,
			long[] roleIds, long[] userGroupIds, boolean sendEmail,
			ServiceContext serviceContext) throws PortalException,
			SystemException {
		LOG.info("addUserWithWorkflow");
		User user = super.addUserWithWorkflow(creatorUserId, companyId,
				autoPassword, password1, password2, autoScreenName, screenName,
				emailAddress, facebookId, openId, locale, firstName,
				middleName, lastName, prefixId, suffixId, male, birthdayMonth,
				birthdayDay, birthdayYear, jobTitle, groupIds, organizationIds,
				roleIds, userGroupIds, sendEmail, serviceContext);

		ExpandoTable table;
		ExpandoColumn column;

		try {
			table = ExpandoTableLocalServiceUtil.getDefaultTable(companyId,
					User.class.getName());
		} catch (NoSuchTableException nste) {
			// Si no existe la tabla la creamos
			table = ExpandoTableLocalServiceUtil.addDefaultTable(companyId,
					User.class.getName());
		}
		column = ExpandoColumnLocalServiceUtil.getColumn(table.getTableId(),
				PAGE);
		if (column == null) {
			// Si no existe la columna, la creamos y le ponemos los permisos
			column = ExpandoColumnLocalServiceUtil.addColumn(
					table.getTableId(), PAGE, COLUMN_TYPE);
			ExpandoColumnLocalServiceUtil.updateTypeSettings(
					column.getColumnId(), TYPE_SETTINGS);
			// setAttributePermissions(companyId, PAGE);
		}

		// A�adimos la fila y el valor
		ExpandoRowLocalServiceUtil.addRow(table.getTableId(), user.getUserId());
		String pageFiltered = filterUrl(serviceContext.getCurrentURL()).getId();
		ExpandoValueLocalServiceUtil.addValue(table.getClassNameId(),
				table.getTableId(), column.getColumnId(), user.getUserId(),
				pageFiltered);

		return user;
	}

	/**
	 * Delete user.
	 *
	 * @param userId the user id
	 * @return the user
	 * @throws PortalException the portal exception
	 * @throws SystemException the system exception
	 * {@inheritDoc}
	 */
	@Override
	public User deleteUser(long userId) throws PortalException, SystemException {
		LOG.info("deleteUser");
		User user = super.deleteUser(userId);
		autoSenderService.deleteUser(userId);
		return user;
	}

	/**
	 * Delete user.
	 *
	 * @param user the user
	 * @return the user
	 * @throws PortalException the portal exception
	 * @throws SystemException the system exception
	 * {@inheritDoc}
	 */
	@Override
	public User deleteUser(User user) throws PortalException, SystemException {
		LOG.info("deleteUser");
		User deletedUser = super.deleteUser(user);
		autoSenderService.deleteUser(user.getUserId());
		return deletedUser;
	}

	/**
	 * Filter url.
	 * 
	 * @param url
	 *            the url
	 * @return the string
	 */
	private Pages filterUrl(String url) {
		Pages result = null;
		Pages[] pages = Pages.values();
		for (int i = 0; i < pages.length; i++) {
			if (url.contains(pages[i].name)) {
				result = pages[i];
			}
		}
		if (result == null) {
			result = Pages.WEB_PRINCIPAL;
		}
		LOG.info("filterUrl() returns: " + result);
		return result;
	}

	/**
	 * Update status.
	 *
	 * @param userId the user id
	 * @param status the status
	 * @return the user
	 * @throws PortalException the portal exception
	 * @throws SystemException the system exception
	 * {@inheritDoc}
	 */
	@Override
	public User updateStatus(long userId, int status)
			throws com.liferay.portal.kernel.exception.PortalException,
			SystemException {
		LOG.info("updateStatus : userId = " + userId + ", status = " + status);
		autoSenderService.deactivateUser(userId, status);
		return super.updateStatus(userId, status);
	}

	/**
	 * Update user.
	 * 
	 * @param userId
	 *            the user id
	 * @param oldPassword
	 *            the old password
	 * @param newPassword1
	 *            the new password1
	 * @param newPassword2
	 *            the new password2
	 * @param passwordReset
	 *            the password reset
	 * @param reminderQueryQuestion
	 *            the reminder query question
	 * @param reminderQueryAnswer
	 *            the reminder query answer
	 * @param screenName
	 *            the screen name
	 * @param emailAddress
	 *            the email address
	 * @param facebookId
	 *            the facebook id
	 * @param openId
	 *            the open id
	 * @param languageId
	 *            the language id
	 * @param timeZoneId
	 *            the time zone id
	 * @param greeting
	 *            the greeting
	 * @param comments
	 *            the comments
	 * @param firstName
	 *            the first name
	 * @param middleName
	 *            the middle name
	 * @param lastName
	 *            the last name
	 * @param prefixId
	 *            the prefix id
	 * @param suffixId
	 *            the suffix id
	 * @param male
	 *            the male
	 * @param birthdayMonth
	 *            the birthday month
	 * @param birthdayDay
	 *            the birthday day
	 * @param birthdayYear
	 *            the birthday year
	 * @param smsSn
	 *            the sms sn
	 * @param aimSn
	 *            the aim sn
	 * @param facebookSn
	 *            the facebook sn
	 * @param icqSn
	 *            the icq sn
	 * @param jabberSn
	 *            the jabber sn
	 * @param msnSn
	 *            the msn sn
	 * @param mySpaceSn
	 *            the my space sn
	 * @param skypeSn
	 *            the skype sn
	 * @param twitterSn
	 *            the twitter sn
	 * @param ymSn
	 *            the ym sn
	 * @param jobTitle
	 *            the job title
	 * @param groupIds
	 *            the group ids
	 * @param organizationIds
	 *            the organization ids
	 * @param roleIds
	 *            the role ids
	 * @param userGroupRoles
	 *            the user group roles
	 * @param userGroupIds
	 *            the user group ids
	 * @param serviceContext
	 *            the service context
	 * @return the com.liferay.portal.model. user
	 * @throws PortalException
	 *             the portal exception
	 * @throws SystemException
	 *             the system exception {@inheritDoc}
	 */
	@Override
	public com.liferay.portal.model.User updateUser(long userId,
			String oldPassword, String newPassword1, String newPassword2,
			boolean passwordReset, String reminderQueryQuestion,
			String reminderQueryAnswer, String screenName, String emailAddress,
			long facebookId, String openId, String languageId,
			String timeZoneId, String greeting, String comments,
			String firstName, String middleName, String lastName, int prefixId,
			int suffixId, boolean male, int birthdayMonth, int birthdayDay,
			int birthdayYear, String smsSn, String aimSn, String facebookSn,
			String icqSn, String jabberSn, java.lang.String msnSn,
			String mySpaceSn, String skypeSn, String twitterSn, String ymSn,
			String jobTitle, long[] groupIds, long[] organizationIds,
			long[] roleIds,
			List<com.liferay.portal.model.UserGroupRole> userGroupRoles,
			long[] userGroupIds, ServiceContext serviceContext)
			throws com.liferay.portal.kernel.exception.PortalException,
			SystemException {
		LOG.info("updateUser (long): userId = " + userId + ", firstName = "
				+ firstName);
		User user = super.updateUser(userId, oldPassword, newPassword1,
				newPassword2, passwordReset, reminderQueryQuestion,
				reminderQueryAnswer, screenName, emailAddress, facebookId,
				openId, languageId, timeZoneId, greeting, comments, firstName,
				middleName, lastName, prefixId, suffixId, male, birthdayMonth,
				birthdayDay, birthdayYear, smsSn, aimSn, facebookSn, icqSn,
				jabberSn, msnSn, mySpaceSn, skypeSn, twitterSn, ymSn, jobTitle,
				groupIds, organizationIds, roleIds, userGroupRoles,
				userGroupIds, serviceContext);
		User u = UserLocalServiceUtil.getUserById(userId);
		LOG.info("updateUser (largo): uId = " + u.getUserId()
				+ ", firstName = " + u.getFirstName());
		autoSenderService.updateUserName(u.getUserId(), u.getFirstName());
		return user;
	}

	/**
	 * Update user.
	 * 
	 * @param user
	 *            the user
	 * @return the user
	 * @throws SystemException
	 *             the system exception {@inheritDoc}
	 */
	@Override
	public User updateUser(User user) throws SystemException {
		LOG.info("updateUser(user)");
		User updatedUser = super.updateUser(user);
		autoSenderService.updateUserName(updatedUser.getUserId(),
				updatedUser.getFirstName());
		return updatedUser;
	}

	/**
	 * Update user.
	 * 
	 * @param user
	 *            the user
	 * @param merge
	 *            the merge
	 * @return the user
	 * @throws SystemException
	 *             the system exception {@inheritDoc}
	 */
	@Override
	public User updateUser(User user, boolean merge) throws SystemException {
		LOG.info("updateUser(user, merge");
		User updatedUser = super.updateUser(user, merge);
		autoSenderService.updateUserName(updatedUser.getUserId(),
				updatedUser.getFirstName());
		return updatedUser;
	}

	/**
	 * Verify email address.
	 * 
	 * @param ticketKey
	 *            the ticket key
	 * @throws PortalException
	 *             the portal exception
	 * @throws SystemException
	 *             the system exception {@inheritDoc}
	 */
	@Override
	public void verifyEmailAddress(String ticketKey)
			throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		LOG.info(new StringBuffer("verifyEmailAddress ").append(ticketKey)
				.append(" ==> ticketKey").toString());

		// Implementaticion propia
		UserLocalService userLocalService = getWrappedService();
		Ticket ticket = TicketLocalServiceUtil.getTicket(ticketKey);
		if (ticket.isExpired()
				|| (ticket.getType() != TicketConstants.TYPE_EMAIL_ADDRESS)) {
			throw new NoSuchTicketException();
		}
		long userId = userLocalService.getUserById(ticket.getClassPK())
				.getUserId();

		// Llamada al methodo super
		super.verifyEmailAddress(ticketKey);

		// Implementaticion propia continuada
		User user = UserLocalServiceUtil.getUser(userId);
		LOG.info(new StringBuffer("user.getEmailAddress() = ").append(
				user.getEmailAddress()).toString());
		LOG.info(new StringBuffer("user.getEmailAddressVerified() = ").append(
				user.getEmailAddressVerified()).toString());
		if (user.getEmailAddressVerified()) {
			LOG.info("user.getEmailAddressVerified() == true");
			ExpandoTable table = ExpandoTableLocalServiceUtil.getDefaultTable(
					user.getCompanyId(), User.class.getName());
			ExpandoColumn column = ExpandoColumnLocalServiceUtil.getColumn(
					table.getTableId(), PAGE);
			ExpandoRow row = ExpandoRowLocalServiceUtil.getRow(
					table.getTableId(), user.getUserId());
			ExpandoValue value = ExpandoValueLocalServiceUtil.getValue(
					column.getColumnId(), row.getRowId());
			autoSenderService.addUser(user.getUserId(), user.getEmailAddress(),
					user.getScreenName(), value.getString());
		}
		TicketLocalServiceUtil.deleteTicket(ticket);
	}

}
