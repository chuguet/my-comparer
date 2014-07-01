/**
 *
 * Copyright (C) FACTORIA ETSIA S.L.
 * All Rights Reserved.
 * www.factoriaetsia.com
 *
 */
package com.comparadorad.bet.comparer.web.client.gwt.imageslider.ui.view;

import java.util.ArrayList;
import java.util.List;

import org.fusesource.restygwt.client.Method;

import com.allen_sauer.gwt.log.client.Log;
import com.comparadorad.bet.comparer.web.client.gwt.common.bean.table.TableResponseCellTo;
import com.comparadorad.bet.comparer.web.client.gwt.common.bean.table.TableResponseRowTo;
import com.comparadorad.bet.comparer.web.client.gwt.common.bean.table.TableResponseTo;
import com.comparadorad.bet.comparer.web.client.gwt.core.data.AbstractServiceMethodCallback;
import com.comparadorad.bet.comparer.web.client.gwt.core.service.ServiceFactory;
import com.comparadorad.bet.comparer.web.client.gwt.imageslider.bean.request.ImageSliderRequestTo;
import com.comparadorad.bet.comparer.web.client.gwt.imageslider.bean.response.ImageSliderResponseTo;
import com.comparadorad.bet.comparer.web.client.gwt.imageslider.bean.response.ImageSliderUpdateResponseTo;
import com.comparadorad.bet.comparer.web.client.gwt.imageslider.ui.Messages;
import com.comparadorad.bet.comparer.web.client.gwt.imageslider.ui.dummy.ImageSliderDummyService;
import com.comparadorad.bet.comparer.web.client.gwt.imageslider.ui.service.IImageSliderService;
import com.comparadorad.bet.comparer.web.client.gwt.imageslider.ui.service.ImageSliderService;
import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.Timer;
import com.smartgwt.client.types.AnimationEffect;
import com.smartgwt.client.widgets.AnimationCallback;
import com.smartgwt.client.widgets.Canvas;
import com.smartgwt.client.widgets.Img;
import com.smartgwt.client.widgets.ImgButton;
import com.smartgwt.client.widgets.events.ClickEvent;
import com.smartgwt.client.widgets.events.ClickHandler;
import com.smartgwt.client.widgets.layout.HLayout;

/**
 * The Class ImageSlider.
 */
public class ImageSlider extends HLayout {

	/** The Constant BUTTON_HEIGHT. */
	private final static int BUTTON_HEIGHT = 20;

	/** The Constant BUTTON_WIDTH. */
	private final static int BUTTON_WIDTH = 20;

	/** The Constant COMPARE_QUOTAS_LEFT. */
	private final static int COMPARE_QUOTAS_LEFT = 680;

	/** The Constant HEIGHT. */
	final static int HEIGHT = 190;

	/** The Constant STYLE_NAME_BUTTON_LAYOUT. */
	private final static String STYLE_NAME_BUTTON_LAYOUT = "imgSliderButtonLayout";

	/** The Constant TRANSPATENT_LABEL_LEFT. */
	private final static int TRANSPATENT_LABEL_LEFT = 501;

	/** The Constant WIDTH. */
	final static int WIDTH = 832;

	/** The all event data. */
	List<ImageSliderResponseTo> allEventData = new ArrayList<ImageSliderResponseTo>();

	/** The button layout. */
	private HLayout buttonLayout;

	/** The callback. */
	AnimationCallback callback = new AnimationCallback() {
		public void execute(boolean earlyFinish) {
		}
	};

	/** The change event time. */
	private int changeEventTime = 10000; // 10 000 milisegundos

	/** The actual event number. */
	private int currentEventNumber = 0;

	/** The event loaded. */
	List<Boolean> eventLoaded = new ArrayList<Boolean>();

	/** The event ok. */
	List<Boolean> eventOk = new ArrayList<Boolean>();

	/** The old event number. */
	private int lastEventNumber;

	/** The list compare quotas label. */
	private List<CompareQuotasWidget> listCompareQuotasLabels = new ArrayList<CompareQuotasWidget>();

