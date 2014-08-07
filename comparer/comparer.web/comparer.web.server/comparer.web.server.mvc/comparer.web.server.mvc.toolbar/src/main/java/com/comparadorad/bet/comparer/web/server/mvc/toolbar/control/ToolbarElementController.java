/**
 *
 * Copyright (C) FACTORIA ETSIA S.L.
 * All Rights Reserved.
 * www.factoriaetsia.com
 *
 */
package com.comparadorad.bet.comparer.web.server.mvc.toolbar.control;

import java.util.Collections;
import java.util.List;

import javax.inject.Inject;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.comparadorad.bet.comparer.model.bet.bean.RtToolbarElement;
import com.comparadorad.bet.comparer.model.bet.service.IRtToolbarElementService;
import com.comparadorad.bet.comparer.model.config.bean.CfgCompetition;
import com.comparadorad.bet.comparer.model.config.bean.CfgRegion;
import com.comparadorad.bet.comparer.model.config.bean.CfgSport;
import com.comparadorad.bet.comparer.model.core.bean.user.UserData;
import com.comparadorad.bet.comparer.web.client.gwt.common.bean.cfg.response.ResourceTo;
import com.comparadorad.bet.comparer.web.client.gwt.toolbar.sports.bean.Level;
import com.comparadorad.bet.comparer.web.client.gwt.toolbar.sports.bean.ToolbarElementListTo;
import com.comparadorad.bet.comparer.web.client.gwt.toolbar.sports.bean.ToolbarElementTo;
import com.comparadorad.bet.comparer.web.server.mvc.toolbar.order.OrderToolbar;

/**
 * The Class SportTypeController.
 */
@Controller
@RequestMapping("/toolbarElementController")
public class ToolbarElementController {

	/** The Constant LOG. */
	private static final Log LOG = LogFactory
			.getLog(ToolbarElementController.class);

	/** The sport type service. */
	@Inject
	private IRtToolbarElementService toolbarElementService;

	/**
	 * Gets the sport list.
	 * 
	 * @param toolbarElementTo
	 *            the toolbar element to
	 * @param userData
	 *            the user data
	 * @return the sport list
	 */
	@RequestMapping(value = "/toolbarElementList", method = RequestMethod.POST)
	@ResponseBody
	public ToolbarElementListTo getToolbarElementList(
			@RequestBody final ToolbarElementTo toolbarElementTo,
			final UserData userData) {
		LOG.info("Comienza el controlador de la toolbar");

		List<RtToolbarElement> toolbarElements = null;
		ToolbarElementListTo result;

		if (toolbarElementTo.getLevel().equals(Level.NIVEL_1)) {
			toolbarElements = toolbarElementService.getFirstLevel();
		} else if (toolbarElementTo.getLevel().equals(Level.NIVEL_2)) {
			toolbarElements = toolbarElementService
					.getSecondLevel(toolbarElementTo.getSportId());
		} else if (toolbarElementTo.getLevel().equals(Level.NIVEL_3)) {
			toolbarElements = toolbarElementService.getThirdLevel(
					toolbarElementTo.getSportId(),
					toolbarElementTo.getRegionId());
		}
		Collections.sort(toolbarElements,
				new OrderToolbar(userData.getLocale()));
		result = convertNodesToTransferObject(toolbarElements, userData);

		LOG.info("Finaliza el controlador de la toolbar");
		return result;
	}

	/**
	 * Convert nodes to transfer object.
	 * 
	 * @param toolbarElements
	 *            the toolbar elements
	 * @param userData
	 *            the user data
	 * @return the toolbar element list to
	 */
	private ToolbarElementListTo convertNodesToTransferObject(
			List<RtToolbarElement> toolbarElements, UserData userData) {
		ToolbarElementListTo result = new ToolbarElementListTo();
		ToolbarElementTo toolbarElementTo;

		for (RtToolbarElement toolbarElement : toolbarElements) {
			toolbarElementTo = convertNodeToTransferObject(toolbarElement,
					userData);
			result.add(toolbarElementTo);
		}
		return result;
	}

	/**
	 * Convert node to transfer object.
	 * 
	 * @param toolbarElement
	 *            the toolbar element
	 * @param userData
	 *            the user data
	 * @return the toolbar element to
	 */
	private ToolbarElementTo convertNodeToTransferObject(
			RtToolbarElement toolbarElement, UserData userData) {
		ToolbarElementTo result = new ToolbarElementTo();

		if (toolbarElement.getToolbarConfigurable() instanceof CfgSport) {
			result.setLevel(Level.NIVEL_1);
			result.setSportId(toolbarElement.getToolbarConfigurable()
					.getObjectId().toString());
			result.setResourceTo(new ResourceTo(toolbarElement.getResource()
					.getLocation()));
		} else if (toolbarElement.getToolbarConfigurable() instanceof CfgRegion) {
			result.setLevel(Level.NIVEL_2);
			result.setResourceTo(new ResourceTo(toolbarElement.getResource()
					.getLocation()));
			result.setRegionId(toolbarElement.getToolbarConfigurable()
					.getObjectId().toString());
			result.setSportId(toolbarElement.getParentElement()
					.getToolbarConfigurable().getObjectId().toString());
		} else if (toolbarElement.getToolbarConfigurable() instanceof CfgCompetition) {
			result.setLevel(Level.NIVEL_3);
			result.setCompetitionId(toolbarElement.getToolbarConfigurable()
					.getObjectId().toString());
		}
		result.setElementName(toolbarElement.getTitle(userData.getLocale()));

		return result;
	}
}