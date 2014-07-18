/**
 *
 * Copyright (C) FACTORIA ETSIA S.L.
 * All Rights Reserved.
 * www.factoriaetsia.com
 *
 */
package com.comparadorad.bet.comparer.web.server.mvc.match.table.country.tablongterm;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map.Entry;
import java.util.TimeZone;

import com.comparadorad.bet.comparer.model.bet.bean.RtBet;
import com.comparadorad.bet.comparer.model.bet.bean.RtMarket;
import com.comparadorad.bet.comparer.model.core.bean.user.UserData;
import com.comparadorad.bet.comparer.util.commons.betOdds.FormatterUtil;
import com.comparadorad.bet.comparer.web.client.gwt.common.bean.ExternalLinkTo;
import com.comparadorad.bet.comparer.web.client.gwt.common.bean.ObjectToId;
import com.comparadorad.bet.comparer.web.client.gwt.common.bean.table.TableResponseRowTo;
import com.comparadorad.bet.comparer.web.client.gwt.common.bean.table.TableResponseTo;
import com.comparadorad.bet.comparer.web.server.mvc.match.comparator.SortRowsByOdd;
import com.comparadorad.bet.comparer.web.server.mvc.match.control.AbstractOdds;

/**
 * The Class AbstractMakeTableCountryLT.
 */
