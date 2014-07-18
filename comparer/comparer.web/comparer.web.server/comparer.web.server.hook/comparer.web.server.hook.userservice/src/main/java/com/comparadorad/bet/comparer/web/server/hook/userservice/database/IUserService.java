package com.comparadorad.bet.comparer.web.server.hook.userservice.database;

import com.comparadorad.bet.comparer.model.autosender.bean.ActionType.ActionTypeName;
import com.comparadorad.bet.comparer.model.autosender.bean.User;

/**
 * The Interface IUserService.
 */
public interface IUserService {
	
	/**
	 * Save.
	 *
	 * @param user the user
	 */
	void save(User user);

	/**
	 * Update.
	 *
	 * @param user the user
	 * @param userAction the user action
	 */
	void update(User user, ActionTypeName userAction);

	/**
	 * Delete.
	 *
	 * @param pLiferayId the liferay id
	 */
	void delete(Integer pLiferayId);
	
	/**
	 * Deactivate.
	 *
	 * @param pLiferayId the liferay id
	 * @param userAction the user action
	 */
	void deactivate(Integer pLiferayId, ActionTypeName userAction);

	/**
	 * Find by liferay user.
	 *
	 * @param pLiferayId the liferay id
	 * @return the user
	 */
	User findByLiferayUser(Integer pLiferayId);

	/**
	 * Find by email.
	 *
	 * @param email the email
	 * @return the user
	 */
	User findByEmail(String email);
}
