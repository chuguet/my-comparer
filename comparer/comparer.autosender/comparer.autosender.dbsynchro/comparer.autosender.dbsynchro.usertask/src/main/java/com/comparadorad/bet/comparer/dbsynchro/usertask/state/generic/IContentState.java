/**
 *
 * Copyright (C) FACTORIA ETSIA S.L.
 * All Rights Reserved.
 * www.factoriaetsia.com
 *
 */
package com.comparadorad.bet.comparer.dbsynchro.usertask.state.generic;

import com.comparadorad.bet.comparer.dbsynchro.usertask.exception.StateException;

/**
 * The Interface IUserState.
 */
public interface IContentState {

	/**
	 * Adds the location.
	 * 
	 * @throws StateException
	 *             the user state exception
	 */
	void addContentListAfiliadosState() throws StateException;

	/**
	 * Adds the location.
	 * 
	 * @throws StateException
	 *             the user state exception
	 */
	void addContentListBlogState() throws StateException;

	/**
	 * Adds the location.
	 * 
	 * @throws StateException
	 *             the user state exception
	 */
	void addContentListReferidosState() throws StateException;

	/**
	 * Adds the location.
	 * 
	 * @throws StateException
	 *             the user state exception
	 */
	void addContentListSurebetState() throws StateException;

	/**
	 * Adds the location.
	 * 
	 * @throws StateException
	 *             the user state exception
	 */
	void addContentListValuebetState() throws StateException;

	/**
	 * Adds the location.
	 * 
	 * @throws StateException
	 *             the user state exception
	 */
	void addContentListWebPrincipalState() throws StateException;

	/**
	 * Delete location user state.
	 * 
	 * @throws StateException
	 *             the user state exception
	 */
	void deleteContentListAfiliadosState() throws StateException;

	/**
	 * Delete location user state.
	 * 
	 * @throws StateException
	 *             the user state exception
	 */
	void deleteContentListBlogState() throws StateException;

	/**
	 * Delete location user state.
	 * 
	 * @throws StateException
	 *             the user state exception
	 */
	void deleteContentListReferidosState() throws StateException;

	/**
	 * Delete location user state.
	 * 
	 * @throws StateException
	 *             the user state exception
	 */
	void deleteContentListSurebetState() throws StateException;

	/**
	 * Delete location user state.
	 * 
	 * @throws StateException
	 *             the user state exception
	 */
	void deleteContentListValueBetState() throws StateException;

	/**
	 * Delete location user state.
	 * 
	 * @throws StateException
	 *             the user state exception
	 */
	void deleteContentListWebPrincipalState() throws StateException;

}
