/**
 *
 * Copyright (C) FACTORIA ETSIA S.L.
 * All Rights Reserved.
 * www.factoriaetsia.com
 *
 */
package com.comparadorad.bet.comparer.web.server.portlet.securebet.client;

import com.allen_sauer.gwt.log.client.Log;
import com.comparadorad.bet.comparer.web.client.gwt.common.bean.ObjectToId;
import com.comparadorad.bet.comparer.web.client.gwt.core.ipc.HashNames;
import com.comparadorad.bet.comparer.web.client.gwt.core.ipc.IIpcEvent;
import com.comparadorad.bet.comparer.web.client.gwt.core.ipc.IIpcEventUtil;
import com.comparadorad.bet.comparer.web.client.gwt.core.ipc.InternalLinkEventNames;
import com.comparadorad.bet.comparer.web.client.gwt.core.ipc.IpcEventFactory;
import com.comparadorad.bet.comparer.web.client.gwt.core.module.AbstractModule;
import com.comparadorad.bet.comparer.web.client.gwt.core.module.IExpireSession;
import com.comparadorad.bet.comparer.web.client.gwt.securebet.ui.view.SecureBet;

/**
 * The Class SecureBetModule.
 */
public class SecureBetModule extends AbstractModule implements IExpireSession {

	/**
	 * The Class ExpireSessionEvent.
	 */
	private class ExpireSessionEvent implements IIpcEvent {

		/** {@inheritDoc} */
		@Override
		public void change(String objectId, String pObjectIdSec, String name) {
			onExpireSession();

		}
	}

	/**
	 * The Class SeachIpcSureBetMatchEvent.
	 */
	private class SeachIpcSureBetMatchEvent implements IIpcEvent {

		/**
		 * Change.
		 * 
		 * @param objectId
		 *            the object id
		 * @param pObjectIdSec
		 *            the object id sec
		 * @param name
		 *            the name {@inheritDoc}
		 */
		@Override
		public void change(String objectId, String pObjectIdSec, String name) {
			Log.debug("Competicion seleccionada: " + objectId);
			resetSureBet();
		}
	}

	/**
	 * The Class SearchIpcResultsMainEvent.
	 */
	private class SearchIpcResultsMainEvent implements IIpcEvent {

		/**
		 * Change.
		 * 
		 * @param objectId
		 *            the object id
		 * @param pObjectIdSec
		 *            the object id sec
		 * @param name
		 *            the name {@inheritDoc}
		 */
		@Override
		public void change(String objectId, String pObjectIdSec, String name) {
			resetSureBet();
			securebet = new SecureBet();
			getMainContainerRootPanel().add(securebet);
		}
	}

	/**
	 * The Class SearchIpcToolbarCompetitionEvent.
	 */
	private class SearchIpcToolbarCompetitionEvent implements IIpcEvent {

		/**
		 * Change.
		 * 
		 * @param objectId
		 *            the object id
		 * @param pObjectIdSec
		 *            the object id sec
		 * @param name
		 *            the name {@inheritDoc}
		 */
		@Override
		public void change(String objectId, String pObjectIdSec, String name) {
			Log.debug("Competicion seleccionada: " + objectId);
			resetSureBet();
		}
	}

	/** The Constant SECUREBET_MODULE_CONTAINER. */
	private static final String SECUREBET_MODULE_CONTAINER = "secureBetModuleContainer";

	/** The live bet. */
	private SecureBet securebet;

	/**
	 * Gets the app path.
	 * 
	 * @return the app path {@inheritDoc}
	 */
	@Override
	protected String getAppPath() {

		return "com.comparadorad.bet.comparer.web.server.portlet.securebet";
	}

	/**
	 * Gets the main container id.
	 * 
	 * @return the main container id {@inheritDoc}
	 */
	@Override
	protected String getMainContainerId() {
		return SECUREBET_MODULE_CONTAINER;
	}

	/**
	 * Gets the sport country competition.
	 * 
	 * @return the sport country competition
	 */
	protected SecureBet getSecureBet() {
		return securebet;
	}

	/**
	 * Hash process.
	 * 
	 * @param ipcEventUtil
	 *            the ipc event util
	 */
	private void hashProcess(IIpcEventUtil ipcEventUtil) {
		Log.debug("hashProcess");
		String page = ipcEventUtil.getHashParam(HashNames.PAGE);
		String sureBetId = ipcEventUtil.getHashParam(HashNames.SURE_BET_ID);
		Log.debug("page = " + page);
		Log.debug("sureBetId = " + sureBetId);
		if (!sureBetId.equals(HashNames.CLEAN)) {
			securebet = new SecureBet(new ObjectToId(sureBetId));
			getMainContainerRootPanel().add(securebet);
		} else if (!page.equals(HashNames.CLEAN)) {
			securebet = new SecureBet(Long.parseLong(page));
			getMainContainerRootPanel().add(securebet);
		} else {
			securebet = new SecureBet();
			getMainContainerRootPanel().add(securebet);
		}
	}

	/** {@inheritDoc} */
	@Override
	public void onExpireSession() {
		if (securebet != null) {
			securebet.stopTimer();
		}

	}

	/**
	 * This is the entry point method.
	 */
	@Override
	public void onModuleLoadActions() {
		IIpcEventUtil ipcEventUtil = IpcEventFactory.getInstance()
				.createIpcEventUtil();
		ipcEventUtil
				.listen(new SearchIpcToolbarCompetitionEvent(),
						InternalLinkEventNames.TOOLBAR_COMPETITION_EVENT
								.getEventName());
		ipcEventUtil.listen(new SearchIpcResultsMainEvent(),
				InternalLinkEventNames.RESULTS_MAIN_EVENT.getEventName());
		ipcEventUtil.listen(new SeachIpcSureBetMatchEvent(),
				InternalLinkEventNames.SURE_BET_MATCH_EVENT.getEventName());
		ipcEventUtil.listen(new ExpireSessionEvent(), "expireSessionEvent");

		hashProcess(ipcEventUtil);

	}

	/**
	 * Reset image slider.
	 */
	private void resetSureBet() {
		if (securebet != null) {
			securebet.stopTimer();
			getMainContainerRootPanel().clear();
			// securebet = null;
		}

	}

}
