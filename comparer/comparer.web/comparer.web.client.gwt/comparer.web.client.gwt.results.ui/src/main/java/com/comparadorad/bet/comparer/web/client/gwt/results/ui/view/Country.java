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
import com.comparadorad.bet.comparer.web.client.gwt.common.bean.cfg.request.CountryRequestTo;
import com.comparadorad.bet.comparer.web.client.gwt.common.bean.table.TableResponseRowTo;
import com.comparadorad.bet.comparer.web.client.gwt.common.bean.table.TableResponseTo;
import com.comparadorad.bet.comparer.web.client.gwt.common.ui.tables.AbstractTableRefreshService;
import com.comparadorad.bet.comparer.web.client.gwt.core.data.AbstractServiceMethodCallback;
import com.comparadorad.bet.comparer.web.client.gwt.core.ipc.HashNames;
import com.comparadorad.bet.comparer.web.client.gwt.core.service.ServiceFactory;
import com.comparadorad.bet.comparer.web.client.gwt.results.ui.country.dummy.MainCountryEventsDummyService;
import com.comparadorad.bet.comparer.web.client.gwt.results.ui.country.dummy.MainCountryLongTermDummyService;
import com.comparadorad.bet.comparer.web.client.gwt.results.ui.country.service.CountryEventsService;
import com.comparadorad.bet.comparer.web.client.gwt.results.ui.country.service.CountryLongTermService;
import com.comparadorad.bet.comparer.web.client.gwt.results.ui.country.service.ICountryEventsService;
import com.comparadorad.bet.comparer.web.client.gwt.results.ui.country.service.ICountryLongTermService;
import com.comparadorad.bet.comparer.web.client.gwt.results.ui.view.table.TableFactory.BetType;
import com.comparadorad.bet.comparer.web.client.gwt.results.ui.view.table.TableFactory.Type;
import com.comparadorad.bet.comparer.web.client.gwt.results.ui.view.table.TableFactory.View;
import com.comparadorad.bet.comparer.web.client.gwt.results.ui.view.table.TableWrapper;
import com.comparadorad.bet.comparer.web.client.gwt.results.ui.view.tabset.HeadTab;
import com.comparadorad.bet.comparer.web.client.gwt.results.ui.view.tabset.HeadTabSet;
import com.comparadorad.bet.comparer.web.client.gwt.results.ui.view.tree.CountryTreeGrid;
import com.comparadorad.bet.comparer.web.client.gwt.results.ui.view.tree.GenericTree;
import com.comparadorad.bet.comparer.web.client.gwt.results.ui.view.tree.GenericTreeNode;
import com.comparadorad.bet.comparer.web.client.gwt.results.ui.view.tree.TreeNodeBetType;
import com.comparadorad.bet.comparer.web.client.gwt.results.ui.view.tree.TreeNodeCompetition;
import com.comparadorad.bet.comparer.web.client.gwt.results.ui.view.tree.TreeNodeTable;
import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.ui.RootPanel;
import com.smartgwt.client.widgets.tree.TreeNode;
import com.smartgwt.client.widgets.tree.events.FolderClosedEvent;
import com.smartgwt.client.widgets.tree.events.FolderOpenedEvent;

/**
 * The Class Country.
 */
public class Country extends ResultsView {

	/** The Constant EVENTS_TAB_INDEX. */
	private static final int EVENTS_TAB_INDEX = 0;

	/** The Constant LONG_TERM_TAB_INDEX. */
	private static final int LONG_TERM_TAB_INDEX = 1;

	/** The Constant TYPE. */
	private static final String TYPE = "type";

	/** The country request to. */
	private CountryRequestTo countryRequestTo;

	/** The events tab. */
	private HeadTab eventsTab;

	/** The events tab selected. */
	private boolean eventsTabSelected;

	/** The events tree. */
	private GenericTree eventsTree;

	/** The events tree grid. */
	private CountryTreeGrid eventsTreeGrid;

	/** The head. */
	private Head head;

	/** The head tab set. */
	private HeadTabSet headTabSet;

	/** The long term tab. */
	private HeadTab longTermTab;

	/** The long term tab selected. */
	private boolean longTermTabSelected;

