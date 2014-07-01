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
import com.comparadorad.bet.comparer.web.client.gwt.common.bean.tab.response.TabResponseTo;
import com.comparadorad.bet.comparer.web.client.gwt.common.bean.table.TableResponseTo;
import com.comparadorad.bet.comparer.web.client.gwt.common.ui.msg.NoDataMsg;
import com.comparadorad.bet.comparer.web.client.gwt.common.ui.msg.ServerErrorMsg;
import com.comparadorad.bet.comparer.web.client.gwt.common.ui.tables.AbstractTableRefreshService;
import com.comparadorad.bet.comparer.web.client.gwt.core.analytics.AnalyticsEventUtil;
import com.comparadorad.bet.comparer.web.client.gwt.core.ipc.IIpcEventUtil;
import com.comparadorad.bet.comparer.web.client.gwt.core.ipc.IpcEventFactory;
import com.comparadorad.bet.comparer.web.client.gwt.core.prop.AppProperties;
import com.comparadorad.bet.comparer.web.client.gwt.results.ui.Messages;
import com.comparadorad.bet.comparer.web.client.gwt.results.ui.util.ResultsDataLoading;
import com.comparadorad.bet.comparer.web.client.gwt.results.ui.util.ResultsViewHashState;
import com.comparadorad.bet.comparer.web.client.gwt.results.ui.view.table.TableWrapper;
import com.comparadorad.bet.comparer.web.client.gwt.results.ui.view.tabset.BetTypeEventTab;
import com.comparadorad.bet.comparer.web.client.gwt.results.ui.view.tabset.BetTypeEventsTabSet;
import com.comparadorad.bet.comparer.web.client.gwt.results.ui.view.tabset.BetTypeTab;
import com.comparadorad.bet.comparer.web.client.gwt.results.ui.view.tabset.BetTypeTabSet;
import com.comparadorad.bet.comparer.web.client.gwt.results.ui.view.tabset.HeadTab;
import com.comparadorad.bet.comparer.web.client.gwt.results.ui.view.tabset.HeadTabSet;
import com.comparadorad.bet.comparer.web.client.gwt.results.ui.view.tabset.ResultsTab;
import com.comparadorad.bet.comparer.web.client.gwt.results.ui.view.tabset.ResultsTabSet;
import com.comparadorad.bet.comparer.web.client.gwt.results.ui.view.tree.GenericTree;
import com.comparadorad.bet.comparer.web.client.gwt.results.ui.view.tree.GenericTreeGrid;
import com.comparadorad.bet.comparer.web.client.gwt.results.ui.view.tree.GenericTreeNode;
import com.comparadorad.bet.comparer.web.client.gwt.results.ui.view.tree.TreeNodeError;
import com.comparadorad.bet.comparer.web.client.gwt.results.ui.view.tree.TreeNodeTable;
import com.google.gwt.core.client.GWT;
import com.smartgwt.client.types.EmbeddedPosition;
import com.smartgwt.client.widgets.Canvas;
import com.smartgwt.client.widgets.layout.VLayout;
import com.smartgwt.client.widgets.tab.Tab;
import com.smartgwt.client.widgets.tab.events.TabDeselectedEvent;
import com.smartgwt.client.widgets.tab.events.TabDeselectedHandler;
import com.smartgwt.client.widgets.tab.events.TabSelectedEvent;
import com.smartgwt.client.widgets.tab.events.TabSelectedHandler;
import com.smartgwt.client.widgets.tree.TreeNode;
import com.smartgwt.client.widgets.tree.events.FolderClosedEvent;
import com.smartgwt.client.widgets.tree.events.FolderClosedHandler;
import com.smartgwt.client.widgets.tree.events.FolderOpenedEvent;
import com.smartgwt.client.widgets.tree.events.FolderOpenedHandler;

/**
 * The Class ResultsView.
 */
public class ResultsView extends VLayout {

	/** The Constant UNIQUE_TABLE_ID. */
	private static final String UNIQUE_TABLE_ID = "uniqueTableId";

	/** The Constant WIDTH. */
	private static final int WIDTH = 680;

	/** The bet type event tab deselected handler. */
	private TabDeselectedHandler betTypeEventTabDeselectedHandler = new TabDeselectedHandler() {
		@Override
		public void onTabDeselected(TabDeselectedEvent pEvent) {
			BetTypeEventTab tab = (BetTypeEventTab) pEvent.getTab();
			onBetTypeEventTabDeselected(tab);
		}
	};

