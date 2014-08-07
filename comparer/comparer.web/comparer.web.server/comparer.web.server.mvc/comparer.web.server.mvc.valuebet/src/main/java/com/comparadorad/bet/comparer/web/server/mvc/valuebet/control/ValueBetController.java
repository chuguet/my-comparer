/**
 *
 * Copyright (C) FACTORIA ETSIA S.L.
 * All Rights Reserved.
 * www.factoriaetsia.com
 *
 */
package com.comparadorad.bet.comparer.web.server.mvc.valuebet.control;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.comparadorad.bet.comparer.model.bet.bean.RtBet;
import com.comparadorad.bet.comparer.model.core.bean.enume.LiferayRoles;
import com.comparadorad.bet.comparer.model.core.bean.user.UserData;
import com.comparadorad.bet.comparer.model.valuebet.bean.InfoMatch;
import com.comparadorad.bet.comparer.model.valuebet.bean.ValueBetData;
import com.comparadorad.bet.comparer.model.valuebet.bean.ValueBetMathematicalExpectation;
import com.comparadorad.bet.comparer.model.valuebet.bean.ValueBetProbability;
import com.comparadorad.bet.comparer.model.valuebet.service.IValueBetService;
import com.comparadorad.bet.comparer.util.commons.betOdds.FormatterUtil;
import com.comparadorad.bet.comparer.web.client.gwt.common.bean.ExternalLinkTo;
import com.comparadorad.bet.comparer.web.client.gwt.common.bean.ValueTo;
import com.comparadorad.bet.comparer.web.client.gwt.common.bean.table.TableResponseCellTo;
import com.comparadorad.bet.comparer.web.client.gwt.common.bean.table.TableResponseRowTo;
import com.comparadorad.bet.comparer.web.client.gwt.common.bean.table.TableResponseTo;
import com.comparadorad.bet.comparer.web.client.gwt.valuebet.bean.request.ValueBetRequestTo;
import com.comparadorad.bet.comparer.web.client.gwt.valuebet.bean.response.ValueBetResponseTo;
import com.comparadorad.bet.comparer.web.server.mvc.core.control.AbstractComparerController;
import com.comparadorad.bet.comparer.web.server.mvc.valuebet.control.factory.AbstractTableValuebetFactory;
import com.comparadorad.bet.comparer.web.server.redirection.conversor.IUrlConversor;
import com.comparadorad.bet.comparer.web.server.redirection.factory.IUrlFactory;

/**
 * The Class SecureBetController.
 */
@Controller
@RequestMapping("/valueBetController")
public class ValueBetController extends AbstractComparerController {

	/** The value bet service. */
	@Inject
	private IValueBetService valueBetService;

	@Inject
	private IUrlFactory urlFactory;

	@Inject
	private List<AbstractTableValuebetFactory> valuebetFactory;

	private final int pageSize = 10;

	/**
	 * Gets the secure bet.
	 * 
	 * @param valueBetRequestTo
	 *            the value bet request to
	 * @param userData
	 *            the user data
	 * @return the secure bet
	 */
	@RequestMapping(value = "/getValueBet", method = RequestMethod.POST)
	@ResponseBody
	public ValueBetResponseTo getValueBet(
			@RequestBody final ValueBetRequestTo valueBetRequestTo,
			final UserData userData) {
		ValueBetResponseTo valueBetResponseTo = new ValueBetResponseTo();
		Iterable<ValueBetData> valueBetsData = null;
		if (userData.getRoles() != null) {
			long count = valueBetService.getCount();
			long page;
			valueBetResponseTo.setCount(count);
			if ((count / pageSize) < valueBetRequestTo.getPageNum()) {
				page = (count / pageSize);
			} else {
				page = valueBetRequestTo.getPageNum();
			}

			for (LiferayRoles rol : (userData.getRoles().getRoles())) {
				if (LiferayRoles.UNREGISTERED.getId() == rol.getId()) {// usuario
																		// no
																		// registrado
																		// solo
																		// le
																		// mostramos
																		// 10
																		// value
																		// bet.
					valueBetsData = valueBetService
							.getValueBetPage(pageSize, 5);
					valueBetResponseTo.setNoPaymentUser(true);
					break;
				} else if (LiferayRoles.FREE.getId() == rol.getId()
						|| LiferayRoles.LEVEL_1.getId() == rol.getId()
						|| LiferayRoles.LEVEL_2.getId() == rol.getId()
						|| LiferayRoles.LEVEL_3.getId() == rol.getId()
						|| LiferayRoles.SPECIAL_LEVEL_0.getId() == rol.getId()) {
					// a los demas usuarios les mostramos todas paginadas
					valueBetsData = valueBetService.getValueBetPage(pageSize,
							page);
					break;
				}
			}
		} else {
			valueBetsData = valueBetService.getValueBetPage(50, 0);
		}
		valueBetResponseTo.setTableResponseTo(new TableResponseTo());
		int valuebetCount = 0;
		for (ValueBetData valueBetData : valueBetsData) {
			valueBetResponseTo.getTableResponseTo().add(
					getTableResponseToForValueBet(valueBetData, userData));
			valuebetCount++;
		}
		if (valuebetCount < pageSize) {// hay que añadir el caso en que justo la
										// ultima pagina tiene 10 elementos.
			valueBetResponseTo.setLastPage(true);
		}
		return valueBetResponseTo;
	}

