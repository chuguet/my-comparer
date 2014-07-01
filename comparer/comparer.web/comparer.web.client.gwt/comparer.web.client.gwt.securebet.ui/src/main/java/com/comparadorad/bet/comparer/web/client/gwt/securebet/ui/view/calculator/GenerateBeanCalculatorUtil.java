/**
 *
 * Copyright (C) FACTORIA ETSIA S.L.
 * All Rights Reserved.
 * www.factoriaetsia.com
 *
 */
package com.comparadorad.bet.comparer.web.client.gwt.securebet.ui.view.calculator;

import java.util.ArrayList;
import java.util.List;

import com.comparadorad.bet.comparer.web.client.gwt.common.bean.ExternalLinkTo;
import com.comparadorad.bet.comparer.web.client.gwt.common.bean.table.TableResponseRowTo;
import com.comparadorad.bet.comparer.web.client.gwt.securebet.ui.view.calculator.bean.BeanCalculator;
import com.smartgwt.client.util.Page;

/**
 * The Class GenerateBeanCalculatorUtil.
 */
public class GenerateBeanCalculatorUtil {

	/**
	 * Generate bean.
	 * 
	 * @param row
	 *            the row
	 * @return the bean calculator
	 */
	public static BeanCalculator generateBean(TableResponseRowTo row) {
		BeanCalculator result = new BeanCalculator();
		result.setIdEvento(row.getObjectToId().getId());
		String fecha[] = row.getCellList().get(0).getValueTo().getDate().split(" ");
		result.setFechaEvento(fecha[0]);
		result.setHoraEvento(fecha[1]);
		result.setIconoCalendario(Page.getAppImgDir() + "comparer/calendar/small_calendar.jpg");
		
		String[] evento = row.getCellList().get(0).getLinkTo().getName().split("\\|");
		String[] participantes = evento[0].split(" vs ");
		result.setParticipanteLocal(participantes[0]);
		result.setParticipanteVisitante(participantes[1]);
		result.setNombreEvento(evento[0]);
		result.setDeporte(evento[1]);
		result.setPais(evento[2]);
		result.setCompeticion(evento[3]);
		String[] tipoApuesta = row.getCellList().get(1).getValueTo().getValueStr().split("\\|");

		result.setTipoApuesta(tipoApuesta[0]);
		result.setBeneficio(row.getCellList().get(2).getValueTo().getValueStr());
		if (tipoApuesta.length == 2) {
			result.setEventoApuesta(tipoApuesta[1]);
		} else if (tipoApuesta.length == 3) {
			result.setInfoAdicionalApuesta(tipoApuesta[1]);
			result.setEventoApuesta(tipoApuesta[2]);
		}
		result.setCasasApuesta(getDirImages(row.getCellList().get(3).getExternalLinkToList()));
//		result.setCasasApuesta(row.getCellList().get(3).getExternalLinkToList());
		if (row.getCellList().get(4).getExternalLinkToList().size() == 2) {
			result.setCuotaLocal(row.getCellList().get(4).getExternalLinkToList().get(0).getLinkText());
			result.setCuotaVisitante(row.getCellList().get(4).getExternalLinkToList().get(1).getLinkText());
		} else {
			result.setCuotaLocal(row.getCellList().get(4).getExternalLinkToList().get(0).getLinkText());
			result.setCuotaEmpate(row.getCellList().get(4).getExternalLinkToList().get(1).getLinkText());
			result.setCuotaVisitante(row.getCellList().get(4).getExternalLinkToList().get(2).getLinkText());

		}
		result.setUrlLogo(Page.getAppImgDir()+"comparer/icons/logo_betcompara_beta.jpg");
		return result;
	}

	/**
	 * Añade los links a las casas de apuestas desencriptados para que podamos
	 * redirigir a las mismas.
	 * 
	 * @param externalLinkToList
	 * @return
	 */
	private static List<ExternalLinkTo> getDirImages(List<ExternalLinkTo> externalLinkToList) {
		List<ExternalLinkTo> result = new ArrayList<ExternalLinkTo>();
		for (ExternalLinkTo link : externalLinkToList) {
			ExternalLinkTo elemento = new ExternalLinkTo();
			elemento.setLinkImgLocation(Page.getAppImgDir() + link.getLinkImgLocation());
			elemento.setUrl(link.getUrl());
			elemento.setActionAnalytics(link.getActionAnalytics());
			elemento.setCategoryAnalytics(link.getCategoryAnalytics());
			result.add(elemento);
		}

		return result;
	}

}
