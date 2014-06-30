/**
 *
 * Copyright (C) FACTORIA ETSIA S.L.
 * All Rights Reserved.
 * www.factoriaetsia.com
 *
 */
package com.comparadorad.bet.comparer.synchro.valuebet.process;

import org.springframework.batch.item.ItemProcessor;

import com.comparadorad.bet.comparer.model.bet.bean.RtMatch;
import com.comparadorad.bet.comparer.synchro.valuebet.core.bean.result.ResultValueBet;

/**
 * The Interface IProcessValueBet.
 */
public interface IProcessValueBet extends
		ItemProcessor<RtMatch, ResultValueBet> {

}