	/** The bet type event tab selected handler. */
	private TabSelectedHandler betTypeEventTabSelectedHandler = new TabSelectedHandler() {
		@Override
		public void onTabSelected(TabSelectedEvent event) {
			Log.info("nativo betTypeEventTabSelected");
			BetTypeEventsTabSet tabSet = (BetTypeEventsTabSet) event.getTab()
					.getTabSet();
			BetTypeEventTab tab = (BetTypeEventTab) event.getTab();
			if (tabSet.isFollowNativeTabCall()) {
				if (((BetTypeEventTab) tabSet.getSelectedTab()) != tab) {
					Log.debug("El tab ya seleccionado no corresponde al tab del evento 'onBetTypeEventTabSelected' --> seleccionamos el tab correcto");
					tabSet.selectTab(tab);
				}
				boolean followNativeTabCall = true;
				if (tab.getPane() instanceof TableWrapper) {
					TableWrapper w = (TableWrapper) tab.getPane();
					if (!w.hasLoadedTables()) {
						followNativeTabCall = false;
					}
				}
				if (followNativeTabCall) {
					tabSet.setCleanHash(true);
					tabSet.setFollowNativeTabCall(true);
					googleAnalytics(new StringBuffer().append(tab.getTitle())
							.toString());
					onBetTypeEventTabSelected(tab);
				}
			}
		}
	};

	/** The events bet type tab deselected handler. */
	private TabDeselectedHandler betTypeTabDeselectedHandler = new TabDeselectedHandler() {
		@Override
		public void onTabDeselected(TabDeselectedEvent event) {
			onBetTypeTabDeselected((BetTypeTab) event.getTab());
		}
	};

	private TabSelectedHandler betTypeTabSelectedHandler = new TabSelectedHandler() {
		@Override
		public void onTabSelected(TabSelectedEvent event) {
			Log.info("nativo betTypeTabSelected");
			BetTypeTab tab = (BetTypeTab) event.getTab();
			BetTypeTabSet tabSet = (BetTypeTabSet) event.getTab().getTabSet();
			if (tabSet.isFollowNativeTabCall()) {
				if (tabSet.getSelectedTab() != tab) {
					Log.debug("El tab ya seleccionado no corresponde al tab del evento 'onBetTypeTabSelected' --> seleccionamos el tab correcto");
					tabSet.selectTab(tab);
				}
				tabSet.setCleanHash(true);
				tabSet.setFollowNativeTabCall(true);
				googleAnalytics(new StringBuffer().append(tab.getTitle())
						.toString());
				onBetTypeTabSelected(tab);
			}
		}
	};

	/** The data loading. */
	private ResultsDataLoading dataLoading = new ResultsDataLoading();

	/** The hash state. */
	private ResultsViewHashState hashState = new ResultsViewHashState();

	/** The head tab selected handler. */
	private TabSelectedHandler headTabSelectedHandler = new TabSelectedHandler() {
		@Override
		public void onTabSelected(TabSelectedEvent event) {
			Log.info("nativo headTabSelected");
			HeadTab tab = (HeadTab) event.getTab();
			HeadTabSet tabSet = (HeadTabSet) tab.getTabSet();
			if (tabSet.isCleanHash()) {
				Log.info("nativo headTabSelected");
				hashState
						.setHeadHash(tab.getIdWithoutPrefix(), tab.isFixHash());
			}
			tabSet.setCleanHash(true);
			googleAnalytics(new StringBuffer()
					.append(tab.getGoogleAnalyticsMsg()).append(tab.getTitle())
					.toString());
			onHeadTabSelected((HeadTab) event.getTab());
		}
	};

	/** The ipc event util. */
	private IIpcEventUtil ipcEventUtil = IpcEventFactory.getInstance()
			.createIpcEventUtil();

	/** The messages. */
	protected Messages messages = GWT.create(Messages.class);

	/** The view visible. */
	private boolean viewVisible = true;

	/**
	 * Instantiates a new results view.
	 */
	public ResultsView() {
		setWidth(WIDTH);
		setPadding(0);
		setAutoHeight();
	}

