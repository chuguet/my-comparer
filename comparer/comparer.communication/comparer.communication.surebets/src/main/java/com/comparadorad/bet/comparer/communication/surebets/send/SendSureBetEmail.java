/**
 *
 * Copyright (C) FACTORIA ETSIA S.L.
 * All Rights Reserved.
 * www.factoriaetsia.com
 *
 */
package com.comparadorad.bet.comparer.communication.surebets.send;

import java.util.Date;
import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.comparadorad.bet.comparer.communication.core.bean.SureBetQueue;
import com.comparadorad.bet.comparer.communication.producer.ISureBetQueueProducer;
import com.comparadorad.bet.comparer.model.securebet.bean.SecureBeanData;
import com.comparadorad.bet.comparer.model.securebet.bean.CfgSureBet;
import com.comparadorad.bet.comparer.model.securebet.service.CfgSureBetService;

/**
 * The Class SendSureBetEmail.
 */
@Service
class SendSureBetEmail implements ISendSureBetEmail {

	/** The bet queue producers. */
	@Inject
	private List<ISureBetQueueProducer<SureBetQueue>> betQueueProducers;

	@Inject
	private CfgSureBetService sureBetConfigService;

	/**
	 * Send.
	 * 
	 * @param sureBetQueue
	 *            the sure bet queue
	 * @return the boolean {@inheritDoc}
	 */
	public Boolean send(SecureBeanData secureBeanData) {
		Boolean flag = Boolean.TRUE;
		if (secureBeanData.getBenefit().getValue() >= getMinimumPercentage()) {
			SureBetQueue sureBetQueue = new SureBetQueue(secureBeanData, new Date());
			for (ISureBetQueueProducer<SureBetQueue> betQueueProducer : betQueueProducers) {
				if (flag) {
					flag = betQueueProducer.send(sureBetQueue);
				}
			}
		} else {
			flag = Boolean.FALSE;
		}

		return flag;
	}

	private Float getMinimumPercentage() {
		Float result = 0F;
		for (CfgSureBet sureBetConfig : sureBetConfigService.findAll()) {
			result = sureBetConfig.getPorcentajeMinimo();
		}
		return result;
	}

}