	/** The long term tree. */
	private GenericTree longTermTree;

	/** The long term tree grid. */
	private CountryTreeGrid longTermTreeGrid;

	/**
	 * Instantiates a new country.
	 * 
	 * @param sportId
	 *            the sport id
	 * @param countryId
	 *            the country id
	 */
	public Country(final ObjectToId sportId, final ObjectToId countryId) {
		initCountry(sportId, countryId);
	}

	/**
	 * Instantiates a new country.
	 * 
	 * @param sportId
	 *            the sport id
	 * @param countryId
	 *            the country id
	 * @param headTabId
	 *            the head tab id
	 */
	public Country(final ObjectToId sportId, final ObjectToId countryId,
			final String headTabId) {
		getHashState().setInicialHeadTab(headTabId);
		getHashState().setViewResponsibleOfFixatingTheHash(false);
		initCountry(sportId, countryId);
	}

	/**
	 * Gets the country events competition.
	 * 
	 * @return the country events competition
	 */
	private void getCountryEventsCompetition() {
		Log.info("getCountryEventsCompetition");
		ICountryEventsService service = getCountryEventsService();
		service.getCountryEventsCompetition(countryRequestTo,
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
							TreeNodeCompetition[] treeNodes = new TreeNodeCompetition[pResponse
									.getRows().size()];
							int rowNum = 0;
							for (TableResponseRowTo rowData : pResponse
									.getRows()) {
								TreeNodeCompetition treeNode = new TreeNodeCompetition(
										rowData, eventsTree.getRootValue(),
										false);
								treeNodes[rowNum] = treeNode;
								rowNum++;
							}
							eventsTree.setData(treeNodes);
							eventsTreeGrid.setData(eventsTree);
						} else {
							showNoDataMessage(eventsTab,
									messages.noDataPaisCortoPlazo());
						}
						getDataLoading().hideLoadingIcon();
					}
				});
	}

	/**
	 * Gets the country events event.
	 * 
	 * @param node
	 *            the node
	 * @return the country events event
	 */
	private void getCountryEventsEvent(final GenericTreeNode node) {
		Log.info("getCountryLongTermEvent");
		final ICountryEventsService service = getCountryEventsService();
		final TableWrapper tableWrapper = new TableWrapper(View.COUNTRY,
				Type.EVENTS, null, null);
		final TreeNodeTable tableTreeNode = new TreeNodeTable(tableWrapper,
				tableWrapper.getID(), node.getTreeNodeId());
		tableWrapper.setTableRefreshService(new AbstractTableRefreshService() {
			@Override
			public void callServerToObtainTableData() {
				if (isViewVisible() && eventsTabSelected) {
					Log.debug("getBetOdds: compId = " + node.getTreeNodeId());
					countryRequestTo.setCompetitionId(new ObjectToId(node
							.getTreeNodeId()));
					service.getCountryEventsEvent(
							countryRequestTo,
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
											service.getCountryEventsEvent(
													countryRequestTo, this);
										} else {
											Log.info("Superado numero maximo de peticiones");
											this.resetCounterRequest();
											serverCallFailureForTreeNode(node,
													eventsTree);
										}
									} else {
										Log.info("Error sin microcorte");
										this.resetCounterRequest();
										serverCallFailureForTreeNode(node,
												eventsTree);
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
											eventsTreeGrid, eventsTree,
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
	 * Gets the country events service.
	 * 
	 * @return the country events service
	 */
	private ICountryEventsService getCountryEventsService() {
		ICountryEventsService service = (ICountryEventsService) ServiceFactory
				.getInstance().getService(
						GWT.create(CountryEventsService.class),
						GWT.create(MainCountryEventsDummyService.class));
		return service;
	}

	/**
	 * Gets the country long term bet types.
	 * 
	 * @param node
	 *            the node
	 * @return the country long term bet types
	 */
	private void getCountryLongTermBetTypes(final GenericTreeNode node) {
		Log.info("getCountryLongTermBetTypes");
		ICountryLongTermService service = getCountryLongTermService();
		Log.debug("compId = " + node.getTreeNodeId());
		countryRequestTo.setCompetitionId(new ObjectToId(node.getTreeNodeId()));
		service.getCountryLongTermBetType(countryRequestTo,
				new AbstractServiceMethodCallback<TableResponseTo>() {
					@Override
					protected void onFailureActions(Method pMethod,
							Throwable pException) {
						serverCallFailureForTreeNode(node, longTermTree);
					}

					@Override
					public void onSuccessActions(Method pMethod,
							TableResponseTo pResponse) {
						if (pResponse != null && pResponse.getRows() != null) {
							TreeNodeBetType[] treeNodes = new TreeNodeBetType[pResponse
									.getRows().size()];
							int rowNum = 0;
							for (TableResponseRowTo rowData : pResponse
									.getRows()) {
								TreeNodeBetType treeNode = new TreeNodeBetType(
										rowData, node.getTreeNodeId(), true);
								treeNodes[rowNum] = treeNode;
								Log.debug("treeNodeId = "
										+ treeNode.getTreeNodeId());
								rowNum++;
							}
							longTermTree.linkNodes(treeNodes);
						}
						getDataLoading().hideLoadingIcon();
					}
				});
	}

	/**
	 * Gets the country long term competition.
	 * 
	 * @return the country long term competition
	 */
	private void getCountryLongTermCompetition() {
		Log.info("getCountryLongTermCompetition");
		ICountryLongTermService service = getCountryLongTermService();
		service.getCountryLongTermCompetition(countryRequestTo,
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
							TreeNodeCompetition[] treeNodes = new TreeNodeCompetition[pResponse
									.getRows().size()];
							int rowNum = 0;
							for (TableResponseRowTo rowData : pResponse
									.getRows()) {
								TreeNodeCompetition treeNode = new TreeNodeCompetition(
										rowData, null, true);
								treeNode.setAttribute(TYPE,
										Type.LONG_TERM.name());
								treeNodes[rowNum] = treeNode;
								Log.debug("treeNodeId = "
										+ treeNode.getTreeNodeId());
								rowNum++;
							}
							longTermTree.setData(treeNodes);
							longTermTreeGrid.setData(longTermTree);
						} else {
							showNoDataMessage(longTermTab,
									messages.noDataPaisLargoPlazo());
						}
						getDataLoading().hideLoadingIcon();
					}
				});
	}

	/**
	 * Gets the country long term event.
	 * 
	 * @param node
	 *            the node
	 * @return the country long term event
	 */
	private void getCountryLongTermEvent(final TreeNodeBetType node) {
		Log.info("getCountryLongTermEvent");
		Log.debug("compId = " + node.getTreeNodeParentId());
		Log.debug("betTypeId = " + node.getTreeNodeIdAux());
		final ICountryLongTermService service = getCountryLongTermService();
		final TableWrapper tableWrapper = new TableWrapper(View.COUNTRY,
				Type.LONG_TERM, BetType.get(node.getTreeNodeIdAux()), null);
		final TreeNodeTable tableTreeNode = new TreeNodeTable(tableWrapper,
				tableWrapper.getID(), node.getTreeNodeId());
		tableWrapper.setTableRefreshService(new AbstractTableRefreshService() {
			@Override
			public void callServerToObtainTableData() {
				if (isViewVisible() && longTermTabSelected) {
					Log.debug("getBetOdds: compId = "
							+ node.getTreeNodeParentId() + ", betTypeId = "
							+ node.getTreeNodeIdAux());
					countryRequestTo.setCompetitionId(new ObjectToId(node
							.getTreeNodeParentId()));
					countryRequestTo.setBetTypeId(new ObjectToId(node
							.getTreeNodeIdAux()));
					service.getCountryLongTermEvent(
							countryRequestTo,
							new AbstractServiceMethodCallback<TableResponseTo>() {

								@Override
								protected void onFailureActions(Method pMethod,
										Throwable pException) {
									if (pMethod.getResponse().getStatusCode() == 404) {
										Log.info("Se produce un microcorte numero de peticion "
												+ this.getCounterRequest());
										if (this.getCounterRequest() < this
												.getMaxRequest()) {
											this.incCounterRequest();
											service.getCountryLongTermEvent(
													countryRequestTo, this);
										} else {
											Log.info("Superado numero maximo de peticiones");
											this.resetCounterRequest();
											serverCallFailureForTreeNode(node,
													longTermTree);
										}
									} else {
										Log.info("Error sin microcorte");
										this.resetCounterRequest();
										serverCallFailureForTreeNode(node,
												longTermTree);
									}
								}

								@Override
								public void onSuccessActions(Method pMethod,
										TableResponseTo pResponse) {
									serverCallSuccessForBetOdds(pResponse,
											tableWrapper, tableWrapper
													.getTableRefreshService());
									addTableTreeNode(tableWrapper,
											longTermTreeGrid, longTermTree,
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
	 * Gets the country long term service.
	 * 
	 * @return the country long term service
	 */
	private ICountryLongTermService getCountryLongTermService() {
		ICountryLongTermService service = (ICountryLongTermService) ServiceFactory
				.getInstance().getService(
						GWT.create(CountryLongTermService.class),
						GWT.create(MainCountryLongTermDummyService.class));
		return service;
	}

	/**
	 * Gets the head data.
	 * 
	 * @return the head data
	 */
	private void getHeadData() {
		ICountryLongTermService longTermService = getCountryLongTermService();
		longTermService.getHead(countryRequestTo,
				new AbstractServiceMethodCallback<HeadResponseTo>() {
					@Override
					protected void onFailureActions(Method pMethod,
							Throwable pException) {
						serverCallFailureForHeadData(messages
								.paisNoDisponibleTemporalmente());
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
	 * Inits the country.
	 * 
	 * @param sportId
	 *            the sport id
	 * @param countryId
	 *            the country id
	 */
	private void initCountry(final ObjectToId sportId,
			final ObjectToId countryId) {
		Log.debug("ID Country = " + getID());
		countryRequestTo = new CountryRequestTo();
		countryRequestTo.setSportId(sportId);
		countryRequestTo.setCountryId(countryId);

		getHashState().setResultViewHash(HashNames.COUNTRY_SP_HASH,
				sportId.getId(), false);
		getHashState().setResultViewHash(HashNames.COUNTRY_CO_HASH,
				countryId.getId(), false);

		head = new Head();

		longTermTreeGrid = new CountryTreeGrid();
		eventsTreeGrid = new CountryTreeGrid();
		longTermTree = new GenericTree();
		eventsTree = new GenericTree();

		longTermTreeGrid.addFolderOpenedHandler(getFolderOpenedHandler());
		eventsTreeGrid.addFolderOpenedHandler(getFolderOpenedHandler());
		longTermTreeGrid.addFolderClosedHandler(getFoldeClosedHandler());
		eventsTreeGrid.addFolderClosedHandler(getFoldeClosedHandler());

		headTabSet = new HeadTabSet(new StringBuffer()
				.append(countryId.getId()).append(getID()).toString());
		headTabSet.addTabSelectedHandler(getHeadTabSelectedHandler());

		longTermTab = new HeadTab(messages.apuesteSiempreEnLaMejorCuota(),
				true, longTermTreeGrid, messages.largoPlazo(),
				Integer.toString(LONG_TERM_TAB_INDEX), headTabSet.getID(), this
						.getClass().getName(), true);
		eventsTab = new HeadTab(messages.apuesteSiempreEnLaMejorCuota(), true,
				eventsTreeGrid, messages.eventos(),
				Integer.toString(EVENTS_TAB_INDEX), headTabSet.getID(), this
						.getClass().getName(), true);
		HeadTab[] tabs = new HeadTab[2];
		tabs[LONG_TERM_TAB_INDEX] = longTermTab;
		tabs[EVENTS_TAB_INDEX] = eventsTab;
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
		TreeNode[] nodeList = null;
		if (longTermTabSelected) {
			nodeList = longTermTree.getAllNodes(node);
		} else if (eventsTabSelected) {
			nodeList = eventsTree.getAllNodes(node);
		}
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
		googleAnalytics(new StringBuffer().append("country - ")
				.append(node.getAttribute("1")).toString());
		if (node instanceof TreeNodeCompetition && longTermTabSelected
				&& !longTermTree.hasChildNodes(node)) {
			Log.debug("onFolderOpenDo --> llamada a getCountryLongTermBetTypes");
			getDataLoading().showLoadingIconForTree(super.getAbsoluteTop(),
					super.getAbsoluteLeft());
			getCountryLongTermBetTypes(node);
		} else if (node instanceof TreeNodeCompetition && eventsTabSelected
				&& !eventsTree.hasChildNodes(node)) {
			Log.debug("onFolderOpenDo --> llamada a getCountryEventsEvent");
			Log.debug("RootPanel abTop = " + RootPanel.get().getAbsoluteTop());
			Log.debug("RootPanel abLeft = " + RootPanel.get().getAbsoluteLeft());
			getDataLoading().showLoadingIconForTree(super.getAbsoluteTop(),
					super.getAbsoluteLeft());
			getCountryEventsEvent(node);
		} else if (node instanceof TreeNodeBetType
				&& !longTermTree.hasChildNodes(node)) {
			Log.debug("onFolderOpenDo --> llamada a getCountryLongTermEvent");
			Log.debug("RootPanel abTop = " + RootPanel.get().getAbsoluteTop());
			Log.debug("RootPanel abLeft = " + RootPanel.get().getAbsoluteLeft());
			getDataLoading().showLoadingIconForTree(super.getAbsoluteTop(),
					super.getAbsoluteLeft());
			getCountryLongTermEvent((TreeNodeBetType) node);
		} else {
			TreeNode[] nodeList;
			if (eventsTabSelected) {
				nodeList = eventsTree.getAllNodes(node);
			} else {
				nodeList = longTermTree.getAllNodes(node);
			}
			startTimerOnChildNode(nodeList);
		}
	}

	/**
	 * On head tab selected.
	 * 
	 * @param tab
	 *            the tab
	 */
	protected void onHeadTabSelected(final HeadTab tab) {
		Log.info("onHeadTabSelected");
		if (tab.getIdWithoutPrefix().equalsIgnoreCase(
				Integer.toString(LONG_TERM_TAB_INDEX))) {
			longTermTabSelected = true;
			eventsTabSelected = false;
			if (!tab.isLoaded()) {
				tab.inicialLoad();
				Log.debug("onHeadTabSelected --> llamda a getCountryLongTermCompetition");
				Log.debug("RootPanel abTop = "
						+ RootPanel.get().getAbsoluteTop());
				Log.debug("RootPanel abLeft = "
						+ RootPanel.get().getAbsoluteLeft());
				getDataLoading().showLoadingIconForTree(super.getAbsoluteTop(),
						super.getAbsoluteLeft());
				getCountryLongTermCompetition();
			} else {
				TreeNode[] nodeList = eventsTree.getAllNodes();
				for (TreeNode n : nodeList) {
					GenericTreeNode gn = (GenericTreeNode) n;
					TreeNode[] nodeList2 = eventsTree.getAllNodes(gn);
					startTimerOnChildNode(nodeList2);
				}
				startTimerOnChildNode(nodeList);
			}
		} else if (tab.getIdWithoutPrefix().equalsIgnoreCase(
				Integer.toString(EVENTS_TAB_INDEX))) {
			eventsTabSelected = true;
			longTermTabSelected = false;
			if (!tab.isLoaded()) {
				tab.inicialLoad();
				Log.debug("onHeadTabSelected --> llamda a getCountryEventsCompetition");
				Log.debug("RootPanel abTop = "
						+ RootPanel.get().getAbsoluteTop());
				Log.debug("RootPanel abLeft = "
						+ RootPanel.get().getAbsoluteLeft());
				getDataLoading().showLoadingIconForTree(super.getAbsoluteTop(),
						super.getAbsoluteLeft());
				getCountryEventsCompetition();
			} else {
				TreeNode[] nodeList = longTermTree.getAllNodes();
				for (TreeNode n : nodeList) {
					GenericTreeNode gn = (GenericTreeNode) n;
					TreeNode[] nodeList2 = longTermTree.getAllNodes(gn);
					startTimerOnChildNode(nodeList2);
				}
			}
		} else {
			eventsTabSelected = false;
			longTermTabSelected = false;
		}
	}

}