	/**
	 * Adds the table tree node.
	 * 
	 * @param tableWrapper
	 *            the table wrapper
	 * @param treeGrid
	 *            the tree grid
	 * @param tree
	 *            the tree
	 * @param tableTreeNode
	 *            the table tree node
	 * @param node
	 *            the node
	 */
	protected void addTableTreeNode(final TableWrapper tableWrapper,
			final GenericTreeGrid treeGrid, final GenericTree tree,
			final TreeNodeTable tableTreeNode, final GenericTreeNode node) {
		if (tree.findById(tableTreeNode.getTreeNodeId()) == null) {
			// Añadimos el tableWrapper al tableTreeNode cuando se hayan creado
			// las tablas para no tener problemas con el height
			Log.info("addTableTreeNode");
			tree.add(tableTreeNode, node);
			treeGrid.addEmbeddedComponent(tableWrapper, tableTreeNode, null,
					null, EmbeddedPosition.WITHIN);
		}
	}

	/**
	 * Gets the bet type event tab deselected handler.
	 * 
	 * @return the bet type event tab deselected handler
	 */
	public TabDeselectedHandler getBetTypeEventTabDeselectedHandler() {
		return betTypeEventTabDeselectedHandler;
	}

	/**
	 * Gets the bet type event tab selected handler.
	 * 
	 * @return the bet type event tab selected handler
	 */
	public TabSelectedHandler getBetTypeEventTabSelectedHandler() {
		return betTypeEventTabSelectedHandler;
	}

	/**
	 * Gets the bet type tab deselected handler.
	 * 
	 * @return the bet type tab deselected handler
	 */
	public TabDeselectedHandler getBetTypeTabDeselectedHandler() {
		return betTypeTabDeselectedHandler;
	}

	/**
	 * Gets the bet type tab selected handler.
	 * 
	 * @return the bet type tab selected handler
	 */
	public TabSelectedHandler getBetTypeTabSelectedHandler() {
		return betTypeTabSelectedHandler;
	}

	/**
	 * Gets the data loading.
	 * 
	 * @return the data loading
	 */
	public ResultsDataLoading getDataLoading() {
		return dataLoading;
	}

	/**
	 * Gets the folde closed handler.
	 * 
	 * @return the folde closed handler
	 */
	protected FolderClosedHandler getFoldeClosedHandler() {
		return new FolderClosedHandler() {
			@Override
			public void onFolderClosed(FolderClosedEvent event) {
				onFolderClosedDo(event);
			}
		};
	}

	/**
	 * Gets the folder opened handler.
	 * 
	 * @return the folder opened handler
	 */
	protected FolderOpenedHandler getFolderOpenedHandler() {
		return new FolderOpenedHandler() {
			@Override
			public void onFolderOpened(FolderOpenedEvent event) {
				onFolderOpenedDo(event);
			}
		};
	}

	/**
	 * Gets the hash state.
	 * 
	 * @return the hash state
	 */
	public ResultsViewHashState getHashState() {
		return hashState;
	}

	/**
	 * Gets the head tab selected handler.
	 * 
	 * @return the head tab selected handler
	 */
	public TabSelectedHandler getHeadTabSelectedHandler() {
		return headTabSelectedHandler;
	}

	/**
	 * Gets the ipc event util.
	 * 
	 * @return the ipc event util
	 */
	public IIpcEventUtil getIpcEventUtil() {
		return ipcEventUtil;
	}

	/**
	 * Google analytics.
	 * 
	 * @param msg
	 *            the msg
	 */
	protected void googleAnalytics(final String msg) {
		if (AppProperties.getInstance().isLiferayEnvironment()) {
			AnalyticsEventUtil analyticsEventUtil = new AnalyticsEventUtil();
			//analyticsEventUtil.trackAnalytics(msg);
		}
	}

	/**
	 * Checks if is view visible.
	 * 
	 * @return true, if is view visible
	 */
	public boolean isViewVisible() {
		return viewVisible;
	}

	/**
	 * On bet type event tab deselected.
	 * 
	 * @param tab
	 *            the tab
	 */
	protected void onBetTypeEventTabDeselected(final BetTypeEventTab tab) {
		Log.info("onBetTypeEventTabDeselected");
		if (tab.getPane() instanceof TableWrapper) {
			TableWrapper tableWrapper = (TableWrapper) tab.getPane();
			tableWrapper.stopTimer();
		} else {
			tab.setLoaded(false);
		}
	}

