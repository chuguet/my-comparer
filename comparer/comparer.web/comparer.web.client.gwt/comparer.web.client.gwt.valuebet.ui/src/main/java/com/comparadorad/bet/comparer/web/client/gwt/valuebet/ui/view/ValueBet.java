/**
 *
 * Copyright (C) FACTORIA ETSIA S.L.
 * All Rights Reserved.
 * www.factoriaetsia.com
 *
 */
package com.comparadorad.bet.comparer.web.client.gwt.valuebet.ui.view;

import org.fusesource.restygwt.client.Method;

import com.allen_sauer.gwt.log.client.Log;
import com.comparadorad.bet.comparer.web.client.gwt.common.bean.ObjectToId;
import com.comparadorad.bet.comparer.web.client.gwt.common.ui.msg.ServerErrorMsg;
import com.comparadorad.bet.comparer.web.client.gwt.common.ui.tables.AbstractTableRefreshService;
import com.comparadorad.bet.comparer.web.client.gwt.common.ui.tables.Pagination;
import com.comparadorad.bet.comparer.web.client.gwt.core.data.AbstractServiceMethodCallback;
import com.comparadorad.bet.comparer.web.client.gwt.core.ipc.HashNames;
import com.comparadorad.bet.comparer.web.client.gwt.core.ipc.IIpcEventUtil;
import com.comparadorad.bet.comparer.web.client.gwt.core.ipc.IpcEventFactory;
import com.comparadorad.bet.comparer.web.client.gwt.core.service.ServiceFactory;
import com.comparadorad.bet.comparer.web.client.gwt.valuebet.bean.request.ValueBetRequestTo;
import com.comparadorad.bet.comparer.web.client.gwt.valuebet.bean.response.ValueBetResponseTo;
import com.comparadorad.bet.comparer.web.client.gwt.valuebet.ui.Messages;
import com.comparadorad.bet.comparer.web.client.gwt.valuebet.ui.dummy.ValueBetDummyService;
import com.comparadorad.bet.comparer.web.client.gwt.valuebet.ui.service.IValueBetService;
import com.comparadorad.bet.comparer.web.client.gwt.valuebet.ui.service.ValueBetService;
import com.google.gwt.core.client.GWT;
import com.smartgwt.client.types.Alignment;
import com.smartgwt.client.widgets.events.ClickEvent;
import com.smartgwt.client.widgets.events.ClickHandler;

/**
 * The Class ValueBet.
 */
public class ValueBet extends ValueBetTableWrapper {

	/** The messages. */
	protected static Messages messages = GWT.create(Messages.class);

	/** The inicial page num. */
	private long inicialPageNum;

	/** The pagination. */
	private Pagination pagination;

	/** The value bet request to. */
	private ValueBetRequestTo valueBetRequestTo = new ValueBetRequestTo();

	/** The view visible for refresh. */
	private boolean viewVisibleForRefresh = true;

	/**
	 * Instantiates a new value bet.
	 */
	public ValueBet() {
		super();
		initValueBet();
	}

	/**
	 * Instantiates a new value bet.
	 * 
	 * @param pInicialPageNum
	 *            the inicial page num
	 */
	public ValueBet(long pInicialPageNum) {
		super();
		// Restamos 1 porque en Paginacion y en la parte del servidor el número
		// de página empieza con 0, 1, 2,... pero en los urls queremos mostrar
		// el número de página apartir de 1, 2, 3, ... Así que el número que no
		// llega en el constructor es él de la url y es una unidad mayor.
		this.inicialPageNum = pInicialPageNum - 1;
		initValueBet();
	}

	/**
	 * Gets the live bet service.
	 * 
	 * @return the live bet service
	 */
	protected IValueBetService getLiveBetService() {
		IValueBetService service = (IValueBetService) ServiceFactory
				.getInstance().getService(GWT.create(ValueBetService.class),
						GWT.create(ValueBetDummyService.class));
		return service;
	}

	/**
	 * Gets the table data.
	 * 
	 * @return the table data
	 */
	private void getTableData() {
		final IValueBetService liveBetService = getLiveBetService();
		setTableRefreshService(new AbstractTableRefreshService() {
			@Override
			public void callServerToObtainTableData() {
				if (viewVisibleForRefresh) {
					valueBetRequestTo.setPageNum(pagination.getPageNum());
					Log.debug("pageNum in request = "
							+ (pagination.getPageNum()));
					liveBetService
							.getValueBet(
									valueBetRequestTo,
									new AbstractServiceMethodCallback<ValueBetResponseTo>() {
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
													liveBetService.getValueBet(
															valueBetRequestTo,
															this);
												} else {
													Log.info("Superado numero maximo de peticiones");
													this.resetCounterRequest();
													stopRefreshTimer();
													ServerErrorMsg errorMsg = new ServerErrorMsg();
													setMembers(errorMsg);
												}
											} else {
												Log.info("Error sin microcorte");
												this.resetCounterRequest();
												stopRefreshTimer();
												ServerErrorMsg errorMsg = new ServerErrorMsg();
												setMembers(errorMsg);
											}
										}

										@Override
										public void onSuccessActions(
												Method pMethod,
												ValueBetResponseTo pResponse) {
											if (responseHasData(pResponse)) {
												pagination
														.setNumRecords(pResponse
																.getCount());
												pResponse
														.getTableResponseTo()
														.setObjectToId(
																new ObjectToId(
																		"UNIQUE"));
												if (pResponse.isNoPaymentUser()) {
													pagination
															.blockAccessToNextPages();
												}
												if (!hasLoadedTables()) {
													createTable(pResponse
															.getTableResponseTo());
													addMember(pagination);
												} else {
													refreshTable(pResponse
															.getTableResponseTo());
												}
											}
										}
									});
				} else {
					stopRefreshTimer();
				}

			}
		});
		getTableRefreshService().callServerToObtainTableData();
	}

	/**
	 * Inits the value bet.
	 */
	private void initValueBet() {
		setAlign(Alignment.CENTER);
		setLayoutAlign(Alignment.CENTER);
		pagination = new Pagination(new StringBuffer()
				.append(messages.numTotalDeValueBets()).append(" ").toString(),
				messages.tooltip(), inicialPageNum);
		pagination.addClickHandler(new ClickHandler() {
			@Override
			public void onClick(ClickEvent pEvent) {
				Log.info("setHashName PAGE: " + (pagination.getPageNum() + 1));
				IIpcEventUtil ipcEventUtil = IpcEventFactory.getInstance()
						.createIpcEventUtil();
				ipcEventUtil.replaceHashParam(HashNames.PAGE,
						Long.toString(pagination.getPageNum() + 1));
				getTableRefreshService().callServerToObtainTableData();
			}
		});
		getTableData();
	}

	/**
	 * Checks if is view visible for refresh.
	 * 
	 * @return true, if is view visible for refresh
	 */
	public boolean isViewVisibleForRefresh() {
		return viewVisibleForRefresh;
	}

	/**
	 * Response has data.
	 * 
	 * @param pResponse
	 *            the response
	 * @return true, if successful
	 */
	private boolean responseHasData(ValueBetResponseTo pResponse) {
		return pResponse != null && pResponse.getTableResponseTo() != null
				&& pResponse.getTableResponseTo().getRows() != null;
	}

	/**
	 * Sets the view visible for refresh.
	 * 
	 * @param pViewVisibleForRefresh
	 *            the new view visible for refresh
	 */
	public void setViewVisibleForRefresh(boolean pViewVisibleForRefresh) {
		viewVisibleForRefresh = pViewVisibleForRefresh;
	}

}
