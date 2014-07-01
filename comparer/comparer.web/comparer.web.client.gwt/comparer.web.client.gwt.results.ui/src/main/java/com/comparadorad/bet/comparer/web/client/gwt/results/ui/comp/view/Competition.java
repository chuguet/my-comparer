/**
 *
 * Copyright (C) FACTORIA ETSIA S.L.
 * All Rights Reserved.
 * www.factoriaetsia.com
 *
 */
package com.comparadorad.bet.comparer.web.client.gwt.results.ui.comp.view;

import java.util.List;

import org.fusesource.restygwt.client.Method;

import com.allen_sauer.gwt.log.client.Log;
import com.comparadorad.bet.comparer.web.client.gwt.common.bean.HeadResponseTo;
import com.comparadorad.bet.comparer.web.client.gwt.common.bean.ObjectToId;
import com.comparadorad.bet.comparer.web.client.gwt.common.bean.cfg.request.CompetitionRequestTo;
import com.comparadorad.bet.comparer.web.client.gwt.common.bean.tab.response.TabResponseTo;
import com.comparadorad.bet.comparer.web.client.gwt.common.bean.table.TableResponseRowTo;
import com.comparadorad.bet.comparer.web.client.gwt.common.bean.table.TableResponseTo;
import com.comparadorad.bet.comparer.web.client.gwt.common.ui.tables.AbstractTableRefreshService;
import com.comparadorad.bet.comparer.web.client.gwt.core.data.AbstractServiceMethodCallback;
import com.comparadorad.bet.comparer.web.client.gwt.core.ipc.HashNames;
import com.comparadorad.bet.comparer.web.client.gwt.core.service.ServiceFactory;
import com.comparadorad.bet.comparer.web.client.gwt.results.ui.Messages;
import com.comparadorad.bet.comparer.web.client.gwt.results.ui.comp.dummy.MainCompEventsDummyService;
import com.comparadorad.bet.comparer.web.client.gwt.results.ui.comp.dummy.MainCompLongTermDummyService;
import com.comparadorad.bet.comparer.web.client.gwt.results.ui.comp.service.CompetitionEventsService;
import com.comparadorad.bet.comparer.web.client.gwt.results.ui.comp.service.CompetitionLongTermService;
import com.comparadorad.bet.comparer.web.client.gwt.results.ui.comp.service.ICompetitionEventsService;
import com.comparadorad.bet.comparer.web.client.gwt.results.ui.comp.service.ICompetitionLongTermService;
import com.comparadorad.bet.comparer.web.client.gwt.results.ui.view.Head;
import com.comparadorad.bet.comparer.web.client.gwt.results.ui.view.ResultsView;
import com.comparadorad.bet.comparer.web.client.gwt.results.ui.view.table.TableFactory;
import com.comparadorad.bet.comparer.web.client.gwt.results.ui.view.table.TableFactory.BetType;
import com.comparadorad.bet.comparer.web.client.gwt.results.ui.view.table.TableFactory.Type;
import com.comparadorad.bet.comparer.web.client.gwt.results.ui.view.table.TableFactory.View;
import com.comparadorad.bet.comparer.web.client.gwt.results.ui.view.table.TableWrapper;
import com.comparadorad.bet.comparer.web.client.gwt.results.ui.view.tabset.BetTypeTab;
import com.comparadorad.bet.comparer.web.client.gwt.results.ui.view.tabset.BetTypeTabSet;
import com.comparadorad.bet.comparer.web.client.gwt.results.ui.view.tabset.HeadTab;
import com.comparadorad.bet.comparer.web.client.gwt.results.ui.view.tabset.HeadTabSet;
import com.comparadorad.bet.comparer.web.client.gwt.results.ui.view.tree.CompetitionTreeGrid;
import com.comparadorad.bet.comparer.web.client.gwt.results.ui.view.tree.GenericTree;
import com.comparadorad.bet.comparer.web.client.gwt.results.ui.view.tree.GenericTreeNode;
import com.comparadorad.bet.comparer.web.client.gwt.results.ui.view.tree.TreeNodeBetType;
import com.comparadorad.bet.comparer.web.client.gwt.results.ui.view.tree.TreeNodeLongTermEvent;
import com.comparadorad.bet.comparer.web.client.gwt.results.ui.view.tree.TreeNodeTable;
import com.google.gwt.core.client.GWT;
import com.smartgwt.client.widgets.tree.TreeNode;
import com.smartgwt.client.widgets.tree.events.FolderClosedEvent;
import com.smartgwt.client.widgets.tree.events.FolderOpenedEvent;

