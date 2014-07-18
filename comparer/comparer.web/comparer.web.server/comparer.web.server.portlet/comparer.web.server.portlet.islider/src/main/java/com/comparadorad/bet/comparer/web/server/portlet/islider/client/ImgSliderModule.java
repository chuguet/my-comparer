/**
 *
 * Copyright (C) FACTORIA ETSIA S.L.
 * All Rights Reserved.
 * www.factoriaetsia.com
 *
 */
package com.comparadorad.bet.comparer.web.server.portlet.islider.client;

import com.allen_sauer.gwt.log.client.Log;
import com.comparadorad.bet.comparer.web.client.gwt.core.ipc.IIpcEvent;
import com.comparadorad.bet.comparer.web.client.gwt.core.ipc.IIpcEventUtil;
import com.comparadorad.bet.comparer.web.client.gwt.core.ipc.InternalLinkEventNames;
import com.comparadorad.bet.comparer.web.client.gwt.core.ipc.IpcEventFactory;
import com.comparadorad.bet.comparer.web.client.gwt.core.module.AbstractModule;
import com.comparadorad.bet.comparer.web.client.gwt.core.module.IExpireSession;
import com.comparadorad.bet.comparer.web.client.gwt.imageslider.ui.view.ImageSlider;

/**
 * Entry point classes define <code>onModuleLoad()</code>.
 */
public class ImgSliderModule extends AbstractModule implements IExpireSession {

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
	 * The Class SearchIpcImageSliderCompetitionEvent.
	 */
	private class SearchIpcImageSliderCompetitionEvent implements IIpcEvent {

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
			resetImageSlider();
		}
	}

	/**
	 * The Class SearchIpcImageSliderMatchEvent.
	 */
	private class SearchIpcImageSliderMatchEvent implements IIpcEvent {

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
			Log.debug("Evento seleccionado: " + objectId);
			resetImageSlider();
		}
	}

	/**
	 * The Class SearchIpcNextEventMatchEvent.
	 */
	private class SearchIpcNextEventMatchEvent implements IIpcEvent {

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
			Log.debug("Evento seleccionado: " + objectId);
			resetImageSlider();
		}
	}

	/**
	 * The Class SearchIpcResultsCountryEvent.
	 */
	private class SearchIpcResultsCountryEvent implements IIpcEvent {

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
			resetImageSlider();
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
			getMainContainerRootPanel().clear();
			imageSlider = new ImageSlider();
			getMainContainerRootPanel().add(imageSlider);
		}
	}

	/**
	 * The Class SearchIpcResultsSportEvent.
	 */
	private class SearchIpcResultsSportEvent implements IIpcEvent {

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
			resetImageSlider();
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
			resetImageSlider();
		}
	}

	/** The Constant NEXTEVENTS_MODULE_CONTAINER. */
	private static final String ImgSlider_MODULE_CONTAINER = "ImgSliderModuleContainer";

	/** The image slider. */
	private ImageSlider imageSlider;

	/**
	 * Gets the app path.
	 * 
	 * @return the app path {@inheritDoc}
	 */
	@Override
	protected String getAppPath() {
		return "com.comparadorad.bet.comparer.web.server.portlet.islider";
	}

	/**
	 * Gets the main container id.
	 * 
	 * @return the main container id {@inheritDoc}
	 */
	@Override
	protected String getMainContainerId() {
		return ImgSlider_MODULE_CONTAINER;
	}

	/** {@inheritDoc} */
	@Override
	public void onExpireSession() {
		if (imageSlider != null) {
			imageSlider.stopTimer();
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
		ipcEventUtil.listen(new SearchIpcImageSliderMatchEvent(),
				InternalLinkEventNames.IMAGE_SLIDER_MATCH_EVENT.getEventName());
		ipcEventUtil.listen(new SearchIpcImageSliderCompetitionEvent(),
				InternalLinkEventNames.IMAGE_SLIDER_COMPETITION_EVENT
						.getEventName());
		ipcEventUtil.listen(new SearchIpcNextEventMatchEvent(),
				InternalLinkEventNames.NEXT_EVENT_MATCH_EVENT.getEventName());
		ipcEventUtil.listen(new SearchIpcResultsSportEvent(),
				InternalLinkEventNames.RESULTS_SPORT_EVENT.getEventName());
		ipcEventUtil.listen(new SearchIpcResultsCountryEvent(),
				InternalLinkEventNames.RESULTS_COUNTRY_EVENT.getEventName());
		ipcEventUtil.listen(new ExpireSessionEvent(), "expireSessionEvent");

		if (!isURL(ipcEventUtil)) {
			imageSlider = new ImageSlider();
			getMainContainerRootPanel().add(imageSlider);
		}

	}

	/**
	 * Reset image slider.
	 */
	private void resetImageSlider() {
		if (imageSlider != null) {
			imageSlider.stopTimer();
			getMainContainerRootPanel().clear();
			// imageSlider = null;
		}

	}

}
