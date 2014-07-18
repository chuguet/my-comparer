/**
 *
 * Copyright (C) FACTORIA ETSIA S.L.
 * All Rights Reserved.
 * www.factoriaetsia.com
 *
 */
package com.comparadorad.bet.comparer.web.server.mvc.securebet.control;

import java.util.Date;
import java.util.List;

import javax.inject.Inject;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.joda.time.Interval;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.comparadorad.bet.comparer.model.core.bean.CoreDate;
import com.comparadorad.bet.comparer.model.core.bean.enume.LiferayRoles;
import com.comparadorad.bet.comparer.model.core.bean.user.Roles;
import com.comparadorad.bet.comparer.model.core.bean.user.UserData;
import com.comparadorad.bet.comparer.model.securebet.bean.CfgSureBet;
import com.comparadorad.bet.comparer.model.securebet.bean.InfoMatch;
import com.comparadorad.bet.comparer.model.securebet.bean.SecureBeanBenefit;
import com.comparadorad.bet.comparer.model.securebet.bean.SecureBeanData;
import com.comparadorad.bet.comparer.model.securebet.service.ICfgSureBetService;
import com.comparadorad.bet.comparer.model.securebet.service.ISecureBetService;
import com.comparadorad.bet.comparer.util.commons.betOdds.FormatterUtil;
import com.comparadorad.bet.comparer.web.client.gwt.common.bean.ValueTo;
import com.comparadorad.bet.comparer.web.client.gwt.common.bean.table.TableResponseCellTo;
import com.comparadorad.bet.comparer.web.client.gwt.common.bean.table.TableResponseRowTo;
import com.comparadorad.bet.comparer.web.client.gwt.common.bean.table.TableResponseTo;
import com.comparadorad.bet.comparer.web.client.gwt.securebet.bean.request.SureBetRequestTo;
import com.comparadorad.bet.comparer.web.client.gwt.securebet.bean.response.SureBetResponseTo;
import com.comparadorad.bet.comparer.web.server.mvc.core.control.AbstractComparerController;
import com.comparadorad.bet.comparer.web.server.mvc.securebet.control.factory.IValueFactory;
import com.comparadorad.bet.comparer.web.server.redirection.factory.IUrlFactory;

/**
 * The Class SecureBetController.
 */
@Controller
@RequestMapping("/secureBetController")
public class SecureBetController extends AbstractComparerController {

	/** The Constant LOG. */
	private static final Log LOG = LogFactory.getLog(SecureBetController.class);

	/** The HOURS. */
	private String HOURS = "h";

	/** The MINUTES. */
	private String MINUTES = "min";

	/** The page size. */
	private Integer pageSize = 10;

	/** The secure bet service. */
	@Inject
	private ISecureBetService secureBetService;

	/** The sure bet config service. */
	@Inject
	private ICfgSureBetService cfgSureBetService;

	/** The surebet factory. */
	@Inject
	private List<IValueFactory> surebetFactory;

	/** The url factory. */
	@Inject
	private IUrlFactory urlFactory;

