/**
 *
 * Copyright (C) FACTORIA ETSIA S.L.
 * All Rights Reserved.
 * www.factoriaetsia.com
 *
 */
package com.comparadorad.bet.comparer.web.client.gwt.toolbar.sports.ui;

import java.util.ArrayList;
import java.util.List;

import org.fusesource.restygwt.client.Method;

import com.allen_sauer.gwt.log.client.Log;
import com.comparadorad.bet.comparer.web.client.gwt.core.analytics.AnalyticsEventUtil;
import com.comparadorad.bet.comparer.web.client.gwt.core.data.AbstractServiceMethodCallback;
import com.comparadorad.bet.comparer.web.client.gwt.core.ipc.AppLinkUtil;
import com.comparadorad.bet.comparer.web.client.gwt.core.ipc.IIpcEventUtil;
import com.comparadorad.bet.comparer.web.client.gwt.core.ipc.InternalLinkEventNames;
import com.comparadorad.bet.comparer.web.client.gwt.core.ipc.IpcEventFactory;
import com.comparadorad.bet.comparer.web.client.gwt.core.prop.AppProperties;
import com.comparadorad.bet.comparer.web.client.gwt.core.service.ServiceFactory;
import com.comparadorad.bet.comparer.web.client.gwt.toolbar.sports.bean.Level;
import com.comparadorad.bet.comparer.web.client.gwt.toolbar.sports.bean.ToolbarElementListTo;
import com.comparadorad.bet.comparer.web.client.gwt.toolbar.sports.bean.ToolbarElementTo;
import com.comparadorad.bet.comparer.web.client.gwt.toolbar.sports.data.dummy2.LeftToolbarDummyService;
import com.comparadorad.bet.comparer.web.client.gwt.toolbar.sports.service.ILeftToolbarService;
import com.comparadorad.bet.comparer.web.client.gwt.toolbar.sports.service.LeftToolbarService;
import com.google.gwt.core.client.GWT;
import com.smartgwt.client.widgets.events.ClickEvent;
import com.smartgwt.client.widgets.events.ClickHandler;
import com.smartgwt.client.widgets.layout.SectionStackSection;

/**
 * The Class LeftToolbar.
 */
public class LeftToolbar extends SectionStackToolbar {

	/** The Constant LEVEL. */
	private static final String LEVEL = "LEVEL";

	/** The Constant linkUtil. */
	private static final AppLinkUtil linkUtil = new AppLinkUtil();

	/** The Constant REGION_ID. */
	private static final String REGION_ID = "REGION_ID";

	/** The Constant SPORT_ID. */
	private static final String SPORT_ID = "SPORT_ID";

	/** The Constant STYLE_APPENDIX_LABEL. */
	private static final String STYLE_APPENDIX_LABEL = "Label";

	/** The Constant STYLE_APPENDIX_SELECTED. */
	private static final String STYLE_APPENDIX_SELECTED = "Selected";

	/** The Constant STYLE_FIRST_LEVEL. */
	private static final String STYLE_FIRST_LEVEL = "toolbarFirstLevel";

	/** The Constant STYLE_SECOND_LEVEL. */
	private static final String STYLE_SECOND_LEVEL = "toolbarSecondLevel";

	/** The Constant STYLE_THIRD_LEVEL. */
	private static final String STYLE_THIRD_LEVEL = "toolbarThirdLevel";

	/** The resolved. */
	private List<String> resolved = new ArrayList<String>();

	/**
	 * Instantiates a new left toolbar.
	 */
	public LeftToolbar() {
		getSubMenuData(null);
	}

	/**
	 * Adds the first or second level.
	 * 
	 * @param pResponse
	 *            the response
	 * @param sectionStack
	 *            the section stack
	 */
	private void addFirstLevel(final ToolbarElementTo pResponse,
			final SectionStackToolbar sectionStack) {
		String location = null;
		if (pResponse.getResourceTo() != null
				&& pResponse.getResourceTo().getLocation() != null) {
			location = pResponse.getResourceTo().getLocation();
		}

		final FirstAndSecondLevel firstAndSecondLevel = new FirstAndSecondLevel(
				location, pResponse.getElementName(), 14, 14);
		setFirstLevelStyle(firstAndSecondLevel);
		final ToolbarSectionStackSection newSection = new ToolbarSectionStackSection(
				pResponse.getSportId(), pResponse.getElementName());
		firstAndSecondLevel.addClickHandler(new ClickHandler() {
			@Override
			public void onClick(ClickEvent event) {
				Log.info("Toolbar: onFirstAndSecondLevelClick");
				onFirstAndSecondLevelClick(firstAndSecondLevel, sectionStack,
						newSection);
			}
		});
		newSection.setAttribute(LEVEL, Level.NIVEL_2);
		newSection.setControls(firstAndSecondLevel);
		newSection.setAttribute(SPORT_ID, pResponse.getSportId());
		sectionStack.addSection(newSection);
	}

