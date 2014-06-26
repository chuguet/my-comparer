/**
 *
 * Copyright (C) FACTORIA ETSIA S.L.
 * All Rights Reserved.
 * www.factoriaetsia.com
 *
 */
package com.comparadorad.bet.comparer.model.securebet.bean;

import java.util.Date;

import com.comparadorad.bet.comparer.model.bet.bean.RtBet;
import com.comparadorad.bet.comparer.model.core.bean.CoreDate;
import com.comparadorad.bet.comparer.model.securebet.bean.HistoricInfo.Cause;

/**
 * The Class SecureBeanData.
 */
@SuppressWarnings("serial")
public class SecureBeanData extends AbstractSecureBeanData {
	/**
	 * Convert to historic.
	 * 
	 * @param secureBeanData
	 *            the secure bean data
	 * @return the secure bean historic data
	 */
	public SecureBeanHistoricData convertToHistoric(
			Cause cause) {
		SecureBeanHistoricData secureBeanHistoricData = new SecureBeanHistoricData();

		secureBeanHistoricData.setNameId(this.getNameId());
		secureBeanHistoricData.setBetType(this.getBetType());
		secureBeanHistoricData.setInfoMatch(this.getInfoMatch());
		secureBeanHistoricData.setCreateDate(this.getCreateDate());
		secureBeanHistoricData.setBenefit(this.getBenefit());
		secureBeanHistoricData.setBets(this.getBets());
		secureBeanHistoricData
				.setBetTypeEvent(this.getBetTypeEvent());
		secureBeanHistoricData.setHistoric(new HistoricInfo(cause, new CoreDate(new Date())));
		return secureBeanHistoricData;
	}

	public boolean containEqualsBet(RtBet bet) {
		Boolean result = Boolean.FALSE;
		for (RtBet rtbet : this.getBets()) {
			if(rtbet.equals(bet)){
				result = Boolean.TRUE;
				break;
			}
		}
		return result;
	}
}