	/**
	 * Gets the all sure bet.
	 * 
	 * @param sureBetRequestTo
	 *            the sure bet request to
	 * @param userData
	 *            the user data
	 * @return the all sure bet
	 */
	@RequestMapping(value = "/getAllSureBet", method = RequestMethod.POST)
	@ResponseBody
	public SureBetResponseTo getAllSureBet(
			@RequestBody final SureBetRequestTo sureBetRequestTo,
			final UserData userData) {
		LOG.debug("Se comienza el controlador de surebet");
		SureBetResponseTo result = new SureBetResponseTo();
		TableResponseTo responseTo = new TableResponseTo();

		Iterable<CfgSureBet> listConfig = cfgSureBetService.findAll();
		CfgSureBet config = listConfig.iterator().next();

		CoreDate date = processConfig(config, userData.getRoles());
		long count = secureBetService.getCount(date);
		LOG.debug(new StringBuffer("Hay un total de ").append(count)
				.append(" surebets.").toString());
		result.setCount(count);
		Long pageNum;
		if (sureBetRequestTo != null) {
			if ((count / pageSize) < sureBetRequestTo.getPageNum()) {
				pageNum = (count / pageSize);
			} else {
				pageNum = sureBetRequestTo.getPageNum();
			}

		} else {
			pageNum = Long.valueOf(0);
		}
		LOG.debug(new StringBuffer("Se procede a pintar la pagina ").append(
				pageNum).toString());

		List<SecureBeanData> surebets = secureBetService.getSureBetPage(date,
				pageSize, pageNum);
		LOG.debug(new StringBuffer("Se procede a pintar ")
				.append(surebets.size()).append(" surebets.").toString());

		int index = 0;
		for (SecureBeanData secureBean : surebets) {
			responseTo.add(processSecureBeanData(secureBean, userData,
					new Date(), index));
			index++;
		}
		result.setTableResponseTo(responseTo);

		LOG.debug("Se finaliza el controlador de surebet");
		return result;
	}

	/**
	 * Gets the days.
	 * 
	 * @param days
	 *            the days
	 * @return the days
	 */
	private Integer getDays(int days) {
		return days * 24;
	}

	/**
	 * Gets the one sure bet.
	 * 
	 * @param sureBetRequestTo
	 *            the sure bet request to
	 * @param userData
	 *            the user data
	 * @return the one sure bet
	 */
	@RequestMapping(value = "/getOneSureBet", method = RequestMethod.POST)
	@ResponseBody
	public SureBetResponseTo getOneSureBet(
			@RequestBody final SureBetRequestTo sureBetRequestTo,
			final UserData userData) {
		LOG.debug("Se comienza el controlador de surebet: getOneSureBet");

		SureBetResponseTo result = new SureBetResponseTo();
		TableResponseTo responseTo = new TableResponseTo();

		if (sureBetRequestTo != null
				&& sureBetRequestTo.getSureBetId() != null
				&& sureBetRequestTo.getSureBetId().getId() != null
				&& idContainsOnlyDigits(sureBetRequestTo.getSureBetId().getId())) {
			SecureBeanData surebet = secureBetService
					.findOneCustom(sureBetRequestTo.getSureBetId().getId());
			if (surebet != null) {
				responseTo.add(processSecureBeanData(surebet, userData,
						new Date(), 0));
			}
		} else {
			LOG.warn("El pedido ha llegado sin id de la apuesta segura");
		}

		result.setTableResponseTo(responseTo);
		LOG.debug("Se finaliza el controlador de surebet");
		return result;
	}

	/**
	 * Gets the since.
	 * 
	 * @param createDate
	 *            the create date
	 * @param userdate
	 *            the userdate
	 * @return the since
	 */
	private TableResponseCellTo getSince(CoreDate createDate, Date userdate) {
		TableResponseCellTo result = new TableResponseCellTo();
		ValueTo valueTo = new ValueTo();
		StringBuffer buff = new StringBuffer();
		Interval interval = new Interval(createDate.getZeroGmtMatchDate()
				.getTime(), userdate.getTime());
		Integer daystohours = getDays(interval.toPeriod().getDays());
		Integer hours = interval.toPeriod().getHours() + daystohours;
		if (hours != 0) {
			buff.append(hours).append(HOURS).append(" ");
		}

		buff.append(interval.toPeriod().getMinutes()).append(MINUTES)
				.append(" ");
		valueTo.setValueStr(buff.toString());
		result.setValueTo(valueTo);
		return result;
	}

	/**
	 * Id contains only digits.
	 * 
	 * @param string
	 *            the string
	 * @return true, if successful
	 */
	private boolean idContainsOnlyDigits(String string) {
		String regex = "\\d+";
		boolean validString = string.matches(regex);
		if (!validString) {
			LOG.warn(new StringBuffer()
					.append("Se ha pasado un id invalido al controlador: ")
					.append(validString).toString());
		}
		return string.matches(regex);
	}