/**
 * The Class Competition.
 */
public class Competition extends ResultsView {

	/** The Constant NUM_STATIC_TABS. */
	private static final int NUM_STATIC_TABS = 2;

	/** The Constant EVENTS_TAB_INDEX. */
	private static final int TAB_INDEX_EVENTS = 0;

	/** The Constant LONG_TERM_TAB_INDEX. */
	private static final int TAB_INDEX_LONG_TERM = 1;

	/** The competition request to. */
	private CompetitionRequestTo competitionRequestTo;

	/** The events tab. */
	private HeadTab eventsTab;

	/** The events tab set. */
	private BetTypeTabSet eventsTabSet;

	/** The event tab selected. */
	boolean eventTabSelected;

	/** The head. */
	private Head head;

	/** The head tab set. */
	private HeadTabSet headTabSet;

	/** The inicial bet type tab. */
	private String inicialBetTypeTab;

	/** The inicial head tab. */
	private String inicialHeadTab;

	/** The long term tab. */
	private HeadTab longTermTab;

	/** The long term tab selected. */
	boolean longTermTabSelected;

	/** The long term tree. */
	private GenericTree longTermTree;

	/** The long term tree grid. */
	private CompetitionTreeGrid longTermTreeGrid;

	/** The messages. */
	private Messages messages = GWT.create(Messages.class);

	/**
	 * Instantiates a new competition.
	 * 
	 * @param competitionId
	 *            the competition id
	 */
	public Competition(final ObjectToId competitionId) {
		initCompetition(competitionId);
	}

	/**
	 * Instantiates a new competition.
	 * 
	 * @param competitionId
	 *            the competition id
	 * @param headTabId
	 *            the head tab id
	 */
	public Competition(final ObjectToId competitionId, String headTabId) {
		getHashState().setInicialHeadTab(headTabId);
		if (Integer.valueOf(headTabId) == TAB_INDEX_LONG_TERM) {
			getHashState().setViewResponsibleOfFixatingTheHash(false);
		}
		initCompetition(competitionId);
	}

	/**
	 * Instantiates a new competition.
	 * 
	 * @param competitionId
	 *            the competition id
	 * @param headTabId
	 *            the head tab id
	 * @param betTypeTabId
	 *            the bet type tab id
	 */
	public Competition(final ObjectToId competitionId, String headTabId,
			String betTypeTabId) {
		getHashState().setInicialHeadTab(headTabId);
		getHashState().setInicialBetTypeTab(betTypeTabId);
		getHashState().setViewResponsibleOfFixatingTheHash(false);
		initCompetition(competitionId);
	}

