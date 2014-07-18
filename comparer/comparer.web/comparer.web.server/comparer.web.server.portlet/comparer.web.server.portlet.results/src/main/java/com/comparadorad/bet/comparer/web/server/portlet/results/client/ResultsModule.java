/**
 *
 * Copyright (C) FACTORIA ETSIA S.L.
 * All Rights Reserved.
 * www.factoriaetsia.com
 *
 */
package com.comparadorad.bet.comparer.web.server.portlet.results.client;

import com.allen_sauer.gwt.log.client.Log;
import com.comparadorad.bet.comparer.web.client.gwt.common.bean.ObjectToId;
import com.comparadorad.bet.comparer.web.client.gwt.core.ipc.HashNames;
import com.comparadorad.bet.comparer.web.client.gwt.core.ipc.IIpcEvent;
import com.comparadorad.bet.comparer.web.client.gwt.core.ipc.IIpcEventUtil;
import com.comparadorad.bet.comparer.web.client.gwt.core.ipc.InternalLinkEventNames;
import com.comparadorad.bet.comparer.web.client.gwt.core.ipc.IpcEventFactory;
import com.comparadorad.bet.comparer.web.client.gwt.core.module.AbstractModule;
import com.comparadorad.bet.comparer.web.client.gwt.core.module.IExpireSession;
import com.comparadorad.bet.comparer.web.client.gwt.results.ui.comp.view.Competition;
import com.comparadorad.bet.comparer.web.client.gwt.results.ui.event.view.Event;
import com.comparadorad.bet.comparer.web.client.gwt.results.ui.view.Country;
import com.comparadorad.bet.comparer.web.client.gwt.results.ui.view.Sport;

/**
 * Entry point classes define <code>onModuleLoad()</code>.
 */
public class ResultsModule extends AbstractModule implements IExpireSession {

