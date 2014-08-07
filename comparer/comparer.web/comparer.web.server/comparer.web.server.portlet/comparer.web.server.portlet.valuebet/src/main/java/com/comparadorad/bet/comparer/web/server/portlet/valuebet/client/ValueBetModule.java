/**
 *
 * Copyright (C) FACTORIA ETSIA S.L.
 * All Rights Reserved.
 * www.factoriaetsia.com
 *
 */
package com.comparadorad.bet.comparer.web.server.portlet.valuebet.client;

import com.allen_sauer.gwt.log.client.Log;
import com.comparadorad.bet.comparer.web.client.gwt.core.ipc.HashNames;
import com.comparadorad.bet.comparer.web.client.gwt.core.ipc.IIpcEvent;
import com.comparadorad.bet.comparer.web.client.gwt.core.ipc.IIpcEventUtil;
import com.comparadorad.bet.comparer.web.client.gwt.core.ipc.InternalLinkEventNames;
import com.comparadorad.bet.comparer.web.client.gwt.core.ipc.IpcEventFactory;
import com.comparadorad.bet.comparer.web.client.gwt.core.module.AbstractModule;
import com.comparadorad.bet.comparer.web.client.gwt.core.module.IExpireSession;
import com.comparadorad.bet.comparer.web.client.gwt.valuebet.ui.view.ValueBet;

/**
 * Entry point classes define <code>onModuleLoad()</code>.
 */
public class ValueBetModule extends AbstractModule implements IExpireSession {

	/**
	 * The Class SeachIpcValueBetMatchEvent.
	 */
	private class SeachIpcValueBetMatchEvent implements IIpcEvent {

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
			resetValueBet();
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
			resetValueBet();
			valueBet = new ValueBet();
			getMainContainerRootPanel().add(valueBet);
		}
	}

	/**
	 * This is the entry point method.
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
			resetValueBet();
		}
	}

	private class ExpireSessionEvent implements IIpcEvent {

		@Override
		public void change(String objectId, String pObjectIdSec, String name) {
			onExpireSession();

		}
	}

	/** The Constant NEXTEVENTS_MODULE_CONTAINER. */
	private static final String VALUEBET_MODULE_CONTAINER = "valueBetModuleContainer";

	/** The live bet. */
	private ValueBet valueBet;

	/**
	 * Gets the app path.
	 * 
	 * @return the app path {@inheritDoc}
	 */
	@Override
	protected String getAppPath() {
		return "com.comparadorad.bet.comparer.web.server.portlet.valuebet";
	}

	/**
	 * Gets the main container id.
	 * 
	 * @return the main container id {@inheritDoc}
	 */
	@Override
	protected String getMainContainerId() {
		return VALUEBET_MODULE_CONTAINER;
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

		if (!page.equals(HashNames.CLEAN)) {
			valueBet = new ValueBet(Long.parseLong(page));
			getMainContainerRootPanel().add(valueBet);
		} else {
			valueBet = new ValueBet();
			getMainContainerRootPanel().add(valueBet);
		}
	}

	/** {@inheritDoc} */
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
		ipcEventUtil.listen(new SeachIpcValueBetMatchEvent(),
				InternalLinkEventNames.VALUE_BET_MATCH_EVENT.getEventName());
		ipcEventUtil.listen(new ExpireSessionEvent(), "expireSessionEvent");

		hashProcess(ipcEventUtil);

	}

	/**
	 * Reset image slider.
	 */
	private void resetValueBet() {
		if (valueBet != null) {
			valueBet.stopTimer();
			getMainContainerRootPanel().clear();
			// valueBet = null;
		}

	}

	@Override
	public void onExpireSession() {
		if (valueBet != null) {
			valueBet.stopTimer();
		}

	}

}