	/**
	 * Gets the table data for events bet type.
	 * 
	 * @param tab
	 *            the tab
	 * @param tableWrapper
	 *            the table wrapper
	 * @return the table data for events bet type
	 */
	private void getBetOddsForEventsBetType(final BetTypeTab tab,
			final TableWrapper tableWrapper) {
		Log.info("getBetOddsForEventsBetType");
		final ICompetitionEventsService eventsService = getCompetitionEventsService();
		tableWrapper.setTableRefreshService(new AbstractTableRefreshService() {
			@Override
			public void callServerToObtainTableData() {
				Log.debug("getBetOdds: betTypeId = "
						+ tableWrapper.getBetType().getId());
				competitionRequestTo.setBetTypeIdFirstLevel(new ObjectToId(
						tableWrapper.getBetType().getId()));
				if (isViewVisible() && eventTabSelected) {
					eventsService
							.getBetOdds(
									competitionRequestTo,
									new AbstractServiceMethodCallback<List<TableResponseTo>>() {

										@Override
										protected void onFailureActions(
												Method pMethod,
												Throwable pException) {
											if (pMethod.getResponse()
													.getStatusCode() == 404) {
												Log.info("Se produce un microcorte numero de peticion "
														+ this.getCounterRequest());
												if (this.getCounterRequest() < this
														.getMaxRequest()) {
													this.incCounterRequest();
													eventsService
															.getBetOdds(
																	competitionRequestTo,
																	this);
												} else {
													Log.info("Superado numero maximo de peticiones");
													this.resetCounterRequest();
													serverCallFailureForTabData(
															tab, false);
												}
											} else {
												Log.info("Error sin microcorte");
												this.resetCounterRequest();
												serverCallFailureForTabData(
														tab, false);
											}
										}

										@Override
										public void onSuccessActions(
												Method pMethod,
												List<TableResponseTo> pResponse) {
											serverCallSuccessForBetOdds(
													pResponse,
													tableWrapper,
													tableWrapper
															.getTableRefreshService());
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
	 * Ge bet types for events tab.
	 * 
	 * @param tab
	 *            the tab
	 * @return the bet types for events tab
	 */
	private void getBetTypesForEventsTab(final HeadTab tab) {
		Log.info("getBetTypesForEventsTab");
		ICompetitionEventsService eventsService = getCompetitionEventsService();
		eventsService.getBetTypes(competitionRequestTo,
				new AbstractServiceMethodCallback<TabResponseTo>() {

					@Override
					protected void onFailureActions(Method pMethod,
							Throwable pException) {
						serverCallFailureForTabData(tab, true);
					}

					@Override
					public void onSuccessActions(Method pMethod,
							TabResponseTo pResponse) {
						if (responseContainsData(pResponse)) {
							serverCallSuccessForBetTypes(eventsTabSet,
									pResponse, inicialBetTypeTab, true);
						} else {
							showNoDataMessage(eventsTab,
									messages.noDataCompeticionCortoPlazo());
						}
					}
				});
	}

	/**
	 * Gets the competition events service.
	 * 
	 * @return the competition events service
	 */
	private ICompetitionEventsService getCompetitionEventsService() {
		ICompetitionEventsService service = (ICompetitionEventsService) ServiceFactory
				.getInstance().getService(
						GWT.create(CompetitionEventsService.class),
						GWT.create(MainCompEventsDummyService.class));
		return service;
	}

	/**
	 * Gets the competition long term service.
	 * 
	 * @return the competition long term service
	 */
	private ICompetitionLongTermService getCompetitionLongTermService() {
		ICompetitionLongTermService service = (ICompetitionLongTermService) ServiceFactory
				.getInstance().getService(
						GWT.create(CompetitionLongTermService.class),
						GWT.create(MainCompLongTermDummyService.class));
		return service;
	}

	/**
	 * Gets the comp long term bet odds.
	 * 
	 * @param node
	 *            the node
	 * @return the comp long term bet odds
	 */
	private void getCompLongTermBetOdds(final TreeNodeBetType node) {
		Log.info("getCompLongTermBetOdds");
		Log.debug("eventId: " + node.getTreeNodeParentId());
		Log.debug("betTypeId: " + node.getTreeNodeIdAux());
		final ICompetitionLongTermService service = getCompetitionLongTermService();
		final TableWrapper tableWrapper = new TableWrapper(View.COMPETICION,
				Type.LONG_TERM, BetType.get(node.getTreeNodeIdAux()), null);
		final TreeNodeTable tableTreeNode = new TreeNodeTable(tableWrapper,
				tableWrapper.getID(), node.getTreeNodeId());
		tableWrapper.setTableRefreshService(new AbstractTableRefreshService() {
			@Override
			public void callServerToObtainTableData() {
				Log.debug("getBetOdds: betTypeId = " + node.getTreeNodeIdAux());
				if (isViewVisible() && longTermTabSelected) {
					competitionRequestTo.setEventId(new ObjectToId(node
							.getTreeNodeParentId()));
					competitionRequestTo.setBetTypeIdFirstLevel(new ObjectToId(
							node.getTreeNodeIdAux()));
					service.getBetOdds(
							competitionRequestTo,
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
											service.getBetOdds(
													competitionRequestTo, this);
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
	 * Gets the comp long term bet types.
	 * 
	 * @param node
	 *            the node
	 * @return the comp long term bet types
	 */
	private void getCompLongTermBetTypes(final TreeNodeLongTermEvent node) {
		Log.info("getCompLongTermBetTypes");
		ICompetitionLongTermService service = getCompetitionLongTermService();
		Log.debug("eventId = " + node.getTreeNodeId());
		competitionRequestTo.setEventId(new ObjectToId(node.getTreeNodeId()));
		service.getBetTypes(competitionRequestTo,
				new AbstractServiceMethodCallback<TableResponseTo>() {

					@Override
					protected void onFailureActions(Method pMethod,
							Throwable pException) {
						serverCallFailureForTreeNode(node, longTermTree);
					}

					@Override
					public void onSuccessActions(Method pMethod,
							TableResponseTo pResponse) {

						if (responseContainsData(pResponse)) {
							TreeNodeBetType[] treeNodes = new TreeNodeBetType[pResponse
									.getRows().size()];
							int rowNum = 0;
							for (TableResponseRowTo rowData : pResponse
									.getRows()) {
								TreeNodeBetType treeNode = new TreeNodeBetType(
										rowData, node.getTreeNodeId(), false);
								treeNodes[rowNum] = treeNode;
								rowNum++;
							}
							longTermTree.linkNodes(treeNodes);
						}
						getDataLoading().hideLoadingIcon();
					}
				});
	}

	/**
	 * Gets the comp long term events.
	 * 
	 * @return the comp long term events
	 */
	private void getCompLongTermEvents() {
		Log.info("getCompLongTermEvents");
		ICompetitionLongTermService service = getCompetitionLongTermService();
		service.getLongTermEvents(competitionRequestTo,
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
							TreeNodeLongTermEvent[] treeNodes = new TreeNodeLongTermEvent[pResponse
									.getRows().size()];
							int rowNum = 0;
							for (TableResponseRowTo rowData : pResponse
									.getRows()) {
								TreeNodeLongTermEvent treeNode = new TreeNodeLongTermEvent(
										rowData);
								treeNodes[rowNum] = treeNode;
								rowNum++;
							}
							longTermTree.setData(treeNodes);
							longTermTreeGrid.setData(longTermTree);
						} else {
							showNoDataMessage(longTermTab,
									messages.noDataCompeticionLargoPlazo());
						}
						getDataLoading().hideLoadingIcon();
					}
				});
	}

	/**
	 * Gets the head data.
	 * 
	 * @return the head data
	 */
	private void getHeadData() {
		ICompetitionLongTermService longTermService = getCompetitionLongTermService();
		longTermService.getHead(competitionRequestTo,
				new AbstractServiceMethodCallback<HeadResponseTo>() {
					@Override
					protected void onFailureActions(Method pMethod,
							Throwable pException) {
						serverCallFailureForHeadData(messages
								.competicionNoDisponibleTemporalmente());
					}

					@Override
					public void onSuccessActions(Method pMethod,
							HeadResponseTo pResponse) {
						boolean fixHash = false;
						int headTabIndex = headTabSet
								.selectInicialTab(getHashState()
										.getInicialHeadTab());
						if (headTabIndex == TAB_INDEX_EVENTS) {
							fixHash = false;
						} else {
							fixHash = true;
						}
						serverCallSuccessForHeadData(head, pResponse,
								headTabSet, fixHash);
					}
				});
	}

	/**
	 * Inits the competition.
	 * 
	 * @param competitionId
	 *            the competition id
	 */
	private void initCompetition(final ObjectToId competitionId) {
		Log.debug("initCompetition: inicialHeadTab = " + inicialHeadTab
				+ ", inicialBetTypeTab = " + inicialBetTypeTab);
		Log.debug("ID Competition = " + getID());

		competitionRequestTo = new CompetitionRequestTo(competitionId);
		getHashState().setResultViewHash(HashNames.COMPETITION_HASH,
				competitionId.getId(), false);

		// Head
		head = new Head();

		// TabSet de la pestaña Eventos
		eventsTabSet = new BetTypeTabSet(new StringBuffer()
				.append(competitionId.getId()).append(getID())
				.append(TAB_INDEX_EVENTS).toString());
		eventsTabSet.addTabSelectedHandler(getBetTypeTabSelectedHandler());
		eventsTabSet.addTabDeselectedHandler(getBetTypeTabDeselectedHandler());

		longTermTreeGrid = new CompetitionTreeGrid();
		longTermTree = new GenericTree();
		longTermTreeGrid.addFolderOpenedHandler(getFolderOpenedHandler());
		longTermTreeGrid.addFolderClosedHandler(getFoldeClosedHandler());

		// HeadTabSet con 3 tabs: Long term, Eventos, Statistics
		headTabSet = new HeadTabSet(new StringBuffer()
				.append(competitionId.getId()).append(getID()).toString());
		headTabSet.addTabSelectedHandler(getHeadTabSelectedHandler());

		longTermTab = new HeadTab(messages.apuestasDelEventoDetalladas(),
				false, longTermTreeGrid, messages.largoPlazo(),
				Integer.toString(TAB_INDEX_LONG_TERM), headTabSet.getID(), this
						.getClass().getName(), true);
		eventsTab = new HeadTab(messages.apuestasDelEventoDetalladas(), false,
				eventsTabSet, messages.eventos(),
				Integer.toString(TAB_INDEX_EVENTS), headTabSet.getID(), this
						.getClass().getName(), false);
		HeadTab[] tabs = new HeadTab[NUM_STATIC_TABS];
		tabs[TAB_INDEX_EVENTS] = eventsTab;
		tabs[TAB_INDEX_LONG_TERM] = longTermTab;
		headTabSet.setTabs(tabs);

		getHeadData();
	}

	/**
	 * On bet type tab selected.
	 * 
	 * @param tab
	 *            the tab {@inheritDoc}
	 */
	@Override
	protected void onBetTypeTabSelected(final BetTypeTab tab) {
		Log.info("onBetTypeTabSelected tabId = " + tab.getIdWithoutPrefix());
		getHashState().setBetTypeHash(tab.getIdWithoutPrefix(), true);
		((BetTypeTabSet) tab.getTabSet()).setFollowNativeTabCall(true);
		if (!tab.isLoaded()) {
			Log.debug("Nueva pestana seleccionada --> crear tabla");
			TableWrapper tableWrapper = new TableWrapper(
					TableFactory.View.COMPETICION, Type.EVENTS,
					TableFactory.BetType.get(tab.getBetTypeId()), null);
			tab.setPane(tableWrapper);
			tab.setLoaded(true);
			getDataLoading().showLoadingIconForTabSet(super.getAbsoluteTop(),
					super.getAbsoluteLeft());
			getBetOddsForEventsBetType(tab, tableWrapper);
		} else {
			if (tab.getPane() instanceof TableWrapper) {
				TableWrapper tableWrapper = (TableWrapper) tab.getPane();
				tableWrapper.startTimer();
			} else {
				tab.setLoaded(false);
			}
		}
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
		if (node instanceof TreeNodeLongTermEvent) {
			Log.debug("Parar timer al cerrar el nodo de long term event");
			TreeNode[] nodeList = longTermTree.getAllNodes(node);
			stopTimerOnChildNode(nodeList);
		} else if (node instanceof TreeNodeBetType) {
			Log.debug("Parar timer al cerrar el nodo betType");
			TreeNode[] nodeList = longTermTree.getAllNodes(node);
			stopTimerOnChildNode(nodeList);
		}
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
		if (node instanceof TreeNodeLongTermEvent) {
			if (longTermTree.getAllNodes(node).length <= 1) {
				Log.debug("onFolderOpenDo --> llamada a getBetTypes");
				getDataLoading().showLoadingIconForTree(super.getAbsoluteTop(),
						super.getAbsoluteLeft());
				getCompLongTermBetTypes((TreeNodeLongTermEvent) node);
			} else {
				TreeNode[] nodeList = longTermTree.getAllNodes(node);
				startTimerOnChildNode(nodeList);
			}
		} else if (node instanceof TreeNodeBetType) {
			if (longTermTree.getAllNodes(node).length <= 1) {
				Log.debug("onFolderOpenDo --> llamada a getCountryEventsEvent");
				getDataLoading().showLoadingIconForTree(super.getAbsoluteTop(),
						super.getAbsoluteLeft());
				getCompLongTermBetOdds((TreeNodeBetType) node);
			} else {
				TreeNode[] nodeList = longTermTree.getAllNodes(node);
				startTimerOnChildNode(nodeList);
			}
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
		Log.info("onHeadTabSelected tabId = " + tab.getIdWithoutPrefix());
		if (tab.getIdWithoutPrefix().equalsIgnoreCase(
				Integer.toString(TAB_INDEX_LONG_TERM))) {
			longTermTabSelected = true;
			eventTabSelected = false;
			if (!tab.isLoaded()) {
				tab.inicialLoad();
				getCompLongTermEvents();
			} else {
				TreeNode[] nodeList = longTermTree.getAllNodes();
				for (TreeNode n : nodeList) {
					GenericTreeNode gn = (GenericTreeNode) n;
					TreeNode[] nodeList2 = longTermTree.getAllNodes(gn);
					startTimerOnChildNode(nodeList2);
				}
				startTimerOnChildNode(nodeList);
			}
		} else if (tab.getIdWithoutPrefix().equalsIgnoreCase(
				Integer.toString(TAB_INDEX_EVENTS))) {
			longTermTabSelected = false;
			eventTabSelected = true;
			if (!tab.isLoaded()) {
				Log.debug("tab not loaded --> getBetTypesForEventsTab");
				tab.inicialLoad();
				getBetTypesForEventsTab(tab);
			} else if (eventsTabSet.getSelectedTab() != null) {
				Log.debug("call to onBetTypeTabSelected for eventsTab");
				onBetTypeTabSelected((BetTypeTab) eventsTabSet.getSelectedTab());
			}
		} else {
			Log.warn("Ninguna operacion encontrado para onHeadTabSelected");
			longTermTabSelected = false;
			eventTabSelected = false;
		}
	}

}
