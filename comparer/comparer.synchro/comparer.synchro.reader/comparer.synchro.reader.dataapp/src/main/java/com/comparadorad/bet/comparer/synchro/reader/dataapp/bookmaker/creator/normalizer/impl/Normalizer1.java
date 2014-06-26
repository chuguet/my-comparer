/**
 *
 * Copyright (C) FACTORIA ETSIA S.L.
 * All Rights Reserved.
 * www.factoriaetsia.com
 *
 */
package com.comparadorad.bet.comparer.synchro.reader.dataapp.bookmaker.creator.normalizer.impl;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Component;

import com.comparadorad.bet.comparer.model.config.bean.CfgNormalizerConversionTable;
import com.comparadorad.bet.comparer.model.repository.CfgNormalizerConversionTableRepository;

/**
 * The Class FirstDBNormalizer.
 */
@Component(value="Normalizer1")
public class Normalizer1 extends AbstractNormalizerImpl {

	/** The Constant LOG. */
	private static final Log LOG = LogFactory.getLog(Normalizer1.class);

	/** The cfg normalizer conversion table repository. */
	@Inject
	private CfgNormalizerConversionTableRepository cfgNormalizerConversionTableRepository;

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.comparadorad.bet.comparer.synchro.reader.dataapp.bookmaker.creator
	 * .normalizer.impl.AbstractNormalizerImpl#normalizar(java.util.List)
	 */
	@Override
	protected List<String> normalizar(List<String> listaANormalizar) {
		List<String> result = new ArrayList<String>(listaANormalizar);
		CfgNormalizerConversionTable key = new CfgNormalizerConversionTable();

		LOG.debug("Inicio normalizacion BD");
		// Para cada uno de los elementos que hemos encontrado como sinonimo
		for (int i = 0; i < listaANormalizar.size(); i++) {
			// Dividimos este sinonimo en sus palabras que lo componen para ver
			// si podemos susitituir alguna de las que lleva por la que haya en
			// BD.
			String[] palabraDividida = listaANormalizar.get(i).split(" ");
			String palabraFinal = listaANormalizar.get(i);
			// Obtengo de base de datos a ver si hay algun reemplazo posible
			// para cada palabra del sinonimo
			for (String palabra : palabraDividida) {
				key = cfgNormalizerConversionTableRepository
						.customFindByKey(palabra);
				if (key != null) {
					List<String> listaKeys = key.getValue();

					for (int k = 0; k < listaKeys.size(); k++) {
						String palabraAñadida = "";
						if (listaKeys.get(k) != null){
							palabraAñadida = palabraFinal.replace(palabra, listaKeys.get(k));
							
						} else {
							palabraAñadida = palabraFinal.replace(palabra, "");
						}
						result.add(palabraAñadida);
					}
				}
			}
			

		}
		LOG.debug("Fin normalizacion BD");
		return result;
	}
}
