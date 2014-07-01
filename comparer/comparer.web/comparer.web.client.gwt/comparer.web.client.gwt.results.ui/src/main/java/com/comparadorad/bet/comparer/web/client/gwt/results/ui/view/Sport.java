/**
 *
 * Copyright (C) FACTORIA ETSIA S.L.
 * All Rights Reserved.
 * www.factoriaetsia.com
 *
 */
package com.comparadorad.bet.comparer.web.client.gwt.results.ui.view;

import java.util.List;

import org.fusesource.restygwt.client.Method;

import com.allen_sauer.gwt.log.client.Log;
import com.comparadorad.bet.comparer.web.client.gwt.common.bean.HeadResponseTo;
import com.comparadorad.bet.comparer.web.client.gwt.common.bean.ObjectToId;
import com.comparadorad.bet.comparer.web.client.gwt.common.bean.cfg.request.SportRequestTo;
import com.comparadorad.bet.comparer.web.client.gwt.common.bean.table.TableResponseRowTo;
import com.comparadorad.bet.comparer.web.client.gwt.common.bean.table.TableResponseTo;
import com.comparadorad.bet.comparer.web.client.gwt.common.ui.tables.AbstractTableRefreshService;
import com.comparadorad.bet.comparer.web.client.gwt.core.data.AbstractServiceMethodCallback;
import com.comparadorad.bet.comparer.web.client.gwt.core.ipc.HashNames;
import com.comparadorad.bet.comparer.web.client.gwt.core.service.ServiceFactory;
import com.comparadorad.bet.comparer.web.client.gwt.results.ui.sport.dummy.MainSportCountriesDummyService;
import com.comparadorad.bet.comparer.web.client.gwt.results.ui.sport.service.ISportCountriesService;
import com.comparadorad.bet.comparer.web.client.gwt.results.ui.sport.service.SportCountriesService;
import com.comparadorad.bet.comparer.web.client.gwt.results.ui.view.table.TableFactory.BetType;
import com.comparadorad.bet.comparer.web.client.gwt.results.ui.view.table.TableFactory.Type;
import com.comparadorad.bet.comparer.web.client.gwt.results.ui.view.table.TableFactory.View;
import com.comparadorad.bet.comparer.web.client.gwt.results.ui.view.table.TableWrapper;
import com.comparadorad.bet.comparer.web.client.gwt.results.ui.view.tabset.HeadTab;
import com.comparadorad.bet.comparer.web.client.gwt.results.ui.view.tabset.HeadTabSet;
import com.comparadorad.bet.comparer.web.client.gwt.results.ui.view.tree.GenericTree;
import com.comparadorad.bet.comparer.web.client.gwt.results.ui.view.tree.GenericTreeNode;
import com.comparadorad.bet.comparer.web.client.gwt.results.ui.view.tree.SportTreeGrid;
import com.comparadorad.bet.comparer.web.client.gwt.results.ui.view.tree.TreeNodeCompetition;
import com.comparadorad.bet.comparer.web.client.gwt.results.ui.view.tree.TreeNodeCountry;
import com.comparadorad.bet.comparer.web.client.gwt.results.ui.view.tree.TreeNodeTable;
import com.google.gwt.core.client.GWT;
import com.smartgwt.client.widgets.tree.TreeNode;
import com.smartgwt.client.widgets.tree.events.FolderClosedEvent;
import com.smartgwt.client.widgets.tree.events.FolderOpenedEvent;

/**
 * The Class Sport.
 */
public class Sport extends ResultsView {

	/** The Constant EVENTS_TAB_INDEX. */
	private static final int COUNTRIES_TAB_INDEX = 0;

	/** The Constant NUM_STATIC_TABS. */
	private static final int NUM_STATIC_TABS = 1;

	/** The countries tab. */
	private HeadTab countriesTab;

	/** The countries tab selected. */
	private boolean countriesTabSelected;

	/** The head. */
	private Head head;

	/** The head tab set. */
	private HeadTabSet headTabSet;

	/** The sport request to. */
	private SportRequestTo sportRequestTo;

	/** The countries tree. */
	private GenericTree sportTree;

	/** The countries tree grid. */
	private SportTreeGrid sportTreeGrid;

	/**
	 * Instantiates a new sport.
	 * 
	 * @param sportId
	 *            the sport id
	 */
	public Sport(final ObjectToId sportId) {
		initSport(sportId);
	}

	/**
	 * Instantiates a new sport.
	 * 
	 * @param sportId
	 *            the sport id
	 * @param headTabId
	 *            the head tab id
	 */
	public Sport(final ObjectToId sportId, final String headTabId) {
		getHashState().setViewResponsibleOfFixatingTheHash(false);
		getHashState().setInicialHeadTab(headTabId);
		initSport(sportId);
	}