	/** The list buttons img. */
	private List<ImgButton> listImgButtons = new ArrayList<ImgButton>();

	/** The list imagenes img. */
	private List<Img> listImgs = new ArrayList<Img>();

	/** The list transparent label. */
	private List<TransparentWidget> listTransparentLabels = new ArrayList<TransparentWidget>();

	/** The messages. */
	private Messages messages = GWT.create(Messages.class);

	/** The timer. */
	private Timer timer = new Timer() {
		public void run() {
			Log.debug("Imageslider timer: next event");
			int eventToShow;
			if (currentEventNumber < allEventData.size() - 1) {
				eventToShow = currentEventNumber + 1;
			} else {
				eventToShow = 0;
			}
			ImgButton imgButton = listImgButtons.get(eventToShow);
			imgButton.fireEvent(new ClickEvent(imgButton.getJsObj()));
		}
	};

	/** The timer active. */
	private boolean timerActive;

	/**
	 * Instantiates a new image slider.
	 */
	public ImageSlider() {
		initImageSlider();
	}

	/**
	 * Animate show.
	 * 
	 * @param canvas
	 *            the canvas
	 * @param effect
	 *            the effect
	 * @param startFrom
	 *            the start from
	 */
	public native void animateShow(Canvas canvas, AnimationEffect effect,
			String startFrom) /*-{
		var effectJsObj = {
			effect : effect.@com.smartgwt.client.types.AnimationEffect::getValue()(),
			startFrom : startFrom
		};
		var canvasJsObj = canvas.@com.smartgwt.client.widgets.Canvas::getOrCreateJsObj()();
		canvasJsObj.animateShow(effectJsObj);
	}-*/;

	/**
	 * Change compare quotas.
	 * 
	 * @param eventNumber
	 *            the image number
	 * @param response
	 *            the response
	 * @param responseOk
	 *            the response ok
	 */
	private void changeCompareQuotas(int eventNumber,
			ImageSliderUpdateResponseTo response, boolean responseOk) {
		listCompareQuotasLabels.get(lastEventNumber).setVisible(false);
		listCompareQuotasLabels.get(lastEventNumber).sendToBack();
		CompareQuotasWidget compareQuotasToShow = listCompareQuotasLabels
				.get(eventNumber);
		if (responseOk && eventOk.get(eventNumber)) {
			compareQuotasToShow.updateProfits(response.getTable());
		} else {
			listCompareQuotasLabels.set(eventNumber, new CompareQuotasWidget());
			compareQuotasToShow = listCompareQuotasLabels.get(eventNumber);
		}
		compareQuotasToShow.setVisible(true);
		compareQuotasToShow.bringToFront();
	}

	/**
	 * Change image.
	 * 
	 * @param imageNumber
	 *            the image number
	 */
	private void changeImage(int imageNumber) {
		listImgs.get(lastEventNumber).animateHide(AnimationEffect.FADE,
				callback);
		animateShow(listImgs.get(imageNumber), AnimationEffect.SLIDE, "L");
	}

	/**
	 * Change transparent label.
	 * 
	 * @param imageNumber
	 *            the image number
	 * @param response
	 *            the response
	 * @param responseOk
	 *            the response ok
	 */
	private void changeTransparentLabel(int imageNumber,
			ImageSliderUpdateResponseTo response, boolean responseOk) {
		listTransparentLabels.get(lastEventNumber).setVisible(false);
		listTransparentLabels.get(lastEventNumber).sendToBack();
		TransparentWidget transparentLabelToShow = listTransparentLabels
				.get(imageNumber);
		if (responseOk && eventOk.get(imageNumber)) {
			transparentLabelToShow.updateTableData(response);
		} else {
			listTransparentLabels.set(imageNumber, new TransparentWidget());
			transparentLabelToShow = listTransparentLabels.get(imageNumber);
		}
		transparentLabelToShow.setVisible(true);
		transparentLabelToShow.bringToFront();
	}

