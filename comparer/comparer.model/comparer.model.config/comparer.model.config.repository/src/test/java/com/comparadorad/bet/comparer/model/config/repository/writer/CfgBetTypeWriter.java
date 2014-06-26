/**
 *
 * Copyright (C) FACTORIA ETSIA S.L.
 * All Rights Reserved.
 * www.factoriaetsia.com
 *
 */
package com.comparadorad.bet.comparer.model.config.repository.writer;

import java.util.ArrayList;
import java.util.List;

import com.comparadorad.bet.comparer.model.config.bean.CfgBetType;
import com.comparadorad.bet.comparer.model.core.bean.CoreActiveElement;
import com.comparadorad.bet.comparer.model.core.bean.Order;
import com.comparadorad.bet.comparer.model.core.repository.AbstractWriterXML;

/**
 * The Class CfgSportWriter.
 */
public class CfgBetTypeWriter extends AbstractWriterXML<List<CfgBetType>> {

	/** {@inheritDoc} */
	@Override
	protected boolean isExtended() {
		return false;
	}

	/**
	 * Make object.
	 * 
	 * @return the list {@inheritDoc}
	 */
	@Override
	protected List<CfgBetType> makeObject() {
		/* 
		UNO_X_DOS("1X2"),
		GANADOR_PARTIDO("Ganador_Partido"),
		GANADOR("Ganador"),
		HANDICAP_ASIATICO("Handicap_Asiatico"),
		UNO_X_DOS_HANDICAP("1X2_Handicap"),
		MAS_MENOS("Mas_Menos"),
		MAXIMO_GOLEADOR("Maximo_Goleador")
		*/
		
		final List<CfgBetType> result = new ArrayList<CfgBetType>();
		CfgBetType register;
		Order orden;
		register = new CfgBetType();
		orden = new Order();
		orden.setPriority(10);
		register.setOrder(orden);
		register.setObjectId("1");
		register.setName("1 x 2");
		register.setNameId("1X2");
		register.setCoreActiveElement(new CoreActiveElement(Boolean.TRUE));
		result.add(register);
		register = new CfgBetType();
		orden = new Order();
		orden.setPriority(20);
		register.setOrder(orden);
		register.setObjectId("2");
		register.setName("Ganador de partido");
		register.setNameId("Ganador_Partido");
		register.setCoreActiveElement(new CoreActiveElement(Boolean.TRUE));
		result.add(register);
		register = new CfgBetType();
		orden = new Order();
		orden.setPriority(30);
		register.setOrder(orden);
		register.setObjectId("3");
		register.setName("Ganador");
		register.setNameId("Ganador");
		register.setCoreActiveElement(new CoreActiveElement(Boolean.TRUE));
		result.add(register);
		register = new CfgBetType();
		orden = new Order();
		orden.setPriority(40);
		register.setOrder(orden);
		register.setObjectId("4");
		register.setName("Handicap Asiatico");
		register.setNameId("Handicap_Asiatico");
		register.setCoreActiveElement(new CoreActiveElement(Boolean.TRUE));
		result.add(register);
		register = new CfgBetType();
		orden = new Order();
		orden.setPriority(50);
		register.setOrder(orden);
		register.setObjectId("5");
		register.setName("1X2 Handicap");
		register.setNameId("1X2_Handicap");
		register.setCoreActiveElement(new CoreActiveElement(Boolean.TRUE));
		result.add(register);
		register = new CfgBetType();
		orden = new Order();
		orden.setPriority(60);
		register.setOrder(orden);
		register.setObjectId("6");
		register.setName("Mas o menos");
		register.setNameId("Mas_Menos");
		register.setCoreActiveElement(new CoreActiveElement(Boolean.TRUE));
		result.add(register);
		register = new CfgBetType();
		orden = new Order();
		orden.setPriority(70);
		register.setOrder(orden);
		register.setObjectId("7");
		register.setName("Maximo goleador");
		register.setNameId("Maximo_Goleador");
		register.setCoreActiveElement(new CoreActiveElement(Boolean.TRUE));
		result.add(register);
		return result;
	}

}