	/**
	 * Gets the head data.
	 * 
	 * @return the head data
	 */
	private void getHeadData() {
		ISportCountriesService service = getSportCountriesService();
		service.getHead(sportRequestTo,
				new AbstractServiceMethodCallback<HeadResponseTo>() {

					@Override
					protected void onFailureActions(Method pMethod,
							Throwable pException) {
						serverCallFailureForHeadData(messages
								.deporteNoDisponibleTemporalmente());
					}

					@Override
					public void onSuccessActions(Method pMethod,
							HeadResponseTo pResponse) {
						serverCallSuccessForHeadData(head, pResponse,
								headTabSet, true);
					}
				});
	}

	/**
	 * Gets the sport countries competitions.
	 * 
	 * @param node
	 *            the node
	 * @return the sport countries competitions
	 */
	private void getSportCountriesCompetitions(final GenericTreeNode node) {
		Log.info("getSportCountriesCompetitions");
		ISportCountriesService service = getSportCountriesService();
		sportRequestTo.setCountryId(new ObjectToId(node.getTreeNodeId()));
		service.getSportCountriesCompetitions(sportRequestTo,
				new AbstractServiceMethodCallback<TableResponseTo>() {

					@Override
					protected void onFailureActions(Method pMethod,
							Throwable pException) {
						serverCallFailureForTreeNode(node, sportTree);
					}

					@Override
					public void onSuccessActions(Method pMethod,
							TableResponseTo pResponse) {
						if (responseContainsData(pResponse)) {
							TreeNodeCompetition[] treeNodes = new TreeNodeCompetition[pResponse
									.getRows().size()];
							int rowNum = 0;
							for (TableResponseRowTo rowData : pResponse
									.getRows()) {
								treeNodes[rowNum] = new TreeNodeCompetition(
										rowData, node.getTreeNodeId(), false);
								rowNum++;
							}
							sportTree.linkNodes(treeNodes);
						}
						getDataLoading().hideLoadingIcon();
					}
				});
	}

	/**
	 * Gets the sport countries countries.
	 * 
	 * @return the sport countries countries
	 */
	private void getSportCountriesCountries() {
		Log.info("getSportCountriesCountries");
		ISportCountriesService service = getSportCountriesService();
		service.getSportCountriesCountries(sportRequestTo,
				new AbstractServiceMethodCallback<TableResponseTo>() {

					@Override
					protected void onFailureActions(Method pMethod,
							Throwable pException) {
						serverCallFailureForTabData(
								(HeadTab) headTabSet.getSelectedTab(), false);
					}

					@Override
					public void onSuccessActions(Method pMethod,
							TableResponseTo pResponse) {
						if (responseContainsData(pResponse)) {
							TreeNodeCountry[] treeNodes = new TreeNodeCountry[pResponse
									.getRows().size()];
							int rowNum = 0;
							for (TableResponseRowTo rowData : pResponse
									.getRows()) {
								treeNodes[rowNum] = new TreeNodeCountry(rowData);
								rowNum++;
							}
							sportTree.setData(treeNodes);
							sportTreeGrid.setData(sportTree);
						}
						getDataLoading().hideLoadingIcon();
					}
				});
	}

	/**
	 * Gets the sport countries events.
	 * 
	 * @param node
	 *            the node
	 * @return the sport countries events
	 */
	private void getSportCountriesEvents(final GenericTreeNode node) {
		Log.info("getSportCountriesEvents");
		final ISportCountriesService service = getSportCountriesService();
		final TableWrapper tableWrapper = new TableWrapper(View.SPORT,
				Type.EVENTS, null, null);
		final TreeNodeTable tableTreeNode = new TreeNodeTable(tableWrapper,
				tableWrapper.getID(), node.getTreeNodeId());
		tableWrapper.setTableRefreshService(new AbstractTableRefreshService() {
			@Override
			public void callServerToObtainTableData() {
				if (isViewVisible() && countriesTabSelected) {
					Log.debug("getBetOdds: compId = " + node.getTreeNodeId());
					sportRequestTo.setCompetitionId(new ObjectToId(node
							.getTreeNodeId()));
					service.getSportCountriesBetOdds(
							sportRequestTo,
							new AbstractServiceMethodCallback<List<TableResponseTo>>() {

								@Override
								protected void onFailureActions(Method pMethod,
										Throwable pException) {

									if (pMethod.getResponse().getStatusCode() == 404) {
										Log.info("Se produce un microcorte numero de peticion "
												+ this.getCounterRequest());
										if (this.getCounterRequest() < this
												.getMaxRequest()) {
											this.incCounterRequest();
											service.getSportCountriesBetOdds(
													sportRequestTo, this);
										} else {
											Log.info("Superado numero maximo de peticiones");
											this.resetCounterRequest();
											serverCallFailureForTreeNode(node,
													sportTree);
										}
									} else {
										Log.info("Error sin microcorte");
										this.resetCounterRequest();
										serverCallFailureForTreeNode(node,
												sportTree);
									}
								}

								@Override
								public void onSuccessActions(Method pMethod,
										List<TableResponseTo> pResponse) {
									String betTypeId = pResponse.get(0)
											.getTitle().getCellList().get(0)
											.getId().getId();
									tableWrapper.setBetType(BetType
											.get(betTypeId));
									serverCallSuccessForBetOdds(pResponse,
											tableWrapper, tableWrapper
													.getTableRefreshService());
									addTableTreeNode(tableWrapper,
											sportTreeGrid, sportTree,
											tableTreeNode, node);
								}
							});
				} else {
					stopRefreshTimer();
				}
			}
		});
		tableWrapper.getTableRefreshService().callServerToObtainTableData();
	}

