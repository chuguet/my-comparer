/**
 *
 * Copyright (C) FACTORIA ETSIA S.L.
 * All Rights Reserved.
 * www.factoriaetsia.com
 *
 */
package com.comparadorad.bet.comparer.web.client.gwt.securebet.ui.view;

import org.fusesource.restygwt.client.Method;

import com.allen_sauer.gwt.log.client.Log;
import com.comparadorad.bet.comparer.web.client.gwt.common.bean.ObjectToId;
import com.comparadorad.bet.comparer.web.client.gwt.common.ui.msg.NoDataMsg;
import com.comparadorad.bet.comparer.web.client.gwt.common.ui.msg.ServerErrorMsg;
import com.comparadorad.bet.comparer.web.client.gwt.common.ui.tables.AbstractTableRefreshService;
import com.comparadorad.bet.comparer.web.client.gwt.common.ui.tables.Pagination;
import com.comparadorad.bet.comparer.web.client.gwt.core.data.AbstractServiceMethodCallback;
import com.comparadorad.bet.comparer.web.client.gwt.core.ipc.HashNames;
import com.comparadorad.bet.comparer.web.client.gwt.core.ipc.IIpcEventUtil;
import com.comparadorad.bet.comparer.web.client.gwt.core.ipc.IpcEventFactory;
import com.comparadorad.bet.comparer.web.client.gwt.core.service.ServiceFactory;
import com.comparadorad.bet.comparer.web.client.gwt.securebet.bean.request.SureBetRequestTo;
import com.comparadorad.bet.comparer.web.client.gwt.securebet.bean.response.SureBetResponseTo;
import com.comparadorad.bet.comparer.web.client.gwt.securebet.ui.Messages;
import com.comparadorad.bet.comparer.web.client.gwt.securebet.ui.dummy.SecureBetDummyService;
import com.comparadorad.bet.comparer.web.client.gwt.securebet.ui.service.ISecureBetService;
import com.comparadorad.bet.comparer.web.client.gwt.securebet.ui.service.SecureBetService;
import com.google.gwt.core.client.GWT;
import com.smartgwt.client.widgets.events.ClickEvent;
import com.smartgwt.client.widgets.events.ClickHandler;

/**
 * The Class SecureBet.
 */
public class SecureBet extends SecureBetTableWrapper {

	/** The messages. */
	protected static Messages messages = GWT.create(Messages.class);

	/** The inicial page num. */
	private long inicialPageNum;

	/** The pagination. */
	private Pagination pagination;

	/** The secure bet request to. */
	private SureBetRequestTo sureBetRequestTo = new SureBetRequestTo();

	/** The visible for update. */
	private boolean visibleForUpdate = true;

	/**
	 * Instantiates a new secure bet.
	 */
	public SecureBet() {
		super();
		initSecureBetWithPagination();
	}

	/**
	 * Instantiates a new secure bet.
	 * 
	 * @param pInicialPageNum
	 *            the inicial page num
	 */
	public SecureBet(long pInicialPageNum) {
		super();
		// Restamos 1 porque en Paginacion y en la parte del servidor el número
		// de página empieza con 0, 1, 2,... pero en los urls queremos mostrar
		// el número de página apartir de 1, 2, 3, ... Así que el número que no
		// llega en el constructor es él de la url y es una unidad mayor.
		this.inicialPageNum = pInicialPageNum - 1;
		initSecureBetWithPagination();
	}

	/**
	 * Instantiates a new secure bet.
	 * 
	 * @param id
	 *            the id
	 */
	public SecureBet(ObjectToId id) {
		super();
		sureBetRequestTo.setSureBetId(id);
		getTableDataOneSureBet();
	}

	/**
	 * Gets the secure bet service.
	 * 
	 * @return the secure bet service
	 */
	protected ISecureBetService getSecureBetService() {
		ISecureBetService service = (ISecureBetService) ServiceFactory
				.getInstance().getService(GWT.create(SecureBetService.class),
						GWT.create(SecureBetDummyService.class));
		return service;
	}

