package com.comparadorad.bet.comparer.model.config.repository;

import java.math.BigInteger;

import javax.inject.Inject;

import com.comparadorad.bet.comparer.model.config.bean.CfgResource;
import com.comparadorad.bet.comparer.model.repository.CfgResourceRepository;

public class CfgResourceRepositoryTest extends
AbstractConfigRepositoryTest<CfgResourceRepository> {
	
	
	@Inject
	private CfgResourceRepository resourceRepository;

	@Override
	public CfgResourceRepository getCrudRepository() {
		return resourceRepository;
	}

	@Override
	protected Object getNewElement() {
		CfgResource cfgResource = new CfgResource();
		cfgResource.setObjectId(BigInteger.ONE);
		cfgResource.setLocation("/image/flag.jpg");
		cfgResource.setName("Bandera de España");
		cfgResource.setHeight(120);
		cfgResource.setWidth(250);
		return cfgResource;
	}

}