public abstract class AbstractMakeTableCountryLT extends AbstractOdds implements
		IMakeTableCountryLT {

	/** The NUMBE r_ digit s_ be t_ format. */
	protected static int NUMBER_DIGITS_BET_FORMAT = 2;

	/** {@inheritDoc} */
	@Override
	public TableResponseTo makeTable(List<RtMarket> markets, UserData userData) {
		TableResponseTo result = new TableResponseTo();
		List<TableResponseRowTo> rowList = new ArrayList<TableResponseRowTo>();
		List<CountryLongTermBean> rows = getRows(markets, userData);
		for (CountryLongTermBean countryLongTermBean : rows) {
			rowList.add(addRow(countryLongTermBean, userData.getTimeZone()));
		}
		Collections.sort(rowList, new SortRowsByOdd());
		result.setRows(rowList);
		return result;
	}

	/**
	 * Gets the rows.
	 * 
	 * @param markets
	 *            the markets
	 * @param userData
	 *            the user data
	 * @return the rows
	 */
	private List<CountryLongTermBean> getRows(List<RtMarket> markets,
			UserData userData) {
		List<CountryLongTermBean> result = new ArrayList<AbstractMakeTableCountryLT.CountryLongTermBean>();
		CountryLongTermBean bean = null;

		HashMap<BigInteger, List<RtBet>> bets = getBets(markets);
		Iterator<Entry<BigInteger, List<RtBet>>> it = bets.entrySet()
				.iterator();
		Entry<BigInteger, List<RtBet>> e;
		Float max;
		while (it.hasNext()) {
			e = it.next();
			if (e.getValue().size() > 0) {
				max = getMax(e.getValue());
				bean = new CountryLongTermBean(e.getValue().get(0)
						.getParticipant().getCfgParticipant()
						.getName(userData.getLocale()),
						getAverage(e.getValue()), max, getBookmakerUrl(
								e.getValue(), max), e.getValue().get(0)
								.getParticipant().getCfgParticipant()
								.getObjectId().toString());
			}
			result.add(bean);
		}
		return result;
	}

	/**
	 * Gets the bookmaker url.
	 * 
	 * @param value
	 *            the value
	 * @param max
	 *            the max
	 * @return the bookmaker url
	 */
	private List<ExternalLinkTo> getBookmakerUrl(List<RtBet> value, Float max) {
		List<ExternalLinkTo> urls = new ArrayList<ExternalLinkTo>();

		for (RtBet rtBet : value) {
			// Vamos a mostrar max 3 bookmakers
			String categoryAnalytics = "";
			if (urls.size() < 3
					&& Float.parseFloat(rtBet.getBetOdd().getOdds()) >= max) {
				ExternalLinkTo externalLinkTo = new ExternalLinkTo();
				externalLinkTo.setLinkImgLocation(rtBet.getBookmaker()
						.getResourceSmallImg().getLocation());
				if (rtBet.getWebUrl() != null) {
					externalLinkTo.setUrl(getExternalLinkTo(rtBet
							.getBookmaker().getObjectId().toString(), rtBet
							.getWebUrl().getUrl(), rtBet.getBookmaker()
							.getBookmakerConfiguration().getIdAfiliado()));
				}
				externalLinkTo.setActionAnalytics(rtBet.getBookmaker().getNameId());
				externalLinkTo.setCategoryAnalytics(categoryAnalytics);
				urls.add(externalLinkTo);
			}
		}
		return urls;
	}

	/**
	 * Gets the average.
	 * 
	 * @param value
	 *            the value
	 * @return the average
	 */
	private Float getAverage(List<RtBet> value) {
		Float result = null;
		for (RtBet rtBet : value) {
			if (result == null) {
				result = new Float(rtBet.getBetOdd().getOdds());
			} else {
				result = result + Float.parseFloat(rtBet.getBetOdd().getOdds());
			}
		}

		return result / value.size();
	}

	/**
	 * Gets the max.
	 * 
	 * @param value
	 *            the value
	 * @return the max
	 */
	private Float getMax(List<RtBet> value) {
		Float result = null;
		Float aux = null;
		for (RtBet rtBet : value) {
			if (result == null) {
				result = new Float(rtBet.getBetOdd().getOdds());
			} else {
				aux = Float.parseFloat(rtBet.getBetOdd().getOdds());
				if (aux > result) {
					result = aux;
				}
			}
		}
		return result;
	}

	/**
	 * Gets the bets.
	 * 
	 * @param markets
	 *            the markets
	 * @return the bets
	 */
	private HashMap<BigInteger, List<RtBet>> getBets(List<RtMarket> markets) {

		HashMap<BigInteger, List<RtBet>> result = new HashMap<BigInteger, List<RtBet>>();
		Iterator<Entry<BigInteger, List<RtBet>>> it;
		Entry<BigInteger, List<RtBet>> e;
		List<RtBet> betList;
		boolean found = false;
		for (RtMarket rtMarket : markets) {
			for (RtBet rtBet : rtMarket.getBets()) {
				it = result.entrySet().iterator();
				while (it.hasNext() && !found) {
					e = it.next();
					if (e.getKey().equals(
							rtBet.getParticipant().getCfgParticipant()
									.getObjectId())) {
						found = true;
						result.get(e.getKey()).add(rtBet);
					}
				}
				if (!found) {
					betList = new ArrayList<RtBet>();
					betList.add(rtBet);
					result.put(rtBet.getParticipant().getCfgParticipant()
							.getObjectId(), betList);
				}
				found = false;
			}
		}

		return result;
	}

	/**
	 * Adds the row.
	 * 
	 * @param countryLongTermBean
	 *            the country long term bean
	 * @param timeZone
	 *            the time zone
	 * @return the table response row to
	 */
	private TableResponseRowTo addRow(CountryLongTermBean countryLongTermBean,
			final TimeZone timeZone) {
		TableResponseRowTo row = getNewRow();
		row.setObjectToId(countryLongTermBean.getObjectToId());
		row.add(getNewCell(null, countryLongTermBean.getParticipant(), null,
				null, null, null, null, timeZone));
		// row.add(getNewCell(null,null, null,
		// countryLongTermBean.getAverageLiretal(), null, null, null));
		String formattedOdd = FormatterUtil.formatBet(
				countryLongTermBean.getAverage(), NUMBER_DIGITS_BET_FORMAT);
		row.add(getNewCell(null, formattedOdd, null, null, null, null, null,
				timeZone));
		formattedOdd = FormatterUtil.formatBet(countryLongTermBean.getMax(),
				NUMBER_DIGITS_BET_FORMAT);
		row.add(getNewCell(null, formattedOdd, null, null, null, null, null,
				timeZone));
		// row.add(getNewCell(null,null, null,
		// countryLongTermBean.getArrobaLiteral(), null, null, null));
		// TableResponseCellTo cell = new TableResponseCellTo();
		// List<ResourceTo> resources = new ArrayList<ResourceTo>();
		for (ExternalLinkTo externalUrl : countryLongTermBean.getBookmakerUrl()) {
			// resources.add(new ResourceTo(url));
			row.add(getNewCell(null, null, null, null, null, null, externalUrl,
					timeZone));
		}
		// cell.setResources(resources);
		// row.add(cell);

		return row;
	}

	/**
	 * The Class CountryLongTermBean.
	 */
	public class CountryLongTermBean {

		/** The participant. */
		private String participant;

		/** The average liretal. */
		private String averageLiretal;

		/** The average. */
		private Float average;

		/** The max. */
		private Float max;

		/** The bookmaker url. */
		private List<ExternalLinkTo> bookmakerUrl;

		/** The object to id. */
		private ObjectToId objectToId;

		/**
		 * Instantiates a new country long term bean.
		 * 
		 * @param participant
		 *            the participant
		 * @param average
		 *            the average
		 * @param max
		 *            the max
		 * @param bookmakerUrl
		 *            the bookmaker url
		 * @param pObjectToId
		 *            the object to id
		 */
		public CountryLongTermBean(String participant, Float average,
				Float max, List<ExternalLinkTo> bookmakerUrl, String pObjectToId) {
			this.participant = participant;
			this.average = average;
			this.max = max;
			this.bookmakerUrl = bookmakerUrl;
			this.objectToId = new ObjectToId(pObjectToId);
		}

		/**
		 * Gets the participant.
		 * 
		 * @return the participant
		 */
		public String getParticipant() {
			return participant;
		}

		/**
		 * Sets the participant.
		 * 
		 * @param participant
		 *            the new participant
		 */
		public void setParticipant(String participant) {
			this.participant = participant;
		}

		/**
		 * Gets the average liretal.
		 * 
		 * @return the average liretal
		 */
		public String getAverageLiretal() {
			return averageLiretal;
		}

		/**
		 * Sets the average liretal.
		 * 
		 * @param averageLiretal
		 *            the new average liretal
		 */
		public void setAverageLiretal(String averageLiretal) {
			this.averageLiretal = averageLiretal;
		}

		/**
		 * Gets the average.
		 * 
		 * @return the average
		 */
		public Float getAverage() {
			return average;
		}

		/**
		 * Sets the average.
		 * 
		 * @param average
		 *            the new average
		 */
		public void setAverage(Float average) {
			this.average = average;
		}

		/**
		 * Gets the max.
		 * 
		 * @return the max
		 */
		public Float getMax() {
			return max;
		}

		/**
		 * Sets the max.
		 * 
		 * @param max
		 *            the new max
		 */
		public void setMax(Float max) {
			this.max = max;
		}

		/**
		 * Gets the bookmaker url.
		 * 
		 * @return the bookmaker url
		 */
		public List<ExternalLinkTo> getBookmakerUrl() {
			return bookmakerUrl;
		}

		/**
		 * Sets the bookmaker url.
		 * 
		 * @param bookmakerUrl
		 *            the new bookmaker url
		 */
		public void setBookmakerUrl(List<ExternalLinkTo> bookmakerUrl) {
			this.bookmakerUrl = bookmakerUrl;
		}

		/**
		 * Gets the object to id.
		 * 
		 * @return the object to id
		 */
		public ObjectToId getObjectToId() {
			return objectToId;
		}

		/**
		 * Sets the object to id.
		 * 
		 * @param pObjectToId
		 *            the new object to id
		 */
		public void setObjectToId(ObjectToId pObjectToId) {
			objectToId = pObjectToId;
		}

	}

}
