/**
 *
 * Copyright (C) FACTORIA ETSIA S.L.
 * All Rights Reserved.
 * www.factoriaetsia.com
 *
 */
package com.comparadorad.bet.comparer.web.client.gwt.livebet.ui.view;

import java.util.List;

import org.fusesource.restygwt.client.Method;

import com.allen_sauer.gwt.log.client.Log;
import com.comparadorad.bet.comparer.web.client.gwt.common.bean.table.TableResponseTo;
import com.comparadorad.bet.comparer.web.client.gwt.common.ui.msg.ServerErrorMsg;
import com.comparadorad.bet.comparer.web.client.gwt.common.ui.tables.AbstractTableRefreshService;
import com.comparadorad.bet.comparer.web.client.gwt.core.data.AbstractServiceMethodCallback;
import com.comparadorad.bet.comparer.web.client.gwt.core.service.ServiceFactory;
import com.comparadorad.bet.comparer.web.client.gwt.livebet.bean.request.LiveBetRequestTo;
import com.comparadorad.bet.comparer.web.client.gwt.livebet.ui.dummy.LiveBetDummyService;
import com.comparadorad.bet.comparer.web.client.gwt.livebet.ui.service.ILiveBetService;
import com.comparadorad.bet.comparer.web.client.gwt.livebet.ui.service.LiveBetService;
import com.google.gwt.core.client.GWT;

/**
 * The Class LiveBet.
 */
public class LiveBet extends LiveBetTableWrapper {

	/** The Constant request. */
	private static final LiveBetRequestTo request = new LiveBetRequestTo();

	/** The visible for update. */
	private boolean visibleForUpdate = true;

	/**
	 * Instantiates a new live bet.
	 */
	public LiveBet() {
		super();
		getTableData();
	}

	/**
	 * Gets the live bet service.
	 * 
	 * @return the live bet service
	 */
	protected ILiveBetService getLiveBetService() {
		ILiveBetService service = (ILiveBetService) ServiceFactory
				.getInstance().getService(GWT.create(LiveBetService.class),
						GWT.create(LiveBetDummyService.class));
		return service;
	}

	/**
	 * Gets the table data.
	 * 
	 * @return the table data
	 */
	private void getTableData() {
		final ILiveBetService liveBetService = getLiveBetService();
		setTableRefreshService(new AbstractTableRefreshService() {
			@Override
			public void callServerToObtainTableData() {

				if (visibleForUpdate) {
					Log.debug("---------------------------------");
					Log.debug("Hago peticion al servidor LIVEBET");
					Log.debug("---------------------------------");
					liveBetService
							.getLiveBet(
									request,
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
													liveBetService.getLiveBet(
															request, this);
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
												List<TableResponseTo> pResponse) {
											Log.debug("---------------------------------");
											Log.debug("Recibo respuestas de servidor LIVEBET");
											Log.debug("---------------------------------");
											if (pResponse != null
													&& pResponse.size() > 0
													&& pResponse.get(0)
															.getRows() != null
													&& pResponse.get(0)
															.getRows().size() > 0) {
												if (!hasLoadedTables()) {
													createTable(pResponse);
												} else {
													addAndDeleteTables(pResponse);
													refreshTable(pResponse);
												}
											}
											Log.debug("---------------------------------");
											Log.debug("Se ha pintado la tabla LIVEBET");
											Log.debug("---------------------------------");
										}
									});

				} else {
					stopRefreshTimer();
				}

			}
		});
		getTableRefreshService().callServerToObtainTableData();
	}

}