	/**
	 * Make benefit cell.
	 * 
	 * @param benefit
	 *            the benefit
	 * @return the table response cell to
	 */
	private TableResponseCellTo makeBenefitCell(SecureBeanBenefit benefit) {
		TableResponseCellTo result = new TableResponseCellTo();
		ValueTo valueTo = new ValueTo();
		valueTo.setValueStr(new StringBuffer()
				.append(FormatterUtil.formatBet(
						String.valueOf(benefit.getValue()),
						NUMBER_DIGITS_BET_FORMAT)).append("%").toString());
		result.setValueTo(valueTo);
		return result;
	}

	/**
	 * Minutes to miliseg.
	 * 
	 * @param mins
	 *            the mins
	 * @return the long
	 */
	private long minutesToMiliseg(Integer mins) {
		return mins * 60000;
	}

	/**
	 * Process config.
	 * 
	 * @param config
	 *            the config
	 * @param roles
	 *            the roles
	 * @return the core date
	 */
	private CoreDate processConfig(CfgSureBet config, Roles roles) {
		CoreDate result = null;
		Date date = new Date();

		if (roles != null) {

			for (LiferayRoles rol : (roles.getRoles())) {
				LOG.debug("Rol " + rol.getId());
				if (LiferayRoles.LEVEL_3.getId() == rol.getId()) {
					date.setTime(date.getTime()
							- minutesToMiliseg(config.getRetardoTipo3()));
					result = new CoreDate();
					result.setZeroGmtMatchDate(date);
					break;
				}
				if (LiferayRoles.LEVEL_2.getId() == rol.getId()) {
					date.setTime(date.getTime()
							- minutesToMiliseg(config.getRetardoTipo2()));
					result = new CoreDate();
					result.setZeroGmtMatchDate(date);
					break;
				}
				if (LiferayRoles.LEVEL_1.getId() == rol.getId()) {
					date.setTime(date.getTime()
							- minutesToMiliseg(config.getRetardoTipo1()));
					result = new CoreDate();
					result.setZeroGmtMatchDate(date);
					break;
				}
				if (LiferayRoles.SPECIAL_LEVEL_0.getId() == rol.getId()) {
					date.setTime(date.getTime()
							- minutesToMiliseg(config.getRetardoTipo0()));
					result = new CoreDate();
					result.setZeroGmtMatchDate(date);
					break;
				}
			}
		} else {
			result = new CoreDate(date);
		}

		return result;
	}

	/**
	 * Process secure bean data.
	 * 
	 * @param secureBean
	 *            the secure bean
	 * @param userdata
	 *            the userdata
	 * @param userdate
	 *            the userdate
	 * @param index
	 *            the index
	 * @return the table response row to
	 */
	private TableResponseRowTo processSecureBeanData(SecureBeanData secureBean,
			UserData userdata, Date userdate, int index) {
		TableResponseRowTo result = new TableResponseRowTo();

		InfoMatch match = secureBean.getInfoMatch();
		String betTypeEventId = secureBean.getBetTypeEvent().getBetTypeEvent()
				.getObjectId().toString();
		Date date = secureBean.getCreateDate().getDateForTimeZone(
				userdata.getTimeZone());

		for (IValueFactory table : surebetFactory) {
			if (table.getBetType().nameId()
					.equals(secureBean.getBetType().getNameId())) {
				result.setObjectToId(table.makeObjectId(match, date, index));
				result.add(table.makeEventCell(betTypeEventId, match, userdata));
				result.add(table.getBetTypeCell(secureBean.getBetType(),
						secureBean.getBetTypeEvent().getBetTypeEvent(),
						secureBean.getBets().iterator().next(), userdata));
				result.add(makeBenefitCell(secureBean.getBenefit()));
				result.add(table.getBookmakers(secureBean.getBets(), urlFactory));
				result.add(table.getbets(secureBean.getBets(), urlFactory));
				result.add(getSince(secureBean.getCreateDate(), userdate));
				break;
			}

		}

		return result;
	}

}
