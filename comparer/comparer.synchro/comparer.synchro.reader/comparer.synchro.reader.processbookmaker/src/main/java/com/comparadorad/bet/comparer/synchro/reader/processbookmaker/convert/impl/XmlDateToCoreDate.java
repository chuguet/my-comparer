/**
 *
 * Copyright (C) FACTORIA ETSIA S.L.
 * All Rights Reserved.
 * www.factoriaetsia.com
 *
 */
package com.comparadorad.bet.comparer.synchro.reader.processbookmaker.convert.impl;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.inject.Inject;

import org.springframework.stereotype.Component;

import com.comparadorad.bet.comparer.model.core.bean.CoreDate;
import com.comparadorad.bet.comparer.synchro.reader.model.XmlDate;
import com.comparadorad.bet.comparer.synchro.reader.processbookmaker.convert.CustomConvertProcess;
import com.comparadorad.bet.comparer.synchro.reader.processbookmaker.exception.DateFormatException;
import com.comparadorad.bet.comparer.util.commons.date.DateFormatUtil;
import com.comparadorad.bet.comparer.util.logger.core.ComparerWrapperLog;

/**
 * The Class XmlDateToCoreDate.
 */
@Component
public class XmlDateToCoreDate extends AbstractCustomConvertProcess implements CustomConvertProcess {

	private static final SimpleDateFormat MINUTES_FORMATTER = new SimpleDateFormat("mm");
	private static final SimpleDateFormat DATE_FORMATTER = new SimpleDateFormat("dd/MM/yyyy HH:mm");
	
	/** The Constant LOG. */
	@Inject
	private ComparerWrapperLog LOG;

	/** {@inheritDoc} */
	@Override
	public Object convert(Object targetObject, Object sourceObject, Class<?> pArg2, Class<?> pArg3) {
		CoreDate result = new CoreDate();
		if (sourceObject instanceof XmlDate) {
			LOG.debug(Thread.currentThread(), "Inicio conversion la fecha");
			XmlDate xmlDate = (XmlDate) sourceObject;

			if (xmlDate.getZeroGmtMatchDate() != null) {
				result.setZeroGmtMatchDate(eraseOvertime(xmlDate.getZeroGmtMatchDate()));
			} else {
				DateFormatUtil dateFormat = new DateFormatUtil("dd/MM/yyyy HH:mm");
				String date = DATE_FORMATTER.format(eraseOvertime(xmlDate.getProviderDate()));
				result.setZeroGmtMatchDate(dateFormat.getZeroGmtDate(date));
			}

			if (xmlDate.getProviderDate() != null) {
				result.setProviderDate(eraseOvertime(xmlDate.getProviderDate()));
			}
			if (xmlDate.getProviderTimeZone() != null) {
				result.setProviderTimeZoneStr(xmlDate.getProviderTimeZoneStr());
			}
		} else {
			LOG.debug(Thread.currentThread(), "No se podido asignar los valores de la fecha");
			throw new DateFormatException("No se podido asignar los valores de la fecha");
		}
		LOG.debug(Thread.currentThread(), "Fin conversion la fecha");
		return result;
	}

	/** {@inheritDoc} */
	@Override
	public String getName() {
		return "xmlDateToCoreDate";
	}
	
	private Date eraseOvertime (Date pDate){
		Date result = new Date(pDate.getTime());
		if(MINUTES_FORMATTER.format(pDate).equals("05")||MINUTES_FORMATTER.format(pDate).equals("35")){
			result = new Date(pDate.getTime()-300000);
		}
		return result;
		
	}

}