	/**
	 * Call to service.
	 * 
	 * @return the all event data
	 */
	private void getAllEventData() {
		IImageSliderService service = getImageSliderService();
		ImageSliderRequestTo request = new ImageSliderRequestTo();
		service.getEventData(
				request,
				new AbstractServiceMethodCallback<List<ImageSliderResponseTo>>() {
					@Override
					public void onSuccessActions(Method pMethod,
							List<ImageSliderResponseTo> pResponse) {
						allEventData = pResponse;
						for (int i = 0; i < pResponse.size(); i++) {
							eventLoaded.add(false);
							eventOk.add(false);
							listCompareQuotasLabels.add(null);
							listImgs.add(null);
							listTransparentLabels.add(null);
						}
						loadEvent(currentEventNumber);
						loadButtons(pResponse.size());
						timer.scheduleRepeating(changeEventTime);
					}
				});
	}

	/**
	 * Gets the new odd.
	 * 
	 * @param eventNumber
	 *            the event number
	 * @return the new odd
	 */
	private void getEventDataUpdate(final int eventNumber) {
		Log.debug("getEventDataUpdate, eventNumber = " + eventNumber);
		IImageSliderService service = getImageSliderService();
		ImageSliderRequestTo request = new ImageSliderRequestTo();
		request.setEventId(allEventData.get(eventNumber).getEventId());
		request.setBetTypeId(allEventData.get(eventNumber).getBetTypeId());
		request.setBetTypeEventId(allEventData.get(eventNumber).getBetTypeEventId());
		service.getEventDataUpdate(
				request,
				new AbstractServiceMethodCallback<ImageSliderUpdateResponseTo>() {
					@Override
					public void onSuccessActions(Method pMethod,
							ImageSliderUpdateResponseTo pResponse) {
						if (pResponse == null
								|| (pResponse != null && (pResponse.getTable() == null))) {
							Log.warn("ImageSliderUpdateResponseTo is null or has no data --> reset ImageSlider");
							timer.cancel();
							resetImageSlider();
							initImageSlider();
						} else {
							boolean responseOk = verifyTableData(pResponse
									.getTable());
							changeImage(eventNumber);
							changeTransparentLabel(eventNumber, pResponse,
									responseOk);
							changeCompareQuotas(eventNumber, pResponse,
									responseOk);
							currentEventNumber = eventNumber;
						}
					}
				});
	}

	/**
	 * Gets the image slider service.
	 * 
	 * @return the image slider service
	 */
	private IImageSliderService getImageSliderService() {
		IImageSliderService service = (IImageSliderService) ServiceFactory
				.getInstance().getService(GWT.create(ImageSliderService.class),
						GWT.create(ImageSliderDummyService.class));
		return service;
	}

	/**
	 * Inits the image slider.
	 */
	public void initImageSlider() {
		Log.info("initImageSlider()");
		getAllEventData();
		setHeight(HEIGHT);
		setWidth(WIDTH);
	}

	/**
	 * Checks if is double.
	 * 
	 * @param stringValue
	 *            the string value
	 * @return true, if is double
	 */
	private boolean isDouble(String stringValue) {
		try {
			Double.parseDouble(stringValue);
		} catch (NumberFormatException e) {
			return false;
		}
		return true;
	}

