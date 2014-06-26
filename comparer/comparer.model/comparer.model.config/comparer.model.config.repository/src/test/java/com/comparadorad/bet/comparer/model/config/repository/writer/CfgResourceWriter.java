package com.comparadorad.bet.comparer.model.config.repository.writer;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

import com.comparadorad.bet.comparer.model.config.bean.CfgResource;
import com.comparadorad.bet.comparer.model.core.repository.AbstractWriterXML;

public class CfgResourceWriter extends
AbstractWriterXML<List<CfgResource>> {

	@Override
	protected boolean isExtended() {
		return false;
	}

	@Override
	protected List<CfgResource> makeObject() {
		CfgResource cfgResource;
		List<CfgResource> cfgResources = new ArrayList<CfgResource>();
		
		cfgResource = new CfgResource();
		cfgResource.setObjectId(BigInteger.ONE);
		cfgResource.setLocation("/image/flag.jpg");
		cfgResource.setName("Bandera de España");
		cfgResource.setHeight(120);
		cfgResource.setWidth(250);
		
		cfgResources.add(cfgResource);
		
		return cfgResources;
	}

}