	/**
	 * Gets the table data one sure bet.
	 * 
	 * @return the table data one sure bet
	 */
	private void getTableDataOneSureBet() {
		Log.info("getTableDataShowOneSureBet");
		final ISecureBetService service = getSecureBetService();
		setTableRefreshService(new AbstractTableRefreshService() {
			@Override
			public void callServerToObtainTableData() {
				if (visibleForUpdate) {
					Log.debug("sureBetId in request = "
							+ (sureBetRequestTo.getSureBetId().getId()));
					service.getOneSureBet(
							sureBetRequestTo,
							new AbstractServiceMethodCallback<SureBetResponseTo>() {
								@Override
								protected void onFailureActions(Method pMethod,
										Throwable pException) {
									if (pMethod.getResponse().getStatusCode() == 404) {
										Log.info("Se produce un microcorte numero de peticion "
												+ this.getCounterRequest());
										if (this.getCounterRequest() < this
												.getMaxRequest()) {
											this.incCounterRequest();
											service.getOneSureBet(
													sureBetRequestTo, this);
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
								public void onSuccessActions(Method pMethod,
										SureBetResponseTo pResponse) {
									if (responseHasData(pResponse)) {
										pResponse
												.getTableResponseTo()
												.setObjectToId(
														new ObjectToId("UNIQUE"));
										if (!hasLoadedTables()) {
											createTable(pResponse
													.getTableResponseTo());
										} else {
											refreshTable(pResponse
													.getTableResponseTo());
										}
									} else {
										NoDataMsg noDataMsg = new NoDataMsg(
												messages.laApuestaSeguraNoExiste());
										addMember(noDataMsg);
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
	 * Gets the table data with pagination.
	 * 
	 * @return the table data with pagination
	 */
	private void getTableDataWithPagination() {
		Log.info("getTableDataWithPagination");
		final ISecureBetService service = getSecureBetService();
		setTableRefreshService(new AbstractTableRefreshService() {
			@Override
			public void callServerToObtainTableData() {
				if (visibleForUpdate) {
					sureBetRequestTo.setPageNum(pagination.getPageNum());
					Log.debug("pageNum in request = "
							+ (pagination.getPageNum()));
					service.getAllSureBet(
							sureBetRequestTo,
							new AbstractServiceMethodCallback<SureBetResponseTo>() {
								@Override
								protected void onFailureActions(Method pMethod,
										Throwable pException) {

									if (pMethod.getResponse().getStatusCode() == 404) {
										Log.info("Se produce un microcorte numero de peticion "
												+ this.getCounterRequest());
										if (this.getCounterRequest() < this
												.getMaxRequest()) {
											this.incCounterRequest();
											service.getAllSureBet(
													sureBetRequestTo, this);
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
								public void onSuccessActions(Method pMethod,
										SureBetResponseTo pResponse) {
									if (responseHasData(pResponse)) {
										pagination.setNumRecords(pResponse
												.getCount());
										pResponse
												.getTableResponseTo()
												.setObjectToId(
														new ObjectToId("UNIQUE"));
										if (pResponse.isNoPaymentUser()) {
											pagination.blockAccessToNextPages();
										}
										if (!hasLoadedTables()) {
											createTable(pResponse
													.getTableResponseTo());
											addMember(pagination);
										} else {
											refreshTable(pResponse
													.getTableResponseTo());
										}
									} else {
										NoDataMsg noDataMsg = new NoDataMsg(
												messages.noHayNingunaApuestaSegura());
										addMember(noDataMsg);
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
	 * Inits the secure bet.
	 */
	private void initSecureBetWithPagination() {
		pagination = new Pagination(
				new StringBuffer().append(messages.numTotalDeSecureBets())
						.append(" ").toString(), messages.tooltip(),
				inicialPageNum);
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
		getTableDataWithPagination();
	}

	/**
	 * Response has data.
	 * 
	 * @param pResponse
	 *            the response
	 * @return true, if successful
	 */
	private boolean responseHasData(SureBetResponseTo pResponse) {
		return pResponse != null && pResponse.getTableResponseTo() != null
				&& pResponse.getTableResponseTo().getRows() != null;
	}

}
