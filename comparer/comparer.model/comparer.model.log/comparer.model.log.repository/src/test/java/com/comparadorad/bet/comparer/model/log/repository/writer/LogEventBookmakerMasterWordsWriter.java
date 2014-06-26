package com.comparadorad.bet.comparer.model.log.repository.writer;

import java.util.ArrayList;
import java.util.List;

import com.comparadorad.bet.comparer.model.config.bean.CfgBookmaker;
import com.comparadorad.bet.comparer.model.core.repository.AbstractWriterXML;
import com.comparadorad.bet.comparer.model.log.bean.LogEvent.LogLevel;
import com.comparadorad.bet.comparer.model.log.bean.LogEvent.LogState;
import com.comparadorad.bet.comparer.model.log.bean.LogEventBookmaker;
import com.comparadorad.bet.comparer.model.log.bean.LogEventBookmakerMasterWords;
import com.comparadorad.bet.comparer.synchro.reader.model.XmlMatch;

public class LogEventBookmakerMasterWordsWriter extends
		AbstractWriterXML<List<LogEventBookmakerMasterWords>> {

	@Override
	protected boolean isExtended() {
		return false;
	}

	@Override
	protected List<LogEventBookmakerMasterWords> makeObject() {
		List<LogEventBookmakerMasterWords> lstLogXmlEvent = new ArrayList<LogEventBookmakerMasterWords>();
		LogEventBookmakerMasterWords logXmlEvent;
		XmlMatch xmlMatch;

		xmlMatch = new XmlMatch();
		xmlMatch.setName("Partido");
		logXmlEvent = new LogEventBookmakerMasterWords();
		logXmlEvent.setLogState(LogState.NEW);
		logXmlEvent.setBookmaker(new CfgBookmaker(
				CfgBookmaker.CfgBookmakerId.BETCLIC_COM_ID));
		logXmlEvent.setObjectId("1");
		logXmlEvent.setData(new String("data"));
		logXmlEvent.setLogLevel(LogLevel.WARN);
		logXmlEvent.setMessage("Message...");
		logXmlEvent.setProcessId("PROCES ID...");
		logXmlEvent.setData(xmlMatch);

		lstLogXmlEvent.add(logXmlEvent);

		return lstLogXmlEvent;
	}

}
