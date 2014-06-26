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

import com.comparadorad.bet.comparer.model.config.bean.CfgBetTypeEvent;
import com.comparadorad.bet.comparer.model.core.bean.CoreActiveElement;
import com.comparadorad.bet.comparer.model.core.bean.Order;
import com.comparadorad.bet.comparer.model.core.repository.AbstractWriterXML;

/**
 * The Class CfgBetTypeEventWriter.
 */
public class CfgBetTypeEventWriter extends
		AbstractWriterXML<List<CfgBetTypeEvent>> {

	/**
	 * Checks if is extended.
	 * 
	 * @return true, if is extended {@inheritDoc}
	 */
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
	protected List<CfgBetTypeEvent> makeObject() {

		final List<CfgBetTypeEvent> result = new ArrayList<CfgBetTypeEvent>();
		CfgBetTypeEvent register;
		register = new CfgBetTypeEvent();
		register.setObjectId("1");
		register.setName("Partido Completo");
		register.setNameId("PARTIDO_COMPLETO");
		register.setCoreActiveElement(new CoreActiveElement(Boolean.TRUE));
		register.setOrder(new Order(new Integer(10)));
		result.add(register);
		register = new CfgBetTypeEvent();
		register.setObjectId("7");
		register.setName("Primer Set");
		register.setNameId("PRIMER_SET");
		register.setCoreActiveElement(new CoreActiveElement(Boolean.TRUE));
		register.setOrder(new Order(new Integer(20)));
		result.add(register);
		register = new CfgBetTypeEvent();
		register.setObjectId("8");
		register.setName("Segundo Set");
		register.setNameId("SEGUNDO_SET");
		register.setCoreActiveElement(new CoreActiveElement(Boolean.TRUE));
		register.setOrder(new Order(new Integer(30)));
		result.add(register);
		register = new CfgBetTypeEvent();
		register.setObjectId("9");
		register.setName("Tercer Set");
		register.setNameId("TERCER_SET");
		register.setCoreActiveElement(new CoreActiveElement(Boolean.TRUE));
		register.setOrder(new Order(new Integer(40)));
		result.add(register);
		register = new CfgBetTypeEvent();
		register.setObjectId("10");
		register.setName("Cuarto Set");
		register.setNameId("CUARTO_SET");
		register.setCoreActiveElement(new CoreActiveElement(Boolean.TRUE));
		register.setOrder(new Order(new Integer(50)));
		result.add(register);
		register = new CfgBetTypeEvent();
		register.setObjectId("11");
		register.setName("Quinto Set");
		register.setNameId("QUINTO_SET");
		register.setCoreActiveElement(new CoreActiveElement(Boolean.TRUE));
		register.setOrder(new Order(new Integer(60)));
		result.add(register);
		register = new CfgBetTypeEvent();
		register.setObjectId("18");
		register.setName("Primera Entrada");
		register.setNameId("PRIMERA_ENTRADA");
		register.setCoreActiveElement(new CoreActiveElement(Boolean.TRUE));
		register.setOrder(new Order(new Integer(70)));
		result.add(register);
		register = new CfgBetTypeEvent();
		register.setObjectId("19");
		register.setName("Cinco Primeras Entradas");
		register.setNameId("CINCO_PRIMERAS_ENTRADAS");
		register.setCoreActiveElement(new CoreActiveElement(Boolean.TRUE));
		register.setOrder(new Order(new Integer(80)));
		result.add(register);
		result.add(register);
		register = new CfgBetTypeEvent();
		register.setObjectId("13");
		register.setName("Primer Cuarto");
		register.setNameId("PRIMER_CUARTO");
		register.setCoreActiveElement(new CoreActiveElement(Boolean.TRUE));
		register.setOrder(new Order(new Integer(90)));
		result.add(register);
		register = new CfgBetTypeEvent();
		register.setObjectId("4");
		register.setName("Quince Minutos");
		register.setNameId("QUINCE_MINUTOS");
		register.setCoreActiveElement(new CoreActiveElement(Boolean.TRUE));
		register.setOrder(new Order(new Integer(100)));
		result.add(register);
		register = new CfgBetTypeEvent();
		register.setObjectId("14");
		register.setName("Segundo Cuarto");
		register.setNameId("SEGUNDO_CUARTO");
		register.setCoreActiveElement(new CoreActiveElement(Boolean.TRUE));
		register.setOrder(new Order(new Integer(110)));
		result.add(register);
		register = new CfgBetTypeEvent();
		register.setObjectId("5");
		register.setName("Treinta Minutos");
		register.setNameId("TREINTA_MINUTOS");
		register.setCoreActiveElement(new CoreActiveElement(Boolean.TRUE));
		register.setOrder(new Order(new Integer(120)));
		result.add(register);
		register = new CfgBetTypeEvent();
		register.setObjectId("2");
		register.setName("Primera Parte");
		register.setNameId("PRIMERA_PARTE");
		register.setCoreActiveElement(new CoreActiveElement(Boolean.TRUE));
		register.setOrder(new Order(new Integer(130)));
		result.add(register);
		register = new CfgBetTypeEvent();
		register.setObjectId("15");
		register.setName("Tercer Cuarto");
		register.setNameId("TERCER_CUARTO");
		register.setCoreActiveElement(new CoreActiveElement(Boolean.TRUE));
		register.setOrder(new Order(new Integer(140)));
		result.add(register);
		register = new CfgBetTypeEvent();
		register.setObjectId("16");
		register.setName("Cuarto Cuarto");
		register.setNameId("CUARTO_CUARTO");
		register.setCoreActiveElement(new CoreActiveElement(Boolean.TRUE));
		register.setOrder(new Order(new Integer(150)));
		result.add(register);
		register = new CfgBetTypeEvent();
		register.setObjectId("3");
		register.setName("Segunda Parte");
		register.setNameId("SEGUNDA_PARTE");
		register.setCoreActiveElement(new CoreActiveElement(Boolean.TRUE));
		register.setOrder(new Order(new Integer(160)));
		result.add(register);
		register = new CfgBetTypeEvent();
		register.setObjectId("6");
		register.setName("Setenta Minutos");
		register.setNameId("SETENTA_MINUTOS");
		register.setCoreActiveElement(new CoreActiveElement(Boolean.TRUE));
		register.setOrder(new Order(new Integer(170)));
		result.add(register);
		register = new CfgBetTypeEvent();
		register.setObjectId("20");
		register.setName("Tercera Parte");
		register.setNameId("TERCERA_PARTE");
		register.setCoreActiveElement(new CoreActiveElement(Boolean.TRUE));
		register.setOrder(new Order(new Integer(180)));
		result.add(register);
		register = new CfgBetTypeEvent();
		register.setObjectId("17");
		register.setName("Partido completo y prorroga");
		register.setNameId("PARTIDO_COMPLETO_PRORROGA");
		register.setCoreActiveElement(new CoreActiveElement(Boolean.TRUE));
		register.setOrder(new Order(new Integer(190)));
		result.add(register);
		return result;
	}

}