	/**
	 * The Class ExpireSessionEvent.
	 */
	private class ExpireSessionEvent implements IIpcEvent {

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
			onExpireSession();

		}
	}

	/**
	 * The Class SearchIpcImageSliderCompetitionEvent.
	 */
	private class SearchIpcImageSliderCompetitionEvent implements IIpcEvent {

		/** The ipc event util. */
		private IIpcEventUtil ipcEventUtil;

		/**
		 * Instantiates a new search ipc image slider competition event.
		 * 
		 * @param ipcEventUtil
		 *            the ipc event util
		 */
		public SearchIpcImageSliderCompetitionEvent(IIpcEventUtil ipcEventUtil) {
			this.ipcEventUtil = ipcEventUtil;
		}

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
			Log.debug("SearchIpcImageSliderCompetitionEvent");
			Log.debug("Competicion seleccionada: " + objectId);
			resetResultWidget();
			String[][] values = { { HashNames.COMPETITION_HASH, objectId },
					{ HashNames.TAB_HEAD_HASH, HEAD } };
			// ipcEventUtil.changeView(HashNames.COMPETICION);
			// ipcEventUtil.setHash(buildHash(values));
			competition = new Competition(new ObjectToId(objectId));
			getMainContainerRootPanel().add(competition);
		}
	}

	/**
	 * The Class SearchIpcImageSliderMatchEvent.
	 */
	private class SearchIpcImageSliderMatchEvent implements IIpcEvent {

		/** The ipc event util. */
		private IIpcEventUtil ipcEventUtil;

		/**
		 * Instantiates a new search ipc image slider match event.
		 * 
		 * @param ipcEventUtil
		 *            the ipc event util
		 */
		public SearchIpcImageSliderMatchEvent(IIpcEventUtil ipcEventUtil) {
			this.ipcEventUtil = ipcEventUtil;
		}

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
			Log.debug("SearchIpcImageSliderMatchEvent");
			Log.debug("Evento seleccionado: " + objectId);
			Log.debug("BetType seleccionado: " + pObjectIdSec);
			resetResultWidget();
			String[][] values = { { HashNames.EVENT_HASH, objectId },
					{ HashNames.TAB_HEAD_HASH, HEAD } };
			// ipcEventUtil.changeView(HashNames.EVENTO);
			// ipcEventUtil.setHash(buildHash(values));
			event = new Event(new ObjectToId(objectId), "0", pObjectIdSec);
			getMainContainerRootPanel().add(event);
		}
	}

	/**
	 * The Class SearchIpcNextEventMatchEvent.
	 */
	private class SearchIpcNextEventMatchEvent implements IIpcEvent {

		/** The ipc event util. */
		private IIpcEventUtil ipcEventUtil;

		/**
		 * Instantiates a new search ipc next event match event.
		 * 
		 * @param ipcEventUtil
		 *            the ipc event util
		 */
		public SearchIpcNextEventMatchEvent(IIpcEventUtil ipcEventUtil) {
			this.ipcEventUtil = ipcEventUtil;
		}

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
			Log.debug("SearchIpcNextEventMatchEvent");
			Log.debug("Match seleccionado: " + objectId);
			Log.debug("BetType seleccionado: " + pObjectIdSec);
			resetResultWidget();
			String[][] values = { { HashNames.EVENT_HASH, objectId },
					{ HashNames.TAB_HEAD_HASH, HEAD } };
			if (name.equals(HashNames.EVENT_HEAD)) {
				Log.debug("EVENT_HEAD");
				// ipcEventUtil.changeView(HashNames.EVENT_HEAD);
				// ipcEventUtil.setHash(buildHash(values));
				ipcEventUtil.changeView();
				event = new Event(new ObjectToId(objectId),
						ipcEventUtil.getHashParam(HashNames.TAB_HEAD_HASH));
			} else if (name.equals(HashNames.EVENT_HEAD_BETTYPE)) {
				Log.debug("EVENT_HEAD_BETTYPE");
				// ipcEventUtil.changeView(HashNames.EVENT_HEAD_BETTYPE);
				// ipcEventUtil.setHash(buildHash(values));
				ipcEventUtil.changeView();
				event = new Event(new ObjectToId(objectId),
						ipcEventUtil.getHashParam(HashNames.TAB_HEAD_HASH),
						ipcEventUtil.getHashParam(HashNames.TAB_BET_TYPE_HASH));
			} else if (name.equals(HashNames.EVENT_HEAD_BETTYPE_BETTYPEEVENT)) {
				Log.debug("EVENT_HEAD_BETTYPE_BETTYPEEVENT");
				// ipcEventUtil.changeView(HashNames.EVENT_HEAD_BETTYPE_BETTYPEEVENT);
				// ipcEventUtil.setHash(buildHash(values));
				ipcEventUtil.changeView();
				event = new Event(
						new ObjectToId(objectId),
						ipcEventUtil.getHashParam(HashNames.TAB_HEAD_HASH),
						ipcEventUtil.getHashParam(HashNames.TAB_BET_TYPE_HASH),
						ipcEventUtil
								.getHashParam(HashNames.TAB_BET_TYPE__EVENT_HASH));
			} else {
				Log.debug("EVENT");
				// ipcEventUtil.changeView(HashNames.EVENTO);
				// ipcEventUtil.setHash(buildHash(values));
				event = new Event(new ObjectToId(objectId), "0", pObjectIdSec);
			}

			getMainContainerRootPanel().add(event);
		}
	}

	/**
	 * The Class SearchIpcResultsCompetitionEvent.
	 */
	private class SearchIpcResultsCompetitionEvent implements IIpcEvent {

		/** The ipc event util. */
		private IIpcEventUtil ipcEventUtil;

		/**
		 * Instantiates a new search ipc results competition event.
		 * 
		 * @param ipcEventUtil
		 *            the ipc event util
		 */
		public SearchIpcResultsCompetitionEvent(IIpcEventUtil ipcEventUtil) {
			this.ipcEventUtil = ipcEventUtil;
		}

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
			Log.debug("SearchIpcResultsCompetitionEvent");
			Log.debug("Competicion seleccionada: " + objectId);
			resetResultWidget();
			String[][] values = { { HashNames.COMPETITION_HASH, objectId },
					{ HashNames.TAB_HEAD_HASH, HEAD } };
			// ipcEventUtil.changeView(HashNames.COMPETICION);
			// ipcEventUtil.setHash(buildHash(values));
			if (pObjectIdSec != null && !pObjectIdSec.isEmpty()) {
				competition = new Competition(new ObjectToId(objectId), "0",
						pObjectIdSec);
			} else {
				Log.debug("Abrir Competition CP with compId, headId0");
				competition = new Competition(new ObjectToId(objectId), "0");
			}
			getMainContainerRootPanel().add(competition);
		}
	}

	/**
	 * The Class SearchIpcResultsCompetitionLTEvent.
	 */
	private class SearchIpcResultsCompetitionLTEvent implements IIpcEvent {

		/** The ipc event util. */
		private IIpcEventUtil ipcEventUtil;

		/**
		 * Instantiates a new search ipc results competition lt event.
		 * 
		 * @param ipcEventUtil
		 *            the ipc event util
		 */
		public SearchIpcResultsCompetitionLTEvent(IIpcEventUtil ipcEventUtil) {
			this.ipcEventUtil = ipcEventUtil;
		}

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
			Log.debug("SearchIpcResultsCompetitionLTEvent");
			Log.debug("Competicion seleccionada: " + objectId);
			resetResultWidget();
			competition = new Competition(new ObjectToId(objectId), "1");
			getMainContainerRootPanel().add(competition);
		}
	}

	/**
	 * The Class SearchIpcResultsSportCountryEvent.
	 */
	private class SearchIpcResultsCountryEvent implements IIpcEvent {

		/** The ipc event util. */
		private IIpcEventUtil ipcEventUtil;

		/**
		 * Instantiates a new search ipc results country event.
		 * 
		 * @param ipcEventUtil
		 *            the ipc event util
		 */
		public SearchIpcResultsCountryEvent(IIpcEventUtil ipcEventUtil) {
			this.ipcEventUtil = ipcEventUtil;
		}

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
			Log.debug("SearchIpcResultsCountryEvent");
			Log.debug("Country:" + objectId + ", Sport: " + pObjectIdSec);
			resetResultWidget();
			String[][] values = { { HashNames.COUNTRY_SP_HASH, objectId },
					{ HashNames.COUNTRY_CO_HASH, pObjectIdSec },
					{ HashNames.TAB_HEAD_HASH, HEAD } };
			if (name.equals(HashNames.PAIS_HEAD)) {
				// ipcEventUtil.changeView(HashNames.PAIS_HEAD);
				// ipcEventUtil.setHash(buildHash(values));
				ipcEventUtil.changeView();
				country = new Country(new ObjectToId(objectId), new ObjectToId(
						pObjectIdSec),
						ipcEventUtil.getHashParam(HashNames.TAB_HEAD_HASH));
			} else {
				// ipcEventUtil.changeView(HashNames.PAIS);
				// ipcEventUtil.setHash(buildHash(values));
				country = new Country(new ObjectToId(pObjectIdSec),
						new ObjectToId(objectId));
			}

			getMainContainerRootPanel().add(country);

		}

	}

	/**
	 * The Class SearchIpcResultsMainEvent.
	 */
	private class SearchIpcResultsMainEvent implements IIpcEvent {

		/** The ipc event util. */
		private IIpcEventUtil ipcEventUtil;

		/**
		 * Instantiates a new search ipc results main event.
		 * 
		 * @param ipcEventUtil
		 *            the ipc event util
		 */
		public SearchIpcResultsMainEvent(IIpcEventUtil ipcEventUtil) {
			this.ipcEventUtil = ipcEventUtil;
		}

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
			Log.debug("SearchIpcResultsMainEvent");
			Log.debug("Inicio:");
			resetResultWidget();
			// ipcEventUtil.changeView(HashNames.MAIN);
			ipcEventUtil.removeHash();
		}

	}

	/**
	 * The Class SearchIpcResultsMatchEvent.
	 */
	private class SearchIpcResultsMatchEvent implements IIpcEvent {

		/** The ipc event util. */
		private IIpcEventUtil ipcEventUtil;

		/**
		 * Instantiates a new search ipc results match event.
		 * 
		 * @param ipcEventUtil
		 *            the ipc event util
		 */
		public SearchIpcResultsMatchEvent(IIpcEventUtil ipcEventUtil) {
			this.ipcEventUtil = ipcEventUtil;
		}

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
			Log.debug("SearchIpcResultsMatchEvent");
			Log.debug("Match seleccionado: " + objectId);
			Log.debug("BetType seleccionado: " + pObjectIdSec);
			resetResultWidget();
			String[][] values = { { HashNames.EVENT_HASH, objectId },
					{ HashNames.TAB_HEAD_HASH, HEAD } };
			// ipcEventUtil.changeView(HashNames.EVENTO);
			// ipcEventUtil.setHash(buildHash(values));
			event = new Event(new ObjectToId(objectId), "0", pObjectIdSec);
			getMainContainerRootPanel().add(event);
		}
	}

	/**
	 * The Class SearchIpcResultsSportEvent.
	 */
	private class SearchIpcResultsSportEvent implements IIpcEvent {

		/** The ipc event util. */
		private IIpcEventUtil ipcEventUtil;

		/**
		 * Instantiates a new search ipc results sport event.
		 * 
		 * @param ipcEventUtil
		 *            the ipc event util
		 */
		public SearchIpcResultsSportEvent(IIpcEventUtil ipcEventUtil) {
			this.ipcEventUtil = ipcEventUtil;
		}

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
			Log.debug("SearchIpcResultsSportEvent");
			Log.debug("Competicion seleccionada: " + objectId);
			resetResultWidget();
			String[][] values = { { HashNames.SPORT_HASH, objectId },
					{ HashNames.TAB_HEAD_HASH, HEAD } };
			if (name.equals(HashNames.DEPORTE_HEAD)) {
				// ipcEventUtil.changeView(HashNames.DEPORTE_HEAD);
				// ipcEventUtil.setHash(buildHash(values));
				ipcEventUtil.changeView();
				sport = new Sport(new ObjectToId(objectId),
						ipcEventUtil.getHashParam(HashNames.TAB_HEAD_HASH));
			} else {
				// ipcEventUtil.changeView(HashNames.DEPORTE);
				// ipcEventUtil.setHash(buildHash(values));
				sport = new Sport(new ObjectToId(objectId));
			}

			getMainContainerRootPanel().add(sport);

		}

	}

	/**
	 * The Class SearchIpcEvent.
	 */

	private class SearchIpcToolbarCompetitionEvent implements IIpcEvent {

		/** The ipc event util. */
		private IIpcEventUtil ipcEventUtil;

		/**
		 * Instantiates a new search ipc toolbar competition event.
		 * 
		 * @param ipcEventUtil
		 *            the ipc event util
		 */
		public SearchIpcToolbarCompetitionEvent(IIpcEventUtil ipcEventUtil) {
			this.ipcEventUtil = ipcEventUtil;
		}

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

			Log.debug("SearchIpcToolbarCompetitionEvent");
			Log.debug("toolbar competition click");
			Log.debug("Competicion seleccionada: " + objectId);
			resetResultWidget();

			String[][] values = { { HashNames.COMPETITION_HASH, objectId },
					{ HashNames.TAB_HEAD_HASH, HEAD } };
			if (name.equals(HashNames.COMPETITION_HEAD)) {
				// ipcEventUtil.changeView(HashNames.COMPETITION_HEAD);
				// ipcEventUtil.setHash(buildHash(values));
				ipcEventUtil.changeView();
				competition = new Competition(new ObjectToId(objectId),
						ipcEventUtil.getHashParam(HashNames.TAB_HEAD_HASH));
			} else if (name.equals(HashNames.COMPETICION_HEAD_BETTYPE)) {
				// ipcEventUtil.changeView(HashNames.COMPETICION_HEAD_BETTYPE);
				// ipcEventUtil.setHash(buildHash(values));
				ipcEventUtil.changeView();
				competition = new Competition(new ObjectToId(objectId),
						ipcEventUtil.getHashParam(HashNames.TAB_HEAD_HASH),
						ipcEventUtil.getHashParam(HashNames.TAB_BET_TYPE_HASH));
			} else {
				// ipcEventUtil.changeView(HashNames.COMPETICION);
				// ipcEventUtil.setHash(buildHash(values));
				competition = new Competition(new ObjectToId(objectId));
			}
			getMainContainerRootPanel().add(competition);

		}
	}

	/** The Constant RESULTS_MODULE_CONTAINER. */
	private static final String RESULTS_MODULE_CONTAINER = "resultsModuleContainer";

	/** The competition. */
	private Competition competition;

	/** The country. */
	private Country country;

	/** The event. */
	private Event event;

	/** The HEAD. */
	private final String HEAD = "0";

	/** The sport. */
	private Sport sport;

	/**
	 * Gets the app path.
	 * 
	 * @return the app path {@inheritDoc}
	 */
	@Override
	protected String getAppPath() {
		return "com.comparadorad.bet.comparer.web.server.portlet.results";
	}

	/**
	 * Gets the main container id.
	 * 
	 * @return the main container id {@inheritDoc}
	 */
	@Override
	protected String getMainContainerId() {
		return RESULTS_MODULE_CONTAINER;
	}

	/**
	 * Hash process.
	 * 
	 * @param ipcEventUtil
	 *            the ipc event util
	 */
	private void hashProcess(IIpcEventUtil ipcEventUtil) {
		Log.debug("hashProcess");
		String head = ipcEventUtil.getHashParam(HashNames.TAB_HEAD_HASH);
		String betType = ipcEventUtil.getHashParam(HashNames.TAB_BET_TYPE_HASH);
		String betTypeEvent = ipcEventUtil
				.getHashParam(HashNames.TAB_BET_TYPE__EVENT_HASH);
		String competitionC = ipcEventUtil
				.getHashParam(HashNames.COMPETITION_HASH);
		// TODO separarlo en métodos más pequeños

		/* COMPETITION */
		Log.debug("competicion" + competitionC);
		if (!competitionC.equals(HashNames.CLEAN)) {
			if ((!head.equals(HashNames.CLEAN))
					&& (!betType.equals(HashNames.CLEAN))) {
				Log.debug("competicion with head and bettype");
				// ipcEventUtil.changeView(HashNames.COMPETICION_HEAD_BETTYPE);
				competition = new Competition(new ObjectToId(competitionC),
						head, betType);
				getMainContainerRootPanel().add(competition);
				return;
			} else if (!head.equals(HashNames.CLEAN)) {
				Log.debug("competicion with head");
				// ipcEventUtil.changeView(HashNames.COMPETITION_HEAD);
				competition = new Competition(new ObjectToId(competitionC),
						head);
				getMainContainerRootPanel().add(competition);
				return;
			} else {
				Log.debug("competicion only");
				// ipcEventUtil.changeView(HashNames.COMPETICION);
				competition = new Competition(new ObjectToId(competitionC));
				getMainContainerRootPanel().add(competition);
				return;
			}
		}

		/* EVENT */
		String eventC = ipcEventUtil.getHashParam(HashNames.EVENT_HASH);

		Log.debug("Evento: " + eventC);
		if (!eventC.equals(HashNames.CLEAN)) {
			if ((!head.equals(HashNames.CLEAN))
					&& (!betType.equals(HashNames.CLEAN))
					&& (!betTypeEvent.equals(HashNames.CLEAN))) {
				Log.debug("event with head and bettype and bettypeevent");
				// ipcEventUtil.changeView(HashNames.EVENT_HEAD_BETTYPE_BETTYPEEVENT);
				event = new Event(new ObjectToId(eventC), head, betType,
						betTypeEvent);
				getMainContainerRootPanel().add(event);
				return;
			} else if ((!head.equals(HashNames.CLEAN))
					&& (!betType.equals(HashNames.CLEAN))) {
				Log.debug("event with head and bettype");
				// ipcEventUtil.changeView(HashNames.EVENT_HEAD_BETTYPE);
				event = new Event(new ObjectToId(eventC), head, betType);
				getMainContainerRootPanel().add(event);
				return;
			} else if (!head.equals(HashNames.CLEAN)) {
				// ipcEventUtil.changeView(HashNames.EVENT_HEAD);
				Log.debug("event with head");
				event = new Event(new ObjectToId(eventC), head);
				getMainContainerRootPanel().add(event);
				return;
			} else {
				Log.debug("event only");
				// ipcEventUtil.changeView(HashNames.EVENTO);
				event = new Event(new ObjectToId(eventC));
				getMainContainerRootPanel().add(event);
				return;
			}
		}

		/* SPORT */
		String countryCoC = ipcEventUtil
				.getHashParam(HashNames.COUNTRY_CO_HASH);
		String sportC = ipcEventUtil.getHashParam(HashNames.SPORT_HASH);

		Log.debug("se refresca deporte: " + sportC);
		if (!sportC.equals(HashNames.CLEAN)
				&& countryCoC.equals(HashNames.CLEAN)) {

			if (!head.equals(HashNames.CLEAN)) {
				Log.debug("sport with head");
				// ipcEventUtil.changeView(HashNames.DEPORTE_HEAD);
				sport = new Sport(new ObjectToId(sportC), head);
				getMainContainerRootPanel().add(sport);
				return;
			} else {
				Log.debug("sport only");
				// ipcEventUtil.changeView(HashNames.DEPORTE);
				sport = new Sport(new ObjectToId(sportC));
				getMainContainerRootPanel().add(sport);
				return;
			}

		}

		/* COUNTRY */
		String countrySpC = ipcEventUtil
				.getHashParam(HashNames.COUNTRY_SP_HASH);

		Log.debug("country: Sport: " + countrySpC + "///" + "Country:"
				+ countryCoC);
		if (!countrySpC.equals(HashNames.CLEAN)
				&& !countryCoC.equals(HashNames.CLEAN)) {

			if (!head.equals(HashNames.CLEAN)) {
				Log.debug("country with head");
				// ipcEventUtil.changeView(HashNames.PAIS_HEAD);
				country = new Country(new ObjectToId(countrySpC),
						new ObjectToId(countryCoC), head);
				getMainContainerRootPanel().add(country);
				return;
			} else {
				Log.debug("country only");
				// ipcEventUtil.changeView(HashNames.PAIS);
				country = new Country(new ObjectToId(countrySpC),
						new ObjectToId(countryCoC));
				getMainContainerRootPanel().add(country);
				return;
			}
		}
	}

	/**
	 * On expire session.
	 * 
	 * {@inheritDoc}
	 */
	@Override
	public void onExpireSession() {
		stopTimer();
	}

	/**
	 * This is the entry point method.
	 */
	@Override
	public void onModuleLoadActions() {
		IIpcEventUtil ipcEventUtil = IpcEventFactory.getInstance()
				.createIpcEventUtil();

		ipcEventUtil
				.listen(new SearchIpcToolbarCompetitionEvent(ipcEventUtil),
						InternalLinkEventNames.TOOLBAR_COMPETITION_EVENT
								.getEventName());
		ipcEventUtil.listen(new SearchIpcResultsMatchEvent(ipcEventUtil),
				InternalLinkEventNames.RESULTS_MATCH_EVENT.getEventName());
		ipcEventUtil
				.listen(new SearchIpcResultsCompetitionEvent(ipcEventUtil),
						InternalLinkEventNames.RESULTS_COMPETITION_EVENT
								.getEventName());
		ipcEventUtil.listen(
				new SearchIpcResultsCompetitionLTEvent(ipcEventUtil),
				InternalLinkEventNames.RESULTS_COMPETITION_LT_EVENT
						.getEventName());
		ipcEventUtil.listen(new SearchIpcResultsSportEvent(ipcEventUtil),
				InternalLinkEventNames.RESULTS_SPORT_EVENT.getEventName());
		ipcEventUtil.listen(new SearchIpcResultsCountryEvent(ipcEventUtil),
				InternalLinkEventNames.RESULTS_COUNTRY_EVENT.getEventName());
		ipcEventUtil.listen(new SearchIpcResultsMainEvent(ipcEventUtil),
				InternalLinkEventNames.RESULTS_MAIN_EVENT.getEventName());
		ipcEventUtil.listen(new SearchIpcNextEventMatchEvent(ipcEventUtil),
				InternalLinkEventNames.NEXT_EVENT_MATCH_EVENT.getEventName());
		ipcEventUtil.listen(new SearchIpcImageSliderMatchEvent(ipcEventUtil),
				InternalLinkEventNames.IMAGE_SLIDER_MATCH_EVENT.getEventName());
		ipcEventUtil.listen(new SearchIpcImageSliderCompetitionEvent(
				ipcEventUtil),
				InternalLinkEventNames.IMAGE_SLIDER_COMPETITION_EVENT
						.getEventName());
		ipcEventUtil.listen(new ExpireSessionEvent(), "expireSessionEvent");

		hashProcess(ipcEventUtil);

	}

	/**
	 * Reset result.
	 */
	private void resetResultWidget() {
		Log.debug("resetResultWidget");
		stopTimer();
		Log.debug("clearing RootPanel");
		getMainContainerRootPanel().clear();
	}

	/**
	 * Stop timer.
	 */
	public void stopTimer() {
		if (sport != null) {
			Log.debug("stop timer sport");
			sport.stopTimer();
		}
		if (country != null) {
			Log.debug("stop timer country");
			country.stopTimer();
		}
		if (competition != null) {
			Log.debug("stop timer competition");
			competition.stopTimer();
		}
		if (event != null) {
			Log.debug("stop timer event");
			event.stopTimer();
		}

	}

}
