/**
 *
 * Copyright (C) FACTORIA ETSIA S.L.
 * All Rights Reserved.
 * www.factoriaetsia.com
 *
 */
package com.comparadorad.bet.comparer.web.client.gwt.imageslider.ui.service;

import java.util.List;

import javax.ws.rs.POST;
import javax.ws.rs.Path;

import org.fusesource.restygwt.client.MethodCallback;

import com.comparadorad.bet.comparer.web.client.gwt.core.service.IService;
import com.comparadorad.bet.comparer.web.client.gwt.imageslider.bean.request.ImageSliderRequestTo;
import com.comparadorad.bet.comparer.web.client.gwt.imageslider.bean.response.ImageSliderResponseTo;
import com.comparadorad.bet.comparer.web.client.gwt.imageslider.bean.response.ImageSliderUpdateResponseTo;

/**
 * The Interface IImageSliderService.
 */
public interface IImageSliderService extends IService {

	/**
	 * Gets the event data.
	 * 
	 * @param request
	 *            the request
	 * @param pCallback
	 *            the callback
	 * @return the event data
	 */
	@POST
	@Path("/getEventData")
	void getEventData(ImageSliderRequestTo request,
			MethodCallback<List<ImageSliderResponseTo>> pCallback);

	/**
	 * Gets the event data update.
	 * 
	 * @param request
	 *            the request
	 * @param pCallback
	 *            the callback
	 * @return the event data update
	 */
	@POST
	@Path("/getEventDataUpdate")
	void getEventDataUpdate(ImageSliderRequestTo request,
			MethodCallback<ImageSliderUpdateResponseTo> pCallback);

}