	/**
	 * Adds the first or second level.
	 * 
	 * @param pResponse
	 *            the response
	 * @param sectionStack
	 *            the section stack
	 */
	private void addSecondLevel(final ToolbarElementTo pResponse,
			final SectionStackToolbar sectionStack) {
		String location = null;
		String id = new StringBuffer(pResponse.getSportId()).append(
				pResponse.getRegionId()).toString();
		if (pResponse.getResourceTo() != null
				&& pResponse.getResourceTo().getLocation() != null) {
			location = pResponse.getResourceTo().getLocation();
		}

		final FirstAndSecondLevel firstAndSecondLevel = new FirstAndSecondLevel(
				location, pResponse.getElementName(), 12, 18);
		setSecondLevelStyle(firstAndSecondLevel);
		final ToolbarSectionStackSection newSection = new ToolbarSectionStackSection(
				id, pResponse.getElementName());
		firstAndSecondLevel.addClickHandler(new ClickHandler() {
			@Override
			public void onClick(ClickEvent event) {
				Log.info("Toolbar: onFirstAndSecondLevelClick");
				onFirstAndSecondLevelClick(firstAndSecondLevel, sectionStack,
						newSection);
			}
		});
		newSection.setAttribute(LEVEL, Level.NIVEL_3);
		newSection.setAttribute(REGION_ID, pResponse.getRegionId());
		newSection.setAttribute(SPORT_ID, pResponse.getSportId());
		newSection.setControls(firstAndSecondLevel);
		sectionStack.addSection(newSection);
	}

	/**
	 * Adds the sub menu data.
	 * 
	 * @param pResponse
	 *            the response
	 * @param parentSectionStackSection
	 *            the parent section stack section
	 */
	private void addSubMenuData(List<ToolbarElementTo> pResponse,
			final ToolbarSectionStackSection parentSectionStackSection) {
		SectionStackToolbar sectionStack = null;
		short level;
		if (parentSectionStackSection == null) {
			Log.debug("Toolbar - creamos nivel 1");
			level = 1;
			sectionStack = this;
		} else if (pResponse.get(0).getLevel().equals(Level.NIVEL_3)) {
			Log.debug("Toolbar - creamos nivel 3");
			level = 3;
		} else {
			Log.debug("Toolbar - creamos nivel 2");
			level = 2;
			sectionStack = new SectionStackToolbar();
		}
		for (ToolbarElementTo toolbarElementTo : pResponse) {
			if (level == 1) {
				addFirstLevel(toolbarElementTo, sectionStack);
			} else if (level == 2) {
				addSecondLevel(toolbarElementTo, sectionStack);
			} else if (level == 3) {
				addThirdLevel(toolbarElementTo, parentSectionStackSection);
			}
		}
		if (level == 2) {
			parentSectionStackSection.addItem(sectionStack);
		}
		if (parentSectionStackSection != null) {
			parentSectionStackSection.setExpanded(true);
		}
	}

	/**
	 * Adds the third level.
	 * 
	 * @param pResponse
	 *            the response
	 * @param parentSectionStackSection
	 *            the parent section stack section
	 */
	private void addThirdLevel(final ToolbarElementTo pResponse,
			final SectionStackSection parentSectionStackSection) {
		ThirdLevel thirdLevel = new ThirdLevel(pResponse.getElementName());
		thirdLevel.setStyleName(STYLE_THIRD_LEVEL);
		final String name = pResponse.getElementName();
		thirdLevel.addClickHandler(new ClickHandler() {
			@Override
			public void onClick(ClickEvent pEvent) {
				googleAnalytics(name);
				internalCompetitionClick(pResponse.getCompetitionId());
			}
		});
		parentSectionStackSection.addItem(thirdLevel);
	}