	/**
	 * Do table response to for value bet.
	 * 
	 * @param valueBetData
	 *            the value bet data
	 * @param userData
	 *            the user data
	 * @return the table response row to
	 */
	public TableResponseRowTo getTableResponseToForValueBet(
			final ValueBetData valueBetData, final UserData userData) {
		TableResponseRowTo result = new TableResponseRowTo();

		InfoMatch match = valueBetData.getInfoMatch();
		String betTypeEventId = valueBetData.getBetTypeEvent().getBetTypeEvent().getObjectId().toString();
		RtBet bet = valueBetData.getBet();
		ValueBetProbability probability = valueBetData.getProbability();
		ValueBetMathematicalExpectation mathematicalExpectation = valueBetData
				.getExpectation();

		for (AbstractTableValuebetFactory table : valuebetFactory) {
			if (table.getBetType().nameId()
					.equals(bet.getBetType().getNameId())) {
				result.setObjectToId(table.makeObjectId(match, bet));
				result.add(table.makeEventCell(betTypeEventId, match, userData));
				result.add(table.getBetTypeCell(bet, userData));
				result.add(table.makeResulCell(bet, userData));
				break;
			}

		}
		result.add(getBookmakerCell(bet, userData));
		result.add(getOddsCell(bet, userData));
		result.add(getProbability(probability));
		result.add(getMathematicalExpectation(mathematicalExpectation));

		return result;
	}

	/**
	 * Gets the bookmaker cell.
	 * 
	 * @param rtBet
	 *            the rt bet
	 * @param userData
	 *            the user data
	 * @return the bookmaker cell
	 */
	private TableResponseCellTo getBookmakerCell(final RtBet rtBet,
			final UserData userData) {
		TableResponseCellTo result = new TableResponseCellTo();
		ExternalLinkTo externalLinkTo = new ExternalLinkTo();

		externalLinkTo.setLinkImgLocation(rtBet.getBookmaker().getResourceMeduimImg()
				.getLocation());
		IUrlConversor conversor = urlFactory.makeUrlConversor(rtBet
				.getBookmaker().getObjectId().toString());
		externalLinkTo
				.setUrl(conversor.makeUrl(rtBet.getWebUrl().getUrl(), ""));
		externalLinkTo.setActionAnalytics(rtBet.getBookmaker().getNameId());
		externalLinkTo.setCategoryAnalytics("valuebets");
		result.setExternalLinkTo(externalLinkTo);

		return result;
	}

	/**
	 * Gets the odds cell.
	 * 
	 * @param rtBet
	 *            the rt bet
	 * @param userData
	 *            the user data
	 * @return the odds cell
	 */
	private TableResponseCellTo getOddsCell(final RtBet rtBet,
			final UserData userData) {
		TableResponseCellTo result = new TableResponseCellTo();
		ExternalLinkTo externalLinkTo = new ExternalLinkTo();

		String formattedOdd = FormatterUtil.formatBet(rtBet.getBetOdd()
				.getOdds(), NUMBER_DIGITS_BET_FORMAT);
		externalLinkTo.setLinkText(formattedOdd);
		IUrlConversor conversor = urlFactory.makeUrlConversor(rtBet
				.getBookmaker().getObjectId().toString());
		externalLinkTo
				.setUrl(conversor.makeUrl(rtBet.getWebUrl().getUrl(), ""));
		externalLinkTo.setActionAnalytics(rtBet.getBookmaker().getNameId());
		externalLinkTo.setCategoryAnalytics("valuebets");
		result.setExternalLinkTo(externalLinkTo);

		return result;
	}

	/**
	 * Gets the probability.
	 * 
	 * @param probability
	 *            the probability
	 * @return the probability
	 */
	private TableResponseCellTo getProbability(
			final ValueBetProbability probability) {
		TableResponseCellTo result = new TableResponseCellTo();
		ValueTo valueTo = new ValueTo();
		StringBuffer buffer = new StringBuffer();
		buffer.append(
				FormatterUtil.formatBet(String.valueOf(probability.getValue()),
						NUMBER_DIGITS_BET_FORMAT)).append("%");
		valueTo.setValueStr(buffer.toString());
		result.setValueTo(valueTo);

		return result;
	}

	/**
	 * Gets the mathematical expectation.
	 * 
	 * @param expectation
	 *            the expectation
	 * @return the mathematical expectation
	 */
	private TableResponseCellTo getMathematicalExpectation(
			final ValueBetMathematicalExpectation expectation) {
		TableResponseCellTo result = new TableResponseCellTo();
		ValueTo valueTo = new ValueTo();

		valueTo.setValueStr(FormatterUtil.formatBet(
				String.valueOf(expectation.getValue()),
				NUMBER_DIGITS_BET_FORMAT));
		result.setValueTo(valueTo);

		return result;
	}

}
