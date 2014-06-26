package com.comparadorad.bet.comparer.synchro.reader.processbookmaker.xml.resolver.bean;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Component;

import com.comparadorad.bet.comparer.model.config.bean.CfgBetTypeEvent.CfgBetTypeEventId;

@Component
public class BetTypeEventResolver {

	private final Map<CriteriaBetTypeEvent, CfgBetTypeEventId> resolver;
	
	public BetTypeEventResolver (){
		resolver = new HashMap<CriteriaBetTypeEvent, CfgBetTypeEventId>();
		resolver.put(new CriteriaBetTypeEvent("19","24","2"), CfgBetTypeEventId.PARTIDO_COMPLETO_PRORROGA);
	}

	public Map<CriteriaBetTypeEvent, CfgBetTypeEventId> getResolver() {
		return resolver;
	}
	
}
