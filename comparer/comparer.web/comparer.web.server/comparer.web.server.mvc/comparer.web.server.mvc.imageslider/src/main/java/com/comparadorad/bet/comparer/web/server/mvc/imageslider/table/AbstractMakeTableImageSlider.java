/**
 *
 * Copyright (C) FACTORIA ETSIA S.L.
 * All Rights Reserved.
 * www.factoriaetsia.com
 *
 */
package com.comparadorad.bet.comparer.web.server.mvc.imageslider.table;

import java.util.Date;
import java.util.List;

import javax.inject.Inject;

import com.comparadorad.bet.comparer.model.bet.bean.CfgImageSlider;
import com.comparadorad.bet.comparer.model.bet.bean.RtBet;
import com.comparadorad.bet.comparer.model.bet.bean.RtMarket;
import com.comparadorad.bet.comparer.model.config.bean.CfgBetType;
import com.comparadorad.bet.comparer.model.config.bean.CfgBetTypeEvent;
import com.comparadorad.bet.comparer.model.core.bean.user.UserData;
import com.comparadorad.bet.comparer.util.commons.betOdds.FormatterUtil;
import com.comparadorad.bet.comparer.web.client.gwt.common.bean.ExternalLinkTo;
import com.comparadorad.bet.comparer.web.client.gwt.common.bean.LinkTo;
import com.comparadorad.bet.comparer.web.client.gwt.common.bean.ObjectToId;
import com.comparadorad.bet.comparer.web.client.gwt.common.bean.ValueTo;
import com.comparadorad.bet.comparer.web.client.gwt.common.bean.cfg.response.ResourceTo;
import com.comparadorad.bet.comparer.web.client.gwt.common.bean.literal.CommonLiterals;
import com.comparadorad.bet.comparer.web.client.gwt.common.bean.table.TableResponseCellTo;
import com.comparadorad.bet.comparer.web.client.gwt.common.bean.table.TableResponseRowTo;
import com.comparadorad.bet.comparer.web.client.gwt.common.bean.table.TableResponseTo;
import com.comparadorad.bet.comparer.web.client.gwt.imageslider.bean.response.ImageSliderResponseTo;
import com.comparadorad.bet.comparer.web.client.gwt.imageslider.bean.response.ImageSliderUpdateResponseTo;
import com.comparadorad.bet.comparer.web.server.mvc.core.beans.DateUtilJava;
import com.comparadorad.bet.comparer.web.server.mvc.core.util.UtilBets;
import com.comparadorad.bet.comparer.web.server.redirection.conversor.IUrlConversor;
import com.comparadorad.bet.comparer.web.server.redirection.factory.IUrlFactory;

/**
 * The Class AbstractMakeTable.
 */