	/**
	 * Load botones.
	 * 
	 * @param numberOfImages
	 *            the number of images
	 */
	private void loadButtons(int numberOfImages) {
		Log.info("loadButtons");
		buttonLayout = new HLayout();
		buttonLayout.setMembersMargin(10);
		buttonLayout.setStyleName(STYLE_NAME_BUTTON_LAYOUT);
		for (int buttonNumber = 0; buttonNumber < numberOfImages; buttonNumber++) {
			final ImgButton imgButton = new ImgButton();
			imgButton.setWidth(BUTTON_WIDTH);
			imgButton.setHeight(BUTTON_HEIGHT);
			imgButton.setShowRollOver(true);
			imgButton.setShowDown(true);
			buttonLayout.addMember(imgButton);
			final int eventNumber = buttonNumber;
			imgButton.addClickHandler(new ClickHandler() {
				public void onClick(ClickEvent event) {
					// Resetear timer
					timer.cancel();
					timer.scheduleRepeating(changeEventTime);
					lastEventNumber = currentEventNumber;
					currentEventNumber = eventNumber;
					imgButton.setSelected(true);
					listImgButtons.get(lastEventNumber).setSelected(false);
					if (!eventLoaded.get(eventNumber)) {
						loadEvent(eventNumber);
					} else {
						getEventDataUpdate(eventNumber);
					}
				}
			});
			listImgButtons.add(imgButton);
		}
		listImgButtons.get(currentEventNumber).setSelected(true);
		addChild(buttonLayout);
		buttonLayout.bringToFront();
	}

	/**
	 * Load compare quotas.
	 * 
	 * @param eventNumber
	 *            the event number
	 * @param responseOk
	 *            the response ok
	 */
	private void loadCompareQuotas(int eventNumber, boolean responseOk) {
		Log.debug("loadCompareQuotas");
		CompareQuotasWidget compareQuotas;
		if (responseOk) {
			compareQuotas = new CompareQuotasWidget(
					allEventData.get(eventNumber));
		} else {
			compareQuotas = new CompareQuotasWidget();
		}
		compareQuotas.setLeft(COMPARE_QUOTAS_LEFT);
		listCompareQuotasLabels.set(eventNumber, compareQuotas);
		addChild(compareQuotas);
	}

	/**
	 * Load first event.
	 * 
	 * @param eventNumber
	 *            the event number
	 */
	private void loadEvent(int eventNumber) {
		Log.debug("loadEvent: " + eventNumber);

		loadImage(eventNumber);
		if (eventNumber == 0 && eventLoaded.size() > 0
				&& eventLoaded.get(0) == false) {
			listImgs.get(eventNumber).setVisible(true);
			listImgs.get(eventNumber).bringToFront();
		} else {
			listImgs.get(lastEventNumber).animateHide(AnimationEffect.FADE,
					callback);
			animateShow(listImgs.get(eventNumber), AnimationEffect.SLIDE, "L");
		}

		boolean responseOk = verifyResponse(allEventData.get(eventNumber));
		if (!responseOk) {
			eventOk.set(eventNumber, false);
			Log.warn("Faltan datos en la respuesta y no se va a mostrar ningun dato del evento "
					+ eventNumber);
		} else {
			eventOk.set(eventNumber, true);
		}

		loadTransparentLabel(eventNumber, responseOk);
		listTransparentLabels.get(lastEventNumber).setVisible(false);
		listTransparentLabels.get(lastEventNumber).sendToBack();
		listTransparentLabels.get(eventNumber).setVisible(true);
		listTransparentLabels.get(eventNumber).bringToFront();

		loadCompareQuotas(eventNumber, responseOk);
		listCompareQuotasLabels.get(lastEventNumber).setVisible(false);
		listCompareQuotasLabels.get(lastEventNumber).sendToBack();
		listCompareQuotasLabels.get(eventNumber).setVisible(true);
		listCompareQuotasLabels.get(eventNumber).bringToFront();

		eventLoaded.set(eventNumber, true);
	}

	/**
	 * Load image.
	 * 
	 * @param eventNumber
	 *            the event number
	 */
	private void loadImage(int eventNumber) {
		Log.debug("loadImage");
		EventImage img;
		if (allEventData.get(eventNumber).getResource() != null
				&& allEventData.get(eventNumber).getResource().getLocation() != null) {
			img = new EventImage(allEventData.get(eventNumber).getResource()
					.getLocation());
		} else {
			Log.warn("No se ha especificado ninguna imagen para el evento");
			img = new EventImage();
		}
		img.setParentElement(this);
		listImgs.set(eventNumber, img);
	}

