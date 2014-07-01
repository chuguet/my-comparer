/**
 *
 * Copyright (C) FACTORIA ETSIA S.L.
 * All Rights Reserved.
 * www.factoriaetsia.com
 *
 */
package com.comparadorad.bet.comparer.web.client.gwt.results.ui.event.view;

import java.util.List;

import org.fusesource.restygwt.client.Method;

import com.allen_sauer.gwt.log.client.Log;
import com.comparadorad.bet.comparer.web.client.gwt.common.bean.HeadResponseTo;
import com.comparadorad.bet.comparer.web.client.gwt.common.bean.ObjectToId;
import com.comparadorad.bet.comparer.web.client.gwt.common.bean.cfg.request.EventRequestTo;
import com.comparadorad.bet.comparer.web.client.gwt.common.bean.tab.response.TabResponseTo;
import com.comparadorad.bet.comparer.web.client.gwt.common.bean.table.TableResponseTo;
import com.comparadorad.bet.comparer.web.client.gwt.common.ui.tables.AbstractTableRefreshService;
import com.comparadorad.bet.comparer.web.client.gwt.core.data.AbstractServiceMethodCallback;
import com.comparadorad.bet.comparer.web.client.gwt.core.ipc.HashNames;
import com.comparadorad.bet.comparer.web.client.gwt.core.service.ServiceFactory;
import com.comparadorad.bet.comparer.web.client.gwt.results.ui.Messages;
import com.comparadorad.bet.comparer.web.client.gwt.results.ui.event.dummy.MainEventQuotasDummyService;
import com.comparadorad.bet.comparer.web.client.gwt.results.ui.event.service.EventQuotasService;
import com.comparadorad.bet.comparer.web.client.gwt.results.ui.event.service.IEventQuotasService;
import com.comparadorad.bet.comparer.web.client.gwt.results.ui.view.Head;
import com.comparadorad.bet.comparer.web.client.gwt.results.ui.view.ResultsView;
import com.comparadorad.bet.comparer.web.client.gwt.results.ui.view.table.TableFactory;
import com.comparadorad.bet.comparer.web.client.gwt.results.ui.view.table.TableWrapper;
import com.comparadorad.bet.comparer.web.client.gwt.results.ui.view.tabset.BetTypeEventTab;
import com.comparadorad.bet.comparer.web.client.gwt.results.ui.view.tabset.BetTypeEventsTabSet;
import com.comparadorad.bet.comparer.web.client.gwt.results.ui.view.tabset.BetTypeTab;
import com.comparadorad.bet.comparer.web.client.gwt.results.ui.view.tabset.BetTypeTabSet;
import com.comparadorad.bet.comparer.web.client.gwt.results.ui.view.tabset.HeadTab;
import com.comparadorad.bet.comparer.web.client.gwt.results.ui.view.tabset.HeadTabSet;
import com.google.gwt.core.client.GWT;

/**
 * The Class Event.
 */
public class Event extends ResultsView {

	/** The Constant NUM_STATIC_TABS. */
	private static final int NUM_STATIC_TABS = 1;

	/** The Constant EVENTS_TAB_INDEX. */
	private static final int TAB_INDEX_QUOTAS = 0;

	/** The bet types tab set. */
	private BetTypeTabSet betTypeTabSet;

	/** The event request to. */
	private EventRequestTo eventRequestTo;

	/** The head. */
	private Head head;

	/** The head tab set. */
	private HeadTabSet headTabSet;

	/** The messages. */
	private Messages messages = GWT.create(Messages.class);

	/** The events tab. */
	private HeadTab quotasTab;

	/** The events tab selected. */
	boolean quotasTabSelected;

	/** The statistics tab. */
	private HeadTab statisticsTab;

	/** The statistics tab selected. */
	boolean statisticsTabSelected;

	/**
	 * Instantiates a new event.
	 * 
	 * @param eventId
	 *            the event id
	 */
	public Event(final ObjectToId eventId) {
		initEvent(eventId);
	}

	/**
	 * Instantiates a new event.
	 * 
	 * @param eventId
	 *            the event id
	 * @param headTabId
	 *            the head tab id
	 */
	public Event(final ObjectToId eventId, String headTabId) {
		getHashState().setInicialHeadTab(headTabId);
		initEvent(eventId);
	}

	/**
	 * Instantiates a new event.
	 * 
	 * @param eventId
	 *            the event id
	 * @param headTabId
	 *            the head tab id
	 * @param betTypeTabId
	 *            the bet type tab id
	 */
	public Event(final ObjectToId eventId, final String headTabId,
			final String betTypeTabId) {
		getHashState().setInicialHeadTab(headTabId);
		getHashState().setInicialBetTypeTab(betTypeTabId);
		initEvent(eventId);
	}

