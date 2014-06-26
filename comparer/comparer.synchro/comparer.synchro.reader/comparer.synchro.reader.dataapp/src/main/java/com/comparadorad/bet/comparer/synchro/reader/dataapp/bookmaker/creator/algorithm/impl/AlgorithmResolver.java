package com.comparadorad.bet.comparer.synchro.reader.dataapp.bookmaker.creator.algorithm.impl;

import org.springframework.stereotype.Component;

import uk.ac.shef.wit.simmetrics.similaritymetrics.AbstractStringMetric;

import com.comparadorad.bet.comparer.model.config.bean.CfgResolverAlgorithm;

@Component
class AlgorithmResolver extends AbstractAlgorithmResolver {

	@Override
	public Double getDiferences(String wordA, String wordB,
			CfgResolverAlgorithm cfgResolverAlgorithm) {
		AbstractStringMetric algoritmo = cfgResolverAlgorithm.getAlgorithm();

		float val = algoritmo.getSimilarity(wordA, wordB);

		Double resultado = (double) val;

		return resultado;

	}

	
}