public abstract class AbstractMakeTableImageSlider implements
		IMakeTableImageSlider {

	/** The Constant LIMIT_BETS. */
	private static final Integer LIMIT_BETS = 3;

	/** The NUMBE r_ digit s_ be t_ format. */
	protected static int NUMBER_DIGITS_BET_FORMAT = 2;

	/** The DRAW. */
	private final String DRAW = CommonLiterals.getEmpate();

	/** The url factory. */
	@Inject
	private IUrlFactory urlFactory;

	/** The util bets. */
	@Inject
	private UtilBets utilBets;

	/**
	 * Find best odd.
	 * 
	 * @param home
	 *            the home
	 * @param away
	 *            the away
	 * @param rtmarket
	 *            the rtmarket
	 * @return the rt bet
	 */
	protected RtBet findBestOdd(boolean home, boolean away, RtMarket rtmarket) {
		RtBet greatestBet = new RtBet();
		boolean firtstime = true;
		for (RtBet betIterator : rtmarket.getBets()) {
			if (betIterator.getParticipant().isAwayParticipant() == away
					&& betIterator.getParticipant().isHomeParticipant() == home) {
				if (firtstime) {
					greatestBet = betIterator;
					firtstime = false;
				} else {
					if (Double.parseDouble(betIterator.getBetOdd().getOdds()) > Double
							.parseDouble(greatestBet.getBetOdd().getOdds())) {
						greatestBet = betIterator;
					}
				}

			}
		}
		return greatestBet;
	}

	/**
	 * Gets the bets in order.
	 * 
	 * @param market
	 *            the market
	 * @return the bets in order
	 */
	protected List<RtBet> getBetsInOrder(RtMarket market) {
		return utilBets.getGreaterBetsLimit(market.getBets(), LIMIT_BETS);
	}

	/**
	 * Gets the row.
	 * 
	 * @param bet
	 *            the bet
	 * @param userData
	 *            the user data
	 * @param is1x2
	 *            the is1x2
	 * @return the row
	 */
	public TableResponseRowTo getrow(RtBet bet, UserData userData, boolean is1x2, String categoryAnalytics) {
		TableResponseRowTo result = new TableResponseRowTo();
		TableResponseCellTo name = new TableResponseCellTo();
		// CELL 0
		if (isDraw(bet) && is1x2) {
			name.setValueTo(new ValueTo(null, DRAW));
		} else {
			name.setValueTo(new ValueTo(null, bet.getParticipant()
					.getCfgParticipant().getName(userData.getLocale())));
		}
		result.add(name);
		// CELL 1
		TableResponseCellTo odd = new TableResponseCellTo();
		odd.setValueTo(new ValueTo(null, FormatterUtil.formatBet(bet
				.getBetOdd().getOdds(), NUMBER_DIGITS_BET_FORMAT)));
		result.add(odd);
		// CELL 2
		IUrlConversor conversor = urlFactory.makeUrlConversor(bet
				.getBookmaker().getObjectId().toString());
		TableResponseCellTo img = new TableResponseCellTo();
		ExternalLinkTo imgLinkTo = new ExternalLinkTo();
		imgLinkTo.setUrl(conversor.makeUrl(bet.getWebUrl().getUrl(), bet
				.getBookmaker().getBookmakerConfiguration().getIdAfiliado()));
		imgLinkTo.setLinkImgLocation(bet.getBookmaker().getResourceSmallImg()
				.getLocation());
		imgLinkTo.setActionAnalytics(bet.getBookmaker().getNameId());
		imgLinkTo.setCategoryAnalytics(categoryAnalytics);
		img.setExternalLinkTo(imgLinkTo);
		result.add(img);

		return result;

	}

	/**
	 * Gets the rows.
	 * 
	 * @param view
	 *            the view
	 * @param userData
	 *            the user data
	 * @return the rows
	 */
	public abstract TableResponseTo getRows(CfgImageSlider view,
			UserData userData);

	/**
	 * Checks if is draw.
	 * 
	 * @param bet
	 *            the bet
	 * @return true, if is draw
	 */
	private boolean isDraw(RtBet bet) {
		return !bet.getParticipant().isAwayParticipant()
				&& !bet.getParticipant().isHomeParticipant();
	}

	/**
	 * Checks if is market.
	 * 
	 * @param market
	 *            the market
	 * @param betType
	 *            the bet type
	 * @param betTypeEvent
	 *            the bet type event
	 * @return true, if is market
	 */
	protected boolean isMarket(RtMarket market, CfgBetType betType,
			CfgBetTypeEvent betTypeEvent) {
		return market.getBetType().getNameId().equals(betType.getNameId())
				&& market.getBetTypeEvent().getBetTypeEvent().getNameId()
						.equals(betTypeEvent.getNameId());
	}

	/**
	 * Make table.
	 * 
	 * @param view
	 *            the view
	 * @param userData
	 *            the user data
	 * @return the image slider response to {@inheritDoc}
	 */
	@Override
	public ImageSliderResponseTo makeTable(CfgImageSlider view,
			UserData userData) {
		ImageSliderResponseTo result = new ImageSliderResponseTo();
		ResourceTo img;
		try {

			result.setBetType(view.getBetType().getName(userData.getLocale()));
			result.setBetTypeId(new ObjectToId(view.getBetType().getObjectId()
					.toString()));
			result.setBetTypeEventId(new ObjectToId(view.getBetTypeEvent()
					.getObjectId().toString()));
			LinkTo competitionlinkTo = new LinkTo(view.getMatch().getMatchId()
					.getCompetition().getName(userData.getLocale()),
					new ObjectToId(view.getMatch().getMatchId()
							.getCompetition().getObjectId().toString()),
					new ObjectToId(getBetTypeId().id()));
			result.setCompetitionLink(competitionlinkTo);

			Date dateAux = DateUtilJava
					.convertSistemDependentDateToDesiredTimeZone(view
							.getMatch().getMatchId().getStartDate()
							.getZeroGmtMatchDate(), userData.getTimeZone());
			result.setEventDate(DateUtilJava.dateToString(dateAux));

			result.setEventId(new ObjectToId(view.getMatch().getObjectId()
					.toString()));
			LinkTo matchLinkTo = new LinkTo(view.getMatch().getName(
					userData.getLocale()), new ObjectToId(view.getMatch()
					.getObjectId().toString()), new ObjectToId(getBetTypeId()
					.id()));
			result.setEventLink(matchLinkTo);
			img = new ResourceTo(view.getImageLocation());
			result.setResource(img);
			result.setTable(getRows(view, userData));

		} catch (NullPointerException e) {
			img = new ResourceTo(view.getImageLocation());
			result.setResource(img);
		}

		return result;
	}

	/**
	 * Make table update.
	 * 
	 * @param view
	 *            the view
	 * @param userData
	 *            the user data
	 * @return the image slider update response to {@inheritDoc}
	 */
	public ImageSliderUpdateResponseTo makeTableUpdate(CfgImageSlider view,
			UserData userData) {
		ImageSliderUpdateResponseTo result = new ImageSliderUpdateResponseTo();

		result.setTable(getRows(view, userData));

		return result;

	}

}