	/**
	 * Instantiates a new event.
	 * 
	 * @param eventId
	 *            the event id
	 * @param headTabId
	 *            the head tab id
	 * @param betTypeTabId
	 *            the bet type tab id
	 * @param betTypeEventTabId
	 *            the bet type event tab id
	 */
	public Event(final ObjectToId eventId, final String headTabId,
			final String betTypeTabId, final String betTypeEventTabId) {
		getHashState().setInicialHeadTab(headTabId);
		getHashState().setInicialBetTypeTab(betTypeTabId);
		getHashState().setInicialBetTypeEventTab(betTypeEventTabId);
		getHashState().setViewResponsibleOfFixatingTheHash(false);
		initEvent(eventId);
	}

	/**
	 * Gets the bet odds.
	 * 
	 * @param tableWrapper
	 *            the table wrapper
	 * @return the bet odds
	 */
	private void getBetOdds(final TableWrapper tableWrapper) {
		final IEventQuotasService service = getEventService();
		tableWrapper.setTableRefreshService(new AbstractTableRefreshService() {
			@Override
			public void callServerToObtainTableData() {
				Log.info("Start get Bet odds");
				if (isViewVisible() && quotasTabSelected) {
					Log.debug("getBetOdds: betType = "
							+ tableWrapper.getBetType().getId()
							+ ", betTypeEvent = "
							+ tableWrapper.getBetTypeEvent());
					eventRequestTo.setBetTypeId(new ObjectToId(tableWrapper
							.getBetType().getId()));
					eventRequestTo.setBetTypeEventId(new ObjectToId(
							tableWrapper.getBetTypeEvent()));
					service.getBetOdds(
							eventRequestTo,
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
											service.getBetOdds(eventRequestTo,
													this);
										} else {
											Log.info("Superado numero maximo de peticiones");
											this.resetCounterRequest();
											BetTypeTab betTypeTab = (BetTypeTab) betTypeTabSet
													.getSelectedTab();
											if (betTypeTab.isLoaded()
													&& betTypeTab.getPane() instanceof BetTypeEventsTabSet) {
												BetTypeEventsTabSet betTypeEventsTabSet = (BetTypeEventsTabSet) betTypeTab
														.getPane();
												BetTypeEventTab betTypeEventTab = (BetTypeEventTab) betTypeEventsTabSet
														.getSelectedTab();
												serverCallFailureForTabData(
														betTypeEventTab, false);
											} else {
												serverCallFailureForTabData(
														(BetTypeTab) betTypeTabSet
																.getSelectedTab(),
														false);
											}
										}
									} else {
										Log.info("Error sin microcorte");
										this.resetCounterRequest();
										BetTypeTab betTypeTab = (BetTypeTab) betTypeTabSet
												.getSelectedTab();
										if (betTypeTab.isLoaded()
												&& betTypeTab.getPane() instanceof BetTypeEventsTabSet) {
											BetTypeEventsTabSet betTypeEventsTabSet = (BetTypeEventsTabSet) betTypeTab
													.getPane();
											BetTypeEventTab betTypeEventTab = (BetTypeEventTab) betTypeEventsTabSet
													.getSelectedTab();
											serverCallFailureForTabData(
													betTypeEventTab, false);
										} else {
											serverCallFailureForTabData(
													(BetTypeTab) betTypeTabSet
															.getSelectedTab(),
													false);
										}
									}
								}

								@Override
								public void onSuccessActions(Method pMethod,
										List<TableResponseTo> pResponse) {
									this.resetCounterRequest();
									Log.info("Start get Bet odds. OnSuccess Actions");
									serverCallSuccessForBetOdds(pResponse,
											tableWrapper, tableWrapper
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
	 * Gets the bet types for events tab.
	 * 
	 * @param tab
	 *            the tab
	 * @return the bet types for events tab
	 */
	private void getBetTypesForQuotasTab(final HeadTab tab) {
		Log.info("getBetTypesForQuotasTab");
		IEventQuotasService eventsService = getEventService();
		eventsService.getBetTypes(eventRequestTo,
				new AbstractServiceMethodCallback<TabResponseTo>() {
					@Override
					protected void onFailureActions(Method pMethod,
							Throwable pException) {
						serverCallFailureForTabData(tab, true);
					}

					@Override
					public void onSuccessActions(Method pMethod,
							TabResponseTo pResponse) {
						Log.info("Start getBetTypesForQuotasTab. OnSuccess");
						serverCallSuccessForBetTypes(betTypeTabSet, pResponse,
								getHashState().getInicialBetTypeTab(), false);
					}
				});
	}

	/**
	 * Gets the event service.
	 * 
	 * @return the event service
	 */
	private IEventQuotasService getEventService() {
		IEventQuotasService service = (IEventQuotasService) ServiceFactory
				.getInstance().getService(GWT.create(EventQuotasService.class),
						GWT.create(MainEventQuotasDummyService.class));
		return service;
	}

	/**
	 * Gets the events for bet type tab.
	 * 
	 * @param tab
	 *            the tab
	 * @return the events for bet type tab
	 */
	private void getEventsForBetTypeTab(final BetTypeTab tab) {
		Log.info("getEventsForBetTypeTab: betTypeId = " + tab.getBetTypeId());
		IEventQuotasService service = getEventService();
		eventRequestTo.setBetTypeId(new ObjectToId(tab.getBetTypeId()));
		service.getBetTypeEvent(eventRequestTo,
				new AbstractServiceMethodCallback<TabResponseTo>() {

					@Override
					protected void onFailureActions(Method pMethod,
							Throwable pException) {
						serverCallFailureForTabData(tab, true);
					}

					@Override
					public void onSuccessActions(Method pMethod,
							TabResponseTo pResponse) {
						Log.info("Start getEventsForBetTypeTab. OnSuccess");
						if (pResponse.getTabs() != null) {
							// Nuevo TabSet con los eventos del bet type
							Log.debug("Creamos betTypeEventsTabSet");
							final BetTypeEventsTabSet betTypeEventsTabSet = new BetTypeEventsTabSet(
									tab.getIdWithPrefix());
							betTypeEventsTabSet.loadTabsWithBetTypeEventId(
									pResponse, tab.getBetTypeId(),
									betTypeEventsTabSet.getID());
							int inicialTabIndex = selectInicialTab(
									betTypeEventsTabSet, getHashState()
											.getInicialBetTypeEventTab());
							getHashState().clearInitialBetEventTab();
							betTypeEventsTabSet
									.addTabSelectedHandler(getBetTypeEventTabSelectedHandler());
							betTypeEventsTabSet
									.addTabDeselectedHandler(getBetTypeEventTabDeselectedHandler());
							tab.setPane(betTypeEventsTabSet);
							tab.setLoaded(true);
							onBetTypeEventTabSelected((BetTypeEventTab) betTypeEventsTabSet
									.getTab(inicialTabIndex));
							betTypeEventsTabSet.selectTab(inicialTabIndex);
						} else {
							Log.debug("Creamos tableWrapper: betTypeId = "
									+ tab.getBetTypeId());
							TableWrapper tableWrapper = new TableWrapper(
									TableFactory.View.EVENT,
									TableFactory.Type.QUOTAS,
									TableFactory.BetType.get(tab.getBetTypeId()),
									null);
							tab.setPane(tableWrapper);
							tab.setFixHash(true);
							getHashState().fixateHashDirectly();
							getBetOdds(tableWrapper);
						}
					}
				});
	}

	/**
	 * Gets the head data.
	 * 
	 * @return the head data
	 */
	private void getHeadData() {
		Log.info("Start get Head Data");
		IEventQuotasService longTermService = getEventService();
		longTermService.getHead(eventRequestTo,
				new AbstractServiceMethodCallback<HeadResponseTo>() {
					@Override
					protected void onFailureActions(Method pMethod,
							Throwable pException) {
						serverCallFailureForHeadData(messages
								.eventoNoDisponibleTemporalmente());
					}

					@Override
					public void onSuccessActions(Method pMethod,
							HeadResponseTo pResponse) {
						Log.info("Start get Head Data. OnSuccess");
						boolean fixHash = false;
						int headTabIndex = headTabSet
								.selectInicialTab(getHashState()
										.getInicialHeadTab());
						if (headTabIndex == TAB_INDEX_QUOTAS) {
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
	 * Inits the event.
	 * 
	 * @param eventId
	 *            the event id
	 */
	private void initEvent(final ObjectToId eventId) {
		Log.debug("initEvent: inicialHeadTab = "
				+ getHashState().getInicialHeadTab() + ", inicialBetTypeTab = "
				+ getHashState().getInicialBetTypeTab()
				+ ", inicialBetTypeEventTab = "
				+ getHashState().getInicialBetTypeEventTab());
		Log.debug("ID Event = " + getID());

		eventRequestTo = new EventRequestTo(eventId);
		getHashState().setResultViewHash(HashNames.EVENT_HASH, eventId.getId(),
				false);

		// Head
		head = new Head();

		// BetTypeTabSets
		betTypeTabSet = new BetTypeTabSet(new StringBuffer()
				.append(eventId.getId()).append(getID())
				.append(TAB_INDEX_QUOTAS).toString());
		betTypeTabSet.addTabSelectedHandler(getBetTypeTabSelectedHandler());
		betTypeTabSet.addTabDeselectedHandler(getBetTypeTabDeselectedHandler());

		// HeadTabSet
		headTabSet = new HeadTabSet(new StringBuffer().append(eventId.getId())
				.append(getID()).toString());
		headTabSet.addTabSelectedHandler(getHeadTabSelectedHandler());
		quotasTab = new HeadTab(messages.apuestasDelEventoDetalladas(), false,
				betTypeTabSet, messages.eventos(),
				Integer.toString(TAB_INDEX_QUOTAS), headTabSet.getID(), this
						.getClass().getName(), false);
		HeadTab[] tabs = new HeadTab[NUM_STATIC_TABS];
		tabs[TAB_INDEX_QUOTAS] = quotasTab;
		headTabSet.setTabs(tabs);
		getHeadData();
	}

	/**
	 * On bet type event tab selected.
	 * 
	 * @param tab
	 *            the tab {@inheritDoc}
	 */
	@Override
	protected void onBetTypeEventTabSelected(final BetTypeEventTab tab) {
		Log.info("Seleccionamos onBetTypeEventTabSelected");
		getHashState().setBetTypeEventHash(tab.getIdWithoutPrefix(),
				tab.isFixHash());
		((BetTypeEventsTabSet) tab.getTabSet()).setFollowNativeTabCall(true);
		if (!tab.isLoaded()) {
			Log.debug("tab is not loaded --> call to get betOdds");
			Log.debug("betTypeId = " + tab.getBetTypeId() + "betTypeEventId = "
					+ tab.getBetTypeEventId());
			getDataLoading().showLoadingIconForTabSet(super.getAbsoluteTop(),
					super.getAbsoluteLeft());
			TableWrapper tableWrapper = new TableWrapper(
					TableFactory.View.EVENT, TableFactory.Type.QUOTAS,
					TableFactory.BetType.get(tab.getBetTypeId()),
					tab.getBetTypeEventId());
			tab.setPane(tableWrapper);
			getBetOdds(tableWrapper);
			tab.setLoaded(true);
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
	 * On bet type tab selected.
	 * 
	 * @param tab
	 *            the tab
	 */
	protected void onBetTypeTabSelected(final BetTypeTab tab) {
		Log.info("onBetTypeTabSelected: " + tab.getBetTypeId());
		getHashState()
				.setBetTypeHash(tab.getIdWithoutPrefix(), tab.isFixHash());
		((BetTypeTabSet) tab.getTabSet()).setFollowNativeTabCall(true);
		if (!tab.isLoaded()) {
			getEventsForBetTypeTab(tab);
			tab.setLoaded(true);
		} else {
			if (tab.getPane() instanceof TableWrapper) {
				Log.debug("tab pane instance of TableWrapper");
				tab.setFixHash(true);
				TableWrapper tableWrapper = (TableWrapper) tab.getPane();
				tableWrapper.startTimer();
			} else if (tab.getPane() instanceof BetTypeEventsTabSet) {
				Log.debug("tab pane instance of BetTypeEventsTabSet");
				BetTypeEventsTabSet tabSet = (BetTypeEventsTabSet) tab
						.getPane();
				if (tabSet.getSelectedTab() != null) {
					onBetTypeEventTabSelected((BetTypeEventTab) tabSet
							.getSelectedTab());
				}
			} else {
				Log.warn("Ninguna operacion encontrado para el tab");
				tab.setLoaded(false);
			}
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
				Integer.toString(TAB_INDEX_QUOTAS))) {
			quotasTabSelected = true;
			if (!tab.isLoaded()) {
				tab.inicialLoad();
				getBetTypesForQuotasTab(tab);
			} else if (betTypeTabSet.getSelectedTab() != null) {
				BetTypeTab betTypeTab = (BetTypeTab) betTypeTabSet
						.getSelectedTab();
				if (betTypeTab.getPane() instanceof TableWrapper) {
					betTypeTab.setFixHash(true);
				}
				onBetTypeTabSelected(betTypeTab);
			}
		} else {
			quotasTabSelected = false;
		}
	}

}