	/**
	 * Gets the sport countries service.
	 * 
	 * @return the sport countries service
	 */
	private ISportCountriesService getSportCountriesService() {
		ISportCountriesService service = (ISportCountriesService) ServiceFactory
				.getInstance().getService(
						GWT.create(SportCountriesService.class),
						GWT.create(MainSportCountriesDummyService.class));
		return service;
	}

	/**
	 * Inits the sport.
	 * 
	 * @param sportId
	 *            the sport id
	 */
	public void initSport(final ObjectToId sportId) {
		Log.debug("ID Sport = " + getID());

		sportRequestTo = new SportRequestTo();
		sportRequestTo.setSportId(sportId);
		getHashState().setResultViewHash(HashNames.SPORT_HASH, sportId.getId(),
				false);

		head = new Head();

		sportTreeGrid = new SportTreeGrid();
		sportTree = new GenericTree();
		sportTreeGrid.addFolderOpenedHandler(getFolderOpenedHandler());
		sportTreeGrid.addFolderClosedHandler(getFoldeClosedHandler());

		headTabSet = new HeadTabSet(new StringBuffer().append(sportId.getId())
				.append(getID()).toString());
		headTabSet.addTabSelectedHandler(getHeadTabSelectedHandler());
		countriesTab = new HeadTab(
				messages.seleccionaUnPaisYEligeUnaCompeticion(), true,
				sportTreeGrid, messages.paises(),
				Integer.toString(COUNTRIES_TAB_INDEX), headTabSet.getID(), this
						.getClass().getName(), true);
		HeadTab[] tabs = new HeadTab[NUM_STATIC_TABS];
		tabs[COUNTRIES_TAB_INDEX] = countriesTab;
		headTabSet.setTabs(tabs);
		getHeadData();
	}

	/**
	 * On folder closed do.
	 * 
	 * @param event
	 *            the event {@inheritDoc}
	 */
	@Override
	protected void onFolderClosedDo(final FolderClosedEvent event) {
		Log.info("OnFolderClosedDo");
		GenericTreeNode node = (GenericTreeNode) event.getNode();
		TreeNode[] nodeList = sportTree.getAllNodes(node);
		stopTimerOnChildNode(nodeList);
	}

	/**
	 * On folder opened do.
	 * 
	 * @param event
	 *            the event {@inheritDoc}
	 */
	@Override
	protected void onFolderOpenedDo(final FolderOpenedEvent event) {
		Log.info("onFolderOpenDo");
		GenericTreeNode node = (GenericTreeNode) event.getNode();
		googleAnalytics(new StringBuffer().append("sport - ")
				.append(node.getName()).toString());
		if (node instanceof TreeNodeCountry && !sportTree.hasChildNodes(node)) {
			Log.debug("onFolderOpenDo --> llamda a getSportCountriesCompetitions");
			getDataLoading().showLoadingIconForTree(super.getAbsoluteTop(),
					super.getAbsoluteLeft());
			getSportCountriesCompetitions(node);
		} else if (node instanceof TreeNodeCompetition
				&& !sportTree.hasChildNodes(node)) {
			Log.debug("onFolderOpenDo --> llamda a getSportCountriesEvents");
			getDataLoading().showLoadingIconForTree(super.getAbsoluteTop(),
					super.getAbsoluteLeft());
			getSportCountriesEvents(node);
		} else {
			TreeNode[] nodeList = sportTree.getAllNodes(node);
			startTimerOnChildNode(nodeList);
		}
	}

	/**
	 * On head tab selected.
	 * 
	 * @param tab
	 *            the tab {@inheritDoc}
	 */
	@Override
	protected void onHeadTabSelected(final HeadTab tab) {
		Log.info("onHeadTabSelected");
		if (tab.getIdWithoutPrefix().equalsIgnoreCase(
				Integer.toString(COUNTRIES_TAB_INDEX))) {
			countriesTabSelected = true;
			if (!tab.isLoaded()) {
				tab.inicialLoad();
				Log.debug("onHeadTabSelected --> llamda a getSportCountriesCountries");
				getDataLoading().showLoadingIconForTabSet(
						super.getAbsoluteTop(), super.getAbsoluteLeft());
				getSportCountriesCountries();
			}
		} else {
			countriesTabSelected = false;
		}
	}

}
