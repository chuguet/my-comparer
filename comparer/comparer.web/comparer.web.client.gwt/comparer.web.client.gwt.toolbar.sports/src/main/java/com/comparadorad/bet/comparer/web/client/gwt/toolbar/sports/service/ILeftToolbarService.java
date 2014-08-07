/**
 *
 * Copyright (C) FACTORIA ETSIA S.L.
 * All Rights Reserved.
 * www.factoriaetsia.com
 *
 */
package com.comparadorad.bet.comparer.web.client.gwt.toolbar.sports.service;

import javax.ws.rs.POST;
import javax.ws.rs.Path;

import org.fusesource.restygwt.client.MethodCallback;

import com.comparadorad.bet.comparer.web.client.gwt.core.service.IService;
import com.comparadorad.bet.comparer.web.client.gwt.toolbar.sports.bean.ToolbarElementListTo;
import com.comparadorad.bet.comparer.web.client.gwt.toolbar.sports.bean.ToolbarElementTo;

/**
 * The Interface ISportToolbarService.
 */

public interface ILeftToolbarService extends IService {

	/**
	 * Gets the toolbar element list.
	 * 
	 * @param toolbarElementListTo
	 *            the toolbar element list to
	 * @param callback
	 *            the callback
	 */
	@POST
	@Path("/toolbarElementList")
	void getToolbarElementList(ToolbarElementTo toolbarElementListTo,
			MethodCallback<ToolbarElementListTo> callback);

}