	/**
	 * On bet type event tab selected.
	 * 
	 * @param tab
	 *            the tab
	 */
	protected void onBetTypeEventTabSelected(final BetTypeEventTab tab) {
	}

	/**
	 * On bet type tab deselected.
	 * 
	 * @param tab
	 *            the tab
	 */
	protected void onBetTypeTabDeselected(final BetTypeTab tab) {
		Log.info("onBetTypeTabDeselected: betType = " + tab.getBetTypeId());
		TableWrapper tableWrapper = null;
		if (tab.getPane() instanceof TableWrapper) {
			tableWrapper = (TableWrapper) tab.getPane();
			tableWrapper.stopTimer();
		} else if (tab.getPane() instanceof BetTypeEventsTabSet) {
			BetTypeEventsTabSet betTypeEventsTabSet = (BetTypeEventsTabSet) tab
					.getPane();
			if (betTypeEventsTabSet.getSelectedTab() != null
					&& betTypeEventsTabSet.getSelectedTab().getPane() instanceof TableWrapper) {
				tableWrapper = (TableWrapper) betTypeEventsTabSet
						.getSelectedTab().getPane();
			}
			if (tableWrapper != null) {
				tableWrapper.stopTimer();
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
	}

	/**
	 * On folder closed do.
	 * 
	 * @param event
	 *            the event
	 */
	protected void onFolderClosedDo(final FolderClosedEvent event) {
	}

	/**
	 * On folder opened do.
	 * 
	 * @param event
	 *            the event
	 */
	protected void onFolderOpenedDo(final FolderOpenedEvent event) {
	}

	/**
	 * On head tab selected.
	 * 
	 * @param tab
	 *            the tab
	 */
	protected void onHeadTabSelected(final HeadTab tab) {
	}

	/**
	 * Response contains data.
	 * 
	 * @param pResponse
	 *            the response
	 * @return true, if successful
	 */
	protected boolean responseContainsData(final List<TableResponseTo> pResponse) {
		if (pResponse != null && pResponse.size() > 0
				&& pResponse.get(0).getRows() != null
				&& pResponse.get(0).getRows().size() > 0) {
			return true;
		} else {
			Log.debug("No existen betOdds para esta vista");
			return false;
		}
	}

	/**
	 * Response contains data.
	 * 
	 * @param pResponse
	 *            the response
	 * @return true, if successful
	 */
	protected boolean responseContainsData(final TableResponseTo pResponse) {
		if (pResponse != null && pResponse.getRows() != null
				&& pResponse.getRows().size() > 0) {
			return true;
		} else {
			Log.debug("No existen betOdds para esta vista");
			return false;
		}
	}

	/**
	 * Response contains data.
	 * 
	 * @param pResponse
	 *            the response
	 * @return true, if successful
	 */
	protected boolean responseContainsData(final TabResponseTo pResponse) {
		if (pResponse != null && pResponse.getTabs() != null
				&& pResponse.getTabs().size() > 0) {
			return true;
		} else {
			Log.debug("No existen bet types para esta vista");
			return false;
		}
	}

	/**
	 * Select inicial tab.
	 * 
	 * @param pTabSet
	 *            the tab set
	 * @param pInicialTabId
	 *            the inicial tab id
	 * @return the int
	 */
	protected int selectInicialTab(final ResultsTabSet pTabSet,
			final String pInicialTabId) {
		Log.debug("selectInicialTab tabId = " + pInicialTabId);
		int tabIndex = 0;
		if (pInicialTabId != null && !pTabSet.isInicialTabSelected()) {
			tabIndex = pTabSet.selectInicialTab(pInicialTabId);
		}
		Log.debug("inicial tabIndex a seleccionar = " + tabIndex);
		pTabSet.setInicialTabSelected(true);
		return tabIndex;
	}

	/**
	 * Server call failure for bet odds.
	 * 
	 * @param pMethod
	 *            the method
	 * @param pException
	 *            the exception
	 * @param refreshService
	 *            the refresh service
	 */
	protected void serverCallFailureForBetOdds(Method pMethod,
			Throwable pException, AbstractTableRefreshService refreshService) {
		Log.error("serverCallFailureForBetOdds");
		refreshService.stopRefreshTimer();
		dataLoading.hideLoadingIcon();
	}

	/**
	 * Server call failure for head data.
	 * 
	 * @param msg
	 *            the msg
	 */
	protected void serverCallFailureForHeadData(String msg) {
		Log.error("Error interno al llamar getHead()");
		if (hashState.isViewResponsibleOfFixatingTheHash()) {
			// Si la vista deberia haber fijado el hash, tenemos que hacerlo
			// explicitamente ahora ya que con el fallo del head no la ha hecho.
			hashState.fixateHashDirectly();
		}
		ServerErrorMsg errorMsg = new ServerErrorMsg(WIDTH, WIDTH, msg, true);
		Canvas[] members = getMembers();
		for (Canvas member : members) {
			member.hide();
		}
		Canvas[] children = getChildren();
		for (Canvas child : children) {
			child.hide();
		}
		addMember(errorMsg);
	}

	/**
	 * Head tab server call failure.
	 * 
	 * @param headTab
	 *            the head tab
	 * @param fixateHashOnError
	 *            the fixate hash on error
	 */
	protected void serverCallFailureForTabData(ResultsTab headTab,
			boolean fixateHashOnError) {
		Log.error("serverCallFailureForTabData");
		dataLoading.hideLoadingIcon();
		if (hashState.isViewResponsibleOfFixatingTheHash() && fixateHashOnError) {
			// Si la vista deberia haber fijado el hash, tenemos que hacerlo
			// explicitamente ahora ya que con el fallo del head no la ha hecho.
			hashState.fixateHashDirectly();
		}
		ServerErrorMsg errorMsg = new ServerErrorMsg(WIDTH, WIDTH,
				messages.eventoNoDisponibleTemporalmente(), true);
		headTab.setPane(errorMsg);
	}

	/**
	 * Server call failure for tree node.
	 * 
	 * @param node
	 *            the node
	 * @param tree
	 *            the tree
	 */
	protected void serverCallFailureForTreeNode(final GenericTreeNode node,
			final GenericTree tree) {
		dataLoading.hideLoadingIcon();
		TreeNodeError[] treeNodes = new TreeNodeError[1];
		final TreeNodeError errorTreeNode = new TreeNodeError(
				new StringBuffer().append("error").append(node.getTreeNodeId())
						.toString(), node.getTreeNodeId());
		treeNodes[0] = errorTreeNode;
		tree.linkNodes(treeNodes);
	}

	/**
	 * Server call success for bet odds.
	 * 
	 * @param pResponse
	 *            the response
	 * @param tableWrapper
	 *            the table wrapper
	 * @param refreshService
	 *            the refresh service
	 */
	protected void serverCallSuccessForBetOdds(
			final List<TableResponseTo> pResponse,
			final TableWrapper tableWrapper,
			final AbstractTableRefreshService refreshService) {
		if (refreshService != null) {
			if (responseContainsData(pResponse)) {
				if (!tableWrapper.hasLoadedTables()) {
					tableWrapper.createTable(pResponse);
				} else {
					tableWrapper.addAndDeleteTables(pResponse);
					refreshService.refreshTable(pResponse);
				}
			}
			dataLoading.hideLoadingIcon();
		} else {
			Log.warn("refreshService null");
		}
	}

	/**
	 * Server call success for bet odds.
	 * 
	 * @param pResponse
	 *            the response
	 * @param tableWrapper
	 *            the table wrapper
	 * @param refreshService
	 *            the refresh service
	 */
	protected void serverCallSuccessForBetOdds(TableResponseTo pResponse,
			TableWrapper tableWrapper,
			AbstractTableRefreshService refreshService) {
		Log.debug("betOddsServerCallSuccess");
		if (refreshService != null) {
			if (responseContainsData(pResponse)) {
				pResponse.setObjectToId(new ObjectToId(UNIQUE_TABLE_ID));
				if (!tableWrapper.hasLoadedTables()) {
					tableWrapper.createTable(pResponse, null);
				} else {
					refreshService.refreshTable(pResponse);
				}
			}
			dataLoading.hideLoadingIcon();
		} else {
			Log.warn("refreshService null");
		}
	}

	/**
	 * Server call success for bet types.
	 * 
	 * @param tabSet
	 *            the tab set
	 * @param pResponse
	 *            the response
	 * @param pInicialBetTypeTab
	 *            the inicial bet type tab
	 * @param fixHash
	 *            the fix hash
	 */
	protected void serverCallSuccessForBetTypes(final BetTypeTabSet tabSet,
			final TabResponseTo pResponse, final String pInicialBetTypeTab,
			final boolean fixHash) {
		tabSet.loadTabsWithBetTypeId(pResponse, tabSet.getID());
		int inicialTabIndex = selectInicialTab(tabSet, pInicialBetTypeTab);
		onBetTypeTabSelected((BetTypeTab) tabSet.getTab(inicialTabIndex));
		tabSet.selectTab(inicialTabIndex);
	}

	/**
	 * Load head.
	 * 
	 * @param head
	 *            the head
	 * @param pResponse
	 *            the response
	 * @param headTabSet
	 *            the head tab set
	 * @param fixHash
	 *            the fix hash
	 */
	protected void serverCallSuccessForHeadData(final Head head,
			final HeadResponseTo pResponse, final HeadTabSet headTabSet,
			boolean fixHash) {

		Log.debug("loadHead");
		head.setTitle(pResponse.getTitle());
		if (pResponse.getResourceTo() != null
				&& pResponse.getResourceTo().getLocation() != null) {
			head.setTitleImg(pResponse.getResourceTo().getLocation(), false);
		}
		head.setBreadcrumbs(pResponse.getLinkTos());
		if (pResponse.getDate() != null) {
			head.setDate(pResponse.getDate());
		}
		addMember(head);

		Log.debug("loadHeadTab");
		int headTabIndex = headTabSet.selectInicialTab(hashState
				.getInicialHeadTab());
		hashState.setHeadHash(Integer.toString(headTabIndex), fixHash);
		headTabSet.setInicialTabSelected(true);
		addMember(headTabSet);

	}

	/**
	 * Sets the data loading.
	 * 
	 * @param pDataLoading
	 *            the new data loading
	 */
	public void setDataLoading(ResultsDataLoading pDataLoading) {
		dataLoading = pDataLoading;
	}

	/**
	 * Sets the hash state.
	 * 
	 * @param pHashState
	 *            the new hash state
	 */
	public void setHashState(ResultsViewHashState pHashState) {
		hashState = pHashState;
	}

	/**
	 * Sets the ipc event util.
	 * 
	 * @param pIpcEventUtil
	 *            the new ipc event util
	 */
	public void setIpcEventUtil(IIpcEventUtil pIpcEventUtil) {
		ipcEventUtil = pIpcEventUtil;
	}

	/**
	 * Sets the view visible.
	 * 
	 * @param pViewVisible
	 *            the new view visible
	 */
	public void setViewVisible(boolean pViewVisible) {
		viewVisible = pViewVisible;
	}

	/**
	 * Show no data message.
	 * 
	 * @param tab
	 *            the tab
	 * @param msg
	 *            the msg
	 */
	protected void showNoDataMessage(Tab tab, String msg) {
		NoDataMsg noDataMsg = new NoDataMsg(msg);
		tab.setPane(noDataMsg);
	}

	/**
	 * Start timer on child node.
	 * 
	 * @param nodeList
	 *            the node list
	 */
	protected void startTimerOnChildNode(final TreeNode[] nodeList) {
		for (TreeNode n : nodeList) {
			GenericTreeNode gn = (GenericTreeNode) n;
			TableWrapper tableWrapper = null;
			if (gn.getAttributeAsObject("tableWrapper") instanceof TableWrapper) {
				tableWrapper = (TableWrapper) gn
						.getAttributeAsObject("tableWrapper");
			}
			if (tableWrapper != null && tableWrapper.isVisible()) {
				tableWrapper.startTimer();
			}
		}
	}

	/**
	 * Stop timer.
	 */
	public void stopTimer() {
		Log.info("se cierra view de Results");
		setViewVisible(false);
		dataLoading.hideLoadingIcon();
	}

	/**
	 * Stop timer on child node.
	 * 
	 * @param nodeList
	 *            the node list
	 */
	protected void stopTimerOnChildNode(final TreeNode[] nodeList) {
		for (TreeNode n : nodeList) {
			GenericTreeNode gn = (GenericTreeNode) n;
			TableWrapper tableWrapper = null;
			if (gn.getAttributeAsObject("tableWrapper") instanceof TableWrapper) {
				tableWrapper = (TableWrapper) gn
						.getAttributeAsObject("tableWrapper");
			}
			if (tableWrapper != null) {
				tableWrapper.stopTimer();
			}
		}
	}

}