	/**
	 * Gets the sub menu data.
	 * 
	 * @param parentSectionStackSection
	 *            the parent section stack section
	 * @return the sub menu data
	 */
	private void getSubMenuData(
			final ToolbarSectionStackSection parentSectionStackSection) {
		ToolbarElementTo request = new ToolbarElementTo();
		ILeftToolbarService service = getToolbarService();
		if (parentSectionStackSection == null) {
			request.setLevel(Level.NIVEL_1);
		} else if (parentSectionStackSection.getAttribute(LEVEL).equals(
				Level.NIVEL_2.name())) {
			request.setLevel(Level.NIVEL_2);
			request.setSportId(parentSectionStackSection.getAttribute(SPORT_ID));
		} else if (parentSectionStackSection.getAttribute(LEVEL).equals(
				Level.NIVEL_3.name())) {
			request.setLevel(Level.NIVEL_3);
			request.setSportId(parentSectionStackSection.getAttribute(SPORT_ID));
			request.setRegionId(parentSectionStackSection
					.getAttribute(REGION_ID));
		}

		service.getToolbarElementList(request,
				new AbstractServiceMethodCallback<ToolbarElementListTo>() {
					@Override
					public void onSuccessActions(Method pMethod,
							ToolbarElementListTo pResponseList) {
						List<ToolbarElementTo> response = pResponseList
								.getToolbarElementList();
						if (response.size() != 0) {
							addSubMenuData(response, parentSectionStackSection);
						} else {
							Log.warn("La respuesta List<ToolbarElementTo> no contiene datos");
						}
					}
				});
	}

	/**
	 * Gets the service.
	 * 
	 * @return the service
	 */
	private ILeftToolbarService getToolbarService() {
		ILeftToolbarService service = (ILeftToolbarService) ServiceFactory
				.getInstance().getService(GWT.create(LeftToolbarService.class),
						GWT.create(LeftToolbarDummyService.class));
		return service;
	}

	/**
	 * Google analytics.
	 * 
	 * @param name
	 *            the name
	 */
	private void googleAnalytics(String name) {
		if (AppProperties.getInstance().isLiferayEnvironment()) {
			AnalyticsEventUtil analyticsEventUtil = new AnalyticsEventUtil();
//			analyticsEventUtil.trackAnalytics(new StringBuffer()
//					.append("toolbar - ").append(name).toString());
		}
	}

	/**
	 * Internal competition click.
	 * 
	 * @param id
	 *            the id
	 */
	protected void internalCompetitionClick(String id) {
		IIpcEventUtil ipcEventUtil = IpcEventFactory.getInstance()
				.createIpcEventUtil();
		Log.info("Toolbar fire event: CompetitionId = " + id);
		linkUtil.openInternalLinkInCurrentWindow(id, "",
				InternalLinkEventNames.TOOLBAR_COMPETITION_EVENT);
		Log.info("scrollTop");
		ipcEventUtil.scrollTop();
	}

	/**
	 * On first and second level click.
	 * 
	 * @param firstAndSecondLevel
	 *            the first and second level
	 * @param sectionStack
	 *            the section stack
	 * @param section
	 *            the section
	 */
	protected void onFirstAndSecondLevelClick(
			FirstAndSecondLevel firstAndSecondLevel,
			SectionStackToolbar sectionStack, ToolbarSectionStackSection section) {
		if (sectionStack.sectionIsExpanded(section.getSectionId())) {
			firstAndSecondLevel.setStyleName(firstAndSecondLevel.getStyleName()
					.replace(STYLE_APPENDIX_SELECTED, ""));
			firstAndSecondLevel.changeToClosedIcon();
			sectionStack.collapseSection(section.getSectionId());
			section.setExpanded(false);
		} else {
			firstAndSecondLevel.setStyleName(new StringBuffer()
					.append(firstAndSecondLevel.getStyleName())
					.append(STYLE_APPENDIX_SELECTED).toString());
			firstAndSecondLevel.changeToOpenIcon();
			sectionStack.expandSection(section.getSectionId());
			section.setExpanded(true);
			if (!resolved.contains(section.getSectionId())) {
				getSubMenuData(section);
				resolved.add(section.getSectionId());
			}
		}
		googleAnalytics(section.getSectionName());
	}

	/**
	 * Sets the first level style.
	 * 
	 * @param firstLevel
	 *            the new first level style
	 */
	private void setFirstLevelStyle(FirstAndSecondLevel firstLevel) {
		firstLevel.setStyleName(STYLE_FIRST_LEVEL);
		firstLevel.setLabelStyleName(new StringBuffer()
				.append(STYLE_FIRST_LEVEL).append(STYLE_APPENDIX_LABEL)
				.toString());
		firstLevel.setImgLeft(10);
		firstLevel.setLabelLeft(36);
	}

	/**
	 * Sets the second level style.
	 * 
	 * @param secondLevel
	 *            the new second level style
	 */
	private void setSecondLevelStyle(FirstAndSecondLevel secondLevel) {
		secondLevel.setStyleName(STYLE_SECOND_LEVEL);
		secondLevel.setLabelStyleName(new StringBuffer()
				.append(STYLE_SECOND_LEVEL).append(STYLE_APPENDIX_LABEL)
				.toString());
		secondLevel.setImgLeft(20);
		secondLevel.setLabelLeft(50);
	}

}
