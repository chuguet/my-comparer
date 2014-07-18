/**
 *
 * Copyright (C) FACTORIA ETSIA S.L.
 * All Rights Reserved.
 * www.factoriaetsia.com
 *
 */
package com.comparadorad.bet.comparer.web.server.mvc.imageslider.control;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.inject.Inject;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.comparadorad.bet.comparer.model.bet.bean.CfgImageSlider;
import com.comparadorad.bet.comparer.model.bet.bean.RtMarket;
import com.comparadorad.bet.comparer.model.bet.bean.RtMatch;
import com.comparadorad.bet.comparer.model.bet.service.ICfgImageSliderService;
import com.comparadorad.bet.comparer.model.bet.service.IRtMatchService;
import com.comparadorad.bet.comparer.model.config.bean.CfgBetType;
import com.comparadorad.bet.comparer.model.config.bean.CfgBetTypeEvent;
import com.comparadorad.bet.comparer.model.core.bean.user.UserData;
import com.comparadorad.bet.comparer.util.cache.CacheRegion;
import com.comparadorad.bet.comparer.util.cache.aop.AsynchronousCacheable;
import com.comparadorad.bet.comparer.web.client.gwt.imageslider.bean.request.ImageSliderRequestTo;
import com.comparadorad.bet.comparer.web.client.gwt.imageslider.bean.response.ImageSliderResponseTo;
import com.comparadorad.bet.comparer.web.client.gwt.imageslider.bean.response.ImageSliderUpdateResponseTo;
import com.comparadorad.bet.comparer.web.server.mvc.core.control.AbstractComparerController;
import com.comparadorad.bet.comparer.web.server.mvc.imageslider.factory.IObjectResponseFactory;
import com.comparadorad.bet.comparer.web.server.mvc.imageslider.table.IMakeTableImageSlider;

/**
 * Controlador de la Image Slider
 */
@Controller
@RequestMapping("/imageSliderController")
public class ImageSliderController extends AbstractComparerController {

	/** The Constant LOG. */
	private static final Log LOG = LogFactory.getLog(ImageSliderController.class);

	/** The factory. */
	@Inject
	private IObjectResponseFactory factory;

	@Inject
	private IRtMatchService matchService;

	@Inject
	private ICfgImageSliderService iImageSliderConfigService;

	/**
	 * Gets the event data.
	 * 
	 * @param imageSliderRequestTo
	 *            the image slider request to
	 * @param userData
	 *            the user data
	 * @return the event data
	 */
	@AsynchronousCacheable(CacheRegion.IMAGESLIDER)
	@RequestMapping(value = "/getEventData", method = RequestMethod.POST)
	@ResponseBody
	public List<ImageSliderResponseTo> getEventData(@RequestBody final ImageSliderRequestTo imageSliderRequestTo, final UserData userData) {
		RtMatch match;
		IMakeTableImageSlider iMakeTableImageSlider;
		Boolean random = Boolean.FALSE;
		
		List<ImageSliderResponseTo> result = new ArrayList<ImageSliderResponseTo>();
		Iterable<CfgImageSlider> views = iImageSliderConfigService.findAll();

		if(views != null) {
			for (CfgImageSlider view : views) {
				match = matchService.findOneCustom(view.getIdMatch());
				if(match!=null){
					LOG.debug(new StringBuffer("Se recupera un partido por configuracion con nombre ").append(match.getName(null)));
				} else{
					LOG.debug(new StringBuffer("No se ha podido recuperar el partido configurado en base de datos con id: ")
									.append(view.getIdMatch()).toString());
					random = Boolean.TRUE;
				}
				match = checkMatchAvailability(match, view.getBetType(), view.getBetTypeEvent());
				if(match!=null && random){
					LOG.debug(new StringBuffer("Se recupera un partido aleatorio con nombre ").append(match.getName(null)));
				}
				view.setMatch(match);
				iMakeTableImageSlider = factory.makeTableImageSlider(view.getBetType());
				result.add(iMakeTableImageSlider.makeTable(view, userData));
			}
		}

		return result;
	}

	/**
	 * Gets the event data update.
	 * 
	 * @param imageSliderRequestTo
	 *            the image slider request to
	 * @param userData
	 *            the user data
	 * @return the event data update
	 */
	@AsynchronousCacheable(CacheRegion.IMAGESLIDER_UPDATE)
	@RequestMapping(value = "/getEventDataUpdate", method = RequestMethod.POST)
	@ResponseBody
	public ImageSliderUpdateResponseTo getEventDataUpdate(@RequestBody final ImageSliderRequestTo imageSliderRequestTo,
			final UserData userData) {
		RtMatch match = matchService.findOneCustom(imageSliderRequestTo.getEventId().getId().toString());
		RtMarket market = null;
		for (RtMarket m : match.getRtMarkets()) {
			if (m.getBetType().getObjectId().toString().equals(imageSliderRequestTo.getBetTypeId().getId())
					&& m.getBetTypeEvent().getBetTypeEvent().getObjectId().toString().equals(imageSliderRequestTo.getBetTypeEventId().getId())) {
				market = m;
				break;
			}
		}
		CfgImageSlider cfgImageSlider = new CfgImageSlider();
		
		cfgImageSlider.setMatch(match);
		cfgImageSlider.setBetType(market.getBetType());
		cfgImageSlider.setBetTypeEvent(market.getBetTypeEvent().getBetTypeEvent());
		IMakeTableImageSlider iMakeTableImageSlider;
		
		iMakeTableImageSlider = factory.makeTableImageSlider(market.getBetType());
		
		return iMakeTableImageSlider.makeTableUpdate(cfgImageSlider, userData);
	}

	/**
	 * Método que devuelve el partido en caso de estar activo y sino devuelve
	 * uno activo recuperado al azar de BD.
	 * 
	 * @param match
	 *            recuperado de la configuracion del imageSlider.
	 * @return match activo.
	 */
	private RtMatch checkMatchAvailability(final RtMatch match, final CfgBetType betType, final CfgBetTypeEvent betTypeEvent) {
		RtMatch result = match;
		if (match == null || !match.isActive(new Date()) || match.getStartDate().getZeroGmtMatchDate().before(new Date())) {
			LOG.debug("El evento no está activo con lo que buscamos uno aleatorio en BD");
			result = matchService.findActiveMatch(betType.getObjectId().toString(), betTypeEvent.getObjectId().toString());
		} else{
			LOG.debug("El evento está activo con lo que no buscamos uno aleatorio en BD");
		}

		return result;
	}

}
