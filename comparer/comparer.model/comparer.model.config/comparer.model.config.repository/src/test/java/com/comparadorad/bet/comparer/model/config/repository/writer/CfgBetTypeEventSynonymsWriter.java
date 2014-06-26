package com.comparadorad.bet.comparer.model.config.repository.writer;

import java.util.ArrayList;
import java.util.List;

import com.comparadorad.bet.comparer.model.config.bean.CfgBetTypeEvent;
import com.comparadorad.bet.comparer.model.config.bean.CfgBetTypeEventSynonyms;
import com.comparadorad.bet.comparer.model.core.bean.CoreActiveElement;
import com.comparadorad.bet.comparer.model.core.repository.AbstractWriterXML;

public class CfgBetTypeEventSynonymsWriter extends
		AbstractWriterXML<List<CfgBetTypeEventSynonyms>> {

	@Override
	protected boolean isExtended() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	protected List<CfgBetTypeEventSynonyms> makeObject() {

		List<CfgBetTypeEventSynonyms> result = new ArrayList<CfgBetTypeEventSynonyms>();
		CfgBetTypeEventSynonyms event = new CfgBetTypeEventSynonyms();

		CfgBetTypeEvent betType = new CfgBetTypeEvent();
		betType.setObjectId("1");
		betType.setName("Handicap");
		event.setObjectId("1");
		event.setRelatedDocument(betType);
		event.setCoreActiveElement(new CoreActiveElement(Boolean.TRUE));
		event.addSynonimWord("Handicap");
		event.addSynonimWord("Handicap Result");
		result.add(event);
		return result;
	}

}
