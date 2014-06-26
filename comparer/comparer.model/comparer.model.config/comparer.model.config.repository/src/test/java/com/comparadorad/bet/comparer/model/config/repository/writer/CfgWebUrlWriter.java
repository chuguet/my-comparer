package com.comparadorad.bet.comparer.model.config.repository.writer;

import java.util.List;

import com.comparadorad.bet.comparer.model.config.bean.bmconf.CfgWebUrl;
import com.comparadorad.bet.comparer.model.core.repository.AbstractWriterXML;

public class CfgWebUrlWriter extends
AbstractWriterXML<List<CfgWebUrl>> {

	@Override
	protected boolean isExtended() {
		return false;
	}

	@Override
	protected List<CfgWebUrl> makeObject() {
		return null;
	}



}