	/**
	 * Load transparent label.
	 * 
	 * @param eventNumber
	 *            the event number
	 * @param responseOk
	 *            the response ok
	 */
	private void loadTransparentLabel(int eventNumber, boolean responseOk) {
		Log.info("loadTransparentLabel");
		TransparentWidget transparent;
		if (responseOk) {
			transparent = new TransparentWidget(allEventData.get(eventNumber));
		} else {
			transparent = new TransparentWidget();
		}
		transparent.setLeft(TRANSPATENT_LABEL_LEFT);
		listTransparentLabels.set(eventNumber, transparent);
		addChild(transparent);
	}

	/**
	 * Reset image slider.
	 */
	private void resetImageSlider() {
		Log.debug("resetImageSlider");
		for (int i = 0; i < allEventData.size(); i++) {
			if (eventLoaded.get(i)) {
				listCompareQuotasLabels.get(i).setVisible(false);
				listImgs.get(i).setVisible(false);
				listTransparentLabels.get(i).setVisible(false);

				listCompareQuotasLabels.get(i).destroy();
				listImgs.get(i).destroy();
				listTransparentLabels.get(i).destroy();
			}
		}
		currentEventNumber = 0;
		lastEventNumber = 0;
		listImgButtons.clear();
		listCompareQuotasLabels.clear();
		listImgs.clear();
		listTransparentLabels.clear();
		allEventData.clear();
		eventLoaded.clear();
		eventOk.clear();
	}

	/**
	 * Stop timer.
	 */
	public void stopTimer() {
		timer.cancel();
	}

	/**
	 * Verify response.
	 * 
	 * @param response
	 *            the response
	 * @return true, if successful
	 */
	private boolean verifyResponse(ImageSliderResponseTo response) {
		boolean eventLinkOk;
		boolean competitionLinkOk;
		boolean eventDateOk;
		boolean betTypeOk;
		if (response != null && verifyTableData(response.getTable())) {
			eventLinkOk = response.getEventLink() != null
					&& response.getEventLink().getName() != null
					&& response.getEventLink().getObjectToId() != null
					&& response.getEventLink().getObjectToId().getId() != null
					&& response.getEventLink().getObjectToIdAux() != null
					&& response.getEventLink().getObjectToIdAux().getId() != null;
			competitionLinkOk = response.getCompetitionLink() != null
					&& response.getCompetitionLink().getName() != null
					&& response.getCompetitionLink().getObjectToId() != null
					&& response.getCompetitionLink().getObjectToId().getId() != null;
			eventDateOk = response.getEventDate() != null;
			betTypeOk = response.getBetType() != null;
			if (!eventLinkOk || !competitionLinkOk || !eventDateOk
					|| !betTypeOk) {
				return false;
			}
		} else {
			return false;
		}
		return true;
	}

	/**
	 * Verify table data.
	 * 
	 * @param response
	 *            the response
	 * @return true, if successful
	 */
	private boolean verifyTableData(TableResponseTo response) {
		boolean partNameOk;
		boolean oddOk;
		boolean bookmakerImgOk;
		boolean responseOk = response != null && response.getRows() != null;
		if (responseOk) {
			for (TableResponseRowTo row : response.getRows()) {
				List<TableResponseCellTo> cellData = row.getCellList();
				partNameOk = cellData.get(0) != null
						&& cellData.get(0).getValueTo() != null && cellData.get(0).getValueTo().getValueStr() != null;
				oddOk = cellData.get(1) != null
						&& cellData.get(1).getValueTo() != null && cellData.get(1).getValueTo().getValueStr() != null;
				bookmakerImgOk = cellData.get(2) != null
						&& cellData.get(2).getExternalLinkTo() != null
						&& cellData.get(2).getExternalLinkTo()
								.getLinkImgLocation() != null
						&& cellData.get(2).getExternalLinkTo().getUrl() != null;
				if (!partNameOk || !oddOk || !bookmakerImgOk) {
					return false;
				}
			}
		} else {
			return false;
		}
		return true;
	}

}
