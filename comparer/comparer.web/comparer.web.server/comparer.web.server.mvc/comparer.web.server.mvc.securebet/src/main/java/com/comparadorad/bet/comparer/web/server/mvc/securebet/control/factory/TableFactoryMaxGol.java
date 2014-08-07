/**
 *
 * Copyright (C) FACTORIA ETSIA S.L.
 * All Rights Reserved.
 * www.factoriaetsia.com
 *
 */
package com.comparadorad.bet.comparer.web.server.mvc.securebet.control.factory;

import java.util.Date;

import org.springframework.stereotype.Service;

import com.comparadorad.bet.comparer.model.config.bean.CfgBetType.CfgBetTypeId;
import com.comparadorad.bet.comparer.model.securebet.bean.InfoMatch;
import com.comparadorad.bet.comparer.web.client.gwt.common.bean.ObjectToId;


/**
 * The Class TableFactoryMaxGol.
 */
@Service
public class TableFactoryMaxGol extends AbstractTableSureBetFactory{



	

	@Override
	public CfgBetTypeId getBetType() {
		return CfgBetTypeId.MAXIMO_GOLEADOR;
	}


	@Override
	public ObjectToId makeObjectId(InfoMatch match, Date date,int index) {
		return new ObjectToId(new StringBuffer().append(match.getObjectId().toString())
				.append(date.hashCode())
				.append(index)
				.toString());
	}


}
