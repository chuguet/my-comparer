/**
 *
 * Copyright (C) FACTORIA ETSIA S.L.
 * All Rights Reserved.
 * www.factoriaetsia.com
 *
 */
package com.comparadorad.bet.comparer.web.client.gwt.toolbar.sports.data.dummy2;

import org.fusesource.restygwt.client.MethodCallback;

import com.comparadorad.bet.comparer.web.client.gwt.common.bean.cfg.response.ResourceTo;
import com.comparadorad.bet.comparer.web.client.gwt.core.dummy.AbstractDummyService;
import com.comparadorad.bet.comparer.web.client.gwt.toolbar.sports.bean.Level;
import com.comparadorad.bet.comparer.web.client.gwt.toolbar.sports.bean.ToolbarElementListTo;
import com.comparadorad.bet.comparer.web.client.gwt.toolbar.sports.bean.ToolbarElementTo;
import com.comparadorad.bet.comparer.web.client.gwt.toolbar.sports.service.ILeftToolbarService;

/**
 * The Class LeftToolbarDummyService.
 */
public class LeftToolbarDummyService extends AbstractDummyService implements
		ILeftToolbarService {

	/**
	 * Gets the first level.
	 * 
	 * @return the first level
	 */
	private ToolbarElementListTo getFirstLevel() {
		ToolbarElementListTo toolbarElements = new ToolbarElementListTo();

		toolbarElements.add(getToolbarElement(Level.NIVEL_1, "1", null, null,
				"Fútbol", "comparer/sport/basketball.png"));
		toolbarElements.add(getToolbarElement(Level.NIVEL_1, "2", null, null,
				"Baloncesto", "comparer/sport/football.png"));
		toolbarElements.add(getToolbarElement(Level.NIVEL_1, "3", null, null,
				"Tenis", "comparer/sport/tennis.png"));
		toolbarElements.add(getToolbarElement(Level.NIVEL_1, "4", null, null,
				"Motor", "comparer/sport/motor.png"));
		toolbarElements.add(getToolbarElement(Level.NIVEL_1, "5", null, null,
				"Handball", "comparer/sport/handball.png"));
		toolbarElements.add(getToolbarElement(Level.NIVEL_1, "6", null, null,
				"Ciclismo", "comparer/sport/cycling.png"));
		toolbarElements.add(getToolbarElement(Level.NIVEL_1, "7", null, null,
				"Hockey hielo", "comparer/sport/icehockey.png"));
		toolbarElements.add(getToolbarElement(Level.NIVEL_1, "8", null, null,
				"Fútbol americano", "comparer/sport/american_football.png"));

		return toolbarElements;
	}

	/**
	 * Gets the second level.
	 * 
	 * @param pSportId
	 *            the sport id
	 * @return the second level
	 */
	private ToolbarElementListTo getSecondLevel(String pSportId) {
		ToolbarElementListTo toolbarElements = new ToolbarElementListTo();
		if (pSportId.equalsIgnoreCase("1")) {
			toolbarElements.add(getToolbarElement(Level.NIVEL_2, pSportId, "1",
					null, "Alemania", "comparer/country/small/de.png"));
			toolbarElements.add(getToolbarElement(Level.NIVEL_2, pSportId, "2",
					null, "Argentina", "comparer/country/small/ar.png"));
			toolbarElements.add(getToolbarElement(Level.NIVEL_2, pSportId, "3",
					null, "España", "comparer/country/small/es.png"));
			toolbarElements.add(getToolbarElement(Level.NIVEL_2, pSportId, "4",
					null, "Suecia", "comparer/country/small/se.png"));
		} else {
			toolbarElements.add(getToolbarElement(Level.NIVEL_2, pSportId, "1",
					null, "Alemania", "comparer/country/small/de.png"));
			toolbarElements.add(getToolbarElement(Level.NIVEL_2, pSportId, "2",
					null, "Argentina", "comparer/country/small/ar.png"));
			toolbarElements.add(getToolbarElement(Level.NIVEL_2, pSportId, "3",
					null, "España", "comparer/country/small/es.png"));
			toolbarElements.add(getToolbarElement(Level.NIVEL_2, pSportId, "4",
					null, "Suecia", "comparer/country/small/se.png"));
			toolbarElements.add(getToolbarElement(Level.NIVEL_2, pSportId, "5",
					null, "Bulgaria", "comparer/country/small/bg.png"));
			toolbarElements.add(getToolbarElement(Level.NIVEL_2, pSportId, "6",
					null, "Colombia", "comparer/country/small/co.png"));
			toolbarElements.add(getToolbarElement(Level.NIVEL_2, pSportId, "7",
					null, "Finlandia", "comparer/country/small/fi.png"));
			toolbarElements.add(getToolbarElement(Level.NIVEL_2, pSportId, "8",
					null, "Islandia", "comparer/country/small/is.png"));
			toolbarElements.add(getToolbarElement(Level.NIVEL_2, pSportId, "9",
					null, "Noruega", "comparer/country/small/no.png"));
			toolbarElements.add(getToolbarElement(Level.NIVEL_2, pSportId,
					"10", null, "Perú", "comparer/country/small/pe.png"));
			toolbarElements.add(getToolbarElement(Level.NIVEL_2, pSportId,
					"11", null, "Brasil", "comparer/country/small/br.png"));
			toolbarElements.add(getToolbarElement(Level.NIVEL_2, pSportId,
					"12", null, "Irlanda", "comparer/country/small/ie.png"));
		}
		return toolbarElements;
	}

	/**
	 * Gets the third level.
	 * 
	 * @param pSportId
	 *            the sport id
	 * @param pRegionId
	 *            the region id
	 * @return the third level
	 */
	private ToolbarElementListTo getThirdLevel(String pSportId, String pRegionId) {
		ToolbarElementListTo toolbarElements = new ToolbarElementListTo();

		toolbarElements.add(getToolbarElement(Level.NIVEL_3, null, null,
				getUniqueCompetitionId("1", pSportId, pRegionId),
				"Competición 1", null));
		toolbarElements.add(getToolbarElement(Level.NIVEL_3, null, null,
				getUniqueCompetitionId("2", pSportId, pRegionId),
				"Competición 2", null));
		toolbarElements.add(getToolbarElement(Level.NIVEL_3, null, null,
				getUniqueCompetitionId("3", pSportId, pRegionId),
				"Competición 3", null));
		toolbarElements.add(getToolbarElement(Level.NIVEL_3, null, null,
				getUniqueCompetitionId("4", pSportId, pRegionId),
				"Competición 4", null));
		toolbarElements.add(getToolbarElement(Level.NIVEL_3, null, null,
				getUniqueCompetitionId("5", pSportId, pRegionId),
				"Competición 5", null));
		toolbarElements.add(getToolbarElement(Level.NIVEL_3, null, null,
				getUniqueCompetitionId("6", pSportId, pRegionId),
				"Competición 6", null));
		toolbarElements.add(getToolbarElement(Level.NIVEL_3, null, null,
				getUniqueCompetitionId("7", pSportId, pRegionId),
				"Competición 7", null));
		toolbarElements.add(getToolbarElement(Level.NIVEL_3, null, null,
				getUniqueCompetitionId("8", pSportId, pRegionId),
				"Competición 8", null));

		return toolbarElements;
	}

	/**
	 * Gets the toolbar element.
	 * 
	 * @param pNivel1
	 *            the nivel1
	 * @param pSportId
	 *            the sport id
	 * @param pRegionId
	 *            the region id
	 * @param pCompetitionId
	 *            the competition id
	 * @param pName
	 *            the name
	 * @param pResourceLocation
	 *            the resource location
	 * @return the toolbar element
	 */
	private ToolbarElementTo getToolbarElement(Level pNivel1, String pSportId,
			String pRegionId, String pCompetitionId, String pName,
			String pResourceLocation) {
		ToolbarElementTo toolbarElement = new ToolbarElementTo();
		toolbarElement.setLevel(pNivel1);
		toolbarElement.setSportId(pSportId);
		toolbarElement.setRegionId(pRegionId);
		toolbarElement.setCompetitionId(pCompetitionId);
		toolbarElement.setElementName(pName);
		toolbarElement.setResourceTo(new ResourceTo(pResourceLocation));
		return toolbarElement;
	}

	/**
	 * Gets the toolbar element list.
	 * 
	 * @param toolbarElementTo
	 *            the toolbar element to
	 * @param pCallback
	 *            the callback
	 * @return the toolbar element list {@inheritDoc}
	 */
	public void getToolbarElementList(ToolbarElementTo toolbarElementTo,
			MethodCallback<ToolbarElementListTo> pCallback) {
		ToolbarElementListTo toolbarElements = new ToolbarElementListTo();

		if (toolbarElementTo.getLevel().equals(Level.NIVEL_1)) {
			toolbarElements = getFirstLevel();
		} else if (toolbarElementTo.getLevel().equals(Level.NIVEL_2)) {
			toolbarElements = getSecondLevel(toolbarElementTo.getSportId());
		} else if (toolbarElementTo.getLevel().equals(Level.NIVEL_3)) {
			toolbarElements = getThirdLevel(toolbarElementTo.getSportId(),
					toolbarElementTo.getRegionId());
		}
		pCallback.onSuccess(null, toolbarElements);
	}

	/**
	 * Gets the unique competition id.
	 * 
	 * @param pId
	 *            the id
	 * @param pSportId
	 *            the sport id
	 * @param pRegionId
	 *            the region id
	 * @return the unique competition id
	 */
	private String getUniqueCompetitionId(String pId, String pSportId,
			String pRegionId) {
		return new StringBuffer().append(pId).append(pSportId)
				.append(pRegionId).toString();
	}

}