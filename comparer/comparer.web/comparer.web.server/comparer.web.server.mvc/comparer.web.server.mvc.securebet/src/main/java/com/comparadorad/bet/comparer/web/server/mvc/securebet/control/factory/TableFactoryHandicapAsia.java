/**
 *
 * Copyright (C) FACTORIA ETSIA S.L.
 * All Rights Reserved.
 * www.factoriaetsia.com
 *
 */
package com.comparadorad.bet.comparer.web.server.mvc.securebet.control.factory;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Set;

import org.springframework.stereotype.Service;

import com.comparadorad.bet.comparer.model.bet.bean.RtBet;
import com.comparadorad.bet.comparer.model.config.bean.CfgBetType.CfgBetTypeId;
import com.comparadorad.bet.comparer.model.securebet.bean.InfoMatch;
import com.comparadorad.bet.comparer.util.commons.betOdds.FormatterUtil;
import com.comparadorad.bet.comparer.web.client.gwt.common.bean.ExternalLinkTo;
import com.comparadorad.bet.comparer.web.client.gwt.common.bean.ObjectToId;
import com.comparadorad.bet.comparer.web.client.gwt.common.bean.table.TableResponseCellTo;
import com.comparadorad.bet.comparer.web.server.redirection.conversor.IUrlConversor;
import com.comparadorad.bet.comparer.web.server.redirection.factory.IUrlFactory;

/**
 * The Class TableFactoryHandicapAsia.
 */
@Service
public class TableFactoryHandicapAsia extends AbstractTableSureBetFactory {

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.comparadorad.bet.comparer.web.server.mvc.securebet.control.factory
	 * .AbstractTableSureBetFactory#getBetType()
	 */
	@Override
	public CfgBetTypeId getBetType() {
		return CfgBetTypeId.HANDICAP_ASIATICO;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.comparadorad.bet.comparer.web.server.mvc.securebet.control.factory
	 * .AbstractTableSureBetFactory
	 * #makeObjectId(com.comparadorad.bet.comparer.model
	 * .securebet.bean.InfoMatch, java.util.Date, int)
	 */
	@Override
	public ObjectToId makeObjectId(InfoMatch match, Date date, int index) {
		return new ObjectToId(new StringBuffer()
				.append(match.getObjectId().toString()).append(date.hashCode())
				.append(index).toString());
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.comparadorad.bet.comparer.web.server.mvc.securebet.control.factory
	 * .AbstractTableSureBetFactory#getbets(java.util.Set,
	 * com.comparadorad.bet.comparer.web.server.redirection.factory.IUrlFactory)
	 */
	@Override
	public TableResponseCellTo getbets(Set<RtBet> bets, IUrlFactory urlFactory) {
		TableResponseCellTo result = new TableResponseCellTo();
		List<ExternalLinkTo> externalLinkToList = new ArrayList<ExternalLinkTo>();
		ExternalLinkTo externalLinkTo;
		List<RtBet> ordernateBets = getBetsInOrder(bets);
		for (RtBet rtBet : ordernateBets) {
			externalLinkTo = new ExternalLinkTo();
			String formattedBet = FormatterUtil.formatBet(rtBet.getBetOdd()
					.getOdds(), NUMBER_DIGITS_BET_FORMAT);
			externalLinkTo.setLinkText(formattedBet);
			IUrlConversor conversor = urlFactory.makeUrlConversor(rtBet
					.getBookmaker().getObjectId().toString());
			externalLinkTo.setUrl(conversor.makeUrl(rtBet.getWebUrl().getUrl(),
					rtBet.getBookmaker().getBookmakerConfiguration()
							.getIdAfiliado()));
			externalLinkTo.setActionAnalytics(rtBet.getBookmaker().getNameId());
			externalLinkTo.setCategoryAnalytics("surebets");

			externalLinkToList.add(externalLinkTo);

		}
		result.setExternalLinkToList(externalLinkToList);
		return result;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.comparadorad.bet.comparer.web.server.mvc.securebet.control.factory
	 * .AbstractTableSureBetFactory#getBookmakers(java.util.Set,
	 * com.comparadorad.bet.comparer.web.server.redirection.factory.IUrlFactory)
	 */
	@Override
	public TableResponseCellTo getBookmakers(Set<RtBet> bets,
			IUrlFactory urlFactory) {
		TableResponseCellTo result = new TableResponseCellTo();
		List<ExternalLinkTo> externalLinkToList = new ArrayList<ExternalLinkTo>();
		ExternalLinkTo externalLinkTo;
		List<RtBet> ordernateBets = getBetsInOrder(bets);
		for (RtBet rtBet : ordernateBets) {
			externalLinkTo = new ExternalLinkTo();
			externalLinkTo.setLinkImgLocation(rtBet.getBookmaker()
					.getResourceSmallImg().getLocation());
			IUrlConversor conversor = urlFactory.makeUrlConversor(rtBet
					.getBookmaker().getObjectId().toString());
			externalLinkTo.setUrl(conversor.makeUrl(rtBet.getWebUrl().getUrl(),
					rtBet.getBookmaker().getBookmakerConfiguration()
							.getIdAfiliado()));
			externalLinkTo.setActionAnalytics(rtBet.getBookmaker().getNameId());
			externalLinkTo.setCategoryAnalytics("surebets");
			externalLinkToList.add(externalLinkTo);
		}
		result.setExternalLinkToList(externalLinkToList);
		return result;
	}
}
